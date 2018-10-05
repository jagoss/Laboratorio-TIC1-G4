package uy.edu.um.bbticg4.service.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TipoComida {

    @Id
    private Integer idTipoComida;
    private String nombre;

    public TipoComida(Integer idTComida, String nombreTipoComida){

        idTipoComida = idTComida;
        this.nombre = nombreTipoComida;
    }

    public TipoComida(){}

    public Integer getIdTipoComida() {
        return idTipoComida;
    }

    public void setIdTipoComida(Integer idTipoComida) {
        this.idTipoComida = idTipoComida;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombreTipoComida) {
        this.nombre = nombreTipoComida;
    }
}
