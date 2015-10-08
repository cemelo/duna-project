package io.duna.server;

import org.glassfish.hk2.api.ServiceLocator;
import org.glassfish.hk2.utilities.ServiceLocatorUtilities;
import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;

/**
 * Created by carlos on 29/09/15.
 */
@ApplicationPath("/")
public class Application extends ResourceConfig {

    public Application() {
        packages(true, "io.duna");
        ServiceLocator locator = ServiceLocatorUtilities.createAndPopulateServiceLocator();
    }
}
