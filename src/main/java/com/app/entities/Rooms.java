package com.app.entities;

import java.util.List;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Entity
@Table(name="rooms")
public class Rooms extends BaseEntity{
	
	@Column(name = "bed_count")
	private int bedCount;
	@Column(name = "adult_count")
	private int adultCount;
	@Column(name = "child_count")
	private int childCount;
	@Column
	private int price;
	@Column
	private String image;
	@Column
	private String description;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id", nullable = false)
	private RoomCategory roomCategory;
	
	@ManyToMany(mappedBy="rooms")
	private List<Facility> facilities;
	
	@OneToMany(mappedBy = "room",cascade=CascadeType.ALL,orphanRemoval = true)
	private List<Booking> bookingList;
}
