/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import parameter.LoginParameter;

/**
 *
 * @author novalkrnfds
 */
public class Login extends LoginParameter{
    private final Koneksi koneksi = new Koneksi();
    Connection con = koneksi.getKoneksi();
    Statement st=null;
    ResultSet rs=null;
    String sql=null;
    
    public List cariId(int username){
        List logLogin = new ArrayList();
        int result;
        
        sql="select username from tbpetugas where username='"+username+"'";
        try{
            rs=st.executeQuery(sql);

            while(rs.next()){
                LoginParameter lp = new LoginParameter();
                lp.setUser(rs.getString("username"));
                logLogin.add(lp);
            }
        } catch(SQLException a){
            JOptionPane.showMessageDialog(null, "Terjadi kesalahaan pencarian ID, pada :\n"+a);
        }
        return logLogin;
    }
    
    public List cariLogin(String username,String password){
        List logLogin = new ArrayList();
        int result;
        sql="select username,password,hakakses from tbpetugas where username='"+username+"' and password='"+password+"'";
        try{
            rs=st.executeQuery(sql);

            while(rs.next()){
                LoginParameter lp = new LoginParameter();
                lp.setUser(rs.getString("username"));
                lp.setPass(rs.getString("password"));
                lp.setHak(rs.getString("hakakses"));
                logLogin.add(lp);
            }
        } catch(SQLException a){
            JOptionPane.showMessageDialog(null, "Terjadi kesalahaan login, pada :\n"+a);
        }
        return logLogin;
    }
}
