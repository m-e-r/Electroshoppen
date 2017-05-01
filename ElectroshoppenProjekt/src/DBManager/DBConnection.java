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
 *
 * @author Jacob
 */
public class DBConnection {

    private static Connection con = null;
    
    public DBConnection() {
	String url = "jdbc:postgresql://localhost:5432/EksamensProjektF17";
	String user = "postgres";
	String password = "sejfyr42";
	
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

    public static ResultSet runQuery(String query) {
	//RUN AN EXAMPLE QUERY
	try {
	    Statement st = con.createStatement();
	    return st.executeQuery(query);
	} catch (SQLException e) {
	    e.printStackTrace();
	}
	return null;
    }
}
