package uy.edu.um.bbticg4.service.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "reserva")
public class Reserva {

    @Id    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_generator_res")
    @SequenceGenerator(name="id_generator_res", sequenceName = "id_seq_res", allocationSize=1)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER,
            cascade = { CascadeType.ALL })
    @JoinColumn(name = "id_cf")
    private ClienteFinal cf;

    @ManyToOne(fetch = FetchType.EAGER,
            cascade = { CascadeType.ALL })
    @JoinColumn(name = "id_resto")
    private Restaurant resto;

    private Integer cantidad;
    private LocalDateTime horaReserva;
    private boolean confirmada;
    private boolean asistio;
    private boolean finalizada;

    public Reserva(){}

    public Reserva(ClienteFinal cf, Restaurant resto,Integer cantidad, LocalDateTime horaReserva){
        this.cf = cf;
        this.resto = resto;
        this.cantidad = cantidad;
        this.horaReserva = horaReserva;
    }

    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public ClienteFinal getCf() { return cf; }

    public void setCf(ClienteFinal cf) { this.cf = cf; }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public LocalDateTime getHoraReserva() {
        return horaReserva;
    }

    public void setHoraReserva(LocalDateTime horaReserva) {
        this.horaReserva = horaReserva;
    }

    public boolean isConfirmada() {
        return confirmada;
    }

    public void setConfirmada(boolean confirmada) {
        this.confirmada = confirmada;
    }

    public boolean isFinalizada() {
        return finalizada;
    }

    public void setFinalizada(boolean finalizada) {
        this.finalizada = finalizada;
    }

    public boolean isAsistio() {
        return asistio;
    }

    public void setAsistio(boolean asistio) {
        this.asistio = asistio;
    }
}
