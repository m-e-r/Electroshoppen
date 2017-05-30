/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WEBSHOP.Order;
import WEBSHOP.Order.OrderLine;
import java.util.ArrayList;
import WEBSHOP.Product.Product;
import WEBSHOP.Product.ProductCategory;

/**
 *
 * @author Bruger
 */
public class tester {

    
    public static void main(String[] args) {
        
//        ArrayList<OrderLine> list = new ArrayList<>();
//        
//        list.add(new OrderLine(new Product("noob", 12, 23.3, "noobies", ProductCategory.PHONE), 1));
//        
//        for(OrderLine n: list) {
//            System.out.println(n);
//        }

	Order o = new Order();
	System.out.println("--------------------------");
	System.out.println(o.getId());
	System.out.println(o.getDate());
    }
}
