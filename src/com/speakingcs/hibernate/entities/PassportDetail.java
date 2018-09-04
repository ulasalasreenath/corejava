package com.speakingcs.hibernate.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "passort_detail")
public class PassportDetail {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private long id;

	@Column(name = "passportno")
	private String passportNo;

	@OneToOne(mappedBy = "passportDetail", cascade = CascadeType.ALL)
	private Person person;

}
