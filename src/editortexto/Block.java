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

    public Block() {
        row=-1;
        modifying=false;
        text="";
    }

    public Block(int row, boolean modifiying, String text) {
        this.row = row;
        this.modifying = modifiying;
        this.text = text;
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

    public boolean isModifiying() {
        return modifying;
    }

    public void setModifiying(boolean modifiying) {
        this.modifying = modifiying;
    }

    @Override
    public String toString() {
        return "Block{" + "row=" + row + ", modifiying=" + modifying + ", text=" + text + '}';
    }
    
    
    
}
