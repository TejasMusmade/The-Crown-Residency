package com.app.entities;



import java.util.Date;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Booking extends BaseEntity {
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "booking_date", insertable = false)
	private Date bookingDate;
	@Column(name = "check_in_date")
	@Temporal(TemporalType.DATE)
	private Date checkIn;
	@Temporal(TemporalType.DATE)
	@Column(name = "check_out_date")
	private Date checkOut;
	@Column
	private String remark;
	@Column
	private String status;
	@Column
	private String payment;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	private User user;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "room_id", nullable = false)
	private Rooms room;
}
