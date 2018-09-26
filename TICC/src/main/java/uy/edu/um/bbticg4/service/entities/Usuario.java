package uy.edu.um.bbticg4.service.entities;

public abstract class Usuario {

    private String email;
    private String cellphone;
    private String password;

    public Usuario(String email, String cellphone, String password){

        this.cellphone = cellphone;
        this.email = email;
        this.password = password;
    }

    public Usuario(){}

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
