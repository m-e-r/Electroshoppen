/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PIM;

import DBManager.DBConnection;
import ProductStuff.ProductCategory;

/**
 * Class to edit information in database on products.
 *
 * @author Jacob
 */
public class ProductEditing {
    private DBConnection dbc = null; //connection to database. Is initialised in constructor.
    
    /**
     * Class constructor. Initializes a DBConnection object. 
     */
    public ProductEditing(){
	dbc = new DBConnection();
    }
    
    /**
     * Method to edit name of a product in database, using the product id and the new name
     * @param id ID as integer of product to edit
     * @param newName New name as String. 
     */
    public void editName(long id, String newName) {
	dbc.runQueryUpdate(SQLQuery(id, "name", newName));
    }
    
    public void editPrice(long id, double newPrice){
	dbc.runQueryUpdate(SQLQuery(id, "price", Double.toString(newPrice)));
    }
    
    public void editDescription(long id, String newDescription){
	dbc.runQueryUpdate(SQLQuery(id, "description", newDescription));
    }
    
    public void editCategory(long id, ProductCategory newCategory){
	dbc.runQueryUpdate(SQLQuery(id, "category", newCategory.toString().toUpperCase()));
    }
    
    private String SQLQuery(long id, String columnToUpdate, String update){
	return "UPDATE public.product\n"
		+ "	SET " + columnToUpdate + " = '" + update + "' \n"
		+ "	WHERE product_id = " + id + ";";
    }
}
