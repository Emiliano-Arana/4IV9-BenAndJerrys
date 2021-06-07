/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Control.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

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
    
    public Vector<Cantidad> listaCantidades() throws ClassNotFoundException{
        Vector<Cantidad> listaCantidades = new Vector<Cantidad>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            con = Conexion.getConection();
            String q = "select * from ccantidad";
            //querry donde se obtenga a traves de join o con vista
            ps = con.prepareStatement(q);
            rs = ps.executeQuery();
            while(rs.next()){
                Cantidad cant = new Cantidad();
                cant.setId_cant(rs.getInt("id_cantidad"));
                cant.setValor(rs.getInt("valor_cantidad"));
                cant.setUnidad(rs.getString("unidad_cantidad"));
                listaCantidades.add(cant);
            }
            
        }catch(SQLException sq){
            System.out.println("Error al consultar los productos");
            System.out.println(sq.getMessage());
            listaCantidades = null;
        
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
        return listaCantidades;
    }
}
