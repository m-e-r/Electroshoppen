/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Facade.Facade;
import Facade.iFacade;

/**
 *
 * @author Kasper
 */
public class WebshopFacade {
    private static WebshopFacade instance = null;
    private iFacade facade;
    
    private WebshopFacade() {
        this.facade = new Facade();
    }
    
    protected static WebshopFacade getInstance() {
        if (instance == null) {
            instance = new WebshopFacade();
        }
        return instance;
    }
    
    protected iFacade getFacade() {
        return this.facade;
    }
}
