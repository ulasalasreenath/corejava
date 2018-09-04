package com.speakingcs.hibernate.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "employee", uniqueConstraints = @UniqueConstraint(columnNames = { "id", "name" }))
public class Employee {

	@Id
	@GeneratedValue
	private long id;

	@Column(name = "name", unique=true, nullable = false)
	private String name;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/*
	 * public String toString() { //return "Employee: " + "\n\t Id: " + this.id
	 * + "\n\t Name: " + this.name; }
	 */

}
