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
import parameter.BarangParameter;
import view.PesanDialog;

/**
 *
 * @author novalkrnfds
 */
public class Barang extends BarangParameter{
    private final Koneksi koneksi = new Koneksi();
    private final PesanDialog pesanDialog = new PesanDialog();
    
    public boolean save(){
        boolean adaKesalahan = false;
        Connection con;
                
        if ((con = koneksi.getKoneksi()) != null){
            int jumlahSimpan=0;
            boolean save = false; 
            
            try{
                String SQLStatemen = "select * from tbbarang where kodebarang='"+kodeBrg+"'";
                Statement sta = con.createStatement();
                ResultSet rst = sta.executeQuery(SQLStatemen);
                
                rst.next();
                if (rst.getRow()>0){
                    if (pesanDialog.tampilkanPilihan("Data sudah ada\nApakah data diperbaharui?", "Konfirmasi", new Object[]{"Ya","Tidak"}) == 0){
                        save = true;
                        SQLStatemen = "update tbbarang set kodeBarang='"+kodeBrg+"',kodemerk ='"+kodeMerk+"', namabarang='"+namaBrg+"', "
                                + "kodekategori='"+kodeKategori+"', harga='"+harga+"', jumlah='"+jumlah+"' where kodebarang='"+kodeBrg+"'";
                        //SQLStatemen = "update tbhakases set namapetugas='"+namaPetugas+"', hakakses='"+hakAkses+"' where username='"+userName+"'";
                        System.out.println(SQLStatemen);
                        sta = con.createStatement();
                        jumlahSimpan = sta.executeUpdate(SQLStatemen);
                    }
                } else {
                    save = true;
                    SQLStatemen = "insert into tbbarang values('"+kodeBrg+"', '"+kodeMerk+"', '"+namaBrg+"','"+kodeKategori+"', '"+harga+"', '"+jumlah+"')";
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
                pesan = "Tidak dapat membuka tabel tbbarang\n"+ex;
            }            
        } else {
            adaKesalahan = true;
            pesan = "Tidak dapat melakukan koneksi ke server\n"+koneksi.getPesan();
        }
        
        return !adaKesalahan;
    }
    
    
    
    public boolean baca(String kode){
        boolean adaKesalahan = false;	
        Connection connection; 
        
        this.kodeBrg = "";
        this.namaBrg = "";
        this.kodeMerk = "";
        this.kodeKategori = "";
        this.jumlah = "";
        this.harga = "";
        
        if ((connection = koneksi.getKoneksi()) != null){
            Statement sta;
            ResultSet rset;
                    
            try {
                String SQLStatemen = "select * from tbbarang where kodebarang='"+kode+"'";
                sta = connection.createStatement();
                rset = sta.executeQuery(SQLStatemen);
                
                rset.next();
                if (rset.getRow()>0){
                    this.kodeBrg = rset.getString("kodebarang");
                    this.namaBrg = rset.getString("namabarang");
                    this.kodeMerk = rset.getString("kodemerk");
                    this.kodeKategori = rset.getString("kodekategori");
                    this.jumlah = rset.getString("jumlah");
                    this.harga = rset.getString("harga");
                } else {
                    adaKesalahan = true;
                    pesan = "Kode barang \""+kode+"\" tidak ditemukan";
                }
                
                sta.close();
                rset.close();
                connection.close();
            } catch (SQLException ex){
                adaKesalahan = true;
                pesan = "Tidak dapat membuka tabel tbbarang\n"+ex;
            }
        } else {
            adaKesalahan = true;
            pesan = "Tidak dapat melakukan koneksi ke server\n"+koneksi.getPesan();
        }
        
        return !adaKesalahan;
    }
    
    public boolean bacaRiwayat(String nota){
        boolean adaKesalahan = false;	
        Connection connection; 
        
        this.kodeBrg = "";
        this.namaBrg = "";
        this.kodeMerk = "";
        this.kodeKategori = "";
        this.jumlah = "";
        this.harga = "";
        
        if ((connection = koneksi.getKoneksi()) != null){
            Statement sta;
            ResultSet rset;
                    
            try {
                String SQLStatemen = "select * from tbbarangmasuk where no_nota='"+nota+"'";
                sta = connection.createStatement();
                rset = sta.executeQuery(SQLStatemen);
                
                rset.next();
                if (rset.getRow()>0){
                    this.kodeBrg = rset.getString("no_nota");
                    this.namaBrg = rset.getString("idbrand");
                    this.kodeMerk = rset.getString("idpetugas");
                    this.kodeKategori = rset.getString("tglmasuk");
                    this.jumlah = rset.getString("total");
                } else {
                    adaKesalahan = true;
                    pesan = "Data Barang Masuk dengan nota : "+nota+" tidak ditemukan";
                }
                
                sta.close();
                rset.close();
                connection.close();
            } catch (SQLException ex){
                adaKesalahan = true;
                pesan = "Tidak dapat membuka tabel tbbarangmasuk\n"+ex;
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
                SQLStatemen = "select * from tbbarangmasuk";
                sta = connection.createStatement();
                rset = sta.executeQuery(SQLStatemen);
                
                rset.next();
                rset.last();
                list = new Object[rset.getRow()][5];
                
                if (rset.getRow()>0){
                    rset.first();
                    int i=0;
                    do {
                        list[i] = new Object[]{rset.getString("no_nota"), rset.getString("idbrand"),
                            rset.getString("idpetugas"),rset.getString("tglmasuk"),rset.getString("total")};
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
    
    public boolean bacaData(){
        boolean adaKesalahan = false;
        Connection connection;
        list = new Object[0][0];
        
        if ((connection = koneksi.getKoneksi()) != null){
            String SQLStatemen;
            Statement sta;
            ResultSet rset;
            
            try {
                SQLStatemen = "select * from tbbarang";
                sta = connection.createStatement();
                rset = sta.executeQuery(SQLStatemen);
                
                rset.next();
                rset.last();
                list = new Object[rset.getRow()][6];
                
                if (rset.getRow()>0){
                    rset.first();
                    int i=0;
                    do {
                        list[i] = new Object[]{rset.getString("kodebarang"), rset.getString("namabarang"),rset.getString("kodemerk"), 
                            rset.getString("kodekategori"),rset.getString("harga"),rset.getString("jumlah")};
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
    
    public boolean delete(String kode){
        boolean adaKesalahan = false;	
        Connection connection; 
        
        if ((connection = koneksi.getKoneksi()) != null){
            int jumlahHapus;
            Statement sta;
            
            try {
                String SQLStatemen = "delete from tbbarang where kodebarang='"+kode+"'";
                sta = connection.createStatement();
                jumlahHapus = sta.executeUpdate(SQLStatemen);
                
                if (jumlahHapus < 1){
                    pesan = "Data dengan nama barang "+kode+" tidak ditemukan";
                    adaKesalahan = true;
                }
                
                sta.close();
                connection.close();
            } catch (SQLException ex){
                adaKesalahan = true;
                pesan = "Tidak dapat membuka tabel tbbarang\n"+ex;
            }
        } else {
            adaKesalahan = true;
            pesan = "Tidak dapat melakukan koneksi ke server\n"+koneksi.getPesan();
        }
        
        return !adaKesalahan;
    }
    
    public boolean deleteBrgMasuk(String nota){
        boolean adaKesalahan = false;	
        Connection connection; 
        
        if ((connection = koneksi.getKoneksi()) != null){
            int jumlahHapus;
            Statement sta;
            
            try {
                String SQLStatemen = "delete from tbbarangmasuk where no_nota='"+nota+"'";
                sta = connection.createStatement();
                jumlahHapus = sta.executeUpdate(SQLStatemen);
                
                if (jumlahHapus < 1){
                    pesan = "Data Barang Masuk dengan No. Nota"+nota+" tidak ditemukan";
                    adaKesalahan = true;
                }
                
                sta.close();
                connection.close();
            } catch (SQLException ex){
                adaKesalahan = true;
                pesan = "Tidak dapat membuka tabel tbbarangmasuk\n"+ex;
            }
        } else {
            adaKesalahan = true;
            pesan = "Tidak dapat melakukan koneksi ke server\n"+koneksi.getPesan();
        }
        
        return !adaKesalahan;
    }
    
    public boolean deleteDetail(String nota){
        boolean adaKesalahan = false;	
        Connection connection; 
        
        if ((connection = koneksi.getKoneksi()) != null){
            int jumlahHapus;
            Statement sta;
            
            try {
                String SQLStatemen = "delete from tbdetailbrgmasuk where no_nota='"+nota+"'";
                sta = connection.createStatement();
                jumlahHapus = sta.executeUpdate(SQLStatemen);
                
                if (jumlahHapus < 1){
                    pesan = "Data Barang Masuk dengan No. Nota"+nota+" tidak ditemukan";
                    adaKesalahan = true;
                }
                
                sta.close();
                connection.close();
            } catch (SQLException ex){
                adaKesalahan = true;
                pesan = "Tidak dapat membuka tabel tbdetailbrgmasuk\n"+ex;
            }
        } else {
            adaKesalahan = true;
            pesan = "Tidak dapat melakukan koneksi ke server\n"+koneksi.getPesan();
        }
        
        return !adaKesalahan;
    }
    
    public boolean tampilCb(){
        boolean adaKesalahan = false;
        Connection connection;
        listMerk = new String[0];
        
        if ((connection = koneksi.getKoneksi()) != null){
            String SQLStatemen;
            Statement sta;
            ResultSet rset;
            
            try {
                SQLStatemen = "select * from tbmerk";
                sta = connection.createStatement();
                rset = sta.executeQuery(SQLStatemen);
                
                rset.next();
                rset.last();
                listMerk = new String[rset.getRow()];
                
                if (rset.getRow()>0){
                    rset.first();
                    int i=0;
                    do {
                        listMerk[i] = rset.getString("namamerk");
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
}
