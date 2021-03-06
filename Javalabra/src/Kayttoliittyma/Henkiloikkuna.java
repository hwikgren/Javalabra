/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Kayttoliittyma;

import Kortisto.Henkilo;
import Kortisto.Kortisto;
import java.util.Observable;
import java.util.Observer;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;

/**
 * Ikkuna yhden henkilön tieton tarkasteluun.
 * @author hwikgren
 */
public class Henkiloikkuna extends javax.swing.JFrame implements Observer {

    Kortisto kortisto;
    Henkilo olio;
    DefaultListModel model;
    String henkilonNimi;
    String[][] tasot;
    String[][] tasoja;
    TitledBorder border;
    NimenMuutos henkilo;
    
    
    /**
     * Creates new form Henkiloikkuna
     */
    public Henkiloikkuna() {
        initComponents();
    }

    /**
     * Konstruktori saa tiedon kortistosta ja henkilöstä.
     * Tekee reunuksen jossa on henkilön nimi.
     * Kutsuu haeTiedot metodia ja asettaa henkilö-olion observeriksi.
     * @param kortisto
     * @param nimi 
     */
    public Henkiloikkuna(Kortisto kortisto, String nimi) {
        initComponents();
        this.kortisto = kortisto;
        this.henkilonNimi = nimi;
        border = BorderFactory.createTitledBorder(henkilonNimi);
        border.setTitleJustification(TitledBorder.CENTER);
        border.setTitlePosition(TitledBorder.CENTER);
        jPanel3.setBorder(border);
        Nimi.setText(henkilonNimi);
        haeTiedot();
        taidotLista.setSelectedIndex(0);
        String osaaminen = tasot[0][1];
        naytaTaso(osaaminen);
        olio = kortisto.valitaHenkiloOlio(henkilonNimi);
        olio.addObserver(this);
        henkilo = new NimenMuutos(kortisto, henkilonNimi);
    }
    
    /**
     * Metodi hakee kortistosta henkilön taidot ja lisää ne listalle.
     */
    private void haeTiedot() {
        tasot = kortisto.haeTaidot(henkilonNimi);
        model = new DefaultListModel();
        for (int i=0; i<tasot.length; i++) {
            model.addElement(tasot[i][0]);
        }
        taidotLista.setModel(model);
    }
    
    /**
     * Metodi lisää radioButtonin mukaisen tason taidolle.
     * Kutsuu tallenna- ja haeTiedot-metodeja.
     * @param indeksi
     * @param taso 
     */
    private void tallennaTaso(int indeksi, String taso) {
        String taito = (String)model.getElementAt(indeksi);
        tasot[indeksi][0] = taito;
        tasot[indeksi][1] = taso;
        tallenna();
        haeTiedot();
        int uusiIndeksi = model.indexOf((Object)taito);
        taidotLista.setSelectedIndex(uusiIndeksi);
        
        
    }
    
    /**
     * Metodi tallentaa henkilön taidot kortistoon.
     * Pyytää ensin tyhjentämään henkilön taidot.
     * Lisää sitten listalla olevat taidot ja tasot henkilölle.
     */
    private void tallenna() {
        kortisto.tyhjennaHenkilonTaidot(henkilonNimi);
        for (int i=0; i<tasot.length; i++) {
            kortisto.lisaaTaito(henkilonNimi, tasot[i][0], tasot[i][1]);
        }
    }
    
    /**
     * Metodi asettaa osaamisen vaatiman radioButtonin aktiiviseksi.
     * @param osaaminen 
     */
    private void naytaTaso(String osaaminen) {
        if (osaaminen.equals("Hyvä")) {
            jRadioButton2.setSelected(rootPaneCheckingEnabled);
        }
        else if (osaaminen.equals("Kohtalainen")) {
            jRadioButton1.setSelected(rootPaneCheckingEnabled);
        }
        else if (osaaminen.equals("Erinomainen")) {
            jRadioButton3.setSelected(rootPaneCheckingEnabled);
        }
        else {
            buttonGroup1.clearSelection();
        }
    }
    
    /**
     * Metodi piilottaa poista-napin, poistaa valinnat ja laittaa radioButtonit ei-aktiivisiksi.
     */
    private void piilota() {
        jRadioButton1.setEnabled(false);
        jRadioButton2.setEnabled(false);
        jRadioButton3.setEnabled(false);
        poistaButton.setVisible(false);
        if (!taidotLista.isSelectionEmpty()) {
            taidotLista.clearSelection();
        }
        if (buttonGroup1.getSelection() != null) {
            buttonGroup1.clearSelection();
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        taidotLista = new javax.swing.JList();
        jLabel1 = new javax.swing.JLabel();
        uusiTaito = new javax.swing.JTextField();
        TallennaButton = new javax.swing.JButton();
        Nimi = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        poistaButton = new javax.swing.JButton();
        muokkaaButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("TAITAJA");

        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel3MouseClicked(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        taidotLista.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        taidotLista.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        taidotLista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                taidotListaMouseClicked(evt);
            }
        });
        taidotLista.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                taidotListaValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(taidotLista);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel1.setText("Uusi taito:");

        uusiTaito.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                uusiTaitoMouseClicked(evt);
            }
        });
        uusiTaito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uusiTaitoActionPerformed(evt);
            }
        });

        TallennaButton.setText("Tallenna");
        TallennaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TallennaButtonActionPerformed(evt);
            }
        });

        Nimi.setFont(new java.awt.Font("Helvetica", 1, 20)); // NOI18N
        Nimi.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel3.setText("Taso");

        jLabel4.setText("Kohtalainen");

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("1");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("2");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setText("3");
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });

        jLabel5.setText("Erinomainen");

        poistaButton.setText("Poista valittu taito");
        poistaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                poistaButtonActionPerformed(evt);
            }
        });

        muokkaaButton.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        muokkaaButton.setText("Muokkaa nimeä");
        muokkaaButton.setFocusable(false);
        muokkaaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                muokkaaButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(poistaButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TallennaButton, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(12, 12, 12)
                                        .addComponent(jRadioButton1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jRadioButton2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jRadioButton3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel5))
                                    .addComponent(jLabel1)
                                    .addComponent(uusiTaito, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(90, 90, 90)
                                        .addComponent(jLabel3)))
                                .addComponent(muokkaaButton, javax.swing.GroupLayout.Alignment.TRAILING))))
                    .addComponent(Nimi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(Nimi, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(muokkaaButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButton1)
                            .addComponent(jRadioButton2)
                            .addComponent(jRadioButton3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(uusiTaito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TallennaButton)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(poistaButton)))
                .addGap(75, 75, 75))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Metodi reagoi enteriin taidonlisäys kentässä.
     * Teksti otetaan talteen ja tarkastetaan ettei henkilöllä jo ole kyseistä taitoa.
     * Jos ei, vanhat taidot siirretään yhtä pidempään taulukkoon.
     * Taidot tallennetaan ja haetaan uudelleen.
     * Kursori pidetään taidonlisäys kentässä mutta teksti poistetaan.
     * @param evt 
     */
    private void uusiTaitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uusiTaitoActionPerformed
        String taito = uusiTaito.getText().trim().toUpperCase();
        if (!taito.equals("")) {
            boolean onJo = false;
            for (int i=0; i<tasot.length; i++) {
                if (tasot[i][0].equalsIgnoreCase(taito)) {
                    JOptionPane.showMessageDialog(this, "Henkilöllä on jo kyseinen taito!", "", JOptionPane.WARNING_MESSAGE);
                    onJo = true;
                }
                break;
            }
            if (!onJo) {
                model.insertElementAt(taito, 0);
                String[][] taidot = new String[tasot.length+1][2];
                for (int i=0; i<tasot.length; i++) {
                    taidot[i][0] = tasot[i][0];
                    taidot[i][1] = tasot[i][1];
                }
                taidot[taidot.length-1][0] = taito;
                taidot[taidot.length-1][1] = "";
                tasot = taidot;
                tallenna();
                haeTiedot();
                int uusiIndeksi = model.indexOf(taito);
                taidotLista.ensureIndexIsVisible(uusiIndeksi);
                uusiTaito.requestFocusInWindow();
                uusiTaito.setText("");
            }
        }
    }//GEN-LAST:event_uusiTaitoActionPerformed

    /**
     * Metodi sulkee ikkunan.
     * @param evt 
     */
    private void TallennaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TallennaButtonActionPerformed
        dispose();
    }//GEN-LAST:event_TallennaButtonActionPerformed

    /**
     * Metodi reagoi radioButtonin 1 klikkaamiseen.
     * Tallentaa valitulle taidolle kyseisen tason.
     * @param evt 
     */
    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        int indeksi = taidotLista.getSelectedIndex();
        tallennaTaso(indeksi, "Kohtalainen");
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    /**
     * Metodi reagoi radioButtonin 2 klikkaamiseen.
     * Tallentaa valitulle taidolle kyseisen tason.
     * @param evt 
     */
    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        int indeksi = taidotLista.getSelectedIndex();
        tallennaTaso(indeksi, "Hyvä");
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    /**
     * Metodi reagoi radioButtonin 3 klikkaamiseen.
     * Tallentaa valitulle taidolle kyseisen tason.
     * @param evt 
     */
    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
        int indeksi = taidotLista.getSelectedIndex();
        tallennaTaso(indeksi, "Erinomainen");
    }//GEN-LAST:event_jRadioButton3ActionPerformed

    private void taidotListaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_taidotListaMouseClicked
        
    }//GEN-LAST:event_taidotListaMouseClicked

    /**
     * Metodi poistaa taidon henkilön listalta.
     * @param evt 
     */
    private void poistaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_poistaButtonActionPerformed
        int indeksi = taidotLista.getSelectedIndex();
        String taito = (String)model.getElementAt(indeksi);
        kortisto.poistaTaito(henkilonNimi, taito);
        haeTiedot();
        piilota();
    }//GEN-LAST:event_poistaButtonActionPerformed

    /**
     * Metodi avaa nimen muokkaus ikkunan.
     * @param evt 
     */
    private void muokkaaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_muokkaaButtonActionPerformed
        
            //ikkuna.setSize(450, 400);
        henkilo.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        henkilo.setVisible(true);
    }//GEN-LAST:event_muokkaaButtonActionPerformed

    /**
     * Metodi reagoi siihen, että taustaa klikataan.
     * Kutsuu piilota metodia.
     * @param evt 
     */
    private void jPanel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseClicked
        piilota();
    }//GEN-LAST:event_jPanel3MouseClicked

    /**
     * Metodi reagoi siihen, että taidon lisäys kenttää klikataan.
     * Kutsuu piilota metodia.
     * @param evt 
     */
    private void uusiTaitoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_uusiTaitoMouseClicked
        piilota();
    }//GEN-LAST:event_uusiTaitoMouseClicked

    /**
     * Metodi pitää huolen siitä mikä taito on valittu listalta.
     * Jos joku taito on valittu, radiobuttonit tulevat näkyviin ja taitoa vastaava taso näkyy.
     * @param evt 
     */
    private void taidotListaValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_taidotListaValueChanged
        if (taidotLista.isSelectionEmpty() == false) {
            poistaButton.setVisible(true);
            jRadioButton1.setEnabled(true);
            jRadioButton2.setEnabled(true);
            jRadioButton3.setEnabled(true);
            int indeksi = taidotLista.getSelectedIndex();
            //String taito = (String)model.getElementAt(indeksi);
            String osaaminen = tasot[indeksi][1];
            naytaTaso(osaaminen);
        }
        
    }//GEN-LAST:event_taidotListaValueChanged

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
            java.util.logging.Logger.getLogger(Henkiloikkuna.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Henkiloikkuna.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Henkiloikkuna.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Henkiloikkuna.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Henkiloikkuna().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Nimi;
    private javax.swing.JButton TallennaButton;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton muokkaaButton;
    private javax.swing.JButton poistaButton;
    private javax.swing.JList taidotLista;
    private javax.swing.JTextField uusiTaito;
    // End of variables declaration//GEN-END:variables

    /**
     * Metodi päivittää henkilön nimen, kun observer ilmoittaa että listalla on tapahtunut muutos.
     * @param o
     * @param o1 
     */
    @Override
    public void update(Observable o, Object o1) {
        Nimi.setText((String)o1);
        border = BorderFactory.createTitledBorder((String)o1);
        border.setTitleJustification(TitledBorder.CENTER);
        border.setTitlePosition(TitledBorder.CENTER);
        jPanel3.setBorder(border);
        henkilonNimi = (String)o1;
    }
}
