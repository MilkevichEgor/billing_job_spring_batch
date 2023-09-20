package example.billingjob;

import org.springframework.retry.RetryCallback;
import org.springframework.retry.RetryContext;
import org.springframework.retry.RetryListener;

public class BillingRetryListener implements RetryListener {

    private int retryCount = 0;

    @Override
    public <T, E extends Throwable> boolean open(RetryContext context, RetryCallback<T, E> callback) {
        retryCount++;
        return true;
    }

//    @Override
//    public <T, E extends Throwable> void close(RetryContext context, RetryCallback<T, E> callback, Throwable throwable) {
//
//        S
//    }

    public int getRetryCount() {
        return retryCount;
    }

}
