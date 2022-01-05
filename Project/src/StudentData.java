import com.mysql.cj.conf.StringProperty;
import javafx.beans.property.SimpleStringProperty;

public class StudentData {

   // id,username,password,firstname,lastname,contact,email
    SimpleStringProperty ID;
    SimpleStringProperty Username;
    SimpleStringProperty Password;
    SimpleStringProperty FirstName;
    SimpleStringProperty LastName;
    SimpleStringProperty Contact;
    SimpleStringProperty Email;


    public StudentData(String id,String username, String password, String firstname, String lastname, String contact, String email) {
        this.ID = new SimpleStringProperty(id);
        this.Username=new SimpleStringProperty(username);
        this.Password =new SimpleStringProperty(password);
        this.FirstName = new SimpleStringProperty(firstname);
        this.LastName = new SimpleStringProperty(lastname);
        this.Contact = new SimpleStringProperty(contact);
        this.Email = new SimpleStringProperty(email);
    }

    public String getID() {
        return ID.get();
    }

    public SimpleStringProperty IDProperty() {
        return ID;
    }

    public void setID(String ID) {
        this.ID.set(ID);
    }

    public String getUsername() {
        return Username.get();
    }

    public SimpleStringProperty usernameProperty() {
        return Username;
    }

    public void setUsername(String username) {
        this.Username.set(username);
    }

    public String getPassword() {
        return Password.get();
    }

    public SimpleStringProperty passwordProperty() {
        return Password;
    }

    public void setPassword(String password) {
        this.Password.set(password);
    }

    public String getFirstName() {
        return FirstName.get();
    }

    public SimpleStringProperty firstNameProperty() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        this.FirstName.set(firstName);
    }

    public String getLastName() {
        return LastName.get();
    }

    public SimpleStringProperty lastNameProperty() {
        return LastName;
    }

    public void setLastName(String lastName) {
        this.LastName.set(lastName);
    }

    public String getContact() {
        return Contact.get();
    }

    public SimpleStringProperty contactProperty() {
        return Contact;
    }

    public void setContact(String contact) {
        this.Contact.set(contact);
    }

    public String getEmail() {
        return Email.get();
    }

    public SimpleStringProperty emailProperty() {
        return Email;
    }

    public void setEmail(String email) {
        this.Email.set(email);
    }
}
