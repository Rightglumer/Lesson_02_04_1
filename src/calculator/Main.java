package calculator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class Main extends Application {

    private static void digitKeyPressed(KeyEvent e) {
        if (e.getCode().isDigitKey()) {
//            Controller.addTextDigit(e.getCode().toString());
        }
    }

    @Override
        public void start(Stage primaryStage) throws Exception{
            Parent root = FXMLLoader.load(getClass().getResource("FormCalculator.fxml"));
            Scene scene = new Scene(root, 300, 400);
            scene.setOnKeyPressed(Main::digitKeyPressed);
            primaryStage.setTitle("Easy calculator 2.0");
            primaryStage.setScene(scene);
            primaryStage.setMinWidth(300);
            primaryStage.setMinHeight(400);
            primaryStage.setMaxWidth(500);
            primaryStage.setMaxHeight(600);
            primaryStage.show();
        }

        public static void main(String[] args) {
            launch(args);
        }
}
