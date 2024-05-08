
package calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.net.URL;
import java.util.ResourceBundle;

/**
 *
 * @author
 */
public class CalculatorController implements Initializable
{
    // Composition instance variables
    String currentVal = "";
    RPNModel rpn;

    @FXML
    private Button buttonZero;

    @FXML
    private Button buttonOne;

    @FXML
    private Button buttonTwo;

    @FXML
    private Button buttonThree;

    @FXML
    private Button buttonPlus;

    @FXML
    private Button buttonFive;

    @FXML
    private Button buttonSix;

    @FXML
    private Button buttonMinus;

    @FXML
    private Button buttonFour;

    @FXML
    private Button buttonSeven;

    @FXML
    private Button buttonEight;

    @FXML
    private Button buttonNine;

    @FXML
    private Button buttonMultiply;

    @FXML
    private Button buttonSign;

    @FXML
    private Button buttonDivide;


    @FXML
    private TextArea display;

    @FXML
    private Button buttonEnter;

    @FXML
    private Button buttonDrop;

    @FXML
    private Label errorMessage;

    /**
     * Drop the top value on the stack
     * @param event - not used
     */
    @FXML
    void buttonDropClick(ActionEvent event) {
        if (currentVal.equals("")) {
            if (!rpn.drop()) {
                updateDisplay("No Value to Drop");
                return;
            }
        }
        else
        {
            currentVal = currentVal.substring(0,currentVal.length()-1);
        }
        updateDisplay();
    }

    /**
     * Push the entered value onto the stack
     * @param event - not used
     */
    @FXML
    void buttonEnterClick(ActionEvent event) {
        try {
            if (currentVal.length() == 0) { // if nothing in queue copy top of stack
                boolean status = rpn.enter(rpn.getTop());
                if (!status)
                    updateDisplay("Stack Full");
                else
                    updateDisplay();
            }
            else { // else
                try {
                    boolean status = rpn.enter(Integer.parseInt(currentVal));
                    currentVal = "";
                    updateDisplay();
                    if (!status)
                        updateDisplay("Stack Full");
                } catch (Exception e) {
                    updateDisplay("Invalid Value");
                }
            }
        }
        catch (Exception e)
        {
            // stack empty - silently ignore
        }
    }

    /**
     * 5 button handler
     * @param event
     */
    @FXML
    void buttonFiveClick(ActionEvent event) {
        currentVal = currentVal + "5";
        updateDisplay();
    }

    /**
     * 4 button handler
     * @param event - not used
     */
    @FXML
    void buttonFourClick(ActionEvent event) {
        currentVal = currentVal + "4";
        updateDisplay();
    }

    /**
     * 1 button handler
     * @param event - not used
     */
    @FXML
    void buttonOneClick(ActionEvent event) {
        currentVal = currentVal + "1";
        updateDisplay();
    }

    /**
     * TODO: Complete the 7 button handler
     * @param event
     */
    @FXML
    void buttonSevenClick(ActionEvent event) {
        currentVal = currentVal + "7";
        updateDisplay();
    }

    /**
     * 6 button handler
     * @param event - not used
     */
    @FXML
    void buttonSixClick(ActionEvent event) {
        currentVal = currentVal + "6";
        updateDisplay();
    }

    /**
     * TODO: Complete the 3 button handler
     * @param event - unused
     */
    @FXML
    void buttonThreeClick(ActionEvent event) {
        currentVal = currentVal + "3";
        updateDisplay();
    }

    /**
     * 2 button handler
     * @param event - not used
     */
    @FXML
    void buttonTwoClick(ActionEvent event) {
        currentVal = currentVal + "2";
        updateDisplay();
    }

    /**
     * TODO: Complete the zero button
     * @param event
     */
    @FXML
    void buttonZeroClick(ActionEvent event) {
        currentVal = currentVal + "0";
        updateDisplay();
    }

    /**
     * TODO: Complete the + operation
     * @param event
     */
    @FXML
    void buttonPlusClick(ActionEvent event) {
        checkCursor();
        if (!rpn.add()) displayErrorMessage("ERROR: Insufficient Operands");
        else updateDisplay();
    }

    @FXML
    void buttonMinusClick(ActionEvent event) {
        checkCursor();
        if (!rpn.subtract())
            displayErrorMessage("ERROR: Insufficient Operands");
        else
            updateDisplay();
    }

    /**
     * TODO: Complete the divide operation
     * @param event - unused
     */
    @FXML
    void buttonDivideClick(ActionEvent event) throws Exception {
        try {
            checkCursor();
            if (!rpn.divide()) displayErrorMessage("ERROR: Insufficient Operands");
            else updateDisplay(); }
        catch (Exception exception) {
            displayErrorMessage("ERROR: Cannot divide by 0");
        }
    }

    /**
     * Multiply operation
     * @param event - not used
     */
    @FXML
    void buttonMultiplyClick(ActionEvent event) {
        checkCursor();
        if (!rpn.multiply())
            displayErrorMessage("ERROR: Insufficient Operands for Multiply");
        else
            updateDisplay();
    }

    /**
     * TODO: Complete the sign change event handler
     * @param event
     */
    @FXML
    void buttonSignClick(ActionEvent event) {
        checkCursor();
        if (!rpn.changeSign()) displayErrorMessage("ERROR: Stack is Empty");
        else updateDisplay();
    }

    /**
     * 8 button handler
     * @param event
     */
    @FXML
    void buttonEightClick(ActionEvent event) {
        currentVal = currentVal + "8";
        updateDisplay();
    }


    /**
     * 9 button handler
     * @param event - unused
     */
    @FXML
    void buttonNineClick(ActionEvent event) {
        currentVal = currentVal + "9";
        updateDisplay();
    }

    /**
     * Displays an error message at the bottom
     * @param msg - error to display
     */
    void displayErrorMessage(String msg)
    {
        errorMessage.setText(msg);
    }

    /**
     * Updates the display and clears the error indicator
     */
    public void updateDisplay(String errorMessage) {
        updateDisplay();
        displayErrorMessage(errorMessage);
    }


    public void updateDisplay()
    {
        try {
            StringBuilder sb = new StringBuilder();
            int[] stack = rpn.getValues();
            int rows = 8;
            for (int i = 0; i < rows - stack.length + 1; i++) {
                sb.append('\n'); // top rows to blank line
            }
            for (int i = 0; i < stack.length; i++) {
                sb.append(Integer.toString(stack[i]) + '\n');
            }
            display.setText(sb.toString() + currentVal);
            errorMessage.setText("");
        }
        catch(Exception e)
        {
            displayErrorMessage(e.getMessage());
        }
    }

    /**
     * If a value has been entered, it is pushed on the stack. If not, no action is taken.
     */
    private void checkCursor()
    {
        if (currentVal.length() > 0) {
            try {
                if (rpn.enter(Integer.parseInt(currentVal)))
                    currentVal = "";

            }
            catch (Exception e) // shouldn't happen
            {
                displayErrorMessage("ERROR: Invalid Value");
            }
        }
    }

    /** GUI Initialization
     *
     * @param url - not used
     * @param rb - not used
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        rpn = new RPNModel();
        display.setFont(Font.font("System", FontWeight.NORMAL, 12));
        display.setPrefRowCount(11);
    }
}
