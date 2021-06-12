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
public class Direccion {
    private int id_dir,id_alcaldia,id_colonia,num_ext,num_int;
    private String calle;

    public Direccion() {
    }

    public int getId_dir() {
        return id_dir;
    }

    public void setId_dir(int id_dir) {
        this.id_dir = id_dir;
    }

    public int getId_alcaldia() {
        return id_alcaldia;
    }

    public void setId_alcaldia(int id_alcaldia) {
        this.id_alcaldia = id_alcaldia;
    }

    public int getId_colonia() {
        return id_colonia;
    }

    public void setId_colonia(int id_colonia) {
        this.id_colonia = id_colonia;
    }

    public int getNum_ext() {
        return num_ext;
    }

    public void setNum_ext(int num_ext) {
        this.num_ext = num_ext;
    }

    public int getNum_int() {
        return num_int;
    }

    public void setNum_int(int num_int) {
        this.num_int = num_int;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }
    
    
}
