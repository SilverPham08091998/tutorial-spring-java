package com.example.springjava.respository;

import com.example.springjava.model.Person;

import java.util.List;

public interface DemoRepository {
    public List<Person> getAllPerson();
    public  void  addPerson(Person person);

    public  void  deletePerson(int id);
}
