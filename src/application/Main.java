package application;
	
import com.sun.javafx.scene.control.skin.TitledPaneSkin;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXMLLoader;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.Spinner;
import javafx.scene.control.TitledPane;
import javafx.scene.input.InputEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Group root = new Group();
			VBox verticalLayout = new VBox();
			Parent p = FXMLLoader.load(getClass().getResource("/MyInterface.fxml"));
			
			
			primaryStage.setTitle("Jueza APP");
			Button button = new Button("Prueba SAM");
			/*button.setOnAction(new EventHandler<ActionEvent>() {
				
				@Override
				public void handle(ActionEvent event) {
					System.out.println("Hola Soy un SAM");
					
				}
			});
			*/
			
			button.setOnAction( (ActionEvent event) -> System.out.println("hola soy una expresion lambda"));
			
			Button botonSalir = new Button("Salir");

			/*
			botonSalir.addEventFilter(MouseEvent.ANY, 
					e -> {	
							System.out.println("Entro al filtro de Evento");
							//Node tps =  p.getChildrenUnmodifiable().
							//TitledPane tp = (TitledPane) tps.getChildrenUnmodifiable().get(0);
							//GridPane gp = (GridPane) tp.getChildrenUnmodifiable().get(0);
							//System.out.println("Transformo el elemento a grilla");
							//Spinner<Integer> sp = (Spinner<Integer>) gp.getChildren().get(3);
							if(sp.getValue()<50)
							{
								System.out.println("Filtrando evento: no se puede salir con tan poco poder");
								e.consume();
								
							};
						});
			*/
			
			//creando un slider para poder de la policia
			HBox hBoxPoderPolicial = new HBox();
			Label labelSlider = new Label("Poder Policia");
			Slider slider = new Slider(0, 100, 3);
			hBoxPoderPolicial.getChildren().addAll(labelSlider, slider);
			
			
			slider.setOnMouseReleased(e -> System.out.println("Mi poder actual es de" + slider.getValue()));
			Popup pop = new Popup();
			pop.setFocused(true);
			pop.centerOnScreen();
			pop.setHeight(25);
			pop.setWidth(50);
			slider.setOnMouseEntered(e -> System.out.println("No cambiar este valor"));
			
			botonSalir.setOnAction( e -> System.exit(0));
			
			botonSalir.addEventFilter(MouseEvent.MOUSE_PRESSED, 
					e -> {
						if(slider.getValue()<50)
						{
							System.out.println("Tu poder es insignificante, moriras en 30 minutos");
							e.consume();
						}
					});
			
			/*
			botonSalir.addEventFilter(MouseEvent.MOUSE_PRESSED, 
					e -> {
						System.out.println("Filtrado Evento");
						e.consume();
					});
					*/
			verticalLayout.getChildren().add(p);
			verticalLayout.getChildren().add(hBoxPoderPolicial);
			verticalLayout.getChildren().add(button);
			verticalLayout.getChildren().add(botonSalir);
			root.getChildren().add(verticalLayout);
			
			verticalLayout.setOnMouseClicked( e -> System.out.println("Evento nivel 2"));
			verticalLayout.setOnMousePressed( new EventHandler<Event>() {

				@Override
				public void handle(Event event) {
					// TODO Auto-generated method stub
					String fuente = event.getTarget().toString();
					System.out.println("El evento viene de la destino: " + fuente);
				}
			});
			
			/*verticalLayout.addEventHandler(EventType.ROOT,
					e -> System.out.println("Evento nivel dios!"));
			*/

			
			Scene scene = new Scene(root,500,500);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	
	public static void main(String[] args) {
		launch(args);
	}
}
