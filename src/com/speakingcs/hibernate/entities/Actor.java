package com.speakingcs.hibernate.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "actor")
public class Actor {
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private long id;
	
	@ManyToOne
	@JoinColumn(name = "movie_id")
	private Movie movie;
}
