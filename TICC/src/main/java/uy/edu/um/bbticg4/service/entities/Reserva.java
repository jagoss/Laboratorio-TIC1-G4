package uy.edu.um.bbticg4.service.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Reserva")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_generator_rs")
    @SequenceGenerator(name="id_generator_rs", sequenceName = "id_seq_rs", allocationSize=1)
    private Integer id;
    private ClienteFinal cf;
    private Restaurant resto;
    private int cantidad;
    private LocalDate horaReserva;

    public Reserva(){}

    public Reserva(ClienteFinal cf, Restaurant resto){
        this.cf = cf;
        this.resto = resto;
    }

    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public ClienteFinal getCf() { return cf; }

    public void setCf(ClienteFinal cf) { this.cf = cf; }

    public Restaurant getResto() { return resto; }

    public void setResto(Restaurant resto) { this.resto = resto; }
}
