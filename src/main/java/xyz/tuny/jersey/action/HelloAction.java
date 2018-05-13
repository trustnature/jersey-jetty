package xyz.tuny.jersey.action;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("hello")
public class HelloAction {

    @GET
    @Produces("text/plain")
    public String getHello() {
        return "hello word...";
    }

    @GET
    @Path("{name}")
    @Produces(MediaType.TEXT_PLAIN)
    //访问路径 /hello/world
    public String hello(@PathParam("name") String name) throws Exception {
        return "hello ! "+name;
    }
}
