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
    @JoinColumn(name = "id_reserva")
    private ClienteFinal cf;

    @ManyToMany(fetch = FetchType.EAGER,
            cascade = { CascadeType.ALL })
    @JoinTable(
            name = "reserva_mesa",
            joinColumns = { @JoinColumn(name = "id_reserva") })
    private List<Mesa> listaMesa;

    private Integer cantidad;
    private LocalDateTime horaReserva;

    public Reserva(){}

    public Reserva(ClienteFinal cf, List<Mesa> listaMesa, Integer cantidad, LocalDateTime horaReserva){
        this.cf = cf;
        this.listaMesa = listaMesa;
        this.cantidad = cantidad;
        this.horaReserva = horaReserva;
    }

    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public ClienteFinal getCf() { return cf; }

    public void setCf(ClienteFinal cf) { this.cf = cf; }

    public List<Mesa> getMesa() { return listaMesa; }

    public void setMesa(List<Mesa> listaMesa) { this.listaMesa = listaMesa; }

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
}
