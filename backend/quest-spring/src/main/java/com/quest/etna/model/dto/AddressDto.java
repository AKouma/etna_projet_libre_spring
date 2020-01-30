package com.quest.etna.model.dto;

import java.util.Set;

import com.quest.etna.model.User;

public class AddressDto {
	
	   private int id;
	    private String street;
	    private String postalCode;
	    private String city;
	    private String country;
	    private Set<User> users;
		
	    public AddressDto() {}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getStreet() {
			return street;
		}

		public void setStreet(String street) {
			this.street = street;
		}

		public String getPostalCode() {
			return postalCode;
		}

		public void setPostalCode(String postalCode) {
			this.postalCode = postalCode;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}

		public String getCountry() {
			return country;
		}

		public void setCountry(String country) {
			this.country = country;
		}

		public Set<User> getUser() {
			return users;
		}

		public void setUser(Set<User> user) {
			this.users = user;
		}
	    
}
