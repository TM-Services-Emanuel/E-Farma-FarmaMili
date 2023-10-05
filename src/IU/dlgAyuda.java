package IU;

import Componentes.Fecha;
import Componentes.Mensajes;
import Componentes.Software;
import java.awt.Toolkit;

public final class dlgAyuda extends javax.swing.JDialog {

    public dlgAyuda(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        informacion();
        cargarIcono();
        jLabel13.setText(System.getenv("COMPUTERNAME"));
        jLabel14.setText(System.getProperty("user.name"));
        jLabel15.setText(System.getenv("PROCESSOR_IDENTIFIER"));
        jLabel16.setText(System.getProperty("os.name"));
        jLabel17.setText(System.getProperty("java.version"));
    }
    
    final void informacion(){
        if(Software.getVersion().equals("null")){
            lbVersion.setText("0");
        }else{
            lbVersion.setText(Software.getVersion()+Fecha.soloAnho()+" - TM•SERVICES, Todos los derechos reservados.");
        }
        if(Software.getDesarrollador().equals("null")){
            lbDesarrollador.setText("Desarrollador: No especificado");
        }else{
            lbDesarrollador.setText(Software.getDesarrollador());
        }
        if(Software.getProfesion().equals("null")){
            lbProfesion.setText("Profesión: No especificado");
        }else{
            lbProfesion.setText(Software.getProfesion());
        }
        if(Software.getCorreo().equals("null")){
            lbcorreo.setText("Dirección de correo electrónico: No especificado");
        }else{
            lbcorreo.setText("Dirección de correo electrónico: "+Software.getCorreo());
        }
        if(Software.getTelefono().equals("null")){
            lbCelular.setText("Celular: No especificado");
        }else{
            lbCelular.setText("Telefono Celular "+Software.getTelefono());
        }
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        btnSalir = new RSMaterialComponent.RSButtonIconUno();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lbDesarrollador = new javax.swing.JLabel();
        lbProfesion = new javax.swing.JLabel();
        lbcorreo = new javax.swing.JLabel();
        lbCelular = new javax.swing.JLabel();
        lbCelular1 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lbVersion = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lbCompu = new javax.swing.JLabel();
        lbUsuario = new javax.swing.JLabel();
        lbProcesador = new javax.swing.JLabel();
        lbSO = new javax.swing.JLabel();
        lbJava = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Información del Sistema");
        setUndecorated(true);
        setResizable(false);

        jPanel4.setBackground(new java.awt.Color(17, 35, 46));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnSalir.setBackground(new java.awt.Color(255, 255, 255));
        btnSalir.setBackgroundHover(new java.awt.Color(205, 0, 0));
        btnSalir.setForegroundText(new java.awt.Color(17, 35, 46));
        btnSalir.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.CLOSE);
        btnSalir.setRippleColor(java.awt.Color.white);
        btnSalir.setTypeBorder(RSMaterialComponent.RSButtonIconUno.TYPEBORDER.CIRCLE);
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jPanel4.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(423, 6, 20, 20));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
        });
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)), "Datos del Desarrollador", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Roboto", 1, 10), new java.awt.Color(0, 153, 204))); // NOI18N
        jPanel2.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbDesarrollador.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        lbDesarrollador.setText("Ing. Emanuel M. Sosa Vera");
        jPanel2.add(lbDesarrollador, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 18, 390, -1));

        lbProfesion.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        lbProfesion.setText("Analista de Sistemas Informaticos");
        jPanel2.add(lbProfesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 35, 390, -1));

        lbcorreo.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        lbcorreo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbcorreo.setText("Direccion de Correo:");
        jPanel2.add(lbcorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 66, 390, -1));

        lbCelular.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        lbCelular.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCelular.setText("Celular:");
        jPanel2.add(lbCelular, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 108, 390, -1));

        lbCelular1.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        lbCelular1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCelular1.setText("Linkedin.com/in/emanuelmiguelsosavera ");
        jPanel2.add(lbCelular1, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 87, 390, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 146, 424, 130));

        jLabel11.setFont(new java.awt.Font("SansSerif", 1, 34)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/fast-farma.png"))); // NOI18N
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 14, 400, 93));

        lbVersion.setFont(new java.awt.Font("Roboto", 1, 10)); // NOI18N
        lbVersion.setForeground(new java.awt.Color(0, 153, 204));
        lbVersion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbVersion.setText("2021 - V1.5.0");
        jPanel1.add(lbVersion, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 114, 420, -1));

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        lbCompu.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        lbCompu.setText("Computadora :");

        lbUsuario.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        lbUsuario.setText("Usuario :");

        lbProcesador.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        lbProcesador.setText("Procesador :");

        lbSO.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        lbSO.setText("S.O. :");

        lbJava.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        lbJava.setText("Version de Java :");

        jLabel13.setFont(new java.awt.Font("Roboto", 0, 10)); // NOI18N
        jLabel13.setText("jLabel6");

        jLabel14.setFont(new java.awt.Font("Roboto", 0, 10)); // NOI18N
        jLabel14.setText("jLabel7");

        jLabel15.setFont(new java.awt.Font("Roboto", 0, 10)); // NOI18N
        jLabel15.setText("jLabel8");

        jLabel16.setFont(new java.awt.Font("Roboto", 0, 10)); // NOI18N
        jLabel16.setText("jLabel9");

        jLabel17.setFont(new java.awt.Font("Roboto", 0, 10)); // NOI18N
        jLabel17.setText("jLabel10");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbCompu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbProcesador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbSO, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbJava, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbCompu)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbUsuario)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbProcesador)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbSO)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbJava)
                    .addComponent(jLabel17))
                .addGap(10, 10, 10))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 281, 420, -1));

        jSeparator1.setForeground(new java.awt.Color(204, 204, 204));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 140, 434, -1));

        jPanel4.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 440, 410));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jPanel1MouseClicked

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
            this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    void cargarIcono() {
        try {
            java.awt.Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Iconos/logo1.png"));
            setIconImage(icon);
        } catch (Exception e) {
            Mensajes.error("No se pudo cargo icono");
        }
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
            java.util.logging.Logger.getLogger(dlgAyuda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dlgAyuda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dlgAyuda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dlgAyuda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(() -> {
            dlgAyuda dialog = new dlgAyuda(new javax.swing.JFrame(), true);
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
    private RSMaterialComponent.RSButtonIconUno btnSalir;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbCelular;
    private javax.swing.JLabel lbCelular1;
    private javax.swing.JLabel lbCompu;
    private javax.swing.JLabel lbDesarrollador;
    private javax.swing.JLabel lbJava;
    private javax.swing.JLabel lbProcesador;
    private javax.swing.JLabel lbProfesion;
    private javax.swing.JLabel lbSO;
    private javax.swing.JLabel lbUsuario;
    private javax.swing.JLabel lbVersion;
    private javax.swing.JLabel lbcorreo;
    // End of variables declaration//GEN-END:variables
}
