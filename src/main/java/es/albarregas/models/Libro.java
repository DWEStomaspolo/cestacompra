/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.models;

import java.io.Serializable;

/**
 *
 * @author tomlu
 */
public class Libro implements Serializable{

    public Libro(int cantidad, String titulo) {
        this.cantidad = cantidad;
        this.titulo = titulo;
    }
    
    
    private int cantidad;
    private String titulo;

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    
}
