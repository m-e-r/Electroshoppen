/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS;

import DBManager.DBConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kasper
 */
public class DBConnecter {
    private static Connection con = null;
    
    public DBConnecter() {
	String url = "jdbc:postgresql://localhost:5432/SemesterProjectDB";
	String user = "postgres";
        String password = "admin123";

	
	//CONNECTING
	try {
	    con = DriverManager.getConnection(url, user, password);

	} catch (SQLException ex) {
	    Logger lgr = Logger.getLogger(DBConnection.class.getName());
	    lgr.log(Level.WARNING, ex.getMessage(), ex);

	}
    }
    
    public Connection getCon(){
	return con;
    }

    public ResultSet runQueryExcecute(String query) {
	try {
	    Statement st = con.createStatement();
	    return st.executeQuery(query);
	} catch (SQLException e) {
	    e.printStackTrace();
	}
	return null;
    }
    
    public int runQueryUpdate(String query){
	try {
	    Statement st = con.createStatement();
	    return st.executeUpdate(query);
	} catch (SQLException e) {
	    e.printStackTrace();
	}
	return -1;
    }
}
