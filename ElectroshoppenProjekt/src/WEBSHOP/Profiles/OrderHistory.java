/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WEBSHOP.Profiles;

import DBManager.DBConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class responsible for fetching orders from the database and collecting them
 * as an OrderHistory.
 * @author Jacob
 */
public class OrderHistory {
    
    private DBConnection DBC = new DBConnection();
    private ArrayList<OrderHistoryLine> allOrders;
    private HashMap<String, ArrayList<String>> orderLinesByOrder;

    public OrderHistory() {         
        allOrders = new ArrayList();
        this.orderLinesByOrder = new HashMap();

    }
    
    /**
     * Finds all orders in the database connected to the given customer email
     * and loads them into the HashMap orderLinesByOrder.
     * @param customerId email
     */
    private void getOrders(String customerId) {
        OrderHistoryLine nextLine;
        String currentOrderNumber = "";
        try {
            String query = "select o.order_number, o.date, p.name, p.price, ol.amount, p.product_id\n"
                    + "from product p inner join order_line ol on p.product_id = ol.product_id\n"
                    + "inner join orders o on ol.order_number=o.order_number AND o.email = '" + customerId + "' ORDER BY o.order_number";
            ResultSet orders = DBC.runQueryExcecute(query);
            
            while (orders.next()) {
                
                String orderNumber = orders.getString("order_number");
                String date = orders.getString("date");
                String name = orders.getString("name");
                Double price = orders.getDouble("price");
                int amount = orders.getInt("amount");
                long product_id = orders.getLong("product_id");
                nextLine = new OrderHistoryLine(orderNumber, date, name, price, amount, product_id);
                allOrders.add(nextLine);

                String orderCred = orderNumber + "\n" + date;

                    if (!orderNumber.equals(currentOrderNumber)) {
                         
                        ArrayList<String> orderLineCred = new ArrayList();
                        orderLineCred.add(nextLine.toString());
                        this.orderLinesByOrder.put(orderCred, orderLineCred);
                        currentOrderNumber = orderNumber;

                    } else {
                        
                        this.orderLinesByOrder.get(orderCred).add(nextLine.toString());
                    }

                
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrderHistory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * 
     * @param customerId email
     * @return All orderLines for the given customer grouped by their Order.
     */
    public HashMap<String, ArrayList<String>> getOrderLinesByOrder(String customerId) {         
        getOrders(customerId);
        return this.orderLinesByOrder;
    }
    
    /**
     * Should have been overtaken by the getOrderLinesByOrder(...) method.
     * Formats information for each Order into one String.
     * @return 
     */
    @Override
    public String toString() {
        String fullOrder = "";
        int lastOrderNumber = 0;
        for (OrderHistoryLine ohl : allOrders) {
            int currentOrderNumber = Integer.parseInt(ohl.getOrderNumber());
            if (currentOrderNumber != lastOrderNumber) {
                lastOrderNumber = currentOrderNumber;
                fullOrder += "\nOrdrernummer: " + currentOrderNumber
                        + "\t Dato for ordreoprettelse: " + ohl.getDate() + "\n"
                        + "\t Produkt navn: " + ohl.getProductName() + "\n\t\t Pris: " + ohl.getProductPrice()
                        + "\n\t\t Amount: " + ohl.getAmount() + "\n\n";
            } else {
                fullOrder += "\t Produkt navn: " + ohl.getProductName() + "\n\t\t Pris: " + ohl.getProductPrice()
                        + "\n\t\t Amount " + ohl.getAmount() + "\n";
            }
        }
        if (fullOrder.equals("")) {
            fullOrder = "Der er ikke registreret nogen købshistorik, på denne email";
        }
        return fullOrder;
    }

}
