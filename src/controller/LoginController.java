/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import croco.FormUtama;
import javax.swing.JOptionPane;
import model.Enkripsi;
import model.Login;
import model.Petugas;

/**
 *
 * @author novalkrnfds
 */
public class LoginController {
    private final Login login = new Login();
    private final Enkripsi enkrip = new Enkripsi();
    private final Petugas p = new Petugas();
 
    public boolean validasi(javax.swing.JTextField userTextField, javax.swing.JPasswordField passwordField){
        boolean valid = false;
        String hashedInputPassword = "";
        
        if (!userTextField.getText().equals("")){
            if (p.bacaLogin(userTextField.getText())){
                try {
                    hashedInputPassword = enkrip.hashMD5(new String(passwordField.getPassword()));
                } catch (Exception ex){}
                
                if (p.getPassword().equalsIgnoreCase(hashedInputPassword)){
                    valid = true;
                } else {
                    JOptionPane.showMessageDialog(null, "username atau password salah", "Kesalahan", JOptionPane.ERROR_MESSAGE);
                }
                
                if (p.getHakAkses().equalsIgnoreCase("Admin")){
                   FormUtama utama = new FormUtama();
                   utama.admin();
                } else if (p.getHakAkses().substring(0, 3).equalsIgnoreCase("Owner")){
                    
                } else if(p.getHakAkses().substring(0, 3).equalsIgnoreCase("Karyawan")){
                    
                }
            } else {
                if (p.getPesan().substring(0, 3).equalsIgnoreCase("username")){
                    JOptionPane.showMessageDialog(null, "username atau password salah", "Kesalahan", JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, p.getPesan(), "Kesalahan", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "username atau password salah", "Kesalahan", JOptionPane.ERROR_MESSAGE);
        }
        
        return valid;
    }
}
