package uy.edu.um.bbticg4.service.entities;

import javax.persistence.*;

@Entity
@Table(name = "barrio")
public class Barrio {

    @Id
    private Integer id;
    private String name;

    public Barrio(Integer id, String name){
        this.id = id;
        this.name = name;
    }

    public Barrio(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
