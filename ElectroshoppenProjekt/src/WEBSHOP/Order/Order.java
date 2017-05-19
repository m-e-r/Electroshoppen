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
    

    public Order(OrderLine OrderLine) {

        this.status = Status.STATUS1;        
        this.orderlines = new ArrayList();
        orderlines.add(OrderLine);
        this.totalPrice = this.getTotalPrice();
    }


    public int getOrderNumber() {
        return orderNumber;
    }

    
    public boolean addToOrderLine(long productNumber, int amount) {
        for (OrderLine o : this.orderlines) {
            if (o.getProductNumber() == productNumber) {
                o.addProductAmount(amount);
                return true;
            }
        }       
        return false;
    }
    
    public boolean removeFromOrderLine(long productNumber, int amount){
        for(OrderLine o: this.orderlines){
            if(o.getProductNumber()==productNumber){
                o.removeProductAmount(amount);
                return true;
            }
        }
        return false;
    }
    
    public String getStatus() {
        return status.toString();
    }

    public double getTotalPrice() {
        
        for(OrderLine orderline: orderlines) {
            
            this.totalPrice += orderline.getSubTotal();
        }
        
        return totalPrice;
    }

    
    @Override 
    public String toString() {
        LocalDateTime time = LocalDateTime.now();
        String printTime = "" + time.getYear() + time.getMonth() + time.getDayOfMonth();
        
        this.orderNumber = 4; //Some sql to find the next ordernumber??
        
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
