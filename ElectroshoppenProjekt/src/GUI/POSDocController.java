/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Authentication.Authenticateable;
import Authentication.Create;
import Facade.Facade;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.DoubleValidator;
import com.jfoenix.validation.NumberValidator;
import com.jfoenix.validation.RequiredFieldValidator;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import WEBSHOP.Address;
import WEBSHOP.Profiles.CustomerProfile;
import WEBSHOP.Profiles.Profile;
import com.jfoenix.controls.JFXTextArea;

/**
 * FXML Controller class
 *
 * @author Kasper
 */
public class POSDocController implements Initializable {

    private RequiredFieldValidator textValidator;
    private NumberValidator numberValidator;
    private String crFirstName, crLastName, crPhoneNumber, crEmail, crStreetName,
	    crStreetNumber, crSecAddress, crZipCode, crCity, crPassword;
    private Authenticateable authen;
    private Address crAddress;
    private Facade facade;

    @FXML
    private JFXTextField crStreetNameTF;
    @FXML
    private JFXTextField crStreetNumberTF;
    @FXML
    private JFXTextField crFirstNameTF;
    @FXML
    private JFXTextField crLastNameTF;
    @FXML
    private JFXTextField crPhoneNumberTF;
    @FXML
    private JFXTextField crZipCodeTF;
    @FXML
    private JFXTextField crCityTF;
    @FXML
    private JFXPasswordField crPasswordTF;
    @FXML
    private JFXButton crRegisterBtn;
    @FXML
    private Label crErrorLabel;
    @FXML
    private JFXTextField crSecAddressTF;
    @FXML
    private JFXTextField crEmailTF;
    @FXML
    private JFXTextField inputEmailTextField;
    @FXML
    private JFXButton searchButton;
    @FXML
    private JFXTextArea customerInfoTextArea;
    @FXML
    private Label infoLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
	this.facade = new Facade();
    }

    @FXML
    private void handleRegister(ActionEvent event) {
	if (this.validateFirstName() & this.validateLastName() & this.validatePhoneNumber()
		& this.validateEmail() & this.validateStreetName() & this.validateStreetNumber()
		& this.validateZipCode() & this.validateCity() & this.validatePassword()) {

	    this.crAddress = new Address(this.crStreetName, this.crStreetNumber,
		    this.crSecAddressTF.getText(), this.crZipCode, this.crCity);

	    String fullName = this.crFirstName + " " + this.crLastName; //Should be fixed in Create and Profile classes

	    this.authen = new Create(fullName, this.crEmail, this.crPhoneNumber, this.crAddress, this.crPassword, "");
	    if (this.authen.createUser("employee")) {
		this.crErrorLabel.setText("Du er nu oprettet!");
		this.crFirstNameTF.clear();
		this.crLastNameTF.clear();
		this.crPhoneNumberTF.clear();
		this.crEmailTF.clear();
		this.crStreetNameTF.clear();
		this.crStreetNumberTF.clear();
		this.crSecAddressTF.clear();
		this.crZipCodeTF.clear();
		this.crCityTF.clear();
		this.crPasswordTF.clear();

	    } else {
		this.crErrorLabel.setText("Du kunne ikke oprettes.");
		this.crPasswordTF.clear();
	    }
	}
    }

    private boolean validateFirstName() {
	this.textValidator = new RequiredFieldValidator();
	this.textValidator.setStyle("-jfx-text-inner-color: red;");
	this.textValidator.setMessage("Mangler navn!");

	this.crFirstNameTF.getValidators().add(this.textValidator);

	if (!this.crFirstNameTF.validate()) {
	    this.crFirstNameTF.setStyle("-jfx-unfocus-color: red;");
	    this.crFirstNameTF.clear();
	    this.crFirstName = "";
	    return false;

	} else {
	    this.crFirstNameTF.setStyle("-jfx-unfocus-color: green;");
	    this.crFirstName = this.crFirstNameTF.getText();
	    return true;
	}
    }

    private boolean validateLastName() {
	this.textValidator = new RequiredFieldValidator();
	this.textValidator.setStyle("-jfx-text-inner-color: red;");
	this.textValidator.setMessage("Mangler navn!");

	this.crLastNameTF.getValidators().add(this.textValidator);

	if (!this.crLastNameTF.validate()) {
	    this.crLastNameTF.setStyle("-jfx-unfocus-color: red;");
	    this.crLastNameTF.clear();
	    this.crLastName = "";
	    return false;

	} else {
	    this.crLastNameTF.setStyle("-jfx-unfocus-color: green;");
	    this.crLastName = this.crLastNameTF.getText();
	    return true;
	}
    }

    private boolean validatePhoneNumber() {
	this.numberValidator = new NumberValidator();
	this.numberValidator.setStyle("-jfx-text-inner-color: red;");
	this.numberValidator.setMessage("fx: 12345678");

	this.crPhoneNumberTF.getValidators().add(this.numberValidator);

	if (!this.crPhoneNumberTF.validate()) {
	    this.crPhoneNumberTF.setStyle("-jfx-unfocus-color: red;");
	    this.crPhoneNumberTF.clear();
	    this.crPhoneNumber = null;
	    return false;

	} else if (this.crPhoneNumberTF.getText().length() != 8) {
	    this.crPhoneNumberTF.clear();
	    this.crPhoneNumberTF.validate();
	    return false;

	} else {
	    this.crPhoneNumberTF.setStyle("-jfx-unfocus-color: green;");
	    this.crPhoneNumber = this.crPhoneNumberTF.getText();
	    return true;
	}
    }

    private boolean validateEmail() {
	this.textValidator = new RequiredFieldValidator();
	this.textValidator.setStyle("-jfx-text-inner-color: red;");
	this.textValidator.setMessage("Mangler by!");

	this.crEmailTF.getValidators().add(this.textValidator);

	if (!this.crEmailTF.validate()) {
	    this.crEmailTF.setStyle("-jfx-unfocus-color: red;");
	    this.crEmailTF.clear();
	    this.crEmail = "";
	    return false;

	} else {
	    this.crEmailTF.setStyle("-jfx-unfocus-color: green;");
	    this.crEmail = this.crEmailTF.getText();
	    return true;
	}
    }

    private boolean validateStreetName() {
	this.textValidator = new RequiredFieldValidator();
	this.textValidator.setStyle("-jfx-text-inner-color: red;");
	this.textValidator.setMessage("Mangler vejnavn!");

	this.crStreetNameTF.getValidators().add(this.textValidator);

	if (!this.crStreetNameTF.validate()) {
	    this.crStreetNameTF.setStyle("-jfx-unfocus-color: red;");
	    this.crStreetNameTF.clear();
	    this.crStreetName = "";
	    return false;

	} else {
	    this.crStreetNameTF.setStyle("-jfx-unfocus-color: green;");
	    this.crStreetName = this.crStreetNameTF.getText();
	    return true;
	}
    }

    private boolean validateStreetNumber() {
	this.numberValidator = new NumberValidator();
	this.numberValidator.setStyle("-jfx-text-inner-color: red;");
	this.numberValidator.setMessage("Mangler nr!");

	this.crStreetNumberTF.getValidators().add(this.numberValidator);

	if (!this.crStreetNumberTF.validate()) {
	    this.crStreetNumberTF.setStyle("-jfx-unfocus-color: red;");
	    this.crStreetNumberTF.clear();
	    this.crStreetNumber = "";
	    return false;

	} else {
	    this.crStreetNumberTF.setStyle("-jfx-unfocus-color: green;");
	    this.crStreetNumber = this.crStreetNumberTF.getText();
	    return true;
	}
    }

    private boolean validateZipCode() {
	this.numberValidator = new NumberValidator();
	this.numberValidator.setStyle("-jfx-text-inner-color: red;");
	this.numberValidator.setMessage("fx: 1234");

	this.crZipCodeTF.getValidators().add(this.numberValidator);

	if (!this.crZipCodeTF.validate()) {
	    this.crZipCodeTF.setStyle("-jfx-unfocus-color: red;");
	    this.crZipCodeTF.clear();
	    this.crZipCode = null;
	    return false;

	} else if (this.crZipCodeTF.getText().length() != 4) {
	    this.crZipCodeTF.clear();
	    this.crZipCodeTF.validate();
	    return false;

	} else {
	    this.crZipCodeTF.setStyle("-jfx-unfocus-color: green;");
	    this.crZipCode = this.crZipCodeTF.getText();
	    return true;
	}
    }

    private boolean validateCity() {
	this.textValidator = new RequiredFieldValidator();
	this.textValidator.setStyle("-jfx-text-inner-color: red;");
	this.textValidator.setMessage("Mangler by!");

	this.crCityTF.getValidators().add(this.textValidator);

	if (!this.crCityTF.validate()) {
	    this.crCityTF.setStyle("-jfx-unfocus-color: red;");
	    this.crCityTF.clear();
	    this.crCity = "";
	    return false;

	} else {
	    this.crCityTF.setStyle("-jfx-unfocus-color: green;");
	    this.crCity = this.crCityTF.getText();
	    return true;
	}
    }

    private boolean validatePassword() {
	this.textValidator = new RequiredFieldValidator();
	this.textValidator.setStyle("-jfx-text-inner-color: red;");
	this.textValidator.setMessage("Mangler kodeord!");

	this.crPasswordTF.getValidators().add(this.textValidator);

	if (!this.crPasswordTF.validate()) {
	    this.crPasswordTF.setStyle("-jfx-unfocus-color: red;");
	    this.crPasswordTF.clear();
	    this.crPassword = "";
	    return false;

	} else {
	    this.crPasswordTF.setStyle("-jfx-unfocus-color: green;");
	    this.crPassword = this.crPasswordTF.getText();
	    return true;
	}
    }

    @FXML
    private void searchCustomer(ActionEvent event) {
	String[] foundProfile;
	String email = inputEmailTextField.getText();
	if (email.equals("")) {
	    infoLabel.setText("Venligst udfyld søgefeltet");
	} else {
	    foundProfile = this.facade.getCustomerInfo(email);
	    if (foundProfile[0] == null) {
		customerInfoTextArea.setText("Ingen kunde fundet med email: " + email);
	    } else {
		customerInfoTextArea.setText("Navn: " + foundProfile[0]
			+ "\nEmail: " + foundProfile[1]
			+ "\nTelefonnummer: " + foundProfile[2]
			+ "\nCVR (hvis virksomhed): " + foundProfile[3] 
			+ "\n\n\n Købshistorik: " 
			+ facade.getOrderHistory(email).toString());
	    }
	}
    }
}