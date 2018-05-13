package xyz.tuny.jersey.filter;

import org.apache.log4j.Logger;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Assert;
import org.junit.Test;
import xyz.tuny.jersey.filter.log.AirLogFilter;
import xyz.tuny.jersey.json.domain.Books;
import xyz.tuny.jersey.json.resource.BookResource;

import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.Application;

/**
 * 测试 4种过滤器
 */
public class TIResourceJtfTest extends JerseyTest {
    private static final Logger LOGGER = Logger.getLogger(TIResourceJtfTest.class);
    private static final String BASEURI = "books/";

    @Override
    protected Application configure() {
        ResourceConfig config = new ResourceConfig(BookResource.class);
        return config.register(xyz.tuny.jersey.filter.log.AirLogFilter.class);
    }

    @Override
    protected void configureClient(ClientConfig config) {
        config.register(new AirLogFilter());
    }

    @Test
    public void testGetAll() {
        TIResourceJtfTest.LOGGER.debug(">>Test Get All");
        final Invocation.Builder invocationBuilder = target(TIResourceJtfTest.BASEURI).request();
        final Books result = invocationBuilder.get(Books.class);
        TIResourceJtfTest.LOGGER.debug(result.getBookList());
        Assert.assertNotNull(result.getBookList());
        TIResourceJtfTest.LOGGER.debug("<<Test Get All");
    }
}
