package pkgApp.controller;

import java.net.URL;
import java.util.ResourceBundle;
import pkgApp.*;
import pkgCore.*;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import pkgApp.RetirementApp;
import javafx.scene.control.Label;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class RetirementController implements Initializable {

		
	private RetirementApp mainApp = null;
	
	@FXML
	private TextField txtYearsToWork;
	@FXML
	private TextField txtAnnualReturnWorking;
	@FXML
	private TextField txtYearsRetired;
	@FXML
	private TextField txtAnnualReturnRetired;
	@FXML
	private TextField txtRequiredIncome;
	@FXML
	private TextField txtMonthlySSI;
	@FXML 
	private Label lblSaveEachMonth;
	@FXML
	private Label lblTotalAmountToSave;
	
	

	public RetirementApp getMainApp() {
		return mainApp;
	}

	public void setMainApp(RetirementApp mainApp) {
		this.mainApp = mainApp;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {		
	}
	
	@FXML
	public void btnClear(ActionEvent event) {
		System.out.println("Clear pressed");
		
		txtYearsToWork.setText("");
		txtAnnualReturnWorking.setText("");
		txtYearsRetired.setText("");
		txtAnnualReturnRetired.setText("");
		txtRequiredIncome.setText("");
		txtMonthlySSI.setText("");
		lblSaveEachMonth.setText("");
		lblTotalAmountToSave.setText("");
	}
	
	@FXML
	public void btnCalculate(ActionEvent event) {
		
		//check the inputs before you run the actual calculations
		testInput(txtAnnualReturnRetired.getText());
		testInput(txtAnnualReturnWorking.getText());
		testInput(txtMonthlySSI.getText());
		testInput(txtRequiredIncome.getText());
		testInput(txtYearsRetired.getText());
		testInput(txtYearsToWork.getText());
		
		
		
		Retirement rt = new Retirement();
		rt.setdAnnualReturnRetired(Double.parseDouble(txtAnnualReturnRetired.getText()));
		rt.setdAnnualReturnWorking(Double.parseDouble(txtAnnualReturnWorking.getText()));
		rt.setdMonthlySSI(Double.parseDouble(txtMonthlySSI.getText()));
		rt.setdRequiredIncome(Double.parseDouble(txtRequiredIncome.getText()));
		rt.setiYearsRetired(Integer.parseInt(txtYearsRetired.getText()));
		rt.setiYearsToWork(Integer.parseInt(txtYearsToWork.getText()));
		
		lblTotalAmountToSave.setText((rt.TotalAmountSaved() * -1) + "");
		lblSaveEachMonth.setText(rt.AmountToSave() + "");
		
		
		
	}
	
	
	//A method to run the inputs through to ensure they are numeric
	private void testInput(String input)
	{
		try {
			Double.parseDouble(input);
		}
		catch (Exception e) {
			
			//The input was not a Double
			
			Alert alert = new Alert(AlertType.WARNING);
			alert.initOwner(mainApp.getPrimaryStage());
			alert.setTitle("Bad Input Type");
			alert.setHeaderText("Please Input Only Numbers");
			alert.setContentText("Input a Valid Number");
			alert.showAndWait();
		}
	}
	
}
