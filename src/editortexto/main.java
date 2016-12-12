package editortexto;

import com.sun.glass.events.KeyEvent;
import com.sun.org.apache.xml.internal.security.exceptions.Base64DecodingException;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import com.sun.org.apache.xml.internal.security.utils.Base64;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import javax.swing.text.Utilities;
import javax.swing.text.html.HTML;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import org.jsoup.Jsoup;

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
    FileClass curr = null;
    File CurrentFile = null;
    DefaultTreeModel original = null;
    int TextSize = 12;
    ArrayList<Block> blocks = null;

    public main() {
        initComponents();
        blocks = new ArrayList();
        tpText.setText("");
        this.setLocationRelativeTo(null);
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectoed2?autoReconnect=true&useSSL=false", "root", "pokemon123");
            db = con.createStatement();
        } catch (SQLException e) {
            System.out.println("hola");
        }
        try {
            File asd = new File("./ftptemp");
            if (!asd.exists()) {
                asd.mkdir();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        jlTextSize.setText(TextSize + "");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jdLogin = new javax.swing.JDialog();
        jPanel5 = new javax.swing.JPanel();
        tfUser = new javax.swing.JTextField();
        pwfPass = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        bCheckCredentials = new javax.swing.JButton();
        bExitLogin = new javax.swing.JButton();
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
        jPanel2 = new javax.swing.JPanel();
        bAlignLeft = new javax.swing.JButton();
        bAlignRight = new javax.swing.JButton();
        bAlignCenter = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        bLoadFile = new javax.swing.JButton();
        bSave = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tpText = new javax.swing.JTextPane();
        jlLogo = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtAdmin = new javax.swing.JTree();
        bClose = new javax.swing.JButton();
        bLogout = new javax.swing.JButton();
        jpmAdminFiles = new javax.swing.JPopupMenu();
        jmiAbrir = new javax.swing.JMenuItem();
        jmiPermiso = new javax.swing.JMenuItem();
        jmiDelete = new javax.swing.JMenuItem();
        jmiExport = new javax.swing.JMenuItem();
        jdPermisos = new javax.swing.JDialog();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        tfPermisosFileName = new javax.swing.JTextField();
        cbListUsers = new javax.swing.JComboBox<>();
        jButton3 = new javax.swing.JButton();
        bReadOnly = new javax.swing.JButton();
        bReadWrite = new javax.swing.JButton();
        jdExport = new javax.swing.JDialog();
        jPanel6 = new javax.swing.JPanel();
        jlName = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        taExport = new javax.swing.JTextArea();
        bFTP = new javax.swing.JButton();
        rbDoc = new javax.swing.JRadioButton();
        rbDocx = new javax.swing.JRadioButton();
        rbRTF = new javax.swing.JRadioButton();
        rbXML = new javax.swing.JRadioButton();
        bExportfile = new javax.swing.JButton();
        rbExport = new javax.swing.ButtonGroup();
        bLogin = new javax.swing.JButton();
        bExit = new javax.swing.JButton();

        jPanel5.setBackground(new java.awt.Color(51, 51, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));

        pwfPass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                pwfPassKeyPressed(evt);
            }
        });

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

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfUser, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pwfPass, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(65, 65, 65))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(191, 191, 191)
                        .addComponent(bCheckCredentials, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(226, 226, 226)
                        .addComponent(bExitLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(28, 28, 28)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pwfPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(28, 28, 28)
                .addComponent(bCheckCredentials)
                .addGap(18, 18, 18)
                .addComponent(bExitLogin)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jdLoginLayout = new javax.swing.GroupLayout(jdLogin.getContentPane());
        jdLogin.getContentPane().setLayout(jdLoginLayout);
        jdLoginLayout.setHorizontalGroup(
            jdLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jdLoginLayout.setVerticalGroup(
            jdLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jdMain.setBackground(new java.awt.Color(51, 51, 255));

        jPanel4.setBackground(new java.awt.Color(5, 5, 35));
        jPanel4.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(0, 0, 153)));

        jtpEditorOptions.setBackground(new java.awt.Color(102, 102, 102));
        jtpEditorOptions.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 102), 5, true));

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

        jPanel3.setBackground(new java.awt.Color(102, 102, 102));

        bLoadFile.setText("Abrir Archivo");
        bLoadFile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bLoadFileMouseClicked(evt);
            }
        });

        bSave.setText("Guardar");
        bSave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bSaveMouseClicked(evt);
            }
        });

        jButton1.setText("Generar reportes");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bLoadFile)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bSave, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(358, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(bSave, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
                        .addComponent(bLoadFile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        jtpEditorOptions.addTab("Archivos", jPanel3);

        tpText.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 102), 5, true));
        tpText.setContentType("text/html"); // NOI18N
        tpText.setText("<html>\r\n  <head>\r\n\r\n  </head>\r\n  <body>\r\n    <p>\r\n      \r\n    </p>\r\n  </body>\r\n</html>\r\n"); // NOI18N
        tpText.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tpTextMouseClicked(evt);
            }
        });
        tpText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tpTextKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tpTextKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(tpText);

        jtAdmin.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 102), 5, true));
        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("Archivos");
        javax.swing.tree.DefaultMutableTreeNode treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Tus Archivos");
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Archivos Compartidos");
        javax.swing.tree.DefaultMutableTreeNode treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Solo Lectura");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Solo Escritura");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Lectura y Escritura");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        jtAdmin.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jtAdmin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtAdminMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jtAdmin);

        bClose.setText("Exit");
        bClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bCloseMouseClicked(evt);
            }
        });

        bLogout.setText("Log out");
        bLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bLogoutMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jlLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jtpEditorOptions, javax.swing.GroupLayout.PREFERRED_SIZE, 796, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                        .addComponent(bClose, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(123, 123, 123))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1078, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jtpEditorOptions, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(jlLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(bLogout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bClose, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jdMainLayout = new javax.swing.GroupLayout(jdMain.getContentPane());
        jdMain.getContentPane().setLayout(jdMainLayout);
        jdMainLayout.setHorizontalGroup(
            jdMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jdMainLayout.setVerticalGroup(
            jdMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jmiAbrir.setText("jMenuItem1");
        jmiAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiAbrirActionPerformed(evt);
            }
        });
        jpmAdminFiles.add(jmiAbrir);

        jmiPermiso.setText("Compartir");
        jmiPermiso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiPermisoActionPerformed(evt);
            }
        });
        jpmAdminFiles.add(jmiPermiso);

        jmiDelete.setText("Borrar");
        jpmAdminFiles.add(jmiDelete);

        jmiExport.setText("jMenuItem1");
        jmiExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiExportActionPerformed(evt);
            }
        });
        jpmAdminFiles.add(jmiExport);

        jLabel5.setText("Usuario: ");

        jLabel6.setText("Elija al usuario al que desee darle permisos de este archivo");

        jLabel7.setText("Archivo:");

        tfPermisosFileName.setEditable(false);

        jButton3.setText("Cancelar");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });

        bReadOnly.setText("Lectura");
        bReadOnly.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bReadOnlyMouseClicked(evt);
            }
        });

        bReadWrite.setText("Lectura y Escritura");
        bReadWrite.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bReadWriteMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jdPermisosLayout = new javax.swing.GroupLayout(jdPermisos.getContentPane());
        jdPermisos.getContentPane().setLayout(jdPermisosLayout);
        jdPermisosLayout.setHorizontalGroup(
            jdPermisosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jdPermisosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jdPermisosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jdPermisosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfPermisosFileName)
                    .addComponent(cbListUsers, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(28, 28, 28))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jdPermisosLayout.createSequentialGroup()
                .addGap(136, 136, 136)
                .addComponent(bReadOnly, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(bReadWrite)
                .addContainerGap(65, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jdPermisosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(106, 106, 106))
        );
        jdPermisosLayout.setVerticalGroup(
            jdPermisosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jdPermisosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGap(46, 46, 46)
                .addGroup(jdPermisosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(tfPermisosFileName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jdPermisosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cbListUsers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addGroup(jdPermisosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bReadWrite)
                    .addComponent(bReadOnly))
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addGap(32, 32, 32))
        );

        jPanel6.setBackground(new java.awt.Color(30, 100, 230));
        jPanel6.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 102)));

        jlName.setText("File Name");

        taExport.setColumns(20);
        taExport.setRows(5);
        jScrollPane3.setViewportView(taExport);

        bFTP.setText("Subir a FTP (XML)");
        bFTP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bFTPMouseClicked(evt);
            }
        });

        rbExport.add(rbDoc);
        rbDoc.setText("Doc");

        rbExport.add(rbDocx);
        rbDocx.setText("Docx");

        rbExport.add(rbRTF);
        rbRTF.setText("RTF");

        rbExport.add(rbXML);
        rbXML.setText("XML");

        bExportfile.setText("Exportar");
        bExportfile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bExportfileMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(81, 81, 81)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(bFTP, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(rbDoc, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(rbDocx, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(rbRTF, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(rbXML, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(bExportfile, javax.swing.GroupLayout.Alignment.LEADING)))
                    .addComponent(jlName))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jlName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(bFTP, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57)
                        .addComponent(rbDoc)
                        .addGap(18, 18, 18)
                        .addComponent(rbDocx)
                        .addGap(18, 18, 18)
                        .addComponent(rbRTF)
                        .addGap(18, 18, 18)
                        .addComponent(rbXML)
                        .addGap(35, 35, 35)
                        .addComponent(bExportfile)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jdExportLayout = new javax.swing.GroupLayout(jdExport.getContentPane());
        jdExport.getContentPane().setLayout(jdExportLayout);
        jdExportLayout.setHorizontalGroup(
            jdExportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jdExportLayout.setVerticalGroup(
            jdExportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 102, Short.MAX_VALUE)
                .addComponent(bExit, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(93, 93, 93))
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
        Login();
    }//GEN-LAST:event_bCheckCredentialsMouseClicked

    private void bExitLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bExitLoginMouseClicked
        jdLogin.dispose();
        if (!this.isVisible()) {
            try {
                if (!db.isClosed()) {
                    db.executeUpdate("update users set connected=0 where ID=" + principal.getId());
                    db.close();
                } else {
                    db = con.createStatement();
                    db.executeUpdate("update users set connected=0 where ID=" + principal.getId());
                    db.close();
                }
                if (!con.isClosed()) {
                    con.close();
                }
            } catch (SQLException e) {
                System.exit(1);
            } finally {
                System.exit(0);
            }
        }

    }//GEN-LAST:event_bExitLoginMouseClicked

    private void bExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bExitMouseClicked
        try {
            if (!db.isClosed()) {
                db.close();
                db = null;
            }
            if (!con.isClosed()) {
                con.close();
                con = null;
            }
        } catch (SQLException e) {

        }
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
        } else {
            StyledDocument document = (StyledDocument) tpText.getDocument();
            AttributeSet as = document.getCharacterElement(0).getAttributes();
            MutableAttributeSet mas = new SimpleAttributeSet(as.copyAttributes());
            StyleConstants.setBold(mas, !StyleConstants.isBold(as));

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
        try {
            JFileChooser chooser = new JFileChooser("Open File");

            chooser.setFileFilter(new FileNameExtensionFilter("Text", "txt", "docx", "xml"));
            chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            int op = chooser.showOpenDialog(jdMain);
            if (op == JFileChooser.APPROVE_OPTION) {
                CurrentFile = chooser.getSelectedFile();

                try (FileReader fr = new FileReader(CurrentFile); BufferedReader br = new BufferedReader(fr)) {
                    String Text = "";
                    tpText.setText("");
                    Document doc = tpText.getDocument();
                    String line;
                    while ((line = br.readLine()) != null) {
                        doc.insertString(doc.getLength(), line, null);
                        Text += line + "\n";
                    }
                    int id = -1;
                    try {
                        if (db.isClosed()) {
                            db = con.createStatement();
                        }
                        ResultSet HighestID = db.executeQuery("select ID from files order by ID desc limit 1");
                        if (HighestID.next()) {
                            id = HighestID.getInt(1);
                        }
                    } catch (SQLException ErrorRetrieving) {
                        ErrorRetrieving.printStackTrace();
                    }
                    curr = new FileClass();
                    curr.setName(CurrentFile.getName());
                    if (id != -1) {
                        id += 1;
                    }
                    curr.setID(id);
                    curr.setText(Text);
                }
            }
        } catch (NullPointerException | IOException | BadLocationException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_bLoadFileMouseClicked

    private void bAlignLeftMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bAlignLeftMouseClicked
        if (tpText.getSelectedText() != null) {
            int start = tpText.getSelectionStart();
            int end = tpText.getSelectionEnd();
            StyledDocument sd = tpText.getStyledDocument();
            MutableAttributeSet MAS = tpText.getInputAttributes();
            StyleConstants.setAlignment(MAS, StyleConstants.ALIGN_LEFT);
            sd.setParagraphAttributes(start, end, MAS, true);
        }
    }//GEN-LAST:event_bAlignLeftMouseClicked

    private void bAlignRightMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bAlignRightMouseClicked
        if (tpText.getSelectedText() != null) {
            int start = tpText.getSelectionStart();
            int end = tpText.getSelectionEnd();
            StyledDocument sd = tpText.getStyledDocument();
            MutableAttributeSet MAS = tpText.getInputAttributes();
            StyleConstants.setAlignment(MAS, StyleConstants.ALIGN_RIGHT);
            sd.setParagraphAttributes(start, end, MAS, true);
        }
    }//GEN-LAST:event_bAlignRightMouseClicked

    private void bAlignCenterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bAlignCenterMouseClicked
        if (tpText.getSelectedText() != null) {
            int start = tpText.getSelectionStart();
            int end = tpText.getSelectionEnd();
            StyledDocument sd = tpText.getStyledDocument();
            MutableAttributeSet MAS = tpText.getInputAttributes();
            StyleConstants.setAlignment(MAS, StyleConstants.ALIGN_CENTER);
            sd.setParagraphAttributes(start, end, MAS, true);
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

    private void jtAdminMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtAdminMouseClicked
        if (SwingUtilities.isRightMouseButton(evt)) {
            jtAdmin.setSelectionRow(jtAdmin.getClosestRowForLocation(evt.getX(), evt.getY()));

            if (jtAdmin.getSelectionPath().getParentPath().getLastPathComponent().toString().equals("Tus Archivos")) {

                jmiPermiso.setEnabled(true);
                jmiDelete.setEnabled(true);
                jpmAdminFiles.show(jtAdmin, evt.getX(), evt.getY());

            } else if (jtAdmin.getSelectionPath().getParentPath().getLastPathComponent().toString().equalsIgnoreCase("Solo Lectura") || jtAdmin.getSelectionPath().getParentPath().getLastPathComponent().toString().equalsIgnoreCase("Lectura y Escritura")) {
                jmiPermiso.setEnabled(false);
                jmiDelete.setEnabled(false);
                jpmAdminFiles.show(jtAdmin, evt.getX(), evt.getY());
            }
        }
    }//GEN-LAST:event_jtAdminMouseClicked

    private void jmiPermisoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiPermisoActionPerformed
        try {
            DefaultComboBoxModel model = new DefaultComboBoxModel();
            if (db == null) {
                db = con.createStatement();
            }
            if (curr == null) {
                curr = (FileClass) ((DefaultMutableTreeNode) jtAdmin.getSelectionPath().getLastPathComponent()).getUserObject();

            }
            ResultSet rs = db.executeQuery("select user from users where ID!=" + principal.getId());
            while (rs.next()) {
                model.addElement(rs.getString("user"));
            }
            cbListUsers.setModel(model);
            tfPermisosFileName.setText(((FileClass) ((DefaultMutableTreeNode) jtAdmin.getSelectionPath().getLastPathComponent()).getUserObject()).getName());
            jdPermisos.pack();
            jdPermisos.setLocationRelativeTo(null);
            jdPermisos.setModal(true);
            jdPermisos.setVisible(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jmiPermisoActionPerformed

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        jdPermisos.dispose();
    }//GEN-LAST:event_jButton3MouseClicked

    private void pwfPassKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pwfPassKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            Login();
        }
    }//GEN-LAST:event_pwfPassKeyPressed

    private void bCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bCloseMouseClicked
        try {
            if (db.isClosed() || db == null) {
                db = con.createStatement();
                db.executeUpdate("update users set connected=0 where ID=" + principal.getId() + " limit 1");
            }
        } catch (SQLException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (db != null) {
            try {
                if (!db.isClosed()) {
                    db.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                db = null;
            }
        }
        if (con != null) {
            try {
                if (!con.isClosed()) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                con = null;
            }
        }
        System.exit(0);
    }//GEN-LAST:event_bCloseMouseClicked

    private void bSaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bSaveMouseClicked
        try {
            FileClass toSave = new FileClass(3, "LUL", tpText.getText());

            String text = tpText.getText();
            System.out.println(text);
            String[] parts = text.split("</p>");
            for (int i = 0; i < parts.length; i++) {
                System.out.println(i + "  \n" + parts[i] + "\n");
            }
            byte[][] bytes = new byte[parts.length][];
            String encoded = "";
            System.out.println("Partes: " + parts.length);
            System.out.println("BYTES:\n");

            for (int i = 0; i < parts.length; i++) {
                bytes[i] = parts[i].getBytes("UTF-8");
                encoded += Base64.encode(bytes[i]);
                System.out.println(Arrays.toString(bytes[i]));
            }

            System.out.println("CODIFICADO: \n" + encoded);
            com.sun.org.apache.xml.internal.security.Init.init();
            byte[] decoded = Base64.decode(encoded);
            System.out.println("\n\nDESCODIFICADO: \n" + Arrays.toString(decoded));
            String transformed = new String(decoded, "UTF-8");
            System.out.println("TRANSFORMADO:\n" + transformed);
            if (transformed.equals(encoded)) {
                System.out.println("YEP");
            }
            String xml = toSave.Serialize();
            System.out.println(xml);
            if (db == null || db.isClosed()) {
                db = con.createStatement();
            }
//            curr.setText(text);

            //db.executeUpdate("insert into files(Name,XML,OwnerID) values('" + curr.getName() + "',' " /*+ xml*/ + "'," + principal.getId() + ")");
        } catch (SQLException | Base64DecodingException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_bSaveMouseClicked

    private void bReadOnlyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bReadOnlyMouseClicked
        AssignPermit(1);
    }//GEN-LAST:event_bReadOnlyMouseClicked

    private void bReadWriteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bReadWriteMouseClicked
        AssignPermit(2);
    }//GEN-LAST:event_bReadWriteMouseClicked

    private void bLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bLogoutMouseClicked
        try {
            db.executeUpdate("update users set connected=0 where ID=" + principal.getId() + " limit 1");
            if (!db.isClosed()) {
                db.close();
            }
            if (!con.isClosed()) {
                con.close();
            }
            if (jdPermisos.isVisible()) {
                jdPermisos.dispose();
            }
            jdMain.dispose();
            tfUser.setText("");
            pwfPass.setText("");
            original.reload();
            jtAdmin.setModel(original);

            jdLogin.setVisible(true);
        } catch (SQLException e) {

        }
    }//GEN-LAST:event_bLogoutMouseClicked

    private void jmiAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiAbrirActionPerformed
        try {
            tpText.setEditable(true);
            TextSize = 12;

            curr = (FileClass) ((DefaultMutableTreeNode) jtAdmin.getSelectionPath().getLastPathComponent()).getUserObject();
            System.out.println(curr.toString());
            tpText.setText(curr.getText());
            if (db.isClosed()) {
                db = con.createStatement();
            }
            System.out.println("curr: " + curr.getID());
            ResultSet getPermit = db.executeQuery("select Type from permissions where FileID=" + curr.getID());
            if (getPermit.next()) {
                System.out.println("get permit: " + getPermit.getInt(1));
                if (getPermit.getInt(1) == 1) {
                    tpText.setEditable(false);
                } else {
                    tpText.setEditable(true);
                }
            } else {
                System.out.println("nope");
                tpText.setEditable(false);
            }
        } catch (Exception e) {

        }
    }//GEN-LAST:event_jmiAbrirActionPerformed

    private void tpTextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tpTextMouseClicked
        if (SwingUtilities.isRightMouseButton(evt)) {
            String text = tpText.getText();

            org.jsoup.nodes.Document doc = Jsoup.parse(text);
            for (int i = 0; i < doc.getAllElements().size(); i++) {
                System.out.println(i + ", " + doc.getAllElements().get(i).toString());
            }
            System.out.println("----------------------------------------------------------");
            if ("    <p>".equals("    <" + HTML.Tag.P + ">")) {
                System.out.println("holiwis");
            }
            String[] split = text.split("\n");
            ArrayList<String> lineas = new ArrayList();
            System.out.println("ORIGINAL\n-------------------------------------------------------------");
            for (int i = 0; i < split.length; i++) {
                System.out.println(split[i]);
            }
            System.out.println("==================================================");
            for (int i = 0; i < split.length; i++) {
                System.out.println("SPLIT[I]: " + split[i]);
                if (split[i].equals("<" + HTML.Tag.P + ">")) {
                    System.out.println("primero: " + i + ", " + split[i]);
                } else if (split[i].equals("    <" + HTML.Tag.P + ">")) {
                    System.out.println("segundo: " + i + ", " + split[i]);
                }
            }
            System.out.println("--------------------------------------------    ");
            for (int i = 0; i < split.length; i++) {
                if (split[i].equals("<p>")) {
                    String Actuelle = split[i + 1];
                    if (Actuelle.contains("<i>") || Actuelle.contains("<b>") || Actuelle.contains("<strike>") || Actuelle.contains("<u>")) {
                        if (Actuelle.contains("</i>") || Actuelle.contains("</b>") || Actuelle.contains("</strike>") || Actuelle.contains("</u>")) {

                        } else if (split[i + 2].contains("</i>") || split[i + 2].contains("</b>") || split[i + 2].contains("</strike>") || split[i + 2].contains("</u>")) {

                        }
                    }
                    System.out.println(lineas.get(lineas.size() - 1));
                }
            }
        } else {
            /*try {
                int row = RowNum();
                Document doc = tpText.getDocument();
                String[] texto = doc.getText(0, doc.getLength()).split("\n");
                Block[] bloques = new Block[texto.length];
                for (int i = 0; i < texto.length; i++) {
                    bloques[i] = new Block(i, false, texto[i]);
                }
                bloques[3].setModifiying(true);
                bloques[5].setModifiying(true);
                if (bloques[row].isModifiying()) {
                    JOptionPane.showMessageDialog(jdMain, "Bloqueado");
                    tpText.setFocusable(false);
                    tpText.setFocusable(true);
                }
            } catch (BadLocationException ex) {
                Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
            }*/
        }
    }//GEN-LAST:event_tpTextMouseClicked

    private void tpTextKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tpTextKeyPressed
        /*try {
            String[] lines = tpText.getDocument().getText(0, tpText.getDocument().getLength()).split("\n");
            System.out.println(Arrays.toString(lines));
            if (KeyEvent.VK_ENTER != evt.getKeyCode()) {

                int row = RowNum();
                if (Arrays.toString(lines).equals(Arrays.toString(lines))) {
                    blocks.add(new Block(0, true, ""));
                }
                blocks.get(row).setText(lines[row]);

            } else {
                int row = RowNum();
                System.out.println("ROW TYPED: " + row);
                System.out.println(lines.length);
                if (row == lines.length) {
                    blocks.add(new Block(row, true, ""));
                    blocks.get(row - 1).setModifiying(false);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }//GEN-LAST:event_tpTextKeyPressed

    private void tpTextKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tpTextKeyTyped
        /*try {
            String[] t = tpText.getDocument().getText(0, tpText.getDocument().getLength()).split("\n");
            int row = RowNum();
            System.out.println("T: " + t.length);
            if (t[row].equals("")) {
                blocks.add(new Block(row, true, ""));
            }else if(KeyEvent.VK_ENTER==evt.getKeyCode()){
                int row=RowNum();
                System.out.println("ROW TYPED: "+row);
                if(row>t.split("\n").length){
                    System.out.println("fugg naw");
                    blocks.add(new Block(row,true,""));
                    blocks.get(row-1).setModifiying(false);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }//GEN-LAST:event_tpTextKeyTyped

    private void bExportfileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bExportfileMouseClicked

        if (rbDoc.isSelected()) {
            JFileChooser chooser = new JFileChooser();
            chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            chooser.setDialogTitle("Elija el directorio a donde exportar");
            chooser.setAcceptAllFileFilterUsed(false);

            int op = chooser.showOpenDialog(jdExport);
            if (op == JFileChooser.APPROVE_OPTION) {
                try {
                    File dir = chooser.getSelectedFile();
                    String name = curr.getName().substring(0, curr.getName().indexOf("."));
                    FileWriter fos = new FileWriter(new File(dir.getPath() + "\\" + name + ".doc"));
                    BufferedWriter bos = new BufferedWriter(fos);
                    bos.write(curr.getText());
                    bos.close();
                    fos.close();
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(jdExport, "Ocurrio un error exportando el documento.\nVerifique el directorio por el archivo");
                }
            }
        } else if (rbDocx.isSelected()) {
            try {
                String text = tpText.getDocument().getText(0, tpText.getDocument().getLength());
                tpText.setContentType("text/rtf");
                tpText.setText(text);
                FileClass temp = new FileClass(curr.getID(), curr.getName(), "");
                System.out.println(tpText.getText());
                tpText.setContentType("text/html");
            } catch (BadLocationException ex) {
                Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (rbRTF.isSelected()) {

        } else if (rbXML.isSelected()) {
            try {
                JFileChooser chooser = new JFileChooser();
                chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                chooser.setDialogTitle("Elija el directorio a donde exportar");
                chooser.setAcceptAllFileFilterUsed(false);

                int op = chooser.showOpenDialog(jdExport);
                if (op == JFileChooser.APPROVE_OPTION) {
                    File file = chooser.getSelectedFile();
                    String name = curr.getName().substring(0, curr.getName().indexOf("."));

                    JAXBContext context = JAXBContext.newInstance(FileClass.class);
                    Marshaller m = context.createMarshaller();
                    m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
                    m.marshal(curr, new File(file.getAbsolutePath() + "/" + name + ".xml"));
                }
            } catch (JAXBException e) {
                JOptionPane.showMessageDialog(jdExport, "Ocurrio un error exportando el documento.\nVerifique el directorio por el archivo");
            }
        }
    }//GEN-LAST:event_bExportfileMouseClicked

    private void jmiExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiExportActionPerformed
        jdExport.setLocationRelativeTo(jdMain);
        jdExport.pack();
        jdExport.setModal(true);
        rbXML.setSelected(false);
        rbRTF.setSelected(false);
        rbDoc.setSelected(false);
        rbDocx.setSelected(false);
        curr = curr = (FileClass) ((DefaultMutableTreeNode) jtAdmin.getSelectionPath().getLastPathComponent()).getUserObject();

        taExport.setText(curr.toString());
        jlName.setText(curr.getName());
        jdExport.setVisible(true);
    }//GEN-LAST:event_jmiExportActionPerformed

    private void bFTPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bFTPMouseClicked
        try {

            File dir = new File("./ftptemp");
            if (!dir.exists()) {
                dir.mkdir();
            }
            String name = curr.getName().substring(0, curr.getName().indexOf("."));
            JAXBContext context = JAXBContext.newInstance(FileClass.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            m.marshal(curr, new File("./ftptemp/" + name + ".xml"));
            URL url = new URL("ftp://UsuarioOA%40webbpa.com:Seccion25@ftp.webbpa.com/" + name + ".xml");
            URLConnection conn = url.openConnection();
            OutputStream os = conn.getOutputStream();
            FileInputStream is = new FileInputStream(new File("./ftptemp/" + name + ".xml"));
            byte[] buffer = new byte[30];
            int BytesRead = -1;
            while ((BytesRead = is.read(buffer)) != -1) {
                os.write(buffer, 0, BytesRead);
            }
            is.close();
            os.close();
            dir = new File("./ftptemp/" + name + ".xml");
            dir.delete();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_bFTPMouseClicked

    public void AssignPermit(int PermitToAssign) {
        try {
            if (db == null) {
                db = con.createStatement();
            }
            String name = cbListUsers.getSelectedItem().toString();
            String Permit = "";
            if (PermitToAssign == 2) {
                Permit = "Permiso de Escritura";
            } else {
                Permit = "Permiso de solo Lectura";
            }
            ResultSet getID = db.executeQuery("select ID from users where user='" + name + "'");
            if (getID.next()) {
                int UserID = getID.getInt("ID");
                getID.close();
                if (curr == null) {
                    curr = (FileClass) ((DefaultMutableTreeNode) jtAdmin.getSelectionPath().getLastPathComponent()).getUserObject();
                }
                ResultSet check = db.executeQuery("select ID,Type from permissions where OwnerID=" + principal.getId() + " and UserID=" + UserID + " and FileID=" + curr.getID() + " limit 1");
                if (check.next()) {
                    int checkType = check.getInt("Type");
                    int PermitID = check.getInt("ID");
                    check.close();
                    if (checkType > PermitToAssign) {
                        int decide = JOptionPane.showConfirmDialog(jdPermisos, "\tEl usuario " + name + " tiene permisos completos en el archivo.\nDesea actualizar el permiso a solo lectura?", "Confirme su elección", JOptionPane.YES_NO_OPTION);
                        if (decide == JOptionPane.YES_OPTION) {
                            db.executeUpdate("update permissions set Type=" + PermitToAssign + " where ID=" + PermitID + " limit 1");
                            JOptionPane.showMessageDialog(jdPermisos, Permit + " asignado con exito a " + name);
                            //jdPermisos.dispose();
                        }
                    } else if (checkType == PermitToAssign) {
                        JOptionPane.showMessageDialog(jdPermisos, "El usuario " + name + " ya tiene ese permiso en el archivo");
                    } else {
                        db.executeUpdate("update permissions set Type=" + PermitToAssign + " where ID=" + PermitID + " limit 1");
                        JOptionPane.showMessageDialog(jdPermisos, Permit + " asignado con exito a " + name);

                    }
                    //check.close();
                } else {
                    check.close();
                    db.executeUpdate("insert into permissions(OwnerID,UserID,Type,FileID) values(" + principal.getId() + "," + UserID + "," + PermitToAssign + "," + curr.getID() + ")");
                    JOptionPane.showMessageDialog(jdPermisos, Permit + " asignado con exito");
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(jdPermisos, "Ocurrio un error en la aplicacion de los permisos");
        }

    }

    public int RowNum() {
        try {
            Document doc = tpText.getDocument();
            String texto2 = doc.getText(0, doc.getLength());
            int caretPos = tpText.getCaretPosition();
            int rowNum = (caretPos == 0) ? 1 : 0;
            for (int offset = caretPos; offset > 0;) {
                offset = Utilities.getRowStart(tpText, offset) - 1;
                rowNum++;
            }
            if (rowNum > 0) {
                rowNum--;
            }
            System.out.println("Row: " + rowNum);
            return rowNum;
        } catch (BadLocationException ex) {
            ex.printStackTrace();
            return -1;
        }

    }

    public void Login() {
        try {
            String user = tfUser.getText();
            String password = String.valueOf(pwfPass.getPassword());

            if (!user.equals("") && !password.equals("")) {
                if (con.isClosed()) {
                    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectoed2?autoReconnect=true&useSSL=false", "root", "pokemon123");
                }
                if (db.isClosed()) {
                    db = con.createStatement();
                }

                ResultSet usuario = db.executeQuery("select * from users where user='" + user + "' and pass='" + password + "'");

                if (usuario.next()) {
                    if (usuario.getInt("connected") == 1) {
                        System.out.println("ya conectado");
                    }
                    principal = new User(usuario.getString("user"), usuario.getString("pass"), usuario.getInt("ID"));
                    usuario.close();

                    db.executeUpdate("update users set connected=1 where ID=" + principal.getId() + " limit 1");
                    jdLogin.dispose();
                    this.setVisible(false);
                    bBold.setSize(60, 50);
                    bBold.setIcon(new ImageIcon(new ImageIcon("./src/Iconos/bold.png").getImage().getScaledInstance(50, 40, Image.SCALE_SMOOTH)));
                    bItalic.setSize(60, 50);
                    bItalic.setIcon(new ImageIcon(new ImageIcon("./src/Iconos/italic.png").getImage().getScaledInstance(50, 40, Image.SCALE_SMOOTH)));
                    bUnderline.setSize(60, 50);
                    bUnderline.setIcon(new ImageIcon(new ImageIcon("./src/Iconos/underline.png").getImage().getScaledInstance(50, 40, Image.SCALE_SMOOTH)));
                    bST.setSize(60, 50);
                    bST.setIcon(new ImageIcon(new ImageIcon("./src/Iconos/strikethrough.png").getImage().getScaledInstance(50, 40, Image.SCALE_SMOOTH)));
                    bAlignLeft.setSize(60, 50);
                    bAlignLeft.setIcon(new ImageIcon(new ImageIcon("./src/Iconos/left-align.png").getImage().getScaledInstance(50, 40, Image.SCALE_SMOOTH)));
                    bAlignRight.setSize(60, 50);
                    bAlignRight.setIcon(new ImageIcon(new ImageIcon("./src/Iconos/right-align.png").getImage().getScaledInstance(50, 40, Image.SCALE_SMOOTH)));
                    bAlignCenter.setSize(60, 50);
                    bAlignCenter.setIcon(new ImageIcon(new ImageIcon("./src/Iconos/center-align.png").getImage().getScaledInstance(50, 40, Image.SCALE_SMOOTH)));
                    original = new DefaultTreeModel(new DefaultMutableTreeNode("Archivos"));
                    DefaultMutableTreeNode root1 = (DefaultMutableTreeNode) original.getRoot();
                    original.insertNodeInto(new DefaultMutableTreeNode("Tus Archivos"), root1, 0);
                    original.insertNodeInto(new DefaultMutableTreeNode("Archivos compartidos"), root1, 1);
                    original.insertNodeInto(new DefaultMutableTreeNode("Solo Lectura"), (DefaultMutableTreeNode) root1.getChildAt(1), 0);
                    original.insertNodeInto(new DefaultMutableTreeNode("Lectura y Escritura"), (DefaultMutableTreeNode) root1.getChildAt(1), 1);

                    jtAdmin.setModel(original);
                    original.reload();
                    //UpdateText updt=new UpdateText(tpText);
                    //updt.start(); Thread para actualizar el texto durante la edicion. Comentado por que apenas esta funcional y para realizar pruebas de las otras funcionalidades
                    if (db == null) {
                        db = con.createStatement();
                    }
                    try {
                        DefaultTreeModel Tmodel = (DefaultTreeModel) jtAdmin.getModel();
                        DefaultMutableTreeNode root = (DefaultMutableTreeNode) Tmodel.getRoot();
                        DefaultMutableTreeNode YourFiles = (DefaultMutableTreeNode) Tmodel.getChild(root, 0);
                        DefaultMutableTreeNode shared = (DefaultMutableTreeNode) Tmodel.getChild(root, 1);
                        DefaultMutableTreeNode shared1 = (DefaultMutableTreeNode) shared.getChildAt(0);
                        DefaultMutableTreeNode shared2 = (DefaultMutableTreeNode) shared.getChildAt(1);
                        try (ResultSet GetFiles = db.executeQuery("select * from files where OwnerID=" + principal.getId())) {
                            GetFiles.last();
                            GetFiles.beforeFirst();
                            while (GetFiles.next()) {
                                YourFiles.add(new DefaultMutableTreeNode(new FileClass(GetFiles.getInt("ID"), GetFiles.getString("Name"), GetFiles.getString("XML"))));
                            }
                        }
                        Statement db2 = con.createStatement();
                        ResultSet GetPermissions = db.executeQuery("select Type,FileID from permissions where UserID=" + principal.getId());
                        while (GetPermissions.next()) {
                            try (ResultSet GetPermitFiles = db2.executeQuery("select * from files where ID=" + GetPermissions.getInt("FileID") + " limit 1")) {
                                if (GetPermitFiles.next()) {
                                    if (GetPermissions.getInt("Type") == 2) {
                                        shared2.add(new DefaultMutableTreeNode(new FileClass(GetPermitFiles.getInt("ID"), GetPermitFiles.getString("Name"), GetPermitFiles.getString("XML"))));
                                    } else {
                                        shared1.add(new DefaultMutableTreeNode(new FileClass(GetPermitFiles.getInt("ID"), GetPermitFiles.getString("Name"), GetPermitFiles.getString("XML"))));
                                    }
                                }
                            }
                        }
                        GetPermissions.close();
                        Tmodel.reload(root);
                        jtAdmin.setModel(Tmodel);
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(jdMain, "Ocurrio un error obteniendo sus archivos de la base de datos. Use la opcion 'Actualizar' del arbol");
                    }
                    jdMain.pack();
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
            JOptionPane.showMessageDialog(jdLogin, "Usuario no encontrado. Verifique sus credenciales e intente de nuevo");
        }
        tfUser.setText("");
        pwfPass.setText("");
    }

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
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(() -> {
            new main().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAlignCenter;
    private javax.swing.JButton bAlignLeft;
    private javax.swing.JButton bAlignRight;
    private javax.swing.JButton bBold;
    private javax.swing.JButton bCheckCredentials;
    private javax.swing.JButton bClose;
    private javax.swing.JButton bExit;
    private javax.swing.JButton bExitLogin;
    private javax.swing.JButton bExportfile;
    private javax.swing.JButton bFTP;
    private javax.swing.JButton bIncreaseSize;
    private javax.swing.JButton bItalic;
    private javax.swing.JButton bLoadFile;
    private javax.swing.JButton bLogin;
    private javax.swing.JButton bLogout;
    private javax.swing.JButton bReadOnly;
    private javax.swing.JButton bReadWrite;
    private javax.swing.JButton bReduceSize;
    private javax.swing.JButton bST;
    private javax.swing.JButton bSave;
    private javax.swing.JButton bUnderline;
    private javax.swing.JComboBox<String> cbListUsers;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JDialog jdExport;
    private javax.swing.JDialog jdLogin;
    private javax.swing.JDialog jdMain;
    private javax.swing.JDialog jdPermisos;
    private javax.swing.JLabel jlLogo;
    private javax.swing.JLabel jlName;
    private javax.swing.JLabel jlTextSize;
    private javax.swing.JMenuItem jmiAbrir;
    private javax.swing.JMenuItem jmiDelete;
    private javax.swing.JMenuItem jmiExport;
    private javax.swing.JMenuItem jmiPermiso;
    private javax.swing.JPopupMenu jpmAdminFiles;
    private javax.swing.JTree jtAdmin;
    private javax.swing.JTabbedPane jtpEditorOptions;
    private javax.swing.JPasswordField pwfPass;
    private javax.swing.JRadioButton rbDoc;
    private javax.swing.JRadioButton rbDocx;
    private javax.swing.ButtonGroup rbExport;
    private javax.swing.JRadioButton rbRTF;
    private javax.swing.JRadioButton rbXML;
    private javax.swing.JTextArea taExport;
    private javax.swing.JTextField tfPermisosFileName;
    private javax.swing.JTextField tfUser;
    private javax.swing.JTextPane tpText;
    // End of variables declaration//GEN-END:variables
}
