package xyz.tuny.jersey.client.common;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import org.junit.After;
import org.junit.Before;
import xyz.tuny.jersey.client.Jaxrs2Client;

import javax.ws.rs.core.UriBuilder;
import java.net.URI;

public class BasicTest {
    HttpServer server;

    @Before
    public void begin() {
        final ResourceConfig resourceConfig = new ResourceConfig();
        final ResourceConfig rc = resourceConfig.packages("xyz.tuny.jersey.client");
        final URI uri = UriBuilder.fromUri(Jaxrs2Client.BASE_URI).port(9527).build();
        server = GrizzlyHttpServerFactory.createHttpServer(uri, rc);
    }

    @After
    public void end() {
        if (server != null) {
            server.shutdown();
        }
    }
}
