/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import DBManager.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MER
 */
public class ElecetroshoppenProjekt extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //launch(args);
	
//	DBConnection dbc = new DBConnection();
//	System.out.println(dbc.toString());
//	System.out.println(dbc.getClass());
//	
	//Code to run query for database, should probably be chance, because the while loop should be
	//different for each function in the program. The execute should maybe be in the webshop package
//	DBConnection dbc = new DBConnection();
//	ResultSet select = dbc.runQuery("SELECT * FROM Component");
//	try {
//	    while (select.next()){
//		System.out.println(select.next());
//		
//	    }
//	} catch (SQLException ex) {
//	    Logger.getLogger(ElecetroshoppenProjekt.class.getName()).log(Level.SEVERE, null, ex);
//	}
	
    }
    
}
