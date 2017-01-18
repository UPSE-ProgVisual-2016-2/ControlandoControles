package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Slider;
import javafx.scene.control.Spinner;

public class ControladorMyInterface {

	//Amarrar Controles FXML a Controlaodr
	@FXML Spinner<Integer> spinnerMinutosPaMorir;
	@FXML Slider sliderPoder;
	@FXML CheckBox checkProbarlo;
	@FXML Button buttonMostrarValores;
	
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
}
