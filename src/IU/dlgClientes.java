package IU;

import Componentes.Mensajes;
import Componentes.Notif;
import Componentes.RenderDecimalVenta;
import Componentes.Software;
import Componentes.clsExportarExcel;
import Controladores.CabecerasTablas;
import Controladores.controlCliente;
import static IU.dlgBuscarCliente.tbDetalle;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;

public final class dlgClientes extends javax.swing.JDialog {

    clsExportarExcel Export;
    private static Point point;
    public static int min;

    public dlgClientes(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        min = 0;
        initComponents();
        titulo();
        txtBuscar.requestFocus();
        CabecerasTablas.cliente(tablaClientes);
        controlCliente.listClientes(tablaClientes, "clientes.cli_codigo");
        Renders();
        tablaClientes.getTableHeader().setReorderingAllowed(false);
        tablaClientes.getTableHeader().setResizingAllowed(false);
        cargarIcono();
    }

    final void titulo() {
        if (Software.getSoftware().equals("null")) {
            this.setTitle("Gestionar clientes");
        } else {
            this.setTitle(Software.getSoftware() + " - Gestionar clientes");
        }
    }

    private void AccesoRapido(int n) {

        switch (n) {
            case KeyEvent.VK_F1 ->
                btnNuevo.doClick();
            case KeyEvent.VK_DELETE ->
                btnEliminar.doClick();
            case KeyEvent.VK_F5 ->
                btnModificar.doClick();
            case KeyEvent.VK_F12 ->
                btnSalir.doClick();
            default -> {
            }
        }
    }

    public static void Renders() {
        dlgClientes.tablaClientes.getColumnModel().getColumn(8).setCellRenderer(new RenderDecimalVenta());
    }

    private void Modificar() {
        try {
            dlgGestClientes cli = new dlgGestClientes(null, true);
            cli.setLocationRelativeTo(null);
            controlCliente.aModificar();
            cli.setTitle("Modificación de Cliente");
            dlgGestClientes.btnModificar.setEnabled(true);
            dlgGestClientes.btnGuardar.setEnabled(false);
            dlgGestClientes.btnNuevo.setEnabled(false);
            dlgGestClientes.btnCancelar.setEnabled(true);
            cli.setVisible(true);
        } catch (Exception e) {
            Mensajes.Sistema("No se pudo cargar información del proveedor");
            txtBuscar.requestFocus();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        itemPModificarP = new javax.swing.JMenuItem();
        itemPEliminarP = new javax.swing.JMenuItem();
        dlgMinimizado = new javax.swing.JFrame();
        jPanel6 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        btnEvento1 = new RSMaterialComponent.RSButtonIconUno();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        panelCabecera = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        PnlNuevo1 = new rojeru_san.rspanel.RSPanelImage();
        btnNuevo = new RSMaterialComponent.RSButtonIconUno();
        Separador5 = new javax.swing.JSeparator();
        LabelTitulo5 = new javax.swing.JLabel();
        PnlModificar1 = new rojeru_san.rspanel.RSPanelImage();
        btnModificar = new RSMaterialComponent.RSButtonIconUno();
        Separador6 = new javax.swing.JSeparator();
        LabelTitulo6 = new javax.swing.JLabel();
        PnlEliminarG = new rojeru_san.rspanel.RSPanelImage();
        btnEliminar = new RSMaterialComponent.RSButtonIconUno();
        Separador8 = new javax.swing.JSeparator();
        LabelTitulo8 = new javax.swing.JLabel();
        btnSalir = new RSMaterialComponent.RSButtonIconUno();
        txtBuscar = new rojeru_san.rsfield.RSTextMaterial();
        btnEvento = new RSMaterialComponent.RSButtonIconUno();

        jPopupMenu1.setLabel("Opciones");

        itemPModificarP.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        itemPModificarP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/editUser15.png"))); // NOI18N
        itemPModificarP.setText("     Modificar");
        itemPModificarP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemPModificarPActionPerformed(evt);
            }
        });
        jPopupMenu1.add(itemPModificarP);

        itemPEliminarP.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        itemPEliminarP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/deleteUser15 (2).png"))); // NOI18N
        itemPEliminarP.setText("     Eliminar");
        itemPEliminarP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemPEliminarPActionPerformed(evt);
            }
        });
        jPopupMenu1.add(itemPEliminarP);

        dlgMinimizado.setUndecorated(true);

        jPanel6.setBackground(new java.awt.Color(17, 35, 46));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel28.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("Gestionar Productos");
        jPanel6.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 9, 110, 12));

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
        jPanel6.add(btnEvento1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 2, 25, 25));

        javax.swing.GroupLayout dlgMinimizadoLayout = new javax.swing.GroupLayout(dlgMinimizado.getContentPane());
        dlgMinimizado.getContentPane().setLayout(dlgMinimizadoLayout);
        dlgMinimizadoLayout.setHorizontalGroup(
            dlgMinimizadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        dlgMinimizadoLayout.setVerticalGroup(
            dlgMinimizadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(17, 35, 46)));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        tablaClientes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        tablaClientes.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        tablaClientes.setModel(new javax.swing.table.DefaultTableModel(
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
        tablaClientes.setGridColor(new java.awt.Color(204, 204, 204));
        tablaClientes.setRowHeight(20);
        tablaClientes.setShowGrid(true);
        tablaClientes.setShowVerticalLines(false);
        tablaClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaClientesMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tablaClientesMousePressed(evt);
            }
        });
        tablaClientes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tablaClientesKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tablaClientesKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tablaClientes);

        jPanel4.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 110, 1168, 494));

        panelCabecera.setBackground(new java.awt.Color(17, 35, 46));
        panelCabecera.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                panelCabeceraMouseDragged(evt);
            }
        });
        panelCabecera.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panelCabeceraMousePressed(evt);
            }
        });
        panelCabecera.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setOpaque(false);
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PnlNuevo1.setImagen(new javax.swing.ImageIcon(getClass().getResource("/Recursos/CONTENEDOR2.png"))); // NOI18N
        PnlNuevo1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        PnlNuevo1.add(btnNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 13, 45, 45));

        Separador5.setForeground(new java.awt.Color(204, 204, 204));
        PnlNuevo1.add(Separador5, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 66, 76, 3));

        LabelTitulo5.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        LabelTitulo5.setForeground(new java.awt.Color(17, 35, 46));
        LabelTitulo5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelTitulo5.setText("NUEVO");
        PnlNuevo1.add(LabelTitulo5, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 71, 76, -1));

        jPanel2.add(PnlNuevo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 3, 100, 100));

        PnlModificar1.setImagen(new javax.swing.ImageIcon(getClass().getResource("/Recursos/CONTENEDOR2.png"))); // NOI18N
        PnlModificar1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        PnlModificar1.add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 13, 45, 45));

        Separador6.setForeground(new java.awt.Color(204, 204, 204));
        PnlModificar1.add(Separador6, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 66, 76, 3));

        LabelTitulo6.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        LabelTitulo6.setForeground(new java.awt.Color(17, 35, 46));
        LabelTitulo6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelTitulo6.setText("MODIFICAR");
        PnlModificar1.add(LabelTitulo6, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 71, 76, -1));

        jPanel2.add(PnlModificar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 3, 100, 100));

        PnlEliminarG.setImagen(new javax.swing.ImageIcon(getClass().getResource("/Recursos/CONTENEDOR2.png"))); // NOI18N
        PnlEliminarG.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        PnlEliminarG.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 13, 45, 45));

        Separador8.setForeground(new java.awt.Color(204, 204, 204));
        PnlEliminarG.add(Separador8, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 66, 76, 3));

        LabelTitulo8.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        LabelTitulo8.setForeground(new java.awt.Color(17, 35, 46));
        LabelTitulo8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelTitulo8.setText("ELIMINAR");
        PnlEliminarG.add(LabelTitulo8, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 71, 76, -1));

        jPanel2.add(PnlEliminarG, new org.netbeans.lib.awtextra.AbsoluteConstraints(199, 3, 100, 100));

        panelCabecera.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        btnSalir.setBackground(new java.awt.Color(17, 35, 46));
        btnSalir.setToolTipText("F12");
        btnSalir.setBackgroundHover(new java.awt.Color(205, 0, 0));
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
        panelCabecera.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(1146, 3, 20, 20));

        txtBuscar.setForeground(new java.awt.Color(0, 0, 0));
        txtBuscar.setColorMaterial(new java.awt.Color(255, 102, 0));
        txtBuscar.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        txtBuscar.setPlaceholder("Barra de busqueda");
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
        panelCabecera.add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(483, 75, 680, 23));

        btnEvento.setBackground(new java.awt.Color(17, 35, 46));
        btnEvento.setToolTipText("MINIMIZAR");
        btnEvento.setBackgroundHover(new java.awt.Color(255, 102, 0));
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
        panelCabecera.add(btnEvento, new org.netbeans.lib.awtextra.AbsoluteConstraints(1122, 3, 20, 20));

        jPanel4.add(panelCabecera, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 1, 1169, 105));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 1171, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 605, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tablaClientesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaClientesMousePressed
        // TODO add your handling code here:
        if (SwingUtilities.isRightMouseButton(evt)) {
            Point p = evt.getPoint();
            int number = tablaClientes.rowAtPoint(p);
            ListSelectionModel modelos = tablaClientes.getSelectionModel();
            modelos.setSelectionInterval(number, number);
        }
    }//GEN-LAST:event_tablaClientesMousePressed

    private void itemPModificarPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemPModificarPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_itemPModificarPActionPerformed

    private void itemPEliminarPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemPEliminarPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_itemPEliminarPActionPerformed

    private void tablaClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaClientesMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            Modificar();
        }
    }//GEN-LAST:event_tablaClientesMouseClicked

    private void tablaClientesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tablaClientesKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            Modificar();
        } else if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            txtBuscar.requestFocus();
        }
        AccesoRapido(evt.getKeyCode());
    }//GEN-LAST:event_tablaClientesKeyPressed

    private void txtBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            tablaClientes.requestFocus();
            int r = tablaClientes.getRowCount();
            tablaClientes.changeSelection(tablaClientes.getRowCount() - r, 5, false, false);
        }
        AccesoRapido(evt.getKeyCode());
    }//GEN-LAST:event_txtBuscarKeyPressed

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        // TODO add your handling code here:
        String cod = txtBuscar.getText();
        CabecerasTablas.limpiarTablaCliente(tablaClientes);
        controlCliente.filtClientes(tablaClientes, cod);
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void txtBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isLowerCase(c)) {
            String cad = ("" + c).toUpperCase();
            c = cad.charAt(0);
            evt.setKeyChar(c);
        }
        int limite = 199;
        if (txtBuscar.getText().length() == limite) {
            evt.consume();
        }
    }//GEN-LAST:event_txtBuscarKeyTyped

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
        dlgGestClientes cli = new dlgGestClientes(null, true);
        cli.setLocationRelativeTo(null);
        cli.setTitle("Agregar Cliente");
        cli.nuevo();
        cli.setVisible(true);
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
        try {
            if (tablaClientes.getSelectedRow() < 0) {
                Notif.NotifyFail("Notificación del sistema", "No es posible cargar el formulario de ABM.\r\nSeleccione el Cliente a la cual desea realizar modificaciones.");
                txtBuscar.requestFocus();
            } else {
                Modificar();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            Mensajes.informacion("No se pudo cargar información del Cliente");

        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        if (tablaClientes.getSelectedRow() < 0) {
           Notif.NotifyFail("Notificación del sistema", "No es posible procesar la eliminación.\r\nSeleccione el Cliente que desea eliminar del sistema.");
            txtBuscar.requestFocus();
        } else {
            int resp = JOptionPane.showConfirmDialog(this, "¿Seguro que desea eliminar el registro?", "Eliminar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (resp == JOptionPane.YES_OPTION) {
                controlCliente.delCliente();
                CabecerasTablas.limpiarTablaCliente(tablaClientes);
                controlCliente.listClientes(tablaClientes, "clientes.cli_codigo");
                txtBuscar.setText("");
                txtBuscar.requestFocus();
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        int rpta = Mensajes.confirmar("¿Seguro que desea salir del formulario?");
        if (rpta == 0) {
            try {
                controlCliente.listClientes(tbDetalle, "clientes.cli_codigo");
            } catch (Exception e) {
            }
            try {
                CabecerasTablas.buscarCliente(dlgBuscarCliente.tbDetalle);
                CabecerasTablas.limpiarTablaBuscarCliente(dlgBuscarCliente.tbDetalle);
                controlCliente.listClientes(dlgBuscarCliente.tbDetalle, "clientes.cli_codigo");
                dlgBuscarCliente.txtBuscar.requestFocus();
            } catch (Exception e) {
            }

            this.dispose();
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

    private void btnSalirKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnSalirKeyPressed
        // TODO add your handling code here:
        AccesoRapido(evt.getKeyCode());
    }//GEN-LAST:event_btnSalirKeyPressed

    private void btnEventoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEventoActionPerformed
        // TODO add your handling code here:
        min = 1;
        System.out.println("btnEvento min: " + min);
        this.setVisible(false);
        Notif.Notify_Minim_dlgClientes("Notificación del sistema", "Formulario de Gestionar Clientes minimizado.\r\n\nHaga click sobre esta notificación para visualizarlo nuevamente.");
    }//GEN-LAST:event_btnEventoActionPerformed

    private void btnEventoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnEventoKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEventoKeyPressed

    private void btnEvento1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEvento1ActionPerformed
        // TODO add your handling code here:
        min = 0;
        System.out.println("btnEvento1 min: " + min);
        dlgMinimizado.dispose();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }//GEN-LAST:event_btnEvento1ActionPerformed

    private void btnEvento1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnEvento1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEvento1KeyPressed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        txtBuscar.requestFocus();
    }//GEN-LAST:event_formWindowActivated

    private void panelCabeceraMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelCabeceraMousePressed
        // TODO add your handling code here:
        point = evt.getPoint();
        getComponentAt(point);
    }//GEN-LAST:event_panelCabeceraMousePressed

    private void panelCabeceraMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelCabeceraMouseDragged
        // TODO add your handling code here:
        int CurrentX = this.getLocation().x;
        int CurrentY = this.getLocation().y;

        int MoveX = (CurrentX + evt.getX()) - (CurrentX + point.x);
        int MoveY = (CurrentY + evt.getY()) - (CurrentY + point.y);

        int x = CurrentX + MoveX;
        int y = CurrentY + MoveY;

        this.setLocation(x, y);
    }//GEN-LAST:event_panelCabeceraMouseDragged

    private void tablaClientesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tablaClientesKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tablaClientesKeyReleased

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
            java.util.logging.Logger.getLogger(dlgClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        //</editor-fold>
        java.awt.EventQueue.invokeLater(() -> {
            dlgClientes dialog = new dlgClientes(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel LabelTitulo5;
    private javax.swing.JLabel LabelTitulo6;
    private javax.swing.JLabel LabelTitulo8;
    private rojeru_san.rspanel.RSPanelImage PnlEliminarG;
    private rojeru_san.rspanel.RSPanelImage PnlModificar1;
    private rojeru_san.rspanel.RSPanelImage PnlNuevo1;
    private javax.swing.JSeparator Separador5;
    private javax.swing.JSeparator Separador6;
    private javax.swing.JSeparator Separador8;
    private RSMaterialComponent.RSButtonIconUno btnEliminar;
    public static RSMaterialComponent.RSButtonIconUno btnEvento;
    public static RSMaterialComponent.RSButtonIconUno btnEvento1;
    private RSMaterialComponent.RSButtonIconUno btnModificar;
    public static RSMaterialComponent.RSButtonIconUno btnNuevo;
    private RSMaterialComponent.RSButtonIconUno btnSalir;
    private javax.swing.JFrame dlgMinimizado;
    private javax.swing.JMenuItem itemPEliminarP;
    private javax.swing.JMenuItem itemPModificarP;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelCabecera;
    public static final javax.swing.JTable tablaClientes = new javax.swing.JTable()
    {
        public boolean isCellEditable(int rowInddex, int celIndex)
        {
            return false;
        }
    };
    public static rojeru_san.rsfield.RSTextMaterial txtBuscar;
    // End of variables declaration//GEN-END:variables
}
