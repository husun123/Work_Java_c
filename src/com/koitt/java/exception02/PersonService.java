package com.koitt.java.exception02;

import java.util.List;

public class PersonService {

	private PersonDao dao;
	
	public PersonService() {
		this.dao = new PersonDao();
	}
	
	public void add(Person p) {
		dao.insert(p);
	}
	
	public List<Person> read(){
		return dao.selectAll();
	}
	
	
}
