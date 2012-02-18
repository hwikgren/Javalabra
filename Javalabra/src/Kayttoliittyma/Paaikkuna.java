/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Kayttoliittyma;

import Kortisto.Kortisto;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;


/**
 *
 * @author hwikgren
 */
public class Paaikkuna extends javax.swing.JFrame implements Observer {

    
    Kortisto kortisto;
    Henkiloikkuna henkilo;
    Lisaysikkuna lisays;
    Hakuikkuna haku;
    /**
     * Creates new form Paaikkuna
     */
    public Paaikkuna() throws FileNotFoundException, IOException, ClassNotFoundException {
        
        initComponents();
        kortisto = new Kortisto();
        kortisto.addObserver(this);
        String[] lista = kortisto.kaikkiHenkilot();
        henkilolista.setListData(lista);
        poistaButton.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        henkilolista = new javax.swing.JList();
        lisaaButton = new javax.swing.JButton();
        poistaButton = new javax.swing.JButton();
        lopetaButton = new javax.swing.JButton();
        HaeButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("TAITAJA");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Henkilöt"));

        henkilolista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                henkilolistaMouseClicked(evt);
            }
        });
        henkilolista.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                henkilolistaValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(henkilolista);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );

        lisaaButton.setText("Lisää henkilö");
        lisaaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lisaaButtonActionPerformed(evt);
            }
        });

        poistaButton.setText("Poista valittu henkilö");
        poistaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                poistaButtonActionPerformed(evt);
            }
        });

        lopetaButton.setText("Lopeta");
        lopetaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lopetaButtonActionPerformed(evt);
            }
        });

        HaeButton.setText("Hae");
        HaeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HaeButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lisaaButton)
                            .addComponent(poistaButton))
                        .addGap(0, 15, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lopetaButton, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(HaeButton, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addContainerGap())))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {HaeButton, lopetaButton});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lisaaButton)
                .addGap(18, 18, 18)
                .addComponent(poistaButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 125, Short.MAX_VALUE)
                .addComponent(HaeButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lopetaButton)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void poistaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_poistaButtonActionPerformed
        String poistettava = (String)henkilolista.getSelectedValue();
        Object[] valinnat = {"Ei", "Kyllä"};
        int valinta = JOptionPane.showOptionDialog(this, "Olet poistamassa henkilön "+poistettava+".\n"
                + "Tämä poistaa myös kaikki henkilöön liitetyt taidot!\n"
                + "Haluatko jatkaa?", "", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, valinnat, valinnat[1]);
        if (valinta == 1) {
            kortisto.poistaHenkilo(poistettava);
            String[] lista = kortisto.kaikkiHenkilot();
            henkilolista.setListData(lista);
            henkilolista.clearSelection();
            poistaButton.setVisible(false);
        }
    }//GEN-LAST:event_poistaButtonActionPerformed

    private void henkilolistaValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_henkilolistaValueChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_henkilolistaValueChanged

    private void lopetaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lopetaButtonActionPerformed
        try {
            kortisto.tallennaTiedot();
        } catch (IOException ex) {
            Logger.getLogger(Paaikkuna.class.getName()).log(Level.SEVERE, null, ex);
        }
        dispose();
    }//GEN-LAST:event_lopetaButtonActionPerformed

    private void henkilolistaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_henkilolistaMouseClicked
        if (evt.getClickCount() == 1) {
            poistaButton.setVisible(true);
        }
        else if (evt.getClickCount() == 2) {
            String valittu = (String)henkilolista.getSelectedValue();
            henkilo = new Henkiloikkuna(kortisto, valittu);
            //ikkuna.setSize(450, 400);
            henkilo.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            henkilo.setVisible(true);
        }
    }//GEN-LAST:event_henkilolistaMouseClicked

    private void lisaaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lisaaButtonActionPerformed
        lisays = new Lisaysikkuna(kortisto);
        lisays.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        lisays.setVisible(true);
    }//GEN-LAST:event_lisaaButtonActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        try {
            kortisto.tallennaTiedot();
        } catch (IOException ex) {
            Logger.getLogger(Paaikkuna.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowClosing

    private void HaeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HaeButtonActionPerformed
        haku = new Hakuikkuna(kortisto);
        haku.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        haku.setVisible(true);
    }//GEN-LAST:event_HaeButtonActionPerformed

    
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
            java.util.logging.Logger.getLogger(Paaikkuna.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Paaikkuna.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Paaikkuna.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Paaikkuna.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        

        
        
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                try {
                    new Paaikkuna().setVisible(true);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Paaikkuna.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(Paaikkuna.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Paaikkuna.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton HaeButton;
    public static javax.swing.JList henkilolista;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton lisaaButton;
    private javax.swing.JButton lopetaButton;
    private javax.swing.JButton poistaButton;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Observable o, Object o1) {
        String[] lista = (String[])o1;
        henkilolista.setListData(lista);
    }
}
