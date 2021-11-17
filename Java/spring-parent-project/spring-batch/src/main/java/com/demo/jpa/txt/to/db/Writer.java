package com.demo.jpa.txt.to.db;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.demo.entity.EmployeeEntity;
import com.demo.repository.EmployeeRepository;

/*@Component
public class Writer implements ItemWriter<EmployeeEntity>{

	@Autowired
	private EmployeeRepository repo;

	@Override
	@Transactional
	public void write(List<? extends EmployeeEntity> employees) throws Exception {
		repo.saveAll(employees);
	}
}*/
