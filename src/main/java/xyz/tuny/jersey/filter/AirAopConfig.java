package xyz.tuny.jersey.filter;

import org.glassfish.jersey.server.ResourceConfig;
import xyz.tuny.jersey.filter.bing.AirNameBindingFilter;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("/aop/*")
public class AirAopConfig extends ResourceConfig {

    public AirAopConfig() {
        register(BookResource.class);
        register(AirNameBindingFilter.class);
    }

    public AirAopConfig(Class<BookResource> registerClass) {
        super(registerClass);
        register(AirNameBindingFilter.class);
    }
}