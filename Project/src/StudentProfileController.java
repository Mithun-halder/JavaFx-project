import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentProfileController {

    @FXML
    private Button PersonalInfoBnt;

    @FXML
    private TableColumn<StudentData, String> TableContact;

    @FXML
    private TableColumn<StudentData, String> TableEmail;

    @FXML
    private TableColumn<StudentData, String> TableId;

    @FXML
    private TableColumn<StudentData, String> TableLastname;

    @FXML
    private TableColumn<StudentData, String> TablePassword;

    @FXML
    private TableColumn<StudentData, String > TableUsername;

    @FXML
    private TableColumn<StudentData, String > TbaleFirstNmae;

    @FXML
    private TableView<StudentData> studentProfileTable;

    @FXML
    Text textContact;

    @FXML
     Text textEmail;

    @FXML
     Text textId;

    @FXML
     Text textName;

    ObservableList<StudentData>list;



    @FXML
    void ShowPersonaInfo(ActionEvent event) throws SQLException {

        Connection conn = MySQLJDBCUtil.getConnection();
        this.list= FXCollections.observableArrayList();

        ResultSet rs= conn.createStatement().executeQuery("SELECT *From loginInfo");
        while (rs.next()){
            if(textId.getText().equals(rs.getString(1))){
                this.list.add(new StudentData(rs.getString("id"),rs.getString("username"),rs.getString("password"),rs.getString("firstname"),rs.getString("lastname"),rs.getString("contact"),rs.getString("email")));
            }

        }

        this.TableId.setCellValueFactory(new PropertyValueFactory<StudentData,String>("ID"));
        this.TableUsername.setCellValueFactory(new PropertyValueFactory<StudentData,String >("Username"));
        this.TablePassword.setCellValueFactory(new PropertyValueFactory<StudentData,String>("Password"));
        this.TbaleFirstNmae.setCellValueFactory(new PropertyValueFactory<StudentData,String>("FirstName"));
        this.TableLastname.setCellValueFactory(new PropertyValueFactory<StudentData,String >("LastName"));
        this.TableContact.setCellValueFactory(new PropertyValueFactory<StudentData,String>("Contact"));
        this.TableEmail.setCellValueFactory(new PropertyValueFactory<StudentData,String >("Email"));

        this.studentProfileTable.setItems(null);
        this.studentProfileTable.setItems(this.list);



    }

}
