package com.crown.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crown.entities.Enquiry;
import com.crown.entities.Facility;
import com.crown.entities.Offers;

public interface IOffersDao extends JpaRepository<Offers, Integer>{

	Offers findByOfferId(int offerId);
}
