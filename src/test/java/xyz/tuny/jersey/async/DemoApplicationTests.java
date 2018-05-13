package xyz.tuny.jersey.async;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Assert;
import org.junit.Test;
import xyz.tuny.jersey.async.domain.Books;
import xyz.tuny.jersey.async.web.AsyncResource;
import xyz.tuny.jersey.filter.AirAopConfig;

import javax.ws.rs.client.AsyncInvoker;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.Application;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * 测试过滤器的名称绑定机制
 */
public class DemoApplicationTests extends JerseyTest {
    private static final Logger log = LogManager.getLogger(DemoApplicationTests.class);
    private static final String BASE_URI = "books/";

    @Override
    protected Application configure() {
        return new AsyncConfig();
    }

    @Test
    public void testAsync() throws InterruptedException, ExecutionException {
        final Invocation.Builder request = target(BASE_URI).request();
        final AsyncInvoker async = request.async();
        final Future<Books> responseFuture = async.get(Books.class);
        long beginTime = System.currentTimeMillis();
        try {
            Books result = responseFuture.get(AsyncResource.TIMEOUT + 1, TimeUnit.SECONDS);
            log.debug("Testing result size = {}"+(result.getBookList().size()));
        } catch (TimeoutException e) {
            log.debug("Fail to request asynchronously", e);
        } finally {
            log.debug("Elapsed time = {}" + (System.currentTimeMillis() - beginTime));
        }
    }

}
