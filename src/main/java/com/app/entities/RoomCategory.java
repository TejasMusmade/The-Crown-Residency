package com.app.entities;

import java.util.List;

import javax.persistence.*;
import lombok.*;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name="room_category")
public class RoomCategory extends BaseEntity {
	@Column
	private String title;
	@Column
	private String description;
	@OneToMany(mappedBy = "roomCategory",cascade=CascadeType.ALL,orphanRemoval = true)
	private List<Rooms> roomsList;
}
