package uy.edu.um.bbticg4.service.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "reserva")
public class Reserva {

    @Id
    private Integer id;

    @OneToOne(fetch = FetchType.LAZY)
    private ClienteFinal cf;
    @ManyToOne
    @JoinColumn(name = "id_resto")
    private Restaurant resto;
    private int cantidad;
    private LocalDate horaReserva;

    public Reserva(){}

    public Reserva(ClienteFinal cf, Restaurant resto){
        this.cf = cf;
        this.resto = resto;
        this.id = cf.hashCode() + resto.hashCode();
    }

    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public ClienteFinal getCf() { return cf; }

    public void setCf(ClienteFinal cf) { this.cf = cf; }

    public Restaurant getResto() { return resto; }

    public void setResto(Restaurant resto) { this.resto = resto; }
}
