package application;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TitledPane;
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
			botonSalir.setOnAction( e -> System.exit(0));
			
			verticalLayout.getChildren().add(p);
			verticalLayout.getChildren().add(button);
			verticalLayout.getChildren().add(botonSalir);
			root.getChildren().add(verticalLayout);
			
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
