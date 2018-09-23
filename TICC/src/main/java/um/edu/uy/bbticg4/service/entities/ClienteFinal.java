package um.edu.uy.bbticg4.service.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.ArrayList;

@Entity
@Table(name = "Cliente_Final")
public class ClienteFinal{

    @Id
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String cellphone;
    private String password;

    public ClienteFinal(Integer id, String fName, String lName, String email, String cellphone, String password){


        this.id = id;
        this.cellphone = cellphone;
        this.email = email;
        this.password = password;
        firstName = fName;
        lastName = lName;
    }

    public ClienteFinal(){}

    public void setId(Integer id){
        this.id = id;
    }

    public Integer getId(){
        return id;
    }
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
