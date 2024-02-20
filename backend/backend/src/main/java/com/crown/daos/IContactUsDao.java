package com.crown.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crown.entities.ContactUs;

public interface IContactUsDao extends JpaRepository<ContactUs, Integer>{

	ContactUs findById(int facilityId);
}
