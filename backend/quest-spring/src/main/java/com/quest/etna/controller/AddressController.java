package com.quest.etna.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.security.sasl.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.quest.etna.customexception.AuthenticateException;
import com.quest.etna.customexception.ParametersNotFound;
import com.quest.etna.customexception.ResourceAlreadyExist;
import com.quest.etna.model.Address;
import com.quest.etna.model.User;
import com.quest.etna.model.User.UserRole;
import com.quest.etna.model.dto.AddressDto;
import com.quest.etna.repositories.AddressRepository;
import com.quest.etna.repositories.UserRepository;
import com.quest.etna.services.UserService;
import com.quest.etna.utils.StringUtils;
import com.quest.etna.utils.Userutils;

@RestController
@RequestMapping("/address")
public class AddressController {
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private UserService userService;
	
	 @PostMapping("/create_address")
	 @ResponseStatus(HttpStatus.CREATED)
	    Address createAddress(@RequestBody AddressDto addressDto) {
		 Address address = null;
		 if(Userutils.isConnected()) {
			  if (addressDto == null || addressDto.getStreet() == null || addressDto.getPostalCode() == null) {
		            throw new ParametersNotFound();
		        } else {
		            boolean isAlreadyExist = addressRepository.findByStreetAndPostalCode(addressDto.getStreet(), addressDto.getPostalCode()) != null;
		            if (isAlreadyExist) {
		                throw new ResourceAlreadyExist();
		            } else {
		                address = new Address();
		                address.setCity(addressDto.getCity());
		                address.setCountry(addressDto.getCountry());
		                address.setPostalCode(addressDto.getPostalCode());
		                address.setStreet(addressDto.getStreet());
		                address.setUser(addressDto.getUser());
		                
		                address = addressRepository.save(address);
		            }
		        }
		 }else
			 throw new AuthenticateException();
	        return address;
	    }
	 
	 @GetMapping("/get_address")
	 @ResponseStatus(HttpStatus.OK)
	 List<Address> getAddress(@RequestParam String address){
		 List<Address> allAddress = new ArrayList<Address>();
		 if(Userutils.isConnected()) {
			 if(address == null || address.isEmpty()) {
				addressRepository.findAll().iterator().forEachRemaining(allAddress::add);
			 }else {
				 allAddress.addAll(addressRepository.findByCity(address));
				 allAddress.addAll(addressRepository.findByCountry(address));
				 allAddress.addAll(addressRepository.findByPostalCode(address));
				 allAddress.addAll(addressRepository.findByStreet(address));
			 }
		 }else
			 throw new AuthenticateException();
		 return filtrateAddress(allAddress);
	 }
	 
	 private List<Address> filtrateAddress(List<Address> addresses){
		 User currentUser = userService.getCurrentUserFromUserdetail();
		 List<Address> list = new ArrayList<Address>();
		 if(currentUser.getRole() == UserRole.ROLE_USER)
			 list.add(currentUser.getAddress());
			 else
				 list.addAll(addresses);
		 return list;
	 }
}
