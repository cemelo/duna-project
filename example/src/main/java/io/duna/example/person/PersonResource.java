package io.duna.example.person;

import org.jvnet.hk2.annotations.Contract;

import java.util.List;

/**
 * Created by carlos on 24/09/15.
 */
@Contract
public interface PersonResource {

    List<Person> getPersonList();
}
