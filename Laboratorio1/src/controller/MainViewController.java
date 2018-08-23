package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.Coprocessor;
import javafx.fxml.Initializable;

public class MainViewController implements Initializable{

	 @FXML
	    private Tab tabUser;

	    @FXML
	    private TextField txtValues;

	    @FXML
	    private Button btnSort;

	    @FXML
	    private Tab tabRamdon;

	    @FXML
	    private TextField txtAmount;

	    @FXML
	    private TextField txtStart;

	    @FXML
	    private TextField txtEnd;

	    @FXML
	    private ComboBox<String> cbTypes;

	    @FXML
	    private Button btnGenerate;
	    
	    @FXML
	    private TextArea areaNumbers;
	    
	    @FXML
	    private Button btnOrderRandom;
	    
	    @FXML
	    private Button btnAgregar;
	    
	    @FXML
	    private TextArea areaValues;
	    
	    /**
	     * Relations--------------
	     */
	    private Coprocessor processor;
	    
	    
	
	public MainViewController() {
			
			processor = new Coprocessor();
		}



	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		cbTypes.getItems().add("Generar valores ordenados");
		cbTypes.getItems().add("Generar valores ordenados inversamente");
		cbTypes.getItems().add("Generar valores en orden aleatorio");
		cbTypes.getItems().add("Generar valores en un porcentaje");
		
		
	}



	public String getTxtValues() {
		return txtValues.getText();
	}



	public void setTxtValues(String values) {
		txtValues.setText(values);
	}



	public String getTxtAmount() {
		return txtAmount.getText();
	}



	public void setTxtAmount(TextField txtAmount) {
		this.txtAmount = txtAmount;
	}



	public String getTxtStart() {
		return txtStart.getText();
	}



	public void setTxtStart(TextField txtStart) {
		this.txtStart = txtStart;
	}



	public String getTxtEnd() {
		return txtEnd.getText();
	}



	public void setTxtEnd(TextField txtEnd) {
		this.txtEnd = txtEnd;
	}



	public ComboBox<String> getCbTypes() {
		return cbTypes;
	}



	public void setCbTypes(ComboBox<String> cbTypes) {
		this.cbTypes = cbTypes;
	}
	
	
	
	public void setAreaNumbers(String numbers) {
		areaNumbers.setText(numbers);
	}



	public TextArea getAreaValues() {
		return areaValues;
	}



	public void setAreaValues(String values) {
		areaValues.setText(values);;
	}



	@FXML
    void generateNumbers(ActionEvent event) {
		System.out.println("click");
		int amount = Integer.parseInt(getTxtAmount());
		int min = Integer.parseInt(getTxtStart());
		int max = Integer.parseInt(getTxtEnd());
		processor.generateRandom(amount, min, max);
		setAreaNumbers(processor.toString());
		
    }
	
	@FXML
    void makeSort(ActionEvent event) {
		int amount = Integer.parseInt(getTxtAmount());
		int maxValue = Integer.parseInt(getTxtEnd());
//		processor.changeSize(amount);
		processor.bucketSort(maxValue);
		setAreaNumbers(processor.toString());
    }
	
	@FXML
    void sortNumbers(ActionEvent event) {
		processor.sortArrayList();
		setAreaValues(processor.getNumbersInt().toString());

    }
	

    @FXML
    void addValues(ActionEvent event) {
    	processor.addNumbersInt(Integer.parseInt(getTxtValues()));
    	setTxtValues("");
    	setAreaValues(processor.getNumbersInt().toString());
    }
	

}
