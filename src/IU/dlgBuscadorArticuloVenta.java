package IU;

import Componentes.RenderDecimalPublico;
import Componentes.RenderDecimalVenta;
import Componentes.Software;
import Controladores.CabecerasTablas;
import Controladores.controlArticulo;
import Controladores.controlFactura;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;

public class dlgBuscadorArticuloVenta extends javax.swing.JDialog {

    public dlgBuscadorArticuloVenta(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        titulo();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Iconos/logo1.png")));
        CabecerasTablas.tablaArticuloAuxiliar(tbDetalle);
        CabecerasTablas.limpiarTablaTablaArticuloAuxiliar(tbDetalle);
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
        dlgBuscadorArticuloVenta.tbDetalle.getColumnModel().getColumn(15).setCellRenderer(new RenderDecimalVenta());
        dlgBuscadorArticuloVenta.tbDetalle.getColumnModel().getColumn(13).setCellRenderer(new RenderDecimalPublico());
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnFondoBlanco = new javax.swing.JPanel();
        pnFondoCabecera = new javax.swing.JPanel();
        txtBuscar = new rojeru_san.rsfield.RSTextMaterial();
        jScrollPane1 = new javax.swing.JScrollPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        pnFondoBlanco.setBackground(new java.awt.Color(255, 255, 255));
        pnFondoBlanco.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(17, 35, 46)));
        pnFondoBlanco.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnFondoCabecera.setBackground(new java.awt.Color(255, 255, 255));
        pnFondoCabecera.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtBuscar.setForeground(new java.awt.Color(0, 0, 0));
        txtBuscar.setColorMaterial(new java.awt.Color(255, 102, 0));
        txtBuscar.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        txtBuscar.setPlaceholder("Barra de busqueda");
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
        pnFondoCabecera.add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 10, 680, 23));

        pnFondoBlanco.add(pnFondoCabecera, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 1, 948, 35));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        tbDetalle.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        tbDetalle.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
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
        tbDetalle.setGridColor(new java.awt.Color(204, 204, 204));
        tbDetalle.setRowHeight(20);
        tbDetalle.setShowGrid(true);
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

        pnFondoBlanco.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 37, 948, 379));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnFondoBlanco, javax.swing.GroupLayout.PREFERRED_SIZE, 950, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnFondoBlanco, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void txtBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if(tbDetalle.getRowCount()==0){
                txtBuscar.requestFocus();
                txtBuscar.selectAll();
            }else{
                tbDetalle.requestFocus();
                tbDetalle.getSelectionModel().setSelectionInterval(0, 0);
            }                
        }else if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
                this.dispose();
        }
    }//GEN-LAST:event_txtBuscarKeyPressed

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        // TODO add your handling code here:
        try {
            String cod = txtBuscar.getText();
            txtBuscar.requestFocus();
            CabecerasTablas.limpiarTablaTablaArticuloAuxiliar(tbDetalle);
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
            java.util.logging.Logger.getLogger(dlgBuscadorArticuloVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dlgBuscadorArticuloVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dlgBuscadorArticuloVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dlgBuscadorArticuloVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                dlgBuscadorArticuloVenta dialog = new dlgBuscadorArticuloVenta(new javax.swing.JFrame(), true);
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnFondoBlanco;
    private javax.swing.JPanel pnFondoCabecera;
    public static final javax.swing.JTable tbDetalle = new javax.swing.JTable();
    public static rojeru_san.rsfield.RSTextMaterial txtBuscar;
    // End of variables declaration//GEN-END:variables
}
