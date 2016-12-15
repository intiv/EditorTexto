package editortexto;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextPane;
import javax.swing.JTree;
import java.sql.Connection;

public class UpdateText extends Thread {

    JTextPane text;
    boolean run;
    JTree tree;
    Connection con;
    int id;
    FileClass curr;
    
    public UpdateText(JTextPane text, JTree tree, Connection con,FileClass curr, int id) {
        this.text = text;
        this.run = true;
        this.tree = tree;
        this.con = con;
        this.id = id;
        this.curr=curr;
    }

    
    @Override
    public void run() {
        try {
            if (run) {
                while (true) {
                    text.setText("asd");

                    Thread.sleep(5000);
                }
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(UpdateText.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
