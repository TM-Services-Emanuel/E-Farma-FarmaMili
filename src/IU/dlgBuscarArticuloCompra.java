package IU;

import Componentes.RenderDecimal;
import Componentes.RenderDecimal1;
import Componentes.RenderDecimalCosto;
import Componentes.RenderDecimalPublico;
import Componentes.Software;
import Controladores.CabecerasTablas;
import Controladores.controlArticulo;
import Controladores.controlCompra;
import Modelo.Articulo;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;

public class dlgBuscarArticuloCompra extends javax.swing.JDialog {

    CabecerasTablas cabe = new CabecerasTablas();
    Articulo art;

    public dlgBuscarArticuloCompra(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        titulo();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Iconos/logo1.png")));
        cabe.tablaArticuloAuxiliarCompra(tbDetalle);
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
        dlgBuscarArticuloCompra.tbDetalle.getColumnModel().getColumn(10).setCellRenderer(new RenderDecimalCosto());
        dlgBuscarArticuloCompra.tbDetalle.getColumnModel().getColumn(13).setCellRenderer(new RenderDecimalPublico());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoBotones = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        txtBuscar = new rojeru_san.rsfield.RSTextMaterial();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbDetalle = new javax.swing.JTable()
        {
            public boolean isCellEditable(int rowInddex, int celIndex)
            {
                return false;
            }
        };

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(17, 35, 46)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        jPanel2.add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 10, 680, 23));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 1, 948, 35));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

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
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tbDetalleKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tbDetalle);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 37, 948, 379));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 950, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
                .addGap(0, 0, Short.MAX_VALUE))
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
        if (evt.getClickCount() == 2) {
            controlCompra.selectArticulo();
            dlgCompras.habilitarCANTCOSTO();
            dlgCompras.txtCant.requestFocus();
            dlgCompras.txtCant.selectAll();
            this.dispose();
        }
    }//GEN-LAST:event_tbDetalleMouseClicked

    private void tbDetalleKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbDetalleKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            controlCompra.selectArticulo();
            dlgCompras.habilitarCANTCOSTO();
            dlgCompras.txtCant.requestFocus();
            //dlgCompras.txtCant.selectAll();
            this.dispose();
        }else if(evt.getKeyCode() == KeyEvent.VK_ESCAPE){
            txtBuscar.requestFocus();
            txtBuscar.selectAll();
        }
    }//GEN-LAST:event_tbDetalleKeyPressed

    private void tbDetalleKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbDetalleKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tbDetalleKeyReleased

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

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        // TODO add your handling code here:
        try {
            String cod = txtBuscar.getText();
            txtBuscar.requestFocus();
            cabe.tablaArticuloAuxiliar(tbDetalle);
            CabecerasTablas.limpiarTablas(tbDetalle);
            controlArticulo.filtrarCodBarraActivo(tbDetalle, cod);

            /*cabe.tablaArticuloAuxiliar(tbDetalle);
            controlArticulo.listArticuloActivo(tbDetalle, "cod");
            CabecerasTablas.limpiarTablas(tbDetalle);
            controlArticulo.filtrarCodBarraActivo(tbDetalle, cod);*/
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
            java.util.logging.Logger.getLogger(dlgBuscarArticuloCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        java.awt.EventQueue.invokeLater(() -> {
            dlgBuscarArticuloCompra dialog = new dlgBuscarArticuloCompra(new javax.swing.JFrame(), true);
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable tbDetalle;
    private rojeru_san.rsfield.RSTextMaterial txtBuscar;
    // End of variables declaration//GEN-END:variables
}
