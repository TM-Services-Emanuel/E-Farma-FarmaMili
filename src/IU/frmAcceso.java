package IU;

import Componentes.Mensajes;
import Componentes.Software;
import Componentes.traerIP;
import Controladores.ControlLogeo;
import Controladores.controlPerfil;
//import de.javasoft.plaf.synthetica.SyntheticaBlackMoonLookAndFeel;
//import de.javasoft.plaf.synthetica.SyntheticaBlueIceLookAndFeel;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import javax.swing.UnsupportedLookAndFeelException;

public final class frmAcceso extends javax.swing.JFrame {
    public frmAcceso() {
        initComponents();
        titulo();
        cargarIcono();
        try { 
            lblIP.setText("HOST IP : "+traerIP.getIP());
            lblHost.setText("HOST: "+traerIP.getHostname());
        } catch (Exception e) {
        }
        txtUsuario.requestFocus();
        
    }
    
    void titulo(){
        if(Software.getSoftware().equals("null")){
            this.setTitle("Bienvenido");
        }else{
            this.setTitle("Bienvendo a "+Software.getSoftware());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblHost = new javax.swing.JLabel();
        contenedor = new javax.swing.JPanel();
        usuario = new javax.swing.JLabel();
        contraseña = new javax.swing.JLabel();
        lblMensaje = new javax.swing.JLabel();
        txtUsuario = new rojeru_san.rsfield.RSTextMaterial();
        psPasword = new rojeru_san.rsfield.RSPassMaterial();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator1 = new javax.swing.JSeparator();
        btnEntrar = new RSMaterialComponent.RSButtonIconUno();
        btnCerrar = new RSMaterialComponent.RSButtonIconUno();
        fast_farma = new javax.swing.JLabel();
        rSPanelGradiente2 = new rojeru_san.rspanel.RSPanelGradiente();
        lblIP = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblHost.setFont(new java.awt.Font("Roboto", 1, 20)); // NOI18N
        lblHost.setForeground(new java.awt.Color(0, 153, 204));
        lblHost.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHost.setText("NOMBRE HOST");
        lblHost.setVerifyInputWhenFocusTarget(false);
        getContentPane().add(lblHost, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 329, 40));

        contenedor.setOpaque(false);
        contenedor.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        usuario.setFont(new java.awt.Font("Roboto", 1, 15)); // NOI18N
        usuario.setForeground(new java.awt.Color(17, 35, 46));
        usuario.setText("USUARIO");
        usuario.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        contenedor.add(usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 114, 31));

        contraseña.setFont(new java.awt.Font("Roboto", 1, 15)); // NOI18N
        contraseña.setForeground(new java.awt.Color(17, 35, 46));
        contraseña.setText("CONTRASEÑA");
        contenedor.add(contraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 114, 30));

        lblMensaje.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        lblMensaje.setForeground(new java.awt.Color(0, 153, 204));
        lblMensaje.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        contenedor.add(lblMensaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 340, 12));

        txtUsuario.setForeground(new java.awt.Color(0, 0, 0));
        txtUsuario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtUsuario.setColorMaterial(new java.awt.Color(17, 35, 46));
        txtUsuario.setDisabledTextColor(new java.awt.Color(86, 86, 86));
        txtUsuario.setFont(new java.awt.Font("Roboto", 1, 15)); // NOI18N
        txtUsuario.setPlaceholder("ESCRIBA AQUI");
        txtUsuario.setSelectionColor(new java.awt.Color(86, 86, 86));
        txtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioActionPerformed(evt);
            }
        });
        txtUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtUsuarioKeyTyped(evt);
            }
        });
        contenedor.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, 220, 31));

        psPasword.setForeground(new java.awt.Color(0, 0, 0));
        psPasword.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        psPasword.setColorMaterial(new java.awt.Color(17, 35, 46));
        psPasword.setDisabledTextColor(new java.awt.Color(86, 86, 86));
        psPasword.setEchoChar('*');
        psPasword.setFont(new java.awt.Font("Roboto", 1, 15)); // NOI18N
        psPasword.setPlaceholder("ESCRIBA AQUI");
        psPasword.setSelectionColor(new java.awt.Color(86, 86, 86));
        psPasword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                psPaswordActionPerformed(evt);
            }
        });
        psPasword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                psPaswordKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                psPaswordKeyTyped(evt);
            }
        });
        contenedor.add(psPasword, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 220, 30));

        jSeparator2.setForeground(new java.awt.Color(204, 204, 204));
        contenedor.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 335, -1));

        jSeparator1.setForeground(new java.awt.Color(204, 204, 204));
        contenedor.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 335, -1));

        btnEntrar.setBackground(new java.awt.Color(255, 255, 255));
        btnEntrar.setBackgroundHover(new java.awt.Color(17, 35, 46));
        btnEntrar.setForegroundText(new java.awt.Color(17, 35, 46));
        btnEntrar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.CHECK);
        btnEntrar.setTypeBorder(RSMaterialComponent.RSButtonIconUno.TYPEBORDER.CIRCLE);
        btnEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntrarActionPerformed(evt);
            }
        });
        contenedor.add(btnEntrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 120, -1, -1));

        getContentPane().add(contenedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 360, 200));

        btnCerrar.setBackground(new java.awt.Color(17, 35, 46));
        btnCerrar.setBackgroundHover(new java.awt.Color(255, 0, 0));
        btnCerrar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.CLOSE);
        btnCerrar.setTypeBorder(RSMaterialComponent.RSButtonIconUno.TYPEBORDER.CIRCLE);
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(375, 0, 25, 25));

        fast_farma.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fast_farma.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/fast-farma_1.png"))); // NOI18N
        getContentPane().add(fast_farma, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 260, -1));

        rSPanelGradiente2.setColorPrimario(new java.awt.Color(17, 35, 46));
        rSPanelGradiente2.setColorSecundario(new java.awt.Color(17, 35, 46));
        rSPanelGradiente2.setGradiente(rojeru_san.rspanel.RSPanelGradiente.Gradiente.VERTICAL);

        lblIP.setBackground(new java.awt.Color(255, 255, 255));
        lblIP.setFont(new java.awt.Font("Roboto", 0, 10)); // NOI18N
        lblIP.setForeground(new java.awt.Color(255, 255, 255));
        lblIP.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblIP.setText("IP : ");

        javax.swing.GroupLayout rSPanelGradiente2Layout = new javax.swing.GroupLayout(rSPanelGradiente2);
        rSPanelGradiente2.setLayout(rSPanelGradiente2Layout);
        rSPanelGradiente2Layout.setHorizontalGroup(
            rSPanelGradiente2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rSPanelGradiente2Layout.createSequentialGroup()
                .addContainerGap(223, Short.MAX_VALUE)
                .addComponent(lblIP, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        rSPanelGradiente2Layout.setVerticalGroup(
            rSPanelGradiente2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rSPanelGradiente2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblIP, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(rSPanelGradiente2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 492, 400, -1));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/ACCESO_1.png"))); // NOI18N
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 510));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtUsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsuarioKeyTyped
        // TODO add your handling code here:
        char c=evt.getKeyChar();
        if(Character.isLowerCase(c)){
            String cad=(""+c).toUpperCase();
            c=cad.charAt(0);
            evt.setKeyChar(c);
        }
        int limite=10;
        if (txtUsuario.getText().length()== limite)
        {
            evt.consume();
        }
    }//GEN-LAST:event_txtUsuarioKeyTyped

    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed
        // TODO add your handling code here:
        psPasword.requestFocus();
        psPasword.selectAll();
    }//GEN-LAST:event_txtUsuarioActionPerformed

    private void psPaswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_psPaswordKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnEntrar.requestFocus();
            btnEntrar.doClick();
        }
    }//GEN-LAST:event_psPaswordKeyPressed

    private void psPaswordKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_psPaswordKeyTyped
        // TODO add your handling code here:
        char c=evt.getKeyChar();
        if(Character.isLowerCase(c)){
            String cad=(""+c).toUpperCase();
            c=cad.charAt(0);
            evt.setKeyChar(c);
        }
        int limite=15;
        if (psPasword.getText().length()== limite)
        {
            evt.consume();
        }
    }//GEN-LAST:event_psPaswordKeyTyped

    private void psPaswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_psPaswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_psPaswordActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void btnEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntrarActionPerformed
        // TODO add your handling code here:
        try {
            ControlLogeo.logear();
            controlPerfil.perfil();
            this.dispose();
        } catch (Exception e) {
            txtUsuario.requestFocus();
            txtUsuario.selectAll();
            System.out.println("Error al cargar Principal: "+e.toString());
        }
    }//GEN-LAST:event_btnEntrarActionPerformed

    void cargarIcono() {
        try {
            java.awt.Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Iconos/logo1.png"));
            setIconImage(icon);
            setVisible(true);
            this.setLocationRelativeTo(null);
        } catch (Exception e) {
            Mensajes.error("No se pudo cargo icono");
        }
    }
    /*void LookAndFeel() {
        //Look And Feel
        System.setProperty(
                "Quaqua.tabLayoutPolicy", "wrap"
        );
        try {
            //UIManager.setLookAndFeel(tema);
            UIManager.setLookAndFeel(new SyntheticaBlackEyeLookAndFeel());
            //UIManager.setLookAndFeel(new SyntheticaBlackMoonLookAndFeel());
            //UIManager.setLookAndFeel(new SyntheticaBlueIceLookAndFeel());
            SwingUtilities.updateComponentTreeUI(this);
        } catch (ParseException | UnsupportedLookAndFeelException erro) {
            //Mensajes.informacion("Error al cargar el tema");
            System.out.println("Error al cargar el tema");
        }
    }*/
    /*public void LookAndFeel2() {
        //Look And Feel
        System.setProperty(
                "Quaqua.tabLayoutPolicy", "wrap"
        );
        try {
            SubstanceLookAndFeel.setSkin(tema);
            SwingUtilities.updateComponentTreeUI(this);
        } catch (Exception erro) {
            Mensajes.informacion("Error al cargar el tema");
        }
    }*/
    
    /**
     * @param args the command line arguments
     * @throws javax.swing.UnsupportedLookAndFeelException
     */
    public static void main(String args[])throws UnsupportedLookAndFeelException {
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
       java.util.logging.Logger.getLogger(frmAcceso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
       }
        //</editor-fold>
        
       //</editor-fold>
           

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new frmAcceso().setVisible(true);
       });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private RSMaterialComponent.RSButtonIconUno btnCerrar;
    public static RSMaterialComponent.RSButtonIconUno btnEntrar;
    private javax.swing.JPanel contenedor;
    private javax.swing.JLabel contraseña;
    private javax.swing.JLabel fast_farma;
    private javax.swing.JLabel fondo;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    public static javax.swing.JLabel lblHost;
    public static javax.swing.JLabel lblIP;
    public static javax.swing.JLabel lblMensaje;
    public static rojeru_san.rsfield.RSPassMaterial psPasword;
    private rojeru_san.rspanel.RSPanelGradiente rSPanelGradiente2;
    public static rojeru_san.rsfield.RSTextMaterial txtUsuario;
    private javax.swing.JLabel usuario;
    // End of variables declaration//GEN-END:variables

}
