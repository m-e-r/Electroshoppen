/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Authentication;

/**
 * Interface used to access methods in the Authentication package.
 * @author Kasper
 */
public interface Authenticateable {
    public Token doLogin();
    public boolean doLogout();
    
    public boolean createUser(String type);
    public boolean deleteUser(String type);
}
