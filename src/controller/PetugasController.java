/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.swing.JOptionPane;
import model.Enkripsi;
import model.Petugas;
import view.FormPetugas;
import view.FormInputPetugas;
import view.PesanDialog;

/**
 *
 * @author novalkrnfds
 */
public class PetugasController {
    private final Petugas petugas = new Petugas();
    private FormPetugas formPetugas;
    private FormInputPetugas formInputPetugas;
    private final Enkripsi enkripsi = new Enkripsi();
    private final PesanDialog pesanDialog = new PesanDialog();
    private boolean hashed = false;
    
    public void serHasehd(boolean hashed){
        this.hashed = hashed;
    }
    
    public void save(javax.swing.JTextField idPetugasTextField, javax.swing.JTextField namaPetugasTextField, javax.swing.JTextField userPetugasTextField,
            javax.swing.JPasswordField petugasPasswordField, javax.swing.JComboBox hakAksesComboBox, javax.swing.JTextArea alamatTextArea, javax.swing.JRadioButton priaRadioButton,
            javax.swing.JRadioButton wanitaRadioButton, javax.swing.JTextField noTelpTextField){
        if(!idPetugasTextField.getText().equals("")){
            petugas.setIdPetugas(idPetugasTextField.getText());
            petugas.setNamaPetugas(namaPetugasTextField.getText());
            petugas.setUserName(userPetugasTextField.getText());
            petugas.setPassword(new String(petugasPasswordField.getPassword()));
            if (hashed){
                petugas.setPassword(new String(petugasPasswordField.getPassword()));
            } else {
                try {
                    petugas.setPassword(enkripsi.hashMD5(new String(petugasPasswordField.getPassword())));
                } catch(Exception nk){
                    petugas.setPassword("");
                }
            }
            petugas.setHakAkses(hakAksesComboBox.getSelectedItem().toString());
            if(priaRadioButton.isSelected()){
                petugas.setJnsKelamin("Pria");
            } else if (wanitaRadioButton.isSelected()){
                petugas.setJnsKelamin("Wanita");
            } else{}
            petugas.setAlamat(alamatTextArea.getText());
            petugas.setNoTelp(noTelpTextField.getText());
            
            if(petugas.save()){
                FormInputPetugas.idPetugasTextField.setText("");
                FormInputPetugas.namaPetugasTextField.setText("");
                FormInputPetugas.userPetugasTextField.setText("");
                FormInputPetugas.petugasPasswordField.setText("");
                FormInputPetugas.jkbuttonGroup.clearSelection();
                FormInputPetugas.hakAksesComboBox.setSelectedItem("--------- Pilih --------");
                FormInputPetugas.alamatTextArea.setText("");
                FormInputPetugas.noTelpTextField.setText("");
                if(petugas.bacaData()){
                    FormPetugas.tampilkanData(petugas.getList());
                }
            } else {
                if (petugas.getPesan().length() > 0){
                    JOptionPane.showMessageDialog(null, petugas.getPesan(), "Kesalahan", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "ID Petugas tidak boleh kosong", "Kesalahan", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void tampilData(){
        if(petugas.bacaData()){
            FormPetugas.tampilkanData(petugas.getList());
        } else {
            JOptionPane.showMessageDialog(null, petugas.getPesan());
        }
    }
    
    public void ubah(String namaPetugas){
        formInputPetugas = new FormInputPetugas(null, true);
        if(petugas.baca(namaPetugas)){
            FormInputPetugas.idPetugasTextField.setText(petugas.getIdPetugas());
            FormInputPetugas.namaPetugasTextField.setText(petugas.getNamaPetugas());
            FormInputPetugas.userPetugasTextField.setText(petugas.getUserName());
            FormInputPetugas.petugasPasswordField.setText(petugas.getPassword());
            FormInputPetugas.hakAksesComboBox.setSelectedItem(petugas.getHakAkses());
            if(petugas.getJnsKelamin().equals("Pria")){
                FormInputPetugas.priaRadioButton.setSelected(true);
            } else if(petugas.getJnsKelamin().equals("Wanita")){
                FormInputPetugas.wanitaRadioButton.setSelected(true);
            }
            FormInputPetugas.alamatTextArea.setText(petugas.getAlamat());
            FormInputPetugas.noTelpTextField.setText(petugas.getNoTelp());
            FormInputPetugas.idPetugasTextField.setEditable(false);
            formInputPetugas.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "failed to read the data branch : "+namaPetugas +"\n"+petugas.getPesan());
        }
    }
    
    public boolean delete(String namaPetugas){
        boolean cek = false;
            petugas.baca(namaPetugas);
            if (pesanDialog.tampilkanPilihan("Delete Data Petugas : "+namaPetugas+" ???","Confirm", new Object[]{"Yes","No"}) == 0){
                cek = petugas.delete(namaPetugas); // cek=true
            } else{
                cek = false;
            }
            
        return cek;
    }
}
