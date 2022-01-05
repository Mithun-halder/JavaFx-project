import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.ConnectException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class AdminController implements Initializable {

    @FXML
    private Button addNewStudent;

    @FXML
    private Label adminName;

    @FXML
    private Button loadData;

    @FXML
    private TextField stContact;

    @FXML
    private TextField stEmail;

    @FXML
    private TextField stFirstName;

    @FXML
    private TextField stId;

    @FXML
    private TextField stLastName;

    @FXML
    private TextField stUsername;

    @FXML
    private TextField stPassword;


    @FXML
    private TableView<StudentData> studentTable;

    @FXML
    private TableColumn<StudentData, String> dataContact;

    @FXML
    private TableColumn<StudentData, String> dataEmail;

    @FXML
    private TableColumn<StudentData, String> dataFirstname;

    @FXML
    private TableColumn<StudentData, String> dataId;

    @FXML
    private TableColumn<StudentData, String> dataLastname;

    @FXML
    private TableColumn<StudentData, String> dataUsername;

    @FXML
    private TableColumn<StudentData, String> dataPassword;

    ObservableList<StudentData>data;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


    }

    @FXML
    public void loadStudentData(ActionEvent event) throws SQLException {

        Connection conn = MySQLJDBCUtil.getConnection();
        this.data= FXCollections.observableArrayList();

        ResultSet rs= conn.createStatement().executeQuery("SELECT *From loginInfo");
        while (rs.next()){
            this.data.add(new StudentData(rs.getString("id"),rs.getString("username"),rs.getString("password"),rs.getString("firstname"),rs.getString("lastname"),rs.getString("contact"),rs.getString("email")));
        }

        this.dataId.setCellValueFactory(new PropertyValueFactory<StudentData,String>("ID"));
        this.dataUsername.setCellValueFactory(new PropertyValueFactory<StudentData,String >("Username"));
        this.dataPassword.setCellValueFactory(new PropertyValueFactory<StudentData,String>("Password"));
        this.dataFirstname.setCellValueFactory(new PropertyValueFactory<StudentData,String>("FirstName"));
        this.dataLastname.setCellValueFactory(new PropertyValueFactory<StudentData,String >("LastName"));
        this.dataContact.setCellValueFactory(new PropertyValueFactory<StudentData,String>("Contact"));
        this.dataEmail.setCellValueFactory(new PropertyValueFactory<StudentData,String >("Email"));

        this.studentTable.setItems(null);
        this.studentTable.setItems(this.data);


    }

    @FXML
    public void addNew(ActionEvent event) throws SQLException {

        Connection conn = MySQLJDBCUtil.getConnection();
        PreparedStatement prs= conn.prepareStatement("insert into loginInfo(id,username,password,firstname,lastname,contact,email)  values(?,?,?,?,?,?,?)");
        prs.setInt(1,Integer.parseInt(this.stId.getText()));
        prs.setString(2,this.stUsername.getText());
        prs.setString(3,this.stPassword.getText());
        prs.setString(4,this.stFirstName.getText());
        prs.setString(5,this.stLastName.getText());
        prs.setString(6,this.stContact.getText());
        prs.setString(7,this.stEmail.getText());

        prs.execute();
        loadStudentData(event);

    }

}