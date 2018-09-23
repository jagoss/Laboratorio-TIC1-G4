package um.edu.uy.bbticg4.service.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.ArrayList;

@Entity
@Table(name = "restaurant")
public class Restaurant {

    @Id
    private Integer id;
    private ArrayList<String> listaCategoriaComida = new ArrayList<>(5);
    private String barrio;
    private String name;

    public Restaurant(Integer id, String name, String barrio){

        this.id = id;
        this.barrio = barrio;
        this.name = name;
    }

    public Restaurant(){

    }

    public void addCategoriaComida(String nuevaCategoria){

        listaCategoriaComida.add(nuevaCategoria);
        System.out.println("Agregacion exitosa!");
    }

    public void deleteCategoriaComida(String categoriaAEliminar){

        if(listaCategoriaComida.remove(categoriaAEliminar)){
            System.out.println("Eliminacion exitosa!");
        }

    }
}
