package com.example.diego.temporal.Objetos;

/**
 * Created by Diego on 13/05/2017.
 */

public class usuario {
    String username;
    String pass;
    boolean ciclo;

    public usuario() {
    }

    public usuario(String username, String pass, boolean ciclo) {
        this.username = username;
        this.pass = pass;
        this.ciclo = ciclo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public boolean isCiclo() {
        return ciclo;
    }

    public void setCiclo(boolean ciclo) {
        this.ciclo = ciclo;
    }


    @Override
    public String toString() {
        return "usuario{" +
                "username='" + username + '\'' +
                ", pass='" + pass + '\'' +
                ", ciclo=" + ciclo;
    }
}
