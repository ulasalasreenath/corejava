package org.speakingcs.hibernate.entities;

import javax.persistence.*;

@Entity
@Table(name="employee")
public class Employee2 {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private long id;
	
	@Column(name = "name")
	private String name;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "employee_detail",
	joinColumns = @JoinColumn(name = "employee_id"),
	inverseJoinColumns = @JoinColumn(name = "detail_id"))
	
	private Detail employeeDetail;
	
	//setters && getters
}
