package com.speakingcs.hibernate.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "technology")
public class Technology {
	@Id
	@Column(name = "id")
	@GeneratedValue
	private long id;
	
	@Column(name = "language")
	private String language;
	
	@Column(name = "expertise")
	private String expertise;
	
	@ManyToMany(mappedBy = "technology")
	private Set<Developer> developer;
}
