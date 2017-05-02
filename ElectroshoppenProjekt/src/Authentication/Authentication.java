/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Authentication;

import DBManager.DBConnection;

/**
 *
 * @author Kasper
 */
public abstract class Authentication {
    protected String userName;
    protected String password;
    protected DBConnection dbCon;
    
    public Authentication(String userName, String password) {
        this.userName = userName;
        this.password = this.encryptPassword(password);
    }
    
    private String encryptPassword(String password) {
        return password.toLowerCase();
    }
       
}
