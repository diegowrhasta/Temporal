package com.example.diego.temporal.Objetos;

/**
 * Created by Diego on 13/05/2017.
 */

public class Pez {
    String genero;
    int numero;
    String tipo;

    public Pez(String genero, int numero, String tipo) {
        this.genero = genero;
        this.numero = numero;
        this.tipo = tipo;
    }

    public Pez() {

    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Pez{" +
                "genero='" + genero + '\'' +
                ", numero=" + numero +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}
