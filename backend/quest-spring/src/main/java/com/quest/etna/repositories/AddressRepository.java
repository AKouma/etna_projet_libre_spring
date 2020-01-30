package com.quest.etna.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.quest.etna.model.Address;

@Repository
public interface AddressRepository extends CrudRepository<Address, Integer> {
	
	@Query("SELECT a FROM Address a WHERE a.street =:street")
	public List<Address> findByStreet(String street);
	
	@Query("SELECT a FROM Address a WHERE a.postalCode =:postalCode")
	public List<Address> findByPostalCode(String postalCode);
	
	@Query("SELECT a FROM Address a WHERE a.city =:city")
	public List<Address> findByCity(String city);
	
	@Query("SELECT a FROM Address a WHERE a.country =:country")
	public List<Address> findByCountry(String country);
	
	@Query("SELECT a FROM Address a WHERE a.street =:street AND a.postalCode =:postalCode")
	public Address findByStreetAndPostalCode(String street, String postalCode);
}
