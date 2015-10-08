package io.duna.example.person.impl;

import io.duna.example.person.Person;
import io.duna.example.person.PersonResource;
import org.jvnet.hk2.annotations.Service;

import java.util.Collections;
import java.util.List;

/**
 * Created by carlos on 24/09/15.
 */
@Service
public class PersonResourceImpl implements PersonResource {

    public List<Person> getPersonList() {
        return Collections.emptyList();
    }
}
