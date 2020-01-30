package com.quest.etna.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "adresse")
public class Address {
	
	public Address() {
		
	}
	
	   @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	   @Column(unique = true)
	    private int id;

	    @NotBlank
	    @Column(name = "rue", nullable = false, length = 100)
	    private String street;

	    @NotBlank
	    @Column(name = "postal_code", nullable = false, length = 50)
	    private String postalCode;

	    @NotBlank
	    @Column(name = "city", nullable = false, length = 50)
	    private String city;
	    
	    @NotBlank
	    @Column(name = "country", nullable = false, length = 50)
	    private String country;
	    

	    @CreationTimestamp
	    @Temporal(TemporalType.TIMESTAMP)
	    @Column(name = "creation_date")
	    private Date creationDate;

	    @UpdateTimestamp
	    @Temporal(TemporalType.TIMESTAMP)
	    @Column(name = "update_date")
	    private Date updatedDate;
	    
	    
	    @OneToMany(fetch = FetchType.LAZY, mappedBy = "address")
	    private Set<User> users;
	    
	    
	    

		@Override
		public String toString() {
			return "Address [id=" + id + ", street=" + street + ", postalCode=" + postalCode + ", city=" + city
					+ ", country=" + country + ", creationDate=" + creationDate + ", updatedDate=" + updatedDate
					+ ", user=" + users + "]";
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((city == null) ? 0 : city.hashCode());
			result = prime * result + ((country == null) ? 0 : country.hashCode());
			result = prime * result + ((creationDate == null) ? 0 : creationDate.hashCode());
			result = prime * result + id;
			result = prime * result + ((postalCode == null) ? 0 : postalCode.hashCode());
			result = prime * result + ((street == null) ? 0 : street.hashCode());
			result = prime * result + ((updatedDate == null) ? 0 : updatedDate.hashCode());
			result = prime * result + ((users == null) ? 0 : users.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Address other = (Address) obj;
			if (city == null) {
				if (other.city != null)
					return false;
			} else if (!city.equals(other.city))
				return false;
			if (country == null) {
				if (other.country != null)
					return false;
			} else if (!country.equals(other.country))
				return false;
			if (creationDate == null) {
				if (other.creationDate != null)
					return false;
			} else if (!creationDate.equals(other.creationDate))
				return false;
			if (id != other.id)
				return false;
			if (postalCode == null) {
				if (other.postalCode != null)
					return false;
			} else if (!postalCode.equals(other.postalCode))
				return false;
			if (street == null) {
				if (other.street != null)
					return false;
			} else if (!street.equals(other.street))
				return false;
			if (updatedDate == null) {
				if (other.updatedDate != null)
					return false;
			} else if (!updatedDate.equals(other.updatedDate))
				return false;
			if (users == null) {
				if (other.users != null)
					return false;
			} else if (!users.equals(other.users))
				return false;
			return true;
		}

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

		public Date getCreationDate() {
			return creationDate;
		}

		public void setCreationDate(Date creationDate) {
			this.creationDate = creationDate;
		}

		public Date getUpdatedDate() {
			return updatedDate;
		}

		public void setUpdatedDate(Date updatedDate) {
			this.updatedDate = updatedDate;
		}

		public Set<User> getUser() {
			return users;
		}

		public void setUser(Set<User> user) {
			this.users = user;
		}

}