/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WEBSHOP.Profiles;

import DBManager.DBConnection;
import WEBSHOP.Order.Order;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jacob
 */
public class OrderHistory {
    private DBConnection DBC = new DBConnection();
    private String customerId;
    private ArrayList<OrderHistoryLine> allOrders;
    
    public OrderHistory(String customerId){
	this.customerId = customerId;
	allOrders = new ArrayList();
	getOrders();
    }
    
    private void getOrders() {
	OrderHistoryLine nextLine;
	try {
	    String query = "select o.order_number, o.date, p.name, p.price, ol.amount\n"
		    + "from product p inner join order_line ol on p.product_id = ol.product_id\n"
		    + "inner join orders o on ol.order_number=o.order_number AND o.email = '" + customerId + "'";
	    ResultSet orders = DBC.runQueryExcecute(query);
	    while (orders.next()) {
		String orderNumber = orders.getString("order_number");
		String date = orders.getString("date");
		String name = orders.getString("name");
		Double price = orders.getDouble("price");
		int amount = orders.getInt("amount");
		nextLine = new OrderHistoryLine(orderNumber, date, name, price, amount);
		allOrders.add(nextLine);
	    }
	} catch (SQLException ex) {
	    Logger.getLogger(OrderHistory.class.getName()).log(Level.SEVERE, null, ex);
	}
    }
    
    @Override
    public String toString(){
	String fullOrder = "";
	int lastOrderNumber = 0;
	for (OrderHistoryLine ohl : allOrders){
	    int currentOrderNumber = Integer.parseInt(ohl.getOrderNumber());
	    if (currentOrderNumber != lastOrderNumber){
		lastOrderNumber = currentOrderNumber;
		fullOrder += "\nOrdrernummer: " + currentOrderNumber 
			+ "\t Dato for ordreoprettelse: " + ohl.getDate() + "\n"
			+ "\t Produkt navn: " + ohl.getProductName() + "\n\t\t Pris: " + ohl.getProductPrice() 
			+ "\n\t\t Amount: " + ohl.getAmount() + "\n";
	    } else {
		fullOrder += "\t Produkt navn: " + ohl.getProductName() + "\n\t\t Pris: " + ohl.getProductPrice() 
			+ "\n\t\t Amount " + ohl.getAmount() + "\n";
	    }
	}
	if(fullOrder.equals("")){
	    fullOrder = "Der er ikke registreret nogen købshistorik, på denne email";
	}
	return fullOrder;
    }

}
