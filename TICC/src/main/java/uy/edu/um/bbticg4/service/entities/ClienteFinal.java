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
    private float review = 3;
    @Lob
    private byte[] fotoPerfil;
    @ManyToOne
    private Reserva reserva;

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

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getCellphone() { return cellphone; }

    public void setCellphone(String cellphone) { this.cellphone = cellphone; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public float getReview() { return review; }

    public void setReview(float review) { this.review = review; }

    public byte[] getFotoPerfil() { return fotoPerfil; }

    public void setFotoPerfil(byte[] fotoPerfil) { this.fotoPerfil = fotoPerfil; }

    public Reserva getReserva() { return reserva; }

    public void setReserva(Reserva reserva) { this.reserva = reserva; }
}
