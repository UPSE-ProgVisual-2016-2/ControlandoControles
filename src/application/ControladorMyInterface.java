package application;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Slider;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class ControladorMyInterface {

	//Amarrar Controles FXML a Controlaodr
	@FXML Spinner<Integer> spinnerMinutosPaMorir;
	@FXML Slider sliderPoder;
	@FXML CheckBox checkProbarlo;
	@FXML public Button buttonMostrarValores;
	@FXML public TextField txtNombre;
	@FXML public TextField txtEdad;
	
	public void mostrarDatos()
	{
		//Poner Datos a Mostrar
		System.out.println("Vale Controlador");
		Integer minutosPaMorir = spinnerMinutosPaMorir.getValue();
		Integer poder =  (int) Math.round(sliderPoder.getValue());
		boolean quieresProbarlo = checkProbarlo.isSelected();
		
		System.out.println("Minutos Para morir: " + minutosPaMorir);
		System.out.println("Poder de juez@: " + poder);
		if(quieresProbarlo){
			System.out.println("Tu si quieres probarlo =)");
		}else{
			System.out.println("POrque no quieres probarlo @#$@#$! =<");
		}
	}
	
	public void validarTextoNumerico()
	{
		
		txtEdad.focusedProperty().addListener(new ChangeListener<Boolean>() {

			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				if(!newValue)
				{
					if(!txtEdad.getText().matches("\\d{1,3}"))
					{
						txtEdad.setText("");
					}
				}
				
			}
		});
	}
	
	public boolean validarTextoAlfabetico()
	{
		boolean valido = false;
		
		txtNombre.focusedProperty().addListener((arg0, oldValue, newValue) ->
				{
					if(!newValue)
					{
						if(!txtNombre.getText().matches("^[a-zA-Z]+[a-zA-Z|\\s]+"))
						{
							txtNombre.setText("");
						}
					}
				});
		return valido;
	}
	
	public void initialize()
	{
		buttonMostrarValores.addEventFilter(MouseEvent.MOUSE_CLICKED, 
				e -> {
					if(sliderPoder.getValue()<50)
					{
						System.out.println("Evento filtrado. "
								+ "No se puede mostrar valores de poder tan bajos.");
					}
				});
		validarTextoAlfabetico();
		validarTextoNumerico();
	}
}
