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
import com.crown.daos.IOffersDao;
import com.crown.dtos.DtoEntityConverter;
import com.crown.dtos.FacilityDto;
import com.crown.dtos.IdproofDto;
import com.crown.entities.Enquiry;
import com.crown.entities.Facility;
import com.crown.entities.Idproof;
import com.crown.entities.Offers;

@Transactional
@Service
public class OffersServices {

	@Autowired
	private IOffersDao offersDao;



	public List<Offers> findAllOffers() {
		List<Offers> offersList = null;
		try {
			offersList = offersDao.findAll();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return offersList;
	}
	
	public Offers findOffersById(int id) {
		Offers offers = null;
		try {
			offers = offersDao.findByOfferId(id);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return offers;
	}
	

	public Map<String, Object> addOffers(Offers offers) {
		if(offers!=null) {
			Offers offersToSaved = null;
			try {
				offersToSaved = offersDao.save(offers);
			}catch (Exception e) {
				e.printStackTrace();
			}
			return Collections.singletonMap("addedRows", 1);
		}
		return Collections.singletonMap("addedRows", 0);
	}
	
	public Map<String, Object> editOffers(int id, Offers offers) {
		if (offersDao.existsById(id)) {
			
			Offers offersToUpdated = null;
			try {
				offersToUpdated = offersDao.save(offers);
			}catch (Exception e) {
				e.printStackTrace();
			}
			return Collections.singletonMap("updatedRows", 1);
		}
		return Collections.singletonMap("updatedRows", 0);
	}


	public Map<String, Object> deleteOffers(int id) {
		if (offersDao.existsById(id)) {
			offersDao.deleteById(id);
			return Collections.singletonMap("deletedRows", 1);
		}
		return Collections.singletonMap("deletedRows", 0);
	}
}
