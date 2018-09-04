package com.speakingcs.hibernate.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "detail")
public class Detail {

	@Id
	@GeneratedValue
	@Column(name = "detail_id")
	private long id;
	
	@Column(name = "city")
	private String city;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinTable(name = "employee_detail",
	joinColumns = @JoinColumn(name = "detail_id"),
	inverseJoinColumns = @JoinColumn(name = "employee_id"))
	private Employee2 employee;
	
	// getters && setters
}
