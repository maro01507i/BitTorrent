package es.deusto.ingenieria.ssdd.utilities;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;
import java.util.Optional;

import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.stage.Modality;
import javafx.stage.Stage;
/**Utilities class for windows. All the general method (that are standard for all windows) are located in here<br>
 * @author asier.gutierrez
 */
public class WindowUtilities {

	//Class´s logger

	/**Method for transist from one window to the other.
	 * @param fileName: Name without extension by which
 	 * the file is Known in the classpath. Only the name is requested because 
	 * all the windows to be loaded are located in the windows package.
 	 * If it is outside the windows package, the method must be redefined 
	 * by applying a correct path.
	 * @param event: Event that makes the transition from one window to other.
	 * The event must have occurred in the window in which you want to
	 * make the transition
	 */

	public static void windowTransition(String fileName, Event event) {
		Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		Parent panel = null;
		try {
			panel = FXMLLoader.load(WindowUtilities.class.getResource("/fxml/"+fileName+".fxml"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		app_stage.setScene(new Scene((Parent) panel));
		//centerWindow(app_stage);
	}
	

	/**Method for closing a window. To center the window is necessary
	 * that the window is displayed, if not, it will appear in the upper left corner.
	 * @param frame: form the Stage class. This is the window that you want to center.
	 */
	public static void centerWindow(Stage frame) {
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
		int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
		frame.setX(x);
		frame.setY(y);
	}


	public static void terminateApp(Event event) {
		Alert alert = new Alert(AlertType.CONFIRMATION);

		alert.setTitle("Terminate app");

		alert.setHeaderText("Are you sure?");

		alert.setContentText("This will terminate the app. Are you sure?");


		alert.initModality(Modality.APPLICATION_MODAL);

		alert.initOwner((Stage) ((Node) event.getSource()).getScene().getWindow());

		Optional<ButtonType> result = alert.showAndWait();


		if (result.get() == ButtonType.OK){
			//TODO: routine to terminate app
			System.out.println("User exited");
			System.exit(0);
		}
		
	}

	


}