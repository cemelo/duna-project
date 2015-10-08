package io.duna.example.person.impl;

import io.duna.example.person.Person;

/**
 * Created by carlos on 24/09/15.
 */
public class PersonImpl implements Person {

    private Integer id;

    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
