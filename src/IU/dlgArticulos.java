package IU;

import Componentes.Mensajes;
import Componentes.RenderDecimal1conPuntos;
import Componentes.RenderDecimalCosto;
import Componentes.RenderDecimalPublico;
import Componentes.RenderDecimalVenta;
import Componentes.RenderDecimalsinColor;
import Componentes.ReporteF;
import Componentes.Software;
import Componentes.clsExportarExcel;
import Controladores.CabecerasTablas;
import Controladores.controlArticulo;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;

public class dlgArticulos extends javax.swing.JDialog {

    CabecerasTablas cabe = new CabecerasTablas();
    clsExportarExcel Export;
    public ReporteF jasper;

    public dlgArticulos(java.awt.Frame parent, boolean modal) throws SQLException {
        super(parent, modal);
        initComponents();
        titulo();
        Barra_Menu.setVisible(false);
        jasper = new ReporteF();
        cabe.Articulos(tbProductos);
        controlArticulo.filtrarGral(tbProductos, "");
        Renders();
        txtBuscar.requestFocus();
    }

    final void titulo() {
        if (Software.getSoftware().equals("null")) {
            this.setTitle("Gestor de artículos");
        } else {
            this.setTitle(Software.getSoftware() + " - Gestor de artículos");
        }
    }

    public static void Renders() {
        dlgArticulos.tbProductos.getColumnModel().getColumn(10).setCellRenderer(new RenderDecimalCosto());
        dlgArticulos.tbProductos.getColumnModel().getColumn(13).setCellRenderer(new RenderDecimalPublico());
        dlgArticulos.tbProductos.getColumnModel().getColumn(15).setCellRenderer(new RenderDecimalVenta());
        dlgArticulos.tbProductos.getColumnModel().getColumn(14).setCellRenderer(new RenderDecimal1conPuntos());
        dlgArticulos.tbProductos.getColumnModel().getColumn(17).setCellRenderer(new RenderDecimal1conPuntos());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
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
        rSButtonIconUno4 = new RSMaterialComponent.RSButtonIconUno();
        Separador3 = new javax.swing.JSeparator();
        LabelTitulo3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtBuscar = new RSMaterialComponent.RSTextFieldMaterialIcon();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbProductos = new javax.swing.JTable()
        {
            public boolean isCellEditable(int rowInddex, int celIndex)
            {
                return false;
            }
        };
        btnSalir1 = new RSMaterialComponent.RSButtonIconUno();
        Barra_Menu = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        itemNuevoE = new javax.swing.JMenuItem();
        itemModificarE = new javax.swing.JMenuItem();
        itemEliminarE = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        itemOrdenC = new javax.swing.JMenuItem();
        itemOrdenN = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        itemExportar = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        itemSalir = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        itemNuevoE1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);
        setResizable(false);
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

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(17, 35, 46)));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setOpaque(false);

        PanelContenedor.setImagen(new javax.swing.ImageIcon(getClass().getResource("/Recursos/CONTENEDOR2.png"))); // NOI18N
        PanelContenedor.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        rSButtonIconUno4.setBackground(new java.awt.Color(0, 153, 255));
        rSButtonIconUno4.setBackgroundHover(new java.awt.Color(255, 255, 255));
        rSButtonIconUno4.setForegroundHover(new java.awt.Color(0, 153, 255));
        rSButtonIconUno4.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.REFRESH);
        rSButtonIconUno4.setRippleColor(java.awt.Color.white);
        rSButtonIconUno4.setTypeBorder(RSMaterialComponent.RSButtonIconUno.TYPEBORDER.CIRCLE);
        rSButtonIconUno4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonIconUno4ActionPerformed(evt);
            }
        });
        PanelContenedor3.add(rSButtonIconUno4, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 15, 45, 45));

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

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 1, 410, 100));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/fondo_2.5.png"))); // NOI18N
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-130, -10, 690, 120));

        txtBuscar.setForeground(new java.awt.Color(0, 0, 0));
        txtBuscar.setColorIcon(new java.awt.Color(17, 35, 46));
        txtBuscar.setColorMaterial(new java.awt.Color(17, 35, 46));
        txtBuscar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtBuscar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.SEARCH);
        txtBuscar.setPhColor(new java.awt.Color(102, 102, 102));
        txtBuscar.setPlaceholder("Buscador de Productos");
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
        jPanel3.add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(688, 70, 669, 30));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        tbProductos.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
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

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 110, 1356, 529));

        btnSalir1.setBackground(new java.awt.Color(255, 255, 255));
        btnSalir1.setBackgroundHover(new java.awt.Color(205, 0, 0));
        btnSalir1.setForegroundText(new java.awt.Color(17, 35, 46));
        btnSalir1.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.CLOSE);
        btnSalir1.setRippleColor(java.awt.Color.white);
        btnSalir1.setTypeBorder(RSMaterialComponent.RSButtonIconUno.TYPEBORDER.CIRCLE);
        btnSalir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalir1ActionPerformed(evt);
            }
        });
        jPanel3.add(btnSalir1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1330, 4, 25, 25));

        jMenu1.setText("Opciones");
        jMenu1.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jMenu1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        itemNuevoE.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        itemNuevoE.setFont(new java.awt.Font("Calibri", 0, 11)); // NOI18N
        itemNuevoE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/addproducto - copia.png"))); // NOI18N
        itemNuevoE.setText("Nuevo");
        itemNuevoE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemNuevoEActionPerformed(evt);
            }
        });
        jMenu1.add(itemNuevoE);

        itemModificarE.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, 0));
        itemModificarE.setFont(new java.awt.Font("Calibri", 0, 11)); // NOI18N
        itemModificarE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/modificarproducto - copia.png"))); // NOI18N
        itemModificarE.setText("Modificar");
        itemModificarE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemModificarEActionPerformed(evt);
            }
        });
        jMenu1.add(itemModificarE);

        itemEliminarE.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_DELETE, 0));
        itemEliminarE.setFont(new java.awt.Font("Calibri", 0, 11)); // NOI18N
        itemEliminarE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/deleteproducto - copia.png"))); // NOI18N
        itemEliminarE.setText("Eliminar");
        itemEliminarE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemEliminarEActionPerformed(evt);
            }
        });
        jMenu1.add(itemEliminarE);
        jMenu1.add(jSeparator4);

        itemOrdenC.setFont(new java.awt.Font("Calibri", 0, 11)); // NOI18N
        itemOrdenC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/orderC15.png"))); // NOI18N
        itemOrdenC.setText("Ordenar por Código");
        itemOrdenC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemOrdenCActionPerformed(evt);
            }
        });
        jMenu1.add(itemOrdenC);

        itemOrdenN.setFont(new java.awt.Font("Calibri", 0, 11)); // NOI18N
        itemOrdenN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/orderN15.png"))); // NOI18N
        itemOrdenN.setText("Ordenar por Nombre Comercial");
        itemOrdenN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemOrdenNActionPerformed(evt);
            }
        });
        jMenu1.add(itemOrdenN);
        jMenu1.add(jSeparator2);

        itemExportar.setFont(new java.awt.Font("Calibri", 0, 11)); // NOI18N
        itemExportar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/excel15.png"))); // NOI18N
        itemExportar.setText("Exportar datos a EXCEL");
        itemExportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemExportarActionPerformed(evt);
            }
        });
        jMenu1.add(itemExportar);
        jMenu1.add(jSeparator3);

        itemSalir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_DOWN_MASK));
        itemSalir.setFont(new java.awt.Font("Calibri", 0, 11)); // NOI18N
        itemSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/back15.png"))); // NOI18N
        itemSalir.setText("Salir");
        itemSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemSalirActionPerformed(evt);
            }
        });
        jMenu1.add(itemSalir);

        Barra_Menu.add(jMenu1);

        jMenu2.setText("Reporte");
        jMenu2.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jMenu2.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        itemNuevoE1.setFont(new java.awt.Font("Calibri", 0, 11)); // NOI18N
        itemNuevoE1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/reports.png"))); // NOI18N
        itemNuevoE1.setText("Reporte de Artículos con Stock Crítico");
        itemNuevoE1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemNuevoE1ActionPerformed(evt);
            }
        });
        jMenu2.add(itemNuevoE1);

        Barra_Menu.add(jMenu2);

        setJMenuBar(Barra_Menu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 1360, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
    void nuevoArticulo() {
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
            dlgGestArticulos.CalculoIVAC();
            a.setVisible(true);
        } catch (Exception e) {
            //Mensajes.error("Seleccione una fila de la tabla");     
        }
        tbProductos.clearSelection();
    }

    void delArticulo() {
        try {
            int x = tbProductos.getSelectedRow();
            String desc = tbProductos.getValueAt(x, 5).toString();
            int rpta = Mensajes.confirmar("Desea realmente eliminar " + desc + " de la lista");
            if (rpta == 0) {
                controlArticulo.delArticulo();
                CabecerasTablas.limpiarTablas(tbProductos);
                controlArticulo.listArticulo(tbProductos, "cod");
                txtBuscar.setText("");
                txtBuscar.requestFocus();
            }
        } catch (Exception e) {
            Mensajes.Sistema("La eliminación no puede ser procesada.\nSeleccione en la tabla el producto que desea eliminar definitivamente de la base de datos.");
        }
    }
    private void tbProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbProductosMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            modArticulo();
        }
    }//GEN-LAST:event_tbProductosMouseClicked

    private void itemNuevoEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemNuevoEActionPerformed
        // TODO add your handling code here:
        btnNuevoActionPerformed(null);
    }//GEN-LAST:event_itemNuevoEActionPerformed

    private void itemModificarEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemModificarEActionPerformed
        // TODO add your handling code here:
        btnModificarActionPerformed(null);
    }//GEN-LAST:event_itemModificarEActionPerformed

    private void itemEliminarEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemEliminarEActionPerformed
        // TODO add your handling code here:
        btnEliminarActionPerformed(null);
    }//GEN-LAST:event_itemEliminarEActionPerformed

    private void itemOrdenCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemOrdenCActionPerformed
        // TODO add your handling code here:
        CabecerasTablas.limpiarTablas(tbProductos);
        controlArticulo.listArticulo(tbProductos, "cod");
    }//GEN-LAST:event_itemOrdenCActionPerformed

    private void itemOrdenNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemOrdenNActionPerformed
        // TODO add your handling code here:
        CabecerasTablas.limpiarTablas(tbProductos);
        controlArticulo.listArticulo(tbProductos, "descripcion");
    }//GEN-LAST:event_itemOrdenNActionPerformed

    private void itemExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemExportarActionPerformed

        try {
            Export = new clsExportarExcel();
            Export.exportarExcel(tbProductos);
        } catch (IOException ex) {
            Logger.getLogger(dlgClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_itemExportarActionPerformed

    private void itemSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemSalirActionPerformed
        // TODO add your handling code here:
        btnSalir1ActionPerformed(null);
    }//GEN-LAST:event_itemSalirActionPerformed

    private void tbProductosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbProductosKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            modArticulo();
        } else if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            txtBuscar.requestFocus();
            txtBuscar.selectAll();
        }
    }//GEN-LAST:event_tbProductosKeyPressed

    private void formWindowLostFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowLostFocus

    }//GEN-LAST:event_formWindowLostFocus

    private void formWindowStateChanged(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowStateChanged

    private void itemNuevoE1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemNuevoE1ActionPerformed
        // TODO add your handling code here:
        try {
            dlgReporteStockCritico rsc = new dlgReporteStockCritico(null, false);
            rsc.setLocationRelativeTo(null);
            rsc.setVisible(true);
        } catch (Exception e) {
            Mensajes.informacion("No hay conexión con el servidor");
        }

        //
    }//GEN-LAST:event_itemNuevoE1ActionPerformed

    private void rSButtonIconUno4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonIconUno4ActionPerformed
        // TODO add your handling code here:
        cabe.Articulos(tbProductos);
        controlArticulo.filtrarGral(tbProductos, "");
        Renders();
        txtBuscar.setText("");
        txtBuscar.requestFocus();
    }//GEN-LAST:event_rSButtonIconUno4ActionPerformed

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
    }//GEN-LAST:event_txtBuscarKeyPressed

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        // TODO add your handling code here:
        System.out.println(txtBuscar.getText().trim().length());
        try {
            String cod = txtBuscar.getText();
            cabe.Articulos(tbProductos);
            CabecerasTablas.limpiarTablas(tbProductos);
            controlArticulo.filtrarGral(tbProductos, cod);
            /*cabe.Articulos(tbProductos);
            controlArticulo.listArticulo(tbProductos, "cod");
            CabecerasTablas.limpiarTablas(tbProductos);
            controlArticulo.filtrarGral(tbProductos, cod);*/
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

    private void btnSalir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalir1ActionPerformed
        // TODO add your handling code here:
        int rpta = Mensajes.confirmar("¿Seguro que desea cerrar este formulario?");
        if (rpta == 0) {
            this.dispose();
        }
    }//GEN-LAST:event_btnSalir1ActionPerformed

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
    private javax.swing.JMenuBar Barra_Menu;
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
    private RSMaterialComponent.RSButtonIconUno btnEliminar;
    private RSMaterialComponent.RSButtonIconUno btnModificar;
    private RSMaterialComponent.RSButtonIconUno btnNuevo;
    private RSMaterialComponent.RSButtonIconUno btnSalir1;
    private javax.swing.JMenuItem itemEliminarE;
    private javax.swing.JMenuItem itemExportar;
    private javax.swing.JMenuItem itemModificarE;
    private javax.swing.JMenuItem itemNuevoE;
    public javax.swing.JMenuItem itemNuevoE1;
    private javax.swing.JMenuItem itemOrdenC;
    private javax.swing.JMenuItem itemOrdenN;
    private javax.swing.JMenuItem itemSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private RSMaterialComponent.RSButtonIconUno rSButtonIconUno4;
    public static javax.swing.JTable tbProductos;
    public static RSMaterialComponent.RSTextFieldMaterialIcon txtBuscar;
    // End of variables declaration//GEN-END:variables
}
