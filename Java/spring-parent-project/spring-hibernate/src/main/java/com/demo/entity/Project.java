package com.demo.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Project")
public class Project {

	@Id
	@GeneratedValue
	@Column(name = "ID", unique = true, nullable = false)
	private Integer id;

	@Column(name = "TITLE")
	private String title;
	
	@ManyToMany(mappedBy = "projects")
    private Set<EmployeeResource> employees = new HashSet<>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Set<EmployeeResource> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<EmployeeResource> employees) {
		this.employees = employees;
	}
	
	
}
