/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.MerkController;
import custom.button;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author novalkrnfds
 */
public class FormDataMerk extends javax.swing.JInternalFrame {
    public static DefaultTableModel merkTableModel;
    private final MerkController merkController = new MerkController();
    
    /**
     * Creates new form FormDataBarang
     */
    public FormDataMerk() {
        initComponents();
        merkTableModel = (DefaultTableModel) merkTable.getModel();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelWarnaTransparan1 = new custom.PanelWarnaTransparan();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        panelBiasa1 = new custom.panelBiasa();
        jScrollPane1 = new javax.swing.JScrollPane();
        merkTable = new javax.swing.JTable();
        jButton1 = new button();
        panelWarnaTransparan2 = new custom.PanelWarnaTransparan();
        addButton = new button();
        editButton = new button();
        deleteButton = new button();

        setBackground(new java.awt.Color(204, 204, 255));
        setClosable(true);
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameActivated(evt);
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        panelWarnaTransparan1.setBackground(new java.awt.Color(80, 175, 175));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("DATA MERK BARANG");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Folder-Data-icon.png"))); // NOI18N

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel14.setText("\"CROCO AND SKATE THEORY\"");

        javax.swing.GroupLayout panelWarnaTransparan1Layout = new javax.swing.GroupLayout(panelWarnaTransparan1);
        panelWarnaTransparan1.setLayout(panelWarnaTransparan1Layout);
        panelWarnaTransparan1Layout.setHorizontalGroup(
            panelWarnaTransparan1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelWarnaTransparan1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelWarnaTransparan1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 473, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addContainerGap(210, Short.MAX_VALUE))
        );
        panelWarnaTransparan1Layout.setVerticalGroup(
            panelWarnaTransparan1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelWarnaTransparan1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelWarnaTransparan1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelWarnaTransparan1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel14)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        panelBiasa1.setBackground(new java.awt.Color(255, 255, 255));

        merkTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "KODE MERK", "NAMA MERK"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        merkTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(merkTable);
        if (merkTable.getColumnModel().getColumnCount() > 0) {
            merkTable.getColumnModel().getColumn(0).setResizable(false);
            merkTable.getColumnModel().getColumn(1).setResizable(false);
        }

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/saveas1.png"))); // NOI18N
        jButton1.setText("Cetak Laporan");

        javax.swing.GroupLayout panelBiasa1Layout = new javax.swing.GroupLayout(panelBiasa1);
        panelBiasa1.setLayout(panelBiasa1Layout);
        panelBiasa1Layout.setHorizontalGroup(
            panelBiasa1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBiasa1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBiasa1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBiasa1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        panelBiasa1Layout.setVerticalGroup(
            panelBiasa1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBiasa1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        panelWarnaTransparan2.setBackground(new java.awt.Color(80, 175, 175));

        addButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.png"))); // NOI18N
        addButton.setText("Add New");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        editButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit.png"))); // NOI18N
        editButton.setText("Edit");
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        deleteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/remove.png"))); // NOI18N
        deleteButton.setText("Delete");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelWarnaTransparan2Layout = new javax.swing.GroupLayout(panelWarnaTransparan2);
        panelWarnaTransparan2.setLayout(panelWarnaTransparan2Layout);
        panelWarnaTransparan2Layout.setHorizontalGroup(
            panelWarnaTransparan2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelWarnaTransparan2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelWarnaTransparan2Layout.setVerticalGroup(
            panelWarnaTransparan2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelWarnaTransparan2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(panelWarnaTransparan2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addButton)
                    .addComponent(editButton)
                    .addComponent(deleteButton))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelBiasa1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelWarnaTransparan1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelWarnaTransparan2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelWarnaTransparan1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelBiasa1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelWarnaTransparan2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void tampilkanData(Object[][] list){
        merkTableModel.setRowCount(0);
        if((list != null) && (list.length>0)){
            for (int i=0;i<list.length;i++){
               merkTableModel.addRow(list[i]);
            }
        }
    }
    
    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        // TODO add your handling code here:
        FormInputMerk add = new FormInputMerk(this, true);
        add.addMerk();
    }//GEN-LAST:event_addButtonActionPerformed

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        // TODO add your handling code here:
        if(merkTable.getSelectedRowCount() > 0){
            String pilih = merkTableModel.getValueAt(merkTable.getSelectedRow(), 1).toString();
            merkController.ubah(pilih);
        } else {
            JOptionPane.showMessageDialog(rootPane, "Belum ada yang dipilih", "Message", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_editButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        // TODO add your handling code here:
        if(merkTable.getSelectedRowCount() > 0){
            String nama = merkTableModel.getValueAt(merkTable.getSelectedRow(), 1).toString();
            if(merkController.delete(nama)){
                merkTableModel.removeRow(merkTable.getSelectedRow());
            } else{
                //JOptionPane.showMessageDialog(null, perusahaan.getPesan());
            }
        } else{
            JOptionPane.showMessageDialog(rootPane, "Belum ada yang dipilih", "Message", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
        // TODO add your handling code here:
        merkController.tampilData();
    }//GEN-LAST:event_formInternalFrameActivated


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton editButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable merkTable;
    private custom.panelBiasa panelBiasa1;
    private custom.PanelWarnaTransparan panelWarnaTransparan1;
    private custom.PanelWarnaTransparan panelWarnaTransparan2;
    // End of variables declaration//GEN-END:variables
}
