package IU;

import Controladores.CabecerasTablas;
import Controladores.controlArticulo;
import Controladores.controlNotaCredito;
import java.awt.Point;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;

public class dlgBuscarArticuloNCredito extends javax.swing.JDialog {

    public dlgBuscarArticuloNCredito(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        CabecerasTablas.tablaArticuloAuxiliar(jTable1);
        controlArticulo.listArticulo(jTable1, "articulo.art_codigo");
        grupo();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoBotones = new javax.swing.ButtonGroup();
        txtArt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        rbtnCod = new javax.swing.JRadioButton();
        rbtnRub = new javax.swing.JRadioButton();
        rbtnDesc = new javax.swing.JRadioButton();
        rbtnMarc = new javax.swing.JRadioButton();
        rbtnProv = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Buscar Arículo");

        txtArt.setEditable(false);
        txtArt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtArtKeyReleased(evt);
            }
        });

        jLabel2.setText("Doble Clic para seleccionar Artículo");
        jLabel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Artículo :");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.setToolTipText("Doble Clic para seleccionar Artículo");
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTable1MousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Buscar por"));

        rbtnCod.setText("Código");
        rbtnCod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnCodActionPerformed(evt);
            }
        });

        rbtnRub.setText("Rubro");
        rbtnRub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnRubActionPerformed(evt);
            }
        });

        rbtnDesc.setText("Descripción");
        rbtnDesc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnDescActionPerformed(evt);
            }
        });

        rbtnMarc.setText("Marca");
        rbtnMarc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnMarcActionPerformed(evt);
            }
        });

        rbtnProv.setText("Proveedor");
        rbtnProv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnProvActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rbtnCod)
                .addGap(18, 18, 18)
                .addComponent(rbtnProv)
                .addGap(18, 18, 18)
                .addComponent(rbtnRub)
                .addGap(18, 18, 18)
                .addComponent(rbtnDesc)
                .addGap(18, 18, 18)
                .addComponent(rbtnMarc)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(rbtnCod)
                .addComponent(rbtnRub)
                .addComponent(rbtnDesc)
                .addComponent(rbtnMarc)
                .addComponent(rbtnProv))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtArt, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtArt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtArtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtArtKeyReleased
        // TODO add your handling code here:
        String cod = txtArt.getText().trim();
        if(rbtnCod.isSelected())
        busCodigo();
        else
        if(rbtnDesc.isSelected()){
            CabecerasTablas.limpiarTablaTablaArticuloAuxiliar(jTable1);
//            controlArticulo.filtrar(jTable1, cod);
        }
        else
        if(rbtnRub.isSelected()){
            CabecerasTablas.limpiarTablaTablaArticuloAuxiliar(jTable1);
//            controlArticulo.filtrarRubro(jTable1, cod);
        }
        else
        if(rbtnMarc.isSelected()){
            CabecerasTablas.limpiarTablaTablaArticuloAuxiliar(jTable1);
//            controlArticulo.filtrarMarca(jTable1, cod);
        }
        else
        if(rbtnProv.isSelected())
        {
            CabecerasTablas.limpiarTablaTablaArticuloAuxiliar(jTable1);
 //           controlArticulo.filrarProveedor(jTable1, cod);
        }
    }//GEN-LAST:event_txtArtKeyReleased

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        if(evt.getClickCount()==2)
        {
            controlNotaCredito.selectArticulo();
            this.dispose();
            dlgNotasCredito.txtCant.requestFocus();
            dlgNotasCredito.txtCant.selectAll();
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTable1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MousePressed
        // TODO add your handling code here:
        if(SwingUtilities.isRightMouseButton(evt))
        {
            Point p = evt.getPoint();
            int number = jTable1.rowAtPoint(p);
            ListSelectionModel modelos = jTable1.getSelectionModel();
            modelos.setSelectionInterval(number, number);
        }
    }//GEN-LAST:event_jTable1MousePressed

    private void rbtnCodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnCodActionPerformed
        // TODO add your handling code here:
        seleccionRadio();
    }//GEN-LAST:event_rbtnCodActionPerformed

    private void rbtnRubActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnRubActionPerformed
        // TODO add your handling code here:
        seleccionRadio();
    }//GEN-LAST:event_rbtnRubActionPerformed

    private void rbtnDescActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnDescActionPerformed
        // TODO add your handling code here:
        seleccionRadio();
    }//GEN-LAST:event_rbtnDescActionPerformed

    private void rbtnMarcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnMarcActionPerformed
        // TODO add your handling code here:
        seleccionRadio();
    }//GEN-LAST:event_rbtnMarcActionPerformed

    private void rbtnProvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnProvActionPerformed
        // TODO add your handling code here:
        seleccionRadio();
    }//GEN-LAST:event_rbtnProvActionPerformed

    void seleccionRadio()
    {
        txtArt.setEditable(true);
        CabecerasTablas.tablaArticuloAuxiliar(jTable1);
        controlArticulo.listArticulo(jTable1, "articulo.art_codigo");
        txtArt.setText("");
        txtArt.requestFocus();
    }
    
    void busCodigo(){
        try {
            int cod = Integer.parseInt(txtArt.getText().trim());
            for(int i=0;i<jTable1.getRowCount();i++)
            {
                if(jTable1.getValueAt(i, 0).equals(cod))
                {
                    jTable1.changeSelection(i, 1, false, false);
                    break;
                }
            }
        } catch (Exception e) {
            txtArt.setText("");
        }
    }
    
    final void grupo()
    {
        grupoBotones.add(rbtnCod);
        grupoBotones.add(rbtnRub);
        grupoBotones.add(rbtnDesc);
        grupoBotones.add(rbtnMarc);
        grupoBotones.add(rbtnProv);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(dlgBuscarArticuloNCredito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dlgBuscarArticuloNCredito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dlgBuscarArticuloNCredito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dlgBuscarArticuloNCredito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                dlgBuscarArticuloNCredito dialog = new dlgBuscarArticuloNCredito(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup grupoBotones;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static final javax.swing.JTable jTable1 = new javax.swing.JTable()
    {
        public boolean isCellEditable(int rowInddex, int celIndex)
        {
            return false;
        }
    };
    private javax.swing.JRadioButton rbtnCod;
    private javax.swing.JRadioButton rbtnDesc;
    private javax.swing.JRadioButton rbtnMarc;
    private javax.swing.JRadioButton rbtnProv;
    private javax.swing.JRadioButton rbtnRub;
    private javax.swing.JTextField txtArt;
    // End of variables declaration//GEN-END:variables
}
