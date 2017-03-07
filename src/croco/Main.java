/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package croco;

import static croco.FormUtama.koneksi;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import model.Koneksi;
import view.FormLogin;
import view.LaunchProgressBar;

/**
 *
 * @author novalkrnfds
 */
public class Main {
    static Koneksi koneksi = new Koneksi();
    static Connection con;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        LaunchProgressBar pb = new LaunchProgressBar();
        pb.setVisible(true);
        for(int i=0;i<=100;i++){
            try {
                pb.getProgressBar().setValue(i);
                Thread.sleep(25);
            } catch (InterruptedException ex) {
                Logger.getLogger(LaunchProgressBar.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        pb.dispose();
        if ((con = koneksi.getKoneksi()) != null){
            new FormLogin().setVisible(true);
            //new FormUtama().setVisible(true);
            //tampilKonek();
        } else {
            JOptionPane.showMessageDialog(null, "Koneksi Gagal\n"+koneksi.getPesan());
        }
        
        
    }
    
    static {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FormLogin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(FormLogin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(FormLogin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(FormLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
