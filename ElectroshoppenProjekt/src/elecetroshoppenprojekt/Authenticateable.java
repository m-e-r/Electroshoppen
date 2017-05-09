/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elecetroshoppenprojekt;

/**
 *
 * @author Kasper
 */
public interface Authenticateable {
    void newLogin(String userName, String password);
    
    boolean doLogin();
}
