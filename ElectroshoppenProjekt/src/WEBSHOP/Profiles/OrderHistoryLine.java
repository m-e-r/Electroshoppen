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
    private long productId;
    
    public OrderHistoryLine(String orderNumber, String date, String productName, Double productPrice, int amount, long productId){
	this.orderNumber = orderNumber;
	this.date = date;
	this.productName = productName;
	this.productPrice = productPrice;
	this.amount = amount;
        this.productId = productId;
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
    
    /**
     * Used when presented alongside its full Oder, which must then contain the 
     * OrderNumber and date.
     * @return 
     */
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        
        str.append(this.productId)
                .append("#")
                .append("Produkt:\n")
                .append(this.productName)
                .append("\n\n")
                .append("Pris:\n")
                .append(this.productPrice)
                .append("\n\n")
                .append("Mængde:\n")
                .append(this.amount)
                .append("\n");
        
        //System.out.println("OrderLine: " + str);
        return new String(str);
    }
    
}
