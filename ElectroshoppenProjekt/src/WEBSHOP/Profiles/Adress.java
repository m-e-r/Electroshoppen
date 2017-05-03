/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WEBSHOP.Profiles;

/**
 *
 * @author Jacob
 */
public class Adress {
    private String zipCode, city, streetName, streetNumber, floor, door;
    
    public Adress(String zipCode, String city, String streetName, String streetNumber,
	    String floor, String door){
	this.city = city;
	this.door = door;
	this.floor = floor;
	this.streetName = streetName;
	this.streetNumber = streetNumber;
	this.zipCode = zipCode;
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
     * @return the floor
     */
    public String getFloor() {
	return floor;
    }

    /**
     * @param floor the floor to set
     */
    public void setFloor(String floor) {
	this.floor = floor;
    }

    /**
     * @return the door
     */
    public String getDoor() {
	return door;
    }

    /**
     * @param door the door to set
     */
    public void setDoor(String door) {
	this.door = door;
    }
    
    
}
