package editortexto;

import com.sun.glass.events.KeyEvent;
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
import java.util.InputMismatchException;
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
import java.awt.Color;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.Utilities;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import java.util.Collections;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.WorkbookFactory;

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
    FileClass Chosen = null;
    DefaultTreeModel original = null;
    int TextSize = 12;
    //ArrayList<Block> blocks = null;
    DefaultTableModel OriginalTable = null;   
    int OriginalRow;
    UpdateText updt=null;
    boolean newFile=false;
    
    public main() {
        initComponents();
        
        OriginalTable = (DefaultTableModel) jtReport.getModel();
        tpText.setText("");
        this.setLocationRelativeTo(null);
        jlIcon.setSize(125, 180);
        OriginalRow = -1;
        
        jlFrameIcon.setIcon(new ImageIcon(new ImageIcon("./src/Iconos/sol.png").getImage().getScaledInstance(jlFrameIcon.getWidth(), jlFrameIcon.getHeight(), Image.SCALE_SMOOTH)));
        
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectoed2?autoReconnect=true&useSSL=false", "root", "pokemon123");
            db = con.createStatement();
        } catch (SQLException ex) {
        }
        updt=new UpdateText(tpText,jtAdmin,con,false);
        updt.setAlive(false);
        updt.start();
        /*Descargar de FTP 
        try {
            URL url = new URL("ftp://UsuarioOA%40webbpa.com:Seccion25@ftp.webbpa.com/Prueba.xml");
            URLConnection conn = url.openConnection();
            InputStream ReadFTP = conn.getInputStream();
            FileOutputStream WriteFile = new FileOutputStream("C:\\Users\\Inti Velasquez\\Desktop\\ftp.xml");
            byte[] buffer = new byte[30];
            int Bytes = -1;
            while ((Bytes = ReadFTP.read(buffer)) != -1) {
                WriteFile.write(buffer, 0, Bytes);
            }
            WriteFile.flush();
            WriteFile.close();
            ReadFTP.close();
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        try {
            File ftpTemp = new File("./ftptemp");
            if (!ftpTemp.exists()) {
                ftpTemp.mkdir();
            }
        } catch (Exception e) {
        }
        jlTextSize.setText(TextSize + "");
        /*jdMain.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
        jdMain.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                
                Connect();
                try {
                    db.executeUpdate("insert into log(Date,Time,Action) values(curdate(),curtime(),'Usuario " + principal.getUsername() + " ID " + principal.getId() + " salio del sistema')");
                    db.executeUpdate("update users set connected=0 where ID=" + principal.getId() + " limit 1");
                } catch (SQLException ex) {
                    Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
                }
                Close();
                System.exit(0);
            }
        });*/
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
        jpMain = new javax.swing.JPanel();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tpText = new javax.swing.JTextPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtAdmin = new javax.swing.JTree();
        jlUser = new javax.swing.JLabel();
        jlIcon = new javax.swing.JLabel();
        jlCurrFile = new javax.swing.JLabel();
        jmbMain = new javax.swing.JMenuBar();
        jmFile = new javax.swing.JMenu();
        jmiOpenFile = new javax.swing.JMenuItem();
        jmiSave = new javax.swing.JMenuItem();
        jmOptions = new javax.swing.JMenu();
        jmiReports = new javax.swing.JMenuItem();
        jmiLog = new javax.swing.JMenuItem();
        jmLogout = new javax.swing.JMenu();
        jmiLogout = new javax.swing.JMenuItem();
        jmiExit = new javax.swing.JMenuItem();
        jpmAdminFiles = new javax.swing.JPopupMenu();
        jmiAbrir = new javax.swing.JMenuItem();
        jmiPermiso = new javax.swing.JMenuItem();
        jmiDelete = new javax.swing.JMenuItem();
        jmiExport = new javax.swing.JMenuItem();
        jmiRefresh = new javax.swing.JMenuItem();
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
        rbgExport = new javax.swing.ButtonGroup();
        jdLog = new javax.swing.JDialog();
        jpLog = new javax.swing.JPanel();
        bSaveLog = new javax.swing.JButton();
        bCloseLog = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        tpLog = new javax.swing.JTextPane();
        jdReport = new javax.swing.JDialog();
        jpReport = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jtReport = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        rbReportByName = new javax.swing.JRadioButton();
        rbReportByOwner = new javax.swing.JRadioButton();
        rbReportByDate = new javax.swing.JRadioButton();
        rbReportByTime = new javax.swing.JRadioButton();
        bGenerateReport = new javax.swing.JButton();
        checkOrder = new javax.swing.JCheckBox();
        rbSize = new javax.swing.JRadioButton();
        rbgReport = new javax.swing.ButtonGroup();
        jPanel8 = new javax.swing.JPanel();
        jlTitle = new javax.swing.JLabel();
        bLogin = new javax.swing.JButton();
        bExit = new javax.swing.JButton();
        jlFrameIcon = new javax.swing.JLabel();

        jdLogin.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        jdLogin.setTitle("Bienvenido a Sun Files!");
        jdLogin.setMinimumSize(null);
        jdLogin.setResizable(false);

        jPanel5.setBackground(new java.awt.Color(51, 51, 180));
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
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfUser, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pwfPass, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(59, 59, 59))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(226, 226, 226)
                        .addComponent(bExitLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(192, 192, 192)
                        .addComponent(bCheckCredentials, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addComponent(bCheckCredentials)
                .addGap(18, 18, 18)
                .addComponent(bExitLogin)
                .addContainerGap())
        );

        javax.swing.GroupLayout jdLoginLayout = new javax.swing.GroupLayout(jdLogin.getContentPane());
        jdLogin.getContentPane().setLayout(jdLoginLayout);
        jdLoginLayout.setHorizontalGroup(
            jdLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jdLoginLayout.setVerticalGroup(
            jdLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jdMain.setTitle("Sun Files");
        jdMain.setBackground(new java.awt.Color(51, 51, 255));
        jdMain.setResizable(false);

        jpMain.setBackground(new java.awt.Color(0, 0, 150));
        jpMain.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 102), 5));

        jtpEditorOptions.setBackground(new java.awt.Color(102, 102, 102));
        jtpEditorOptions.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 5, true));

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));

        jlTextSize.setForeground(new java.awt.Color(0, 102, 255));
        jlTextSize.setText("Textsize");

        bUnderline.setBackground(new java.awt.Color(0, 0, 0));
        bUnderline.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bUnderline.setEnabled(false);
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
        bST.setEnabled(false);
        bST.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bSTMouseClicked(evt);
            }
        });

        bIncreaseSize.setBackground(new java.awt.Color(0, 0, 0));
        bIncreaseSize.setForeground(new java.awt.Color(0, 0, 204));
        bIncreaseSize.setText("A ↑");
        bIncreaseSize.setEnabled(false);
        bIncreaseSize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bIncreaseSizeMouseClicked(evt);
            }
        });

        bReduceSize.setBackground(new java.awt.Color(0, 0, 0));
        bReduceSize.setForeground(new java.awt.Color(0, 0, 204));
        bReduceSize.setText("a ↓");
        bReduceSize.setEnabled(false);
        bReduceSize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bReduceSizeMouseClicked(evt);
            }
        });

        bItalic.setBackground(new java.awt.Color(0, 0, 0));
        bItalic.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bItalic.setEnabled(false);
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
        bBold.setEnabled(false);
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
                .addGap(18, 18, 18)
                .addComponent(bItalic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bUnderline, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bST, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bReduceSize)
                .addGap(18, 18, 18)
                .addComponent(bIncreaseSize, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jlTextSize, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(191, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bST, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bItalic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bUnderline, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
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
        bAlignLeft.setEnabled(false);
        bAlignLeft.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bAlignLeftMouseClicked(evt);
            }
        });

        bAlignRight.setBackground(new java.awt.Color(0, 0, 0));
        bAlignRight.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        bAlignRight.setEnabled(false);
        bAlignRight.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bAlignRightMouseClicked(evt);
            }
        });

        bAlignCenter.setBackground(new java.awt.Color(0, 0, 0));
        bAlignCenter.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        bAlignCenter.setEnabled(false);
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

        tpText.setEditable(false);
        tpText.setBackground(new java.awt.Color(245, 245, 245));
        tpText.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 5, true));
        tpText.setContentType("text/html"); // NOI18N
        tpText.setText("<html>\r\n  <head>\r\n\r\n  </head>\r\n  <body>\r\n    <p>\r\n    </p>\r\n  </body>\r\n</html>\r\n"); // NOI18N
        tpText.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tpTextMouseClicked(evt);
            }
        });
        tpText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tpTextKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tpText);

        jtAdmin.setBackground(new java.awt.Color(102, 102, 102));
        jtAdmin.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 5, true));
        jtAdmin.setForeground(new java.awt.Color(255, 255, 255));
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

        jlUser.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jlUser.setText("Usuario, ID");

        jlIcon.setFocusable(false);

        javax.swing.GroupLayout jpMainLayout = new javax.swing.GroupLayout(jpMain);
        jpMain.setLayout(jpMainLayout);
        jpMainLayout.setHorizontalGroup(
            jpMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpMainLayout.createSequentialGroup()
                .addGroup(jpMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpMainLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(jpMainLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jpMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlUser, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(63, 63, 63)))
                .addGroup(jpMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlCurrFile, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jtpEditorOptions, javax.swing.GroupLayout.Alignment.LEADING)))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        jpMainLayout.setVerticalGroup(
            jpMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpMainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpMainLayout.createSequentialGroup()
                        .addComponent(jtpEditorOptions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlCurrFile, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpMainLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jlIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jlUser, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 33, Short.MAX_VALUE))
        );

        jmFile.setText("Archivo");

        jmiOpenFile.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        jmiOpenFile.setText("Cargar Archivo");
        jmiOpenFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiOpenFileActionPerformed(evt);
            }
        });
        jmFile.add(jmiOpenFile);

        jmiSave.setText("Guardar");
        jmiSave.setEnabled(false);
        jmiSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiSaveActionPerformed(evt);
            }
        });
        jmFile.add(jmiSave);

        jmbMain.add(jmFile);

        jmOptions.setText("Opciones");

        jmiReports.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        jmiReports.setText("Generar reporte");
        jmiReports.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiReportsActionPerformed(evt);
            }
        });
        jmOptions.add(jmiReports);

        jmiLog.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_MASK));
        jmiLog.setText("Ver bitacora");
        jmiLog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiLogActionPerformed(evt);
            }
        });
        jmOptions.add(jmiLog);

        jmbMain.add(jmOptions);

        jmLogout.setText("Sesión");

        jmiLogout.setText("Cerrar sesion");
        jmiLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiLogoutActionPerformed(evt);
            }
        });
        jmLogout.add(jmiLogout);

        jmiExit.setText("Salir");
        jmiExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiExitActionPerformed(evt);
            }
        });
        jmLogout.add(jmiExit);

        jmbMain.add(jmLogout);

        jdMain.setJMenuBar(jmbMain);

        javax.swing.GroupLayout jdMainLayout = new javax.swing.GroupLayout(jdMain.getContentPane());
        jdMain.getContentPane().setLayout(jdMainLayout);
        jdMainLayout.setHorizontalGroup(
            jdMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jdMainLayout.setVerticalGroup(
            jdMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jmiAbrir.setText("Abrir");
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
        jmiDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiDeleteActionPerformed(evt);
            }
        });
        jpmAdminFiles.add(jmiDelete);

        jmiExport.setText("Exportar");
        jmiExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiExportActionPerformed(evt);
            }
        });
        jpmAdminFiles.add(jmiExport);

        jmiRefresh.setText("Actualizar");
        jmiRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiRefreshActionPerformed(evt);
            }
        });
        jpmAdminFiles.add(jmiRefresh);

        jdPermisos.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        jdPermisos.setTitle("Asignar permiso");
        jdPermisos.setResizable(false);

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

        jdExport.setTitle("Exportar archivos");
        jdExport.setResizable(false);

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

        rbgExport.add(rbDoc);
        rbDoc.setText("Doc");

        rbgExport.add(rbDocx);
        rbDocx.setText("Docx");

        rbgExport.add(rbRTF);
        rbRTF.setText("RTF");
        rbRTF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rbRTFMouseClicked(evt);
            }
        });

        rbgExport.add(rbXML);
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

        jdLog.setTitle("Bitacora de Actividad");
        jdLog.setBackground(new java.awt.Color(0, 51, 102));
        jdLog.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jdLog.setResizable(false);

        jpLog.setBackground(new java.awt.Color(0, 50, 120));

        bSaveLog.setText("Guardar");
        bSaveLog.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bSaveLogMouseClicked(evt);
            }
        });

        bCloseLog.setText("Cerrar");
        bCloseLog.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bCloseLogMouseClicked(evt);
            }
        });

        tpLog.setEditable(false);
        jScrollPane6.setViewportView(tpLog);

        javax.swing.GroupLayout jpLogLayout = new javax.swing.GroupLayout(jpLog);
        jpLog.setLayout(jpLogLayout);
        jpLogLayout.setHorizontalGroup(
            jpLogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpLogLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 805, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpLogLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jpLogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bSaveLog, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpLogLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(bCloseLog, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(378, 378, 378))
        );
        jpLogLayout.setVerticalGroup(
            jpLogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpLogLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 523, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bSaveLog, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bCloseLog, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7))
        );

        javax.swing.GroupLayout jdLogLayout = new javax.swing.GroupLayout(jdLog.getContentPane());
        jdLog.getContentPane().setLayout(jdLogLayout);
        jdLogLayout.setHorizontalGroup(
            jdLogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpLog, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jdLogLayout.setVerticalGroup(
            jdLogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpLog, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jdReport.setTitle("Reporte de sus archivos");

        jpReport.setBackground(new java.awt.Color(0, 0, 102));
        jpReport.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 5, true));

        jtReport.setAutoCreateRowSorter(true);
        jtReport.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Nombre", "Dueño", "Fecha de creación", "Hora de creación", "Tamaño"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtReport.setRowHeight(30);
        jScrollPane5.setViewportView(jtReport);

        jPanel4.setBackground(new java.awt.Color(0, 0, 150));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Reporte ordenado por", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 13), new java.awt.Color(204, 167, 0))); // NOI18N

        rbReportByName.setBackground(new java.awt.Color(0, 0, 150));
        rbgReport.add(rbReportByName);
        rbReportByName.setText("<html><b>Nombre</b></html>");

        rbReportByOwner.setBackground(new java.awt.Color(0, 0, 150));
        rbgReport.add(rbReportByOwner);
        rbReportByOwner.setText("<html><b>Dueño</b></html>");

        rbReportByDate.setBackground(new java.awt.Color(0, 0, 150));
        rbgReport.add(rbReportByDate);
        rbReportByDate.setText("<html><b>Fecha</b></html>");

        rbReportByTime.setBackground(new java.awt.Color(0, 0, 150));
        rbgReport.add(rbReportByTime);
        rbReportByTime.setText("<html><b>Hora</b></html>");

        bGenerateReport.setText("Generar reporte");
        bGenerateReport.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bGenerateReportMouseClicked(evt);
            }
        });

        checkOrder.setBackground(new java.awt.Color(0, 0, 150));
        checkOrder.setText("<html><b>Ascendientemente</b></html>");

        rbSize.setBackground(new java.awt.Color(0, 0, 150));
        rbgReport.add(rbSize);
        rbSize.setText("Tamaño");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(279, 279, 279)
                .addComponent(bGenerateReport)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(rbReportByName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(rbReportByOwner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(rbReportByDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(rbReportByTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rbSize)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addComponent(checkOrder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbReportByName, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbReportByOwner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbReportByDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbReportByTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkOrder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbSize))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bGenerateReport)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jpReportLayout = new javax.swing.GroupLayout(jpReport);
        jpReport.setLayout(jpReportLayout);
        jpReportLayout.setHorizontalGroup(
            jpReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpReportLayout.createSequentialGroup()
                .addGroup(jpReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpReportLayout.createSequentialGroup()
                        .addGap(267, 267, 267)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpReportLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 1130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(109, Short.MAX_VALUE))
        );
        jpReportLayout.setVerticalGroup(
            jpReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpReportLayout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(57, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jdReportLayout = new javax.swing.GroupLayout(jdReport.getContentPane());
        jdReport.getContentPane().setLayout(jdReportLayout);
        jdReportLayout.setHorizontalGroup(
            jdReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpReport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jdReportLayout.setVerticalGroup(
            jdReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpReport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 51, 153));

        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 5));
        jPanel8.setForeground(new java.awt.Color(0, 0, 102));

        jlTitle.setFont(new java.awt.Font("NSimSun", 3, 24)); // NOI18N
        jlTitle.setForeground(new java.awt.Color(255, 0, 51));
        jlTitle.setText("Sunny Files");

        bLogin.setText("Log in");
        bLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bLoginMouseClicked(evt);
            }
        });
        bLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bLoginActionPerformed(evt);
            }
        });

        bExit.setText("Salir");
        bExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bExitMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                                .addComponent(jlTitle)
                                .addGap(21, 21, 21))))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(153, 153, 153)
                        .addComponent(bExit, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addComponent(jlFrameIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(89, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(jlFrameIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bExit, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bLoginMouseClicked
        tfUser.setText("");
        pwfPass.setText("");
        jdLogin.setIconImage((new ImageIcon("./sol.png").getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH)));
        jdLogin.pack();
        jdLogin.setLocationRelativeTo(this);
        jdLogin.setModal(true);
        jdLogin.setVisible(true);
    }//GEN-LAST:event_bLoginMouseClicked

    private void bCheckCredentialsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bCheckCredentialsMouseClicked
        Login();
    }//GEN-LAST:event_bCheckCredentialsMouseClicked

    private void bExitLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bExitLoginMouseClicked
        try {
            Connect();
            db.executeUpdate("update users set connected=0 where ID=" + principal.getId());
            db.executeUpdate("insert into log(Date,Time,Action) values(curdate(),curtime(),'Usuario " + principal.getUsername() + " ID " + principal.getId() + "salió del sistema')");
        } catch (SQLException e) {
            Close();
            jdLogin.dispose();
            System.exit(1);
        } finally {
            Close();
            jdLogin.dispose();
            System.exit(0);
        }
    }//GEN-LAST:event_bExitLoginMouseClicked

    private void bExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bExitMouseClicked
        try {
            Connect();
            db.executeUpdate("insert into log(Date,Time,Action) values(curdate(),curtime(),'Usuario " + principal.getUsername() + " ID" + principal.getId() + " salio del sistema')");
            db.executeUpdate("update users set connected=0 where ID=" + principal.getId());
        } catch (SQLException e) {
            Close();
            System.exit(1);
        } finally {
            Close();
            System.exit(0);
        }
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
                Chosen = (FileClass) ((DefaultMutableTreeNode) jtAdmin.getSelectionPath().getLastPathComponent()).getUserObject();
                jmiPermiso.setEnabled(true);
                jmiDelete.setEnabled(true);
                jpmAdminFiles.show(jtAdmin, evt.getX(), evt.getY());

            } else if (jtAdmin.getSelectionPath().getParentPath().getLastPathComponent().toString().equalsIgnoreCase("Solo Lectura") || jtAdmin.getSelectionPath().getParentPath().getLastPathComponent().toString().equalsIgnoreCase("Lectura y Escritura")) {
                Chosen = (FileClass) ((DefaultMutableTreeNode) jtAdmin.getSelectionPath().getLastPathComponent()).getUserObject();
                jmiPermiso.setEnabled(false);
                jmiDelete.setEnabled(false);
                jpmAdminFiles.show(jtAdmin, evt.getX(), evt.getY());
            }
        }
    }//GEN-LAST:event_jtAdminMouseClicked

    private void jmiPermisoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiPermisoActionPerformed
        try {
            Connect();
            DefaultComboBoxModel model = new DefaultComboBoxModel();
            if (Chosen == null) {
                Chosen = (FileClass) ((DefaultMutableTreeNode) jtAdmin.getSelectionPath().getLastPathComponent()).getUserObject();
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
        } finally {
            Close();
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

    private void bReadOnlyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bReadOnlyMouseClicked
        AssignPermit(1);
    }//GEN-LAST:event_bReadOnlyMouseClicked

    private void bReadWriteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bReadWriteMouseClicked
        AssignPermit(2);
    }//GEN-LAST:event_bReadWriteMouseClicked

    private void jmiAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiAbrirActionPerformed
        try {
            Connect();
            if(!updt.isInterrupted()){
                updt.setAlive(false);
                updt.join();
                updt.interrupt();
            }
            tpText.setEditable(true);
            tpText.setText("");
            TextSize = 12;
            OriginalRow=-1;
            //ESTAS EN EL MAIN LUMBO
            if(curr!=null)
                db.executeUpdate("update blocks set UserID=-1,Editing=0 where UserID="+principal.getId()+" and FileID="+curr.getID());
            jlTextSize.setText(12 + "");
            curr = (FileClass) ((DefaultMutableTreeNode) jtAdmin.getSelectionPath().getLastPathComponent()).getUserObject();
            jlCurrFile.setText(curr.getName());
            
            ResultSet getBlocks = db.executeQuery("select * from blocks where FileID=" + curr.getID() + " order by row asc");
            ArrayList<Block> bloques = new ArrayList();
            String texto = " ";
            getBlocks.last();
            int length = getBlocks.getRow();
            getBlocks.beforeFirst();
            int cont = 0;
            while (getBlocks.next()) {
                boolean modifying = getBlocks.getInt("Editing") == 1;
                Block b = new Block(getBlocks.getInt("row"), modifying, getBlocks.getString("Text"), getBlocks.getInt("UserID"));
                bloques.add(b);
                texto += b.getText();
                if (++cont < length) {
                    texto += "\n";
                }
            }
            curr.setBlocks(bloques);
            tpText.getDocument().insertString(0, texto, tpText.getCharacterAttributes());
            if (jtAdmin.getSelectionPath().getParentPath().getLastPathComponent().toString().equals("Tus Archivos")) {
                tpText.setEditable(true);
                bBold.setEnabled(true);
                bST.setEnabled(true);
                bUnderline.setEnabled(true);
                bItalic.setEnabled(true);
                bReduceSize.setEnabled(true);
                bIncreaseSize.setEnabled(true);
                bAlignLeft.setEnabled(true);
                bAlignCenter.setEnabled(true);
                bAlignRight.setEnabled(true);
                db.executeUpdate("insert into log(Date,Time,Action) values(curdate(),curtime(),'usuario " + principal.getUsername() + " ID " + principal.getId() + " abrio el archivo " + curr.getName() + " ID " + curr.getID() + "')");
            } else {
                ResultSet getPermit = db.executeQuery("select Type from permissions where FileID=" + curr.getID());
                if (getPermit.next()) {

                    if (getPermit.getInt(1) == 1) {
                        tpText.setEditable(false);
                        bBold.setEnabled(false);
                        bST.setEnabled(false);
                        bUnderline.setEnabled(false);
                        bItalic.setEnabled(false);
                        bReduceSize.setEnabled(false);
                        bIncreaseSize.setEnabled(false);
                        bAlignLeft.setEnabled(false);
                        bAlignCenter.setEnabled(false);
                        bAlignRight.setEnabled(false);
                    } else {
                        tpText.setEditable(true);
                        bBold.setEnabled(true);
                        bST.setEnabled(true);
                        bUnderline.setEnabled(true);
                        bItalic.setEnabled(true);
                        bReduceSize.setEnabled(true);
                        bIncreaseSize.setEnabled(true);
                        bAlignLeft.setEnabled(true);
                        bAlignCenter.setEnabled(true);
                        bAlignRight.setEnabled(true);
                    }
                } else {
                    tpText.setEditable(false);
                }
                db.executeUpdate("insert into log(Date,Time,Action) values(curdate(),curtime(),'usuario " + principal.getUsername() + " ID " + principal.getId() + " abrio el archivo " + curr.getName() + " ID " + curr.getID() + "')");

            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(jdMain, "Ocurrio un error");
        } finally {
            
            Close();
            if (tpText.isEditable()) {
                updt = new UpdateText(tpText, jtAdmin, con, true);
                updt.setCurr(curr);
                updt.setUser(principal);
                updt.setOriginalRow(OriginalRow);
                updt.setAlive(true);
                updt.start();
            }
        }
    }//GEN-LAST:event_jmiAbrirActionPerformed

    private void tpTextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tpTextMouseClicked
        if (SwingUtilities.isRightMouseButton(evt)) {
            /* String text = tpText.getText();

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
            }*/

        } else if (curr != null && tpText.isEditable() && tpText.getDocument().getLength() > 0 && curr.getBlocks().size() > 0) {
            int row = RowNum();

            if (curr.getBlocks().get(row).isModifying()) {
                if (OriginalRow != -1 && OriginalRow <= curr.getBlocks().size() && OriginalRow != row) {
                    curr.getBlocks().get(OriginalRow).setModifying(false);
                }
                if (curr.getBlocks().get(row).getUser() != principal.getId()) {
                    JOptionPane.showMessageDialog(jdMain, "Bloqueado por usuario ID "+curr.getBlocks().get(row).getUser());
                    tpText.setFocusable(false);
                    tpText.setFocusable(true);
                } else {
                    OriginalRow = row;
                    updt.setOriginalRow(row);
                }
            } else {
                if (OriginalRow != -1 && OriginalRow <= curr.getBlocks().size()) {
                    curr.getBlocks().get(OriginalRow).setModifying(false);
                }
                OriginalRow = row;
                updt.setOriginalRow(row);
                curr.getBlocks().get(row).setModifying(true);
                curr.getBlocks().get(row).setUser(principal.getId());
            }
        }
    }//GEN-LAST:event_tpTextMouseClicked

    private void bExportfileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bExportfileMouseClicked
        try {
            Connect();
            JFileChooser chooser = new JFileChooser();
            chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            chooser.setDialogTitle("Elija el directorio a donde exportar");
            chooser.setAcceptAllFileFilterUsed(false);
            int op = chooser.showOpenDialog(jdExport);
            if (op == JFileChooser.APPROVE_OPTION) {
                File dir = chooser.getSelectedFile();
                String name = Chosen.getName();
                if (name.contains(".")) {
                    name = name.substring(0, Chosen.getName().indexOf("."));
                }
                if (rbDoc.isSelected()) {
                    try {
                        FileWriter fos = new FileWriter(new File(dir.getPath() + "\\" + name + ".doc"));
                        BufferedWriter bos = new BufferedWriter(fos);
                        ResultSet rs = db.executeQuery("select Text from blocks where FileID=" + Chosen.getID());
                        while (rs.next()) {
                            bos.write(rs.getString("Text") + "\n");

                        }
                        bos.close();
                        fos.close();
                        JOptionPane.showMessageDialog(jdExport, "Archivo exportado con exito");
                        try {
                            db.executeUpdate("insert into log(Date,Time,Action) values(curdate(),curtime(),'Usuario " + principal.getUsername() + " exportó el archivo " + Chosen.getName() + " ID " + Chosen.getID() + " a Doc')");
                        } catch (SQLException e) {
                            JOptionPane.showMessageDialog(jdExport, "Ocurrio un error escribiendo a la bitacora");
                        }
                    } catch (IOException e) {
                        JOptionPane.showMessageDialog(jdExport, "Ocurrio un error exportando el documento.\nVerifique el directorio por el archivo");
                    }
                } else if (rbDocx.isSelected()) {
                    XWPFDocument docu = new XWPFDocument();
                    XWPFParagraph p = docu.createParagraph();
                    XWPFRun run = p.createRun();
                    String text = "";
                    ResultSet rs = db.executeQuery("select Text from blocks where FileID=" + Chosen.getID());
                    while (rs.next()) {
                        text += rs.getString("Text") + "\n";
                    }
                    if (!text.equals("") && text.contains("\n")) {
                        text = text.substring(0, text.lastIndexOf("\n"));
                    }
                    run.setText(text);
                    try {
                        FileOutputStream fos = new FileOutputStream(new File(dir.getAbsolutePath() + "\\" + name + ".docx"));
                        docu.write(fos);
                        try {
                            db.executeUpdate("insert into log(Date,Time,Action) values(curdate(),curtime(),'Usuario " + principal.getUsername() + " exportó el archivo " + Chosen.getName() + " ID " + Chosen.getID() + " a Docx')");
                        } catch (SQLException e) {
                        }

                        fos.close();
                        JOptionPane.showMessageDialog(jdExport, "Archivo exportado con exito!");
                    } catch (IOException ex) {
                    }
                } else if (rbRTF.isSelected()) {
                    XWPFDocument docu = new XWPFDocument();
                    XWPFParagraph p = docu.createParagraph();
                    XWPFRun run = p.createRun();
                    String text = "";
                    ResultSet rs = db.executeQuery("select Text from blocks where FileID=" + Chosen.getID());
                    while (rs.next()) {
                        text += rs.getString("Text") + "\n";
                    }
                    if (!text.equals("") && text.contains("\n")) {
                        text = text.substring(0, text.lastIndexOf("\n"));
                    }
                    run.setText(text);
                    try {
                        FileOutputStream fos = new FileOutputStream(new File(dir.getAbsolutePath() + "\\" + name + ".rtf"));
                        docu.write(fos);
                        fos.close();
                        JOptionPane.showMessageDialog(jdExport, "Archivo exportado con exito!");
                        try {
                            db.executeUpdate("insert into log(Date,Time,Action) values(curdate(),curtime(),'Usuario " + principal.getUsername() + " exportó el archivo " + Chosen.getName() + " ID " + Chosen.getID() + " a RTF')");
                        } catch (SQLException e) {
                        }
                    } catch (IOException ex) {
                    }
                } else if (rbXML.isSelected()) {
                    try {
                        File file = chooser.getSelectedFile();
                        JAXBContext context = JAXBContext.newInstance(FileClass.class);
                        Marshaller m = context.createMarshaller();
                        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
                        m.marshal(Chosen, new File(file.getAbsolutePath() + "\\" + name + ".xml"));
                        JOptionPane.showMessageDialog(jdExport, "Archivo exportado con exito!");

                        try {
                            db.executeUpdate("insert into log(Date,Time,Action) values(curdate(),curtime(),'Usuario " + principal.getUsername() + " exportó el archivo " + Chosen.getName() + " ID " + Chosen.getID() + " a XML')");
                        } catch (SQLException e) {
                            JOptionPane.showMessageDialog(jdExport, "Ocurrio un error escribiendo a la base de datos");
                        }

                    } catch (JAXBException e) {
                        JOptionPane.showMessageDialog(jdExport, "Ocurrio un error exportando el documento.\nVerifique el directorio por el archivo");
                    }
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(jdExport, "Ocurrio un error");
        } finally {
            Close();
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
        Chosen = (FileClass) ((DefaultMutableTreeNode) jtAdmin.getSelectionPath().getLastPathComponent()).getUserObject();
        String app=Chosen.toString();
        Connect();
        try {
            ResultSet blocks=db.executeQuery("select Text from blocks where FileID="+Chosen.getID());
            if(blocks.next()){
                app+="\nBlocks:\n=======\n";
                blocks.beforeFirst();
            }
            
            while(blocks.next()){
                app+="\n"+blocks.getString("Text");
            }
        } catch (SQLException ex) {
        }
        
        Close();
        
        taExport.setText(app);
        jlName.setText(Chosen.getName());
        jdExport.setVisible(true);
    }//GEN-LAST:event_jmiExportActionPerformed

    private void bFTPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bFTPMouseClicked
        try {
            Connect();
            File dir = new File("./ftptemp");
            if (!dir.exists()) {
                dir.mkdir();
            }
            
            String name = Chosen.getName();
            if(name.contains("."))
                name=name.substring(0, Chosen.getName().lastIndexOf("."));
            JAXBContext context = JAXBContext.newInstance(FileClass.class);
            Marshaller m = context.createMarshaller();
                m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            m.marshal(Chosen, new File("./ftptemp/" + name + ".xml"));
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
            db.executeUpdate("insert into log(Date,Time,Action) values(curdate(),curtime(),'Usuario " + principal.getUsername() + " subió el archivo " + Chosen.getName() + " ID " + Chosen.getID() + " al FTP')");

            dir = new File("./ftptemp/" + name + ".xml");
            dir.delete();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(jdExport, "Ocurrio un error en la subida al ftp");
        } finally {
            Close();
        }
    }//GEN-LAST:event_bFTPMouseClicked

    private void jmiDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiDeleteActionPerformed
        try {
            Connect();
            Chosen = (FileClass) ((DefaultMutableTreeNode) jtAdmin.getSelectionPath().getLastPathComponent()).getUserObject();
            db.executeUpdate("delete from blocks where FileID="+Chosen.getID());

            db.executeUpdate("delete from files where ID=" + Chosen.getID() + " limit 1");
            db.executeUpdate("insert into log(Date,Time,Action) values(curdate(),curtime(),'Usuario " + principal.getUsername() + " eliminó el archivo " + Chosen.getName() + " ID " + Chosen.getID() + "')");
            RefreshTree();
            if (curr != null) {
                if (curr.getID() == Chosen.getID()) {
                    tpText.setText("");
                    tpText.setEditable(false);
                }
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(jdMain, "No se puedo eliminar el archivo. Intente abrir el archivo e intente de nuevo");
        } finally {
            Close();
        }
    }//GEN-LAST:event_jmiDeleteActionPerformed

    private void jmiLogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiLogActionPerformed
        try {
            Connect();
            tpLog.setText("");
            ResultSet GetLog = db.executeQuery("select Date,Time,Action from log");

            if (GetLog.next()) {
                String logs = "";
                logs += (GetLog.getDate("Date").toString() + ", " + GetLog.getTime("Time").toString() + ": " + GetLog.getString("Action") + "\n");
                while (GetLog.next()) {
                    logs += (GetLog.getDate("Date").toString() + ", " + GetLog.getTime("Time").toString() + ": " + GetLog.getString("Action") + "\n");

                }
                jdLog.setBackground(new Color(0, 50, 102));
                tpLog.setText(logs);
                jdLog.pack();
                jdLog.setLocationRelativeTo(jdMain);
                jdLog.setModal(true);
                jdLog.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(jdMain, "No hay registros en la bitacora");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(jdMain, "Ocurrio un error obteniendo la bitacora");
        } finally {
            Close();
        }
    }//GEN-LAST:event_jmiLogActionPerformed

    private void bSaveLogMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bSaveLogMouseClicked
        try {
            JFileChooser chooser = new JFileChooser("Elija el directorio donde guardar el log");
            chooser.setAcceptAllFileFilterUsed(false);

            chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int op = chooser.showOpenDialog(jdLog);
            if (op == JFileChooser.APPROVE_OPTION) {
                String filename = "Log.txt";
                int ext = 0;
                String dir = chooser.getSelectedFile().getAbsolutePath();
                File destino = new File(dir + "/" + filename);
                while (destino.exists()) {
                    ext++;
                    filename = "Log" + ext + ".txt";
                    destino = new File(dir + "/" + filename);
                }
                FileWriter fw = new FileWriter(destino);
                BufferedWriter bw = new BufferedWriter(fw);
                String[] logs = tpLog.getText().split("\n");
                for (int i = 0; i < logs.length; i++) {
                    bw.write(logs[i]);
                    bw.newLine();
                }
                bw.close();
                fw.close();
            }
        } catch (IOException e) {

        }
    }//GEN-LAST:event_bSaveLogMouseClicked

    private void bCloseLogMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bCloseLogMouseClicked
        jdLog.dispose();
    }//GEN-LAST:event_bCloseLogMouseClicked

    private void bLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bLoginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bLoginActionPerformed

    private void jmiReportsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiReportsActionPerformed

        DefaultTableModel modelo = (DefaultTableModel) jtReport.getModel();
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        modelo.addRow(new Object[]{"", "", "", ""});
        modelo.addRow(new Object[]{"", "", "", ""});
        modelo.addRow(new Object[]{"", "", "", ""});
        modelo.addRow(new Object[]{"", "", "", ""});
        jtReport.setModel(modelo);
        rbReportByName.setSelected(false);
        rbReportByOwner.setSelected(false);
        rbReportByDate.setSelected(false);
        rbReportByTime.setSelected(false);
        jdReport.pack();
        jdReport.setLocationRelativeTo(jdMain);
        jdReport.setModal(true);
        jdReport.setVisible(true);
    }//GEN-LAST:event_jmiReportsActionPerformed

    private void bGenerateReportMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bGenerateReportMouseClicked
        if (!rbReportByName.isSelected() && !rbReportByOwner.isSelected() && !rbReportByDate.isSelected() && !rbReportByTime.isSelected() && !rbSize.isSelected()) {
            JOptionPane.showMessageDialog(jdReport, "Elija una opcion antes de generar el reporte");
        } else {
            try {
                Connect();
                DefaultTableModel modelo = (DefaultTableModel) jtReport.getModel();
                while (modelo.getRowCount() > 0) {
                    modelo.removeRow(0);
                }

                jtReport.setModel(modelo);
                
                ResultSet getAccess = db.executeQuery("select FileID from permissions where UserID=" + principal.getId());
                String query = "select ID,Name,OwnerID,Date,Time from files where ";
                String order = checkOrder.isSelected() ? "ASC" : "DESC";
                if (getAccess.first()) {
                    query += ("ID=" + getAccess.getInt("FileID") + " ");
                    while (getAccess.next()) {
                        query += "or ID=" + getAccess.getInt("FileID") + " ";

                    }
                }
                getAccess.close();
                Close();
                query += "or OwnerID=" + principal.getId();
                if (rbReportByName.isSelected()) {
                    query += " order by Name ";
                } else if (rbReportByOwner.isSelected()) {
                    query += " order by OwnerID ";
                } else if (rbReportByDate.isSelected()) {
                    query += " order by Date ";
                } else if (rbReportByTime.isSelected()) {
                    query += " order by Time ";
                } 
                if(!rbSize.isSelected())
                    query += order;
                Connect();
                ResultSet GetFiles = db.executeQuery(query);
                DefaultTableModel model = (DefaultTableModel) jtReport.getModel();
                new WorkbookFactory();
                HSSFWorkbook wb=new HSSFWorkbook();
                int rowNum=1;
                HSSFSheet sh=wb.createSheet();
                Row row=sh.createRow(0);
                row.createCell(0).setCellValue("Nombre");
                row.createCell(1).setCellValue("Dueño");
                row.createCell(2).setCellValue("Fecha");
                row.createCell(3).setCellValue("Hora");
                row.createCell(4).setCellValue("Tamaño");
                Statement db2=con.createStatement();
                ArrayList<Integer> sizes=new ArrayList();
                ArrayList<Object[]> obs=new ArrayList();
                while (GetFiles.next()) {
                    ResultSet size=db2.executeQuery("select Text from blocks where FileID="+GetFiles.getInt("ID"));
                    int bytes=0;
                    while(size.next()){
                        bytes+=size.getString("Text").getBytes().length;
                    }
                    sizes.add(bytes);
                    size.close();
                    if(!rbSize.isSelected()){
                        model.addRow(new Object[]{GetFiles.getString("Name"), GetFiles.getInt("OwnerID") + "", GetFiles.getDate("Date").toString(), GetFiles.getTime("Time").toString(),bytes});
                    }else{
                        obs.add(new Object[]{GetFiles.getString("Name"), GetFiles.getInt("OwnerID") + "", GetFiles.getDate("Date").toString(), GetFiles.getTime("Time").toString(),bytes});
                    }
                    Row nRow=sh.createRow(rowNum);
                    nRow.createCell(0).setCellValue(GetFiles.getString("Name"));
                    nRow.createCell(1).setCellValue(GetFiles.getInt("OwnerID"));
                    nRow.createCell(2).setCellValue(GetFiles.getDate("Date").toString());
                    nRow.createCell(3).setCellValue(GetFiles.getTime("Time").toString());
                    nRow.createCell(4).setCellValue(bytes);
                    rowNum++;
                }
                GetFiles.close();
                if(rbSize.isSelected()){
                    Collections.sort(sizes);
                    Collections.reverse(sizes);
                    
                    for (Integer size : sizes) {
                        for (int i = 0; i < obs.size(); i++) {
                            if(obs.get(i)[4]==size){
                                model.addRow(obs.get(i));                                                                      
                                obs.remove(i);
                                i=900000;
                            }
                        }
                    }
                }
                try{
                    int n=1;
                    File TryName=new File("./Reporte.xls");
                    while(TryName.exists()){
                        TryName=new File("./Reporte"+n+".xls");
                        n++;
                    }
                    
                    FileOutputStream fos=new FileOutputStream(TryName);
                    wb.write(fos);
                    fos.close();
                    
                }catch(IOException e){
                }
                
                db.executeUpdate("insert into log(Date,Time,Action) values(curdate(),curtime(),'Usuario "+principal.getUsername()+" ID "+principal.getId()+" genero un report de sus archivos')");
                
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(jdReport, "Ocurrio un error al generar el reporte");
            } finally {
                Close();
            }
        }
    }//GEN-LAST:event_bGenerateReportMouseClicked

    private void rbRTFMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbRTFMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_rbRTFMouseClicked

    private void jmiRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiRefreshActionPerformed
        try {
            RefreshTree();
        } catch (SQLException ex) {
        }
    }//GEN-LAST:event_jmiRefreshActionPerformed

    private void tpTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tpTextKeyReleased
        if (tpText.isEditable()) {
            if (evt.getKeyCode() == KeyEvent.VK_DOWN) {
                RowNum();
            }
            if ((evt.getKeyCode() > 64 && evt.getKeyCode() < 91) || (evt.getKeyCode() > 96 && evt.getKeyCode() < 123) || evt.getKeyCode() == 8) {
                try {
                    int row = RowNum();
                    String[] lineas = tpText.getDocument().getText(0, tpText.getDocument().getLength()).split("\n");
                    if (row >= curr.getBlocks().size()) {
                        curr.getBlocks().add(new Block(row, true, lineas[row], principal.getId()));
                        
                        curr.getBlocks().get(row).setModified(true);
                        Connect();
                        try {
                            db.executeUpdate("insert into blocks(UserID,Text,row,FileID,Edited,Editing) values("+principal.getId()+",'"+curr.get(row).getText()+"',"+row+","+curr.getID()+",1,1)");
                        } catch (SQLException ex) {
                        }
                        
                    } else {
                        curr.getBlocks().get(row).setText(lineas[row]);
                        curr.getBlocks().get(row).setModifying(true);
                        curr.getBlocks().get(row).setModified(true);
                        curr.getBlocks().get(row).setUser(principal.getId());                        
                    }
                } catch (BadLocationException ex) {
                }
            } else if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                try {

                    int row = RowNum();
                    tpText.getDocument().insertString(tpText.getDocument().getLength(), " ", tpText.getCharacterAttributes());
                    curr.getBlocks().get(row - 1).setModifying(false);
                    OriginalRow = row;
                    Block nuevo = new Block(row, true, " ", principal.getId());
                    curr.getBlocks().add(nuevo);
                    Connect();
                    try {
                        db.executeUpdate("insert into blocks(UserID,Text,row,FileID,Edited,Editing) values(" + principal.getId() + ",' '," + row + "," + curr.getID() + ",0,1)");
                    } catch (SQLException ex) {
                    }
                    Close();
                    /*
                        System.out.println("ENTER");
                        System.out.println(tpText.getDocument().getText(0, tpText.getDocument().getLength()));
                        System.out.println("===============================");
                        String[] lineas = tpText.getDocument().getText(0, tpText.getDocument().getLength()).split("\n");
                        if (lineas.length > 0) {
                        String[] temp = new String[lineas.length - 1];
                        boolean changed = false;
                        if (lineas[0].equals("")) {
                        System.err.println("hehexd");
                        int count = 0;
                        for (int i = 1; i < lineas.length; i++) {
                        temp[count] = lineas[i];
                        count++;
                        }
                        changed = true;
                        for (int i = 0; i < temp.length; i++) {
                        System.out.println("temp[i]: " + temp[i]);
                        }
                        }
                        if (!changed) {
                        System.out.println(lineas.length);
                        for (int i = 0; i < lineas.length; i++) {
                        System.out.print(lineas[i]);
                        
                        if (lineas[i].equals("")) {
                        System.out.println(" AWILSON LO DETECTA");
                        }
                        }
                        } else {
                        System.out.println(temp.length);
                        for (int i = 0; i < temp.length; i++) {
                        System.out.print(temp[i]);
                        
                        if (temp[i].equals("")) {
                        System.out.println(" AWILSON LO DETECTA");
                        }
                        }
                        
                        }
                        System.out.println("\n--------------------------------");
                        for (int i = row; i < curr.getBlocks().size(); i++) {

                        }
                        }*/

                } catch (BadLocationException ex) {
                }
            }
        }
    }//GEN-LAST:event_tpTextKeyReleased

    private void jmiSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiSaveActionPerformed
        
        if (curr != null&&newFile) {
            String name = curr.getName();
            if (name.contains(".")) {
                name = name.substring(0, name.lastIndexOf("."));
            }            
            try {
                Connect();
                ResultSet rs = db.executeQuery("select ID from files where Name='" + name + "' limit 1");
                if (rs.next()) {
                    rs.close();
                    int op = JOptionPane.showConfirmDialog(jdMain, "Ya existe un archivo con ese nombre.\nCambiar nombre del archivo?", "El archivo ya existe!", JOptionPane.OK_CANCEL_OPTION);
                    if (op == JOptionPane.OK_OPTION) {
                        try {
                            String nName=JOptionPane.showInputDialog(jdMain, "Ingrese nuevo nombre");
                            curr.setName(nName);
                            jlCurrFile.setText(nName);
                            db.executeUpdate("insert into files(Name,OwnerID,Date,Time) values('"+nName+"',"+principal.getId()+",curdate(),curtime())");
                            //rs=db.executeQuery("select ID from files where Name='"+nName+"' and OwnerID="+principal.getId()+" order by ID asc limit 1");
                            
                           // int id=rs.getInt(1);
                            ResultSet GetNewID=db.executeQuery("select ID from files where Name='"+nName+"' and OwnerID="+principal.getId()+" limit 1");
                            int id=-1;
                            if(GetNewID.next()){
                                id=GetNewID.getInt("ID");
                            }
                            GetNewID.close();
                            curr.setID(id);
                            for (int i = 0; i < curr.getBlocks().size(); i++) {
                                int mod=1;
                                if(curr.getBlocks().get(i).isModifying()&&curr.getBlocks().get(i).getUser()==principal.getId()||curr.getBlocks().get(i).isModifying()&&curr.getBlocks().get(i).getUser()==-1){
                                    curr.getBlocks().get(i).setModifying(false);
                                    OriginalRow=-1;
                                    mod=0;
                                } 
                                db.executeUpdate("insert into blocks(UserID,Text,row,FileID,Edited,Editing) values(-1,'"+curr.get(i).getText()+"',"+i+","+curr.getID()+","+(curr.get(i).isModified()?1:0)+","+mod+")");
                            }
                        } catch (InputMismatchException e) {
                        }
                    } else {
                        JOptionPane.showMessageDialog(jdMain, "No se subio el archivo a la BD");
                    }
                } else {
                    db.executeUpdate("insert into files(Name,OwnerID,Date,Time) values('"+name+"',"+principal.getId()+",curdate(),curtime())");
                    ResultSet NID=db.executeQuery("select ID from files where Name='"+name+"' and OwnerID="+principal.getId()+" limit 1");
                    int nID=-1;
                    if(NID.next())
                        nID=NID.getInt("ID");
                    curr.setID(nID);
                    for (int i = 0; i < curr.getBlocks().size(); i++) {
                        int mod=1;
                        if(curr.getBlocks().get(i).isModifying()&&curr.getBlocks().get(i).getUser()==principal.getId()){
                            curr.getBlocks().get(i).setModifying(false);
                            OriginalRow=-1;
                            mod=0;
                        }
                        db.executeUpdate("insert into blocks(UserID,Text,row,FileID,Edited,Editing) values(-1,'"+curr.get(i).getText()+"',"+i+","+curr.getID()+","+(curr.get(i).isModified()?1:0)+","+mod+")");
                    }
                }
                RefreshTree();
            } catch (SQLException ex) {
            }finally{
                if(curr!=null){
                    if(updt.isInterrupted()){
                        updt=new UpdateText(tpText,jtAdmin,con,true);
                        updt.setUser(principal);
                        updt.setCurr(curr);
                        updt.setOriginalRow(OriginalRow);
                        updt.setActive(true);
                        updt.setAlive(true);
                        updt.start();
                    }else{
                        try {
                            updt.setAlive(false);
                            updt.join();
                            updt.interrupt();
                        } catch (InterruptedException ex) {
                        }
                        updt=new UpdateText(tpText,jtAdmin,con,true);
                        updt.setUser(principal);
                        updt.setCurr(curr);
                        updt.setOriginalRow(OriginalRow);
                        updt.setActive(true);
                        updt.setAlive(true);
                        updt.start();
                    }
                }
                Close();
            }

        }else{
        
        }
    }//GEN-LAST:event_jmiSaveActionPerformed

    private void jmiOpenFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiOpenFileActionPerformed
        try {
            Connect();
            
            JFileChooser chooser = new JFileChooser("Open File");
            chooser.setFileFilter(new FileNameExtensionFilter("Text", "txt", "xml", "docx", "doc", "rtf"));
            chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            int op = chooser.showOpenDialog(jdMain);
            if (op == JFileChooser.APPROVE_OPTION) {
                CurrentFile = chooser.getSelectedFile();
                if (CurrentFile.getName().endsWith(".doc") || CurrentFile.getName().endsWith(".txt")) {
                    try (FileReader fr = new FileReader(CurrentFile); BufferedReader br = new BufferedReader(fr)) {
                        String Text = "";
                        tpText.setText("");
                        Document doc = tpText.getDocument();
                        String line;
                        ArrayList<Block> bloques = new ArrayList();
                        int row = 0;
                        while ((line = br.readLine()) != null) {
                            doc.insertString(doc.getLength(), line, null);
                            bloques.add(new Block(row,false,line,-1));
                            
                            Text += line + "\n";
                            row++;
                        }
                        
                        curr = new FileClass();
                        String name=CurrentFile.getName();
                        if(name.contains("."))
                            name=name.substring(0,name.lastIndexOf("."));
                        curr.setName(name);
                        
                        curr.setID(-1);
                        curr.setBlocks(bloques);
                        // curr.setBlocks(blocks);
                        
                        newFile=true;
                        jmiSave.setEnabled(true);
                        tpText.setEditable(true);
                        try {
                            db.executeUpdate("insert into log(Date,Time,Action) values(curdate(),curtime(),'Usuario "+principal.getUsername()+" ID "+principal.getId()+" abrio un archivo nuevo')");
                        } catch (SQLException ex) {
                        }
                    }
                } else if (CurrentFile.getName().endsWith(".xml")) {
                    FileReader fr = new FileReader(CurrentFile);
                    BufferedReader br = new BufferedReader(fr);
                    String line;
                    String xml = "";
                    ArrayList<Block> bloques = new ArrayList();
                    int cont = 0;
                    String text="";
                    while ((line = br.readLine()) != null) {
                        xml += line;
                        
                        //bloques.add(new Block(cont, false, line, -1));
                    }                    
                    FileClass des = new FileClass();
                    FileClass lel = des.Deserialize(xml);
                    //lel.setBlocks(bloques);
                    curr = lel;
                    for (int i = 0; i < curr.size(); i++) {
                        if(i<curr.size()-1)
                            tpText.getDocument().insertString(tpText.getDocument().getLength(), curr.get(i).getText()+"\n", tpText.getCharacterAttributes());
                        else
                                                        tpText.getDocument().insertString(tpText.getDocument().getLength(), curr.get(i).getText(), tpText.getCharacterAttributes());

                    }
                    
                    newFile=true;
                    jmiSave.setEnabled(true);
                    tpText.setEditable(true);
                    try {
                            db.executeUpdate("insert into log(Date,Time,Action) values(curdate(),curtime(),'Usuario "+principal.getUsername()+" ID "+principal.getId()+" abrio un archivo nuevo')");
                        } catch (SQLException ex) {
                        }
                } else if (CurrentFile.getName().endsWith(".docx") || CurrentFile.getName().endsWith(".rtf")) {
                    try {
                        FileInputStream fis = new FileInputStream(CurrentFile);

                        XWPFDocument document = new XWPFDocument(fis);

                        List<XWPFParagraph> paragraphs = document.getParagraphs();
                        String x = "";
                        ArrayList<Block> bloques = new ArrayList();
                        int cont = 0;
                        for (XWPFParagraph para : paragraphs) {
                            x += para.getText()+"\n";
                            cont++;
                            bloques.add(new Block(cont, false, para.getText(), -1));
                            
                        }
                        if(!x.equals("")&&x.contains("\n"))
                            x=x.substring(0, x.lastIndexOf("\n"));
                        String name=CurrentFile.getName();
                        if(name.contains("."))
                            name=name.substring(0, name.lastIndexOf("\n"));
                        curr = new FileClass(name, bloques);
                        tpText.getDocument().insertString(0, x, tpText.getCharacterAttributes());
                        newFile=true;
                        jmiSave.setEnabled(true);
                        tpText.setEditable(true);

                        fis.close();
                        try {
                            db.executeUpdate("insert into log(Date,Time,Action) values(curdate(),curtime(),'Usuario "+principal.getUsername()+" ID "+principal.getId()+" abrio un archivo nuevo')");
                        } catch (SQLException ex) {
                        }
                    } catch (Exception e) {
                    }
                }
            }
        } catch (NullPointerException | IOException | BadLocationException e) {
        } finally {
            if(curr!=null&&newFile){
                if(!updt.isInterrupted()){
                    try {
                        updt.setActive(false);
                        updt.join();
                    } catch (InterruptedException ex) {
                    }
                }         
            }
            updt.interrupt();

            Close();
        }
    }//GEN-LAST:event_jmiOpenFileActionPerformed

    private void jmiLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiLogoutActionPerformed
        try {
            Connect();
            db.executeUpdate("update users set connected=0 where ID=" + principal.getId() + " limit 1");
            db.executeUpdate("insert into log(Date,Time,Action) values(curdate(),curtime(),'Usuario " + principal.getUsername() + " ID " + principal.getId() + " se desconectó')");

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
        } finally {
            Close();
        }
    }//GEN-LAST:event_jmiLogoutActionPerformed

    private void jmiExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiExitActionPerformed
        try {
            Connect();
            db.executeUpdate("update users set connected=0 where ID=" + principal.getId() + " limit 1");
            db.executeUpdate("insert into log(Date,Time,Action) values(curdate(),curtime(),'Usuario " + principal.getUsername() + " ID " + principal.getId() + " salio del sistema')");
            if (curr != null) {
                db.executeUpdate("update blocks set UserID=-1,Editing=0 where UserID="+principal.getId());
            }
        } catch (SQLException ex) {
            Close();
            System.exit(1);
        } finally {
            Close();
            System.exit(0);
        }
    }//GEN-LAST:event_jmiExitActionPerformed

    public void Connect() {
        try {
            if (con.isClosed()) {
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectoed2?autoReconnect=true&useSSL=false", "root", "pokemon123");
            }
            if (db.isClosed()) {
                db = con.createStatement();
            }
        } catch (SQLException ex) {
        }
    }

    public void Close() {
        try {
            if (!db.isClosed()) {
                db.close();
            }
            if (!con.isClosed()) {
                con.close();
            }
        } catch (SQLException e) {
        }
    }

    public void AssignPermit(int PermitToAssign) {
        try {
            Connect();
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
                if (Chosen == null) {
                    Chosen = (FileClass) ((DefaultMutableTreeNode) jtAdmin.getSelectionPath().getLastPathComponent()).getUserObject();
                }
                ResultSet check = db.executeQuery("select ID,Type from permissions where OwnerID=" + principal.getId() + " and UserID=" + UserID + " and FileID=" + Chosen.getID() + " limit 1");
                if (check.next()) {
                    int checkType = check.getInt("Type");
                    int PermitID = check.getInt("ID");
                    check.close();
                    if (checkType > PermitToAssign) {
                        int decide = JOptionPane.showConfirmDialog(jdPermisos, "\tEl usuario " + name + " tiene permisos completos en el archivo.\nDesea actualizar el permiso a solo lectura?", "Confirme su elección", JOptionPane.YES_NO_OPTION);
                        if (decide == JOptionPane.YES_OPTION) {
                            db.executeUpdate("update permissions set Type=" + PermitToAssign + " where ID=" + PermitID + " limit 1");
                            db.executeUpdate("insert into log(Date,Time,Action) values(curdate(),curtime(),'Usuario " + principal.getUsername() + " ID: " + principal.getId() + " asigno " + PermitToAssign + " a " + name + " ID: " + UserID + " sobre el archivo " + Chosen.getName() + " ID " + Chosen.getID() + "')");
                            JOptionPane.showMessageDialog(jdPermisos, Permit + " asignado con exito a " + name);
                            //jdPermisos.dispose();
                        }
                    } else if (checkType == PermitToAssign) {
                        JOptionPane.showMessageDialog(jdPermisos, "El usuario " + name + " ya tiene ese permiso en el archivo");
                    } else {
                        db.executeUpdate("update permissions set Type=" + PermitToAssign + " where ID=" + PermitID + " limit 1");
                        db.executeUpdate("insert into log(Date,Time,Action) values(curdate(),curtime(),'Usuario " + principal.getUsername() + " ID: " + principal.getId() + " asigno " + PermitToAssign + " a " + name + " ID: " + UserID + " sobre el archivo " + Chosen.getName() + " ID " + Chosen.getID() + "')");
                        JOptionPane.showMessageDialog(jdPermisos, Permit + " asignado con exito a " + name);
                    }
                    //check.close();
                } else {
                    check.close();
                    db.executeUpdate("insert into permissions(OwnerID,UserID,Type,FileID) values(" + principal.getId() + "," + UserID + "," + PermitToAssign + "," + Chosen.getID() + ")");
                    db.executeUpdate("insert into log(Date,Time,Action) values(curdate(),curtime(),'Usuario " + principal.getUsername() + " ID: " + principal.getId() + " asigno " + PermitToAssign + " a " + name + " ID: " + UserID + " sobre el archivo " + Chosen.getName() + " ID " + Chosen.getID() + "')");
                    JOptionPane.showMessageDialog(jdPermisos, Permit + " asignado con exito");
                }
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(jdPermisos, "Ocurrio un error en la aplicacion de los permisos");
        } finally {
            Close();
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
            return rowNum;
        } catch (BadLocationException ex) {
            return -1;
        }

    }

    public void RefreshTree() throws SQLException {
        original = new DefaultTreeModel(new DefaultMutableTreeNode("Archivos"));
        DefaultMutableTreeNode root1 = (DefaultMutableTreeNode) original.getRoot();
        original.insertNodeInto(new DefaultMutableTreeNode("Tus Archivos"), root1, 0);
        original.insertNodeInto(new DefaultMutableTreeNode("Archivos compartidos"), root1, 1);
        original.insertNodeInto(new DefaultMutableTreeNode("Solo Lectura"), (DefaultMutableTreeNode) root1.getChildAt(1), 0);
        original.insertNodeInto(new DefaultMutableTreeNode("Lectura y Escritura"), (DefaultMutableTreeNode) root1.getChildAt(1), 1);
        jtAdmin.setModel(original);
        original.reload();
        Connect();
        try {
            DefaultTreeModel Tmodel = (DefaultTreeModel) jtAdmin.getModel();
            DefaultMutableTreeNode root = (DefaultMutableTreeNode) Tmodel.getRoot();
            DefaultMutableTreeNode YourFiles = (DefaultMutableTreeNode) Tmodel.getChild(root, 0);
            DefaultMutableTreeNode shared = (DefaultMutableTreeNode) Tmodel.getChild(root, 1);
            DefaultMutableTreeNode shared1 = (DefaultMutableTreeNode) shared.getChildAt(0);
            DefaultMutableTreeNode shared2 = (DefaultMutableTreeNode) shared.getChildAt(1);
            try (ResultSet GetFiles = db.executeQuery("select * from files where OwnerID=" + principal.getId())) {
                Statement db2=con.createStatement();

                while (GetFiles.next()) {
                    ResultSet getBlocks=db2.executeQuery("select * from blocks where FileID="+GetFiles.getInt("ID"));
                    ArrayList<Block> blocks=new ArrayList();
                    int cont=0;
                    while(getBlocks.next())
                        blocks.add(new Block(getBlocks.getInt("row"),getBlocks.getInt("Editing")==1,getBlocks.getString("Text"),getBlocks.getInt("UserID")));
                    getBlocks.close();
                    YourFiles.add(new DefaultMutableTreeNode(new FileClass(GetFiles.getInt("ID"), GetFiles.getString("Name"),blocks)));
                }
                db2.close();
            }
            Statement db3 = con.createStatement();
            Statement db4 = con.createStatement();
            ResultSet GetPermissions = db.executeQuery("select Type,FileID from permissions where UserID=" + principal.getId());
            while (GetPermissions.next()) {
                try (ResultSet GetPermitFiles = db3.executeQuery("select * from files where ID=" + GetPermissions.getInt("FileID") + " limit 1")) {
                    if (GetPermitFiles.next()) {
                        ResultSet getBlocks=db4.executeQuery("select * from blocks where FileID="+GetPermissions.getInt("FileID")+" limit 1");
                        ArrayList<Block> blocks=new ArrayList();
                        while(getBlocks.next())
                            blocks.add(new Block(getBlocks.getInt("row"),getBlocks.getInt("Editing")==1,getBlocks.getString("Text"),getBlocks.getInt("UserID")));

                        if (GetPermissions.getInt("Type") == 2) {
                            shared2.add(new DefaultMutableTreeNode(new FileClass(GetPermitFiles.getInt("ID"), GetPermitFiles.getString("Name"),blocks)));
                        } else {
                            shared1.add(new DefaultMutableTreeNode(new FileClass(GetPermitFiles.getInt("ID"), GetPermitFiles.getString("Name"),blocks)));
                        }
                        getBlocks.close();
                    }
                }
            }
            GetPermissions.close();
            Tmodel.reload(root);
            jtAdmin.setModel(Tmodel);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error actualizando el arbol");
        } finally {
            Close();
        }
    }

    public void Login() {
        try {
            Connect();
            String user = tfUser.getText();
            String password = String.valueOf(pwfPass.getPassword());

            if (!user.equals("") && !password.equals("")) {

                ResultSet usuario = db.executeQuery("select * from users where user='" + user + "' and pass='" + password + "'");

                if (usuario.next()) {
                    if (usuario.getInt("connected") == 0) {

                        principal = new User(usuario.getString("user"), usuario.getString("pass"), usuario.getInt("ID"));
                        jlUser.setText("<html><b>Usuario: " + principal.getUsername() + ", ID: " + principal.getId() + "</b></html>");
                        usuario.close();
                        db.executeUpdate("insert into log(Date,Time,Action) values(curdate(),curtime(), '" + principal.getUsername() + " con ID " + principal.getId() + " inicio sesión')");
                        db.executeUpdate("update users set connected=1 where ID=" + principal.getId() + " limit 1");
                        updt.setUser(principal);
                        jdLogin.dispose();
                        this.setVisible(false);
                        jlIcon.setIcon(new ImageIcon(new ImageIcon("./src/Iconos/sol.png").getImage().getScaledInstance(jlIcon.getHeight(), jlIcon.getWidth(), Image.SCALE_SMOOTH)));
        
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
                        // UpdateText updt=new UpdateText(tpText,jtAdmin,con,1);
                        //updt.start(); //Thread para actualizar el texto durante la edicion. Comentado por que apenas esta funcional y para realizar pruebas de las otras funcionalidades
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
                                    YourFiles.add(new DefaultMutableTreeNode(new FileClass(GetFiles.getInt("ID"), GetFiles.getString("Name"))));
                                }
                            }
                            Statement db2 = con.createStatement();
                            ResultSet GetPermissions = db.executeQuery("select Type,FileID from permissions where UserID=" + principal.getId());
                            while (GetPermissions.next()) {
                                try (ResultSet GetPermitFiles = db2.executeQuery("select * from files where ID=" + GetPermissions.getInt("FileID") + " limit 1")) {
                                    if (GetPermitFiles.next()) {
                                        if (GetPermissions.getInt("Type") == 2) {
                                            shared2.add(new DefaultMutableTreeNode(new FileClass(GetPermitFiles.getInt("ID"), GetPermitFiles.getString("Name"))));
                                        } else {
                                            shared1.add(new DefaultMutableTreeNode(new FileClass(GetPermitFiles.getInt("ID"), GetPermitFiles.getString("Name"))));
                                        }
                                    }

                                }
                            }
                            Tmodel.reload(root);
                            jtAdmin.setModel(Tmodel);
                            GetPermissions.close();
                            db2.close();
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(jdMain, "Ocurrio un error obteniendo sus archivos de la base de datos. Use la opcion 'Actualizar' del arbol");
                        }
                        jdMain.pack();
                        jdMain.setLocationRelativeTo(this);
                        jdMain.setModal(true);
                        jdMain.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                        jdMain.setVisible(true);
                    } else if (usuario.getInt("connected") == 1) {
                        JOptionPane.showMessageDialog(jdLogin, "Ese usuario ya esta conectado");
                        pwfPass.setFocusable(false);
                        pwfPass.setFocusable(true);
                        tfUser.setFocusable(false);
                        tfUser.setFocusable(true);
                    }
                } else {
                    JOptionPane.showMessageDialog(jdLogin, "Usuario no encontrado, revise sus credenciales");
                    principal = null;
                    pwfPass.setFocusable(false);
                    pwfPass.setFocusable(true);
                    tfUser.setFocusable(false);
                    tfUser.setFocusable(true);
                }
            } else {
                JOptionPane.showMessageDialog(jdLogin, "Usuario y/o contraseña no pueden ser vacios");
                tfUser.setText("");
                pwfPass.setText("");
                pwfPass.setFocusable(false);
                pwfPass.setFocusable(true);
                tfUser.setFocusable(false);
                tfUser.setFocusable(true);
            }
        } catch (InputMismatchException | SQLException e) {
            JOptionPane.showMessageDialog(jdLogin, "Usuario no encontrado. Verifique sus credenciales e intente de nuevo");
            pwfPass.setFocusable(false);
            pwfPass.setFocusable(true);
            tfUser.setFocusable(false);
            tfUser.setFocusable(true);
        } finally {
            Close();
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
    private javax.swing.JButton bCloseLog;
    private javax.swing.JButton bExit;
    private javax.swing.JButton bExitLogin;
    private javax.swing.JButton bExportfile;
    private javax.swing.JButton bFTP;
    private javax.swing.JButton bGenerateReport;
    private javax.swing.JButton bIncreaseSize;
    private javax.swing.JButton bItalic;
    private javax.swing.JButton bLogin;
    private javax.swing.JButton bReadOnly;
    private javax.swing.JButton bReadWrite;
    private javax.swing.JButton bReduceSize;
    private javax.swing.JButton bST;
    private javax.swing.JButton bSaveLog;
    private javax.swing.JButton bUnderline;
    private javax.swing.JComboBox<String> cbListUsers;
    private javax.swing.JCheckBox checkOrder;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JDialog jdExport;
    private javax.swing.JDialog jdLog;
    private javax.swing.JDialog jdLogin;
    private javax.swing.JDialog jdMain;
    private javax.swing.JDialog jdPermisos;
    private javax.swing.JDialog jdReport;
    private javax.swing.JLabel jlCurrFile;
    private javax.swing.JLabel jlFrameIcon;
    private javax.swing.JLabel jlIcon;
    private javax.swing.JLabel jlName;
    private javax.swing.JLabel jlTextSize;
    private javax.swing.JLabel jlTitle;
    private javax.swing.JLabel jlUser;
    private javax.swing.JMenu jmFile;
    private javax.swing.JMenu jmLogout;
    private javax.swing.JMenu jmOptions;
    private javax.swing.JMenuBar jmbMain;
    private javax.swing.JMenuItem jmiAbrir;
    private javax.swing.JMenuItem jmiDelete;
    private javax.swing.JMenuItem jmiExit;
    private javax.swing.JMenuItem jmiExport;
    private javax.swing.JMenuItem jmiLog;
    private javax.swing.JMenuItem jmiLogout;
    private javax.swing.JMenuItem jmiOpenFile;
    private javax.swing.JMenuItem jmiPermiso;
    private javax.swing.JMenuItem jmiRefresh;
    private javax.swing.JMenuItem jmiReports;
    private javax.swing.JMenuItem jmiSave;
    private javax.swing.JPanel jpLog;
    private javax.swing.JPanel jpMain;
    private javax.swing.JPanel jpReport;
    private javax.swing.JPopupMenu jpmAdminFiles;
    private javax.swing.JTree jtAdmin;
    private javax.swing.JTable jtReport;
    private javax.swing.JTabbedPane jtpEditorOptions;
    private javax.swing.JPasswordField pwfPass;
    private javax.swing.JRadioButton rbDoc;
    private javax.swing.JRadioButton rbDocx;
    private javax.swing.JRadioButton rbRTF;
    private javax.swing.JRadioButton rbReportByDate;
    private javax.swing.JRadioButton rbReportByName;
    private javax.swing.JRadioButton rbReportByOwner;
    private javax.swing.JRadioButton rbReportByTime;
    private javax.swing.JRadioButton rbSize;
    private javax.swing.JRadioButton rbXML;
    private javax.swing.ButtonGroup rbgExport;
    private javax.swing.ButtonGroup rbgReport;
    private javax.swing.JTextArea taExport;
    private javax.swing.JTextField tfPermisosFileName;
    private javax.swing.JTextField tfUser;
    private javax.swing.JTextPane tpLog;
    private javax.swing.JTextPane tpText;
    // End of variables declaration//GEN-END:variables
}
