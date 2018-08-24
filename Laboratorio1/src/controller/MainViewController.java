package controller;

import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.Coprocessor;
import javafx.fxml.Initializable;

public class MainViewController implements Initializable {
	public static final String[] CB_ELEMENTS = { "Generar valores ordenados", "Generar valores ordenados inversamente",
			"Generar valores en orden aleatorio", "Generar valores en un porcentaje" };

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
	
    @FXML
    private Label lblPercent;

    @FXML
    private TextField txtPercent;
	/**
	 * Relations--------------
	 */
	private Coprocessor processor;

	
	private int option;
	public MainViewController() {
		
		option = 0;

		processor = new Coprocessor();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		lblPercent.setVisible(false);
		txtPercent.setVisible(false);
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

	public String getCbTypes() {
		return cbTypes.getValue();
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
		areaValues.setText(values);
		;
	}

	@FXML
	void generateNumbers(ActionEvent event) {
		

		try {
			int amount = Integer.parseInt(getTxtAmount());
			int min = Integer.parseInt(getTxtStart());
			int max = Integer.parseInt(getTxtEnd());			
			if (getCbTypes().equals(CB_ELEMENTS[0])) {
				System.out.println("opcion 1");
				option = 1;
				
				processor.generateRandom(amount, min, max, 0);
				int[] arr = processor.countingSort(processor.getArrNumInt());
				setAreaNumbers(Arrays.toString(arr));
//				setAreaNumbers(processor.toString());
			} else if (getCbTypes().equals(CB_ELEMENTS[1])) {
				option = 2;
			} else if (getCbTypes().equals(CB_ELEMENTS[2])) {
				option = 3;
				processor.generateRandom(amount, min, max, 0);
				setAreaNumbers(processor.toString());
			} else {
				option = 4;
				int percent = ((Integer.parseInt(txtPercent.getText()))*amount)/100;
				int [] arr = processor.generateRandomA(amount, min, max, 0);
				
			}
			
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Debe escribir numeros en todos los campos");
		}
		

	}

	// Method to sort numbers generated randomly
	@FXML
	void makeSort(ActionEvent event) {

		if (processor.getArrNumInt().length == 0) {
			JOptionPane.showMessageDialog(null, "Genere los números a ordenar primero");
		} else {
			int[] arr = processor.countingSort(processor.getArrNumInt());
			setAreaNumbers(Arrays.toString(arr));
		}
//		if (getCbTypes() != null) {
//			
//		} else {
//			JOptionPane.showMessageDialog(null, "Seleccion una forma de ordenar");
//
//		}
		

//			int amount = Integer.parseInt(getTxtAmount());
//			int maxValue = Integer.parseInt(getTxtEnd());
//			processor.bucketSort(maxValue);
//			setAreaNumbers(processor.toString());

	}

	// Method to sort values inserted by the user
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
	
	@FXML
    void verifyOption(ActionEvent event) {
		if (getCbTypes().equals(CB_ELEMENTS[3])) {
			lblPercent.setVisible(true);
			txtPercent.setVisible(true);
		}
    }

}
