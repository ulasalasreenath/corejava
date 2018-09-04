package com.speakingcs.hibernate.entities;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Employee1 {

	@Id
	@GeneratedValue
	@Column(name="id")
	private long id;
	
	@Column(name="name")
	private String name;
	
	@ElementCollection(fetch=FetchType.LAZY)
	@CollectionTable(name="email")
		private List<String> emails;
}
