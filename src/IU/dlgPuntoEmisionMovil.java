package IU;

import Componentes.DataSourceService;
import Componentes.Mensajes;
import Componentes.Software;
import Componentes.cargarComboBox;
import Componentes.validarCampos;
import Controladores.CabecerasTablas;
import Controladores.ControlLogeo;
import Controladores.controlPuntoEmisionMovil;
import Datos.GestionarPuntoEmisionMovil;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.sql.*;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class dlgPuntoEmisionMovil extends javax.swing.JDialog {
    static DataSourceService dss = new DataSourceService();
    private int ban;

    public dlgPuntoEmisionMovil(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        cargarComboBox.cargar(cboTimbrado, "SELECT * FROM timbrado WHERE estado='Activo'");
        titulo();
        CabecerasTablas.PuntoEmision(tbPuntoEmision);
        controlPuntoEmisionMovil.listPuntoEmision(tbPuntoEmision);
        Estados();
    }

    final void titulo() {
        if (Software.getSoftware().equals("null")) {
            this.setTitle("Gestionar Punto de Emisión");
        } else {
            this.setTitle(Software.getSoftware() + " - Gestionar Punto de Emisión");
        }
    }

    private void Estados() {
        if (rbActivo.isSelected()) {
            etiEstado.setText("ACTIVO");
        } else {
            etiEstado.setText("INACTIVO");
        }
    }

    public void Cancelar() {
        ban = 0;
        btnNuevo.setEnabled(true);
        btnModificar.setEnabled(false);
        btnGuardar.setEnabled(false);
        btnCancelar.setEnabled(false);
        btnSalir.setEnabled(true);
        btnEliminar.setEnabled(false);
        tbPuntoEmision.clearSelection();
        tbPuntoEmision.setEnabled(true);
        //
        cboTimbrado.setEnabled(false);
        txtEstablecimiento.setEnabled(false);
        txtEmision.setEnabled(false);
        txtDireccion.setEnabled(false);
        txtFInicio.setEnabled(false);
        txtFFin.setEnabled(false);
        txtFActual.setEnabled(false);
        cbTickeet.setEnabled(false);
        rbActivo.setEnabled(false);
        rbInactivo.setEnabled(false);
        btnBuscarImpresora.setEnabled(false);
        txtIP.setEnabled(false);
        limpiarCampos();
        btnNuevo.requestFocus();
    }

    public void modcboTimbrado(String idTimbrado) {
        DefaultComboBoxModel ml = new DefaultComboBoxModel();
        String sqlTimbs = "SELECT * FROM timbrado WHERE estado='Activo'";
        String sqlTimbEsp = "SELECT * FROM timbrado WHERE idtimbrado=" + idTimbrado;
        try (Connection cn = dss.getDataSource().getConnection(); Statement st = cn.createStatement(); ResultSet rs = st.executeQuery(sqlTimbs); ResultSet rss = st.executeQuery(sqlTimbEsp)) {
            ml.addElement("SELEC. UNA OPCIÓN");
            while (rs.next()) {
                ml.addElement(rs.getString("descripcion"));
            }
            rss.first();
            Object descripcion = (Object) rss.getString("descripcion");
            cboTimbrado.setModel(ml);
            cboTimbrado.setSelectedItem(descripcion);
            rs.close();
            rss.close();
            st.close();
            cn.close();
        } catch (SQLException ew) {
            System.out.println("Error mod timbrado: " + ew.getMessage());
        }

        try (Connection cn = dss.getDataSource().getConnection(); Statement st = cn.createStatement(); ResultSet rs = st.executeQuery("select * from timbrado where idtimbrado=" + idTimbrado)) {
            rs.first();
            try {
                if (rs.getRow() != 0) {
                    lbFechaTimbrado.setText("VALIDEZ: " + rs.getString(3) + " - " + rs.getString(4));
                    txtEstablecimiento.requestFocus();
                } else {
                    System.out.println("No se puede cargar Fecha timbrado.");
                }
            } catch (SQLException ee) {
                System.out.println(ee.getMessage());
            }
            rs.close();
            st.close();
            cn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupActivo = new javax.swing.ButtonGroup();
        Blanco = new org.edisoncor.gui.panel.PanelImage();
        Oscuro = new org.edisoncor.gui.panel.PanelImage();
        jPanel4 = new javax.swing.JPanel();
        PnlNuevo = new rojeru_san.rspanel.RSPanelImage();
        btnNuevo = new RSMaterialComponent.RSButtonIconUno();
        Separador1 = new javax.swing.JSeparator();
        LabelTitulo1 = new javax.swing.JLabel();
        PnlModificar = new rojeru_san.rspanel.RSPanelImage();
        btnModificar = new RSMaterialComponent.RSButtonIconUno();
        Separador2 = new javax.swing.JSeparator();
        LabelTitulo2 = new javax.swing.JLabel();
        PnlGuardar = new rojeru_san.rspanel.RSPanelImage();
        btnGuardar = new RSMaterialComponent.RSButtonIconUno();
        Separador3 = new javax.swing.JSeparator();
        LabelTitulo3 = new javax.swing.JLabel();
        PnlCancelar = new rojeru_san.rspanel.RSPanelImage();
        btnCancelar = new RSMaterialComponent.RSButtonIconUno();
        Separador4 = new javax.swing.JSeparator();
        LabelTitulo4 = new javax.swing.JLabel();
        PnlEliminar = new rojeru_san.rspanel.RSPanelImage();
        btnEliminar = new RSMaterialComponent.RSButtonIconUno();
        Separador = new javax.swing.JSeparator();
        LabelTitulo = new javax.swing.JLabel();
        btnSalir = new RSMaterialComponent.RSButtonIconUno();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtCod = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cboTimbrado = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        txtEstablecimiento = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtEmision = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtFInicio = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtFFin = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtFActual = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        cbTickeet = new javax.swing.JCheckBox();
        txtIP = new javax.swing.JTextField();
        rbActivo = new javax.swing.JRadioButton();
        rbInactivo = new javax.swing.JRadioButton();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel13 = new javax.swing.JLabel();
        etiEstado = new javax.swing.JLabel();
        lbFechaTimbrado = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtImpresora = new javax.swing.JTextField();
        btnBuscarImpresora = new RSMaterialComponent.RSButtonIconUno();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbPuntoEmision = new javax.swing.JTable()
        {
            public boolean isCellEditable(int rowInddex, int celIndex)
            {
                return false;
            }
        };

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        Blanco.setBackground(new java.awt.Color(255, 255, 255));
        Blanco.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(17, 35, 46)));
        Blanco.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/fondoBlanco.jpg"))); // NOI18N
        Blanco.setPreferredSize(new java.awt.Dimension(690, 418));
        Blanco.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Oscuro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/fondo.png"))); // NOI18N
        Oscuro.setPreferredSize(new java.awt.Dimension(690, 418));
        Oscuro.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setOpaque(false);
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PnlNuevo.setImagen(new javax.swing.ImageIcon(getClass().getResource("/Recursos/CONTENEDOR2.png"))); // NOI18N
        PnlNuevo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnNuevo.setBackground(new java.awt.Color(0, 102, 0));
        btnNuevo.setBackgroundHover(new java.awt.Color(255, 255, 255));
        btnNuevo.setForegroundHover(new java.awt.Color(0, 102, 0));
        btnNuevo.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.ADD);
        btnNuevo.setRippleColor(java.awt.Color.white);
        btnNuevo.setTypeBorder(RSMaterialComponent.RSButtonIconUno.TYPEBORDER.CIRCLE);
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        PnlNuevo.add(btnNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 13, 45, 45));

        Separador1.setForeground(new java.awt.Color(204, 204, 204));
        PnlNuevo.add(Separador1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 66, 76, 3));

        LabelTitulo1.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        LabelTitulo1.setForeground(new java.awt.Color(17, 35, 46));
        LabelTitulo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelTitulo1.setText("NUEVO");
        PnlNuevo.add(LabelTitulo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 71, 76, -1));

        jPanel4.add(PnlNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 3, 100, 100));

        PnlModificar.setImagen(new javax.swing.ImageIcon(getClass().getResource("/Recursos/CONTENEDOR2.png"))); // NOI18N
        PnlModificar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnModificar.setBackground(new java.awt.Color(255, 102, 0));
        btnModificar.setBackgroundHover(new java.awt.Color(255, 255, 255));
        btnModificar.setEnabled(false);
        btnModificar.setForegroundHover(new java.awt.Color(255, 102, 0));
        btnModificar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EDIT);
        btnModificar.setRippleColor(java.awt.Color.white);
        btnModificar.setTypeBorder(RSMaterialComponent.RSButtonIconUno.TYPEBORDER.CIRCLE);
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        PnlModificar.add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 13, 45, 45));

        Separador2.setForeground(new java.awt.Color(204, 204, 204));
        PnlModificar.add(Separador2, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 66, 76, 3));

        LabelTitulo2.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        LabelTitulo2.setForeground(new java.awt.Color(17, 35, 46));
        LabelTitulo2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelTitulo2.setText("MODIFICAR");
        PnlModificar.add(LabelTitulo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 71, 76, -1));

        jPanel4.add(PnlModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 3, 100, 100));

        PnlGuardar.setImagen(new javax.swing.ImageIcon(getClass().getResource("/Recursos/CONTENEDOR2.png"))); // NOI18N
        PnlGuardar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnGuardar.setBackground(new java.awt.Color(0, 102, 255));
        btnGuardar.setBackgroundHover(new java.awt.Color(255, 255, 255));
        btnGuardar.setEnabled(false);
        btnGuardar.setForegroundHover(new java.awt.Color(0, 102, 0));
        btnGuardar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.SAVE);
        btnGuardar.setRippleColor(java.awt.Color.white);
        btnGuardar.setTypeBorder(RSMaterialComponent.RSButtonIconUno.TYPEBORDER.CIRCLE);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        PnlGuardar.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 13, 45, 45));

        Separador3.setForeground(new java.awt.Color(204, 204, 204));
        PnlGuardar.add(Separador3, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 66, 76, 3));

        LabelTitulo3.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        LabelTitulo3.setForeground(new java.awt.Color(17, 35, 46));
        LabelTitulo3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelTitulo3.setText("REGISTRAR");
        PnlGuardar.add(LabelTitulo3, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 71, 76, -1));

        jPanel4.add(PnlGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(199, 3, 100, 100));

        PnlCancelar.setImagen(new javax.swing.ImageIcon(getClass().getResource("/Recursos/CONTENEDOR2.png"))); // NOI18N
        PnlCancelar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCancelar.setBackground(new java.awt.Color(153, 0, 51));
        btnCancelar.setBackgroundHover(new java.awt.Color(255, 255, 255));
        btnCancelar.setEnabled(false);
        btnCancelar.setForegroundHover(new java.awt.Color(153, 0, 51));
        btnCancelar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.CANCEL);
        btnCancelar.setRippleColor(java.awt.Color.white);
        btnCancelar.setTypeBorder(RSMaterialComponent.RSButtonIconUno.TYPEBORDER.CIRCLE);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        PnlCancelar.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 13, 45, 45));

        Separador4.setForeground(new java.awt.Color(204, 204, 204));
        PnlCancelar.add(Separador4, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 66, 76, 3));

        LabelTitulo4.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        LabelTitulo4.setForeground(new java.awt.Color(17, 35, 46));
        LabelTitulo4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelTitulo4.setText("CANCELAR");
        PnlCancelar.add(LabelTitulo4, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 71, 76, -1));

        jPanel4.add(PnlCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(296, 3, 100, 100));

        PnlEliminar.setImagen(new javax.swing.ImageIcon(getClass().getResource("/Recursos/CONTENEDOR2.png"))); // NOI18N
        PnlEliminar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnEliminar.setBackground(new java.awt.Color(255, 0, 0));
        btnEliminar.setBackgroundHover(new java.awt.Color(255, 255, 255));
        btnEliminar.setEnabled(false);
        btnEliminar.setForegroundHover(new java.awt.Color(255, 0, 0));
        btnEliminar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.DELETE);
        btnEliminar.setRippleColor(java.awt.Color.white);
        btnEliminar.setTypeBorder(RSMaterialComponent.RSButtonIconUno.TYPEBORDER.CIRCLE);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        PnlEliminar.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 13, 45, 45));

        Separador.setForeground(new java.awt.Color(204, 204, 204));
        PnlEliminar.add(Separador, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 66, 76, 3));

        LabelTitulo.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        LabelTitulo.setForeground(new java.awt.Color(17, 35, 46));
        LabelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelTitulo.setText("ELIMINAR");
        PnlEliminar.add(LabelTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 71, 76, -1));

        jPanel4.add(PnlEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(393, 3, 100, 100));

        Oscuro.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 100));

        btnSalir.setBackground(new java.awt.Color(17, 35, 46));
        btnSalir.setBackgroundHover(new java.awt.Color(205, 0, 0));
        btnSalir.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.CLOSE);
        btnSalir.setRippleColor(java.awt.Color.white);
        btnSalir.setTypeBorder(RSMaterialComponent.RSButtonIconUno.TYPEBORDER.CIRCLE);
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        Oscuro.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(778, 3, 20, 20));

        Blanco.add(Oscuro, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 1, 801, 105));

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel2.setOpaque(false);
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel3.setText("ID");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 12, 21, 23));

        txtCod.setEditable(false);
        txtCod.setBackground(new java.awt.Color(255, 255, 255));
        txtCod.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        txtCod.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCod.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtCod.setOpaque(false);
        jPanel2.add(txtCod, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 12, 39, 23));

        jLabel2.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel2.setText("Timbrado");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 12, -1, 23));

        cboTimbrado.setFont(new java.awt.Font("Roboto", 1, 13)); // NOI18N
        cboTimbrado.setEnabled(false);
        cboTimbrado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboTimbradoActionPerformed(evt);
            }
        });
        cboTimbrado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cboTimbradoKeyPressed(evt);
            }
        });
        jPanel2.add(cboTimbrado, new org.netbeans.lib.awtextra.AbsoluteConstraints(188, 12, 280, 23));

        jLabel6.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel6.setText("Establecimiento");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 68, -1, 23));

        txtEstablecimiento.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        txtEstablecimiento.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtEstablecimiento.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtEstablecimiento.setEnabled(false);
        txtEstablecimiento.setOpaque(false);
        txtEstablecimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEstablecimientoActionPerformed(evt);
            }
        });
        txtEstablecimiento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtEstablecimientoKeyPressed(evt);
            }
        });
        jPanel2.add(txtEstablecimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(188, 68, 70, 23));

        jLabel7.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel7.setText("Punto de expedición");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(279, 68, 120, 23));

        txtEmision.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        txtEmision.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtEmision.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtEmision.setEnabled(false);
        txtEmision.setOpaque(false);
        txtEmision.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmisionActionPerformed(evt);
            }
        });
        txtEmision.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtEmisionKeyPressed(evt);
            }
        });
        jPanel2.add(txtEmision, new org.netbeans.lib.awtextra.AbsoluteConstraints(398, 68, 70, 23));

        jLabel8.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel8.setText("Dirección");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 95, -1, 23));

        txtDireccion.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        txtDireccion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtDireccion.setEnabled(false);
        txtDireccion.setOpaque(false);
        txtDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDireccionActionPerformed(evt);
            }
        });
        txtDireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDireccionKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDireccionKeyTyped(evt);
            }
        });
        jPanel2.add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(188, 95, 280, 23));

        jLabel9.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel9.setText("Factura Inicio");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 122, -1, 23));

        txtFInicio.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        txtFInicio.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFInicio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtFInicio.setEnabled(false);
        txtFInicio.setOpaque(false);
        txtFInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFInicioActionPerformed(evt);
            }
        });
        txtFInicio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtFInicioKeyPressed(evt);
            }
        });
        jPanel2.add(txtFInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(188, 122, 80, 23));

        jLabel10.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel10.setText("Factura Fin");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 122, -1, 23));

        txtFFin.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        txtFFin.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFFin.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtFFin.setEnabled(false);
        txtFFin.setOpaque(false);
        txtFFin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFFinActionPerformed(evt);
            }
        });
        txtFFin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtFFinKeyPressed(evt);
            }
        });
        jPanel2.add(txtFFin, new org.netbeans.lib.awtextra.AbsoluteConstraints(388, 122, 80, 23));

        jLabel11.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel11.setText("Factura Actual");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 150, -1, 23));

        txtFActual.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        txtFActual.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFActual.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtFActual.setEnabled(false);
        txtFActual.setOpaque(false);
        txtFActual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFActualActionPerformed(evt);
            }
        });
        txtFActual.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtFActualKeyPressed(evt);
            }
        });
        jPanel2.add(txtFActual, new org.netbeans.lib.awtextra.AbsoluteConstraints(188, 150, 80, 23));

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel3.setOpaque(false);
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cbTickeet.setBackground(new java.awt.Color(255, 102, 0));
        cbTickeet.setFont(new java.awt.Font("Roboto Black", 1, 11)); // NOI18N
        cbTickeet.setSelected(true);
        cbTickeet.setText("PARA EMISIÓN DE TICKET");
        cbTickeet.setEnabled(false);
        cbTickeet.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        cbTickeet.setIconTextGap(6);
        cbTickeet.setOpaque(false);
        cbTickeet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTickeetActionPerformed(evt);
            }
        });
        jPanel3.add(cbTickeet, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 5, 180, 20));

        txtIP.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtIP.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtIP.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtIP.setEnabled(false);
        txtIP.setOpaque(false);
        txtIP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtIPKeyPressed(evt);
            }
        });
        jPanel3.add(txtIP, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, 98, 23));

        grupActivo.add(rbActivo);
        rbActivo.setText("P. Expedición Activo");
        rbActivo.setEnabled(false);
        rbActivo.setIconTextGap(6);
        rbActivo.setOpaque(false);
        rbActivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbActivoActionPerformed(evt);
            }
        });
        jPanel3.add(rbActivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 65, 150, 18));

        grupActivo.add(rbInactivo);
        rbInactivo.setSelected(true);
        rbInactivo.setText("P. Expedición Inactivo");
        rbInactivo.setEnabled(false);
        rbInactivo.setIconTextGap(6);
        rbInactivo.setOpaque(false);
        rbInactivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbInactivoActionPerformed(evt);
            }
        });
        jPanel3.add(rbInactivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 82, 150, 20));

        jSeparator2.setForeground(new java.awt.Color(204, 204, 204));
        jPanel3.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 60, 274, -1));

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Dirección IP");
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 30, 97, 23));

        etiEstado.setBackground(new java.awt.Color(255, 255, 255));
        etiEstado.setFont(new java.awt.Font("Roboto", 1, 13)); // NOI18N
        etiEstado.setForeground(new java.awt.Color(0, 153, 255));
        etiEstado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etiEstado.setOpaque(true);
        jPanel3.add(etiEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(161, 65, 120, 35));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(483, 12, 290, 107));

        lbFechaTimbrado.setBackground(new java.awt.Color(255, 102, 0));
        lbFechaTimbrado.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        lbFechaTimbrado.setForeground(new java.awt.Color(255, 255, 255));
        lbFechaTimbrado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbFechaTimbrado.setOpaque(true);
        jPanel2.add(lbFechaTimbrado, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 43, 454, 16));

        jLabel1.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel1.setText("Impresora Predeterminada");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 177, -1, 23));

        txtImpresora.setEditable(false);
        txtImpresora.setBackground(new java.awt.Color(255, 255, 255));
        txtImpresora.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        txtImpresora.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtImpresora.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtImpresora.setOpaque(false);
        jPanel2.add(txtImpresora, new org.netbeans.lib.awtextra.AbsoluteConstraints(188, 177, 280, 23));

        btnBuscarImpresora.setBackground(new java.awt.Color(255, 102, 0));
        btnBuscarImpresora.setBackgroundHover(new java.awt.Color(255, 102, 0));
        btnBuscarImpresora.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.SEARCH);
        btnBuscarImpresora.setRippleColor(java.awt.Color.white);
        btnBuscarImpresora.setTypeBorder(RSMaterialComponent.RSButtonIconUno.TYPEBORDER.CIRCLE);
        btnBuscarImpresora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarImpresoraActionPerformed(evt);
            }
        });
        jPanel2.add(btnBuscarImpresora, new org.netbeans.lib.awtextra.AbsoluteConstraints(472, 177, 23, 23));

        Blanco.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 117, 780, 210));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        tbPuntoEmision.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        tbPuntoEmision.setModel(new javax.swing.table.DefaultTableModel(
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
        tbPuntoEmision.setGridColor(new java.awt.Color(204, 204, 204));
        tbPuntoEmision.setRowHeight(20);
        tbPuntoEmision.setShowGrid(true);
        tbPuntoEmision.setShowVerticalLines(false);
        tbPuntoEmision.getTableHeader().setResizingAllowed(false);
        tbPuntoEmision.getTableHeader().setReorderingAllowed(false);
        tbPuntoEmision.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbPuntoEmisionMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbPuntoEmisionMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tbPuntoEmision);

        Blanco.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 330, 801, 219));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Blanco, javax.swing.GroupLayout.PREFERRED_SIZE, 803, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Blanco, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbPuntoEmisionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbPuntoEmisionMouseClicked
        // TODO add your handling code here:
        

    }//GEN-LAST:event_tbPuntoEmisionMouseClicked

    private void txtFInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFInicioActionPerformed
        // TODO add your handling code here:
        txtFFin.requestFocus();
    }//GEN-LAST:event_txtFInicioActionPerformed

    private void txtEmisionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmisionKeyPressed
        // TODO add your handling code here:
        validarCampos.soloNumeros(txtEmision);
        validarCampos.cantCaracteres(txtEmision, 3);
    }//GEN-LAST:event_txtEmisionKeyPressed

    private void txtEmisionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmisionActionPerformed
        // TODO add your handling code here:
        txtDireccion.requestFocus();
    }//GEN-LAST:event_txtEmisionActionPerformed

    private void txtEstablecimientoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEstablecimientoKeyPressed
        // TODO add your handling code here:
        validarCampos.soloNumeros(txtEstablecimiento);
        validarCampos.cantCaracteres(txtEstablecimiento, 3);
    }//GEN-LAST:event_txtEstablecimientoKeyPressed

    private void txtEstablecimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEstablecimientoActionPerformed
        // TODO add your handling code here:
        txtEmision.requestFocus();
    }//GEN-LAST:event_txtEstablecimientoActionPerformed

    private void cboTimbradoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cboTimbradoKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (cboTimbrado.getSelectedIndex() == 0) {
                lbFechaTimbrado.setText("");
            } else {
                try {
                    int idT;
                    idT = Integer.parseInt(cargarComboBox.getCodidgo(cboTimbrado));
                    try (Connection cn = dss.getDataSource().getConnection(); Statement st = cn.createStatement(); ResultSet rs = st.executeQuery("select * from timbrado where idtimbrado=" + idT)) {
                        rs.first();
                        try {
                            if (rs.getRow() != 0) {
                                lbFechaTimbrado.setText("VALIDEZ: " + rs.getString(3) + " - " + rs.getString(4));
                                txtEstablecimiento.requestFocus();
                            } else {
                                System.out.println("No se puede cargar Fecha timbrado.");
                            }
                        } catch (SQLException ee) {
                            System.out.println(ee.getMessage());
                        }
                        rs.close();
                        st.close();
                        cn.close();
                    } catch (SQLException ex) {
                        System.out.println(ex.getMessage());
                    }

                } catch (Exception e) {
                }
                txtEstablecimiento.requestFocus();
            }

        }
    }//GEN-LAST:event_cboTimbradoKeyPressed

    private void cboTimbradoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboTimbradoActionPerformed
        // TODO add your handling code here:
        /*if (cboTimbrado.getSelectedIndex() == 0) {
            lbFechaTimbrado.setText("");
        } else {
            try {
                int idT;
                idT = Integer.parseInt(cargarComboBoxMovil.getCodidgo(cboTimbrado));
                try {
                    rs = sentencia.executeQuery("select * from timbrado where idtimbrado=" + idT);
                    rs.first();
                    try {
                        if (rs.getRow() != 0) {
                            lbFechaTimbrado.setText("VALIDEZ: " + rs.getString(3) + " - " + rs.getString(4));
                            txtEstablecimiento.requestFocus();
                        } else {
                            System.out.println("No se puede cargar Fecha timbrado.");
                        }
                    } catch (SQLException ee) {
                        System.out.println(ee.getMessage());
                    }
                    rs.close();
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }

            } catch (Exception e) {
            }
        }*/
    }//GEN-LAST:event_cboTimbradoActionPerformed

    private void rbInactivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbInactivoActionPerformed
        // TODO add your handling code here:
        Estados();
    }//GEN-LAST:event_rbInactivoActionPerformed

    private void rbActivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbActivoActionPerformed
        // TODO add your handling code here:
        Estados();
    }//GEN-LAST:event_rbActivoActionPerformed

    private void cbTickeetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTickeetActionPerformed
        // TODO add your handling code here:
        if (cbTickeet.isSelected()) {
            //txtIP.setEnabled(false);
        } else {
            //txtIP.setEnabled(true);
            //txtIP.requestFocus();
            rbActivo.doClick();
        }
    }//GEN-LAST:event_cbTickeetActionPerformed

    private void txtIPKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIPKeyPressed
        // TODO add your handling code here:
        validarCampos.soloDecimales(txtIP);
        validarCampos.cantCaracteres(txtIP, 16);
    }//GEN-LAST:event_txtIPKeyPressed

    private void txtDireccionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDireccionKeyPressed
        // TODO add your handling code here:
        validarCampos.cantCaracteres(txtDireccion, 20);
    }//GEN-LAST:event_txtDireccionKeyPressed

    private void txtDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccionActionPerformed
        // TODO add your handling code here:
        txtFInicio.requestFocus();
    }//GEN-LAST:event_txtDireccionActionPerformed

    private void txtFInicioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFInicioKeyPressed
        // TODO add your handling code here:
        validarCampos.soloNumeros(txtFInicio);
        validarCampos.cantCaracteres(txtFInicio, 3);
    }//GEN-LAST:event_txtFInicioKeyPressed

    private void txtFFinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFFinActionPerformed
        // TODO add your handling code here:
        txtFActual.requestFocus();
    }//GEN-LAST:event_txtFFinActionPerformed

    private void txtFFinKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFFinKeyPressed
        // TODO add your handling code here:
        validarCampos.soloNumeros(txtFFin);
        validarCampos.cantCaracteres(txtFFin, 10);
    }//GEN-LAST:event_txtFFinKeyPressed

    private void txtFActualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFActualActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_txtFActualActionPerformed

    private void txtFActualKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFActualKeyPressed
        // TODO add your handling code here:
        validarCampos.soloNumeros(txtFActual);
        validarCampos.cantCaracteres(txtFActual, 6);
    }//GEN-LAST:event_txtFActualKeyPressed

    private void txtDireccionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDireccionKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isLowerCase(c)) {
            String cad = ("" + c).toUpperCase();
            c = cad.charAt(0);
            evt.setKeyChar(c);
        }
    }//GEN-LAST:event_txtDireccionKeyTyped

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
        ban = 1;
        String cod = GestionarPuntoEmisionMovil.getCodigo();
        cargarComboBox.cargar(cboTimbrado, "SELECT * FROM timbrado WHERE estado='Activo'");
        txtCod.setText(cod);
        btnNuevo.setEnabled(false);
        btnModificar.setEnabled(false);
        btnGuardar.setEnabled(true);
        btnCancelar.setEnabled(true);
        btnSalir.setEnabled(false);
        btnEliminar.setEnabled(false);
        tbPuntoEmision.setEnabled(false);
        //
        cboTimbrado.setEnabled(true);
        txtEstablecimiento.setEnabled(true);
        txtEmision.setEnabled(true);
        txtDireccion.setEnabled(true);
        txtFInicio.setEnabled(true);
        txtFFin.setEnabled(true);
        txtFActual.setEnabled(true);
        cbTickeet.setEnabled(true);
        rbActivo.setEnabled(true);
        rbInactivo.setEnabled(true);
        btnBuscarImpresora.setEnabled(true);
        txtIP.setEnabled(true);
        //
        
        cboTimbrado.requestFocus();
        cboTimbrado.setPopupVisible(true);
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
        if (txtEstablecimiento.getText().trim().isEmpty()) {
            Mensajes.informacion("Ingrese el Establecimiento");
            txtEstablecimiento.requestFocus();
        } else if (txtEmision.getText().trim().isEmpty()) {
            Mensajes.informacion("Ingrese el Punto de Emisión");
            txtEmision.requestFocus();
        } else if (txtDireccion.getText().trim().isEmpty()) {
            Mensajes.informacion("Ingrese la Dirección");
            txtDireccion.requestFocus();
        } else if (txtFInicio.getText().trim().isEmpty()) {
            Mensajes.informacion("Ingrese número para el inicio de las facturaciones");
            txtFInicio.requestFocus();
        } else if (txtFFin.getText().trim().isEmpty()) {
            Mensajes.informacion("Ingrese número para la finalización de las facturaciones");
            txtFFin.requestFocus();
        } else if (txtFActual.getText().trim().isEmpty()) {
            Mensajes.informacion("Ingrese número actual de la facturación");
            txtFActual.requestFocus();
        } else if (txtImpresora.getText().trim().isEmpty()) {
            Mensajes.informacion("Seleccione la impresora predeterminada para este punto de emisión");
            btnBuscarImpresora.requestFocus();
        } else if (!cbTickeet.isSelected()) {
            if (txtIP.getText().trim().isEmpty()) {
                Mensajes.informacion("Ingrese la dirección IP de la terminar que utilizara este Punto de Emisión");
                txtIP.requestFocus();
            } else {
                try {
                    int resp = JOptionPane.showConfirmDialog(this, "¿Seguro que desea Modificar el registro?", "Modificar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if (resp == JOptionPane.YES_OPTION) {
                        controlPuntoEmisionMovil.actPuntoEmision();
                        //CabecerasTablas.limpiarTablaPE(tbPuntoEmision);
                        //controlPuntoEmisionMovil.listPuntoEmision(tbPuntoEmision);
                        Cancelar();
                    }
                } catch (HeadlessException ee) {
                }
            }
        } else {
            try {
                int resp = JOptionPane.showConfirmDialog(this, "¿Seguro que desea Modificar el registro?", "Modificar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (resp == JOptionPane.YES_OPTION) {
                    controlPuntoEmisionMovil.actPuntoEmision();
                    //CabecerasTablas.limpiarTablaPE(tbPuntoEmision);
                    //controlPuntoEmisionMovil.listPuntoEmision(tbPuntoEmision);
                    Cancelar();
                }
            } catch (HeadlessException ee) {
            }
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        if (cboTimbrado.getSelectedIndex() == 0) {
            Mensajes.informacion("Seleccione un Timbrado");
            cboTimbrado.requestFocus();
            cboTimbrado.setPopupVisible(true);
        } else if (txtEstablecimiento.getText().trim().isEmpty()) {
            Mensajes.informacion("Ingrese el Establecimiento");
            txtEstablecimiento.requestFocus();
        } else if (txtEmision.getText().trim().isEmpty()) {
            Mensajes.informacion("Ingrese el Punto de Emisión");
            txtEmision.requestFocus();
        } else if (txtDireccion.getText().trim().isEmpty()) {
            Mensajes.informacion("Ingrese la Dirección");
            txtDireccion.requestFocus();
        } else if (txtFInicio.getText().trim().isEmpty()) {
            Mensajes.informacion("Ingrese número para el inicio de las facturaciones");
            txtFInicio.requestFocus();
        } else if (txtFFin.getText().trim().isEmpty()) {
            Mensajes.informacion("Ingrese número para la finalización de las facturaciones");
            txtFFin.requestFocus();
        } else if (txtFActual.getText().trim().isEmpty()) {
            Mensajes.informacion("Ingrese número actual de la facturación");
            txtFActual.requestFocus();
        } else if (txtImpresora.getText().trim().isEmpty()) {
            Mensajes.informacion("Seleccione la impresora predeterminada para este punto de emisión");
            btnBuscarImpresora.requestFocus();
        } else if (!cbTickeet.isSelected()) {
            if (txtIP.getText().trim().isEmpty()) {
                Mensajes.informacion("Ingrese la dirección IP de la terminar que utilizara este Punto de Emisión");
                txtIP.requestFocus();
            } else {
                try {
                    int resp = JOptionPane.showConfirmDialog(this, "¿Seguro que desea insertar el registro?", "Insertar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if (resp == JOptionPane.YES_OPTION) {
                        String cod = GestionarPuntoEmisionMovil.getCodigo();
                        txtCod.setText(cod);
                        controlPuntoEmisionMovil.addPuntoEmision();
                        //CabecerasTablas.limpiarTablaPE(tbPuntoEmision);
                        //controlPuntoEmisionMovil.listPuntoEmision(tbPuntoEmision);
                        Cancelar();
                    }
                } catch (HeadlessException ee) {
                }
            }
        } else {
            try {
                int resp = JOptionPane.showConfirmDialog(this, "¿Seguro que desea insertar el registro?", "Insertar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (resp == JOptionPane.YES_OPTION) {
                    String cod = GestionarPuntoEmisionMovil.getCodigo();
                    txtCod.setText(cod);
                    controlPuntoEmisionMovil.addPuntoEmision();
                    //CabecerasTablas.limpiarTablaPE(tbPuntoEmision);
                    //controlPuntoEmisionMovil.listPuntoEmision(tbPuntoEmision);
                    Cancelar();
                }
            } catch (HeadlessException ee) {
            }
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        int rpta = Mensajes.confirmar("¿Seguro que desea cancelar esta operación?");
        if (rpta == 0) {
            Cancelar();
        }
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        try {
            int resp = JOptionPane.showConfirmDialog(this, "¿Seguro que desea Eliminar el registro?", "Eliminar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (resp == JOptionPane.YES_OPTION) {
                controlPuntoEmisionMovil.delPuntoEmision();
                //CabecerasTablas.limpiarTablaPE(tbPuntoEmision);
                //controlPuntoEmisionMovil.listPuntoEmision(tbPuntoEmision);
                Cancelar();
            }
        } catch (HeadlessException ee) {
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        int rpta = Mensajes.confirmar("¿Seguro que desea salir del formulario?");
        if (rpta == 0) {
            ControlLogeo.Timbrado_Ticket();
            this.dispose();
        }
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnBuscarImpresoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarImpresoraActionPerformed
        // TODO add your handling code here:
        try {
            dlgImpresorasPE imp = new dlgImpresorasPE(null, true);
            imp.setLocationRelativeTo(null);
            imp.setVisible(true);
        } catch (Exception e) {
            Mensajes.informacion("No hay conexión con el servidor");
        }
    }//GEN-LAST:event_btnBuscarImpresoraActionPerformed

    private void tbPuntoEmisionMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbPuntoEmisionMousePressed
        // TODO add your handling code here:
        if (ban == 0) {
            btnNuevo.setEnabled(false);
            btnModificar.setEnabled(true);
            btnGuardar.setEnabled(false);
            btnCancelar.setEnabled(true);
            btnSalir.setEnabled(false);
            btnEliminar.setEnabled(true);
            tbPuntoEmision.setVisible(true);
            //
            cboTimbrado.setEnabled(false);
            txtEstablecimiento.setEnabled(true);
            txtEmision.setEnabled(true);
            txtDireccion.setEnabled(true);
            txtFInicio.setEnabled(true);
            txtFFin.setEnabled(true);
            txtFActual.setEnabled(true);
            cbTickeet.setEnabled(true);
            rbActivo.setEnabled(true);
            rbInactivo.setEnabled(true);
            btnBuscarImpresora.setEnabled(true);
            txtIP.setEnabled(true);

            int fila = tbPuntoEmision.getSelectedRow();
            String cod = tbPuntoEmision.getValueAt(fila, 0).toString();
            String itTimbrado = tbPuntoEmision.getValueAt(fila, 1).toString();
            String establecimiento = tbPuntoEmision.getValueAt(fila, 3).toString();
            String puntoEmision = tbPuntoEmision.getValueAt(fila, 4).toString();
            String direccion = tbPuntoEmision.getValueAt(fila, 5).toString();
            String fi = tbPuntoEmision.getValueAt(fila, 6).toString();
            String ff = tbPuntoEmision.getValueAt(fila, 7).toString();
            String fa = tbPuntoEmision.getValueAt(fila, 8).toString();
            String tipo = tbPuntoEmision.getValueAt(fila, 9).toString();
            String ip = tbPuntoEmision.getValueAt(fila, 10).toString();
            String estado = tbPuntoEmision.getValueAt(fila, 11).toString();
            String impPred = tbPuntoEmision.getValueAt(fila, 12).toString();

            txtCod.setText(cod);
            modcboTimbrado(itTimbrado);
            txtEstablecimiento.setText(establecimiento);
            txtEmision.setText(puntoEmision);
            txtDireccion.setText(direccion);
            txtFInicio.setText(fi);
            txtFFin.setText(ff);
            txtFActual.setText(fa);
            if (tipo.equals("T")) {
                cbTickeet.setSelected(true);
                cbTickeetActionPerformed(null);
            } else {
                cbTickeet.setSelected(false);
                txtIP.setEnabled(true);
            }
            txtIP.setText(ip);
            if (estado.equals("Inactivo")) {
                rbInactivo.setSelected(true);
                rbInactivoActionPerformed(null);
            } else {
                rbActivo.setSelected(true);
                rbActivoActionPerformed(null);
            }
            txtImpresora.setText(impPred);
            txtEstablecimiento.requestFocus();
        }
    }//GEN-LAST:event_tbPuntoEmisionMousePressed

    void limpiarCampos() {
        txtCod.setText("");
        cboTimbrado.setSelectedIndex(0);
        lbFechaTimbrado.setText("");
        txtEstablecimiento.setText("");
        txtEmision.setText("");
        txtDireccion.setText("");
        txtFInicio.setText("");
        txtFFin.setText("");
        txtFActual.setText("");
        txtIP.setText("");
        cbTickeet.setSelected(true);
        rbInactivo.setSelected(true);
        tbPuntoEmision.clearSelection();
        txtImpresora.setText("");
        CabecerasTablas.limpiarTablaPE(tbPuntoEmision);
        controlPuntoEmisionMovil.listPuntoEmision(tbPuntoEmision);

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(dlgPuntoEmisionMovil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        //</editor-fold>
        java.awt.EventQueue.invokeLater(() -> {
            dlgPuntoEmisionMovil dialog = new dlgPuntoEmisionMovil(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel LabelTitulo;
    private javax.swing.JLabel LabelTitulo1;
    private javax.swing.JLabel LabelTitulo2;
    private javax.swing.JLabel LabelTitulo3;
    private javax.swing.JLabel LabelTitulo4;
    private org.edisoncor.gui.panel.PanelImage Oscuro;
    private rojeru_san.rspanel.RSPanelImage PnlCancelar;
    private rojeru_san.rspanel.RSPanelImage PnlEliminar;
    private rojeru_san.rspanel.RSPanelImage PnlGuardar;
    private rojeru_san.rspanel.RSPanelImage PnlModificar;
    private rojeru_san.rspanel.RSPanelImage PnlNuevo;
    private javax.swing.JSeparator Separador;
    private javax.swing.JSeparator Separador1;
    private javax.swing.JSeparator Separador2;
    private javax.swing.JSeparator Separador3;
    private javax.swing.JSeparator Separador4;
    private RSMaterialComponent.RSButtonIconUno btnBuscarImpresora;
    private RSMaterialComponent.RSButtonIconUno btnCancelar;
    private RSMaterialComponent.RSButtonIconUno btnEliminar;
    private RSMaterialComponent.RSButtonIconUno btnGuardar;
    private RSMaterialComponent.RSButtonIconUno btnModificar;
    private RSMaterialComponent.RSButtonIconUno btnNuevo;
    private RSMaterialComponent.RSButtonIconUno btnSalir;
    public static javax.swing.JCheckBox cbTickeet;
    public static javax.swing.JComboBox<String> cboTimbrado;
    private javax.swing.JLabel etiEstado;
    private javax.swing.ButtonGroup grupActivo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lbFechaTimbrado;
    public static javax.swing.JRadioButton rbActivo;
    public static javax.swing.JRadioButton rbInactivo;
    private javax.swing.JTable tbPuntoEmision;
    public static javax.swing.JTextField txtCod;
    public static javax.swing.JTextField txtDireccion;
    public static javax.swing.JTextField txtEmision;
    public static javax.swing.JTextField txtEstablecimiento;
    public static javax.swing.JTextField txtFActual;
    public static javax.swing.JTextField txtFFin;
    public static javax.swing.JTextField txtFInicio;
    public static javax.swing.JTextField txtIP;
    public static javax.swing.JTextField txtImpresora;
    // End of variables declaration//GEN-END:variables
}
