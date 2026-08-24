package dataProvider;

import org.apache.poi.ss.usermodel.*;
import utils.ConfigReader;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExcelUtils {

    private ExcelUtils() {}

    public static List<Map<String, String>> getTestData(
            String sheetName,
            String testClassName
    ) {

        List<Map<String, String>> result = new ArrayList<>();

        try (
                FileInputStream fis = new FileInputStream(
                        "src/test/resources/testdata/" + ConfigReader.get("inputExcel"));
                Workbook workbook = WorkbookFactory.create(fis)
        ) {

            Sheet sheet = workbook.getSheet(sheetName);
            int lastRow = sheet.getLastRowNum();

            for (int i = 0; i <= lastRow; i++) {

                Row headerRow = sheet.getRow(i);
                if (headerRow == null) continue;

                Cell firstCell = headerRow.getCell(0);
                if (firstCell == null) continue;

                //Detect header row
                if (!"ClassName".equalsIgnoreCase(firstCell.getStringCellValue())) {
                    continue;
                }

                //Next row should contain class name
                Row dataRow = sheet.getRow(i + 1);
                if (dataRow == null) continue;

                String className =
                        dataRow.getCell(0).getStringCellValue();

                if (!className.equalsIgnoreCase(testClassName)) {
                    continue;
                }

                //We found matching block
                int colCount = headerRow.getLastCellNum();

                Map<String, String> dataMap = new HashMap<>();
                for (int col = 0; col < colCount; col++) {

                    String key = headerRow.getCell(col).getStringCellValue();
                    Cell cell = dataRow.getCell(col);

                    String value = (cell == null) ? "" : cell.toString().trim();
                    dataMap.put(key, value);
                }

                result.add(dataMap);
                break; //only one block per test class
            }

        } catch (Exception e) {
            throw new RuntimeException("Failed to read Excel data", e);
        }

        return result;
    }
}
