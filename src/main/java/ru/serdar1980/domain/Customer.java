package ru.serdar1980.domain;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Customer implements DomainObject{
	/*
	first name, 
	last name, 
	email, 
	phone number, 
	address line one, 
	address line two, 
	city, 
	state, 
	zip code
	*/
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Getter @Setter
	private Integer Id;
	@Getter @Setter
	private String firstName;  
	@Getter @Setter
	private String lastName;
	@Getter @Setter
	private String email;
	@Getter @Setter
	private String phoneNumber;
	@Getter @Setter
	private String addressFirst;
	@Getter @Setter
	private String addressSecond;
	@Getter @Setter
	private String city;
	@Getter @Setter
	private String state;
	@Getter @Setter
	private String zipCode;
	
	
	public Customer buildSetFirstName(String firstName){
		this.firstName = firstName;
		return this;
	} 
	public Customer buildSetLastName(String lastName){
		this.lastName = lastName;
		return this;
	}

	public Customer buildSetEmail(String email) {
		this.email =email;
		return this;
	}
	
	public Customer buildSetCity(String city) {
		this.city =city;
		return this;
	}
	public Customer buildSetZipCode(String zipCode) {
		this.zipCode =zipCode;
		return this;
	}
	
	public Customer buildSetAddressFirst(String adrressFirst) {
		this.addressFirst =adrressFirst;
		return this;
	}
	public Customer buildSetAddressSecond(String adrressSecond) {
		this.addressSecond =adrressSecond;
		return this;
	}
	public Customer buildSetState(String state) {
		this.state = state;
		return this;
	}
	
}
