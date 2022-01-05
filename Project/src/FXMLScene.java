import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;


import java.io.IOException;

public class FXMLScene {
     Parent root = null;
     Object controller = null;

    public static FXMLScene load(String fxmlpath) {

       FXMLScene fxmlScene = new FXMLScene();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(fxmlScene.getClass().getResource(fxmlpath));
        try {
            fxmlScene.root = loader.load();
            fxmlScene.controller = loader.getController();// get the controller class of new scene
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fxmlScene;
    }
}
