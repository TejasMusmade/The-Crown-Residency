package com.crown.services;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crown.daos.IRoomsCategoryDao;
import com.crown.daos.IRoomsDao;
import com.crown.dtos.DtoEntityConverter;
import com.crown.dtos.FacilityDto;
import com.crown.dtos.RoomsCategoryDto;
import com.crown.entities.Facility;
import com.crown.entities.RoomCategory;
import com.crown.entities.Rooms;

@Transactional
@Service
public class RoomCategoryServices {

	
	@Autowired
	private IRoomsCategoryDao roomsCategoryDao;
	
	@Autowired
	private DtoEntityConverter converter;
	
	
	public RoomsCategoryDto findRoomsCategoryById(int id) {
		RoomCategory roomCategory=null;
		RoomsCategoryDto roomCategoryDto=null;
		try {
			roomCategory = roomsCategoryDao.findBycategoryId(id);
			roomCategoryDto = converter.RoomsCategoryEntityToRoomsCategoryDto(roomCategory);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return roomCategoryDto;
	}
	
	public List<RoomsCategoryDto> findAllRoomsCategory() {
		List<RoomCategory> roomsCategoryList=null;
		try {
			roomsCategoryList = roomsCategoryDao.findAll();
		}catch (Exception e) {
			e.printStackTrace();
		}
		if(roomsCategoryList==null) {
			return null;
		}
		return roomsCategoryList.stream().map(RoomCategory -> converter.RoomsCategoryEntityToRoomsCategoryDto(RoomCategory))
				.collect(Collectors.toList());
	}
	
	public Map<String, Object> addRoomsCategory(RoomsCategoryDto roomsCategoryDto) {
		if(roomsCategoryDto!=null) {
			RoomCategory roomCategoryToBeSaved = null;
			RoomCategory roomCategoryToSaved=null;
			try {
				roomCategoryToBeSaved = converter.RoomsCategoryDtoToRoomsCategoryEntity(roomsCategoryDto);
				roomCategoryToSaved = roomsCategoryDao.save(roomCategoryToBeSaved);
			}catch (Exception e) {
				e.printStackTrace();
			}
			//System.out.println(roomCategoryToSaved);
			return Collections.singletonMap("addedRows", 1);
		}
		return Collections.singletonMap("addedRows", 0);
	}

	public Map<String, Object> editRoomsCategory(int id, RoomsCategoryDto roomsCategoryDto) {
		if (roomsCategoryDao.existsById(id)) {
			RoomCategory roomCategoryToBeUpdated = null;
			RoomCategory roomCategoryToUpdated=null;
			try {
				roomCategoryToBeUpdated = converter.RoomsCategoryDtoToRoomsCategoryEntity(roomsCategoryDto);
				roomCategoryToUpdated = roomsCategoryDao.save(roomCategoryToBeUpdated);
			}catch (Exception e) {
				e.printStackTrace();
			}
			//System.out.println(roomCategoryToUpdated);
			return Collections.singletonMap("updatedRows", 1);
		}
		return Collections.singletonMap("updatedRows", 0);
	}

	public Map<String, Object> deleteRoomsCategory(int id) {
		if (roomsCategoryDao.existsById(id)) {
			roomsCategoryDao.deleteById(id);
			return Collections.singletonMap("deletedRows", 1);
		}
		return Collections.singletonMap("deletedRows", 0);
	}
}
