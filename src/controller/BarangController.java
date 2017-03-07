/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import model.Barang;
import model.BarangMasuk;
import model.Kategori;
import model.Merk;
import view.FormBarangMasuk;
import view.FormDataBarang;
import view.FormInputBarang;
import view.PesanDialog;
import view.RiwayatBrgMasuk;

/**
 *
 * @author novalkrnfds
 */
public class BarangController {
    private final Barang barang = new Barang();
    private final Merk merk = new Merk();
    private final Kategori kategori = new Kategori();
    private final BarangMasuk barangMasuk = new BarangMasuk();
    private final PesanDialog pesanDialog = new PesanDialog();
    private FormInputBarang formInputBarang;
    private FormDataBarang formBarang;
    private FormBarangMasuk formBarangMasuk;
    
    public void simpan(JTextField kodeBarangTextField, JComboBox merkComboBox, JTextField namaTextField, JComboBox kategoriComboBox,
            JTextField hargaTextField, JTextField jumlahTextField){
        if(!kodeBarangTextField.getText().equals("")){
            barang.setKodeBrg(kodeBarangTextField.getText());
            barang.setKodeMerk((merkComboBox.getSelectedItem().toString()));
            barang.setNamaBrg(namaTextField.getText());
            barang.setKodeKategori(kategoriComboBox.getSelectedItem().toString());
            barang.setHarga(hargaTextField.getText());
            barang.setJumlah(jumlahTextField.getText());
            
            if(barang.save()){
                FormInputBarang.kodeBarangTextField.setText("");
                FormInputBarang.merkComboBox.setSelectedItem("--- Pilih ---");
                FormInputBarang.namaTextField.setText("");
                FormInputBarang.kategoriComboBox.setSelectedItem("--- Pilih ---");
                FormInputBarang.hargaTextField.setText("");
                FormInputBarang.jumlahTextField.setText("");
                
                if(barang.bacaData()){
                    FormDataBarang.tampilkanData(barang.getList());
                }
            } else {
                if (barang.getPesan().length() > 0){
                    JOptionPane.showMessageDialog(null, barang.getPesan(), "Kesalahan", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Kode barang tidak boleh kosong", "Kesalahan", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void simpanBrgMasuk(JTextField notaTextField, JComboBox brandComboBox, JTextField petugasText, JDateChooser tglDateChooser,
            JTextField totalTextField){
        if(!totalTextField.getText().equals("")){
            barangMasuk.setNoNota(notaTextField.getText());
            barangMasuk.setIdBrand(brandComboBox.getSelectedItem().toString());
            barangMasuk.setIdPetugas(petugasText.getText());
            barangMasuk.setTglMasuk(((JTextField)tglDateChooser.getDateEditor().getUiComponent()).getText());
            barangMasuk.setTotal(totalTextField.getText());
            
            if(barangMasuk.save()){
                FormBarangMasuk.brandComboBox.setSelectedItem("---- PILIH ----");
                FormBarangMasuk.namaBText.setText("");
                FormBarangMasuk.totalTextField.setText("");
            } else {
                if (barangMasuk.getPesan().length() > 0){
                    JOptionPane.showMessageDialog(null, barang.getPesan(), "Kesalahan", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Kode barang tidak boleh kosong", "Kesalahan", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void tampilData(){
        if(barang.bacaData()){
            FormDataBarang.tampilkanData(barang.getList());
        } else {
            JOptionPane.showMessageDialog(null, barang.getPesan());
        }
    }   
    
    public void tampilRiwayat(){
        if(barang.bacaRiwayat()){
            RiwayatBrgMasuk.tampilkanData(barang.getList());
        } else {
            JOptionPane.showMessageDialog(null, barang.getPesan());
        }
    }
    
    public void ubah(String kode){
        formInputBarang = new FormInputBarang(null, true);
        if(barang.baca(kode)){
            FormInputBarang.kodeBarangTextField.setText(barang.getKodeBrg());
            FormInputBarang.namaTextField.setText(barang.getNamaBrg());
            FormInputBarang.merkComboBox.setSelectedItem(barang.getKodeMerk());
            FormInputBarang.kategoriComboBox.setSelectedItem(barang.getKodeKategori());
            FormInputBarang.hargaTextField.setText(barang.getHarga());
            FormInputBarang.jumlahTextField.setText(barang.getJumlah());
            formInputBarang.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "failed to read the data barang : "+kode +"\n"+barang.getPesan());
        }
    }
    
    public void tampilCb(){
        if(merk.tampilCb()){
            if(kategori.tampilCb()){
                FormInputBarang.merkComboBox.addItem(merk.getNama());
                FormInputBarang.kategoriComboBox.addItem(kategori.getNama());
            }
        }
    }
    
    public void cb(){
        if(barang.tampilCb()){
            FormInputBarang.merkComboBox.addItem(barang.listMerk);
        }
    }
    
    public boolean delete(String kode){
        boolean cek = false;
            barang.baca(kode);
            if (pesanDialog.tampilkanPilihan("Delete Data Barang : "+kode+" ???","Confirm", new Object[]{"Yes","No"}) == 0){
                cek = barang.delete(kode); // cek=true
            } else{
                cek = false;
            }
            
        return cek;
    }
    
    public boolean deteleRiwayat(String nota){
        boolean cek,cek2 = false;
        barang.bacaRiwayat(nota);
            if (pesanDialog.tampilkanPilihan("Delete Data Barang Masuk : "+nota+" ???","Confirm", new Object[]{"Yes","No"}) == 0){
                cek = barang.deleteBrgMasuk(nota); // cek=true
                cek2 = barang.deleteDetail(nota);
            } else{
                cek = false;
                cek2 = false;
            }    
        return cek;
    }
    
}
