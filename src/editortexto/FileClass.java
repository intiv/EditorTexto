/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editortexto;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.Arrays;
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
    //private byte[][] sections;
    private String text;
    

    public FileClass() {
        ID=-1;
        name="";
        text="";
        //sections=null;
    }

    public FileClass(int ID, String name, byte[][] bytes) {
        this.ID = ID;
        this.name = name;
        
        //this.sections = sections;
    }

    public FileClass(int ID, String name, byte[][] bytes,String text) {
        this.ID = ID;
        this.name = name;
        //this.sections = sections;
        this.text=text;
    }
    
    
 //   public byte[][] getSections() {
  //      return sections;
  //  }

   // public void setSections(byte[][] sections) {
   //     this.sections = sections;
   // }

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


    @Override
    public String toString() {
        return "FileClass{" + "ID=" + ID + ", name=" + name + ", sections="/* + Arrays.deepToString(sections) */+ '}';
    }
    
    public String Serialize(){
        try{
            StringWriter sw=new StringWriter();
            JAXBContext context=JAXBContext.newInstance(FileClass.class);
            Marshaller m=context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            m.marshal(this, sw);
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

    @XmlElement
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
