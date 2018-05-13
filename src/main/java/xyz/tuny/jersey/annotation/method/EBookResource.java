package xyz.tuny.jersey.annotation.method;

import org.apache.log4j.Logger;
import xyz.tuny.jersey.domain.Book;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

@Path("book")
public class EBookResource {
    private final static Logger LOGGER = Logger.getLogger(EBookResource.class);
    public static AtomicLong serverBookSequence = new AtomicLong();

    @GET
    public String getWeight(){
        System.out.println("==receiving get req ==");
        return "150M";
    }

    @PUT
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_XML)
    public String newBook(Book book) {
        System.out.println("==receiving pub req ==");
        SimpleDateFormat f = new SimpleDateFormat("d MMM yyyy HH:mm:ss");
        Date lastUpdate = Calendar.getInstance().getTime();
        LOGGER.debug(book.getBookId());
        return f.format(lastUpdate);
    }

    @DELETE
    public void delete(long bookId) {
        System.out.println("==receiving delete req ==");
        LOGGER.debug(bookId);
    }

    @POST
    @Produces(MediaType.APPLICATION_XML)
    @Consumes(MediaType.APPLICATION_XML)
    public Book createBook(Book book) {
        System.out.println("==receiving post req == ");
        book.setBookId(serverBookSequence.incrementAndGet());
        return book;
    }
}
