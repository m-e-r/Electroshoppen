/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProductStuff;

import java.util.ArrayList;

/**
 *
 * @author Kasper
 */
public enum ProductCategory {
    COMPUTER("Computer"), PHONE("Phone"), VACUUM("Vacuum");
    
    private final String text;
    
    private ProductCategory(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return this.text;
    }
}
