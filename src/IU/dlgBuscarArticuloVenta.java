package IU;

import Componentes.RenderDecimal;
import Componentes.RenderDecimal2;
import Componentes.Software;
import Controladores.CabecerasTablas;
import Controladores.controlArticulo;
import Controladores.controlFactura;
import Modelo.Articulo;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;

public class dlgBuscarArticuloVenta extends javax.swing.JDialog {
    CabecerasTablas cabe = new CabecerasTablas();
    Articulo art;

    public dlgBuscarArticuloVenta(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        titulo();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Iconos/logo1.png")));
        cabe.tablaArticuloAuxiliar(tbDetalle);
        CabecerasTablas.limpiarTablas(tbDetalle);
        //controlArticulo.listArticuloActivo(tbDetalle, "cod");
        controlArticulo.filtrarCodBarraActivo(tbDetalle, "");
        Renders();
        txtBuscar.requestFocus();
    }
    
    final void titulo(){
        if(Software.getSoftware().equals("null")){
            this.setTitle("Buscar artículo");
        }else{
            this.setTitle(Software.getSoftware()+" - Buscar artículo");
        }
    }

    public static void Renders() {
        dlgBuscarArticuloVenta.tbDetalle.getColumnModel().getColumn(15).setCellRenderer(new RenderDecimal());
        dlgBuscarArticuloVenta.tbDetalle.getColumnModel().getColumn(13).setCellRenderer(new RenderDecimal2());
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoBotones = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbDetalle = new javax.swing.JTable()
        {
            public boolean isCellEditable(int rowInddex, int celIndex)
            {
                return false;
            }
        };
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jScrollPane1.setBackground(new java.awt.Color(210, 229, 235));
        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jScrollPane1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jScrollPane1KeyPressed(evt);
            }
        });

        tbDetalle.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        tbDetalle.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        tbDetalle.setModel(new javax.swing.table.DefaultTableModel(
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
        tbDetalle.setToolTipText("");
        tbDetalle.setFillsViewportHeight(true);
        tbDetalle.setGridColor(new java.awt.Color(204, 204, 204));
        tbDetalle.setShowVerticalLines(false);
        tbDetalle.getTableHeader().setResizingAllowed(false);
        tbDetalle.getTableHeader().setReorderingAllowed(false);
        tbDetalle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbDetalleMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbDetalleMousePressed(evt);
            }
        });
        tbDetalle.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tbDetalleKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tbDetalle);

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));

        jLabel3.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/search15.png"))); // NOI18N
        jLabel3.setText("Buscador de Artículos:");
        jLabel3.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        txtBuscar.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtBuscar.setBorder(null);
        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscarKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscarKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBuscar)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtBuscar)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 894, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbDetalleMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbDetalleMousePressed
        // TODO add your handling code here:
        if (SwingUtilities.isRightMouseButton(evt)) {
            Point p = evt.getPoint();
            int number = tbDetalle.rowAtPoint(p);
            ListSelectionModel modelos = tbDetalle.getSelectionModel();
            modelos.setSelectionInterval(number, number);
        }
    }//GEN-LAST:event_tbDetalleMousePressed

    private void tbDetalleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbDetalleMouseClicked
        // TODO add your handling code here:
        if(evt.getClickCount()==2)
        {
            controlFactura.selecArticulo();
            dlgVentas.habilitarCANTCOSTO();
            dlgVentas.txtCant.requestFocus();
            dlgVentas.txtCant.selectAll();
            this.dispose();
        }
    }//GEN-LAST:event_tbDetalleMouseClicked

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        // TODO add your handling code here:
        try {
            String cod = txtBuscar.getText();
            txtBuscar.requestFocus();
            //CabecerasTablas.limpiarTablas(tbDetalle);
            //controlArticulo.listArticuloActivo(tbDetalle, "cod");
            cabe.tablaArticuloAuxiliar(tbDetalle);
            CabecerasTablas.limpiarTablas(tbDetalle);
            controlArticulo.filtrarCodBarraActivo(tbDetalle, cod);
            Renders();
        } catch (Exception e) {
            System.out.println("Caracter Invalido " + e.getMessage());
        }
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void txtBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isLowerCase(c)) {
            String cad = ("" + c).toUpperCase();
            c = cad.charAt(0);
            evt.setKeyChar(c);
        }
    }//GEN-LAST:event_txtBuscarKeyTyped

    private void txtBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if(tbDetalle.getRowCount()==0){
                txtBuscar.requestFocus();
                txtBuscar.selectAll();
            }else{
                tbDetalle.requestFocus();
                //tbDetalle.changeSelection ( 0, 0, false, false );
                tbDetalle.getSelectionModel().setSelectionInterval(0, 0);
            }                
        }else if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
                this.dispose();
        }
    }//GEN-LAST:event_txtBuscarKeyPressed

    private void jScrollPane1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jScrollPane1KeyPressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jScrollPane1KeyPressed

    private void tbDetalleKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbDetalleKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            controlFactura.selecArticulo();
            dlgVentas.habilitarCANTCOSTO();
            this.dispose();
            dlgVentas.txtCant.requestFocus();
            dlgVentas.txtCant.selectAll();
        }else if(evt.getKeyCode()== KeyEvent.VK_ESCAPE){
            txtBuscar.requestFocus();
            txtBuscar.selectAll();
        }
    }//GEN-LAST:event_tbDetalleKeyPressed

    public static void main(String args[]) {

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dlgBuscarArticuloVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
        //</editor-fold>
        //</editor-fold>

        java.awt.EventQueue.invokeLater(() -> {
            dlgBuscarArticuloVenta dialog = new dlgBuscarArticuloVenta(new javax.swing.JFrame(), true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup grupoBotones;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable tbDetalle;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
