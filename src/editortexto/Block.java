/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editortexto;

/**
 *
 * @author Inti Velasquez
 */
public class Block {
    private int row;
    private boolean modifying;
    private String text;
    private int user;
    
    public Block() {
        row=-1;
        modifying=false;
        text="";
    }

    public Block(int row, boolean modifying, String text,int id) {
        this.row = row;
        this.modifying = modifying;
        this.text = text;
        user=id;
    }

    
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public boolean isModifying() {
        return modifying;
    }

    public void setModifying(boolean modifying) {
        this.modifying = modifying;
    }

    @Override
    public String toString() {
        return "Block{" + "row=" + row + ", modifying=" + modifying + ", text=" + text + '}';
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }
    
    
    
}
