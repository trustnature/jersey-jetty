package xyz.tuny.jersey;

import org.apache.log4j.Logger;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.glassfish.jersey.test.TestProperties;
import org.junit.Assert;
import org.junit.Test;
import xyz.tuny.jersey.domain.Book;
import xyz.tuny.jersey.media.xml.XMLResource;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;

public class XMLTest extends JerseyTest {
    private static final Logger LOGGER = Logger.getLogger(XMLTest.class);
    final String path = "xml-resource";
    Book book = new Book(100L, "TEST BOOK");
    @Override
    protected Application configure() {
        enable(TestProperties.LOG_TRAFFIC);
        enable(TestProperties.DUMP_ENTITY);
        return new ResourceConfig(XMLResource.class);
    }

    //http://127.0.0.1:8080/rest/xml-resource
    @Test
    public void testJAXB() {
        final Invocation.Builder request = target(path).request();
        LOGGER.debug("JAXB");
        handleResult(request);
    }

    private void handleResult(final Invocation.Builder request) {
        final Book result = request.post(Entity.entity(book, MediaType.APPLICATION_XML), Book.class);
        Assert.assertNotNull(result);
    }
}
