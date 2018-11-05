package uy.edu.um.bbticg4.service.entities;

import javax.persistence.*;

@Entity
@Table(name = "mesa")
public class Mesa {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_generator_mesa")
    @SequenceGenerator(name="id_generator_mesa", sequenceName = "id_seq_mesa", allocationSize=1)
    private Integer id;
    private Integer nroPersonas;

    public Mesa(){}

    public Mesa(Integer nroPersonas){
        this.nroPersonas = nroPersonas;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNroPersonas() {
        return nroPersonas;
    }

    public void setNroPersonas(Integer nroPersonas) {
        this.nroPersonas = nroPersonas;
    }
}
