package uy.edu.um.bbticg4.service.entities;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name = "Cliente_Final")
public class ClienteFinal{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_generator_cf")
    @SequenceGenerator(name="id_generator_cf", sequenceName = "id_seq_cf", allocationSize=1)
    private Integer id;
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String cellphone;
    private String password;

    public ClienteFinal(String fName, String lName, String email, String cellphone, String password){

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
