package editortexto;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextPane;

public class UpdateText extends Thread {

    JTextPane text;
    boolean run;

    public UpdateText(JTextPane text) {
        this.text = text;
        this.run = true;
    }

    @Override
    public void run() {
        try {
            while (true) {
                if (run) {
                    text.setText("asd");
                    Thread.sleep(10000);
                }
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(UpdateText.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
