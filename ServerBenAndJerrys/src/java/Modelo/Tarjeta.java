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
public class Tarjeta {
    private int id_tar,id_tipo,id_banco,cod_seg;
    private String titular,num_tar,FV;

    public Tarjeta() {
    }

    public int getId_tar() {
        return id_tar;
    }

    public void setId_tar(int id_tar) {
        this.id_tar = id_tar;
    }

    public int getId_tipo() {
        return id_tipo;
    }

    public void setId_tipo(int id_tipo) {
        this.id_tipo = id_tipo;
    }

    public int getId_banco() {
        return id_banco;
    }

    public void setId_banco(int id_banco) {
        this.id_banco = id_banco;
    }

    public int getCod_seg() {
        return cod_seg;
    }

    public void setCod_seg(int cod_seg) {
        this.cod_seg = cod_seg;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public String getNum_tar() {
        return num_tar;
    }

    public void setNum_tar(String num_tar) {
        this.num_tar = num_tar;
    }

    public String getFV() {
        return FV;
    }

    public void setFV(String FV) {
        this.FV = FV;
    }
    
    
}
