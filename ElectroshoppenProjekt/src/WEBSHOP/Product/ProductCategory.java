/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WEBSHOP.Product;


/**
 * Enum defining the legal categories a product can have.
 * @author Kasper
 */
public enum ProductCategory {
    COMPUTER("Computer"), PHONE("Phone"), VACUUM("Vacuum"), TELEVISION("Television"), 
    HIFI("hifi"), TABLET("Tablet"), CAMERA("Camera");
    
    private final String text;
    
    private ProductCategory(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return this.text;
    }
}
