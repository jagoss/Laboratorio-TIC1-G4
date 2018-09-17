package pruebapersistence;

import javax.persistence.*;


@Entity
@Table(name = "mesas")
public class Mesas {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idMesa_generator")
    @SequenceGenerator(name = "idMesa_generator", sequenceName = "mesas_sequence")
    @Column(name = "id_mesa")
    private Integer idMesa;

    @Column(name = "nro_mesa")
    private Integer nroMesa;

    @Column(name = "seccion")
    private Integer seccion;

    @Column(name = "cant_personas")
    private Integer cantidadPersonas;

    @Column(name = "libre")
    private boolean libre = false;

    @ManyToOne
    @JoinColumn(name="id_resto", nullable=false)
    private Restuarante miResto;

    @OneToOne(mappedBy = "idCliente")
    private Integer cliente;

    public Mesas(Integer nroMesa, Integer seccion, Integer cantidadPersonas, Restuarante miResto){

        this.miResto = miResto;
        this.nroMesa = nroMesa;
        this.cantidadPersonas = cantidadPersonas;
        this.seccion = seccion;
    }

    public Mesas() {
    }

    @Override
    public String toString() {
        return "Mesa [ idMesa= " + idMesa + ", nroMesa=" + nroMesa + ", seccion= " + seccion + ", cantPersonas= "
                + cantidadPersonas + ", libre= " + libre + ", miResto= "+ miResto.getName() + "]";
    }

    public Integer getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(Integer idMesa) {
        this.idMesa = idMesa;
    }

    public Integer getNroMesa() {
        return nroMesa;
    }

    public void setNroMesa(Integer nroMesa) {
        this.nroMesa = nroMesa;
    }

    public Integer getSeccion() {
        return seccion;
    }

    public void setSeccion(Integer seccion) {
        this.seccion = seccion;
    }

    public Integer getCantidadPersonas() {
        return cantidadPersonas;
    }

    public void setCantidadPersonas(Integer cantidadPersonas) {
        this.cantidadPersonas = cantidadPersonas;
    }

    public boolean isLibre() {
        return libre;
    }

    public void setLibre(boolean libre) {
        this.libre = libre;
    }
}
