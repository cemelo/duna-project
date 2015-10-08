package io.duna.inject;

import org.glassfish.hk2.api.ServiceLocator;
import org.glassfish.jersey.ServiceLocatorProvider;

import javax.ws.rs.core.Feature;
import javax.ws.rs.core.FeatureContext;

/**
 * Created by carlos on 08/10/15.
 */
public class ProxyInjectionFeature implements Feature {

    @Override
    public boolean configure(FeatureContext context) {
        ServiceLocator serviceLocator = ServiceLocatorProvider.getServiceLocator(context);

        return false;
    }
}
