/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parameter;

/**
 *
 * @author novalkrnfds
 */
public class BarangParameter {
    public String kodeBrg, kodeMerk, namaBrg, kodeKategori, harga, jumlah, pesan;
    public Object[][] list;
    public String[] listMerk,listKategori;

    public String[] getListMerk() {
        return listMerk;
    }

    public Object[] getListKategori() {
        return listKategori;
    }

    public String getKodeBrg() {
        return kodeBrg;
    }

    public void setKodeBrg(String kodeBrg) {
        this.kodeBrg = kodeBrg;
    }

    public String getKodeMerk() {
        return kodeMerk;
    }

    public void setKodeMerk(String kodeMerk) {
        this.kodeMerk = kodeMerk;
    }

    public String getNamaBrg() {
        return namaBrg;
    }

    public void setNamaBrg(String namaBrg) {
        this.namaBrg = namaBrg;
    }

    public String getKodeKategori() {
        return kodeKategori;
    }

    public void setKodeKategori(String kodeKategori) {
        this.kodeKategori = kodeKategori;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public String getJumlah() {
        return jumlah;
    }

    public void setJumlah(String jumlah) {
        this.jumlah = jumlah;
    }

    public String getPesan() {
        return pesan;
    }

    public void setPesan(String pesan) {
        this.pesan = pesan;
    }

    public Object[][] getList() {
        return list;
    }

    public void setList(Object[][] list) {
        this.list = list;
    }
    
}
