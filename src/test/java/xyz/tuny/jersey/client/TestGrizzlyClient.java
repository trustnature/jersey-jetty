package xyz.tuny.jersey.client;

import org.junit.Test;
import xyz.tuny.jersey.client.common.BasicTest;

public class TestGrizzlyClient extends BasicTest {

    @Test
    public void testTalk() {
        final Jaxrs2Client one = new GrizzlyClient();
        one.test();
    }
}
