package com.crown.services;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crown.daos.IEnquiryDao;
import com.crown.daos.IFacilityDao;
import com.crown.dtos.DtoEntityConverter;
import com.crown.dtos.FacilityDto;
import com.crown.entities.Enquiry;
import com.crown.entities.Facility;

@Transactional
@Service
public class EnquiryServices {

	@Autowired
	private IEnquiryDao enquiryDao;



	public List<Enquiry> findAllEnquiry() {
		List<Enquiry> enquiryList = null;
		try {
			enquiryList = enquiryDao.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return enquiryList;
	}
	
	public Enquiry findEnquiryById(int id) {
		Enquiry enquiry = null;
		try {
			enquiry = enquiryDao.findByEnquiryId(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return enquiry;
	}
	

	public Map<String, Object> addEnquiry(Enquiry enquiry) {
	if(enquiry!=null) {
		Enquiry enquiryToSaved = null;
		try {
			enquiryToSaved = enquiryDao.save(enquiry);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Collections.singletonMap("addedRows", 1);
	}
	return Collections.singletonMap("addedRows", 0);
	}


	public Map<String, Object> deleteEnquiry(int id) {
		if (enquiryDao.existsById(id)) {
			enquiryDao.deleteById(id);
			return Collections.singletonMap("deletedRows", 1);
		}
		return Collections.singletonMap("deletedRows", 0);
	}
}
