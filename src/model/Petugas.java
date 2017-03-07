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
import view.PesanDialog;

/**
 *
 * @author novalkrnfds
 */
public class Petugas {
    private String idPetugas, namaPetugas, userName, password, hakAkses, jnsKelamin, alamat, noTelp, pesan;
    private Object[][] list;
    private final Koneksi koneksi = new Koneksi();
    private final PesanDialog pesanDialog = new PesanDialog();
    
    public String getIdPetugas(){
        return idPetugas;
    }
    
    public void setIdPetugas(String idPetugas){
        this.idPetugas = idPetugas;
    }
    
    public String getNamaPetugas(){
        return namaPetugas;
    }
    
    public void setNamaPetugas(String namaPetugas){
        this.namaPetugas = namaPetugas;
    }
    
    public String getUserName(){
        return userName;
    }
    
    public void setUserName(String userName){
        this.userName = userName;
    }
    
    public String getPassword(){
        return password;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
    
    public String getHakAkses(){
        return hakAkses;
    }
    
    public void setHakAkses(String hakAkses){
        this.hakAkses = hakAkses;
    }
    
    public String getJnsKelamin(){
        return jnsKelamin;
    }
    
    public void setJnsKelamin(String jnsKelamin){
        this.jnsKelamin = jnsKelamin;
    }
    
    public String getAlamat(){
        return alamat;
    }
    
    public void setAlamat(String alamat){
        this.alamat = alamat;
    }
    
    public String getNoTelp(){
        return noTelp;
    }
    
    public void setNoTelp(String noTelp){
        this.noTelp = noTelp;
    }
    
    public String getPesan() {
        return pesan;
    }
    
    public Object[][] getList(){
        return list;
    }
    
    public void setList(Object[][] list){
        this.list = list;
    }
    
    public boolean save(){
        boolean adaKesalahan = false;
        Connection con;
                
        if ((con = koneksi.getKoneksi()) != null){
            int jumlahSimpan=0;
            boolean save = false; 
            
            try{
                String SQLStatemen = "select * from tbpetugas where idpetugas='"+idPetugas+"'";
                Statement sta = con.createStatement();
                ResultSet rst = sta.executeQuery(SQLStatemen);
                
                rst.next();
                if (rst.getRow()>0){
                    if (pesanDialog.tampilkanPilihan("ID Petugas sudah ada\nApakah data diperbaharui?", "Konfirmasi", new Object[]{"Ya","Tidak"}) == 0){
                        save = true;
                        SQLStatemen = "update tbpetugas set namapetugas ='"+namaPetugas+"', username='"+userName+"', password='"+password+"', hakakses='"+hakAkses+"', jnskelamin='"+jnsKelamin+"',"
                            + "alamat = '"+alamat+"', notelp='"+noTelp+"' where idpetugas='"+idPetugas+"'";
                        //SQLStatemen = "update tbhakases set namapetugas='"+namaPetugas+"', hakakses='"+hakAkses+"' where username='"+userName+"'";
                        System.out.println(SQLStatemen);
                        sta = con.createStatement();
                        jumlahSimpan = sta.executeUpdate(SQLStatemen);
                    }
                } else {
                    save = true;
                    SQLStatemen = "insert into tbpetugas values('"+idPetugas+"', '"+namaPetugas+"', '"+userName+"', '"+password+"', '"+hakAkses+"', '"+jnsKelamin+"', '"+alamat+"', '"+noTelp+"')";
                    //SQLStatemen = "insert into tbhakakses values('"+userName+"', '"+password+"', '"+hakAkses+"')";
                    sta = con.createStatement();
                    jumlahSimpan = sta.executeUpdate(SQLStatemen);
                }
                
                if (save) {
                    if (jumlahSimpan < 1){
                        adaKesalahan = true; 
                        pesan = "Gagal menyimpan data petugas";
                    }
                }
                
                sta.close();
                rst.close();
                con.close();                
            } catch (SQLException ex){
                adaKesalahan = true;
                pesan = "Tidak dapat membuka tabel tbpetugas\n"+ex;
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
                SQLStatemen = "select idpetugas, namapetugas, jnskelamin, alamat, notelp from tbpetugas";
                sta = connection.createStatement();
                rset = sta.executeQuery(SQLStatemen);
                
                rset.next();
                rset.last();
                list = new Object[rset.getRow()][2];
                
                if (rset.getRow()>0){
                    rset.first();
                    int i=0;
                    do {
                        list[i] = new Object[]{rset.getString("idpetugas"), rset.getString("namapetugas"),rset.getString("jnskelamin"),
                        rset.getString("alamat"),rset.getString("notelp")};
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
    
    public boolean baca(String namaPetugas){
        boolean adaKesalahan = false;	
        Connection connection;
        if ((connection = koneksi.getKoneksi()) != null){
            Statement sta;
            ResultSet rset;
                    
            try {
                String SQLStatemen = "select * from tbpetugas where namapetugas='"+namaPetugas+"'";
                sta = connection.createStatement();
                rset = sta.executeQuery(SQLStatemen);
                
                rset.next();
                if (rset.getRow()>0){
                    this.idPetugas = rset.getString("idpetugas");
                    this.namaPetugas = rset.getString("namapetugas");
                    this.userName = rset.getString("username");
                    this.password = rset.getString("password");
                    this.hakAkses = rset.getString("hakakses");
                    this.jnsKelamin = rset.getString("jnskelamin");
                    this.alamat = rset.getString("alamat");
                    this.noTelp = rset.getString("notelp");
                    
                } else {
                    adaKesalahan = true;
                    pesan = "The Data of : "+namaPetugas+" is not found";
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
    
    public boolean bacaLogin(String user){
        boolean adaKesalahan = false;	
        Connection connection;
        if ((connection = koneksi.getKoneksi()) != null){
            Statement sta;
            ResultSet rset;
                    
            try {
                String SQLStatemen = "select * from tbpetugas where username='"+user+"'";
                sta = connection.createStatement();
                rset = sta.executeQuery(SQLStatemen);
                
                rset.next();
                if (rset.getRow()>0){
                    this.idPetugas = rset.getString("idpetugas");
                    this.namaPetugas = rset.getString("namapetugas");
                    this.userName = rset.getString("username");
                    this.password = rset.getString("password");
                    this.hakAkses = rset.getString("hakakses");
                    
                } else {
                    adaKesalahan = true;
                    pesan = "Username atau password tidak valid";
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
    
    public boolean delete(String namaPetugas){
        boolean adaKesalahan = false;	
        Connection connection; 
        
        if ((connection = koneksi.getKoneksi()) != null){
            int jumlahHapus;
            Statement sta;
            
            try {
                String SQLStatemen = "delete from tbpetugas where namaPetugas='"+namaPetugas+"'";
                sta = connection.createStatement();
                jumlahHapus = sta.executeUpdate(SQLStatemen);
                
                if (jumlahHapus < 1){
                    pesan = "Data dengan nama petugas "+namaPetugas+" tidak ditemukan";
                    adaKesalahan = true;
                }
                
                sta.close();
                connection.close();
            } catch (SQLException ex){
                adaKesalahan = true;
                pesan = "Tidak dapat membuka tabel tbpetugas\n"+ex;
            }
        } else {
            adaKesalahan = true;
            pesan = "Tidak dapat melakukan koneksi ke server\n"+koneksi.getPesan();
        }
        
        return !adaKesalahan;
    }
     
}
