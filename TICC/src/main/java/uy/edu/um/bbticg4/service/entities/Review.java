package uy.edu.um.bbticg4.service.entities;

import javax.persistence.Id;

public class Review {

    private Integer id;
    private Restaurant resto;
    private ClienteFinal cf;
    private String descripcion;
    private float puntacion;

    public Review() {}
    public Review(ClienteFinal cf, Restaurant resto, String descripcion, float puntacion){

        this.cf = cf;
        this.puntacion = puntacion;
        this.resto = resto;
        this.id = cf.hashCode()+resto.hashCode();
    }
}
