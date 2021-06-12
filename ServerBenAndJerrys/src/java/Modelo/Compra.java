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
public class Compra {
    private int id_compra,id_subtotal,id_FP;
    private String fecha;
    private long total;

    public Compra() {
    }

    public int getId_compra() {
        return id_compra;
    }

    public void setId_compra(int id_compra) {
        this.id_compra = id_compra;
    }

    public int getId_subtotal() {
        return id_subtotal;
    }

    public void setId_subtotal(int id_subtotal) {
        this.id_subtotal = id_subtotal;
    }

    public int getId_FP() {
        return id_FP;
    }

    public void setId_FP(int id_FP) {
        this.id_FP = id_FP;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }
    
    
}
