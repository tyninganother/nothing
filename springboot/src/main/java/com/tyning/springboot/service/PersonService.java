package com.tyning.springboot.service;

import com.tyning.springboot.model.Person;

import java.util.List;

public interface PersonService {

    Long save();

    Long update();

    Long delete();

    Person selectById(Long id);

    List<Person> selectAll();

    Boolean transaction();
}
