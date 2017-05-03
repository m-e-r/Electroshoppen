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

    /**
     * Query NEEDED!!
     * @return 
     */
    public boolean createUser() {
        if (super.userExists()) {
            return false;
            
        } else {
            return true;
        }
    }
    
}
