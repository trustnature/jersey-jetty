package xyz.tuny.jersey.client.resource;

import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("/client/*")
public class AirResourceConfig extends ResourceConfig {

    public AirResourceConfig() {
        packages("xyz.tuny.jersey.client");
    }
}