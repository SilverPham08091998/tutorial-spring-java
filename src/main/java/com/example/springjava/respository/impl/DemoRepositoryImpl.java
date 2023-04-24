package com.example.springjava.respository.impl;

import com.example.springjava.model.Person;
import com.example.springjava.respository.DemoRepository;
import com.zaxxer.hikari.pool.HikariProxyCallableStatement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Transactional
@Repository
public class DemoRepositoryImpl implements DemoRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    public List<Person> getAllPerson() {
        String sql ="SELECT * FROM DEMO";
        return jdbcTemplate.query(sql, new RowMapper<Person>() {
            @Override
            public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
                Person person = new Person();
                person.setId(rs.getInt("ID"));
                person.setAge(rs.getInt("AGE"));
                person.setFullName(rs.getString("NAME"));
                return person;
            }
        });
    }

    @Override
    public void addPerson(Person person) {
        String sql = "INSERT INTO DEMO(ID,NAME,AGE) VALUES ('"+ person.getId()+"','"+person.getFullName()+"','"+person.getAge()+"')";
        jdbcTemplate.execute(sql);
    }
}
