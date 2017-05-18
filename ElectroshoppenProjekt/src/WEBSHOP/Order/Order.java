/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WEBSHOP.Order;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;


/**
 *
 * @author Bruger
 */
public class Order {

    private int orderNumber;
    private Status status;
    private double totalPrice;
    private ArrayList<OrderLine> orderlines;
    private LocalDateTime date;
    

    public Order(int orderNumber, OrderLine OrderLine) {
        
        this.orderNumber = orderNumber;
        this.status = Status.STATUS1;        
        this.orderlines = new ArrayList();
        orderlines.add(OrderLine);
        this.totalPrice = this.getTotalPrice();
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
        return status.toString();
    }

    /**
     * @return the totalPrice
     */
    public double getTotalPrice() {
        
        for(OrderLine orderline: orderlines) {
            
            this.totalPrice += orderline.getAmountPrice();
        }
        
        return totalPrice;
    }

    
    @Override 
    public String toString() {
        LocalDateTime time = LocalDateTime.now();
        String printTime = "" + time.getYear() + time.getMonth() + time.getDayOfMonth();
        
        return "Order: \t" + getOrderNumber() + "\t" + printTime + "\t" + getTotalPrice();
    }

    /**
     * @param status the status to set
     */
    public void setStatus(Status status) {
        this.status = status;
    }
    
    public void addOrderline(OrderLine orderline) {        
        this.orderlines.add(orderline);
        
    }
}
