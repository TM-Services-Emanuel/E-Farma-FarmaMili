package IU;

import Componentes.ConexionBD;
import Componentes.Mensajes;
import Componentes.Software;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import org.mariadb.jdbc.MariaDbConnection;
import org.mariadb.jdbc.MariaDbStatement;

public final class frmCargaInicial extends javax.swing.JFrame {

    public static ResultSet rs;
    public static MariaDbStatement st;
    public static MariaDbConnection con;

    public frmCargaInicial() {
        my_style();
        initComponents();
        cargarIcono();
        Iniciar();
        Titulo();
        jProgressBar1.setVisible(false);
    }
    
    public static void prepararBD() {
        try {
            con = (MariaDbConnection) new ConexionBD().getConexion();
            if (con == null) {
                System.out.println("No hay Conexion con la Base de Datos");
            } else {
                st = (MariaDbStatement) con.createStatement();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void Titulo() {
        prepararBD();
        try {
            String sql = "SELECT * FROM software WHERE indicador='S'";
            rs = st.executeQuery(sql);
            rs.first();
            Software.setSoftware(rs.getString("nombre"));
            Software.setDescripcion(rs.getString("descripcion"));
            Software.setVersion(rs.getString("version"));
            Software.setDesarrollador(rs.getString("desarrollador"));
            Software.setProfesion(rs.getString("profesion"));
            Software.setTelefoo(rs.getString("tel_desarrollador"));
            Software.setCorreo(rs.getString("correo"));
        } catch (SQLException ee) {
            Software.setSoftware("null");
            Software.setDescripcion("null");
            Software.setVersion("null");
            Software.setDesarrollador("null");
            Software.setProfesion("null");
            Software.setTelefoo("null");
            Software.setCorreo("null");
        }
    }

    private void my_style() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.getMessage();
        }

    }

    private void Iniciar() {
        CargandoDatos CargandoDatos = new CargandoDatos();
        CargandoDatos.start();
        CargandoDatos = null;
        Cargando Cargando = new Cargando();
        Cargando.start();
        Cargando = null;
    }

    /*private void lookandfeel() {
        try {
            UIManager.setLookAndFeel("com.jtattoo.plaf.graphite.GraphiteLookAndFeel");

        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) {
            System.out.println(e.getMessage());
        }
    }*/
 /* void LookAndFeel2() {
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
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rSPanelGradiente1 = new rojeru_san.rspanel.RSPanelGradiente();
        jLabel2 = new javax.swing.JLabel();
        lblCarga = new javax.swing.JLabel();
        barProgress = new RSMaterialComponent.RSProgressMaterial();
        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        rSPanelGradiente1.setColorPrimario(new java.awt.Color(255, 255, 255));
        rSPanelGradiente1.setColorSecundario(new java.awt.Color(230, 230, 230));
        rSPanelGradiente1.setGradiente(rojeru_san.rspanel.RSPanelGradiente.Gradiente.CENTRAL);
        rSPanelGradiente1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/fast-farma.png"))); // NOI18N
        rSPanelGradiente1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 9, 271, 80));

        lblCarga.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        lblCarga.setForeground(new java.awt.Color(255, 255, 255));
        lblCarga.setText("Carga");
        lblCarga.setFocusable(false);
        lblCarga.setInheritsPopupMenu(false);
        lblCarga.setPreferredSize(new java.awt.Dimension(25, 14));
        rSPanelGradiente1.add(lblCarga, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 386, 380, 20));

        barProgress.setForeground(new java.awt.Color(255, 255, 255));
        barProgress.setFocusable(false);
        barProgress.setTimeProgress(2500);
        barProgress.setWidthProgress(3);
        rSPanelGradiente1.add(barProgress, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 375, 30, 30));

        jProgressBar1.setBackground(new java.awt.Color(17, 35, 46));
        jProgressBar1.setForeground(new java.awt.Color(17, 35, 46));
        jProgressBar1.setEnabled(false);
        jProgressBar1.setString("");
        jProgressBar1.setStringPainted(true);
        rSPanelGradiente1.add(jProgressBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 20, 130, 20));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/CARGA_INICIAL_1.png"))); // NOI18N
        rSPanelGradiente1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 410));

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

    public void velocidadDeCarga() throws InterruptedException {
        for (int i = 0; i <= 100; i++) {
            Thread.sleep(60L);
            jProgressBar1.setValue(i);
            if (i == 00) {
                lblCarga.setText(" Cargando libreria de componentes y controladores necesarios");
            }
            if (i == 10) {
                lblCarga.setText(" Levantando los modelos y datos de software");
            }
            if (i == 20) {
                lblCarga.setText(" Comprobando conexion con la base de datos");
            }
            if (i == 25) {
                lblCarga.setText(" Conexion exitosa");
            }
            if (i == 30) {
                lblCarga.setText(" Cargando los reportes pretinentes y las interfaces de usuario");
            }
            if (i == 40) {
                lblCarga.setText(" Verificando perfiles de acceso...");
            }
            if (i == 50) {
                lblCarga.setText(" Verificando Usuarios...");
            }
            if (i == 60) {
                lblCarga.setText(" Verificación completada con exito");
            }
            if (i == 65) {
                lblCarga.setText(" Cargando Listas de funciones...");
            }
            if (i == 70) {
                lblCarga.setText(" Cargando módulos de operación...");
            }
            if (i == 75) {
                lblCarga.setText(" Carga de listas y modulos Terminada");
            }
            if (i == 80) {
                lblCarga.setText(" El software se ejecutara sin ningún inconveniente");
            }
            if (i == 95) {
                lblCarga.setText(" Bienvenido a FAST-FARMA");
            }
        }
    }

    class Cargando extends Thread {

        public Cargando() {
            super();
        }

        @Override
        public void run() {
            setProgresoMax(100);
            try {
                velocidadDeCarga();
            } catch (InterruptedException ex) {
                Logger.getLogger(frmCargaInicial.class.getName()).log(Level.SEVERE, null, ex);
            }
            new frmAcceso().setVisible(true);
            dispose();
        }
    }

    class CargandoDatos extends Thread {

        public CargandoDatos() {
            super();
        }

        @Override
        public void run() {
            try {
                velocidadDeCarga();
            } catch (InterruptedException ex) {
                Logger.getLogger(frmCargaInicial.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void setProgresoMax(int maxProgress) {
        jProgressBar1.setMaximum(maxProgress);
    }

    public void setProgreso(int progress) {
        final int progreso = progress;
        jProgressBar1.setValue(progreso);
    }

    void cargarIcono() {
        try {
            setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Iconos/logo1.png")));
            this.setLocationRelativeTo(null);
        } catch (Exception e) {
            Mensajes.error("No se pudo cargo icono");
        }
    }

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
            java.util.logging.Logger.getLogger(frmCargaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new frmCargaInicial().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private RSMaterialComponent.RSProgressMaterial barProgress;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JLabel lblCarga;
    private rojeru_san.rspanel.RSPanelGradiente rSPanelGradiente1;
    // End of variables declaration//GEN-END:variables
}
