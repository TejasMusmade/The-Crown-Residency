package com.app.entities;

import java.util.List;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
@Table(name="facilty")
public class Facility extends BaseEntity {
	@Column
	private String title;
	@Column
	private String description;
	
	@ManyToMany
	@JoinTable(name = "room_facility",joinColumns = @JoinColumn(name = "facility_id",nullable=false),inverseJoinColumns = @JoinColumn(name = "room_id",nullable=false))
	private List<Rooms>rooms ;
}
