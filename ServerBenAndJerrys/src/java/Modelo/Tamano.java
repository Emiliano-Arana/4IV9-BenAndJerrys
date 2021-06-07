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

import java.util.Vector;
import Control.Conexion;
import java.sql.*;

public class Tamano {
    private int id_tam;
    private String tam;

    public Tamano() {
    }

    public int getId_tam() {
        return id_tam;
    }

    public void setId_tam(int id_tam) {
        this.id_tam = id_tam;
    }

    public String getTam() {
        return tam;
    }

    public void setTam(String tam) {
        this.tam = tam;
    }
    
    public Vector<Tamano> listaTamanos() throws ClassNotFoundException{
        Vector<Tamano> listaTamanos = new Vector<Tamano>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            con = Conexion.getConection();
            String q = "select * from ctamano";
            //querry donde se obtenga a traves de join o con vista
            ps = con.prepareStatement(q);
            rs = ps.executeQuery();
            while(rs.next()){
                Tamano tam = new Tamano();
                tam.setId_tam(rs.getInt("id_tamano"));
                tam.setTam(rs.getString("nombre_tamano"));
                listaTamanos.add(tam);
            }
            
        }catch(SQLException sq){
            System.out.println("Error al consultar los productos");
            System.out.println(sq.getMessage());
            listaTamanos = null;
        
        }finally{
            try{
                rs.close();
                ps.close();
                con.close();
            
            }catch(Exception e){
                System.out.println("Error no encuentra la clase");
                System.out.println(e.getMessage());
            }
        }
        return listaTamanos;
    }
}
