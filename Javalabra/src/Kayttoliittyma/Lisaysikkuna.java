/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Kayttoliittyma;

import Kortisto.Kortisto;
import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.*;

/**
 *
 * @author hwikgren
 */
public class Lisaysikkuna extends javax.swing.JFrame {

    Kortisto kortisto;
    DefaultListModel model;
    HashMap<String, String> taidot;
    
    /**
     * Creates new form Lisaysikkuna
     */
    public Lisaysikkuna() {
        initComponents();
        model = new DefaultListModel();
        taidotLista.setModel(model);
        
    }

    public Lisaysikkuna(Kortisto kortisto) {
        initComponents();
        model = new DefaultListModel();
        taidotLista.setModel(model);
        this.kortisto = kortisto;
        taidot = new HashMap<String, String>();
        poistaButton.setVisible(false);
        jRadioButton1.setEnabled(false);
        jRadioButton2.setEnabled(false);
        jRadioButton3.setEnabled(false);
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        etunimi = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        sukunimi = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        uusiTaito = new javax.swing.JTextField();
        lisaaButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        taidotLista = new javax.swing.JList();
        jLabel3 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        poistaButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("TAITAJA");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lisää henkilö", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        jPanel1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jPanel1AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jLabel1.setText("Etunimi:");

        etunimi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                etunimiActionPerformed(evt);
            }
        });
        etunimi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                etunimiKeyPressed(evt);
            }
        });

        jLabel2.setText("Sukunimi:");

        sukunimi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sukunimiActionPerformed(evt);
            }
        });
        sukunimi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                sukunimiKeyPressed(evt);
            }
        });

        jLabel6.setText("Lisää taito:");

        uusiTaito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uusiTaitoActionPerformed(evt);
            }
        });
        uusiTaito.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                uusiTaitoKeyPressed(evt);
            }
        });

        lisaaButton.setText("Lisää");
        lisaaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lisaaButtonActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Taidot"));

        taidotLista.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        taidotLista.setFocusable(false);
        taidotLista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                taidotListaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(taidotLista);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        jLabel3.setText("Taso");

        buttonGroup2.add(jRadioButton1);
        jRadioButton1.setText("1");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        buttonGroup2.add(jRadioButton2);
        jRadioButton2.setText("2");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        buttonGroup2.add(jRadioButton3);
        jRadioButton3.setText("3");
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });

        jLabel4.setText("Kohtalainen");

        jLabel5.setText("Erinomainen");

        poistaButton.setText("Poista valittu taito");
        poistaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                poistaButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lisaaButton)
                        .addGap(10, 10, 10))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(etunimi, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(sukunimi, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel4)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jRadioButton1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jRadioButton2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jRadioButton3)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel5))
                                            .addComponent(jLabel6)
                                            .addComponent(uusiTaito, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(8, 8, 8)
                                        .addComponent(poistaButton)))))
                        .addGap(18, 18, 18)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(etunimi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(sukunimi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButton1)
                            .addComponent(jRadioButton2)
                            .addComponent(jRadioButton3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(31, 31, 31)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(uusiTaito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                        .addComponent(poistaButton)
                        .addGap(18, 18, 18)
                        .addComponent(lisaaButton)
                        .addGap(18, 18, 18))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private String etu;
    private String suku;
    
    private void etunimiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_etunimiActionPerformed
        sukunimi.requestFocusInWindow();
    }//GEN-LAST:event_etunimiActionPerformed

    private void sukunimiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sukunimiActionPerformed
        uusiTaito.requestFocusInWindow();
    }//GEN-LAST:event_sukunimiActionPerformed

    private void uusiTaitoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_uusiTaitoKeyPressed
        
    }//GEN-LAST:event_uusiTaitoKeyPressed

    private void uusiTaitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uusiTaitoActionPerformed
        String taito = uusiTaito.getText();
        boolean onJo = false;
        if (taidot.containsKey(taito)) {
            JOptionPane.showMessageDialog(this, "Henkilöllä on jo kyseinen taito!", "", JOptionPane.WARNING_MESSAGE);
            onJo = true;
        }
        if (!onJo) {
            model.insertElementAt(taito, 0);
            taidot.put(taito, "");
            taidotLista.ensureIndexIsVisible(0);
            taidotLista.setSelectedIndex(0);
            uusiTaito.requestFocusInWindow();
            uusiTaito.setText("");
            if (jRadioButton1.isSelected() || jRadioButton2.isSelected() || jRadioButton3.isSelected()) {
                buttonGroup2.clearSelection();
            }
            else {
                jRadioButton1.setEnabled(true);
                jRadioButton2.setEnabled(true);
                jRadioButton3.setEnabled(true);
            }
        }
    }//GEN-LAST:event_uusiTaitoActionPerformed

    private void lisaaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lisaaButtonActionPerformed
        etu = etunimi.getText();
        suku = sukunimi.getText();
        ArrayList<String> haettu = kortisto.hae(etu, suku, null);
        if (!haettu.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Henkilö "+suku+" "+etu+" on jo kortistossa!", "", JOptionPane.WARNING_MESSAGE);
        }
        else {
            kortisto.lisaaHenkilo(etu, suku);
            int indeksi = kortisto.getKoko()-1;
            for (int i=0; i<model.getSize(); i++) {
                String taito = (String)model.elementAt(i);
                kortisto.lisaaTaito(suku+" "+etu, taito, taidot.get(taito));
            }
            dispose();
        }
    }//GEN-LAST:event_lisaaButtonActionPerformed

    private void jPanel1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jPanel1AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel1AncestorAdded

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        if (!taidotLista.isSelectionEmpty()) {
            String taito = (String)model.getElementAt(taidotLista.getSelectedIndex());
            taidot.put(taito, "Hyvä");
        }
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        if (!taidotLista.isSelectionEmpty()) {
            String taito = (String)model.getElementAt(taidotLista.getSelectedIndex());
            taidot.put(taito, "Kohtalainen");
        }
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
        if (!taidotLista.isSelectionEmpty()) {
            String taito = (String)model.getElementAt(taidotLista.getSelectedIndex());
            taidot.put(taito, "Erinomainen");
        }
    }//GEN-LAST:event_jRadioButton3ActionPerformed

    private void taidotListaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_taidotListaMouseClicked
        jRadioButton1.setEnabled(true);
        jRadioButton2.setEnabled(true);
        jRadioButton3.setEnabled(true);
        String taito = (String)model.getElementAt(taidotLista.getSelectedIndex());
        String osaaminen = taidot.get(taito);
        if (osaaminen.isEmpty()) {
            buttonGroup2.clearSelection();
        }
        else if (osaaminen.equals("Hyvä")) {
            jRadioButton2.setSelected(rootPaneCheckingEnabled);
        }
        else if (osaaminen.equals("Kohtalainen")) {
            jRadioButton1.setSelected(rootPaneCheckingEnabled);
        }
        else if (osaaminen.equals("Erinomainen")) {
            jRadioButton3.setSelected(rootPaneCheckingEnabled);
        }
        poistaButton.setVisible(true);
    }//GEN-LAST:event_taidotListaMouseClicked

    private void poistaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_poistaButtonActionPerformed
        int indeksi = taidotLista.getSelectedIndex();
        String taito = (String)model.getElementAt(indeksi);
        taidot.remove(taito);
        model.remove(indeksi);
        taidotLista.setModel(model);
        taidotLista.clearSelection();
        poistaButton.setVisible(false);
        buttonGroup2.clearSelection();
    }//GEN-LAST:event_poistaButtonActionPerformed

    private void etunimiKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_etunimiKeyPressed

    }//GEN-LAST:event_etunimiKeyPressed

    private void sukunimiKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_sukunimiKeyPressed
        
    }//GEN-LAST:event_sukunimiKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Lisaysikkuna.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Lisaysikkuna.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Lisaysikkuna.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Lisaysikkuna.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Lisaysikkuna().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JTextField etunimi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton lisaaButton;
    private javax.swing.JButton poistaButton;
    private javax.swing.JTextField sukunimi;
    private javax.swing.JList taidotLista;
    private javax.swing.JTextField uusiTaito;
    // End of variables declaration//GEN-END:variables
}
