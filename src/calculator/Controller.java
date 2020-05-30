package calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;

public class Controller {
    public String CHAR_DOT = ",";
    public String CHAR_MINUS_BUTTON = "±";
    public String CHAR_MINUS = "-";
    public final String ACTION_DIVIDE = "/";
    public final String ACTION_MINUS = "-";
    public final String ACTION_PLUS = "+";
    public final String ACTION_MULTIPLICATION = "x";
    public final String ACTION_CALC = "=";

    @FXML
    public TextArea res;
    @FXML
    public TextArea txtAction;
    @FXML
    public TextArea txtSubTotal;

    public void addTextDigit(String newText){
        String curText = res.getText();
        if (newText.equals(CHAR_DOT)) {
            if (curText.indexOf(CHAR_DOT) != -1) {
                return;
            }
            if (curText.isEmpty()) {
                curText = "0";
            }
        }
        if (newText.equals(CHAR_MINUS_BUTTON)) {
            if (curText.indexOf(CHAR_MINUS) == -1) {
                curText = CHAR_MINUS + curText;
            } else {
                curText = curText.substring(1, curText.length());
            }
            newText = "";
        }
        curText += newText;
        res.setText(curText);
    }

    public void btnMainClick(ActionEvent actionEvent) {
        // get text from button class
        String btnText = ((Button) actionEvent.getSource()).getText();
        addTextDigit(btnText);
    }

    public void btnClearClick(ActionEvent actionEvent) {
        res.setText("");
        txtAction.setText("");
        txtSubTotal.setText("");
    }

    private void calcAction(String actionString){
        String curAction = txtAction.getText();
        Double curResult;
        Double newResult;
        if (txtSubTotal.getText().isEmpty()) {
            curResult = 0.0;
        } else {
            curResult = Double.valueOf(txtSubTotal.getText());
        }
        if (res.getText().isEmpty()) {
            newResult = 0.0;
        } else {
            newResult = Double.valueOf(res.getText());
        }
        if (curAction.isEmpty() && curResult == 0) {
            curResult = newResult;
        } else {
            switch (curAction) {
                case ACTION_DIVIDE:
                    if (newResult != 0) {
                        curResult /= newResult;
                    }
                    break;
                case ACTION_MINUS:
                    curResult -= newResult;
                    break;
                case ACTION_MULTIPLICATION:
                    curResult *= newResult;
                    break;
                case ACTION_PLUS:
                    curResult += newResult;
                    break;
                default:
                    txtAction.setText(actionString);
                    break;
            }
        }
        if (!actionString.equals(ACTION_CALC)) {
            txtAction.setText(actionString);
        } else {
            txtAction.setText("");
        }
        txtSubTotal.setText(String.valueOf(curResult));
        res.setText("");
    }

    public void btnActionClick(ActionEvent actionEvent) {
        // get text from button class
        String btnText = ((Button) actionEvent.getSource()).getText();
        calcAction(btnText);
    }

    public void btnPrcClick(ActionEvent actionEvent) {
        if (!res.getText().isEmpty()) {
            Double curRes = Double.valueOf(res.getText()) / 100.0;
            res.setText(String.valueOf(curRes));
        }
    }
}
