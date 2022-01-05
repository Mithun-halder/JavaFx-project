import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class mainLogin extends Application {

    public static void main(String[] args) {
        launch(args);
    }

   public static Stage primaryStage;

    @Override
    public void start(Stage stage) throws IOException {

        primaryStage=stage;

        Parent root= FXMLLoader.load(getClass().getResource("login.fxml"));

        Scene scene=new Scene(root);



        stage.setScene(scene);

        stage.setResizable(false);

        stage.show();
    }

}
