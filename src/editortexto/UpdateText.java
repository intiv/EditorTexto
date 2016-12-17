package editortexto;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextPane;
import javax.swing.JTree;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class UpdateText extends Thread {

    JTextPane text;
    boolean active;
    boolean alive;
    JTree tree;
    Connection con;
    User user;
    FileClass curr;
    Statement db;
    int OriginalRow;

    public UpdateText(JTextPane text, JTree tree, Connection con, boolean active) {
        this.text = text;
        this.active = true;
        this.tree = tree;
        this.con = con;
        alive = false;
        db = null;
        user = null;
        curr = null;
        OriginalRow = -1;
    }

    public void setCurr(FileClass curr) {
        this.curr = curr;
    }

    public void setUser(User user) {
        this.user = user;

    }

    public User getUser() {
        return user;
    }

    public FileClass getCurr() {
        return curr;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isActive() {
        return active;
    }

    public void setOriginalRow(int row) {
        this.OriginalRow = row;
    }

    public int getOriginalRow() {
        return this.OriginalRow;
    }
    
    public void setAlive(boolean al){
        alive=al;
    }

    public boolean Alive(){
        return alive;
    }
    
    @Override
    public void run() {
        try {
            while (alive) {
                //if (alive) {
                    try {

                        if (con == null || con.isClosed()) {
                            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectoed2?autoReconnect=true&useSSL=false", "root", "pokemon123");
                        }

                        if (db == null || db.isClosed()) {
                            db = con.createStatement();
                        }
                        text.setFocusable(false);
                        text.setFocusable(true);
                        String[] OriginalLines = text.getDocument().getText(0, text.getDocument().getLength()).split("\n");
                        ArrayList<String> lineas = new ArrayList();
                        for (int i = 0; i < OriginalLines.length; i++) {
                            lineas.add(OriginalLines[i]);
                        }
                        for (int i = 0; i < curr.size(); i++) {
                            if (curr.get(i).isModifying() && curr.get(i).getUser() == user.getId()) {
                                db.executeUpdate("update blocks set Editing=1,Edited=" + curr.get(i).isModified() + ",UserID=" + user.getId() + ",fileid=" + curr.getID() + ",text='" + curr.get(i).getText() + "' where row=" + i);
                            }
                        }
                        ResultSet editing = db.executeQuery("select * from blocks where Editing=1 and UserID<>" + user.getId() + " and FileID=" + curr.getID() + " order by row asc");
                        while (editing.next()) {
                            int row = editing.getInt("row");
                            if (row < curr.size()) {
                                curr.get(row).setText(editing.getString("Text"));
                                curr.get(row).setModified(true);
                                curr.get(row).setModifying(true);
                                curr.get(row).setUser(editing.getInt("userid"));

                            } else {
                                curr.getBlocks().add(new Block(row, true, editing.getString("Text"), editing.getInt("UserID")));
                                lineas.add(editing.getString("Text"));

                            }
                            lineas.set(row, editing.getString("Text"));

                        }
                        editing.close();
                        ResultSet edit=db.executeQuery("select * from blocks where Edited=1 and userid=-1 and fileid="+curr.getID());
                        while(edit.next()){
                            int row=edit.getInt("row");
                            if(row<curr.size()){
                                curr.get(row).setText(edit.getString("text"));
                                curr.get(row).setModified(false);
                                curr.get(row).setModifying(false);
                                
                            }else{
                                curr.getBlocks().add(new Block(row,false,edit.getString("Text"),-1));
                                lineas.add(edit.getString("Text"));
                            }
                        }
                        text.setText("");
                        System.out.println("\n");
                        for (int i = 0; i < lineas.size(); i++) {
                            if (i < lineas.size() - 1) {
                                lineas.set(i, lineas.get(i) + "\n");
                            }
                            text.getDocument().insertString(text.getDocument().getLength(), lineas.get(i), text.getCharacterAttributes());
                        }
    
                        /*ResultSet rs = db.executeQuery("select * from blocks where UserID=-1 and FileID=" + curr.getID() + " and Edited=1 and Editing=0");
                        ArrayList<Integer> rows = new ArrayList();
                        while (rs.next()) {
                            System.out.println("ALLAHU AKBHAR");
                            int row = rs.getInt("row");
                            if (row < curr.size()) {
                                curr.get(row).setText(rs.getString("Text"));
                                curr.get(row).setModified(false);
                                curr.get(row).setUser(-1);
                            } else {
                                curr.getBlocks().add(new Block(row, (rs.getInt("Editing") == 1), rs.getString("Text"), rs.getInt("UserID")));
                                lineas.add(rs.getString("Text"));
                            }
                            System.out.println("Row "+row+": "+curr.get(row).toString());
                            lineas.set(row, rs.getString("Text"));
                            rows.add(row);
                        }
                        rs.close();
                        ResultSet editing=db.executeQuery("select * from blocks where edited=1 and Editing=1 and FileID="+curr.getID()+" and UserID<>"+user.getId()+" and UserID<>-1");
                        while(editing.next()){
                            int row=editing.getInt("row");
                            if (row < curr.size()) {
                                curr.get(row).setText(editing.getString("Text"));
                                curr.get(row).setModified(false);
                                curr.get(row).setModifying(true);
                                curr.get(row).setUser(editing.getInt("UserID"));
                            } else {
                                curr.getBlocks().add(new Block(row, (editing.getInt("Editing") == 1), editing.getString("Text"), editing.getInt("UserID")));
                                lineas.add(editing.getString("Text"));
                            }
                        }
                        editing.close();
                        ResultSet makesure=db.executeQuery("select * from blocks where edited=0 and editing=1 and fileid="+curr.getID()+" and userid<>"+user.getId());
                        while(makesure.next()){
                            int row=makesure.getInt("row");
                            if (row < curr.size()) {
                                curr.get(row).setText(makesure.getString("Text"));
                                curr.get(row).setModified(false);
                                curr.get(row).setModifying(true);
                                curr.get(row).setUser(makesure.getInt("UserID"));
                            } else {
                                curr.getBlocks().add(new Block(row, (makesure.getInt("Editing") == 1), makesure.getString("Text"), makesure.getInt("UserID")));
                                lineas.add(makesure.getString("Text"));
                            }
                        }
                        text.setText("");
                        System.out.println("\n");
                        for (int i = 0; i < lineas.size(); i++) {
                            if (i < lineas.size() - 1) {
                                lineas.set(i, lineas.get(i) + "\n");
                            }
                            text.getDocument().insertString(text.getDocument().getLength(), lineas.get(i), text.getCharacterAttributes());
                        }
                        System.out.println("***** HILO *******");
                        System.out.println("LINEA ORIGINAL: " + OriginalRow);
                        for (int i = 0; i < curr.getBlocks().size(); i++) {
                            System.out.println("ANTES: " + i + ": " + curr.getBlocks().get(i).toString());
                            if (!curr.get(i).isModifying()) {
                                int mod = curr.getBlocks().get(i).isModifying() ? 1 : 0;
                                int us = -1;
                                int mod2 = curr.getBlocks().get(i).isModified() ? 1 : 0;
                                if (mod == 1) {
                                    if (curr.getBlocks().get(i).getUser() == user.getId()) {
                                        us = user.getId();
                                    } else {
                                        us = curr.get(i).getUser();
                                    }
                                }
                                if (us != -1) {
                                    db.executeUpdate("update blocks set Text='" + curr.getBlocks().get(i).getText() + "',Editing=" + mod + ",UserID=" + us + ",Edited=" + mod2 + " where FileID=" + curr.getID() + " and row=" + i);
                                } else {
                                    db.executeUpdate("update blocks set Text='" + curr.getBlocks().get(i).getText() + "',Editing=0,UserID=-1,Edited=" + mod2 + " where FileID=" + curr.getID() + " and row=" + i);
                                }
                            } else {
                                
                            }
                        }
                        System.out.println("===========================================================");
                        */
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            db.close();
                            con.close();
                        } catch (SQLException ex) {
                        }
                    }
                    
                    Thread.sleep(10000);    
                }
            //}
                
        } catch (InterruptedException ex) {
        }
    }

}
