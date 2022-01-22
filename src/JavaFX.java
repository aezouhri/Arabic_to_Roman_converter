import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Opens a new window and runs the S10_arabicToRomanGUI_Hard assignment for SWD Fall 2021
 * @author aezouhri
 */
public class JavaFX extends Application {
    /**
     * Method to run the class.
     * @param args Java command.
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Starts a new stage for the application
     * @param primaryStage Stage for the GUI
     * @throws IOException Handles input/output failures
     */
    @Override
    public void start(Stage primaryStage) throws IOException {


        Parent root = FXMLLoader.load(getClass().getResource("MyJavaFX.fxml"));

        Scene scene = new Scene(root); // attach scene graph to scene
        primaryStage.setTitle("Arabic to Roman converter"); // displayed in window's title bar
        primaryStage.setScene(scene); // attach scene to stage
        primaryStage.show(); // display the stage


    }
}