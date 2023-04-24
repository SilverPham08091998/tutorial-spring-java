package com.example.springjava.service;

import com.example.springjava.model.Person;

import java.util.List;

public interface DemoService {
    public List<Person> getAllPerson();
    public void addPerson(Person person);

    public void deletePerson(int id);
}
