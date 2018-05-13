package xyz.tuny.jersey;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Assert;
import xyz.tuny.jersey.annotation.method.EBookResource;
import xyz.tuny.jersey.domain.Book;

import java.util.concurrent.atomic.AtomicLong;

public class MethodTest extends JerseyTest {
    private final static Logger LOGGER = Logger.getLogger(MethodTest.class);
    public static AtomicLong clientBookSequence = new AtomicLong();
    @Override
    protected Application configure() {
        return new ResourceConfig(EBookResource.class);
    }

    @org.junit.Test
    public void testGet() {
        Response response = target("book").request().get();
        System.out.println(response.readEntity(String.class));
    }

    @org.junit.Test
    public void PutTest(){
        final Book newBook = new Book(clientBookSequence.incrementAndGet(),"book-" + System.nanoTime());
        MediaType contentTypeMediaType = MediaType.APPLICATION_XML_TYPE;
        MediaType acceptMediaType = MediaType.TEXT_PLAIN_TYPE;
        final Entity<Book> bookEntity = Entity.entity(newBook, contentTypeMediaType);
        final String lastUpdate = target("book").request(acceptMediaType).put(bookEntity,String.class);
        Assert.assertNotNull(lastUpdate);
        LOGGER.debug(lastUpdate);
    }

    @org.junit.Test
    public void delTest(){
        final Response response = target("book").queryParam("bookId","9527").request().delete();
        int status = response.getStatus();
        LOGGER.debug(status);
        Assert.assertEquals(Response.Status.NO_CONTENT.getStatusCode(),status);
    }

    @org.junit.Test
    public void postTest(){
        final Book newBook = new Book("book-" + System.nanoTime());
        MediaType contentTypeMediaType = MediaType.APPLICATION_XML_TYPE;
        MediaType acceptMediaType = MediaType.APPLICATION_XML_TYPE;
        final Entity<Book> bookEntity = Entity.entity(newBook,contentTypeMediaType);
        final Book book = target("book").request(acceptMediaType).post(bookEntity, Book.class);
        Assert.assertNotNull(book.getBookId());
        LOGGER.debug("Server ID=" + book.getBookId());
    }
}
