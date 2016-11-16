
package editortexto;

import java.awt.Image;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.text.AttributeSet;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
/*
********************************************************************************************* 
*********************************************************************************************
** !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!  **
** !@author Inti Velasquez - Proyecto de Estructura de Datos II/Organización de Archivos!  **
** !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!  **
**                                                                                         **
** Editor de texto multi-usuario basado en el manejo de archivos por bloques de datos,     **
** utilizando herramientas para manejar los datos como: Estructuras de datos concentradas  **
** en archivos, bases de datos para el almacenamiento y facil extraccion/asimilacion de    **
** usuarios y permisos que tienen para cada archivo, y cualquier otra libreria que se      **
** considere util como Flamingo (Sin embargo, esta no se utiliza en esta aplicacion.       **
**                                                                                         **
*********************************************************************************************
*********************************************************************************************

 */
public class main extends javax.swing.JFrame {

    Connection con = null;
    Statement db = null;
    User principal = null;
    File file = null;

    int TextSize = 12;

    public main() {
        initComponents();
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectoed2?autoReconnect=true&useSSL=false", "root", "pokemon123");
            db = con.createStatement();
        } catch (SQLException e) {
            System.out.println("hola");
        }
        /*FileClass test=new FileClass(1,"Hola.txt","Desktop",null);
        String xml=test.Serialize();
        FileClass temp=test.Deserialize(xml);
        System.out.println("xml = "+xml);
        System.out.println("Deserialized = "+temp.toString()); Prueba de serializacion*/
        jlTextSize.setText(TextSize+"");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jdLogin = new javax.swing.JDialog();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tfUser = new javax.swing.JTextField();
        pwfPass = new javax.swing.JPasswordField();
        bCheckCredentials = new javax.swing.JButton();
        bExitLogin = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jdMain = new javax.swing.JDialog();
        jPanel4 = new javax.swing.JPanel();
        jtpEditorOptions = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jlTextSize = new javax.swing.JLabel();
        bUnderline = new javax.swing.JButton();
        bST = new javax.swing.JButton();
        bIncreaseSize = new javax.swing.JButton();
        bReduceSize = new javax.swing.JButton();
        bItalic = new javax.swing.JButton();
        bBold = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        bLoadFile = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        bXMLFile = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        bAlignLeft = new javax.swing.JButton();
        bAlignRight = new javax.swing.JButton();
        bAlignCenter = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tpText = new javax.swing.JTextPane();
        bLogin = new javax.swing.JButton();
        bExit = new javax.swing.JButton();

        jLabel1.setText("Usuario:");

        jLabel2.setText("Contraseña:");

        bCheckCredentials.setText("Iniciar Sesion");
        bCheckCredentials.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bCheckCredentialsMouseClicked(evt);
            }
        });

        bExitLogin.setText("Salir");
        bExitLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bExitLoginMouseClicked(evt);
            }
        });

        jLabel3.setText("Ingrese su usuario y contraseña para iniciar sesion. ");

        jLabel4.setText("Si no tiene una cuenta, Registrese en el menu principal.");

        javax.swing.GroupLayout jdLoginLayout = new javax.swing.GroupLayout(jdLogin.getContentPane());
        jdLogin.getContentPane().setLayout(jdLoginLayout);
        jdLoginLayout.setHorizontalGroup(
            jdLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jdLoginLayout.createSequentialGroup()
                .addGroup(jdLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jdLoginLayout.createSequentialGroup()
                        .addGap(198, 198, 198)
                        .addGroup(jdLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(bCheckCredentials, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bExitLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jdLoginLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jdLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jdLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jdLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(tfUser)
                                .addComponent(pwfPass, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE))
                            .addComponent(jLabel4))))
                .addContainerGap(39, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jdLoginLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
        jdLoginLayout.setVerticalGroup(
            jdLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jdLoginLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addGap(36, 36, 36)
                .addGroup(jdLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jdLoginLayout.createSequentialGroup()
                        .addComponent(tfUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                        .addGroup(jdLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pwfPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addComponent(bCheckCredentials)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bExitLogin)
                        .addGap(23, 23, 23))
                    .addGroup(jdLoginLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jdMain.setBackground(new java.awt.Color(51, 51, 255));

        jPanel4.setBackground(new java.awt.Color(0, 0, 0));
        jPanel4.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(0, 0, 153)));

        jtpEditorOptions.setBackground(new java.awt.Color(102, 102, 102));
        jtpEditorOptions.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 153), 5, true));

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));

        jlTextSize.setText("jLabel5");

        bUnderline.setBackground(new java.awt.Color(0, 0, 0));
        bUnderline.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bUnderline.setMaximumSize(new java.awt.Dimension(60, 50));
        bUnderline.setMinimumSize(new java.awt.Dimension(60, 50));
        bUnderline.setPreferredSize(new java.awt.Dimension(60, 50));
        bUnderline.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bUnderlineMouseClicked(evt);
            }
        });

        bST.setBackground(new java.awt.Color(0, 0, 0));
        bST.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bST.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bSTMouseClicked(evt);
            }
        });

        bIncreaseSize.setBackground(new java.awt.Color(0, 0, 0));
        bIncreaseSize.setForeground(new java.awt.Color(0, 0, 204));
        bIncreaseSize.setText("A ↑");
        bIncreaseSize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bIncreaseSizeMouseClicked(evt);
            }
        });

        bReduceSize.setBackground(new java.awt.Color(0, 0, 0));
        bReduceSize.setForeground(new java.awt.Color(0, 0, 204));
        bReduceSize.setText("a ↓");
        bReduceSize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bReduceSizeMouseClicked(evt);
            }
        });

        bItalic.setBackground(new java.awt.Color(0, 0, 0));
        bItalic.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bItalic.setMaximumSize(new java.awt.Dimension(60, 50));
        bItalic.setMinimumSize(new java.awt.Dimension(60, 50));
        bItalic.setPreferredSize(new java.awt.Dimension(60, 50));
        bItalic.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bItalicMouseClicked(evt);
            }
        });

        bBold.setBackground(new java.awt.Color(0, 0, 0));
        bBold.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bBold.setMaximumSize(new java.awt.Dimension(60, 50));
        bBold.setMinimumSize(new java.awt.Dimension(60, 50));
        bBold.setPreferredSize(new java.awt.Dimension(60, 50));
        bBold.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bBoldMouseClicked(evt);
            }
        });
        bBold.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBoldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(bBold, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(bItalic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(bUnderline, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(bST, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addComponent(bReduceSize)
                .addGap(18, 18, 18)
                .addComponent(bIncreaseSize, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jlTextSize, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bST, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bItalic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bUnderline, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bBold, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bReduceSize, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bIncreaseSize, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jlTextSize)))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        jtpEditorOptions.addTab("Letra", jPanel1);

        jPanel3.setBackground(new java.awt.Color(102, 102, 102));

        bLoadFile.setText("Agregar Archivo");
        bLoadFile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bLoadFileMouseClicked(evt);
            }
        });

        jButton1.setText("Asignar permisos");

        bXMLFile.setText("XML");
        bXMLFile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bXMLFileMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bLoadFile)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bXMLFile, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(365, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(bXMLFile, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
                        .addComponent(bLoadFile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        jtpEditorOptions.addTab("Archivos", jPanel3);

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));

        bAlignLeft.setBackground(new java.awt.Color(0, 0, 0));
        bAlignLeft.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        bAlignLeft.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bAlignLeftMouseClicked(evt);
            }
        });

        bAlignRight.setBackground(new java.awt.Color(0, 0, 0));
        bAlignRight.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        bAlignRight.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bAlignRightMouseClicked(evt);
            }
        });

        bAlignCenter.setBackground(new java.awt.Color(0, 0, 0));
        bAlignCenter.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        bAlignCenter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bAlignCenterMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(bAlignLeft, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bAlignRight, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bAlignCenter, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(537, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(bAlignCenter, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                    .addComponent(bAlignRight, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                    .addComponent(bAlignLeft, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        jtpEditorOptions.addTab("Formato", jPanel2);

        tpText.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 102), 5));
        jScrollPane1.setViewportView(tpText);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtpEditorOptions, javax.swing.GroupLayout.PREFERRED_SIZE, 796, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1248, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(68, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jtpEditorOptions, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jdMainLayout = new javax.swing.GroupLayout(jdMain.getContentPane());
        jdMain.getContentPane().setLayout(jdMainLayout);
        jdMainLayout.setHorizontalGroup(
            jdMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jdMainLayout.setVerticalGroup(
            jdMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bLogin.setText("Log in");
        bLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bLoginMouseClicked(evt);
            }
        });

        bExit.setText("Salir");
        bExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bExitMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(163, 163, 163)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(bLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                    .addComponent(bExit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(160, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(bLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69)
                .addComponent(bExit, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(126, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bLoginMouseClicked
        tfUser.setText("");
        pwfPass.setText("");
        jdLogin.pack();
        jdLogin.setLocationRelativeTo(this);
        jdLogin.setModal(true);
        jdLogin.setVisible(true);
    }//GEN-LAST:event_bLoginMouseClicked

    private void bCheckCredentialsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bCheckCredentialsMouseClicked
        try {
            String user = tfUser.getText();
            String password = String.valueOf(pwfPass.getPassword());
            if (!user.equals("") && !password.equals("")) {
                ResultSet usuario = db.executeQuery("select * from users where username='" + user + "' and password='" + password + "'");
                if (usuario.next()) {
                    principal = new User(usuario.getString("username"), usuario.getString("password"));
                    //JOptionPane.showMessageDialog(jdLogin, "Bienvenido " + usuario.getString(1));
                    String ser = principal.Serialize();
                    System.out.println(ser);
                    System.out.println(principal.Deserialize(ser).toString());
                    db.close();
                    jdLogin.dispose();
                    this.setVisible(false);
                    bBold.setSize(60, 50);
                    bBold.setIcon(new ImageIcon(new ImageIcon("./src/Iconos/bold.png").getImage().getScaledInstance(50, 40, Image.SCALE_SMOOTH)));
                    bItalic.setSize(60, 50);
                    bItalic.setIcon(new ImageIcon(new ImageIcon("./src/Iconos/italic.png").getImage().getScaledInstance(50, 40, Image.SCALE_SMOOTH)));
                    bUnderline.setSize(60,50);
                    bUnderline.setIcon(new ImageIcon(new ImageIcon("./src/Iconos/underline.png").getImage().getScaledInstance(50, 40, Image.SCALE_SMOOTH)));
                    bST.setSize(60, 50);
                    bST.setIcon(new ImageIcon(new ImageIcon("./src/Iconos/strikethrough.png").getImage().getScaledInstance(50, 40, Image.SCALE_SMOOTH)));
                    bAlignLeft.setSize(60,50);
                    bAlignLeft.setIcon(new ImageIcon(new ImageIcon("./src/Iconos/left-align.png").getImage().getScaledInstance(50, 40, Image.SCALE_SMOOTH)));
                    bAlignRight.setSize(60, 50);
                    bAlignRight.setIcon(new ImageIcon(new ImageIcon("./src/Iconos/right-align.png").getImage().getScaledInstance(50, 40, Image.SCALE_SMOOTH)));
                    bAlignCenter.setSize(60,50);
                    bAlignCenter.setIcon(new ImageIcon(new ImageIcon("./src/Iconos/center-align.png").getImage().getScaledInstance(50, 40, Image.SCALE_SMOOTH)));
                    //UpdateText updt=new UpdateText(tpText);
                    //updt.start(); Thread para actualizar el texto durante la edicion. Comentado por que apenas esta funcional y para realizar pruebas de las otras funcionalidades
                    jdMain.pack();//!Cambiar a un boton para que el usuario ingrese al editor cuando desee
                    jdMain.setLocationRelativeTo(this);
                    jdMain.setModal(true);
                    jdMain.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                    jdMain.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(this, "Usuario no encontrado, revise sus credenciales");
                    principal = null;

                }
            } else {
                JOptionPane.showMessageDialog(jdLogin, "Usuario y/o contraseña no pueden ser vacios");
                tfUser.setText("");
                pwfPass.setText("");
            }
        } catch (InputMismatchException | SQLException e) {
            JOptionPane.showMessageDialog(jdLogin, "Usuario no encontrado. Verifique sus credenciales o registre una cuenta primero");
        }
        tfUser.setText("");
        pwfPass.setText("");
    }//GEN-LAST:event_bCheckCredentialsMouseClicked

    private void bExitLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bExitLoginMouseClicked
        jdLogin.dispose();
    }//GEN-LAST:event_bExitLoginMouseClicked

    private void bExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bExitMouseClicked
        System.exit(0);
    }//GEN-LAST:event_bExitMouseClicked

    private void bBoldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bBoldMouseClicked
        if (tpText.getSelectedText() != null) {
            int start = tpText.getSelectionStart();
            int end = tpText.getSelectedText().length();
            StyledDocument document = (StyledDocument) tpText.getDocument();
            AttributeSet as = document.getCharacterElement(start).getAttributes();
            MutableAttributeSet mas = new SimpleAttributeSet(as.copyAttributes());
            StyleConstants.setBold(mas, !StyleConstants.isBold(as));//toggle bold/negrita
            document.setCharacterAttributes(start, end, mas, true);//setear estilo
        }
    }//GEN-LAST:event_bBoldMouseClicked

    private void bItalicMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bItalicMouseClicked
        if (tpText.getSelectedText() != null) {
            int start = tpText.getSelectionStart();
            int end = tpText.getSelectedText().length();
            StyledDocument document = (StyledDocument) tpText.getDocument();
            AttributeSet as = document.getCharacterElement(start).getAttributes();
            MutableAttributeSet mas = new SimpleAttributeSet(as.copyAttributes());
            StyleConstants.setItalic(mas, !StyleConstants.isItalic(as));//toggle letra italica
            document.setCharacterAttributes(start, end, mas, true);//setear estilo
        }
    }//GEN-LAST:event_bItalicMouseClicked

    private void bSTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bSTMouseClicked
        if (tpText.getSelectedText() != null) {
            int start = tpText.getSelectionStart();
            int end = tpText.getSelectedText().length();
            StyledDocument document = (StyledDocument) tpText.getDocument();
            AttributeSet as = document.getCharacterElement(start).getAttributes();
            MutableAttributeSet mas = new SimpleAttributeSet(as.copyAttributes());
            StyleConstants.setStrikeThrough(mas, !StyleConstants.isStrikeThrough(as));//toggle linea cruzada     
            document.setCharacterAttributes(start, end, mas, true);//setear estilo
        }
    }//GEN-LAST:event_bSTMouseClicked

    private void bIncreaseSizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bIncreaseSizeMouseClicked
        if (TextSize < 24) {
            TextSize += 2;
            MutableAttributeSet mas = tpText.getInputAttributes();
            StyleConstants.setFontSize(mas, TextSize);
            jlTextSize.setText(TextSize + "");
        }
    }//GEN-LAST:event_bIncreaseSizeMouseClicked

    private void bReduceSizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bReduceSizeMouseClicked
        if (TextSize > 6) {
            TextSize -= 2;
            MutableAttributeSet mas = tpText.getInputAttributes();
            StyleConstants.setFontSize(mas, TextSize);
            jlTextSize.setText(TextSize + "");
            
        }
    }//GEN-LAST:event_bReduceSizeMouseClicked

    private void bLoadFileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bLoadFileMouseClicked

    }//GEN-LAST:event_bLoadFileMouseClicked

    private void bBoldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBoldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bBoldActionPerformed

    private void bAlignLeftMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bAlignLeftMouseClicked
        if(tpText.getSelectedText()!=null){
            int start=tpText.getSelectionStart();
            int end=tpText.getSelectionEnd();
            StyledDocument sd=tpText.getStyledDocument();
            MutableAttributeSet SAS =tpText.getInputAttributes();
            StyleConstants.setAlignment(SAS, StyleConstants.ALIGN_LEFT);
            sd.setParagraphAttributes(start,end,SAS, true);
        
        }
    }//GEN-LAST:event_bAlignLeftMouseClicked

    private void bAlignRightMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bAlignRightMouseClicked
        if(tpText.getSelectedText()!=null){
            int start=tpText.getSelectionStart();
            int end=tpText.getSelectionEnd();
            StyledDocument sd=tpText.getStyledDocument();
            MutableAttributeSet SAS =tpText.getInputAttributes();
            StyleConstants.setAlignment(SAS, StyleConstants.ALIGN_RIGHT);
            sd.setParagraphAttributes(start,end,SAS, true);
        
        }
    }//GEN-LAST:event_bAlignRightMouseClicked

    private void bAlignCenterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bAlignCenterMouseClicked
        if(tpText.getSelectedText()!=null){
            int start=tpText.getSelectionStart();
            int end=tpText.getSelectionEnd();
            StyledDocument sd=tpText.getStyledDocument();
            MutableAttributeSet MAS =tpText.getInputAttributes();
            StyleConstants.setAlignment(MAS, StyleConstants.ALIGN_CENTER);
            sd.setParagraphAttributes(start,end,MAS, true);
        
        }
    }//GEN-LAST:event_bAlignCenterMouseClicked

    private void bUnderlineMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bUnderlineMouseClicked
        if (tpText.getSelectedText() != null) {
            int start = tpText.getSelectionStart();
            int end = tpText.getSelectedText().length();
            StyledDocument document = (StyledDocument) tpText.getDocument();
            AttributeSet as = document.getCharacterElement(start).getAttributes();
            MutableAttributeSet mas = new SimpleAttributeSet(as.copyAttributes());
            StyleConstants.setUnderline(mas, !StyleConstants.isUnderline(as));//toggle linea cruzada     
            document.setCharacterAttributes(start, end, mas, true);//setear estilo
        }

    }//GEN-LAST:event_bUnderlineMouseClicked

    private void bXMLFileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bXMLFileMouseClicked
        String texto=tpText.getText();
        int size=texto.length();
        boolean remaining=size > 0;
        float asd=(float)size/(float)15;
        int cuantos=(int)Math.ceil(asd);
        byte[][] bytes=new byte[cuantos][15];
        int pos=0;
        // !TERMINAR: falta hacerlo bien para crear los bloques de bytes adecuados para ser considerados una 'pagina'
        while(remaining){
            System.out.println(pos);
            if(size>=15){
                String sub=texto.substring(0, 15);
                System.out.println("Sub: "+sub);
                bytes[pos]=sub.getBytes(Charset.forName("UTF-8"));
                texto=texto.substring(15, texto.length());
                
            }else if(size>0&&size<15){
                String sub=texto.substring(0, texto.length());
                System.out.println("sub menos de 15: "+sub);
                bytes[pos]=sub.getBytes(Charset.forName("UTF-8"));
                texto="";
            }
            if(pos<cuantos)
                    pos++;
            size=texto.length();
            remaining=size>0;
        }
        System.out.println("===================== PRUEBA =======================");
        System.out.println("----------------------------------------------------\n");
        for (int i = 0; i < cuantos; i++) {
            System.out.println(Arrays.toString(bytes[i]));
        }
        FileClass prueba=new FileClass(1,"Prueba.txt","Desktop",bytes);
        String ser=prueba.Serialize();
        System.out.println("Serializado: "+ser);
        prueba=new FileClass();
        prueba=prueba.Deserialize(ser);
        System.out.println("Deserializado: "+prueba.toString());
        for (int i = 0; i < cuantos; i++) {
            try {
                String trans=new String(prueba.getSections()[i],"UTF-8");
                System.out.println(trans);
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_bXMLFileMouseClicked

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new main().setVisible(true);
            }
        });
    }  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAlignCenter;
    private javax.swing.JButton bAlignLeft;
    private javax.swing.JButton bAlignRight;
    private javax.swing.JButton bBold;
    private javax.swing.JButton bCheckCredentials;
    private javax.swing.JButton bExit;
    private javax.swing.JButton bExitLogin;
    private javax.swing.JButton bIncreaseSize;
    private javax.swing.JButton bItalic;
    private javax.swing.JButton bLoadFile;
    private javax.swing.JButton bLogin;
    private javax.swing.JButton bReduceSize;
    private javax.swing.JButton bST;
    private javax.swing.JButton bUnderline;
    private javax.swing.JButton bXMLFile;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JDialog jdLogin;
    private javax.swing.JDialog jdMain;
    private javax.swing.JLabel jlTextSize;
    private javax.swing.JTabbedPane jtpEditorOptions;
    private javax.swing.JPasswordField pwfPass;
    private javax.swing.JTextField tfUser;
    private javax.swing.JTextPane tpText;
    // End of variables declaration//GEN-END:variables
}
