package IU;

import Componentes.Mensajes;
import Componentes.Software;
import Componentes.clsExportarExcel;
import Controladores.CabecerasTablas;
import Controladores.controlCliente;
import static IU.dlgBuscarCliente.tbDetalle;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;

public final class dlgClientes extends javax.swing.JDialog {

    CabecerasTablas cabe = new CabecerasTablas();
    clsExportarExcel Export;
    public dlgClientes(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        titulo();
        cabe.cliente(tablaClientes);
        controlCliente.listClientes(tablaClientes, "clientes.cli_codigo");
        tablaClientes.getTableHeader().setReorderingAllowed(false);
        tablaClientes.getTableHeader().setResizingAllowed(false);
        cargarIcono();
        cbkBuscarActionPerformed(null);
    }
    
    final void titulo(){
        if(Software.getSoftware().equals("null")){
            this.setTitle("Gestionar clientes");
        }else{
            this.setTitle(Software.getSoftware()+" - Gestionar clientes");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        itemPModificarP = new javax.swing.JMenuItem();
        itemPEliminarP = new javax.swing.JMenuItem();
        jPanel2 = new javax.swing.JPanel();
        txtBuscar = new javax.swing.JTextField();
        cbkBuscar = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        btnNuevoP = new newscomponents.RSButtonBigIcon_new();
        btnModificarP = new newscomponents.RSButtonBigIcon_new();
        btnEliminarP = new newscomponents.RSButtonBigIcon_new();
        btnSalir = new newscomponents.RSButtonBigIcon_new();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaClientes = new javax.swing.JTable()
        {
            public boolean isCellEditable(int rowInddex, int celIndex)
            {
                return false;
            }
        };
        jSeparator4 = new javax.swing.JSeparator();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        itemNuevoE = new javax.swing.JMenuItem();
        itemModificarE = new javax.swing.JMenuItem();
        itemEliminarE = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        itemOrdenC = new javax.swing.JMenuItem();
        itemOrdenN = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        itemExportar = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        itemSalir = new javax.swing.JMenuItem();

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

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        txtBuscar.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtBuscar.setEnabled(false);
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

        cbkBuscar.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        cbkBuscar.setSelected(true);
        cbkBuscar.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        cbkBuscar.setOpaque(false);
        cbkBuscar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        cbkBuscar.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        cbkBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbkBuscarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/baseline_content_paste_search_black_20.png"))); // NOI18N
        jLabel1.setText("Buscador de Clientes");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbkBuscar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 493, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(240, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbkBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(32, 32, 32))
        );

        jPanel3.setBackground(new java.awt.Color(102, 102, 102));

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setLayout(new java.awt.GridLayout(1, 5));

        btnNuevoP.setBackground(new java.awt.Color(102, 102, 102));
        btnNuevoP.setBorder(null);
        btnNuevoP.setText("NUEVO");
        btnNuevoP.setBgHover(new java.awt.Color(57, 57, 57));
        btnNuevoP.setFocusPainted(false);
        btnNuevoP.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        btnNuevoP.setIconTextGap(0);
        btnNuevoP.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.ADD_BOX);
        btnNuevoP.setPixels(0);
        btnNuevoP.setSizeIcon(60.0F);
        btnNuevoP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoPActionPerformed(evt);
            }
        });
        jPanel1.add(btnNuevoP);

        btnModificarP.setBackground(new java.awt.Color(102, 102, 102));
        btnModificarP.setBorder(null);
        btnModificarP.setText("MODIFICAR");
        btnModificarP.setBgHover(new java.awt.Color(57, 57, 57));
        btnModificarP.setFocusPainted(false);
        btnModificarP.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        btnModificarP.setIconTextGap(0);
        btnModificarP.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EDIT);
        btnModificarP.setPixels(0);
        btnModificarP.setSizeIcon(60.0F);
        btnModificarP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarPActionPerformed(evt);
            }
        });
        jPanel1.add(btnModificarP);

        btnEliminarP.setBackground(new java.awt.Color(102, 102, 102));
        btnEliminarP.setBorder(null);
        btnEliminarP.setText("ELIMINAR");
        btnEliminarP.setBgHover(new java.awt.Color(57, 57, 57));
        btnEliminarP.setFocusPainted(false);
        btnEliminarP.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        btnEliminarP.setIconTextGap(0);
        btnEliminarP.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.DELETE);
        btnEliminarP.setPixels(0);
        btnEliminarP.setSizeIcon(60.0F);
        btnEliminarP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarPActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminarP);

        btnSalir.setBackground(new java.awt.Color(102, 102, 102));
        btnSalir.setBorder(null);
        btnSalir.setText("SALIR");
        btnSalir.setBgHover(new java.awt.Color(57, 57, 57));
        btnSalir.setFocusPainted(false);
        btnSalir.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        btnSalir.setIconTextGap(0);
        btnSalir.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EXIT_TO_APP);
        btnSalir.setPixels(0);
        btnSalir.setSizeIcon(60.0F);
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jPanel1.add(btnSalir);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel4.setLayout(new java.awt.GridLayout());

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
        tablaClientes.setComponentPopupMenu(jPopupMenu1);
        tablaClientes.setGridColor(new java.awt.Color(221, 221, 221));
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
        });
        jScrollPane1.setViewportView(tablaClientes);

        jPanel4.add(jScrollPane1);

        jSeparator4.setForeground(new java.awt.Color(204, 204, 204));
        jSeparator4.setOpaque(true);

        jMenuBar1.setBackground(new java.awt.Color(255, 255, 255));
        jMenuBar1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        jMenu1.setBackground(new java.awt.Color(255, 255, 255));
        jMenu1.setBorder(null);
        jMenu1.setText("Opciones");
        jMenu1.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        jMenu1.setOpaque(true);

        itemNuevoE.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        itemNuevoE.setBackground(new java.awt.Color(255, 255, 255));
        itemNuevoE.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        itemNuevoE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/baseline_add_box_black_24.png"))); // NOI18N
        itemNuevoE.setText("NUEVO");
        itemNuevoE.setBorder(null);
        itemNuevoE.setOpaque(true);
        itemNuevoE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemNuevoEActionPerformed(evt);
            }
        });
        jMenu1.add(itemNuevoE);

        itemModificarE.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, 0));
        itemModificarE.setBackground(new java.awt.Color(255, 255, 255));
        itemModificarE.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        itemModificarE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/baseline_edit_black_24.png"))); // NOI18N
        itemModificarE.setText("MODIFICAR");
        itemModificarE.setBorder(null);
        itemModificarE.setOpaque(true);
        itemModificarE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemModificarEActionPerformed(evt);
            }
        });
        jMenu1.add(itemModificarE);

        itemEliminarE.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_DELETE, 0));
        itemEliminarE.setBackground(new java.awt.Color(255, 255, 255));
        itemEliminarE.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        itemEliminarE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/baseline_delete_black_24.png"))); // NOI18N
        itemEliminarE.setText("ELIMINAR");
        itemEliminarE.setBorder(null);
        itemEliminarE.setOpaque(true);
        itemEliminarE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemEliminarEActionPerformed(evt);
            }
        });
        jMenu1.add(itemEliminarE);

        jSeparator1.setForeground(new java.awt.Color(204, 204, 204));
        jSeparator1.setOpaque(true);
        jMenu1.add(jSeparator1);

        itemOrdenC.setBackground(new java.awt.Color(255, 255, 255));
        itemOrdenC.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        itemOrdenC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/baseline_format_list_numbered_black_24.png"))); // NOI18N
        itemOrdenC.setText("ORDENAR POR CÓDIGO");
        itemOrdenC.setBorder(null);
        itemOrdenC.setOpaque(true);
        itemOrdenC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemOrdenCActionPerformed(evt);
            }
        });
        jMenu1.add(itemOrdenC);

        itemOrdenN.setBackground(new java.awt.Color(255, 255, 255));
        itemOrdenN.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        itemOrdenN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/baseline_sort_by_alpha_black_24.png"))); // NOI18N
        itemOrdenN.setText("ORDENAR POR RAZÓN SOCIAL");
        itemOrdenN.setBorder(null);
        itemOrdenN.setOpaque(true);
        itemOrdenN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemOrdenNActionPerformed(evt);
            }
        });
        jMenu1.add(itemOrdenN);

        jSeparator2.setForeground(new java.awt.Color(204, 204, 204));
        jSeparator2.setOpaque(true);
        jMenu1.add(jSeparator2);

        itemExportar.setBackground(new java.awt.Color(255, 255, 255));
        itemExportar.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        itemExportar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/baseline_move_to_inbox_black_24.png"))); // NOI18N
        itemExportar.setText("EXPORTAR INFORMACIÓN A EXCEL");
        itemExportar.setBorder(null);
        itemExportar.setOpaque(true);
        itemExportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemExportarActionPerformed(evt);
            }
        });
        jMenu1.add(itemExportar);

        jSeparator3.setForeground(new java.awt.Color(204, 204, 204));
        jSeparator3.setOpaque(true);
        jMenu1.add(jSeparator3);

        itemSalir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_DOWN_MASK));
        itemSalir.setBackground(new java.awt.Color(255, 255, 255));
        itemSalir.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        itemSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/outline_exit_to_app_black_24.png"))); // NOI18N
        itemSalir.setText("SALIR");
        itemSalir.setBorder(null);
        itemSalir.setOpaque(true);
        itemSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemSalirActionPerformed(evt);
            }
        });
        jMenu1.add(itemSalir);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator4)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        // TODO add your handling code here:
        String cod = txtBuscar.getText();
        CabecerasTablas.limpiarTablas(tablaClientes);
        controlCliente.filtClientes(tablaClientes, cod);

    }//GEN-LAST:event_txtBuscarKeyReleased

    private void itemOrdenNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemOrdenNActionPerformed
        // TODO add your handling code here:
        CabecerasTablas.limpiarTablas(tablaClientes);
        controlCliente.listClientes(tablaClientes, "clientes.cli_razonsocial");
    }//GEN-LAST:event_itemOrdenNActionPerformed

    private void itemSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemSalirActionPerformed
        // TODO add your handling code here:
        btnSalirActionPerformed(null);
    }//GEN-LAST:event_itemSalirActionPerformed

    private void itemNuevoEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemNuevoEActionPerformed
        // TODO add your handling code here:
        btnNuevoPActionPerformed(null);
    }//GEN-LAST:event_itemNuevoEActionPerformed

    private void tablaClientesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaClientesMousePressed
        // TODO add your handling code here:
        if(SwingUtilities.isRightMouseButton(evt))
        {
            Point p = evt.getPoint();
            int number = tablaClientes.rowAtPoint(p);
            ListSelectionModel modelos = tablaClientes.getSelectionModel();
            modelos.setSelectionInterval(number, number);
        }
    }//GEN-LAST:event_tablaClientesMousePressed

    private void itemModificarEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemModificarEActionPerformed
        // TODO add your handling code here:
        btnModificarPActionPerformed(null);
    }//GEN-LAST:event_itemModificarEActionPerformed

    private void itemEliminarEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemEliminarEActionPerformed
        // TODO add your handling code here:
        btnEliminarPActionPerformed(null);
    }//GEN-LAST:event_itemEliminarEActionPerformed

    private void itemOrdenCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemOrdenCActionPerformed
        // TODO add your handling code here:
        CabecerasTablas.limpiarTablas(tablaClientes);        
        controlCliente.listClientes(tablaClientes, "clientes.cli_codigo");
    }//GEN-LAST:event_itemOrdenCActionPerformed

    private void itemPModificarPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemPModificarPActionPerformed
        // TODO add your handling code here:
        btnModificarPActionPerformed(null);
    }//GEN-LAST:event_itemPModificarPActionPerformed

    private void itemPEliminarPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemPEliminarPActionPerformed
        // TODO add your handling code here:
        btnEliminarPActionPerformed(null);
    }//GEN-LAST:event_itemPEliminarPActionPerformed

    private void tablaClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaClientesMouseClicked
        // TODO add your handling code here:
        if(evt.getClickCount() == 2)
        {
            try {
                dlgGestClientes cli = new dlgGestClientes(null, true);
                cli.setLocationRelativeTo(null);
                controlCliente.aModificar();
                cli.setTitle("Modificación de Cliente");
                dlgGestClientes.btnModificar.setEnabled(true);
                dlgGestClientes.itemModificar.setEnabled(true);
                dlgGestClientes.btnGuardar.setEnabled(false);
                dlgGestClientes.itemGuardar.setEnabled(false);
                dlgGestClientes.btnNuevo.setEnabled(false);
                dlgGestClientes.itemNuevo.setEnabled(false);
                dlgGestClientes.btnCancelar.setEnabled(true);
                dlgGestClientes.itemCancelar.setEnabled(true);
                cli.setVisible(true);
        } catch (Exception e) {
            Mensajes.informacion("No se pudo cargar información del Cliente");
        }
        }
    }//GEN-LAST:event_tablaClientesMouseClicked

    private void cbkBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbkBuscarActionPerformed
        // TODO add your handling code here:
        habilitarbusqueda();
    }//GEN-LAST:event_cbkBuscarActionPerformed

    private void itemExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemExportarActionPerformed
        // TODO add your handling code here:
        try {
            Export = new clsExportarExcel();
            Export.exportarExcel(tablaClientes);
        } catch (IOException ex) {
            Logger.getLogger(dlgClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_itemExportarActionPerformed

    private void txtBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyTyped
        // TODO add your handling code here:
        char c=evt.getKeyChar();
        if(Character.isLowerCase(c)){
            String cad=(""+c).toUpperCase();
            c=cad.charAt(0);
            evt.setKeyChar(c);
        }
        int limite=199;
        if (txtBuscar.getText().length()== limite)
        {
            evt.consume();
        }
    }//GEN-LAST:event_txtBuscarKeyTyped

    private void txtBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            tablaClientes.requestFocus();
            int r=tablaClientes.getRowCount ();
            tablaClientes.changeSelection ( tablaClientes.getRowCount ()-r, 5, false, false );
        }
    }//GEN-LAST:event_txtBuscarKeyPressed

    private void tablaClientesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tablaClientesKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                dlgGestClientes cli = new dlgGestClientes(null, true);
                cli.setLocationRelativeTo(null);
                controlCliente.aModificar();
                cli.setTitle("Modificación de Cliente");
                dlgGestClientes.btnModificar.setEnabled(true);
                dlgGestClientes.itemModificar.setEnabled(true);
                dlgGestClientes.btnGuardar.setEnabled(false);
                dlgGestClientes.itemGuardar.setEnabled(false);
                dlgGestClientes.btnNuevo.setEnabled(false);
                dlgGestClientes.itemNuevo.setEnabled(false);
                dlgGestClientes.btnCancelar.setEnabled(true);
                dlgGestClientes.itemCancelar.setEnabled(true);
                cli.setVisible(true);
        } catch (Exception e) {
            Mensajes.informacion("No se pudo cargar información del Cliente"+e.getMessage());
        }
        }
    }//GEN-LAST:event_tablaClientesKeyPressed

    private void btnNuevoPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoPActionPerformed
        // TODO add your handling code here:
        dlgGestClientes cli = new dlgGestClientes(null, true);
        cli.setLocationRelativeTo(null);
        cli.setTitle("Agregar Cliente");
        cli.setVisible(true);
    }//GEN-LAST:event_btnNuevoPActionPerformed

    private void btnEliminarPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarPActionPerformed
        // TODO add your handling code here:
        if (tablaClientes.getSelectedRow() < 0) {
            Mensajes.informacion("Seleccione un fila de la tabla");
        } else {
            try {
                int resp = JOptionPane.showConfirmDialog(this, "¿Seguro que desea eliminar el registro?", "Eliminar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (resp == JOptionPane.YES_OPTION) {
                    controlCliente.delCliente();
                    CabecerasTablas.limpiarTablas(tablaClientes);
                    controlCliente.listClientes(tablaClientes, "clientes.cli_codigo");
                }
            } catch (Exception e) {
                //Mensajes.informacion("Seleccione un fila de la tabla");
            }
        }
    }//GEN-LAST:event_btnEliminarPActionPerformed

    private void btnModificarPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarPActionPerformed
        // TODO add your handling code here:
        try {
            dlgGestClientes cli = new dlgGestClientes(null, true);
            cli.setLocationRelativeTo(null);
            controlCliente.aModificar();
            cli.setTitle("Modificación de Cliente");
            dlgGestClientes.btnModificar.setEnabled(true);
            dlgGestClientes.itemModificar.setEnabled(true);
            dlgGestClientes.btnGuardar.setEnabled(false);
            dlgGestClientes.itemGuardar.setEnabled(false);
            dlgGestClientes.btnNuevo.setEnabled(false);
            dlgGestClientes.itemNuevo.setEnabled(false);
            dlgGestClientes.btnCancelar.setEnabled(true);
            dlgGestClientes.itemCancelar.setEnabled(true);
            cli.setVisible(true);
        } catch (Exception e) {
            Mensajes.informacion("Seleccione un fila de la tabla");
        }
    }//GEN-LAST:event_btnModificarPActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        int rpta = Mensajes.confirmar("¿Seguro que desea salir del formulario?");
        if (rpta == 0) {
            try{
                controlCliente.listClientes(tbDetalle, "clientes.cli_codigo");
            }catch(Exception e){}
            try{
                cabe.buscarCliente(dlgBuscarCliente.tbDetalle);
                CabecerasTablas.limpiarTablas(dlgBuscarCliente.tbDetalle);
                controlCliente.listClientes(dlgBuscarCliente.tbDetalle, "clientes.cli_codigo");
                dlgBuscarCliente.txtBuscar.requestFocus();
            }catch(Exception e){}
            
            this.dispose();
        }
    }//GEN-LAST:event_btnSalirActionPerformed

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarActionPerformed

    void habilitarbusqueda(){
        if(cbkBuscar.isSelected()){
            txtBuscar.setEnabled(true);
            txtBuscar.requestFocus();
        }else{
            txtBuscar.setEnabled(false);
            txtBuscar.setText("");
            CabecerasTablas.limpiarTablas(tablaClientes);
            controlCliente.listClientes(tablaClientes, "clientes.cli_codigo");
        }
    }
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
    private newscomponents.RSButtonBigIcon_new btnEliminarP;
    private newscomponents.RSButtonBigIcon_new btnModificarP;
    private newscomponents.RSButtonBigIcon_new btnNuevoP;
    private newscomponents.RSButtonBigIcon_new btnSalir;
    private javax.swing.JCheckBox cbkBuscar;
    private javax.swing.JMenuItem itemEliminarE;
    private javax.swing.JMenuItem itemExportar;
    private javax.swing.JMenuItem itemModificarE;
    private javax.swing.JMenuItem itemNuevoE;
    private javax.swing.JMenuItem itemOrdenC;
    private javax.swing.JMenuItem itemOrdenN;
    private javax.swing.JMenuItem itemPEliminarP;
    private javax.swing.JMenuItem itemPModificarP;
    private javax.swing.JMenuItem itemSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    public static javax.swing.JTable tablaClientes;
    public static javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
