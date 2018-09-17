package pruebapersistence;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Cliente_Final")
public class ClienteFinal implements Serializable {

    @Id
    @OneToOne
    @JoinTable(name = "id_cliente_res")
    @Column(name = "id_cliente")
    private Integer idCliente;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "celular", nullable = false, unique = true)
    private String celular;

    @Column(name = "email", nullable = false, unique = true)
    private String email;


    public ClienteFinal(Integer id, String firstName, String lastName, String email, String celular){
        this.idCliente = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.celular = celular;
    }

    @Override
    public String toString() {
        return "Cliente Final [idCliente=" + idCliente + ", firstname= " + firstName + ", lastname=" + lastName + ", email= "
            + email + ", celular= " + celular + "]";
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(Integer id) {
        this.idCliente = id;
    }

    public Integer getId() {
        return idCliente;
    }



}
