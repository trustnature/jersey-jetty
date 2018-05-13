package xyz.tuny.jersey.media.xml;

import org.apache.log4j.Logger;
import xyz.tuny.jersey.domain.Book;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("xml-resource")
public class XMLResource {
    private static final Logger LOGGER = Logger.getLogger(XMLResource.class);

    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces(MediaType.APPLICATION_XML)
    public Book getEntity(Book book) {
        LOGGER.debug(book.getBookName());
        return book;
    }
}
