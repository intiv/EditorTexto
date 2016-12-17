/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editortexto;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Inti Velasquez
 */
@XmlRootElement(name = "file")
public class FileClass {

    private int ID;
    private String name;
    private ArrayList<Block> blocks;

    public FileClass() {
        ID = -1;
        name = "";
    }

    public FileClass(int ID, String name) {
        this.ID = ID;
        this.name = name;
    }

    public FileClass(int ID, String name,ArrayList<Block> blocks) {
        this.ID = ID;
        this.name = name;
        this.blocks = blocks;
    }

    public FileClass(String name, ArrayList<Block> blocks) {
        this.name = name;
        this.blocks = blocks;
        this.ID = -1;

    }

    @XmlElement
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    @XmlElement
    public String getName() {
        return name;
    }

    public Block get(int i) {
        if (blocks != null) {
            if (i >= 0 && i < blocks.size()) {
                return blocks.get(i);
            }
        }
        return null;
    }

    public int size() {
        return blocks.size();
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ID=" + ID + " - Name = " + name;
    }

    public String Serialize() {
        try {
            StringWriter sw = new StringWriter();
            JAXBContext context = JAXBContext.newInstance(FileClass.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            m.marshal(this, sw);
            return sw.toString();
        } catch (JAXBException CantSerialize) {
            return "Error";
        }
    }

    public FileClass Deserialize(String xml) {
        try {
            JAXBContext context = JAXBContext.newInstance(FileClass.class);
            Unmarshaller um = context.createUnmarshaller();
            return (FileClass) um.unmarshal(new StringReader(xml));
        } catch (JAXBException CantDeserialize) {
            return null;
        }
    }

    public String getBlocksText() {
        if (blocks != null) {
            if (blocks.size() > 0) {
                String retVal = " ";
                for (int i = 0; i < blocks.size(); i++) {
                    retVal += blocks.get(i).getText();
                    if (i < blocks.size() - 1) {
                        retVal += "\n";
                    }
                }
                return retVal;
            } else {
                return "";
            }
        } else {
            return "";
        }
    }

    public void restructure() {
        boolean valid = false;
        while (!valid) {
            valid = true;
        }
    }

    @XmlElement
    public ArrayList<Block> getBlocks() {
        return blocks;
    }

    public void setBlocks(ArrayList<Block> blocks) {
        this.blocks = blocks;
    }

}
