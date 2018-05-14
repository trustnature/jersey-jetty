package xyz.tuny.jersey.client;

import org.junit.Test;
import xyz.tuny.jersey.client.common.BasicTest;
import xyz.tuny.jersey.client.common.PerformanceLog;

public class TestPoolingClient extends BasicTest {

    @Test
    public void testTalk() {
        final Jaxrs2Client one = new PoolingClient();
        one.test();
    }

    //@Test
    public void testPerformance() throws InterruptedException {
        int n = 0;
        final int times = 1000;
        while (n < times) {
            final Jaxrs2Client one = new PoolingClient();
            one.test();
            Thread.currentThread();
            Thread.sleep(100);
            if (n++ % 10 == 0) {
                System.out.println(n + ": " + PerformanceLog.getMemory());
            }
        }
    }
}
