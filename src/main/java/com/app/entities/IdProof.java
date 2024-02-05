package com.app.entities;

import javax.persistence.*;

import lombok.*;

@Entity
@Table(name="id_proof")
public class IdProof extends BaseEntity{

	@Column
	private String type;
	
	@OneToOne(mappedBy="idprf",cascade=CascadeType.ALL,orphanRemoval = true)
	private User user;
	
	
	
}
