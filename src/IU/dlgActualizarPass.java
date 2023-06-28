
package IU;


import Componentes.ConexionBD;
import Componentes.Login;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import org.mariadb.jdbc.MariaDbConnection;
import org.mariadb.jdbc.MariaDbStatement;

/**
 *
 * @author ADMIN
 */
public class dlgActualizarPass extends javax.swing.JDialog { 

    String UsuarioL = "";
    String PasswordU = "";
    String idUsuarioL = "";

    /**
     *
     */
    public MariaDbStatement sentencia;

    /**
     *
     */
    public MariaDbConnection con;
    private String passfinal;

    /**
     *
     * @param parent
     * @param modal
     */
    public dlgActualizarPass(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setTitle("Cambiar contraseña");
        prepararBD();
        UsuarioL = Login.getUsuarioLogueado();
        PasswordU = Login.getPasswordLogeado();
        idUsuarioL = Login.getIdLogueado();
        btnCancelarActionPerformed(null);
        System.out.println("User: " + UsuarioL);
        System.out.println("Pass: " + PasswordU);
        System.out.println("ID: " + idUsuarioL);
    }

    /**
     *
     */
    private void salir() {
        int resp = JOptionPane.showConfirmDialog(null, "Esta seguro que desea Cerrar el formulario?", "Salir", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (resp == JOptionPane.YES_OPTION) {
            this.dispose();
        }
    }

    private void prepararBD() {
        try {
            con = (MariaDbConnection) new ConexionBD().getConexion();
            if (con == null) {
                System.out.println("No hay Conexion con la Base de Datos");
            } else {
                sentencia = (MariaDbStatement) con.createStatement();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private void limpiarCampos() {
        //txtCod.setText("");
        txtPassActual.setText("");
        txtPassNuevo.setText("");
        txtPassConfirmar.setText("");
    }

    private void habilitarCampos(boolean b) {
        txtPassNuevo.setEnabled(b);
        txtPassConfirmar.setEnabled(b);
        //btnGuardar.setEnabled(b);
        //menuitemGuardar.setEnabled(b);
        btnCancelar.setEnabled(b);
        menuitemCancelar.setEnabled(b);
        btnSalir.setEnabled(!b);
        menuitemSalir.setEnabled(!b);
    }

    private void validarPass() {
        if (txtPassActual.getText().equals(PasswordU)) {
            habilitarCampos(true);
            txtPassNuevo.requestFocus();
        } else {
            JOptionPane.showMessageDialog(null, "Contraseña actual incorrecta, por favor vuelva a intentarlo", "Mensaje", 0);
            habilitarCampos(false);
            txtPassActual.requestFocus();
            txtPassNuevo.setText("");
            txtPassConfirmar.setText("");
            btnGuardar.setEnabled(false);
            menuitemGuardar.setEnabled(false);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        txtPassConfirmar = new javax.swing.JPasswordField();
        txtPassActual = new javax.swing.JPasswordField();
        txtPassNuevo = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuOpcion = new javax.swing.JMenu();
        menuitemGuardar = new javax.swing.JMenuItem();
        menuitemCancelar = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        menuitemSalir = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(new java.awt.GridLayout());

        btnGuardar.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 9)); // NOI18N
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/save30.png"))); // NOI18N
        btnGuardar.setText("Guardar cambio - F6");
        btnGuardar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnGuardar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel2.add(btnGuardar);

        btnCancelar.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 9)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/cancel30.png"))); // NOI18N
        btnCancelar.setText("Cancelar - Esc");
        btnCancelar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCancelar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel2.add(btnCancelar);

        btnSalir.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 9)); // NOI18N
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/back30.png"))); // NOI18N
        btnSalir.setText("Salir - Alt+F4");
        btnSalir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSalir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jPanel2.add(btnSalir);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel1.setText("Contraseña actual");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, 20));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel2.setText("Confirmar contraseña");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, 20));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel3.setText("Nueva contraseña");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, 20));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 310, 10));

        txtPassConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPassConfirmarActionPerformed(evt);
            }
        });
        txtPassConfirmar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPassConfirmarKeyTyped(evt);
            }
        });
        jPanel1.add(txtPassConfirmar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 90, 180, 20));

        txtPassActual.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPassActualFocusLost(evt);
            }
        });
        txtPassActual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPassActualActionPerformed(evt);
            }
        });
        txtPassActual.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPassActualKeyTyped(evt);
            }
        });
        jPanel1.add(txtPassActual, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 180, 20));

        txtPassNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPassNuevoActionPerformed(evt);
            }
        });
        txtPassNuevo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPassNuevoKeyTyped(evt);
            }
        });
        jPanel1.add(txtPassNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, 180, 20));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/llaveInicio4 - copia.png"))); // NOI18N

        menuOpcion.setText("Opciones");
        menuOpcion.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        menuOpcion.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        menuitemGuardar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F6, 0));
        menuitemGuardar.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        menuitemGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/save15.png"))); // NOI18N
        menuitemGuardar.setText("Guardar cambio                          ");
        menuitemGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuitemGuardarActionPerformed(evt);
            }
        });
        menuOpcion.add(menuitemGuardar);

        menuitemCancelar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        menuitemCancelar.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        menuitemCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/cancel15.png"))); // NOI18N
        menuitemCancelar.setText("Cancelar");
        menuitemCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuitemCancelarActionPerformed(evt);
            }
        });
        menuOpcion.add(menuitemCancelar);
        menuOpcion.add(jSeparator3);

        menuitemSalir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_DOWN_MASK));
        menuitemSalir.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        menuitemSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/back15.png"))); // NOI18N
        menuitemSalir.setText("Salir");
        menuitemSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuitemSalirActionPerformed(evt);
            }
        });
        menuOpcion.add(menuitemSalir);

        jMenuBar1.add(menuOpcion);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        txtPassActual.setText("");
        salir();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
    /*    System.out.println(txtPassNuevo.getText());
        int resp = JOptionPane.showConfirmDialog(this, "¿Desea modificar su contraseña de acceso al sistema?",
                "Aviso", JOptionPane.YES_NO_OPTION);
        if (resp == JOptionPane.YES_OPTION) {
            try {
                abm.modificar("empleado", "pass='" + passfinal + "', usuario='" + UsuarioL + "'",
                        "ci ='" + idUsuarioL + "'");
                JOptionPane.showMessageDialog(this, "Contraseña modificada exitosamente" + "\n" + "Cierre Sesion para actualizar los datos de ingreso al sistema.");
                this.dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error al cambiar contraseña", "Mensaje", 0);
            }
            btnCancelarActionPerformed(null);
        }*/
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        habilitarCampos(false);
        btnGuardar.setEnabled(false);
        menuitemGuardar.setEnabled(false);
        limpiarCampos();
        txtPassActual.setText("");
        txtPassActual.requestFocus();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtPassActualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPassActualActionPerformed
        // TODO add your handling code here:
        if (!txtPassActual.getText().isEmpty()) {
            validarPass();
        }
    }//GEN-LAST:event_txtPassActualActionPerformed

    private void txtPassActualKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPassActualKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isLowerCase(c)) {
            String cad = ("" + c).toUpperCase();
            c = cad.charAt(0);
            evt.setKeyChar(c);
        }
    }//GEN-LAST:event_txtPassActualKeyTyped

    private void txtPassNuevoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPassNuevoKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isLowerCase(c)) {
            String cad = ("" + c).toUpperCase();
            c = cad.charAt(0);
            evt.setKeyChar(c);
        }
    }//GEN-LAST:event_txtPassNuevoKeyTyped

    private void txtPassConfirmarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPassConfirmarKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isLowerCase(c)) {
            String cad = ("" + c).toUpperCase();
            c = cad.charAt(0);
            evt.setKeyChar(c);
        }
    }//GEN-LAST:event_txtPassConfirmarKeyTyped

    private void menuitemSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuitemSalirActionPerformed
        // TODO add your handling code here:
        salir();
    }//GEN-LAST:event_menuitemSalirActionPerformed

    private void menuitemCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuitemCancelarActionPerformed
        // TODO add your handling code here:
        btnCancelarActionPerformed(null);
    }//GEN-LAST:event_menuitemCancelarActionPerformed

    private void menuitemGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuitemGuardarActionPerformed
        // TODO add your handling code here:
        btnGuardarActionPerformed(null);
    }//GEN-LAST:event_menuitemGuardarActionPerformed

    private void txtPassActualFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPassActualFocusLost
        // TODO add your handling code here:
        /* if (!txtPassActual.getText().isEmpty()) {
            validarPass();
        }
         */
    }//GEN-LAST:event_txtPassActualFocusLost

    private void txtPassNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPassNuevoActionPerformed
        // TODO add your handling code here:
        if (txtPassNuevo.getText().equals("")) {
            txtPassNuevo.requestFocus();
        } else {
            txtPassConfirmar.requestFocus();
        }

    }//GEN-LAST:event_txtPassNuevoActionPerformed

    private void txtPassConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPassConfirmarActionPerformed
        // TODO add your handling code here:
        if (txtPassConfirmar.getText().equals("")) {
            txtPassConfirmar.requestFocus();
        } else {
            if (txtPassNuevo.getText().equals(txtPassConfirmar.getText())) {
                passfinal = txtPassConfirmar.getText();
                btnGuardar.setEnabled(true);
                menuitemGuardar.setEnabled(true);
                btnGuardar.requestFocus();
            } else {
                btnGuardar.setEnabled(false);
                menuitemGuardar.setEnabled(false);
                JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden, vuelva a interntarlo", "Mensaje", 2);
            }
        }

    }//GEN-LAST:event_txtPassConfirmarActionPerformed

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
            java.util.logging.Logger.getLogger(dlgActualizarPass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dlgActualizarPass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dlgActualizarPass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dlgActualizarPass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(() -> {
            dlgActualizarPass dialog = new dlgActualizarPass(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnCancelar;
    public javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JMenu menuOpcion;
    private javax.swing.JMenuItem menuitemCancelar;
    private javax.swing.JMenuItem menuitemGuardar;
    private javax.swing.JMenuItem menuitemSalir;
    private javax.swing.JPasswordField txtPassActual;
    private javax.swing.JPasswordField txtPassConfirmar;
    private javax.swing.JPasswordField txtPassNuevo;
    // End of variables declaration//GEN-END:variables
}
