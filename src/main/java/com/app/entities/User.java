package com.app.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.*;


@Entity
@Table(name="users")
public class User extends BaseEntity {

	@Column(name ="first_name")
	private String firstName;
	@Column(name ="last_name")
	private String lastName;
	@Column
	private String email;
	@Column
	private String password;
	@Column(name ="idproof")
	private Integer idproofno;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(insertable = false)
	private Date createdTimestamp;
	@Column
	private String gender;
	@Column
	private String role;
	@Column
	private String mobile;
	@Column
	private String address;
	@Column
	private String city;
	@Column
	private String state;
	@Column
	private String zipcode;
	
	
	@OneToOne
	@JoinColumn(name="id_proofno",nullable=false)
	private IdProof idprf;
	
	@OneToMany(mappedBy = "user",cascade=CascadeType.ALL,orphanRemoval = true)
	private List<Booking> bookingList;

}
