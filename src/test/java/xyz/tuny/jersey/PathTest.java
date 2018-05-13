package xyz.tuny.jersey;

import org.apache.log4j.Logger;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.glassfish.jersey.test.TestProperties;
import org.junit.Assert;
import org.junit.Test;
import xyz.tuny.jersey.annotation.param.PathResource;

import javax.ws.rs.core.Application;

public class PathTest extends JerseyTest {
    private static final Logger LOGGER = Logger.getLogger(PathTest.class);
    private static final String path = "path-resource";
    @Override
    protected Application configure() {
        enable(TestProperties.LOG_TRAFFIC);
        enable(TestProperties.DUMP_ENTITY);
        return new ResourceConfig(PathResource.class);
    }

    @Test
    public void testBasic() {
        String result;
        /*http://localhost:9998/path-resource/Eric*/
        result = target(path).path("Eric").request().get().readEntity(String.class);
        Assert.assertEquals("Eric:Shen Yang", result);

        /*http://localhost:9998/path-resource/Eric?hometown=Buenos Aires*/
        /*http://localhost:9998/path-resource/Eric?hometown=Buenos+Aires*/
        result = target(path).path("Eric").queryParam("hometown", "Buenos Aires").request().get().readEntity(String.class);
        Assert.assertEquals("Eric:Buenos Aires", result);
    }



}
