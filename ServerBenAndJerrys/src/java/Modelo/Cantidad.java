/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Emiliano
 */
public class Cantidad {
    private int id_cant,valor;
    private String unidad;

    public Cantidad() {
    }

    public int getId_cant() {
        return id_cant;
    }

    public void setId_cant(int id_cant) {
        this.id_cant = id_cant;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }    
    
}
