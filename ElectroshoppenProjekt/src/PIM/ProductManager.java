/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PIM;

import DBManager.DBConnection;
import WEBSHOP.Product.Product;
import WEBSHOP.Product.ProductCategory;

/**
 * Class used to add and remove products from database.
 * @author Jacob
 */
public class ProductManager {
    
    private Product currentProduct;
    private DBConnection dbc = null; //connection to database. Is initialised in constructor.
    
    /**
     * Class constructor. Initializes a DBConnection object. 
     */
    public ProductManager(){
	dbc = new DBConnection();
    }
    
    public void newProduct(String name, long number, double price, String description, ProductCategory category) {
        this.currentProduct = new Product(name, number, price, description, category);
    }
    
    /**
     * Method to add a product, to the database. Runs an INSERT query,
     * using getters from Product class.
     */
    public boolean addProductToDatabase() {
        
        if (this.currentProduct != null) {
            String query = "INSERT INTO public.product(\n"
                    + "	product_id, name, price, description, category)\n"
                    + "	VALUES (" + (int) this.currentProduct.getProductNumber() + ", '"
                    + this.currentProduct.getProductName() + "', " + this.currentProduct.getPiecePrice() + ", '"
                    + this.currentProduct.getDescription() + "', '" + this.currentProduct.getProductCategory().toString() + "');";
            DBConnection dbc = new DBConnection();
            dbc.runQueryUpdate(query);
            return true;
            
        } else {
            return false;
        }
    }

    /**
     * Method to remove product from database using Product. Runs a delete query on Product
     * table, an remove where product_id equals id on the product used as parameter.
     * @param product Product to delete in database. Uses the id of said product.
     */
    public void removeProduct(Product product) {
	String query = "DELETE FROM public.product\n"
		+ "WHERE product_id = " + product.getProductNumber() + ";";
	DBConnection dbc = new DBConnection();
	dbc.runQueryUpdate(query);
    }
    
    /**
     * Method to remove product from database using only id. Runs a delete query on Product
     * table, an remove where product_id equals id.
     * @param id ID as an integer of product to be removed from database. 
     */
    public void removeProduct(int id) {
	String query = "DELETE FROM public.product\n"
		+ "WHERE product_id = " + id + ";";
	DBConnection dbc = new DBConnection();
	dbc.runQueryUpdate(query);
    }
}
