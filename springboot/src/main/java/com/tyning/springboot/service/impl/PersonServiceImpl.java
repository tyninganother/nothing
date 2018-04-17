package com.tyning.springboot.service.impl;

import com.tyning.springboot.manager.PersonMapper;
import com.tyning.springboot.model.Person;
import com.tyning.springboot.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author haining
 */
@Service
public class PersonServiceImpl implements PersonService {

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private PersonMapper personMapper;

    @Override
    public Long save() {
        Person personDO = new Person();
        personDO.setName("张三");
        personDO.setAge(18);
        personMapper.insert(personDO);
        return personDO.getId();
    }

    @Override
    public Long update() {
        Person personDO = new Person();
        personDO.setId(2L);
        personDO.setName("旺旺");
        personDO.setAge(12);
        return personMapper.update(personDO);
    }

    @Override
    public Long delete() {
        return personMapper.delete(1L);
    }

    @Override
    public Person selectById(Long id) {
        return personMapper.selectById(id);
    }

    @Override
    public List<Person> selectAll() {
        return personMapper.selectAll();
    }

    @Override
    @Transactional
    public Boolean transaction() {
        delete();
        save();
        return true;
    }
}
