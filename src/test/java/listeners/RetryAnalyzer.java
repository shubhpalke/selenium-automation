package listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.SkipException;

public class RetryAnalyzer implements IRetryAnalyzer {

    private int retryCount = 0;
    private static final int MAX_RETRY = 3;

    @Override
    public boolean retry(ITestResult result) {
        return retryCount++ < MAX_RETRY;
    }
}
