package com.fontend.api.test.model;

public class Person {
	
	private Integer id;
	private Integer age;
	private String name;

	public Person(Integer age, String name) {
		this.age = age;
		this.name = name;
	}

	public Person() {
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
