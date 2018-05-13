package xyz.tuny.jersey.async;

import org.glassfish.jersey.server.ResourceConfig;
import xyz.tuny.jersey.async.web.AsyncResource;
import xyz.tuny.jersey.filter.BookResource;
import xyz.tuny.jersey.filter.bing.AirNameBindingFilter;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("/books/*")
public class AsyncConfig extends ResourceConfig {

    public AsyncConfig() {
        register(AsyncResource.class);
    }

}