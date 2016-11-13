/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editortexto;

import java.io.StringReader;
import java.io.StringWriter;
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
@XmlRootElement(name="file")
public class FileClass {
    private int ID;
    private String name;
    private String dir;
    private byte[][] sections;

    public FileClass() {
    }

    public FileClass(int ID, String name, String dir, byte[][] sections) {
        this.ID = ID;
        this.name = name;
        this.dir = dir;
        this.sections = sections;
    }

    @XmlElement
    public byte[][] getSections() {
        return sections;
    }

    public void setSections(byte[][] sections) {
        this.sections = sections;
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

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement
    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    @Override
    public String toString() {
        return "FileClass{" + "ID=" + ID + ", name=" + name + ", dir=" + dir + ", sections=" + sections + '}';
    }
    
    public String Serialize(){
        try{
            StringWriter sw=new StringWriter();
            JAXBContext context=JAXBContext.newInstance(FileClass.class);
            Marshaller m=context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            m.marshal(this, sw);
            System.out.println(sw.toString());
            return sw.toString();
        }catch(JAXBException CantSerialize){
            return "Error";
        }
    }
    
    public FileClass Deserialize(String xml){
        try{
            JAXBContext context=JAXBContext.newInstance(FileClass.class);
            Unmarshaller um=context.createUnmarshaller();
            return (FileClass)um.unmarshal(new StringReader(xml));
        }catch(JAXBException CantDeserialize){
            System.out.println("Error deserializando");
            return null;
        }
    }
}
