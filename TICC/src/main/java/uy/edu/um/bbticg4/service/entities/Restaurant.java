package uy.edu.um.bbticg4.service.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "restaurant")
public class Restaurant{

    @Id
    private Integer id;

    @ManyToMany(fetch = FetchType.EAGER,
            cascade = { CascadeType.ALL })
    @JoinTable(
            name = "restaurant_tipo_comida",
            joinColumns = { @JoinColumn(name = "tipo_comida_id") })
    private List<TipoComida> listaCategoriaComida = new ArrayList<>(5);
    private Integer rating;
    private String barrio;
    private String name;
    private String email;
    private String cellphone;
    private String password;

    public Restaurant(Integer id, String name, String password, String email, String cellphone ,String barrio){

        this.id = id;
        this.cellphone = cellphone;
        this.email = email;
        this.password = password;
        this.barrio = barrio;
        this.name = name;
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
