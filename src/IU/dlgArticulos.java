package IU;

import Componentes.Mensajes;
import Componentes.Notif;
import Componentes.RenderDecimal1conPuntos;
import Componentes.RenderDecimalCosto;
import Componentes.RenderDecimalPublico;
import Componentes.RenderDecimalVenta;
import Componentes.ReporteF;
import Componentes.Software;
import Componentes.clsExportarExcel;
import Controladores.CabecerasTablas;
import Controladores.controlArticulo;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;

public class dlgArticulos extends javax.swing.JDialog {

    clsExportarExcel Export;
    public ReporteF jasper;
    private static Point point;
    public static int min;

    public dlgArticulos(java.awt.Frame parent, boolean modal) throws SQLException {
        super(parent, modal);
        min = 0;
        initComponents();
        titulo();
        jasper = new ReporteF();
        CabecerasTablas.Articulos(tbProductos);
        controlArticulo.filtrarGral(tbProductos, "");
        Renders();
        txtBuscar.requestFocus();
        System.out.println("inicializando min: " + min);
    }

    final void titulo() {
        if (Software.getSoftware().equals("null")) {
            this.setTitle("Gestor de artículos");
        } else {
            this.setTitle(Software.getSoftware() + " - Gestor de artículos");
        }
    }

    void Volver2() {
        try {
            CabecerasTablas.tablaArticuloAuxiliar(dlgBuscarArticuloCompra.tbDetalle);
            CabecerasTablas.limpiarTablaTablaArticuloAuxiliar(dlgBuscarArticuloCompra.tbDetalle);
            controlArticulo.filtrarCodBarraActivo(dlgBuscarArticuloCompra.tbDetalle, "");
            dlgBuscarArticuloCompra.Renders();
            dlgBuscarArticuloCompra.txtBuscar.requestFocus();
            dlgBuscarArticuloCompra.txtBuscar.setText("");
            dlgBuscarArticuloCompra.tbDetalle.clearSelection();
        } catch (Exception e) {
            System.out.println("Error volviendo a dlgBuscarArticuloCompra: " + e.getMessage());
        }
    }

    private void AccesoRapido(int n) {

        switch (n) {
            case KeyEvent.VK_F1 ->
                btnNuevo.doClick();
            case KeyEvent.VK_F5 ->
                btnModificar.doClick();
            case KeyEvent.VK_DELETE ->
                btnEliminar.doClick();
            case KeyEvent.VK_F12 ->
                btnSalir.doClick();
            default -> {
            }
        }
    }

    public static void Renders() {
        dlgArticulos.tbProductos.getColumnModel().getColumn(12).setCellRenderer(new RenderDecimalCosto());
        dlgArticulos.tbProductos.getColumnModel().getColumn(10).setCellRenderer(new RenderDecimalPublico());
        dlgArticulos.tbProductos.getColumnModel().getColumn(15).setCellRenderer(new RenderDecimalVenta());
        dlgArticulos.tbProductos.getColumnModel().getColumn(14).setCellRenderer(new RenderDecimal1conPuntos());
        dlgArticulos.tbProductos.getColumnModel().getColumn(17).setCellRenderer(new RenderDecimal1conPuntos());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dlgMinimizado = new javax.swing.JFrame();
        jPanel1 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        btnEvento1 = new RSMaterialComponent.RSButtonIconUno();
        FondoBlanco = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        PanelContenedor = new rojeru_san.rspanel.RSPanelImage();
        btnNuevo = new RSMaterialComponent.RSButtonIconUno();
        Separador = new javax.swing.JSeparator();
        LabelTitulo = new javax.swing.JLabel();
        PanelContenedor1 = new rojeru_san.rspanel.RSPanelImage();
        btnModificar = new RSMaterialComponent.RSButtonIconUno();
        Separador1 = new javax.swing.JSeparator();
        LabelTitulo1 = new javax.swing.JLabel();
        PanelContenedor2 = new rojeru_san.rspanel.RSPanelImage();
        btnEliminar = new RSMaterialComponent.RSButtonIconUno();
        Separador2 = new javax.swing.JSeparator();
        LabelTitulo2 = new javax.swing.JLabel();
        PanelContenedor3 = new rojeru_san.rspanel.RSPanelImage();
        btnActualizar = new RSMaterialComponent.RSButtonIconUno();
        Separador3 = new javax.swing.JSeparator();
        LabelTitulo3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtBuscar = new RSMaterialComponent.RSTextFieldMaterialIcon();
        btnSalir = new RSMaterialComponent.RSButtonIconUno();
        btnEvento = new RSMaterialComponent.RSButtonIconUno();

        dlgMinimizado.setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(17, 35, 46));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel19.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Gestionar Productos");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 9, 110, 12));

        btnEvento1.setBackground(new java.awt.Color(17, 35, 46));
        btnEvento1.setToolTipText("F12");
        btnEvento1.setBackgroundHover(new java.awt.Color(17, 35, 46));
        btnEvento1.setForegroundHover(new java.awt.Color(255, 102, 0));
        btnEvento1.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.KEYBOARD_ARROW_UP);
        btnEvento1.setRippleColor(java.awt.Color.white);
        btnEvento1.setTypeBorder(RSMaterialComponent.RSButtonIconUno.TYPEBORDER.CIRCLE);
        btnEvento1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEvento1ActionPerformed(evt);
            }
        });
        btnEvento1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnEvento1KeyPressed(evt);
            }
        });
        jPanel1.add(btnEvento1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 2, 25, 25));

        javax.swing.GroupLayout dlgMinimizadoLayout = new javax.swing.GroupLayout(dlgMinimizado.getContentPane());
        dlgMinimizado.getContentPane().setLayout(dlgMinimizadoLayout);
        dlgMinimizadoLayout.setHorizontalGroup(
            dlgMinimizadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        dlgMinimizadoLayout.setVerticalGroup(
            dlgMinimizadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);
        setResizable(false);
        setType(java.awt.Window.Type.POPUP);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
                formWindowLostFocus(evt);
            }
        });
        addWindowStateListener(new java.awt.event.WindowStateListener() {
            public void windowStateChanged(java.awt.event.WindowEvent evt) {
                formWindowStateChanged(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        FondoBlanco.setBackground(new java.awt.Color(255, 255, 255));
        FondoBlanco.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(17, 35, 46)));
        FondoBlanco.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                FondoBlancoMouseDragged(evt);
            }
        });
        FondoBlanco.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                FondoBlancoMousePressed(evt);
            }
        });
        FondoBlanco.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setOpaque(false);

        PanelContenedor.setImagen(new javax.swing.ImageIcon(getClass().getResource("/Recursos/CONTENEDOR2.png"))); // NOI18N
        PanelContenedor.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnNuevo.setBackground(new java.awt.Color(0, 102, 0));
        btnNuevo.setToolTipText("F1");
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
        btnNuevo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnNuevoKeyPressed(evt);
            }
        });
        PanelContenedor.add(btnNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 15, 45, 45));

        Separador.setForeground(new java.awt.Color(204, 204, 204));
        PanelContenedor.add(Separador, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 65, 76, 3));

        LabelTitulo.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        LabelTitulo.setForeground(new java.awt.Color(17, 35, 46));
        LabelTitulo.setText("NUEVO");
        PanelContenedor.add(LabelTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 70, -1, -1));

        PanelContenedor1.setImagen(new javax.swing.ImageIcon(getClass().getResource("/Recursos/CONTENEDOR2.png"))); // NOI18N
        PanelContenedor1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnModificar.setBackground(new java.awt.Color(255, 102, 0));
        btnModificar.setToolTipText("F5");
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
        btnModificar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnModificarKeyPressed(evt);
            }
        });
        PanelContenedor1.add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 15, 45, 45));

        Separador1.setForeground(new java.awt.Color(204, 204, 204));
        PanelContenedor1.add(Separador1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 65, 76, 3));

        LabelTitulo1.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        LabelTitulo1.setForeground(new java.awt.Color(17, 35, 46));
        LabelTitulo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelTitulo1.setText("MODIFICAR");
        PanelContenedor1.add(LabelTitulo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 70, 90, -1));

        PanelContenedor2.setImagen(new javax.swing.ImageIcon(getClass().getResource("/Recursos/CONTENEDOR2.png"))); // NOI18N
        PanelContenedor2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnEliminar.setBackground(new java.awt.Color(255, 0, 0));
        btnEliminar.setToolTipText("DELETE");
        btnEliminar.setBackgroundHover(new java.awt.Color(255, 255, 255));
        btnEliminar.setForegroundHover(new java.awt.Color(255, 0, 0));
        btnEliminar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.DELETE);
        btnEliminar.setRippleColor(java.awt.Color.white);
        btnEliminar.setTypeBorder(RSMaterialComponent.RSButtonIconUno.TYPEBORDER.CIRCLE);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        btnEliminar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnEliminarKeyPressed(evt);
            }
        });
        PanelContenedor2.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 15, 45, 45));

        Separador2.setForeground(new java.awt.Color(204, 204, 204));
        PanelContenedor2.add(Separador2, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 65, 76, 3));

        LabelTitulo2.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        LabelTitulo2.setForeground(new java.awt.Color(17, 35, 46));
        LabelTitulo2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelTitulo2.setText("ELIMINAR");
        PanelContenedor2.add(LabelTitulo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 70, 90, -1));

        PanelContenedor3.setImagen(new javax.swing.ImageIcon(getClass().getResource("/Recursos/CONTENEDOR2.png"))); // NOI18N
        PanelContenedor3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnActualizar.setBackground(new java.awt.Color(0, 153, 255));
        btnActualizar.setBackgroundHover(new java.awt.Color(255, 255, 255));
        btnActualizar.setForegroundHover(new java.awt.Color(0, 153, 255));
        btnActualizar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.REFRESH);
        btnActualizar.setRippleColor(java.awt.Color.white);
        btnActualizar.setTypeBorder(RSMaterialComponent.RSButtonIconUno.TYPEBORDER.CIRCLE);
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        btnActualizar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnActualizarKeyPressed(evt);
            }
        });
        PanelContenedor3.add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 15, 45, 45));

        Separador3.setForeground(new java.awt.Color(204, 204, 204));
        PanelContenedor3.add(Separador3, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 65, 76, 3));

        LabelTitulo3.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        LabelTitulo3.setForeground(new java.awt.Color(17, 35, 46));
        LabelTitulo3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelTitulo3.setText("ACTUALIZAR");
        PanelContenedor3.add(LabelTitulo3, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 70, 90, -1));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(PanelContenedor, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(PanelContenedor1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(PanelContenedor2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(PanelContenedor3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PanelContenedor, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PanelContenedor1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PanelContenedor2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PanelContenedor3, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );

        FondoBlanco.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 1, 410, 100));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/fondo_2.5.png"))); // NOI18N
        FondoBlanco.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-130, -10, 690, 120));

        txtBuscar.setForeground(new java.awt.Color(0, 0, 0));
        txtBuscar.setColorIcon(new java.awt.Color(255, 102, 0));
        txtBuscar.setColorMaterial(new java.awt.Color(255, 102, 0));
        txtBuscar.setFont(new java.awt.Font("Roboto", 1, 13)); // NOI18N
        txtBuscar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.SEARCH);
        txtBuscar.setPhColor(new java.awt.Color(102, 102, 102));
        txtBuscar.setPlaceholder("Barra de busqueda");
        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });
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
        FondoBlanco.add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(688, 70, 583, 30));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        tbProductos.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        tbProductos.setModel(new javax.swing.table.DefaultTableModel(
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
        tbProductos.setGridColor(new java.awt.Color(204, 204, 204));
        tbProductos.setRowHeight(22);
        tbProductos.setShowGrid(true);
        tbProductos.setShowVerticalLines(false);
        tbProductos.getTableHeader().setResizingAllowed(false);
        tbProductos.getTableHeader().setReorderingAllowed(false);
        tbProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbProductosMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbProductosMousePressed(evt);
            }
        });
        tbProductos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tbProductosKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tbProductos);

        FondoBlanco.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 105, 1270, 528));

        btnSalir.setBackground(new java.awt.Color(255, 255, 255));
        btnSalir.setToolTipText("F12");
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
        btnSalir.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnSalirKeyPressed(evt);
            }
        });
        FondoBlanco.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(1244, 4, 25, 25));

        btnEvento.setBackground(new java.awt.Color(255, 255, 255));
        btnEvento.setToolTipText("MINIMIZAR");
        btnEvento.setBackgroundHover(new java.awt.Color(255, 255, 255));
        btnEvento.setForegroundHover(new java.awt.Color(255, 102, 0));
        btnEvento.setForegroundText(new java.awt.Color(17, 35, 46));
        btnEvento.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.KEYBOARD_ARROW_DOWN);
        btnEvento.setRippleColor(java.awt.Color.white);
        btnEvento.setTypeBorder(RSMaterialComponent.RSButtonIconUno.TYPEBORDER.CIRCLE);
        btnEvento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEventoActionPerformed(evt);
            }
        });
        btnEvento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnEventoKeyPressed(evt);
            }
        });
        FondoBlanco.add(btnEvento, new org.netbeans.lib.awtextra.AbsoluteConstraints(1214, 4, 25, 25));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(FondoBlanco, javax.swing.GroupLayout.DEFAULT_SIZE, 1274, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(FondoBlanco, javax.swing.GroupLayout.DEFAULT_SIZE, 640, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbProductosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbProductosMousePressed
        // TODO add your handling code here:
        if (SwingUtilities.isRightMouseButton(evt)) {
            Point p = evt.getPoint();
            int number = tbProductos.rowAtPoint(p);
            ListSelectionModel modelos = tbProductos.getSelectionModel();
            modelos.setSelectionInterval(number, number);
        }
    }//GEN-LAST:event_tbProductosMousePressed
    public static void nuevoArticulo() {
        dlgGestArticulos gestArticulos = new dlgGestArticulos(null, true);
        gestArticulos.setLocationRelativeTo(null);
        gestArticulos.Nuevo();
        gestArticulos.setVisible(true);

    }

    void modArticulo() {
        try {
            dlgGestArticulos a = new dlgGestArticulos(null, true);
            a.setLocationRelativeTo(null);
            controlArticulo.aModifcar();
            dlgGestArticulos.btnNuevo.setEnabled(false);
            dlgGestArticulos.btnModificar.setEnabled(true);
            dlgGestArticulos.btnGuardar.setEnabled(false);
            dlgGestArticulos.btnCancelar.setEnabled(true);
            dlgGestArticulos.btnSalir.setEnabled(false);
            dlgGestArticulos.txtCodBarra.requestFocus();
            dlgGestArticulos.txtStock.setEnabled(false);
            a.modcbLaboratorio();
            a.modcbProveedor();
            a.modcbFamilia();
            a.setVisible(true);
        } catch (Exception e) {
            //Mensajes.error("Seleccione una fila de la tabla");     
        }
        tbProductos.clearSelection();
    }

    void delArticulo() {
        try {
            int x = tbProductos.getSelectedRow();
            if (x < 0) {
                Mensajes.Sistema("La eliminación no puede ser procesada.\nSeleccione en la tabla el producto que desea eliminar definitivamente de la base de datos.");
            } else {
                String desc = tbProductos.getValueAt(x, 5).toString();
                int rpta = Mensajes.confirmar("Desea realmente eliminar " + desc + " de la lista");
                if (rpta == 0) {
                    controlArticulo.delArticulo();
                    CabecerasTablas.limpiarTablaArticulos(tbProductos);
                    controlArticulo.listArticulo(tbProductos, "cod");
                    txtBuscar.setText("");
                    txtBuscar.requestFocus();
                }
            }
        } catch (Exception e) {
           // Mensajes.Sistema("La eliminación no puede ser procesada.\nSeleccione en la tabla el producto que desea eliminar definitivamente de la base de datos.");
        }
    }
    private void tbProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbProductosMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            modArticulo();
        }
    }//GEN-LAST:event_tbProductosMouseClicked

    private void tbProductosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbProductosKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            modArticulo();
        } else if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            txtBuscar.requestFocus();
            txtBuscar.selectAll();
        }
        AccesoRapido(evt.getKeyCode());
    }//GEN-LAST:event_tbProductosKeyPressed

    private void formWindowLostFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowLostFocus

    }//GEN-LAST:event_formWindowLostFocus

    private void formWindowStateChanged(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowStateChanged

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:
        CabecerasTablas.limpiarTablaArticulos(tbProductos);
        controlArticulo.filtrarGral(tbProductos, "");
        Renders();
        txtBuscar.setText("");
        txtBuscar.requestFocus();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
        nuevoArticulo();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
        int x = tbProductos.getSelectedRow();
        if (x < 0) {
            Mensajes.Sistema("El formulario ABM no puede ser procesado.\nSeleccione en la tabla el producto que desea modificar.");
        } else {
            modArticulo();
        }

    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        delArticulo();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        // TODO add your handling code here:
        System.out.println(txtBuscar.getText().length());
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void txtBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (tbProductos.getRowCount() <= 0) {
                txtBuscar.requestFocus();
                txtBuscar.selectAll();
            } else {
                tbProductos.requestFocus();
                tbProductos.getSelectionModel().setSelectionInterval(0, 0);
            }
        }
        AccesoRapido(evt.getKeyCode());
    }//GEN-LAST:event_txtBuscarKeyPressed

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        // TODO add your handling code here:
        System.out.println(txtBuscar.getText().trim().length());
        try {
            String cod = txtBuscar.getText();
            CabecerasTablas.limpiarTablaArticulos(tbProductos);
            controlArticulo.filtrarGral(tbProductos, cod);
            Renders();
        } catch (Exception e) {
            System.out.println("Mensaje de Error: " + e.getMessage());
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

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        int rpta = Mensajes.confirmar("¿Seguro que desea cerrar este formulario?");
        if (rpta == 0) {
            try {
                Volver2();
                System.out.println("btnCerrar min: " + min);
                min = 0;
                this.dispose();
            } catch (Exception e) {
                System.out.println("Error btnSalir: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnNuevoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnNuevoKeyPressed
        // TODO add your handling code here:
        AccesoRapido(evt.getKeyCode());
    }//GEN-LAST:event_btnNuevoKeyPressed

    private void btnModificarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnModificarKeyPressed
        // TODO add your handling code here:
        AccesoRapido(evt.getKeyCode());
    }//GEN-LAST:event_btnModificarKeyPressed

    private void btnEliminarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnEliminarKeyPressed
        // TODO add your handling code here:
        AccesoRapido(evt.getKeyCode());
    }//GEN-LAST:event_btnEliminarKeyPressed

    private void btnActualizarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnActualizarKeyPressed
        // TODO add your handling code here:
        AccesoRapido(evt.getKeyCode());
    }//GEN-LAST:event_btnActualizarKeyPressed

    private void btnSalirKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnSalirKeyPressed
        // TODO add your handling code here:
        AccesoRapido(evt.getKeyCode());
    }//GEN-LAST:event_btnSalirKeyPressed

    private void btnEventoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEventoActionPerformed
        // TODO add your handling code here:
        min = 1;
        System.out.println("btnEvento min: " + min);
        this.setVisible(false);
        Notif.Notify_Minim_dlgArticulos("Notificación del sistema", "Formulario de Gestión de Productos minimizado.\r\n\nHaga click sobre esta notificación para visualizarlo nuevamente.");
    }//GEN-LAST:event_btnEventoActionPerformed

    private void btnEventoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnEventoKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEventoKeyPressed

    private void FondoBlancoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FondoBlancoMousePressed
        // TODO add your handling code here:
        point = evt.getPoint();
        getComponentAt(point);
    }//GEN-LAST:event_FondoBlancoMousePressed

    private void FondoBlancoMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FondoBlancoMouseDragged
        // TODO add your handling code here:
        int CurrentX = this.getLocation().x;
        int CurrentY = this.getLocation().y;

        int MoveX = (CurrentX + evt.getX()) - (CurrentX + point.x);
        int MoveY = (CurrentY + evt.getY()) - (CurrentY + point.y);

        int x = CurrentX + MoveX;
        int y = CurrentY + MoveY;

        this.setLocation(x, y);
    }//GEN-LAST:event_FondoBlancoMouseDragged

    private void btnEvento1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnEvento1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEvento1KeyPressed

    private void btnEvento1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEvento1ActionPerformed
        // TODO add your handling code here:
        min = 0;
        System.out.println("btnEvento1 min: " + min);
        dlgMinimizado.dispose();
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }//GEN-LAST:event_btnEvento1ActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        txtBuscar.requestFocus();
    }//GEN-LAST:event_formWindowActivated

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
            java.util.logging.Logger.getLogger(dlgArticulos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>
        java.awt.EventQueue.invokeLater(() -> {
            try {
                dlgArticulos dialog = new dlgArticulos(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {

                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(dlgArticulos.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel FondoBlanco;
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
    private RSMaterialComponent.RSButtonIconUno btnActualizar;
    private RSMaterialComponent.RSButtonIconUno btnEliminar;
    private RSMaterialComponent.RSButtonIconUno btnEvento;
    public static RSMaterialComponent.RSButtonIconUno btnEvento1;
    private RSMaterialComponent.RSButtonIconUno btnModificar;
    private RSMaterialComponent.RSButtonIconUno btnNuevo;
    private RSMaterialComponent.RSButtonIconUno btnSalir;
    private javax.swing.JFrame dlgMinimizado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private final javax.swing.JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
    public static final javax.swing.JTable tbProductos = new javax.swing.JTable()
    {
        public boolean isCellEditable(int rowInddex, int celIndex)
        {
            return false;
        }
    };
    public static RSMaterialComponent.RSTextFieldMaterialIcon txtBuscar;
    // End of variables declaration//GEN-END:variables
}
