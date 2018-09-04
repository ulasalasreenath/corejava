package com.speakingcs.hibernate.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "movie")
public class Movie {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private long id;
	
	@Column(name = "name")
	private String name;
	
	@OneToMany(mappedBy = "movie")
	private Set<Actor> actors;
}
