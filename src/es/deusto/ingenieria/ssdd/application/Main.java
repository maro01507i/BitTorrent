package es.deusto.ingenieria.ssdd.application;
	
import es.deusto.ingenieria.ssdd.controller.TrackerListController;
import es.deusto.ingenieria.ssdd.utilities.WindowUtilities;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			//Load the chosen FXML 
			Pane page =  FXMLLoader.load(getClass().getResource("/fxml/DisplayTrackerInfo.fxml")); 
			
			Scene scene = new Scene(page);

			//Css addition 
			scene.getStylesheets().add(getClass().getResource("/css/application.css").toExternalForm());
		
			
			//Used to close the session (if the user forces to close it)
			primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
				@Override public void handle(WindowEvent t) {
					TrackerListController.checkTrackerList = false;
					System.out.println("User exited the platform");
				}
			});

			//Icon
			primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/images/appIcon.png")));

			//Title to the window
			primaryStage.setTitle("Tracker info");

			primaryStage.setScene(scene);

			//No allowing to resize the window
			primaryStage.setResizable(false);

			primaryStage.initStyle(StageStyle.UTILITY);


			primaryStage.sizeToScene();

			primaryStage.show();
			
			WindowUtilities.centerWindow(primaryStage);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
