/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PIM;

import ProductStuff.Product;
import ProductStuff.ProductCategory;

/**
 *
 * @author Jacob
 */
public class PIMTestMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
	Product p = new Product("Test Product", 10, 12345, "Test product description", ProductCategory.PHONE);
	ProductManager pm = new ProductManager();
	pm.removeProduct(p);
	pm.addProduct(p);
	ProductEditing pe = new ProductEditing();
	pe.editCategory(10, ProductCategory.COMPUTER);
	pe.editDescription(10, "new description");
	pe.editName(10, "name edit");
	pe.editPrice(10, 222);
    }
    
}
