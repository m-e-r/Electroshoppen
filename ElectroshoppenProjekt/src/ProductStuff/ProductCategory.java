/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProductStuff;

/**
 *
 * @author Kasper
 */
public enum ProductCategory {
    CAT1("Category1"), CAT2("Category2"), CAT3("Category3");
    
    private final String text;
    
    private ProductCategory(String text) {
        this.text = text;
    }
    
    @Override
    public String toString() {
        return this.text;
    }
}
