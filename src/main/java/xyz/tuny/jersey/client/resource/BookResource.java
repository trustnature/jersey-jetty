package xyz.tuny.jersey.client.resource;

import org.apache.log4j.Logger;
import xyz.tuny.jersey.filter.domain.Book;
import xyz.tuny.jersey.filter.domain.Books;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import java.util.ArrayList;
import java.util.List;

@Path("books")
public class BookResource {
    private static final Logger LOGGER = Logger.getLogger(BookResource.class);

    @Context
    UriInfo uriInfo;

    @GET
    @Produces({ MediaType.APPLICATION_XML })
    public Books getBooks() {
        final Books books = new Books();
        final List<Book> bookList = new ArrayList<>();
        for (long i = 0; i < 50000; i++) {
            final Book book = new Book(i, "" + i);
            bookList.add(book);
        }
        books.setBookList(bookList);
        return books;
    }

    @GET
    @Path("book")
    @Produces({ MediaType.APPLICATION_XML })
    public Book getBookByPath(@QueryParam("bookId") final Long bookId) {
        final Book book = new Book(bookId);
        BookResource.LOGGER.debug(book);
        final List<Object> matchedResources = uriInfo.getMatchedResources();
        for (final Object matchedResource : matchedResources) {
            BookResource.LOGGER.debug(matchedResource.getClass());
        }
        BookResource.LOGGER.debug(uriInfo.getAbsolutePath());
        return book;
    }
}
