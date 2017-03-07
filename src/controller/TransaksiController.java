/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.toedter.calendar.JDateChooser;
import java.util.Vector;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import model.Barang;
import model.Transaksi;
import view.FormDetailTransaksi;
import view.FormTransaksi;
import view.ListBarang;
import view.PesanDialog;

/**
 *
 * @author novalkrnfds
 */
public class TransaksiController {
    private ListBarang lb;
    private final PesanDialog pesanDialog = new PesanDialog();
    private final Barang barang = new Barang();
    private final Transaksi t = new Transaksi();
    public static Vector<Transaksi> fieldPenjualan=new Vector<Transaksi>();
    
    public void simpan(JTextField notaTextField, JDateChooser tglDateChooser, JLabel jLabel7, JLabel txtsub,
            JTextField bayarTextField, JLabel jLabel30){
        if(!jLabel7.getText().equals("0")){
            if(!bayarTextField.getText().equals("")){
                t.setNoFaktur(notaTextField.getText());
                t.setTgl(((JTextField)tglDateChooser.getDateEditor().getUiComponent()).getText());
                t.setPetugas(jLabel7.getText());
                t.setTotal(txtsub.getText());
                t.setBayar(bayarTextField.getText());
                t.setSisa(jLabel30.getText());

                if(t.save()){
                    FormTransaksi.txtsub.setText("0");
                    FormTransaksi.bayarTextField.setText("");
                    FormTransaksi.jLabel30.setText("0");
                } else {
                    if (t.getPesan().length() > 0){
                        JOptionPane.showMessageDialog(null, t.getPesan(), "Kesalahan", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Jumlah Pembayaran Belum Dimasukkan!", "Kesalahan", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Silahkan Lengkapi Dahulu", "Kesalahan", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void tampilkanListBarang(){
        lb = new ListBarang(null, true);
        
        if(barang.bacaData()){
            lb.tampilkanData(barang.getList());
            
            lb.setVisible(true);
            if(!lb.getDipilih().equals("")){
                FormTransaksi.kdTextField.setText(lb.getDipilih());
                if(barang.baca(lb.getDipilih())){
                    FormTransaksi.namaBarangTextField.setText(barang.getNamaBrg());
                    FormTransaksi.stokTextField.setText(barang.getJumlah());
                    FormTransaksi.hargaTextField.setText(barang.getHarga());
                }
            } else {
                FormTransaksi.kdTextField.setText("");
                FormTransaksi.namaBarangTextField.setText("");
                FormTransaksi.stokTextField.setText("");
                FormTransaksi.hargaTextField.setText("");
            }
        } else {
           JOptionPane.showMessageDialog(null, barang.getPesan());
        }
    }
    
    public void tampilData(){
        if(t.bacaRiwayat()){
            FormDetailTransaksi.tampilkanData(t.getList());
        } else {
            JOptionPane.showMessageDialog(null, t.getPesan());
        }
    } 
    
    public void cari(javax.swing.JTextField kdTextField){
        if (!kdTextField.getText().equals("")){
            if (barang.baca(kdTextField.getText())){
                FormTransaksi.namaBarangTextField.setText(barang.getNamaBrg());
                FormTransaksi.hargaTextField.setText(barang.getHarga());
                FormTransaksi.stokTextField.setText(barang.getJumlah());
            } else {
                FormTransaksi.namaBarangTextField.setText("");
                FormTransaksi.hargaTextField.setText(null);
                FormTransaksi.stokTextField.setText(null);
                
                JOptionPane.showMessageDialog(null, barang.getPesan(), "Kesalahan", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Kode Barang tidak boleh kosong", "Kesalahan", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public boolean delete(String faktur){
        boolean cek,cek2 = false;
            t.baca(faktur);
            if (pesanDialog.tampilkanPilihan("Delete Data Penjualan : "+faktur+" ???","Confirm", new Object[]{"Yes","No"}) == 0){
                cek = t.delete(faktur); // cek=true
                cek2 = t.deleteDetail(faktur);
            } else{
                cek = false;
                cek2 = false;
            }
            
        return cek;
    }
}
