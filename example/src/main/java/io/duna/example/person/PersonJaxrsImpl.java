package io.duna.example.person;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;

/**
 * Created by carlos on 29/09/15.
 */
@Path("/person")
public class PersonJaxrsImpl {

    PersonResource resource;

    @GET
    public void getPersonList(@Suspended final AsyncResponse response) {
        Thread t = new Thread() {
            @Override
            public void run() {
                response.resume("Nothing");
            }
        };
        t.start();
    }

    @GET
    @Path("/test")
    public String x() {
        return "asdasd";
    }
}
