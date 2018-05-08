package xyz.tner.jersey;

import org.glassfish.jersey.server.ResourceConfig;

public class RESTApplication extends ResourceConfig {
    public RESTApplication() {
        //给出要扫描的包,也就是上面heloword所在的包,扫描多个包使用分号隔开
        packages("xyz.tner.jersey.action");
    }
}
