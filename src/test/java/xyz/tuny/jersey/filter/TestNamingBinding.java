package xyz.tuny.jersey.filter;


import org.glassfish.jersey.test.JerseyTest;
import org.junit.Assert;
import org.junit.Test;
import xyz.tuny.jersey.filter.domain.Book;
import xyz.tuny.jersey.filter.domain.Books;

import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;

/**
 * 测试过滤器的名称绑定机制
 */
public class TestNamingBinding extends JerseyTest {
    private static final String BASE_URI = "books/";

    @Override
    protected Application configure() {
        return new AirAopConfig();
    }

    @Test
    public void testPathGetJSON() {
        final WebTarget pathTarget = target(BASE_URI).path("1");
        final Invocation.Builder invocationBuilder = pathTarget.request(MediaType.APPLICATION_JSON_TYPE);
        final Book result = invocationBuilder.get(Book.class);
        Assert.assertNotNull(result.getBookId());
    }

    @Test
    public void testGetAll() {
        final Invocation.Builder invocationBuilder = target(BASE_URI).request();
        final Books result = invocationBuilder.get(Books.class);
        Assert.assertNotNull(result.getBookList());
    }
}
