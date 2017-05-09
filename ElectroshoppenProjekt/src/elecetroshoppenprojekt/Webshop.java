/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elecetroshoppenprojekt;

import Authentication.Authentication;
import Authentication.Login;

/**
 *
 * @author Kasper
 */
public class Webshop implements Authenticateable {
    private Authentication authenticate;

    @Override
    public void newLogin(String userName, String password) {
        this.authenticate = new Login(userName, password);
    }

    @Override
    public boolean doLogin() {
        if (!this.authenticate.getClass().equals(Login.class)) {
            System.out.println("Local variabel 'authenticate' must be initialized as Login type");
            return false;
            
        } else {
            return ((Login) this.authenticate).doLogin();
        }
        
    }
}
