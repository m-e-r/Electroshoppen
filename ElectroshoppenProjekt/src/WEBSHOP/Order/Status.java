/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WEBSHOP.Order;

/**
 *
 * @author Kasper
 */
public enum Status {
    STATUS1("Status1"), STATUS2("Status2"), STATUS3("Status3");
    
    private final String text;
    
    private Status(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return this.text;
    }
}
