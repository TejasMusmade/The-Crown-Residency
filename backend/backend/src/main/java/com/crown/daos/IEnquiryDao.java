package com.crown.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crown.entities.Enquiry;
import com.crown.entities.Facility;

public interface IEnquiryDao extends JpaRepository<Enquiry, Integer>{

	Enquiry findByEnquiryId(int enquiryId);
}
