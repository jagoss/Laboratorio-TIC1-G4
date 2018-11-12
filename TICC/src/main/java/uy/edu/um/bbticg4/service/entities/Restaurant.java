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
            name = "restaurant_tipo_comida",
            joinColumns = { @JoinColumn(name = "id_resto") })
    private List<TipoComida> listaCategoriaComida = new ArrayList<>(5);
    private Integer rating = 3;

    @ManyToOne
    private Barrio barrio;

    @OneToMany
    List<Mesa> mesasTotales;

    @Column(unique = true)
    private String name;
    private String nombreFantasia;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String cellphone;
    private String password;
    @Column(unique = true)
    private String cuentaBanco;
    @Column(unique = true)
    private Long ruc;
    @Column(unique = true)
    private String direccion;
    private boolean firstReview = false;
    private String descripcion;
    private String opcionesDePago;
    private String horario;
    private String costoPersona;
    private boolean firstLogin = true;


    public Restaurant(String name,String password, String cuentaBanco, Long ruc ,String email, String cellphone ,
                      String direccion, Barrio barrio){

        this.direccion = direccion;
        this.ruc = ruc;
        this.cellphone = cellphone;
        this.email = email;
        this.password = password;
        this.barrio = barrio;
        this.name = name;
        this.cuentaBanco = cuentaBanco;
    }

    public Restaurant(String name, String nombreFantasia,String password,String cuentaBanco , Long ruc,
                      String email, String cellphone, String direccion, Barrio barrio){

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

    public Long getRuc() {
        return ruc;
    }

    public void setRuc(Long ruc) {
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

    public Barrio getBarrio() {
        return barrio;
    }

    public void setBarrio(Barrio barrio) {
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

    public boolean getFirstReview() {
        return firstReview;
    }

    public void setFirstReview(boolean fr) {
        this.firstReview = fr;
    }

    public boolean isFirstReview() {
        return firstReview;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCostoPersona() {
        return costoPersona;
    }

    public void setCostoPersona(String costoPersona) {
        this.costoPersona = costoPersona;
    }

    public String getOpcionesDePago() {
        return opcionesDePago;
    }

    public void setOpcionesDePago(String opcionesDePago) {
        this.opcionesDePago = opcionesDePago;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public void setFirstLogin(boolean estado){firstLogin = estado;}

    public boolean getFistLogin() {return firstLogin;}

    public List<Mesa> getMesasTotales() { return mesasTotales; }

    public void setMesasTotales(List<Mesa> mesasTotales) { this.mesasTotales = mesasTotales; }
}
