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
public class Login extends Authentication{
    private Token token;
    
    public Login(String userName, String password) {
        super(userName, password);

    }
    
    /**
     * Creates and returns a Token object used to validate a succesfull login
     * for a profile.
     * If userName and password can't be validated this method returns null.
     * @return 
     */
    public Token doLogin() {
        if (super.userExists()) {
            this.token = new Token(super.userName.toUpperCase());
            return this.token;
            
        } else {
            return null;
        }
    }
    
}
