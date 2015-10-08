package io.duna.example;

import io.duna.example.person.Person;
import io.duna.example.person.PersonJaxrsImpl;
import io.duna.example.person.PersonResource;
import io.duna.example.person.impl.PersonImpl;
import org.glassfish.hk2.api.ServiceLocator;
import org.glassfish.hk2.api.ServiceLocatorFactory;
import org.glassfish.hk2.utilities.ServiceLocatorUtilities;
import org.glassfish.jersey.ServiceLocatorProvider;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Configuration;
import javax.ws.rs.core.FeatureContext;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Map;

/**
 * Created by carlos on 07/10/15.
 */
@Path("/")
public class EntryPointJaxrsImpl {

    @Inject
    PersonJaxrsImpl impl;

    @Inject
    PersonResource resource;

//    @Inject
//    ServiceLocator serviceLocator;

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Person get() {
        Person p = new PersonImpl();
        p.setName("asd");
        ((PersonImpl) p).setId(1);
        return p;
    }

    @GET
    @Path("/persons")
    public List<Person> getPersonList() {
        return resource.getPersonList();
    }
}
