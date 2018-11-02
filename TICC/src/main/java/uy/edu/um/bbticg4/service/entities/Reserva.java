package uy.edu.um.bbticg4.service.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "reserva")
public class Reserva {

    @Id    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_generator_res")
    @SequenceGenerator(name="id_generator_res", sequenceName = "id_seq_res", allocationSize=1)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_cf")
    private ClienteFinal cf;
    @ManyToOne
    @JoinColumn(name = "id_resto")
    private Restaurant resto;
    private int cantidad;
    private LocalDateTime horaReserva;

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
