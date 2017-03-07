/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JOptionPane;

/**
 *
 * @author novalkrnfds
 */
public class PesanDialog {
    public int tampilkanPilihan(String pesan, String judul, Object[] ospiPilihan){
        return JOptionPane.showOptionDialog(null, pesan, judul, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, ospiPilihan, ospiPilihan[0]);
    }
    
}
