package com.crown.dtos;

public class IdproofDto {

	private int id;
	private String type;
	
	public IdproofDto() {
		super();
	}

	public IdproofDto(int id, String type) {
		super();
		this.id = id;
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "IdproofDto [id=" + id + ", type=" + type + "]";
	}
	
	
}
