package IU;

import Componentes.Fecha;
import Componentes.Login;
import Componentes.Software;
import Componentes.validarCampos;
import Controladores.ControlCaja;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;

public class dlgCaja extends javax.swing.JDialog {

    public dlgCaja(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        titulo();
        lbUsuario.setText(Login.getUsuarioLogueado());
        lbFecha.setText(Fecha.fechaCorrecta());
        lbHora.setText(Fecha.darHoraSinSS());
    }

    private void AccesoRapido(int n) {
        switch (n) {

            case KeyEvent.VK_ESCAPE -> {
                int resp = JOptionPane.showConfirmDialog(this, "¿Seguro que desea salir de este formulario?", "Iniciar Caja", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (resp == JOptionPane.YES_OPTION) {
                    this.dispose();
                }
            }
            default -> {
            }
        }
        System.out.println(n);
    }

    final void titulo() {
        if (Software.getSoftware().equals("null")) {
            this.setTitle("Cargar valor inicial de la caja");
        } else {
            this.setTitle(Software.getSoftware() + " - Cargar valor inicial de la caja");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Blanco = new org.edisoncor.gui.panel.PanelImage();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lbFecha = new javax.swing.JLabel();
        lbHora = new javax.swing.JLabel();
        lbUsuario = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtCaInicial = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        Blanco.setBackground(new java.awt.Color(255, 255, 255));
        Blanco.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Blanco.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/fondoBlanco.jpg"))); // NOI18N
        Blanco.setPreferredSize(new java.awt.Dimension(690, 418));

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel2.setOpaque(false);
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        jLabel2.setText("Fecha");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 14, 62, -1));

        jLabel4.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        jLabel4.setText("Hora");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 36, 62, -1));

        jLabel6.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        jLabel6.setText("Usuario");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 58, 62, -1));

        lbFecha.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        lbFecha.setText("jLabel3");
        jPanel2.add(lbFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(82, 14, 274, -1));

        lbHora.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        lbHora.setText("jLabel5");
        jPanel2.add(lbHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(82, 36, 274, -1));

        lbUsuario.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        lbUsuario.setText("jLabel7");
        jPanel2.add(lbUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(82, 58, 274, -1));

        jLabel3.setBackground(new java.awt.Color(17, 35, 46));
        jLabel3.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("DATOS DE LA INICIALIZACIÓN");
        jLabel3.setOpaque(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 204));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("VALOR INICIAL");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 14, -1, 40));

        txtCaInicial.setFont(new java.awt.Font("Roboto", 1, 28)); // NOI18N
        txtCaInicial.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCaInicial.setText("0");
        txtCaInicial.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtCaInicial.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txtCaInicial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCaInicialActionPerformed(evt);
            }
        });
        txtCaInicial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCaInicialKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCaInicialKeyReleased(evt);
            }
        });
        jPanel1.add(txtCaInicial, new org.netbeans.lib.awtextra.AbsoluteConstraints(141, 14, 203, 40));

        javax.swing.GroupLayout BlancoLayout = new javax.swing.GroupLayout(Blanco);
        Blanco.setLayout(BlancoLayout);
        BlancoLayout.setHorizontalGroup(
            BlancoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(BlancoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(BlancoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 369, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        BlancoLayout.setVerticalGroup(
            BlancoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BlancoLayout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Blanco, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Blanco, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCaInicialKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCaInicialKeyReleased
        // TODO add your handling code here:
        try {
            if (txtCaInicial.getText().trim().length() >= 1) {
                DecimalFormat df = new DecimalFormat("#,###");
                txtCaInicial.setText(df.format(Integer.valueOf(txtCaInicial.getText().trim().replace(".", "").replace(",", ""))));

            }
        } catch (NumberFormatException e) {
            System.out.println("c: " + e.getMessage());
        }
    }//GEN-LAST:event_txtCaInicialKeyReleased

    private void txtCaInicialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCaInicialActionPerformed
        // TODO add your handling code here:
        try {
            if (txtCaInicial.getText().isEmpty()) {
                txtCaInicial.setText("0");
                txtCaInicial.selectAll();
            } else if (Integer.parseInt(txtCaInicial.getText().replace(".", "").replace(",", "")) <= 0) {
                txtCaInicial.setText("0");
                txtCaInicial.selectAll();
            } else {
                int resp = JOptionPane.showConfirmDialog(this, "¿El monto con que se iniciara es el correcto?", "Iniciar Caja", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (resp == JOptionPane.YES_OPTION) {
                    ControlCaja.addCaja();
                    this.dispose();
                }
            }
        } catch (NumberFormatException e) {
            txtCaInicial.setText("0");
            txtCaInicial.selectAll();
        }

    }//GEN-LAST:event_txtCaInicialActionPerformed

    private void txtCaInicialKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCaInicialKeyPressed
        // TODO add your handling code here:
        validarCampos.soloNumeros(txtCaInicial);
        AccesoRapido(evt.getKeyCode());
    }//GEN-LAST:event_txtCaInicialKeyPressed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dlgCaja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(() -> {
            dlgCaja dialog = new dlgCaja(new javax.swing.JFrame(), true);
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
    private org.edisoncor.gui.panel.PanelImage Blanco;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public static javax.swing.JLabel lbFecha;
    public static javax.swing.JLabel lbHora;
    public static javax.swing.JLabel lbUsuario;
    public static javax.swing.JTextField txtCaInicial;
    // End of variables declaration//GEN-END:variables
}
