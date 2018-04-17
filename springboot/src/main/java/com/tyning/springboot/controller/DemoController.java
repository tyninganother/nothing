package com.tyning.springboot.controller;

import com.tyning.springboot.model.Person;
import com.tyning.springboot.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author haining
 */
@RestController
public class DemoController {

    @Autowired
    private PersonService personService;

    @RequestMapping("/save")
    public Long save() {
        return personService.save();
    }

    @RequestMapping("/update")
    public Long update() {
        return personService.update();
    }

    @RequestMapping("/delete")
    public Long delete() {
        return personService.delete();
    }

    @RequestMapping("/selectById")
    public Person selectById(@RequestParam Long id) {
        return personService.selectById(id);
    }

    @RequestMapping("/selectAll")
    public List<Person> selectAll() {
        return personService.selectAll();
    }

    @RequestMapping("/transaction")
    @Transactional
    public Boolean transaction() {
        return personService.transaction();
    }
}
