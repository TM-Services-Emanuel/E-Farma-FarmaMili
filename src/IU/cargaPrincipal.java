package IU;

public class cargaPrincipal extends javax.swing.JFrame {

    public cargaPrincipal() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rSCheckBox1 = new rojerusan.RSCheckBox();
        rSDateChooser1 = new rojeru_san.rsdate.RSDateChooser();
        jPanel2 = new javax.swing.JPanel();
        PnlNuevo1 = new rojeru_san.rspanel.RSPanelImage();
        btn1 = new RSMaterialComponent.RSButtonIconUno();
        Separador5 = new javax.swing.JSeparator();
        LabelTitulo5 = new javax.swing.JLabel();
        PnlModificar1 = new rojeru_san.rspanel.RSPanelImage();
        btN3 = new RSMaterialComponent.RSButtonIconUno();
        Separador6 = new javax.swing.JSeparator();
        LabelTitulo6 = new javax.swing.JLabel();
        PnlActualizar = new rojeru_san.rspanel.RSPanelImage();
        btn6 = new RSMaterialComponent.RSButtonIconUno();
        Separador7 = new javax.swing.JSeparator();
        LabelTitulo7 = new javax.swing.JLabel();
        PnlEliminarG = new rojeru_san.rspanel.RSPanelImage();
        btn7 = new RSMaterialComponent.RSButtonIconUno();
        Separador8 = new javax.swing.JSeparator();
        LabelTitulo8 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        PnlNuevo = new rojeru_san.rspanel.RSPanelImage();
        btn = new RSMaterialComponent.RSButtonIconUno();
        Separador1 = new javax.swing.JSeparator();
        LabelTitulo1 = new javax.swing.JLabel();
        PnlModificar = new rojeru_san.rspanel.RSPanelImage();
        btN2 = new RSMaterialComponent.RSButtonIconUno();
        Separador2 = new javax.swing.JSeparator();
        LabelTitulo2 = new javax.swing.JLabel();
        PnlGuardar = new rojeru_san.rspanel.RSPanelImage();
        btn3 = new RSMaterialComponent.RSButtonIconUno();
        Separador3 = new javax.swing.JSeparator();
        LabelTitulo3 = new javax.swing.JLabel();
        PnlCancelar = new rojeru_san.rspanel.RSPanelImage();
        btn4 = new RSMaterialComponent.RSButtonIconUno();
        Separador4 = new javax.swing.JSeparator();
        LabelTitulo4 = new javax.swing.JLabel();
        PnlEliminar = new rojeru_san.rspanel.RSPanelImage();
        btn5 = new RSMaterialComponent.RSButtonIconUno();
        Separador = new javax.swing.JSeparator();
        LabelTitulo = new javax.swing.JLabel();
        btnSalir = new RSMaterialComponent.RSButtonIconUno();
        rSComboBox1 = new RSMaterialComponent.RSComboBox();
        jPanel3 = new javax.swing.JPanel();
        PnlNuevo2 = new rojeru_san.rspanel.RSPanelImage();
        btn2 = new RSMaterialComponent.RSButtonIconUno();
        Separador9 = new javax.swing.JSeparator();
        LabelTitulo9 = new javax.swing.JLabel();
        PnlGuardar1 = new rojeru_san.rspanel.RSPanelImage();
        btn8 = new RSMaterialComponent.RSButtonIconUno();
        Separador11 = new javax.swing.JSeparator();
        LabelTitulo11 = new javax.swing.JLabel();
        PnlCancelar1 = new rojeru_san.rspanel.RSPanelImage();
        btn9 = new RSMaterialComponent.RSButtonIconUno();
        Separador12 = new javax.swing.JSeparator();
        LabelTitulo12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        rSCheckBox1.setForeground(new java.awt.Color(0, 0, 0));
        rSCheckBox1.setText("rSCheckBox1");

        rSDateChooser1.setColorBackground(new java.awt.Color(51, 51, 51));
        rSDateChooser1.setColorButtonHover(new java.awt.Color(17, 35, 46));
        rSDateChooser1.setColorForeground(new java.awt.Color(0, 0, 0));
        rSDateChooser1.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        rSDateChooser1.setFormatoFecha("dd/MM/yyyy");
        rSDateChooser1.setFuente(new java.awt.Font("Roboto", 1, 11)); // NOI18N

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PnlNuevo1.setImagen(new javax.swing.ImageIcon(getClass().getResource("/Recursos/CONTENEDOR2.png"))); // NOI18N
        PnlNuevo1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn1.setBackground(new java.awt.Color(0, 102, 0));
        btn1.setBackgroundHover(new java.awt.Color(255, 255, 255));
        btn1.setForegroundHover(new java.awt.Color(0, 102, 0));
        btn1.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.ADD);
        btn1.setRippleColor(java.awt.Color.white);
        btn1.setTypeBorder(RSMaterialComponent.RSButtonIconUno.TYPEBORDER.CIRCLE);
        btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn1ActionPerformed(evt);
            }
        });
        PnlNuevo1.add(btn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 13, 45, 45));

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

        btN3.setBackground(new java.awt.Color(255, 102, 0));
        btN3.setBackgroundHover(new java.awt.Color(255, 255, 255));
        btN3.setForegroundHover(new java.awt.Color(255, 102, 0));
        btN3.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EDIT);
        btN3.setRippleColor(java.awt.Color.white);
        btN3.setTypeBorder(RSMaterialComponent.RSButtonIconUno.TYPEBORDER.CIRCLE);
        btN3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btN3ActionPerformed(evt);
            }
        });
        PnlModificar1.add(btN3, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 13, 45, 45));

        Separador6.setForeground(new java.awt.Color(204, 204, 204));
        PnlModificar1.add(Separador6, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 66, 76, 3));

        LabelTitulo6.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        LabelTitulo6.setForeground(new java.awt.Color(17, 35, 46));
        LabelTitulo6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelTitulo6.setText("MODIFICAR");
        PnlModificar1.add(LabelTitulo6, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 71, 76, -1));

        jPanel2.add(PnlModificar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 3, 100, 100));

        PnlActualizar.setImagen(new javax.swing.ImageIcon(getClass().getResource("/Recursos/CONTENEDOR2.png"))); // NOI18N
        PnlActualizar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn6.setBackground(new java.awt.Color(0, 153, 255));
        btn6.setBackgroundHover(new java.awt.Color(255, 255, 255));
        btn6.setForegroundHover(new java.awt.Color(0, 153, 255));
        btn6.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.REFRESH);
        btn6.setRippleColor(java.awt.Color.white);
        btn6.setTypeBorder(RSMaterialComponent.RSButtonIconUno.TYPEBORDER.CIRCLE);
        btn6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn6ActionPerformed(evt);
            }
        });
        PnlActualizar.add(btn6, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 13, 45, 45));

        Separador7.setForeground(new java.awt.Color(204, 204, 204));
        PnlActualizar.add(Separador7, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 66, 76, 3));

        LabelTitulo7.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        LabelTitulo7.setForeground(new java.awt.Color(17, 35, 46));
        LabelTitulo7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelTitulo7.setText("ACTUALIZAR");
        PnlActualizar.add(LabelTitulo7, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 71, 76, -1));

        jPanel2.add(PnlActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(296, 3, 100, 100));

        PnlEliminarG.setImagen(new javax.swing.ImageIcon(getClass().getResource("/Recursos/CONTENEDOR2.png"))); // NOI18N
        PnlEliminarG.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn7.setBackground(new java.awt.Color(255, 0, 0));
        btn7.setBackgroundHover(new java.awt.Color(255, 255, 255));
        btn7.setForegroundHover(new java.awt.Color(255, 0, 0));
        btn7.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.DELETE);
        btn7.setRippleColor(java.awt.Color.white);
        btn7.setTypeBorder(RSMaterialComponent.RSButtonIconUno.TYPEBORDER.CIRCLE);
        btn7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn7ActionPerformed(evt);
            }
        });
        PnlEliminarG.add(btn7, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 13, 45, 45));

        Separador8.setForeground(new java.awt.Color(204, 204, 204));
        PnlEliminarG.add(Separador8, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 66, 76, 3));

        LabelTitulo8.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        LabelTitulo8.setForeground(new java.awt.Color(17, 35, 46));
        LabelTitulo8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelTitulo8.setText("ELIMINAR");
        PnlEliminarG.add(LabelTitulo8, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 71, 76, -1));

        jPanel2.add(PnlEliminarG, new org.netbeans.lib.awtextra.AbsoluteConstraints(199, 3, 100, 100));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PnlNuevo.setImagen(new javax.swing.ImageIcon(getClass().getResource("/Recursos/CONTENEDOR2.png"))); // NOI18N
        PnlNuevo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn.setBackground(new java.awt.Color(0, 102, 0));
        btn.setBackgroundHover(new java.awt.Color(255, 255, 255));
        btn.setForegroundHover(new java.awt.Color(0, 102, 0));
        btn.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.ADD);
        btn.setRippleColor(java.awt.Color.white);
        btn.setTypeBorder(RSMaterialComponent.RSButtonIconUno.TYPEBORDER.CIRCLE);
        btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActionPerformed(evt);
            }
        });
        PnlNuevo.add(btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 13, 45, 45));

        Separador1.setForeground(new java.awt.Color(204, 204, 204));
        PnlNuevo.add(Separador1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 66, 76, 3));

        LabelTitulo1.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        LabelTitulo1.setForeground(new java.awt.Color(17, 35, 46));
        LabelTitulo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelTitulo1.setText("NUEVO");
        PnlNuevo.add(LabelTitulo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 71, 76, -1));

        jPanel1.add(PnlNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 3, 100, 100));

        PnlModificar.setImagen(new javax.swing.ImageIcon(getClass().getResource("/Recursos/CONTENEDOR2.png"))); // NOI18N
        PnlModificar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btN2.setBackground(new java.awt.Color(255, 102, 0));
        btN2.setBackgroundHover(new java.awt.Color(255, 255, 255));
        btN2.setForegroundHover(new java.awt.Color(255, 102, 0));
        btN2.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EDIT);
        btN2.setRippleColor(java.awt.Color.white);
        btN2.setTypeBorder(RSMaterialComponent.RSButtonIconUno.TYPEBORDER.CIRCLE);
        btN2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btN2ActionPerformed(evt);
            }
        });
        PnlModificar.add(btN2, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 13, 45, 45));

        Separador2.setForeground(new java.awt.Color(204, 204, 204));
        PnlModificar.add(Separador2, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 66, 76, 3));

        LabelTitulo2.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        LabelTitulo2.setForeground(new java.awt.Color(17, 35, 46));
        LabelTitulo2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelTitulo2.setText("MODIFICAR");
        PnlModificar.add(LabelTitulo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 71, 76, -1));

        jPanel1.add(PnlModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 3, 100, 100));

        PnlGuardar.setImagen(new javax.swing.ImageIcon(getClass().getResource("/Recursos/CONTENEDOR2.png"))); // NOI18N
        PnlGuardar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn3.setBackground(new java.awt.Color(0, 102, 255));
        btn3.setBackgroundHover(new java.awt.Color(255, 255, 255));
        btn3.setForegroundHover(new java.awt.Color(0, 102, 0));
        btn3.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.SAVE);
        btn3.setRippleColor(java.awt.Color.white);
        btn3.setTypeBorder(RSMaterialComponent.RSButtonIconUno.TYPEBORDER.CIRCLE);
        btn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn3ActionPerformed(evt);
            }
        });
        PnlGuardar.add(btn3, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 13, 45, 45));

        Separador3.setForeground(new java.awt.Color(204, 204, 204));
        PnlGuardar.add(Separador3, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 66, 76, 3));

        LabelTitulo3.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        LabelTitulo3.setForeground(new java.awt.Color(17, 35, 46));
        LabelTitulo3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelTitulo3.setText("REGISTRAR");
        PnlGuardar.add(LabelTitulo3, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 71, 76, -1));

        jPanel1.add(PnlGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(199, 3, 100, 100));

        PnlCancelar.setImagen(new javax.swing.ImageIcon(getClass().getResource("/Recursos/CONTENEDOR2.png"))); // NOI18N
        PnlCancelar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn4.setBackground(new java.awt.Color(153, 0, 51));
        btn4.setBackgroundHover(new java.awt.Color(255, 255, 255));
        btn4.setForegroundHover(new java.awt.Color(153, 0, 51));
        btn4.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.CANCEL);
        btn4.setRippleColor(java.awt.Color.white);
        btn4.setTypeBorder(RSMaterialComponent.RSButtonIconUno.TYPEBORDER.CIRCLE);
        btn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn4ActionPerformed(evt);
            }
        });
        PnlCancelar.add(btn4, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 13, 45, 45));

        Separador4.setForeground(new java.awt.Color(204, 204, 204));
        PnlCancelar.add(Separador4, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 66, 76, 3));

        LabelTitulo4.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        LabelTitulo4.setForeground(new java.awt.Color(17, 35, 46));
        LabelTitulo4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelTitulo4.setText("CANCELAR");
        PnlCancelar.add(LabelTitulo4, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 71, 76, -1));

        jPanel1.add(PnlCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(296, 3, 100, 100));

        PnlEliminar.setImagen(new javax.swing.ImageIcon(getClass().getResource("/Recursos/CONTENEDOR2.png"))); // NOI18N
        PnlEliminar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn5.setBackground(new java.awt.Color(255, 0, 0));
        btn5.setBackgroundHover(new java.awt.Color(255, 255, 255));
        btn5.setForegroundHover(new java.awt.Color(255, 0, 0));
        btn5.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.DELETE);
        btn5.setRippleColor(java.awt.Color.white);
        btn5.setTypeBorder(RSMaterialComponent.RSButtonIconUno.TYPEBORDER.CIRCLE);
        btn5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn5ActionPerformed(evt);
            }
        });
        PnlEliminar.add(btn5, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 13, 45, 45));

        Separador.setForeground(new java.awt.Color(204, 204, 204));
        PnlEliminar.add(Separador, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 66, 76, 3));

        LabelTitulo.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        LabelTitulo.setForeground(new java.awt.Color(17, 35, 46));
        LabelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelTitulo.setText("ELIMINAR");
        PnlEliminar.add(LabelTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 71, 76, -1));

        jPanel1.add(PnlEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(393, 3, 100, 100));

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

        rSComboBox1.setForeground(new java.awt.Color(0, 0, 0));
        rSComboBox1.setColorArrow(new java.awt.Color(17, 35, 46));
        rSComboBox1.setColorBorde(new java.awt.Color(204, 204, 204));
        rSComboBox1.setColorDisabledIndexText(new java.awt.Color(255, 255, 255));
        rSComboBox1.setColorFondo(new java.awt.Color(255, 255, 255));
        rSComboBox1.setConBorde(true);
        rSComboBox1.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PnlNuevo2.setImagen(new javax.swing.ImageIcon(getClass().getResource("/Recursos/CONTENEDOR2.png"))); // NOI18N
        PnlNuevo2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn2.setBackground(new java.awt.Color(0, 102, 0));
        btn2.setBackgroundHover(new java.awt.Color(255, 255, 255));
        btn2.setForegroundHover(new java.awt.Color(0, 102, 0));
        btn2.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.ADD);
        btn2.setRippleColor(java.awt.Color.white);
        btn2.setTypeBorder(RSMaterialComponent.RSButtonIconUno.TYPEBORDER.CIRCLE);
        btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn2ActionPerformed(evt);
            }
        });
        PnlNuevo2.add(btn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 13, 45, 45));

        Separador9.setForeground(new java.awt.Color(204, 204, 204));
        PnlNuevo2.add(Separador9, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 66, 76, 3));

        LabelTitulo9.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        LabelTitulo9.setForeground(new java.awt.Color(17, 35, 46));
        LabelTitulo9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelTitulo9.setText("NUEVO");
        PnlNuevo2.add(LabelTitulo9, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 71, 76, -1));

        jPanel3.add(PnlNuevo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 3, 100, 100));

        PnlGuardar1.setImagen(new javax.swing.ImageIcon(getClass().getResource("/Recursos/CONTENEDOR2.png"))); // NOI18N
        PnlGuardar1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn8.setBackground(new java.awt.Color(0, 102, 255));
        btn8.setBackgroundHover(new java.awt.Color(255, 255, 255));
        btn8.setForegroundHover(new java.awt.Color(0, 102, 0));
        btn8.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.SAVE);
        btn8.setRippleColor(java.awt.Color.white);
        btn8.setTypeBorder(RSMaterialComponent.RSButtonIconUno.TYPEBORDER.CIRCLE);
        btn8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn8ActionPerformed(evt);
            }
        });
        PnlGuardar1.add(btn8, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 13, 45, 45));

        Separador11.setForeground(new java.awt.Color(204, 204, 204));
        PnlGuardar1.add(Separador11, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 66, 76, 3));

        LabelTitulo11.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        LabelTitulo11.setForeground(new java.awt.Color(17, 35, 46));
        LabelTitulo11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelTitulo11.setText("REGISTRAR");
        PnlGuardar1.add(LabelTitulo11, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 71, 76, -1));

        jPanel3.add(PnlGuardar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 3, 100, 100));

        PnlCancelar1.setImagen(new javax.swing.ImageIcon(getClass().getResource("/Recursos/CONTENEDOR2.png"))); // NOI18N
        PnlCancelar1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn9.setBackground(new java.awt.Color(153, 0, 51));
        btn9.setBackgroundHover(new java.awt.Color(255, 255, 255));
        btn9.setForegroundHover(new java.awt.Color(153, 0, 51));
        btn9.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.CANCEL);
        btn9.setRippleColor(java.awt.Color.white);
        btn9.setTypeBorder(RSMaterialComponent.RSButtonIconUno.TYPEBORDER.CIRCLE);
        btn9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn9ActionPerformed(evt);
            }
        });
        PnlCancelar1.add(btn9, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 13, 45, 45));

        Separador12.setForeground(new java.awt.Color(204, 204, 204));
        PnlCancelar1.add(Separador12, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 66, 76, 3));

        LabelTitulo12.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        LabelTitulo12.setForeground(new java.awt.Color(17, 35, 46));
        LabelTitulo12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelTitulo12.setText("CANCELAR");
        PnlCancelar1.add(LabelTitulo12, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 71, 76, -1));

        jPanel3.add(PnlCancelar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(199, 3, 100, 100));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(290, 290, 290)
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(186, 186, 186)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rSDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(rSCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(113, 113, 113)
                                .addComponent(rSComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(301, 301, 301)
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rSCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(rSComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(119, 119, 119)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rSDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(107, 107, 107)))
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnActionPerformed

    private void btN2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btN2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btN2ActionPerformed

    private void btn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn3ActionPerformed

    private void btn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn4ActionPerformed

    private void btn5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn5ActionPerformed

    private void btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn1ActionPerformed

    private void btN3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btN3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btN3ActionPerformed

    private void btn6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn6ActionPerformed

    private void btn7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn7ActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn2ActionPerformed

    private void btn8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn8ActionPerformed

    private void btn9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn9ActionPerformed

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
            java.util.logging.Logger.getLogger(cargaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new cargaPrincipal().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelTitulo;
    private javax.swing.JLabel LabelTitulo1;
    private javax.swing.JLabel LabelTitulo11;
    private javax.swing.JLabel LabelTitulo12;
    private javax.swing.JLabel LabelTitulo2;
    private javax.swing.JLabel LabelTitulo3;
    private javax.swing.JLabel LabelTitulo4;
    private javax.swing.JLabel LabelTitulo5;
    private javax.swing.JLabel LabelTitulo6;
    private javax.swing.JLabel LabelTitulo7;
    private javax.swing.JLabel LabelTitulo8;
    private javax.swing.JLabel LabelTitulo9;
    private rojeru_san.rspanel.RSPanelImage PnlActualizar;
    private rojeru_san.rspanel.RSPanelImage PnlCancelar;
    private rojeru_san.rspanel.RSPanelImage PnlCancelar1;
    private rojeru_san.rspanel.RSPanelImage PnlEliminar;
    private rojeru_san.rspanel.RSPanelImage PnlEliminarG;
    private rojeru_san.rspanel.RSPanelImage PnlGuardar;
    private rojeru_san.rspanel.RSPanelImage PnlGuardar1;
    private rojeru_san.rspanel.RSPanelImage PnlModificar;
    private rojeru_san.rspanel.RSPanelImage PnlModificar1;
    private rojeru_san.rspanel.RSPanelImage PnlNuevo;
    private rojeru_san.rspanel.RSPanelImage PnlNuevo1;
    private rojeru_san.rspanel.RSPanelImage PnlNuevo2;
    private javax.swing.JSeparator Separador;
    private javax.swing.JSeparator Separador1;
    private javax.swing.JSeparator Separador11;
    private javax.swing.JSeparator Separador12;
    private javax.swing.JSeparator Separador2;
    private javax.swing.JSeparator Separador3;
    private javax.swing.JSeparator Separador4;
    private javax.swing.JSeparator Separador5;
    private javax.swing.JSeparator Separador6;
    private javax.swing.JSeparator Separador7;
    private javax.swing.JSeparator Separador8;
    private javax.swing.JSeparator Separador9;
    private RSMaterialComponent.RSButtonIconUno btN2;
    private RSMaterialComponent.RSButtonIconUno btN3;
    private RSMaterialComponent.RSButtonIconUno btn;
    private RSMaterialComponent.RSButtonIconUno btn1;
    private RSMaterialComponent.RSButtonIconUno btn2;
    private RSMaterialComponent.RSButtonIconUno btn3;
    private RSMaterialComponent.RSButtonIconUno btn4;
    private RSMaterialComponent.RSButtonIconUno btn5;
    private RSMaterialComponent.RSButtonIconUno btn6;
    private RSMaterialComponent.RSButtonIconUno btn7;
    private RSMaterialComponent.RSButtonIconUno btn8;
    private RSMaterialComponent.RSButtonIconUno btn9;
    private RSMaterialComponent.RSButtonIconUno btnSalir;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private rojerusan.RSCheckBox rSCheckBox1;
    private RSMaterialComponent.RSComboBox rSComboBox1;
    private rojeru_san.rsdate.RSDateChooser rSDateChooser1;
    // End of variables declaration//GEN-END:variables
}
