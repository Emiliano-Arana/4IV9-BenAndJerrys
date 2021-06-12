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
public class Banco {
    private int id_banco;
    private String nombre;

    public Banco() {
    }

    public int getId_banco() {
        return id_banco;
    }

    public void setId_banco(int id_banco) {
        this.id_banco = id_banco;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public Vector<Banco> listaBanco() throws ClassNotFoundException{
        Vector<Banco> listaBanco = new Vector<Banco>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            con = Conexion.getConection();
            String q = "select * from cbanco";
            //querry donde se obtenga a traves de join o con vista
            ps = con.prepareStatement(q);
            rs = ps.executeQuery();
            while(rs.next()){
                Banco ban = new Banco();
                ban.setId_banco(rs.getInt("id_banco"));
                ban.setNombre(rs.getString("tipo_banco"));
                listaBanco.add(ban);
            }
            
        }catch(SQLException sq){
            System.out.println("Error al consultar los bancos");
            System.out.println(sq.getMessage());
                    
            listaBanco = null;
        
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
        return listaBanco;
    }
    
}
