/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBManager;

import java.sql.*;
import java.util.*;
import java.util.logging.*;

/**
 * @author Jacob
 */
public class DBConnection {

    private static Connection con = null;
    
    public DBConnection() {
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
