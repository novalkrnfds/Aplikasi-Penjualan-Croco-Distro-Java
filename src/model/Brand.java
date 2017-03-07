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
import parameter.BrandParameter;
import view.PesanDialog;

/**
 *
 * @author novalkrnfds
 */
public class Brand extends BrandParameter{
    private final Koneksi koneksi = new Koneksi();
    private final PesanDialog pesanDialog = new PesanDialog();
    
    public boolean save(){
        boolean adaKesalahan = false;
        Connection con;
                
        if ((con = koneksi.getKoneksi()) != null){
            int jumlahSimpan=0;
            boolean save = false; 
            
            try{
                String SQLStatemen = "select * from tbbrand where idbrand='"+id+"'";
                Statement sta = con.createStatement();
                ResultSet rst = sta.executeQuery(SQLStatemen);
                
                rst.next();
                if (rst.getRow()>0){
                    if (pesanDialog.tampilkanPilihan("Data sudah ada\nApakah data diperbaharui?", "Konfirmasi", new Object[]{"Ya","Tidak"}) == 0){
                        save = true;
                        SQLStatemen = "update tbbrand set idbrand='"+id+"',namabrand='"+nama+"', alamat='"+alamat+"', email='"+email+"', telp='"+telp+"' where idbrand='"+id+"'";
                        //SQLStatemen = "update tbhakases set namapetugas='"+namaPetugas+"', hakakses='"+hakAkses+"' where username='"+userName+"'";
                        System.out.println(SQLStatemen);
                        sta = con.createStatement();
                        jumlahSimpan = sta.executeUpdate(SQLStatemen);
                    }
                } else {
                    save = true;
                    SQLStatemen = "insert into tbbrand values('"+id+"', '"+nama+"', '"+alamat+"', '"+email+"', '"+telp+"')";
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
                pesan = "Tidak dapat membuka tabel tbbrand\n"+ex;
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
                SQLStatemen = "select * from tbbrand";
                sta = connection.createStatement();
                rset = sta.executeQuery(SQLStatemen);
                
                rset.next();
                rset.last();
                list = new Object[rset.getRow()][5];
                
                if (rset.getRow()>0){
                    rset.first();
                    int i=0;
                    do {
                        list[i] = new Object[]{rset.getString("idbrand"), rset.getString("namabrand"),rset.getString("alamat"),rset.getString("email"),rset.getString("telp")};
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
    
    public boolean baca(String nama){
        boolean adaKesalahan = false;	
        Connection connection;
        if ((connection = koneksi.getKoneksi()) != null){
            Statement sta;
            ResultSet rset;
                    
            try {
                String SQLStatemen = "select * from tbbrand where namabrand='"+nama+"'";
                sta = connection.createStatement();
                rset = sta.executeQuery(SQLStatemen);
                
                rset.next();
                if (rset.getRow()>0){
                    this.id = rset.getString("idbrand");
                    this.nama = rset.getString("namabrand");
                    this.alamat = rset.getString("alamat");
                    this.email = rset.getString("email");
                    this.telp = rset.getString("telp");
                } else {
                    adaKesalahan = true;
                    pesan = "The Data of : "+nama+" is not found";
                }
                
                sta.close();
                rset.close();
                connection.close();
            } catch (SQLException ex){
                adaKesalahan = true;
                pesan = "Can't open the data\n"+ex;
            }
        } else {
            adaKesalahan = true;
            pesan = "Can't connect to the server\n"+koneksi.getPesan();
        }
        
        return !adaKesalahan;
    }
    
    public boolean delete(String nama){
        boolean adaKesalahan = false;	
        Connection connection; 
        
        if ((connection = koneksi.getKoneksi()) != null){
            int jumlahHapus;
            Statement sta;
            
            try {
                String SQLStatemen = "delete from tbbrand where namabrand='"+nama+"'";
                sta = connection.createStatement();
                jumlahHapus = sta.executeUpdate(SQLStatemen);
                
                if (jumlahHapus < 1){
                    pesan = "Data dengan nama brand "+nama+" tidak ditemukan";
                    adaKesalahan = true;
                }
                
                sta.close();
                connection.close();
            } catch (SQLException ex){
                adaKesalahan = true;
                pesan = "Tidak dapat membuka tabel tbbrand\n"+ex;
            }
        } else {
            adaKesalahan = true;
            pesan = "Tidak dapat melakukan koneksi ke server\n"+koneksi.getPesan();
        }
        
        return !adaKesalahan;
    }
}
