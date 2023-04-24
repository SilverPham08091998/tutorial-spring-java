package com.example.springjava.service.Impl;

import com.example.springjava.model.Person;
import com.example.springjava.respository.DemoRepository;
import com.example.springjava.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class DemoServiceImpl implements DemoService {

    @Autowired
    DemoRepository demoRepository;
    @Override
    public List<Person> getAllPerson() {
        return demoRepository.getAllPerson() ;
    }

    @Override
    public void addPerson(Person person) {
        demoRepository.addPerson(person);
    }
}
