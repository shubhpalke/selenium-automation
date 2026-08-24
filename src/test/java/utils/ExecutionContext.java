package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ExecutionContext {

    private static final String RUN_ID;

    static {
        RUN_ID = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss")
                .format(new Date());
    }

    private ExecutionContext() {}

    public static String getRunId() {
        return RUN_ID;
    }

    public static String getReportBasePath() {
        return System.getProperty("user.dir")
                + "/reports/Run_" + RUN_ID;
    }

}
