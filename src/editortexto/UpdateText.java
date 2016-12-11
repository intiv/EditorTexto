package editortexto;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.tree.DefaultMutableTreeNode;

public class UpdateText extends Thread {

    JTextPane text;
    boolean run;
    JTree tree;
    Connection con;
    int id;

    public UpdateText(JTextPane text, JTree tree, Connection con,int id) {
        this.text = text;
        this.run = true;
        this.tree = tree;
        this.con = con;
        this.id=id;
    }

    @Override
    public void run() {
        try {
            if (run) {
                try {
                    DefaultTreeModel model = (DefaultTreeModel) tree.getModel();
                    Statement db = con.createStatement();
                    ResultSet rs=db.executeQuery("select * from permissions where UserID="+id);
                    DefaultMutableTreeNode root=(DefaultMutableTreeNode)model.getRoot();
                    DefaultMutableTreeNode shared=(DefaultMutableTreeNode)model.getChild(root, 1);
                    
                    ArrayList<DefaultMutableTreeNode> sharedfiles=new ArrayList();
                    
                    for (int i = 0; i < shared.getChildCount(); i++) {
                        sharedfiles.add((DefaultMutableTreeNode)shared.getChildAt(i));
                    }
                    
                    while(rs.next()){
                        
                    }
                    //text.setText("asd");
                } catch (SQLException e) {

                }
                Thread.sleep(10000);
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(UpdateText.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
