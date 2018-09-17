package pruebapersistence;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "restaurante")
public class Restuarante implements Serializable {

    @Id
    @Column(name = "id_resto")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idMesas_generator")
    @SequenceGenerator(name = "idMesas_generator", sequenceName = "testMesas_sequence")
    private Integer id_restaurente;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "nombre_fantasia", unique = true)
    private String nombre_fantasia;

    @Column(name = "ruc", unique = true, nullable = false)
    private Integer ruc;

    @Column(name = "barrio", nullable = false)
    private String barrio;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "contacto_tel", unique = true, nullable = false)
    private String contacto_tel;

    @Column(name = "cuenta_bancaria", unique = true, nullable = false)
    private String cuentaBancaria;

    @OneToMany(mappedBy = "miResto")
    private List<Mesas> listaMesas;

    public Restuarante(String name, String email, String barrio, String contacto_tel){

        this.barrio = barrio;
        this.contacto_tel = contacto_tel;
        this.email = email;
        this.name = name;
    }

    public Restuarante() {
    }

    public Integer getId_restaurente() {
        return id_restaurente;
    }

    public void setId_restaurente(Integer id_restaurente) {
        this.id_restaurente = id_restaurente;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNombre_fantasia() {
        return nombre_fantasia;
    }

    public void setNombre_fantasia(String nombre_fantasia) {
        this.nombre_fantasia = nombre_fantasia;
    }

    public Integer getRuc() {
        return ruc;
    }

    public void setRuc(Integer ruc) {
        this.ruc = ruc;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContacto_tel() {
        return contacto_tel;
    }

    public void setContacto_tel(String contacto_tel) {
        this.contacto_tel = contacto_tel;
    }

    public String getCuentaBancaria() {
        return cuentaBancaria;
    }

    public void setCuentaBancaria(String cuentaBancaria) {
        this.cuentaBancaria = cuentaBancaria;
    }

    public List<Mesas> getListaMesas() {
        return listaMesas;
    }

    public void setListaMesas(List<Mesas> listaMesas) {
        this.listaMesas = listaMesas;
    }
}
