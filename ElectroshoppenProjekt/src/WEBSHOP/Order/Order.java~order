/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WEBSHOP.Order;

import java.util.Date;

/**
 *
 * @author Bruger
 */
public class Order {

    private int orderNumber;
    private String status;
    private double totalPrice;
    private Date date;
    private OrderLine orderLine;
    

    public Order(int orderNumber, String status, double totalPrice, Date date, OrderLine OrderLine) {
        
        this.orderNumber = orderNumber;
        this.status = status;
        this.totalPrice = totalPrice;
        this.date = date;
        this.orderLine = OrderLine;
    }

    /**
     * @return the orderNumber
     */
    public int getOrderNumber() {
        return orderNumber;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @return the totalPrice
     */
    public double getTotalPrice() {
        return totalPrice;
    }

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @return the orderLine
     */
    public OrderLine getOrderLine() {
        return orderLine;
    }
    
    @Override 
    public String toString() {
        
        return "Order: \t" + getOrderNumber() + "\t" + getDate() + "\t" + getTotalPrice();
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = "Not paid";
    }

}
