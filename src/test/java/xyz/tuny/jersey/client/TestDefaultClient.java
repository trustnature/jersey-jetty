package xyz.tuny.jersey.client;


import org.junit.Test;
import xyz.tuny.jersey.client.common.BasicTest;

public class TestDefaultClient extends BasicTest {

    @Test
    public void testTalk() {
        final Jaxrs2Client one = new DefaultClient();
        one.test();
    }
    

}
