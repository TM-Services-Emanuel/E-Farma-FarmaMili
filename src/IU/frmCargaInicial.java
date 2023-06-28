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
        jProgressBar1 = new javax.swing.JProgressBar();
        rSPanelImage1 = new rojeru_san.rspanel.RSPanelImage();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblCarga = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        rSPanelGradiente1.setColorPrimario(new java.awt.Color(255, 255, 255));
        rSPanelGradiente1.setColorSecundario(new java.awt.Color(230, 230, 230));
        rSPanelGradiente1.setGradiente(rojeru_san.rspanel.RSPanelGradiente.Gradiente.CENTRAL);

        jProgressBar1.setBackground(new java.awt.Color(255, 255, 255));
        jProgressBar1.setForeground(new java.awt.Color(254, 50, 0));
        jProgressBar1.setBorderPainted(false);
        jProgressBar1.setEnabled(false);
        jProgressBar1.setOpaque(true);
        jProgressBar1.setString("");
        jProgressBar1.setStringPainted(true);

        rSPanelImage1.setImagen(new javax.swing.ImageIcon(getClass().getResource("/Recursos/GettyImages-1172906735-1024x608.jpg"))); // NOI18N

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/tm_services - 256.png"))); // NOI18N

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/fast-farma.png"))); // NOI18N

        lblCarga.setFont(new java.awt.Font("Roboto", 0, 10)); // NOI18N
        lblCarga.setForeground(new java.awt.Color(17, 35, 46));
        lblCarga.setText("Carga");
        lblCarga.setFocusable(false);
        lblCarga.setInheritsPopupMenu(false);
        lblCarga.setPreferredSize(new java.awt.Dimension(25, 14));

        javax.swing.GroupLayout rSPanelImage1Layout = new javax.swing.GroupLayout(rSPanelImage1);
        rSPanelImage1.setLayout(rSPanelImage1Layout);
        rSPanelImage1Layout.setHorizontalGroup(
            rSPanelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rSPanelImage1Layout.createSequentialGroup()
                .addGroup(rSPanelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(rSPanelImage1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(lblCarga, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        rSPanelImage1Layout.setVerticalGroup(
            rSPanelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rSPanelImage1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 244, Short.MAX_VALUE)
                .addComponent(lblCarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(rSPanelImage1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout rSPanelGradiente1Layout = new javax.swing.GroupLayout(rSPanelGradiente1);
        rSPanelGradiente1.setLayout(rSPanelGradiente1Layout);
        rSPanelGradiente1Layout.setHorizontalGroup(
            rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rSPanelImage1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        rSPanelGradiente1Layout.setVerticalGroup(
            rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                .addComponent(rSPanelImage1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

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
            Thread.sleep(30L);
            jProgressBar1.setValue(i);
            if (i == 00) {
                lblCarga.setText(" Cargando y Activando componentes necesarios...");
            }
            if (i == 10) {
                lblCarga.setText(" Comenzando inicio del Sistema...");
            }
            if (i == 20) {
                lblCarga.setText(" Iniciando conexion con la Base de Datos E-Farm...");
            }
            if (i == 25) {
                lblCarga.setText(" Conexion exitosa.");
            }
            if (i == 30) {
                lblCarga.setText(" Cargando Reportes e Interfaz de usuario...");
            }
            if (i == 40) {
                lblCarga.setText(" Verificando Perfiles de Acceso...");
            }
            if (i == 50) {
                lblCarga.setText(" Verificando Usuarios...");
            }
            if (i == 60) {
                lblCarga.setText(" Verificación completada con exito.");
            }
            if (i == 65) {
                lblCarga.setText(" Cargando Listas de funciones...");
            }
            if (i == 70) {
                lblCarga.setText(" Cargando Módulos de operación...");
            }
            if (i == 75) {
                lblCarga.setText(" Carga de listas y modulos Terminada.");
            }
            if (i == 80) {
                lblCarga.setText(" El sistema se ha ejecutado sin ningún inconveniente.");
            }
            if (i == 95) {
                lblCarga.setText(" Bienvenido al Sistema E-Farm.");
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JLabel lblCarga;
    private rojeru_san.rspanel.RSPanelGradiente rSPanelGradiente1;
    private rojeru_san.rspanel.RSPanelImage rSPanelImage1;
    // End of variables declaration//GEN-END:variables
}
