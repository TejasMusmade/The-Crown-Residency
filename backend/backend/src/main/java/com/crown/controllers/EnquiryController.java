package com.crown.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.crown.dtos.FacilityDto;
import com.crown.dtos.IdproofDto;
import com.crown.entities.Enquiry;
import com.crown.entities.Facility;
import com.crown.services.EnquiryServices;
import com.crown.services.FacilityServices;
import com.crown.utils.Response;

@CrossOrigin(origins = "*")
@RestController	
public class EnquiryController {

	@Autowired
	private EnquiryServices enquiryServices;

	@GetMapping("/enquiry/{id}")
	public ResponseEntity<?> enquiryById(@PathVariable("id") int enquiryId) {
		//FacilityDto facilityDto  = facilityServices.findFacilityById(facilityId);
		Enquiry enquiryDto  = enquiryServices.findEnquiryById(enquiryId);
		if(enquiryDto==null) {
			return Response.status(HttpStatus.NOT_FOUND);
		}
		return Response.success(enquiryDto);
	}
	
	@GetMapping("/enquiry/allenquiry")
	public ResponseEntity<?> allEnquiry() {
		List<Enquiry> enquiryList = enquiryServices.findAllEnquiry();
		if(enquiryList==null) {
			return Response.status(HttpStatus.NOT_FOUND);
		}
		return Response.success(enquiryList);
	}

	@PostMapping("/enquiry/add")
	public ResponseEntity<?> addEnquiry(@RequestBody Enquiry enquiry) {
		Map<String, Object> result = enquiryServices.addEnquiry(enquiry);
		if(result.containsValue(1)) {
			return Response.success(result);
		}
		return Response.status(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@DeleteMapping("/enquiry/delete/{id}")
	public ResponseEntity<?> deleteFacility(@PathVariable("id") int id) {
		Map<String, Object> result = enquiryServices.deleteEnquiry(id);
		if(result.containsValue(1)) {
			return Response.success(result);
		}
		return Response.status(HttpStatus.NOT_FOUND);
	}
}
