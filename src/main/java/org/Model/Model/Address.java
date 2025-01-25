package org.Model.Model;

public class Address {

	public Address() {
	}

	public Address(String country, String city, String zipCode, String street, String blockNumber) {
		Country = country;
		City = city;
		ZipCode = zipCode;
		Street = street;
		BlockNumber = blockNumber;
	}
	public String Country;
	public String City;
	public String ZipCode;
	public String Street;
	public String BlockNumber;

}