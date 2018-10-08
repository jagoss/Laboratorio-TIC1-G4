package uy.edu.um.bbticg4.service.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "restaurant")
public class Restaurant{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_generator")
    @SequenceGenerator(name="id_generator", sequenceName = "id_seq", allocationSize=1)
    private Integer id;

    @ManyToMany(fetch = FetchType.EAGER,
            cascade = { CascadeType.ALL })
    @JoinTable(
            name = "restauranttipo_comida",
            joinColumns = { @JoinColumn(name = "id_resto") })
    private List<TipoComida> listaCategoriaComida = new ArrayList<>(5);
    private Integer rating;
    private String barrio;
    private String name;
    private String nombreFantasia;
    private String email;
    private String cellphone;
    private String password;
    private String cuentaBanco;
    private Integer ruc;
    private String direccion;

    public Restaurant(String name,String password, String cuentaBanco, Integer ruc ,String email, String cellphone ,
                      String direccion, String barrio){

        this.direccion = direccion;
        this.ruc = ruc;
        this.cellphone = cellphone;
        this.email = email;
        this.password = password;
        this.barrio = barrio;
        this.name = name;
        this.cuentaBanco = cuentaBanco;
    }

    public Restaurant(String name, String nombreFantasia,String password,String cuentaBanco , Integer ruc,
                      String email, String cellphone, String direccion, String barrio){

        this.direccion = direccion;
        this.ruc = ruc;
        this.cellphone = cellphone;
        this.email = email;
        this.password = password;
        this.barrio = barrio;
        this.name = name;
        this.nombreFantasia = nombreFantasia;
        this.cuentaBanco = cuentaBanco;
    }

    public Restaurant(){}

    public void deleteCategoriaComida(String categoriaAEliminar){

        if(listaCategoriaComida.remove(categoriaAEliminar)){
            System.out.println("Eliminacion exitosa!");
        }

    }

    @Override
    public String toString(){

        return "Restaurant [Nombre=" + name + ", email=" + email
                + ", Contacto=" + cellphone + ", barrio=" + barrio + "]";
    }


    public void setListaCategoriaComida(List<TipoComida> listaCategoriaComida) {
        this.listaCategoriaComida = listaCategoriaComida;
    }

    public String getNombreFantasia() {
        return nombreFantasia;
    }

    public void setNombreFantasia(String nombreFantasia) {
        this.nombreFantasia = nombreFantasia;
    }

    public String getCuentaBanco() {
        return cuentaBanco;
    }

    public void setCuentaBanco(String cuentaBanco) {
        this.cuentaBanco = cuentaBanco;
    }

    public Integer getRuc() {
        return ruc;
    }

    public void setRuc(Integer ruc) {
        this.ruc = ruc;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public Integer getId(){
        return id;
    }

    public List<TipoComida> getListaCategoriaComida() {
        return listaCategoriaComida;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
