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
    private boolean modified;
    
    public Block() {
        row=-1;
        modifying=false;
        text="";
        modified=false;
    }

    public Block(int row, boolean modifying, String text,int id) {
        this.row = row;
        this.modifying = modifying;
        if(modifying)
            user=id;
        else
            user=-1;
        this.text = text;
        modified=false;
    }

    
    public String getText() {
        return text;
    }

    public void IncreaseRow(){
        row++;
    }
    
    public void DecreaseRow(){
        if(row>0)
            row--;
    }
    public void setText(String text) {
        this.text = text;
    }

    public boolean isModified() {
        return modified;
    }

    public void setModified(boolean modified) {
        this.modified = modified;
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
        if(modifying==false)
            user=-1;
        this.modifying = modifying;
    }

    @Override
    public String toString() {
        return "Block: " + "row=" + row + ", modifying=" + modifying + ", text=" + text +", user="+user+", modified="+modified;
    }

    public int getUser() {
        return user;
    }


    public void setUser(int user) {
        this.user = user;
    }
    
    
    
}
