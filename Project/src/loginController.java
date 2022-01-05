import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class loginController implements Initializable {

    @FXML
    private Button create_acc_btn;

    @FXML
    private Button adminLogin;

    @FXML
    private Button login_btn;

    @FXML
    private PasswordField tf_password;

    @FXML
    private TextField tf_username;

    @FXML
    ChoiceBox choiceLoginType;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
       ObservableList<String> choice = FXCollections.observableArrayList("Student", "Admin");
       choiceLoginType.setItems(choice);
    }

    @FXML
    void loginAction(ActionEvent event) throws SQLException {


        if (choiceLoginType.getValue() == "Student") {

            String username = tf_username.getText();
            String password = tf_password.getText();

            Connection connection= MySQLJDBCUtil.getConnection();
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * from loginInfo;");

            while (resultSet.next()) {

                if (username.equals(resultSet.getString("username")) && password.equals(resultSet.getString("password"))) {



                    Parent root = null;
                    FXMLScene fxmlScene = FXMLScene.load("StudentProfile.fxml");
                    root = fxmlScene.root;

                    StudentProfileController controller = (StudentProfileController) fxmlScene.controller;
                    Scene scene = new Scene(root);
                    mainLogin.primaryStage.setScene(scene);

                    controller.textName.setText(resultSet.getString(2));
                    controller.textId.setText(resultSet.getString(1));
                    controller.textContact.setText(resultSet.getString(6));
                    controller.textEmail.setText(resultSet.getString(7));

                    // controller.profile_username.setText(username);


                    break;

                }

            }

        } else if (choiceLoginType.getValue() == "Admin") {

            String username= tf_username.getText();
            String password=tf_password.getText();

            Connection connection = MySQLJDBCUtil.getConnection();
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * from admin;");

            while (resultSet.next()) {

                if (username.equals(resultSet.getString("username")) && password.equals(resultSet.getString("password"))) {

                    Parent root = null;
                    FXMLScene fxmlScene = FXMLScene.load("Admin.fxml");
                    root = fxmlScene.root;

                    AdminController controller = (AdminController) fxmlScene.controller;
                    Scene scene = new Scene(root);
                    mainLogin.primaryStage.setScene(scene);

                    // controller.profile_username.setText(username);


                    break;


                }

            }


        }

    }




}




