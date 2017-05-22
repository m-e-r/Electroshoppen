/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WEBSHOP;

/**
 *
 * @author Jacob
 */
public class Address {
    private String zipCode, city, streetName, streetNumber, secAddress;
    
   
    
    public Address(String streetName, String streetNumber, String secAddress, String zipCode,
            String city) {
        this.city = city;
	this.secAddress = secAddress;
	this.streetName = streetName;
	this.streetNumber = streetNumber;
	this.zipCode = zipCode;
    }
    
    public Address(String streetName, String streetNumber, String zipCode, String city) {
        this.zipCode = zipCode;
        this.city = city;
        this.streetName = streetName;
        this.streetNumber = streetNumber;
    }
    
    @Override
    public String toString(){
	return this.streetName + " " + this.streetNumber + ", " 
                + this.secAddress + ", " + this.zipCode + " " + this.city;
    }

    /**
     * @return the zipCode
     */
    public String getZipCode() {
	return zipCode;
    }

    /**
     * @param zipCode the zipCode to set
     */
    public void setZipCode(String zipCode) {
	this.zipCode = zipCode;
    }

    /**
     * @return the city
     */
    public String getCity() {
	return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
	this.city = city;
    }

    /**
     * @return the streetName
     */
    public String getStreetName() {
	return streetName;
    }

    /**
     * @param streetName the streetName to set
     */
    public void setStreetName(String streetName) {
	this.streetName = streetName;
    }

    /**
     * @return the streetNumber
     */
    public String getStreetNumber() {
	return streetNumber;
    }

    /**
     * @param streetNumber the streetNumber to set
     */
    public void setStreetNumber(String streetNumber) {
	this.streetNumber = streetNumber;
    }

    /**
     * @return the door
     */
    public String getSecAddress() {
	return secAddress;
    }

    /**
     * @param door the door to set
     */
    public void setSecAddress(String secAddress) {
	this.secAddress = secAddress;
    }
    
    
}
