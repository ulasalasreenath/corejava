package com.speakingcs.hibernate.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "passport_detail")
public class PassportDetail1 {

	@Id
	@GeneratedValue
	private long id;
	
	@Column(name = "passportno")
	private String passportNo;
	
	@OneToOne (cascade = CascadeType.ALL, 
			mappedBy = "passportDetail")
	private Person person;
	
	
}
