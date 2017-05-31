/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WEBSHOP.Order;

import DBManager.DBConnection;
import WEBSHOP.Product.Product;
import java.sql.Date;
import java.util.*;

/**
 *
 * @author Bruger
 */
public class Order {

    //Attributes
    private Status status;
    private double totalPrice;
    private ArrayList<OrderLine> orderlines;
    private String date;
    private OrderLine nextOrderLine;
    private Payment payment;
    private long id;
    private String email = null;
    private final DBConnection DBC = new DBConnection();
    private String dateAsString;

    //Constructor
    public Order() {
	this.status = Status.STATUS1;
	this.orderlines = new ArrayList();
	this.payment = new Payment();
	Long currentMillis = System.currentTimeMillis();
	this.date = new Date(currentMillis).toString();

	/*
	Creates the order id, using the system time and a random number between 0 and 100.
	Random number is used, in case to people log on to the system at the exact same time, and
	therefor getting the same output from currentTimeMillis(). Very unlikely though. 
	 */
	int r = new Random().nextInt(100);
	String random = Integer.toString(r);
	String n = currentMillis + random;
	id = Long.parseLong(n);

	addOrderToDB();

    }
    
    /**
     * Remove?
     * @param date
     * @param id
     * @param status
     * @param orderLines 
     */
    public Order(String date, Long id, String status, ArrayList<OrderLine> orderLines){
	
    }

    /**
     * Return the order id
     *
     * @return Order id as type Long.
     */
    public Long getId() {
	return id;
    }

    public String getDate() {
	return this.date;
    }
    
    
    /**
     * Call this method to pay for an Order. This will set its status to STATUS3.
     * @return Its toString() implementation along with the total price.
     */
    public String pay() {

	if (this.payment.Pay(this.getTotalPrice())) {
	    this.setStatus(Status.STATUS3);
	    return this.toString() + "\nTotalpris: " + this.getTotalPrice() + " kr.";
	} else {
	    return "";
	}

    }

    
    /**
     * Use this method whether or not the product already is in this Order.
     * Creates a new OrderLine and checks if it exists in this Order based on
     * productNumber. It then adds the given amount to the OrderLine if it
     * exists, or else it adds the new OrderLine to its array.
     *
     * @param p
     * @param amount
     */
    public void addOrderLine(Product p, int amount) {
	this.nextOrderLine = new OrderLine(p, amount);

	if (!this.addToOrderLine(this.nextOrderLine.getProductNumber(), amount)) {
	    this.orderlines.add(this.nextOrderLine);
	    createNewOrderLineDb(p, amount);
	}
    }
    
    /**
     * Saves the new OrderLine to the database.
     * @param p
     * @param amount 
     */
    private void createNewOrderLineDb(Product p, int amount) {
	int r = new Random().nextInt(100);
	String random = Integer.toString(r);
	String n = System.currentTimeMillis() + random;
	Long orderLineNumber = Long.parseLong(n);
	String query = "INSERT INTO public.order_line(\n"
		+ "	order_line_id, order_number, product_id, amount)\n"
		+ "	VALUES (" + orderLineNumber + ", " + this.id + ", " 
		+ p.getProductNumber() + ", " + amount + ");";
	DBC.runQueryUpdate(query);
    }

    /**
     * Use this method to remove an amount or the orderline entirely.
     * @param p
     * @param amount
     */
    public void removeOrderLine(Product p, int amount) {
	this.nextOrderLine = new OrderLine(p, amount);
	this.removeFromOrderLine(this.nextOrderLine.getProductNumber(), amount);
    }

    /**
     * Helper method for addOrderLine.
     * Checks if the product exists on the Order and adds the amount to the 
     * OrderLine if so.
     * @param productNumber
     * @param amount
     * @return true if the product exists, false if not
     */
    private boolean addToOrderLine(long productNumber, int amount) {
	for (OrderLine o : this.orderlines) {
	    if (o.getProductNumber() == productNumber) {
		o.addProductAmount(amount);
		return true;
	    }
	}
	return false;
    }

    /**
     * Helper method for removeOrderLine.
     * Removes the wished amount from the OrderLine, or the OrderLine entirly
     * if the wished amount results in a 0 sum.
     * @param productNumber
     * @param amount
     * @return true if the wished amount was removed or the OrderLine was removed entirely.
     * False if the wished amount would result in a negative value, or if the OrderLine was never found.
     */
    private boolean removeFromOrderLine(long productNumber, int amount) {
	for (int i = 0; i < this.orderlines.size(); i++) {
	    if (this.orderlines.get(i).getProductNumber() == productNumber) {

		if (this.orderlines.get(i).removeProductAmount(amount)) {

		    if (this.orderlines.get(i).getProductAmount() == 0) {
			this.orderlines.remove(i);
		    }

		    return true; //if the wished amount was removed or the orderline was removed entirely

		} else {
		    return false; //if the wished amount removed would result in a negative value.
		}
	    }
	}

	return false; //if the orderline was never found on the order
    }
    
    
    /**
     * Set the status for the Order. This should maybe be private?
     * @param status 
     */
    public void setStatus(Status status) {
        this.status = status;
    }
    
    public Long getOrderNumber() {
        return id;
    }

    public String getStatus() {
	return status.toString();
    }
    
    /**
     * Calculates the total price for the Order.
     * @return The total price
     */
    public double getTotalPrice() {
        this.totalPrice = 0; //Reset before calculating

	for (OrderLine orderline : orderlines) {

	    this.totalPrice += orderline.getSubTotal();
	}

	return totalPrice;
    }

    /**
     * Method that adds an order to orders table in database.
     */
    private void addOrderToDB() {
	String query = "INSERT INTO public.orders(\n"
		+ "	order_number, email, date)\n"
		+ "	VALUES (" + id + ", '" + email + "', '" + date + "');";

	DBC.runQueryUpdate(query);
    }
    
    /**
     * Sets the email for the Order in the database.
     * @param email 
     */
    public void setEmail(String email) {
	this.email = email;
	String query = "UPDATE public.orders\n"
		+ "	SET email = '" + this.email + "'\n"
		+ "	WHERE order_number = '" + this.id + "';";
	DBC.runQueryUpdate(query);
    }
    
    
    /**
     * Returns the OrderLines in this Order seperated by newlines as one String.
     * @return 
     */
    public String showBasket() {
        StringBuilder str = new StringBuilder();
        for (OrderLine o : this.orderlines) {
            str.append(o.toString());
            str.append("\n");
        }
        
        return new String(str);
    }
    
    /**
     * Use this method to print the Order with all of its OrderLines, their total,
     * the overall total, the date and the Status of the Order.
     * @return 
     */
    @Override
    public String toString() {

	StringBuilder str = new StringBuilder();

	for (OrderLine o : this.orderlines) {
	    str.append(o.toString());
	    str.append("\n");
	}
	return "Order:\t" + this.id + "\t" + date + "\t" + this.getTotalPrice() + "\t" + this.getStatus() + "\n\n" + str;
    }
    
    /**
     * Method used when a logged in user with products in his order logs out.
     */
    public void resetOrder() {
        this.orderlines.removeAll(this.orderlines);
    }

}
