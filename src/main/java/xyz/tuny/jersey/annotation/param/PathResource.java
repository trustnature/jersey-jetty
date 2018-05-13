package xyz.tuny.jersey.annotation.param;

import org.apache.log4j.Logger;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("path-resource")
public class PathResource {
    private static final Logger LOGGER = Logger.getLogger(PathResource.class);


    @GET
    /*[a-zA-Z0-9] is equivalent to \w*/
    @Path("{user: [a-zA-Z][a-zA-Z_0-9]*}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getUserInfo(@PathParam("user") final String user, @DefaultValue("Shen Yang") @QueryParam("hometown") final String hometown) {
        return user + ":" + hometown;
    }
}
