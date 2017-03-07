/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import model.Merk;
import view.FormDataMerk;
import view.FormInputMerk;
import view.PesanDialog;

/**
 *
 * @author novalkrnfds
 */
public class MerkController {
    private final PesanDialog pesanDialog = new PesanDialog();
    private final Merk merk = new Merk();
    private FormInputMerk formInputMerk;
    private FormDataMerk formMerk;
    
    public void simpan(JTextField kodeText, JTextField namaText){
        if(!kodeText.getText().equals("")){
            merk.setKode(kodeText.getText());
            merk.setNama(namaText.getText());
            
            if(merk.save()){
                FormInputMerk.kodeText.setText("");
                FormInputMerk.namaText.setText("");
                
                if(merk.bacaData()){
                    FormDataMerk.tampilkanData(merk.getList());
                }
            } else {
                if (merk.getPesan().length() > 0){
                    JOptionPane.showMessageDialog(null, merk.getPesan(), "Kesalahan", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "ID Petugas tidak boleh kosong", "Kesalahan", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void tampilData(){
        if(merk.bacaData()){
            FormDataMerk.tampilkanData(merk.getList());
        } else {
            JOptionPane.showMessageDialog(null, merk.getPesan());
        }
    }
    
    public void ubah(String nama){
        formInputMerk = new FormInputMerk(null, true);
        if(merk.baca(nama)){
            FormInputMerk.kodeText.setText(merk.getKode());
            FormInputMerk.namaText.setText(merk.getNama());
            FormInputMerk.kodeText.setEditable(false);
            formInputMerk.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "failed to read the data merk : "+nama +"\n"+merk.getPesan());
        }
    }
    
    public boolean delete(String nama){
        boolean cek = false;
            merk.baca(nama);
            if (pesanDialog.tampilkanPilihan("Delete Data Merk : "+nama+" ???","Confirm", new Object[]{"Yes","No"}) == 0){
                cek = merk.delete(nama); // cek=true
            } else{
                cek = false;
            }
            
        return cek;
    }
    
}
