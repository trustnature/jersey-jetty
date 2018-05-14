package xyz.tuny.jersey.client;

import org.junit.Test;
import xyz.tuny.jersey.client.common.BasicTest;

public class TestApacheClient extends BasicTest {
    @Test
    public void testTalk() {
        final Jaxrs2Client one = new ApacheClient();
        one.test();
    }
}
