package com.crown.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crown.entities.RoomCategory;
import com.crown.entities.Rooms;

public interface IRoomsCategoryDao extends JpaRepository<RoomCategory, Integer>{

	RoomCategory findBycategoryId(int id);
	

}
