package com.crown.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crown.entities.Facility;

public interface IFacilityDao extends JpaRepository<Facility, Integer>{

	Facility findByFacilityId(int facilityId);
}
