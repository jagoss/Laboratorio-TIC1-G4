package um.edu.uy.bbticg4.service.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "restaurant")
public class Restaurant {

    @Id
    private Integer id;

    private String barrio;
    private String name;

    public Restaurant(Integer id, String name, String barrio){

        this.id = id;
        this.barrio = barrio;
        this.name = name;
    }
}
