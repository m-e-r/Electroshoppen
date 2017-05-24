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
public class OrderHistoryLine {
    private String orderNumber, date, productName;
    private Double productPrice;
    private int amount;
    
    public OrderHistoryLine(String orderNumber, String date, String productName, Double productPrice, int amount){
	this.orderNumber = orderNumber;
	this.date = date;
	this.productName = productName;
	this.productPrice = productPrice;
	this.amount = amount;
    }

    /**
     * @return the orderNumber
     */
    public String getOrderNumber() {
	return orderNumber;
    }

    /**
     * @return the date
     */
    public String getDate() {
	return date;
    }

    /**
     * @return the productName
     */
    public String getProductName() {
	return productName;
    }

    /**
     * @return the productPrice
     */
    public Double getProductPrice() {
	return productPrice;
    }

    /**
     * @return the amount
     */
    public int getAmount() {
	return amount;
    }
    
}
