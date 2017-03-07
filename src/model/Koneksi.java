 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


/**
 *
 * @author novalkrnfds
 */
public class Koneksi {
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String database = "jdbc:mysql://localhost:3306/dbcrocodistro";
    private static final String user = "root";
    private static final String password = "";
    
    public Connection connection;
    private String pesanKesalahan;
    
    public String getPesan(){
        return pesanKesalahan;
    }
    
    public Connection getKoneksi(){
        connection = null;
        pesanKesalahan = "";
        
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex){
            pesanKesalahan = "JDBC Driver tidak ditemukan atau rusak\n"+ex;
        }
        
        if (pesanKesalahan.equals("")){
            try {
                connection = DriverManager.getConnection(database+"?user="+user+"&password="+password+"");
            } catch(SQLException ex){
                pesanKesalahan = "Koneksi ke "+database+" gagal\n"+ex;
            }
        }
        return connection;
    }

    
}
