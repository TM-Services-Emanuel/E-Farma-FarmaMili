package IU;

import Componentes.DataSourceService;
import Componentes.Mensajes;
import Componentes.Redondeo;
import Componentes.Software;
import Componentes.cargarComboBox;
import Componentes.validarCampos;
import Controladores.CabecerasTablas;
import Controladores.controlArticulo;
import Datos.GestionarArticulos;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.sql.*;
import java.text.DecimalFormat;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class dlgGestArticulos extends javax.swing.JDialog {

    static DataSourceService dss = new DataSourceService();

    public dlgGestArticulos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        titulo();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Iconos/logo1.png")));
        Invisible();
    }

    final void titulo() {
        if (Software.getSoftware().equals("null")) {
            this.setTitle("Crear o modificar artículo");
        } else {
            this.setTitle(Software.getSoftware() + " - Crear o modificar artículo");
        }
    }

    private void CargarCombos() {
        cargarComboBox.cargar(cbLaboratorio, "SELECT * FROM laboratorio WHERE lab_indicador='S'");
        cargarComboBox.cargar(cbProveedor, "SELECT pro_codigo, pro_razonsocial, pro_indicador FROM proveedor WHERE pro_indicador='S'");
        cargarComboBox.cargar(cbFamilia, "SELECT * FROM familia WHERE fam_indicador='S'");
    }

    private void Invisible() {
        txtCodPro.setVisible(false);
        txtCodFam.setVisible(false);
        txtCodLab.setVisible(false);
        txtPrecioVentaML.setVisible(false);
    }

    private void Habilitacion() {
        btnNuevo.setEnabled(false);
        btnGuardar.setEnabled(true);
        btnModificar.setEnabled(false);
        btnCancelar.setEnabled(true);
        btnLaboratorio.setEnabled(true);
        btnProveedor.setEnabled(true);
        btnFamilia.setEnabled(true);
        txtCodBarra.setEnabled(true);
        txtDescripcion.setEnabled(true);
        txtPrincipio.setEnabled(true);
        txtAccion.setEnabled(true);
        rLibre.setEnabled(true);
        rControlado.setEnabled(true);
        rNacional.setEnabled(true);
        rImportado.setEnabled(true);
        rActivo.setEnabled(true);
        rInactivo.setEnabled(true);
        cbLaboratorio.setEnabled(true);
        cbFamilia.setEnabled(true);
        cbProveedor.setEnabled(true);
        txtCosto.setEnabled(true);
        txtPrecioPublico.setEnabled(true);
        txtGanancia.setEnabled(true);
        txtDesc.setEnabled(true);
        txtPrecioVenta.setEnabled(true);
        txtStock.setEnabled(true);
        txtStockMin.setEnabled(true);
    }

    private void pintarEstado() {
        if (rActivo.isSelected()) {
            rActivo.setFont(new java.awt.Font("Roboto", 1, 11));
            rActivo.setForeground(new java.awt.Color(255, 102, 0));
            rInactivo.setFont(new java.awt.Font("Roboto", 0, 11));
            rInactivo.setForeground(new java.awt.Color(0, 0, 0));
        } else {
            rActivo.setFont(new java.awt.Font("Roboto", 0, 11));
            rActivo.setForeground(new java.awt.Color(0, 0, 0));
            rInactivo.setFont(new java.awt.Font("Roboto", 1, 11));
            rInactivo.setForeground(new java.awt.Color(255, 102, 0));
        }
    }

    private void pintarVenta() {
        if (rLibre.isSelected()) {
            rLibre.setFont(new java.awt.Font("Roboto", 1, 11));
            rLibre.setForeground(new Color(0, 102, 0));
            rLibre.setColorCheck(new Color(0, 102, 0));
            rControlado.setFont(new java.awt.Font("Roboto", 0, 11));
            rControlado.setForeground(new java.awt.Color(0, 0, 0));
            rControlado.setColorCheck(new Color(51, 51, 51));
        } else {
            rLibre.setFont(new java.awt.Font("Roboto", 0, 11));
            rLibre.setForeground(new java.awt.Color(0, 0, 0));
            rLibre.setColorCheck(new Color(51, 51, 51));
            rControlado.setFont(new java.awt.Font("Roboto", 1, 11));
            rControlado.setForeground(new java.awt.Color(255, 0, 0));
            rControlado.setColorCheck(new Color(255, 0, 0));
        }
    }

    private void pintarTipo() {
        if (rNacional.isSelected()) {
            rNacional.setFont(new java.awt.Font("Roboto", 1, 11));
            rNacional.setForeground(new java.awt.Color(255, 102, 0));
            rImportado.setFont(new java.awt.Font("Roboto", 0, 11));
            rImportado.setForeground(new java.awt.Color(0, 0, 0));
        } else {
            rNacional.setFont(new java.awt.Font("Roboto", 0, 11));
            rNacional.setForeground(new java.awt.Color(0, 0, 0));
            rImportado.setFont(new java.awt.Font("Roboto", 1, 11));
            rImportado.setForeground(new java.awt.Color(255, 102, 0));
        }
    }

    private void Cancelar() {
        limpiarCampos();
        btnModificar.setEnabled(true);
        btnModificar.setEnabled(false);
        btnGuardar.setEnabled(false);
        btnCancelar.setEnabled(false);
        btnLaboratorio.setEnabled(false);
        btnProveedor.setEnabled(false);
        btnFamilia.setEnabled(false);
        txtCodBarra.setEnabled(false);
        txtDescripcion.setEnabled(false);
        txtPrincipio.setEnabled(false);
        txtAccion.setEnabled(false);
        rLibre.setEnabled(false);
        rControlado.setEnabled(false);
        rNacional.setEnabled(false);
        rImportado.setEnabled(false);
        rActivo.setEnabled(false);
        rInactivo.setEnabled(false);
        cbLaboratorio.setEnabled(false);
        cbFamilia.setEnabled(false);
        cbProveedor.setEnabled(false);
        txtCosto.setEnabled(false);
        txtPrecioPublico.setEnabled(false);
        txtGanancia.setEnabled(false);
        txtDesc.setEnabled(false);
        txtPrecioVenta.setEnabled(false);
        txtStock.setEnabled(false);
        txtStockMin.setEnabled(false);
        btnSalir.setEnabled(true);
        pintarEstado();
        pintarVenta();
        pintarTipo();
        Volver();
        this.dispose();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jPanel12 = new javax.swing.JPanel();
        btnSalir = new RSMaterialComponent.RSButtonIconUno();
        PanelContenedor3 = new rojeru_san.rspanel.RSPanelImage();
        btnCancelar = new RSMaterialComponent.RSButtonIconUno();
        Separador3 = new javax.swing.JSeparator();
        LabelTitulo3 = new javax.swing.JLabel();
        PanelContenedor2 = new rojeru_san.rspanel.RSPanelImage();
        btnGuardar = new RSMaterialComponent.RSButtonIconUno();
        Separador2 = new javax.swing.JSeparator();
        LabelTitulo2 = new javax.swing.JLabel();
        PanelContenedor1 = new rojeru_san.rspanel.RSPanelImage();
        btnNuevo = new RSMaterialComponent.RSButtonIconUno();
        Separador1 = new javax.swing.JSeparator();
        LabelTitulo1 = new javax.swing.JLabel();
        PanelContenedor = new rojeru_san.rspanel.RSPanelImage();
        btnModificar = new RSMaterialComponent.RSButtonIconUno();
        Separador = new javax.swing.JSeparator();
        LabelTitulo = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        txtCodProducto = new javax.swing.JTextField();
        txtCodBarra = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtPrincipio = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtAccion = new javax.swing.JTextArea();
        jPanel8 = new javax.swing.JPanel();
        rImportado = new rojerusan.RSRadioButton();
        rNacional = new rojerusan.RSRadioButton();
        jPanel5 = new javax.swing.JPanel();
        rLibre = new rojerusan.RSRadioButton();
        rControlado = new rojerusan.RSRadioButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnFamilia = new javax.swing.JButton();
        btnProveedor = new javax.swing.JButton();
        btnLaboratorio = new javax.swing.JButton();
        lbGan = new javax.swing.JLabel();
        lbIVA = new javax.swing.JLabel();
        cbLaboratorio = new RSMaterialComponent.RSComboBox();
        cbProveedor = new RSMaterialComponent.RSComboBox();
        cbFamilia = new RSMaterialComponent.RSComboBox();
        jPanel4 = new javax.swing.JPanel();
        rActivo = new rojerusan.RSRadioButton();
        rInactivo = new rojerusan.RSRadioButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        txtDesc = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txtPrecioVenta = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtCosto = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtGanancia = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtPrecioPublico = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jPanel6 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        txtStock = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtStockMin = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtIVACosto = new javax.swing.JTextField();
        cbImpuesto = new RSMaterialComponent.RSComboBox();
        jPanel11 = new javax.swing.JPanel();
        txtPrecioVentaM = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        txtCantM = new javax.swing.JTextField();
        txtPrecioVentaML = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        ckHabilitar = new rojerusan.RSCheckBox();
        jLabel1 = new javax.swing.JLabel();
        txtCodLab = new javax.swing.JTextField();
        txtCodPro = new javax.swing.JTextField();
        txtCodFam = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
                formWindowLostFocus(evt);
            }
        });

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(17, 35, 46)));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        jPanel12.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(857, 3, 20, 20));

        PanelContenedor3.setImagen(new javax.swing.ImageIcon(getClass().getResource("/Recursos/CONTENEDOR2.png"))); // NOI18N
        PanelContenedor3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCancelar.setBackground(new java.awt.Color(205, 0, 0));
        btnCancelar.setBackgroundHover(new java.awt.Color(255, 255, 255));
        btnCancelar.setForegroundHover(new java.awt.Color(205, 0, 0));
        btnCancelar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.CANCEL);
        btnCancelar.setRippleColor(java.awt.Color.white);
        btnCancelar.setTypeBorder(RSMaterialComponent.RSButtonIconUno.TYPEBORDER.CIRCLE);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        PanelContenedor3.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 15, 45, 45));

        Separador3.setForeground(new java.awt.Color(204, 204, 204));
        PanelContenedor3.add(Separador3, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 65, 76, 3));

        LabelTitulo3.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        LabelTitulo3.setForeground(new java.awt.Color(17, 35, 46));
        LabelTitulo3.setText("CANCELAR");
        PanelContenedor3.add(LabelTitulo3, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 70, -1, -1));

        jPanel12.add(PanelContenedor3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 0, 100, 98));

        PanelContenedor2.setImagen(new javax.swing.ImageIcon(getClass().getResource("/Recursos/CONTENEDOR2.png"))); // NOI18N
        PanelContenedor2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnGuardar.setBackground(new java.awt.Color(0, 102, 255));
        btnGuardar.setBackgroundHover(new java.awt.Color(255, 255, 255));
        btnGuardar.setForegroundHover(new java.awt.Color(0, 102, 255));
        btnGuardar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.SAVE);
        btnGuardar.setRippleColor(java.awt.Color.white);
        btnGuardar.setTypeBorder(RSMaterialComponent.RSButtonIconUno.TYPEBORDER.CIRCLE);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        PanelContenedor2.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 15, 45, 45));

        Separador2.setForeground(new java.awt.Color(204, 204, 204));
        PanelContenedor2.add(Separador2, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 65, 76, 3));

        LabelTitulo2.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        LabelTitulo2.setForeground(new java.awt.Color(17, 35, 46));
        LabelTitulo2.setText("GUARDAR");
        PanelContenedor2.add(LabelTitulo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 70, -1, -1));

        jPanel12.add(PanelContenedor2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 0, 100, 98));

        PanelContenedor1.setImagen(new javax.swing.ImageIcon(getClass().getResource("/Recursos/CONTENEDOR2.png"))); // NOI18N
        PanelContenedor1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        PanelContenedor1.add(btnNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 15, 45, 45));

        Separador1.setForeground(new java.awt.Color(204, 204, 204));
        PanelContenedor1.add(Separador1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 65, 76, 3));

        LabelTitulo1.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        LabelTitulo1.setForeground(new java.awt.Color(17, 35, 46));
        LabelTitulo1.setText("NUEVO");
        PanelContenedor1.add(LabelTitulo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 70, -1, -1));

        jPanel12.add(PanelContenedor1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 100, 98));

        PanelContenedor.setImagen(new javax.swing.ImageIcon(getClass().getResource("/Recursos/CONTENEDOR2.png"))); // NOI18N
        PanelContenedor.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnModificar.setBackground(new java.awt.Color(255, 102, 0));
        btnModificar.setBackgroundHover(new java.awt.Color(255, 255, 255));
        btnModificar.setForegroundHover(new java.awt.Color(255, 102, 0));
        btnModificar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EDIT);
        btnModificar.setRippleColor(java.awt.Color.white);
        btnModificar.setTypeBorder(RSMaterialComponent.RSButtonIconUno.TYPEBORDER.CIRCLE);
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        PanelContenedor.add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 15, 45, 45));

        Separador.setForeground(new java.awt.Color(204, 204, 204));
        PanelContenedor.add(Separador, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 65, 76, 3));

        LabelTitulo.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        LabelTitulo.setForeground(new java.awt.Color(17, 35, 46));
        LabelTitulo.setText("MODIFICAR");
        PanelContenedor.add(LabelTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 70, -1, -1));

        jPanel12.add(PanelContenedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 0, 100, 98));

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/fondo_2.5.png"))); // NOI18N
        jPanel12.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(-130, -10, 690, 120));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)), "Información del Artículo", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Roboto", 1, 11), new java.awt.Color(17, 35, 46))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtCodProducto.setEditable(false);
        txtCodProducto.setBackground(new java.awt.Color(255, 255, 255));
        txtCodProducto.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        txtCodProducto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel1.add(txtCodProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, 136, 23));

        txtCodBarra.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        txtCodBarra.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtCodBarra.setNextFocusableComponent(txtDescripcion);
        txtCodBarra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodBarraActionPerformed(evt);
            }
        });
        txtCodBarra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodBarraKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodBarraKeyTyped(evt);
            }
        });
        jPanel1.add(txtCodBarra, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, 304, 23));

        jLabel2.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        jLabel2.setText("ID ARTICULO");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 30, -1, 20));

        jLabel3.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        jLabel3.setText("CÓDIGO DE BARRA");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 60, -1, 20));

        txtDescripcion.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        txtDescripcion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtDescripcion.setNextFocusableComponent(txtPrincipio);
        txtDescripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescripcionActionPerformed(evt);
            }
        });
        txtDescripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDescripcionKeyTyped(evt);
            }
        });
        jPanel1.add(txtDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 90, 304, 23));

        jLabel7.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        jLabel7.setText("NOMBRE COMERCIAL");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 90, -1, 20));

        jLabel8.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        jLabel8.setText("PRINCIPIO ACTIVO");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 130, -1, 23));

        jScrollPane4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jScrollPane4.setHorizontalScrollBar(null);

        txtPrincipio.setColumns(20);
        txtPrincipio.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        txtPrincipio.setRows(2);
        txtPrincipio.setAutoscrolls(false);
        txtPrincipio.setBorder(null);
        txtPrincipio.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txtPrincipio.setNextFocusableComponent(txtAccion);
        txtPrincipio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPrincipioKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrincipioKeyTyped(evt);
            }
        });
        jScrollPane4.setViewportView(txtPrincipio);

        jPanel1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, 304, 46));

        jLabel9.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        jLabel9.setText("ACCIÓN TERAPEÚTICA");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 180, -1, 23));

        jScrollPane3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        txtAccion.setColumns(20);
        txtAccion.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        txtAccion.setRows(2);
        txtAccion.setAutoscrolls(false);
        txtAccion.setBorder(null);
        txtAccion.setNextFocusableComponent(cbLaboratorio);
        txtAccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtAccionKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAccionKeyTyped(evt);
            }
        });
        jScrollPane3.setViewportView(txtAccion);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 170, 304, 50));

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buttonGroup2.add(rImportado);
        rImportado.setForeground(new java.awt.Color(0, 0, 0));
        rImportado.setText("Importado");
        rImportado.setColorCheck(new java.awt.Color(255, 102, 0));
        rImportado.setColorUnCheck(new java.awt.Color(51, 51, 51));
        rImportado.setFocusPainted(false);
        rImportado.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        rImportado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rImportadoActionPerformed(evt);
            }
        });
        jPanel8.add(rImportado, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 28, 92, 23));

        buttonGroup2.add(rNacional);
        rNacional.setForeground(new java.awt.Color(0, 0, 0));
        rNacional.setText("Nacional");
        rNacional.setColorCheck(new java.awt.Color(255, 102, 0));
        rNacional.setColorUnCheck(new java.awt.Color(51, 51, 51));
        rNacional.setFocusPainted(false);
        rNacional.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        rNacional.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rNacionalActionPerformed(evt);
            }
        });
        jPanel8.add(rNacional, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 7, 92, 23));

        jPanel1.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(585, 40, 115, 56));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buttonGroup1.add(rLibre);
        rLibre.setForeground(new java.awt.Color(0, 0, 0));
        rLibre.setText("Venta Libre");
        rLibre.setColorCheck(new java.awt.Color(255, 102, 0));
        rLibre.setColorUnCheck(new java.awt.Color(51, 51, 51));
        rLibre.setFocusPainted(false);
        rLibre.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        rLibre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rLibreActionPerformed(evt);
            }
        });
        jPanel5.add(rLibre, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 7, 97, 23));

        buttonGroup1.add(rControlado);
        rControlado.setForeground(new java.awt.Color(0, 0, 0));
        rControlado.setText("Controlado");
        rControlado.setColorCheck(new java.awt.Color(255, 102, 0));
        rControlado.setColorUnCheck(new java.awt.Color(51, 51, 51));
        rControlado.setFocusPainted(false);
        rControlado.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        rControlado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rControladoActionPerformed(evt);
            }
        });
        jPanel5.add(rControlado, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 28, 97, 23));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 40, 120, 56));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        jLabel5.setText("LABORATORIO");
        jPanel7.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 13, 80, 25));

        jLabel4.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        jLabel4.setText("PROVEEDOR");
        jPanel7.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 41, 80, 25));

        jLabel6.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        jLabel6.setText("FAMILIA");
        jPanel7.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 69, 70, 25));

        btnFamilia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/document15.png"))); // NOI18N
        btnFamilia.setToolTipText("Gestionar Familia");
        btnFamilia.setBorderPainted(false);
        btnFamilia.setContentAreaFilled(false);
        btnFamilia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFamiliaActionPerformed(evt);
            }
        });
        jPanel7.add(btnFamilia, new org.netbeans.lib.awtextra.AbsoluteConstraints(361, 69, 25, 25));

        btnProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/document15.png"))); // NOI18N
        btnProveedor.setToolTipText("Gestionar Proveedor");
        btnProveedor.setBorderPainted(false);
        btnProveedor.setContentAreaFilled(false);
        btnProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProveedorActionPerformed(evt);
            }
        });
        jPanel7.add(btnProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(361, 41, 25, 25));

        btnLaboratorio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/document15.png"))); // NOI18N
        btnLaboratorio.setToolTipText("Gestionar Laboratorio");
        btnLaboratorio.setBorderPainted(false);
        btnLaboratorio.setContentAreaFilled(false);
        btnLaboratorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLaboratorioActionPerformed(evt);
            }
        });
        jPanel7.add(btnLaboratorio, new org.netbeans.lib.awtextra.AbsoluteConstraints(361, 13, 25, 25));

        lbGan.setFont(new java.awt.Font("Roboto", 1, 9)); // NOI18N
        lbGan.setForeground(new java.awt.Color(0, 153, 204));
        lbGan.setText("Ganancia Sugerida:");
        jPanel7.add(lbGan, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 97, 123, -1));

        lbIVA.setFont(new java.awt.Font("Roboto", 1, 9)); // NOI18N
        lbIVA.setForeground(new java.awt.Color(0, 153, 204));
        lbIVA.setText("I.V.A Sugerido:");
        jPanel7.add(lbIVA, new org.netbeans.lib.awtextra.AbsoluteConstraints(229, 97, 103, -1));

        cbLaboratorio.setForeground(new java.awt.Color(0, 0, 0));
        cbLaboratorio.setColorArrow(new java.awt.Color(17, 35, 46));
        cbLaboratorio.setColorBorde(new java.awt.Color(204, 204, 204));
        cbLaboratorio.setColorDisabledIndexText(new java.awt.Color(255, 255, 255));
        cbLaboratorio.setColorFondo(new java.awt.Color(255, 255, 255));
        cbLaboratorio.setColorSeleccion(new java.awt.Color(0, 153, 204));
        cbLaboratorio.setConBorde(true);
        cbLaboratorio.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        cbLaboratorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbLaboratorioActionPerformed(evt);
            }
        });
        cbLaboratorio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbLaboratorioKeyPressed(evt);
            }
        });
        jPanel7.add(cbLaboratorio, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 13, 256, 25));

        cbProveedor.setForeground(new java.awt.Color(0, 0, 0));
        cbProveedor.setColorArrow(new java.awt.Color(17, 35, 46));
        cbProveedor.setColorBorde(new java.awt.Color(204, 204, 204));
        cbProveedor.setColorDisabledIndexText(new java.awt.Color(255, 255, 255));
        cbProveedor.setColorFondo(new java.awt.Color(255, 255, 255));
        cbProveedor.setColorSeleccion(new java.awt.Color(0, 153, 204));
        cbProveedor.setConBorde(true);
        cbProveedor.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        cbProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbProveedorActionPerformed(evt);
            }
        });
        cbProveedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbProveedorKeyPressed(evt);
            }
        });
        jPanel7.add(cbProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 41, 256, 25));

        cbFamilia.setForeground(new java.awt.Color(0, 0, 0));
        cbFamilia.setColorArrow(new java.awt.Color(17, 35, 46));
        cbFamilia.setColorBorde(new java.awt.Color(204, 204, 204));
        cbFamilia.setColorDisabledIndexText(new java.awt.Color(255, 255, 255));
        cbFamilia.setColorFondo(new java.awt.Color(255, 255, 255));
        cbFamilia.setColorSeleccion(new java.awt.Color(0, 153, 204));
        cbFamilia.setConBorde(true);
        cbFamilia.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        cbFamilia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbFamiliaActionPerformed(evt);
            }
        });
        cbFamilia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbFamiliaKeyPressed(evt);
            }
        });
        jPanel7.add(cbFamilia, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 69, 256, 25));

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 100, 395, 120));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buttonGroup3.add(rActivo);
        rActivo.setForeground(new java.awt.Color(0, 0, 0));
        rActivo.setText("Articulo Activo");
        rActivo.setColorCheck(new java.awt.Color(255, 102, 0));
        rActivo.setColorUnCheck(new java.awt.Color(51, 51, 51));
        rActivo.setFocusPainted(false);
        rActivo.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        rActivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rActivoActionPerformed(evt);
            }
        });
        jPanel4.add(rActivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 7, 124, 23));

        buttonGroup3.add(rInactivo);
        rInactivo.setForeground(new java.awt.Color(0, 0, 0));
        rInactivo.setText("Articulo Inactivo");
        rInactivo.setColorCheck(new java.awt.Color(255, 102, 0));
        rInactivo.setColorUnCheck(new java.awt.Color(51, 51, 51));
        rInactivo.setFocusPainted(false);
        rInactivo.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        rInactivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rInactivoActionPerformed(evt);
            }
        });
        jPanel4.add(rInactivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 28, 124, 23));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(705, 40, 150, 56));

        jPanel12.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 110, 870, 231));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)), "Margen de Utilidad - IVA - Stock", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Roboto", 1, 11), new java.awt.Color(17, 35, 46))); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel18.setFont(new java.awt.Font("Roboto", 1, 15)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(51, 51, 51));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("% Desc.");
        jLabel18.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel3.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(207, 59, 60, 28));

        txtDesc.setFont(new java.awt.Font("Roboto", 1, 15)); // NOI18N
        txtDesc.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDesc.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtDesc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtDescMouseClicked(evt);
            }
        });
        txtDesc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescActionPerformed(evt);
            }
        });
        txtDesc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDescKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDescKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDescKeyTyped(evt);
            }
        });
        jPanel3.add(txtDesc, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 59, 70, 28));

        jLabel19.setFont(new java.awt.Font("Roboto", 1, 15)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(51, 51, 51));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Precio Venta");
        jLabel19.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel3.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 102, 105, 28));

        txtPrecioVenta.setFont(new java.awt.Font("Roboto", 1, 15)); // NOI18N
        txtPrecioVenta.setForeground(new java.awt.Color(0, 102, 0));
        txtPrecioVenta.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPrecioVenta.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtPrecioVenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtPrecioVentaMouseClicked(evt);
            }
        });
        txtPrecioVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioVentaActionPerformed(evt);
            }
        });
        txtPrecioVenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPrecioVentaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPrecioVentaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecioVentaKeyTyped(evt);
            }
        });
        jPanel3.add(txtPrecioVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 102, 90, 28));

        jLabel10.setFont(new java.awt.Font("Roboto", 1, 15)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 51, 51));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Precio Costo");
        jLabel10.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 15, 105, 28));

        txtCosto.setFont(new java.awt.Font("Roboto", 1, 15)); // NOI18N
        txtCosto.setForeground(new java.awt.Color(205, 0, 0));
        txtCosto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCosto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtCosto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtCostoMouseClicked(evt);
            }
        });
        txtCosto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCostoActionPerformed(evt);
            }
        });
        txtCosto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCostoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCostoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCostoKeyTyped(evt);
            }
        });
        jPanel3.add(txtCosto, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 15, 90, 28));

        jLabel16.setFont(new java.awt.Font("Roboto", 1, 15)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(51, 51, 51));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("% Lucro");
        jLabel16.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel3.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(207, 102, 60, 28));

        txtGanancia.setFont(new java.awt.Font("Roboto", 1, 15)); // NOI18N
        txtGanancia.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtGanancia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtGanancia.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtGananciaFocusLost(evt);
            }
        });
        txtGanancia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtGananciaMouseClicked(evt);
            }
        });
        txtGanancia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGananciaActionPerformed(evt);
            }
        });
        txtGanancia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtGananciaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtGananciaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtGananciaKeyTyped(evt);
            }
        });
        jPanel3.add(txtGanancia, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 102, 70, 28));

        jLabel17.setFont(new java.awt.Font("Roboto", 1, 15)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(51, 51, 51));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Precio Publico");
        jLabel17.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel3.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 59, 105, 28));

        txtPrecioPublico.setFont(new java.awt.Font("Roboto", 1, 15)); // NOI18N
        txtPrecioPublico.setForeground(new java.awt.Color(0, 102, 255));
        txtPrecioPublico.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPrecioPublico.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtPrecioPublico.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtPrecioPublicoMouseClicked(evt);
            }
        });
        txtPrecioPublico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioPublicoActionPerformed(evt);
            }
        });
        txtPrecioPublico.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPrecioPublicoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPrecioPublicoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecioPublicoKeyTyped(evt);
            }
        });
        jPanel3.add(txtPrecioPublico, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 59, 90, 28));

        jSeparator2.setForeground(new java.awt.Color(204, 204, 204));
        jPanel3.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 50, 336, -1));

        jSeparator3.setForeground(new java.awt.Color(204, 204, 204));
        jPanel3.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 94, 336, -1));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 27, 350, 145));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel13.setText("Stock");
        jPanel6.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 8, 80, 23));

        txtStock.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        txtStock.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtStock.setText("0");
        txtStock.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStockActionPerformed(evt);
            }
        });
        txtStock.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtStockKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtStockKeyTyped(evt);
            }
        });
        jPanel6.add(txtStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(123, 8, 80, 23));

        jLabel14.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel14.setText("Stock Mínimo");
        jPanel6.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 38, 80, 23));

        txtStockMin.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtStockMin.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtStockMin.setText("0");
        txtStockMin.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtStockMin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtStockMinMouseClicked(evt);
            }
        });
        txtStockMin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStockMinActionPerformed(evt);
            }
        });
        txtStockMin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtStockMinKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtStockMinKeyTyped(evt);
            }
        });
        jPanel6.add(txtStockMin, new org.netbeans.lib.awtextra.AbsoluteConstraints(123, 38, 80, 23));

        jPanel2.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(621, 102, 238, 70));

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        jLabel11.setText("I.V.A. Grabada");
        jPanel9.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 13, -1, -1));

        jLabel12.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        jLabel12.setText("Costo I.V.A.");
        jPanel9.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 42, -1, -1));

        txtIVACosto.setEditable(false);
        txtIVACosto.setBackground(new java.awt.Color(255, 255, 255));
        txtIVACosto.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        txtIVACosto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtIVACosto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel9.add(txtIVACosto, new org.netbeans.lib.awtextra.AbsoluteConstraints(122, 38, 98, 23));

        cbImpuesto.setForeground(new java.awt.Color(0, 0, 0));
        cbImpuesto.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SELECCION", "EXENTA", "5%", "10%" }));
        cbImpuesto.setColorArrow(new java.awt.Color(17, 35, 46));
        cbImpuesto.setColorBorde(new java.awt.Color(204, 204, 204));
        cbImpuesto.setColorDisabledIndexText(new java.awt.Color(255, 255, 255));
        cbImpuesto.setColorFondo(new java.awt.Color(255, 255, 255));
        cbImpuesto.setColorSeleccion(new java.awt.Color(0, 153, 204));
        cbImpuesto.setConBorde(true);
        cbImpuesto.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        cbImpuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbImpuestoActionPerformed(evt);
            }
        });
        cbImpuesto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbImpuestoKeyPressed(evt);
            }
        });
        jPanel9.add(cbImpuesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(122, 8, 98, 23));

        jPanel2.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(621, 27, 238, 70));

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204))));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtPrecioVentaM.setFont(new java.awt.Font("Roboto", 1, 15)); // NOI18N
        txtPrecioVentaM.setForeground(new java.awt.Color(255, 102, 0));
        txtPrecioVentaM.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPrecioVentaM.setText("0");
        txtPrecioVentaM.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtPrecioVentaM.setEnabled(false);
        txtPrecioVentaM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtPrecioVentaMMouseClicked(evt);
            }
        });
        txtPrecioVentaM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioVentaMActionPerformed(evt);
            }
        });
        txtPrecioVentaM.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPrecioVentaMKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPrecioVentaMKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecioVentaMKeyTyped(evt);
            }
        });
        jPanel11.add(txtPrecioVentaM, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 100, 130, 28));

        jLabel21.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 153, 204));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("Cant.");
        jPanel11.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 70, -1));

        jLabel22.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 153, 204));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("Precio Mayorista");
        jPanel11.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 80, 130, -1));

        txtCantM.setFont(new java.awt.Font("Roboto", 1, 15)); // NOI18N
        txtCantM.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCantM.setText("2");
        txtCantM.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtCantM.setEnabled(false);
        txtCantM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtCantMMouseClicked(evt);
            }
        });
        txtCantM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantMActionPerformed(evt);
            }
        });
        txtCantM.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCantMKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCantMKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantMKeyTyped(evt);
            }
        });
        jPanel11.add(txtCantM, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 70, 28));

        txtPrecioVentaML.setEditable(false);
        txtPrecioVentaML.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        txtPrecioVentaML.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPrecioVentaML.setText("0");
        jPanel11.add(txtPrecioVentaML, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, 43, -1));

        jSeparator1.setForeground(new java.awt.Color(204, 204, 204));
        jPanel11.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 230, -1));

        ckHabilitar.setForeground(new java.awt.Color(0, 0, 0));
        ckHabilitar.setText("Aplicar precio mayorista a partir de:");
        ckHabilitar.setColorCheck(new java.awt.Color(255, 102, 0));
        ckHabilitar.setColorUnCheck(new java.awt.Color(51, 51, 51));
        ckHabilitar.setFocusPainted(false);
        ckHabilitar.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        ckHabilitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ckHabilitarActionPerformed(evt);
            }
        });
        ckHabilitar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ckHabilitarKeyPressed(evt);
            }
        });
        jPanel11.add(ckHabilitar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 45, 230, 23));

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 204));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("MAYORISTA");
        jPanel11.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 5, 230, 30));

        jPanel2.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(366, 27, 250, 145));

        jPanel12.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 340, 870, 183));
        jPanel2.getAccessibleContext().setAccessibleName("");

        jPanel12.add(txtCodLab, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 50, 44, -1));
        jPanel12.add(txtCodPro, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 50, 44, -1));
        jPanel12.add(txtCodFam, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 50, 44, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 880, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 532, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFamiliaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFamiliaActionPerformed
        // TODO add your handling code here:
        dlgFamilia fa = new dlgFamilia(null, true);
        fa.setLocationRelativeTo(null);
        fa.setVisible(true);
    }//GEN-LAST:event_btnFamiliaActionPerformed

    private void btnLaboratorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLaboratorioActionPerformed
        // TODO add your handling code here:
        dlgLaboratorio la = new dlgLaboratorio(null, true);
        la.setLocationRelativeTo(null);
        la.setVisible(true);
    }//GEN-LAST:event_btnLaboratorioActionPerformed

    private void btnProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProveedorActionPerformed
        // TODO add your handling code here:
        dlgProveedores pro = new dlgProveedores(null, true);
        pro.setSize(1230, 570);
        pro.setLocationRelativeTo(null);
        pro.setVisible(true);
    }//GEN-LAST:event_btnProveedorActionPerformed

    private void txtPrecioVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioVentaActionPerformed
        // TODO add your handling code here:
        if (!txtPrecioVenta.getText().trim().isEmpty() || Integer.parseInt(txtPrecioVenta.getText()) != 0) {
            CalcularDescuento();
            CalcularGanancia();
            ckHabilitar.requestFocus();
        }

    }//GEN-LAST:event_txtPrecioVentaActionPerformed

    private void txtPrecioPublicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioPublicoActionPerformed
        // TODO add your handling code here:
        if (!txtPrecioPublico.getText().trim().isEmpty() || Integer.parseInt(txtPrecioPublico.getText()) != 0) {
            CalcularDescuento();
            txtPrecioVenta.requestFocus();
            txtPrecioVenta.selectAll();
        } else {
            txtDesc.setText("0");
        }

    }//GEN-LAST:event_txtPrecioPublicoActionPerformed

    private void txtGananciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGananciaActionPerformed
        // TODO add your handling code here:
        if (!txtCosto.getText().replace(".", "").replace(",", "").isEmpty() && !txtGanancia.getText().trim().isEmpty()) {
            int band = CalcularPrecioVentaxGan();
            if (band == 1) {
                CalcularDescuento();
            }
        }
        ckHabilitar.requestFocus();
    }//GEN-LAST:event_txtGananciaActionPerformed

    private void txtGananciaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGananciaKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGananciaKeyReleased

    private void txtPrecioPublicoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioPublicoKeyReleased
        // TODO add your handling code here:
        try {
            if (txtPrecioPublico.getText().trim().length() >= 1) {
                DecimalFormat df = new DecimalFormat("#,###");
                txtPrecioPublico.setText(df.format(Integer.valueOf(txtPrecioPublico.getText().trim().replace(".", "").replace(",", ""))));
            }
        } catch (NumberFormatException e) {
            System.out.println("c: " + e.getMessage());
        }
    }//GEN-LAST:event_txtPrecioPublicoKeyReleased

    private void txtCostoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCostoKeyReleased
        // TODO add your handling code here:
        try {
            if (txtCosto.getText().trim().length() >= 1) {
                DecimalFormat df = new DecimalFormat("#,###");
                txtCosto.setText(df.format(Integer.valueOf(txtCosto.getText().trim().replace(".", "").replace(",", ""))));
            }
            cbImpuestoActionPerformed(null);
        } catch (NumberFormatException e) {
            System.out.println("c: " + e.getMessage());
        }

    }//GEN-LAST:event_txtCostoKeyReleased

    private void txtDescKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescKeyReleased
        // TODO add your handling code here:
        try {
            if (Integer.parseInt(txtDesc.getText()) < 0) {
                txtDesc.setText("0");
                if (txtDesc.getText().trim().length() == 0) {
                    txtDesc.setText("0");
                }
            }
        } catch (NumberFormatException e) {
        }


    }//GEN-LAST:event_txtDescKeyReleased

    private void txtPrecioVentaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioVentaKeyReleased
        // TODO add your handling code here:
        try {
            if (txtPrecioVenta.getText().trim().length() >= 1) {
                DecimalFormat df = new DecimalFormat("#,###");
                txtPrecioVenta.setText(df.format(Integer.valueOf(txtPrecioVenta.getText().trim().replace(".", "").replace(",", ""))));
            } else {
                txtPrecioVenta.setText("0");
            }
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_txtPrecioVentaKeyReleased

    private void txtPrecioPublicoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioPublicoKeyTyped
        // TODO add your handling code here:

        int limite = 10;
        /*char c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            getToolkit().beep();

            evt.consume();

            System.out.println("Ingresa Solo Numeros");
        }*/
        if (txtPrecioPublico.getText().length() == limite) {
            evt.consume();
        }
    }//GEN-LAST:event_txtPrecioPublicoKeyTyped

    private void txtCostoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCostoKeyTyped
        // TODO add your handling code here:
        int limite = 10;
        if (txtCosto.getText().length() == limite) {
            evt.consume();
        }
    }//GEN-LAST:event_txtCostoKeyTyped

    private void txtCostoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCostoActionPerformed
        // TODO add your handling code here:  
        if (!txtCosto.getText().trim().isEmpty() || Integer.parseInt(txtCosto.getText()) != 0) {
            CalcularGanancia();
            txtPrecioPublico.requestFocus();
            txtPrecioPublico.selectAll();
        } else {
            txtGanancia.setText("0");
        }

    }//GEN-LAST:event_txtCostoActionPerformed

    private void txtGananciaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtGananciaFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGananciaFocusLost

    private void txtDescActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescActionPerformed
        // TODO add your handling code here:
        if (txtPrecioPublico.getText().replace(".", "").replace(",", "").equals("0")) {
            txtDesc.setText("0");
            txtPrecioVenta.requestFocus();
        } else {
            int band = CalcularPrecioVentaxDesc();
            if (band == 1) {
                CalcularDescuento();
                CalcularGanancia();
            }
        }
        txtGanancia.requestFocus();
        txtGanancia.selectAll();
    }//GEN-LAST:event_txtDescActionPerformed

    private void txtDescripcionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescripcionKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isLowerCase(c)) {
            String cad = ("" + c).toUpperCase();
            c = cad.charAt(0);
            evt.setKeyChar(c);
        }
    }//GEN-LAST:event_txtDescripcionKeyTyped

    private void txtPrincipioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrincipioKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isLowerCase(c)) {
            String cad = ("" + c).toUpperCase();
            c = cad.charAt(0);
            evt.setKeyChar(c);
        }
    }//GEN-LAST:event_txtPrincipioKeyTyped

    private void txtAccionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAccionKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isLowerCase(c)) {
            String cad = ("" + c).toUpperCase();
            c = cad.charAt(0);
            evt.setKeyChar(c);
        }
    }//GEN-LAST:event_txtAccionKeyTyped

    private void txtCodBarraKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodBarraKeyPressed
        // TODO add your handling code here:
        /* if (!txtCodBarra.getText().trim().isEmpty()) {
            validarCampos.soloNumeros(txtCodBarra);
        }*/

    }//GEN-LAST:event_txtCodBarraKeyPressed

    private void txtGananciaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGananciaKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        int limite = 5;
        if (Character.isLetter(c)) {
            getToolkit().beep();

            evt.consume();

            System.out.println("Ingresa Solo Numeros");
        }
        if (txtGanancia.getText().length() == limite) {
            evt.consume();
        }
    }//GEN-LAST:event_txtGananciaKeyTyped

    private void txtDescKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescKeyTyped
        // TODO add your handling code here:
        //char c = evt.getKeyChar();
        int limite = 5;
        /*if (Character.isLetter(c)) {
            getToolkit().beep();

            evt.consume();

            System.out.println("Ingresa Solo Numeros");
        }*/
        if (txtDesc.getText().length() == limite) {
            evt.consume();
        }
    }//GEN-LAST:event_txtDescKeyTyped

    private void txtPrecioVentaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioVentaKeyTyped
        // TODO add your handling code here:

        int limite = 10;
        if (txtPrecioVenta.getText().length() == limite) {
            evt.consume();
        }
    }//GEN-LAST:event_txtPrecioVentaKeyTyped

    private void txtStockKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtStockKeyTyped
        // TODO add your handling code here:
        //char c = evt.getKeyChar();
        int limite = 5;
        if (txtStock.getText().length() == limite) {
            evt.consume();
        }
    }//GEN-LAST:event_txtStockKeyTyped

    private void txtStockMinKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtStockMinKeyTyped
        // TODO add your handling code here:
        // char c = evt.getKeyChar();
        int limite = 5;
        /*if (Character.isLetter(c)) {
            getToolkit().beep();

            evt.consume();

            System.out.println("Ingresa Solo Numeros");
        }*/
        if (txtStockMin.getText().length() == limite) {
            evt.consume();
        }
    }//GEN-LAST:event_txtStockMinKeyTyped

    private void txtPrecioVentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPrecioVentaMouseClicked
        // TODO add your handling code here:
        txtPrecioVenta.selectAll();
    }//GEN-LAST:event_txtPrecioVentaMouseClicked

    private void txtCostoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCostoMouseClicked
        // TODO add your handling code here:
        txtCosto.selectAll();
    }//GEN-LAST:event_txtCostoMouseClicked

    private void txtPrecioPublicoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPrecioPublicoMouseClicked
        // TODO add your handling code here:
        txtPrecioPublico.selectAll();
    }//GEN-LAST:event_txtPrecioPublicoMouseClicked

    private void txtCodBarraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodBarraActionPerformed
        // TODO add your handling code here:
        txtDescripcion.requestFocus();
    }//GEN-LAST:event_txtCodBarraActionPerformed

    private void txtDescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescripcionActionPerformed
        // TODO add your handling code here:
        txtPrincipio.requestFocus();
    }//GEN-LAST:event_txtDescripcionActionPerformed

    private void txtPrincipioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrincipioKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtAccion.requestFocus();
        }
    }//GEN-LAST:event_txtPrincipioKeyPressed

    private void txtAccionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAccionKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            cbLaboratorio.requestFocus();
            cbLaboratorio.setPopupVisible(true);
        }
    }//GEN-LAST:event_txtAccionKeyPressed

    private void txtDescKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescKeyPressed
        // TODO add your handling code here:
        if (!txtDesc.getText().trim().isEmpty()) {
            validarCampos.soloDecimales(txtDesc);
        }
    }//GEN-LAST:event_txtDescKeyPressed

    private void txtPrecioVentaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioVentaKeyPressed
        // TODO add your handling code here:
        if (!txtPrecioVenta.getText().trim().isEmpty()) {
            validarCampos.soloNumeros(txtPrecioVenta);
        }
    }//GEN-LAST:event_txtPrecioVentaKeyPressed

    private void txtCostoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCostoKeyPressed
        // TODO add your handling code here:
        if (!txtCosto.getText().trim().isEmpty()) {
            validarCampos.soloNumeros(txtCosto);
        }
    }//GEN-LAST:event_txtCostoKeyPressed

    private void txtPrecioPublicoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioPublicoKeyPressed
        // TODO add your handling code here:
        if (!txtPrecioPublico.getText().trim().isEmpty()) {
            validarCampos.soloNumeros(txtPrecioPublico);
        }

    }//GEN-LAST:event_txtPrecioPublicoKeyPressed

    private void txtDescMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtDescMouseClicked
        // TODO add your handling code here:
        txtDesc.selectAll();
    }//GEN-LAST:event_txtDescMouseClicked

    private void txtStockKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtStockKeyPressed
        // TODO add your handling code here:
        validarCampos.soloNumeros(txtStock);
    }//GEN-LAST:event_txtStockKeyPressed

    private void txtStockMinKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtStockMinKeyPressed
        // TODO add your handling code here:
        validarCampos.soloNumeros(txtStock);
    }//GEN-LAST:event_txtStockMinKeyPressed

    private void txtStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStockActionPerformed
        // TODO add your handling code here:
        if (txtStock.getText().isEmpty()) {
            txtStock.setText("0");
            txtStock.selectAll();
        } else {
            txtStockMin.requestFocus();
            txtStockMin.selectAll();
        }

    }//GEN-LAST:event_txtStockActionPerformed

    private void txtStockMinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStockMinActionPerformed
        // TODO add your handling code here:
        if (txtStockMin.getText().isEmpty()) {
            txtStockMin.setText("0");
            txtStockMin.selectAll();
        } else if (txtStockMin.getText().equals("0")) {
            txtStockMin.selectAll();
        } else {
            if (!btnGuardar.isEnabled()) {
                btnModificar.doClick();
            } else {
                btnGuardar.doClick();
            }

        }
    }//GEN-LAST:event_txtStockMinActionPerformed

    private void txtStockMinMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtStockMinMouseClicked
        // TODO add your handling code here:
        txtStockMin.selectAll();
    }//GEN-LAST:event_txtStockMinMouseClicked

    private void txtGananciaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtGananciaMouseClicked
        // TODO add your handling code here:
        txtGanancia.selectAll();
    }//GEN-LAST:event_txtGananciaMouseClicked

    private void txtGananciaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGananciaKeyPressed
        // TODO add your handling code here:
        if (!txtGanancia.getText().trim().isEmpty()) {
            validarCampos.soloDecimales(txtGanancia);
        }
    }//GEN-LAST:event_txtGananciaKeyPressed

    private void formWindowLostFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowLostFocus
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowLostFocus

    private void txtPrecioVentaMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPrecioVentaMMouseClicked
        // TODO add your handling code here:
        txtPrecioVenta.selectAll();
    }//GEN-LAST:event_txtPrecioVentaMMouseClicked

    private void txtPrecioVentaMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioVentaMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioVentaMActionPerformed

    private void txtPrecioVentaMKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioVentaMKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            cbImpuesto.setPopupVisible(true);
            cbImpuesto.requestFocus();
        }
    }//GEN-LAST:event_txtPrecioVentaMKeyPressed

    private void txtPrecioVentaMKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioVentaMKeyReleased
        // TODO add your handling code here:
        try {
            if (txtPrecioVentaM.getText().trim().length() >= 1) {
                DecimalFormat df = new DecimalFormat("#,###");
                txtPrecioVentaM.setText(df.format(Integer.valueOf(txtPrecioVentaM.getText().trim().replace(".", "").replace(",", ""))));
            } else {
                txtPrecioVentaM.setText("0");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        if (txtPrecioVentaM.getText().equals("")) {
            txtPrecioVentaM.setText("0");
        } else {
            DecimalFormat dff = new DecimalFormat("#0");
            txtPrecioVentaML.setText(dff.format(Integer.valueOf(txtPrecioVentaM.getText().trim().replace(".", "").replace(",", ""))));
        }
    }//GEN-LAST:event_txtPrecioVentaMKeyReleased

    private void txtPrecioVentaMKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioVentaMKeyTyped
        // TODO add your handling code here:
        int limite = 10;
        if (txtPrecioVentaM.getText().length() == limite) {
            evt.consume();
        }
    }//GEN-LAST:event_txtPrecioVentaMKeyTyped

    private void txtCantMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCantMMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantMMouseClicked

    private void txtCantMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantMActionPerformed
        // TODO add your handling code here:
        if (txtCantM.getText().isEmpty()) {
            txtCantM.setText("2");
            txtPrecioVentaM.requestFocus();
        } else if (Integer.parseInt(txtCantM.getText()) < 2) {
            Mensajes.informacion("Para aplicar Precio Mayorista se requiere una Cantidad mayor que 1");
            txtCantM.setText("2");
            txtPrecioVentaM.requestFocus();
        } else {
            txtPrecioVentaM.requestFocus();
        }
    }//GEN-LAST:event_txtCantMActionPerformed

    private void txtCantMKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantMKeyPressed
        // TODO add your handling code here:
        if (!txtCantM.getText().trim().isEmpty()) {
            validarCampos.soloNumeros(txtPrecioVenta);
        }
    }//GEN-LAST:event_txtCantMKeyPressed

    private void txtCantMKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantMKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantMKeyReleased

    private void txtCantMKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantMKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantMKeyTyped

    private void txtCodBarraKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodBarraKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isLowerCase(c)) {
            String cad = ("" + c).toUpperCase();
            c = cad.charAt(0);
            evt.setKeyChar(c);
        }
    }//GEN-LAST:event_txtCodBarraKeyTyped

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
        if (txtDescripcion.getText().isEmpty()) {
            Mensajes.Sistema("El Nombre comercial se encuentra vacío.\nPor favor, complete esta información para proceder con el registro.");
            txtDescripcion.requestFocus();
        } else if (cbLaboratorio.getSelectedIndex() == 0) {
            Mensajes.Sistema("No se ha especificado el laboratorio.\nPor favor, seleccione la opción correspondiente para proceder con el registro.");
            cbLaboratorio.setPopupVisible(true);
            cbLaboratorio.requestFocus();
        } else if (cbProveedor.getSelectedIndex() == 0) {
            Mensajes.Sistema("No se ha especificado el Proveedor.\nPor favor, seleccione la opción correspondiente para proceder con el registro.");
            cbProveedor.setPopupVisible(true);
            cbProveedor.requestFocus();
        } else if (cbFamilia.getSelectedIndex() == 0) {
            Mensajes.Sistema("No se ha especificado la Familia.\nPor favor, seleccione la opción correspondiente para proceder con el registro.");
            cbFamilia.setPopupVisible(true);
            cbFamilia.requestFocus();
        } else if (Double.parseDouble(txtGanancia.getText()) <= (double) 0) {
            Mensajes.Sistema("Ganancia vacía o fuera de rango.\nPor favor, verifique los números ingresados para proceder con el registro");
            txtPrecioVenta.requestFocus();
            txtPrecioVenta.selectAll();
        } else if (Double.parseDouble(txtDesc.getText()) <= (double) 0) {
            Mensajes.Sistema("Descuento vacío o fuera de rango.\nPor favor, verifique los números ingresados para proceder con el registro");
            txtPrecioPublico.requestFocus();
            txtPrecioPublico.selectAll();
        } else if (Integer.parseInt(txtPrecioPublico.getText().replace(".", "").replace(",", "")) <= Integer.parseInt(txtCosto.getText().replace(".", "").replace(",", ""))) {
            Mensajes.Sistema("El Precio Publico es MENOR o IGUAL al Precio Costo.\nPor favor, verifique los números ingresados para proceder con el registro");
            txtPrecioPublico.requestFocus();
            txtPrecioPublico.selectAll();
        } else if (Integer.parseInt(txtPrecioVenta.getText().replace(".", "").replace(",", "")) <= Integer.parseInt(txtCosto.getText().replace(".", "").replace(",", ""))) {
            Mensajes.Sistema("El Precio Venta es MENOR o IGUAL al Precio Costo.\nPor favor, verifique los números ingresados para proceder con el registro");
            txtPrecioVenta.requestFocus();
            txtPrecioVenta.selectAll();
        } else if (Integer.parseInt(txtPrecioPublico.getText().replace(".", "").replace(",", "")) <= Integer.parseInt(txtPrecioVenta.getText().replace(".", "").replace(",", ""))) {
            Mensajes.Sistema("El Precio Publico es MENOR o IGUAL al Precio Venta.\nPor favor, verifique los números ingresados para proceder con el registro");
            txtPrecioPublico.requestFocus();
            txtPrecioPublico.selectAll();
        } else if (ckHabilitar.isSelected() && txtCantM.getText().isEmpty()) {
            Mensajes.Sistema("No se ha especificado la cantidad con la cual se habilitara el Precio Mayorista.\nPor favor, complete esta información para proceder con el registro.");
            txtCantM.requestFocus();
            txtCantM.selectAll();
        } else if (ckHabilitar.isSelected() && Integer.parseInt(txtPrecioVentaM.getText().replace(".", "").replace(",", "")) > Integer.parseInt(txtPrecioVenta.getText().replace(".", "").replace(",", ""))) {
            Mensajes.Sistema("El Precio Mayorista es Mayor al Precio Venta.\nPor favor, verifique los números ingresados para proceder con el registro");
            txtPrecioVentaM.requestFocus();
            txtPrecioVentaM.selectAll();
        } else if (cbImpuesto.getSelectedIndex() == 0) {
            Mensajes.Sistema("No se ha especificado el Impuesto a aplicar.\nPor favor, seleccione la opción correspondiente para proceder con el registro.");
            cbImpuesto.setPopupVisible(true);
            cbImpuesto.requestFocus();
        } else {
            try {
                int resp = JOptionPane.showConfirmDialog(this, "¿Seguro que desea modificar este registro?", "Modificar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (resp == JOptionPane.YES_OPTION) {
                    controlArticulo.actArticulo();
                    Cancelar();
                }
            } catch (HeadlessException ee) {
                System.out.println(ee.getMessage());
            }
        }

    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
        CargarCombos();
        limpiarCampos();
        cbFamiliaActionPerformed(null);
        Habilitacion();
        pintarEstado();
        pintarVenta();
        pintarTipo();
        String cod = GestionarArticulos.getCodigo();
        txtCodProducto.setText(cod);
        txtCodBarra.requestFocus();
        btnSalir.setEnabled(false);
        txtCosto.setText("0");
        txtPrecioPublico.setText("0");
        txtDesc.setText("0");
        txtPrecioVenta.setText("0");
        txtGanancia.setText("0");
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        if (txtDescripcion.getText().isEmpty()) {
            Mensajes.Sistema("El Nombre comercial se encuentra vacío.\nPor favor, complete esta información para proceder con el registro.");
            txtDescripcion.requestFocus();
        } else if (cbLaboratorio.getSelectedIndex() == 0) {
            Mensajes.Sistema("No se ha especificado el laboratorio.\nPor favor, seleccione la opción correspondiente para proceder con el registro.");
            cbLaboratorio.setPopupVisible(true);
            cbLaboratorio.requestFocus();
        } else if (cbProveedor.getSelectedIndex() == 0) {
            Mensajes.Sistema("No se ha especificado el Proveedor.\nPor favor, seleccione la opción correspondiente para proceder con el registro.");
            cbProveedor.setPopupVisible(true);
            cbProveedor.requestFocus();
        } else if (cbFamilia.getSelectedIndex() == 0) {
            Mensajes.Sistema("No se ha especificado la Familia.\nPor favor, seleccione la opción correspondiente para proceder con el registro.");
            cbFamilia.setPopupVisible(true);
            cbFamilia.requestFocus();
        } else if (Double.parseDouble(txtGanancia.getText()) <= (double) 0) {
            Mensajes.Sistema("Ganancia vacía o fuera de rango.\nPor favor, verifique los números ingresados para proceder con el registro");
            txtPrecioVenta.requestFocus();
            txtPrecioVenta.selectAll();
        } else if (txtGanancia.getText().equals("-Infinity")) {
            Mensajes.Sistema("Ganancia vacía o fuera de rango.\nPor favor, verifique los números ingresados para proceder con el registro");
            txtPrecioVenta.requestFocus();
            txtPrecioVenta.selectAll();
        } else if (txtGanancia.getText().equals("NaN")) {
            Mensajes.Sistema("Ganancia vacía o fuera de rango.\nPor favor, verifique los números ingresados para proceder con el registro");
            txtPrecioVenta.requestFocus();
            txtPrecioVenta.selectAll();
        } else if (Double.parseDouble(txtDesc.getText()) <= (double) 0) {
            Mensajes.Sistema("Descuento vacío o fuera de rango.\nPor favor, verifique los números ingresados para proceder con el registro");
            txtPrecioPublico.requestFocus();
            txtPrecioPublico.selectAll();
        }else if (txtDesc.getText().equals("-Infinity")) {
            Mensajes.Sistema("Ganancia vacía o fuera de rango.\nPor favor, verifique los números ingresados para proceder con el registro");
            txtPrecioVenta.requestFocus();
            txtPrecioVenta.selectAll();
        } else if (txtDesc.getText().equals("NaN")) {
            Mensajes.Sistema("Ganancia vacía o fuera de rango.\nPor favor, verifique los números ingresados para proceder con el registro");
            txtPrecioVenta.requestFocus();
            txtPrecioVenta.selectAll();
        } else if (Integer.parseInt(txtPrecioPublico.getText().replace(".", "").replace(",", "")) <= Integer.parseInt(txtCosto.getText().replace(".", "").replace(",", ""))) {
            Mensajes.Sistema("El Precio Publico es MENOR o IGUAL al Precio Costo.\nPor favor, verifique los números ingresados para proceder con el registro");
            txtPrecioPublico.requestFocus();
            txtPrecioPublico.selectAll();
        } else if (Integer.parseInt(txtPrecioVenta.getText().replace(".", "").replace(",", "")) <= Integer.parseInt(txtCosto.getText().replace(".", "").replace(",", ""))) {
            Mensajes.Sistema("El Precio Venta es MENOR o IGUAL al Precio Costo.\nPor favor, verifique los números ingresados para proceder con el registro");
            txtPrecioVenta.requestFocus();
            txtPrecioVenta.selectAll();
        } else if (Integer.parseInt(txtPrecioPublico.getText().replace(".", "").replace(",", "")) <= Integer.parseInt(txtPrecioVenta.getText().replace(".", "").replace(",", ""))) {
            Mensajes.Sistema("El Precio Publico es MENOR o IGUAL al Precio Venta.\nPor favor, verifique los números ingresados para proceder con el registro");
            txtPrecioPublico.requestFocus();
            txtPrecioPublico.selectAll();
        } else if (ckHabilitar.isSelected() && txtCantM.getText().isEmpty()) {
            Mensajes.Sistema("No se ha especificado la cantidad con la cual se habilitara el Precio Mayorista.\nPor favor, complete esta información para proceder con el registro.");
            txtCantM.requestFocus();
            txtCantM.selectAll();
        } else if (ckHabilitar.isSelected() && Integer.parseInt(txtPrecioVentaM.getText().replace(".", "").replace(",", "")) > Integer.parseInt(txtPrecioVenta.getText().replace(".", "").replace(",", ""))) {
            Mensajes.Sistema("El Precio Mayorista es Mayor al Precio Venta.\nPor favor, verifique los números ingresados para proceder con el registro");
            txtPrecioVentaM.requestFocus();
            txtPrecioVentaM.selectAll();
        } else if (cbImpuesto.getSelectedIndex() == 0) {
            Mensajes.Sistema("No se ha especificado el Impuesto a aplicar.\nPor favor, seleccione la opción correspondiente para proceder con el registro.");
            cbImpuesto.setPopupVisible(true);
            cbImpuesto.requestFocus();
        } else {
            try {
                int resp = JOptionPane.showConfirmDialog(this, "¿Seguro que desea insertar el registro?", "Insertar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (resp == JOptionPane.YES_OPTION) {
                    String cod = GestionarArticulos.getCodigo();
                    txtCodProducto.setText(cod);
                    controlArticulo.addArticulo();
                    Cancelar();
                } else {
                    txtCodBarra.requestFocus();
                }
            } catch (Exception ee) {
                System.out.println(ee.getMessage());
            }
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        int rpta = Mensajes.confirmar("¿Seguro que desea Cancelar?");
        if (rpta == 0) {
            limpiarCampos();
            btnModificar.setEnabled(true);
            btnModificar.setEnabled(false);
            btnGuardar.setEnabled(false);
            btnCancelar.setEnabled(false);
            btnLaboratorio.setEnabled(false);
            btnProveedor.setEnabled(false);
            btnFamilia.setEnabled(false);
            txtCodBarra.setEnabled(false);
            txtDescripcion.setEnabled(false);
            txtPrincipio.setEnabled(false);
            txtAccion.setEnabled(false);
            rLibre.setEnabled(false);
            rControlado.setEnabled(false);
            rNacional.setEnabled(false);
            rImportado.setEnabled(false);
            rActivo.setEnabled(false);
            rInactivo.setEnabled(false);
            cbLaboratorio.setEnabled(false);
            cbFamilia.setEnabled(false);
            cbProveedor.setEnabled(false);
            txtCosto.setEnabled(false);
            txtPrecioPublico.setEnabled(false);
            txtGanancia.setEnabled(false);
            txtDesc.setEnabled(false);
            txtPrecioVenta.setEnabled(false);
            txtStock.setEnabled(false);
            txtStockMin.setEnabled(false);
            btnSalir.setEnabled(true);
            pintarEstado();
            pintarVenta();
            pintarTipo();
            Volver();
            this.dispose();
        } else {
            txtCodBarra.requestFocus();
        }
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        int rpta = Mensajes.confirmar("¿Seguro que desea salir del formulario?");
        if (rpta == 0) {
            Volver();
            this.dispose();
        } else {
            txtCodBarra.requestFocus();
        }
    }//GEN-LAST:event_btnSalirActionPerformed

    private void rInactivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rInactivoActionPerformed
        // TODO add your handling code here:
        pintarEstado();
    }//GEN-LAST:event_rInactivoActionPerformed

    private void rActivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rActivoActionPerformed
        // TODO add your handling code here:
        pintarEstado();
    }//GEN-LAST:event_rActivoActionPerformed

    private void rNacionalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rNacionalActionPerformed
        // TODO add your handling code here:
        pintarTipo();
    }//GEN-LAST:event_rNacionalActionPerformed

    private void rLibreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rLibreActionPerformed
        // TODO add your handling code here:
        pintarVenta();
    }//GEN-LAST:event_rLibreActionPerformed

    private void rImportadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rImportadoActionPerformed
        // TODO add your handling code here:
        pintarTipo();
    }//GEN-LAST:event_rImportadoActionPerformed

    private void rControladoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rControladoActionPerformed
        // TODO add your handling code here:
        pintarVenta();
    }//GEN-LAST:event_rControladoActionPerformed

    private void cbLaboratorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbLaboratorioActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_cbLaboratorioActionPerformed

    private void cbLaboratorioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbLaboratorioKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            cbProveedor.requestFocus();
            cbProveedor.setPopupVisible(true);
        }
        //AccesoRapido(evt.getKeyCode());
    }//GEN-LAST:event_cbLaboratorioKeyPressed

    private void cbProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbProveedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbProveedorActionPerformed

    private void cbProveedorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbProveedorKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            cbFamilia.requestFocus();
            cbFamilia.setPopupVisible(true);
        }
    }//GEN-LAST:event_cbProveedorKeyPressed

    private void cbFamiliaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbFamiliaActionPerformed
        // TODO add your handling code here:
        if (cbFamilia.getSelectedIndex() == 0) {
            txtGanancia.setText("");
            lbGan.setText("");
            lbIVA.setText("");
        } else {
            int id = 0;
            String sqlItem = "Select fam_codigo from familia where fam_nombre='" + String.valueOf(cbFamilia.getSelectedItem()) + "' and fam_indicador='S'";
            try (Connection cn = dss.getDataSource().getConnection(); Statement st = cn.createStatement(); ResultSet rs = st.executeQuery(sqlItem)) {
                rs.first();
                id = rs.getInt("fam_codigo");
                rs.close();
                st.close();
                cn.close();
            } catch (SQLException ex) {
                Mensajes.error("Error obteniendo ID familia:" + ex.getMessage());
            }
            String sql = "select fam_ganancia, fam_iva from familia where fam_codigo=" + id + " and fam_indicador='S'";
            try (Connection cn = dss.getDataSource().getConnection(); Statement st = cn.createStatement(); ResultSet rss = st.executeQuery(sql)) {
                rss.first();
                lbGan.setText(String.valueOf("Ganancia Sugerida: " + rss.getInt(1)));
                lbIVA.setText(String.valueOf("I.V.A Sugerido: " + rss.getString(2)));
                rss.close();
                st.close();
                cn.close();
            } catch (Exception e) {
                Mensajes.error("Error obteniendo info ganancia:" + e.getMessage());
            }
        }
    }//GEN-LAST:event_cbFamiliaActionPerformed

    private void cbFamiliaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbFamiliaKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtCosto.requestFocus();
        }
    }//GEN-LAST:event_cbFamiliaKeyPressed

    private void ckHabilitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ckHabilitarActionPerformed
        // TODO add your handling code here:
        if (ckHabilitar.isSelected()) {
            txtCantM.setEnabled(true);
            txtPrecioVentaM.setEnabled(true);
            txtCantM.requestFocus();
        } else {
            txtCantM.setEnabled(false);
            txtPrecioVentaM.setEnabled(false);
            //txtCantM.setText("2");
            //txtPrecioVentaM.setText("0");
            //txtPrecioVentaML.setText("0");
        }
    }//GEN-LAST:event_ckHabilitarActionPerformed

    private void ckHabilitarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ckHabilitarKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            cbImpuesto.setPopupVisible(true);
            cbImpuesto.requestFocus();
        }
    }//GEN-LAST:event_ckHabilitarKeyPressed

    private void cbImpuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbImpuestoActionPerformed
        // TODO add your handling code here:
        try {
            if (cbImpuesto.getSelectedIndex() == 0) {
                Mensajes.Sistema("No se ha especificado el Impuesto a aplicar.\nPor favor, seleccione la opción correspondiente para calcular el costo de iva.");
                cbImpuesto.setPopupVisible(true);
                cbImpuesto.requestFocus();
            } else {
                switch (cbImpuesto.getSelectedIndex()) {
                    case 1 ->
                        CalculoIVAC(0);
                    case 2 ->
                        CalculoIVAC(5);
                    case 3 ->
                        CalculoIVAC(10);
                    default -> {
                    }
                }
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_cbImpuestoActionPerformed

    private void cbImpuestoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbImpuestoKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!txtStock.isEnabled()) {
                txtStockMin.requestFocus();
                txtStockMin.selectAll();
            } else {
                txtStock.requestFocus();
                txtStock.selectAll();
            }
        }
    }//GEN-LAST:event_cbImpuestoKeyPressed

    public int CalcularPrecioVentaxGan() {
        int band = 0;
        try {
            if (!txtGanancia.getText().trim().isEmpty()) {
                double c = Double.parseDouble(txtCosto.getText().replace(".", "").replace(",", ""));
                double g = Double.parseDouble(txtGanancia.getText());
                double v = (double) c / (1 - (g / 100));
                DecimalFormat df = new DecimalFormat("#,###");
                txtPrecioVenta.setText(df.format(Redondeo.redondearD(v)));
                band = 1;
            }
        } catch (NumberFormatException e) {
            band = 0;
            System.out.println("Error Metodo CalcularPrecioVentaxGan: " + e.getMessage());
        }

        return band;
    }

    public int CalcularPrecioVentaxDesc() {
        int band = 0;
        try {
            double pp = Double.parseDouble(txtPrecioPublico.getText().replace(".", "").replace(",", ""));
            double d = Double.parseDouble(txtDesc.getText().trim());
            double v = (double) pp - (pp * (d / 100));
            DecimalFormat df = new DecimalFormat("#,###");
            txtPrecioVenta.setText(df.format((Redondeo.redondearD(v))));
            band = 1;
        } catch (NumberFormatException ee) {
            band = 0;
            System.out.println("Error Metodo CalcularPrecioVentaxDesc: " + ee.getMessage());
        }

        return band;
    }

    public void CalcularDescuento() {
        try {
            double pv = Double.parseDouble(txtPrecioVenta.getText().replace(".", "").replace(",", ""));
            double pp = Double.parseDouble(txtPrecioPublico.getText().replace(".", "").replace(",", ""));
            if (pp < pv) {
                Mensajes.informacion("PRECIO VENTA MAYOR A PRECIO PUBLICO");
            } else {
                double dif = (double) (pv / pp);
                double desc = Redondeo.redondearD((1 - dif) * 100);
                txtDesc.setText(String.valueOf(desc));
            }
        } catch (NumberFormatException e) {
        }
    }

    public static void CalculoIVAC(int iva) {
        try {
            int c = Integer.parseInt(txtCosto.getText().replace(".", "").replace(",", ""));
            double div = 0;
            double cosIVA;
            switch ((int) iva) {
                case 5 ->
                    div = 21;
                case 10 ->
                    div = 11;
                default -> {
                }
            }
            if (iva != 0) {
                cosIVA = (c / div);
                txtIVACosto.setText(String.valueOf(Redondeo.redondearD(cosIVA)));
            } else {
                txtIVACosto.setText("0.0");
            }
        } catch (NumberFormatException e) {
        }

    }

    public void CalcularGanancia() {
        try {
            double pv;
            double pc;
            double G;
            pv = Double.parseDouble(txtPrecioVenta.getText().replace(".", "").replace(",", ""));
            pc = Double.parseDouble(txtCosto.getText().replace(".", "").replace(",", ""));
            G = (double) (pc / pv);
            double ganancia = Redondeo.redondearD((1 - G) * 100);
            txtGanancia.setText(String.valueOf(ganancia));
        } catch (NumberFormatException e) {
        }
    }

    public void Nuevo() {
        btnNuevoActionPerformed(null);
    }

    public static void limpiarCampos() {
        txtDescripcion.setText("");
        txtCodBarra.setText("");
        txtPrincipio.setText("");
        txtAccion.setText("");
        txtCosto.setText("");
        txtPrecioPublico.setText("");
        txtGanancia.setText("");
        txtDesc.setText("");
        txtPrecioVenta.setText("");
        txtStock.setText("0");
        txtStockMin.setText("0");
        txtIVACosto.setText("");
        txtCodLab.setText("");
        txtCodFam.setText("");
        txtCodPro.setText("");
        cbLaboratorio.setSelectedIndex(0);
        cbProveedor.setSelectedIndex(0);
        cbFamilia.setSelectedIndex(0);
        rActivo.setSelected(true);
        rNacional.setSelected(true);
        rLibre.setSelected(true);
    }

    void Volver() {
        CabecerasTablas cabe = new CabecerasTablas();
        cabe.Articulos(dlgArticulos.tbProductos);
        CabecerasTablas.limpiarTablas(dlgArticulos.tbProductos);
        controlArticulo.listArticulo(dlgArticulos.tbProductos, "cod");
        dlgArticulos.Renders();
        dlgArticulos.txtBuscar.requestFocus();
        dlgArticulos.txtBuscar.setText("");
        dlgArticulos.tbProductos.clearSelection();
    }

    public void modcbLaboratorio() {
        DefaultComboBoxModel ml = new DefaultComboBoxModel();
        String sqlLabs = "SELECT * FROM laboratorio WHERE lab_indicador='S'";
        String sqlLabEsp = "SELECT * FROM laboratorio WHERE lab_codigo=" + txtCodLab.getText().trim();
        try (Connection cn = dss.getDataSource().getConnection(); Statement st = cn.createStatement(); ResultSet rs = st.executeQuery(sqlLabs); ResultSet rss = st.executeQuery(sqlLabEsp)) {
            ml.addElement("**OPCIONES**");
            while (rs.next()) {
                ml.addElement(rs.getString("lab_nombre"));
            }
            rss.first();
            Object descripcion = (Object) rss.getString("lab_nombre");
            dlgGestArticulos.cbLaboratorio.setModel(ml);
            dlgGestArticulos.cbLaboratorio.setSelectedItem(descripcion);
            rs.close();
            rss.close();
            st.close();
            cn.close();
        } catch (SQLException ew) {
            System.out.println("Error combomod laboratorio: " + ew.getMessage());
        }
    }

    public void modcbProveedor() {
        DefaultComboBoxModel pr = new DefaultComboBoxModel();
        String sqlProvs = "SELECT * FROM proveedor WHERE pro_indicador='S'";
        String sqlProvEsp = "SELECT * FROM proveedor WHERE pro_codigo=" + txtCodPro.getText().trim();
        try (Connection cn = dss.getDataSource().getConnection(); Statement st = cn.createStatement(); ResultSet rs = st.executeQuery(sqlProvs); ResultSet rss = st.executeQuery(sqlProvEsp)) {
            pr.addElement("**OPCIONES**");
            while (rs.next()) {
                pr.addElement(rs.getString("pro_razonsocial"));
            }
            rss.first();
            Object descripcion = (Object) rss.getString("pro_razonsocial");
            dlgGestArticulos.cbProveedor.setModel(pr);
            dlgGestArticulos.cbProveedor.setSelectedItem(descripcion);
            rs.close();
            rss.close();
            st.close();
            cn.close();
        } catch (SQLException ew) {
            System.out.println("Error combomod proveedor: " + ew.getMessage());
        }
    }

    public void modcbFamilia() {
        DefaultComboBoxModel fm = new DefaultComboBoxModel();
        String sqlFams = "SELECT * FROM familia WHERE fam_indicador='S'";
        String sqlFamEsp = "SELECT * FROM familia WHERE fam_codigo=" + txtCodFam.getText().trim();
        try (Connection cn = dss.getDataSource().getConnection(); Statement st = cn.createStatement(); ResultSet rs = st.executeQuery(sqlFams); ResultSet rss = st.executeQuery(sqlFamEsp)) {
            fm.addElement("**OPCIONES**");
            while (rs.next()) {
                fm.addElement(rs.getString("fam_nombre"));
            }
            rss.first();
            Object descripcion = (Object) rss.getString("fam_nombre");
            dlgGestArticulos.cbFamilia.setModel(fm);
            dlgGestArticulos.cbFamilia.setSelectedItem(descripcion);
            rs.close();
            rss.close();
            st.close();
            cn.close();
        } catch (SQLException ew) {
            System.out.println("Error combomod familia: " + ew.getMessage());
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dlgGestArticulos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(() -> {
            dlgGestArticulos dialog = new dlgGestArticulos(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel LabelTitulo;
    private javax.swing.JLabel LabelTitulo1;
    private javax.swing.JLabel LabelTitulo2;
    private javax.swing.JLabel LabelTitulo3;
    private rojeru_san.rspanel.RSPanelImage PanelContenedor;
    private rojeru_san.rspanel.RSPanelImage PanelContenedor1;
    private rojeru_san.rspanel.RSPanelImage PanelContenedor2;
    private rojeru_san.rspanel.RSPanelImage PanelContenedor3;
    private javax.swing.JSeparator Separador;
    private javax.swing.JSeparator Separador1;
    private javax.swing.JSeparator Separador2;
    private javax.swing.JSeparator Separador3;
    public static RSMaterialComponent.RSButtonIconUno btnCancelar;
    public static javax.swing.JButton btnFamilia;
    public static RSMaterialComponent.RSButtonIconUno btnGuardar;
    public static javax.swing.JButton btnLaboratorio;
    public static RSMaterialComponent.RSButtonIconUno btnModificar;
    public static RSMaterialComponent.RSButtonIconUno btnNuevo;
    public static javax.swing.JButton btnProveedor;
    public static RSMaterialComponent.RSButtonIconUno btnSalir;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    public static RSMaterialComponent.RSComboBox cbFamilia;
    public static RSMaterialComponent.RSComboBox cbImpuesto;
    public static RSMaterialComponent.RSComboBox cbLaboratorio;
    public static RSMaterialComponent.RSComboBox cbProveedor;
    public static rojerusan.RSCheckBox ckHabilitar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lbGan;
    private javax.swing.JLabel lbIVA;
    public static rojerusan.RSRadioButton rActivo;
    public static rojerusan.RSRadioButton rControlado;
    public static rojerusan.RSRadioButton rImportado;
    public static rojerusan.RSRadioButton rInactivo;
    public static rojerusan.RSRadioButton rLibre;
    public static rojerusan.RSRadioButton rNacional;
    public static javax.swing.JTextArea txtAccion;
    public static javax.swing.JTextField txtCantM;
    public static javax.swing.JTextField txtCodBarra;
    public static javax.swing.JTextField txtCodFam;
    public static javax.swing.JTextField txtCodLab;
    public static javax.swing.JTextField txtCodPro;
    public static javax.swing.JTextField txtCodProducto;
    public static javax.swing.JTextField txtCosto;
    public static javax.swing.JTextField txtDesc;
    public static javax.swing.JTextField txtDescripcion;
    public static javax.swing.JTextField txtGanancia;
    public static javax.swing.JTextField txtIVACosto;
    public static javax.swing.JTextField txtPrecioPublico;
    public static javax.swing.JTextField txtPrecioVenta;
    public static javax.swing.JTextField txtPrecioVentaM;
    public static javax.swing.JTextField txtPrecioVentaML;
    public static javax.swing.JTextArea txtPrincipio;
    public static javax.swing.JTextField txtStock;
    public static javax.swing.JTextField txtStockMin;
    // End of variables declaration//GEN-END:variables
}
