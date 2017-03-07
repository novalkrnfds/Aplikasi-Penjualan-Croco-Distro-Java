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
import parameter.TransaksiParameter;
import view.FormTransaksi;
import view.PesanDialog;

/**
 *
 * @author novalkrnfds
 */
public class Transaksi extends TransaksiParameter{
    private final Koneksi koneksi = new Koneksi();
    private final PesanDialog pesanDialog = new PesanDialog();
    
    public boolean save(){
        boolean adaKesalahan = false;
        Connection con;
                
        if ((con = koneksi.getKoneksi()) != null){
            int jumlahSimpan=0;
            boolean save = false; 
            
            try{
                String SQLStatemen = "select * from tbpenjualan where no_faktur='"+noFaktur+"'";
                Statement sta = con.createStatement();
                ResultSet rst = sta.executeQuery(SQLStatemen);
                
                rst.next();
                if (rst.getRow()>0){
                    if (pesanDialog.tampilkanPilihan("Data sudah ada\nApakah data diperbaharui?", "Konfirmasi", new Object[]{"Ya","Tidak"}) == 0){
                        save = true;
                        SQLStatemen = "update tbpenjualan set tglpenjualan='"+tgl+"',petugas ='"+petugas+"', total='"+total+"', "
                                + "bayar='"+bayar+"',bayar='"+sisa+"' where no_faktur='"+noFaktur+"'";
                        //SQLStatemen = "update tbhakases set namapetugas='"+namaPetugas+"', hakakses='"+hakAkses+"' where username='"+userName+"'";
                        System.out.println(SQLStatemen);
                        sta = con.createStatement();
                        jumlahSimpan = sta.executeUpdate(SQLStatemen);
                    }
                } else {
                    save = true;
                    SQLStatemen = "insert into tbpenjualan values('"+noFaktur+"', '"+tgl+"', '"+petugas+"','"+total+"', '"+bayar+"', '"+sisa+"')";
                    //SQLStatemen = "insert into tbhakakses values('"+userName+"', '"+password+"', '"+hakAkses+"')";
                    sta = con.createStatement();
                    jumlahSimpan = sta.executeUpdate(SQLStatemen);
                }
                
                if (save) {
                    if (jumlahSimpan < 1){
                        adaKesalahan = true; 
                        pesan = "Gagal menyimpan data";
                    }
                }
                
                sta.close();
                rst.close();
                con.close();                
            } catch (SQLException ex){
                adaKesalahan = true;
                pesan = "Tidak dapat membuka tabel tbpenjualan\n"+ex;
            }            
        } else {
            adaKesalahan = true;
            pesan = "Tidak dapat melakukan koneksi ke server\n"+koneksi.getPesan();
        }
        
        return !adaKesalahan;
    }
    
    public boolean bacaData(){
        boolean adaKesalahan = false;
        Connection connection;
        list = new Object[0][0];
        
        if ((connection = koneksi.getKoneksi()) != null){
            String SQLStatemen;
            Statement sta;
            ResultSet rset;
            
            try {
                SQLStatemen = "select tbdetailpenjualan.kodebarang,tbbarang.namabarang,tbdetailpenjualan.jumlah,tbdetailpenjualan.sub from tbdetailpenjualan,tbbarang where tbdetailpenjualan.kodebarang=tbbarang.kodebarang and tbdetailpenjualan.no_faktur";
                sta = connection.createStatement();
                rset = sta.executeQuery(SQLStatemen);
                
                rset.next();
                rset.last();
                list = new Object[rset.getRow()][4];
                
                if (rset.getRow()>0){
                    rset.first();
                    int i=0;
                    do {
                        list[i] = new Object[]{rset.getString("tbdetailpenjualan.kodebarang"), rset.getString("tbbarang.namabarang"),
                            rset.getString("tbdetailpenjualan.jumlah"),rset.getString("tbdetailpenjualan.sub")};
                        i++;
                    } while (rset.next());
                }
                
                sta.close();
                rset.close();
                connection.close();
            } catch (SQLException ex){
                adaKesalahan = true;
                pesan = "Tidak dapat membaca data\n"+ex.getMessage();
            }
        } else {
            adaKesalahan = true;
            pesan = "Tidak dapat melakukan koneksi ke server\n"+koneksi.getPesan();
        }
        
        return !adaKesalahan;
    }
    
    public boolean bacaRiwayat(){
        boolean adaKesalahan = false;
        Connection connection;
        list = new Object[0][0];
        
        if ((connection = koneksi.getKoneksi()) != null){
            String SQLStatemen;
            Statement sta;
            ResultSet rset;
            
            try {
                SQLStatemen = "select * from tbpenjualan";
                sta = connection.createStatement();
                rset = sta.executeQuery(SQLStatemen);
                
                rset.next();
                rset.last();
                list = new Object[rset.getRow()][6];
                
                if (rset.getRow()>0){
                    rset.first();
                    int i=0;
                    do {
                        list[i] = new Object[]{rset.getString("no_faktur"), rset.getString("petugas"),
                            rset.getString("tglpenjualan"),rset.getString("total"),rset.getString("bayar"),rset.getString("sisa")};
                        i++;
                    } while (rset.next());
                }
                
                sta.close();
                rset.close();
                connection.close();
            } catch (SQLException ex){
                adaKesalahan = true;
                pesan = "Tidak dapat membaca data\n"+ex.getMessage();
            }
        } else {
            adaKesalahan = true;
            pesan = "Tidak dapat melakukan koneksi ke server\n"+koneksi.getPesan();
        }
        
        return !adaKesalahan;
    }
    
    public boolean baca(String faktur){
        boolean adaKesalahan = false;
        Connection connection;
        list = new Object[0][0];
        
        if ((connection = koneksi.getKoneksi()) != null){
            String SQLStatemen;
            Statement sta;
            ResultSet rset;
            
            try {
                SQLStatemen = "select * from tbpenjualan where no_faktur='"+faktur+"'";
                sta = connection.createStatement();
                rset = sta.executeQuery(SQLStatemen);
                
                rset.next();
                rset.last();
                list = new Object[rset.getRow()][6];
                
                if (rset.getRow()>0){
                    rset.first();
                    int i=0;
                    do {
                        list[i] = new Object[]{rset.getString("no_faktur"), rset.getString("petugas"),
                            rset.getString("tglpenjualan"),rset.getString("total"),rset.getString("bayar"),rset.getString("sisa")};
                        i++;
                    } while (rset.next());
                }
                
                sta.close();
                rset.close();
                connection.close();
            } catch (SQLException ex){
                adaKesalahan = true;
                pesan = "Tidak dapat membaca data\n"+ex.getMessage();
            }
        } else {
            adaKesalahan = true;
            pesan = "Tidak dapat melakukan koneksi ke server\n"+koneksi.getPesan();
        }
        
        return !adaKesalahan;
    }
    
    public boolean delete(String faktur){
        boolean adaKesalahan = false;	
        Connection connection; 
        
        if ((connection = koneksi.getKoneksi()) != null){
            int jumlahHapus;
            Statement sta;
            
            try {
                String SQLStatemen = "delete from tbpenjualan where no_faktur='"+faktur+"'";
                sta = connection.createStatement();
                jumlahHapus = sta.executeUpdate(SQLStatemen);
                
                if (jumlahHapus < 1){
                    pesan = "Data penjualan dengan No. Faktur"+faktur+" tidak ditemukan";
                    adaKesalahan = true;
                }
                
                sta.close();
                connection.close();
            } catch (SQLException ex){
                adaKesalahan = true;
                pesan = "Tidak dapat membuka tabel tbpenjualan\n"+ex;
            }
        } else {
            adaKesalahan = true;
            pesan = "Tidak dapat melakukan koneksi ke server\n"+koneksi.getPesan();
        }
        
        return !adaKesalahan;
    }
    
    public boolean deleteDetail(String faktur){
        boolean adaKesalahan = false;	
        Connection connection; 
        
        if ((connection = koneksi.getKoneksi()) != null){
            int jumlahHapus;
            Statement sta;
            
            try {
                String SQLStatemen = "delete from tbdetailpenjualan where no_faktur='"+faktur+"'";
                sta = connection.createStatement();
                jumlahHapus = sta.executeUpdate(SQLStatemen);
                
                if (jumlahHapus < 1){
                    pesan = "Data penjualan dengan No. Faktur"+faktur+" tidak ditemukan";
                    adaKesalahan = true;
                }
                
                sta.close();
                connection.close();
            } catch (SQLException ex){
                adaKesalahan = true;
                pesan = "Tidak dapat membuka tabel tbdetailpenjualan\n"+ex;
            }
        } else {
            adaKesalahan = true;
            pesan = "Tidak dapat melakukan koneksi ke server\n"+koneksi.getPesan();
        }
        
        return !adaKesalahan;
    }
}
