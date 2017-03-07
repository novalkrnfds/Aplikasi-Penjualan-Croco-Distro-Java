/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import model.Brand;
import view.FormBrand;
import view.FormInputBrand;
import view.PesanDialog;

/**
 *
 * @author novalkrnfds
 */
public class BrandController {
    private final Brand b = new Brand();
    private final PesanDialog p = new PesanDialog();
    private FormBrand formBrand;
    private FormInputBrand formInputBrand;
    
    public void simpan(JTextField idBrandText, JTextField namaBrandText, JTextArea alamatText, JTextField emailText,
            JTextField telpText){
        if(!idBrandText.getText().equals("")){
            b.setId(idBrandText.getText());
            b.setNama(namaBrandText.getText());
            b.setAlamat(alamatText.getText());
            b.setEmail(emailText.getText());
            b.setTelp(telpText.getText());
            
            if(b.save()){
                FormInputBrand.idBrandText.setText("");
                FormInputBrand.namaBrandText.setText("");
                FormInputBrand.alamatText.setText("");
                FormInputBrand.emailText.setText("");
                FormInputBrand.telpText.setText("");
                
                if(b.bacaData()){
                    FormBrand.tampilkanData(b.getList());
                }
            } else {
                if(b.getPesan().length()>0){
                    JOptionPane.showMessageDialog(null, b.getPesan(), "Kesalahan", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "ID Brand tidak boleh kosong","Kesalahan", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void tampilData(){
        if (b.bacaData()){
            FormBrand.tampilkanData(b.getList());
        } else {
            JOptionPane.showMessageDialog(null, b.getPesan());
        }
    }
    
    public void ubah(String nama){
        formInputBrand = new FormInputBrand(null, true);
        if(b.baca(nama)){
            FormInputBrand.idBrandText.setText(b.getId());
            FormInputBrand.namaBrandText.setText(b.getNama());
            FormInputBrand.alamatText.setText(b.getAlamat());
            FormInputBrand.emailText.setText(b.getEmail());
            FormInputBrand.telpText.setText(b.getTelp());
            FormInputBrand.idBrandText.setEditable(false);
            formInputBrand.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "failed to read the data branch : "+nama +"\n"+b.getPesan());
        }
    }
    
    public boolean delete(String nama){
        boolean cek = false;
            b.baca(nama);
            if (p.tampilkanPilihan("Delete Data Brand : "+nama+" ???","Confirm", new Object[]{"Yes","No"}) == 0){
                cek = b.delete(nama); // cek=true
            } else{
                cek = false;
            }
            
        return cek;
    }
}