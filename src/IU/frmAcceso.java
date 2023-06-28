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

        rSPanelGradiente1 = new rojeru_san.rspanel.RSPanelGradiente();
        jLabel1 = new javax.swing.JLabel();
        lblHost = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblMensaje = new javax.swing.JLabel();
        txtUsuario = new rojeru_san.rsfield.RSTextMaterial();
        psPasword = new rojeru_san.rsfield.RSPassMaterial();
        btnEntrar = new newscomponents.RSButtonGradientIcon_new();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator1 = new javax.swing.JSeparator();
        rSPanelGradiente2 = new rojeru_san.rspanel.RSPanelGradiente();
        lblIP = new javax.swing.JLabel();
        menu = new rojeru_san.rspanel.RSPanelOpacity();
        btnCerrar = new RSMaterialComponent.RSButtonIconDos();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        rSPanelGradiente1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        rSPanelGradiente1.setColorPrimario(new java.awt.Color(255, 255, 255));
        rSPanelGradiente1.setColorSecundario(new java.awt.Color(255, 255, 255));
        rSPanelGradiente1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/fast-farma.png"))); // NOI18N
        rSPanelGradiente1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 36, 319, -1));

        lblHost.setFont(new java.awt.Font("Roboto", 1, 20)); // NOI18N
        lblHost.setForeground(new java.awt.Color(254, 50, 0));
        lblHost.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHost.setText("NOMBRE HOST");
        lblHost.setVerifyInputWhenFocusTarget(false);
        rSPanelGradiente1.add(lblHost, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 201, 329, 40));

        jPanel1.setOpaque(false);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Roboto", 1, 15)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(86, 86, 86));
        jLabel4.setText("USUARIO");
        jLabel4.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 114, 20));

        jLabel5.setFont(new java.awt.Font("Roboto", 1, 15)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(86, 86, 86));
        jLabel5.setText("CONTRASEÑA");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 57, 114, 20));

        lblMensaje.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        lblMensaje.setForeground(new java.awt.Color(17, 35, 46));
        jPanel1.add(lblMensaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 133, 309, 12));

        txtUsuario.setForeground(new java.awt.Color(0, 0, 0));
        txtUsuario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtUsuario.setColorMaterial(new java.awt.Color(102, 102, 102));
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
        jPanel1.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(134, 15, 185, 31));

        psPasword.setForeground(new java.awt.Color(0, 0, 0));
        psPasword.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        psPasword.setColorMaterial(new java.awt.Color(102, 102, 102));
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
        jPanel1.add(psPasword, new org.netbeans.lib.awtextra.AbsoluteConstraints(134, 52, 185, 30));

        btnEntrar.setBackground(new java.awt.Color(255, 255, 255));
        btnEntrar.setText("ACCEDER");
        btnEntrar.setColorPrimario(new java.awt.Color(17, 35, 46));
        btnEntrar.setColorPrimarioHover(new java.awt.Color(63, 74, 80));
        btnEntrar.setColorSecundario(new java.awt.Color(63, 74, 80));
        btnEntrar.setColorSecundarioHover(new java.awt.Color(17, 35, 46));
        btnEntrar.setFocusPainted(false);
        btnEntrar.setFont(new java.awt.Font("Roboto Bold", 1, 15)); // NOI18N
        btnEntrar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.PERSON_PIN);
        btnEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntrarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEntrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(134, 87, 185, -1));

        jSeparator2.setForeground(new java.awt.Color(204, 204, 204));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 151, 309, -1));

        jSeparator1.setForeground(new java.awt.Color(204, 204, 204));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 309, -1));

        rSPanelGradiente1.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 247, 329, -1));

        rSPanelGradiente2.setColorPrimario(new java.awt.Color(17, 35, 46));
        rSPanelGradiente2.setColorSecundario(new java.awt.Color(63, 74, 80));
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblIP, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        rSPanelGradiente2Layout.setVerticalGroup(
            rSPanelGradiente2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rSPanelGradiente2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblIP, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        rSPanelGradiente1.add(rSPanelGradiente2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 403, 330, -1));

        menu.setBackground(new java.awt.Color(255, 255, 255));

        btnCerrar.setBackground(new java.awt.Color(254, 50, 0));
        btnCerrar.setBackgroundHover(new java.awt.Color(204, 0, 0));
        btnCerrar.setFontSize(30.0F);
        btnCerrar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.CLOSE);
        btnCerrar.setInheritsPopupMenu(true);
        btnCerrar.setPreferredSize(new java.awt.Dimension(30, 30));
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout menuLayout = new javax.swing.GroupLayout(menu);
        menu.setLayout(menuLayout);
        menuLayout.setHorizontalGroup(
            menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        menuLayout.setVerticalGroup(
            menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        rSPanelGradiente1.add(menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 1, 328, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rSPanelGradiente1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rSPanelGradiente1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

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

    private void psPaswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_psPaswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_psPaswordActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btnCerrarActionPerformed

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
    private RSMaterialComponent.RSButtonIconDos btnCerrar;
    public static newscomponents.RSButtonGradientIcon_new btnEntrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    public static javax.swing.JLabel lblHost;
    public static javax.swing.JLabel lblIP;
    public static javax.swing.JLabel lblMensaje;
    private rojeru_san.rspanel.RSPanelOpacity menu;
    public static rojeru_san.rsfield.RSPassMaterial psPasword;
    private rojeru_san.rspanel.RSPanelGradiente rSPanelGradiente1;
    private rojeru_san.rspanel.RSPanelGradiente rSPanelGradiente2;
    public static rojeru_san.rsfield.RSTextMaterial txtUsuario;
    // End of variables declaration//GEN-END:variables

}
