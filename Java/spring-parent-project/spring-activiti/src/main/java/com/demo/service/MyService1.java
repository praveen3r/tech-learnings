package com.demo.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.entity.Person;
import com.demo.repository.PersonRepository;

@Service
@Transactional
public class MyService1 {

	@Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private PersonRepository personRepository;

    public void startProcess(String assignee) {

        Person person = personRepository.findByUsername(assignee);

        Map<String, Object> variables = new HashMap<String, Object>();
        variables.put("person", person);
        runtimeService.startProcessInstanceByKey("oneTaskProcess", variables);
    }

    public List<Task> getTasks(String assignee) {
		
		  TaskQuery query = taskService.createTaskQuery().taskAssignee(assignee);
		  return query.list();
		 
    	//return taskService.createTaskQuery().list();
    }

    public void createDemoUsers() {
		 if (personRepository.findAll().size() == 0) {
            personRepository.save(new Person(1l, "jbarrez", "Joram", "Barrez", new Date()));
            personRepository.save(new Person(2l, "trademakers", "Tijs", "Rademakers", new Date()));
        }
    }

}
