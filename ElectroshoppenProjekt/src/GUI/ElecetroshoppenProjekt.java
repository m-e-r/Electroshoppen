/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Authentication.Authenticateable;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 *
 * @author MER
 */
public class ElecetroshoppenProjekt extends Application {

    Authenticateable authen;

    @Override
    public void start(Stage stage) throws Exception {
	Parent root = FXMLLoader.load(getClass().getResource("startFXML.fxml"));
	Scene scene = new Scene(root);
	stage.setScene(scene);
	stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
	launch(args);

//	DBConnection dbc = new DBConnection();
//	 
//	 
//	
	//Code to run query for database, should probably be chance, because the while loop should be
	//different for each function in the program. The execute should maybe be in the webshop package
//	DBConnection dbc = new DBConnection();
//	ResultSet select = dbc.runQuery("SELECT * FROM Component");
//	try {
//	    while (select.next()){
//		 
//		
//	    }
//	} catch (SQLException ex) {
//	    Logger.getLogger(ElecetroshoppenProjekt.class.getName()).log(Level.SEVERE, null, ex);
//	}
    }

}
