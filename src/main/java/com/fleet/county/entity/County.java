package com.fleet.county.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class County {

	@Id
	private String fips;

	private String state;
	private String name;

	public String getFips() {
		return fips;
	}

	public void setFips(String fips) {
		this.fips = fips;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
