/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Authentication;

/**
 *
 * @author Kasper
 */
public class Create extends Authentication{
    
    public Create(String userName, String password) {
        super(userName, password);
    }
    
    private boolean userExists() {
        return true; 
    }
    
    public boolean createUser() {
        return true;
    }
    
}
