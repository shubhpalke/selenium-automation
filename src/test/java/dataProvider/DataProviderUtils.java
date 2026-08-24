package dataProvider;

import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DataProviderUtils {

    private DataProviderUtils() {
    }

    @DataProvider(name = "testData")
    public static Object[][] getData(Method method) {

        String testClassName = method.getDeclaringClass().getSimpleName();

        List<Map<String, String>> data =
                ExcelUtils.getTestData("Test Data", testClassName);

        Object[][] result = new Object[data.size()][1];
        for (int i = 0; i < data.size(); i++) {
            result[i][0] = data.get(i);
        }
        return result;
    }
}
