package xyz.tuny.jersey;

import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.glassfish.jersey.test.TestProperties;
import org.junit.Assert;
import org.junit.Test;
import xyz.tuny.jersey.media.json.JSONResource;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;

public class JSONTest extends JerseyTest {
    private static final Logger LOGGER = Logger.getLogger(JSONTest.class);
    final String path = "json-resource";
    @Override
    protected Application configure() {
        enable(TestProperties.LOG_TRAFFIC);
        enable(TestProperties.DUMP_ENTITY);
        return new ResourceConfig(JSONResource.class);
    }
    //http://127.0.0.1:8080/rest/json-resource
    @Test
    public void testJSONObject() {
        final Invocation.Builder request = target(path).request();
        LOGGER.debug("JSON");
        handleResult(request);
    }

    private void handleResult(final Invocation.Builder request) {
        JSONObject req = new JSONObject();
        try {
            req.put("query", "name");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        final String  resp = request.post(Entity.entity(req.toString(), MediaType.APPLICATION_JSON), String.class);
        Assert.assertNotNull(resp);
    }


}
