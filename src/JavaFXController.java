import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;


/**
 * Class controller for the JavaFX framework of the S10_arabicToRomanGUI_Hard assignment for SWD Fall 2021
 * @author aezouhri
 */
public class JavaFXController {


    /**
     * TextField where the arabic number will be displayed
     */
    @FXML
    private TextField ArabicText = new TextField();

    /**
     * TextField where the roman number will be displayed
     */
    @FXML
    private TextField RomanText = new TextField();


    /**
     * Reads the input in the RomanText TextField, converts it in arabic using methods from ArabicToRoman.java
     * and displays it in the ArabicText
     *
     * @param event1 detects when a key is hit on the keyboard
     */
    @FXML
    public void romanToArabic(KeyEvent event1) {

        if (((TextField) event1.getSource()).getText().equals("")) {
            ArabicText.setText("");
        } else {

            String user_input = ((TextField) event1.getSource()).getText();

            ArabicToRoman Object1 = new ArabicToRoman(user_input);

            int arabic_number = Object1.toArabic();
            String arab_num = Integer.toString(arabic_number);
            Object1.setRoman(user_input);

            boolean test = Object1.toArabicChecker();
            if (test) {
                ArabicText.setText(arab_num);
            } else {
                ArabicText.setText("Error wrong roman number");

            }

        }


    }


    /**
     * Reads the input in the ArabicText TextField, converts it in roman using methods from ArabicToRoman.java
     * and displays it in the RomanText
     *
     * @param event detects when a key is hit on the keyboard
     */
    @FXML
    public void arabicToRoman(KeyEvent event) {

        try {
            if (((TextField) event.getSource()).getText().equals("")) {
                RomanText.setText("");
            } else {
                int arabic_input = Integer.parseInt(((TextField) event.getSource()).getText());
                ArabicToRoman Object = new ArabicToRoman(arabic_input);
                RomanText.setText(Object.toRoman());
            }
        } catch (NumberFormatException e) {
            RomanText.setAlignment(Pos.CENTER_LEFT);
            RomanText.setText("Error enter a digit");

        }

    }


}