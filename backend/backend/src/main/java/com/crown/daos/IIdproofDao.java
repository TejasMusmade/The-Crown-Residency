package com.crown.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crown.entities.Idproof;

public interface IIdproofDao extends JpaRepository<Idproof, Integer>{

	Idproof findById(int id);
}
