/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import model.Kategori;
import view.FormInputKategori;
import view.FormKategoriBarang;
import view.PesanDialog;

/**
 *
 * @author novalkrnfds
 */
public class KategoriController {
    private final PesanDialog pesanDialog = new PesanDialog();
    private FormInputKategori formInputKategori;
    private final Kategori kategori = new Kategori();
    
    public void save(JTextField kodeText, JTextField namaText, JTextField ketText){
        if(!kodeText.getText().equals("")){
            kategori.setKode(kodeText.getText());
            kategori.setNama(namaText.getText());
            kategori.setKeterangan(ketText.getText());
            
            if(kategori.save()){
                FormInputKategori.kodeText.setText("");
                FormInputKategori.namaText.setText("");
                FormInputKategori.ketText.setText("");
                
                if(kategori.bacaData()){
                    FormKategoriBarang.tampilkanData(kategori.getList());
                }
            }else {
                if(kategori.getPesan().length()>0){
                    JOptionPane.showMessageDialog(null, kategori.getPesan(), "Kesalahan", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Company Name tidak boleh kosong","Kesalahan", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void tampilData(){
        if (kategori.bacaData()){
            FormKategoriBarang.tampilkanData(kategori.getList());
        } else {
            JOptionPane.showMessageDialog(null, kategori.getPesan());
        }
    }
    
    public void ubah(String nama){
        formInputKategori = new FormInputKategori(null, true);
        if(kategori.baca(nama)){
            FormInputKategori.kodeText.setText(kategori.getKode());
            FormInputKategori.namaText.setText(kategori.getNama());
            FormInputKategori.ketText.setText(kategori.getKeterangan());
            FormInputKategori.kodeText.setEditable(false);
            formInputKategori.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "failed to read the data branch : "+nama +"\n"+kategori.getPesan());
        }
    }
    
    public boolean delete(String nama){
        boolean cek = false;
            kategori.baca(nama);
            if (pesanDialog.tampilkanPilihan("Delete Data Category : "+nama+" ???","Confirm", new Object[]{"Yes","No"}) == 0){
                cek = kategori.delete(nama); // cek=true
            } else{
                cek = false;
            }
            
        return cek;
    }
}
