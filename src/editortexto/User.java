/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editortexto;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
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

@XmlRootElement(name="user")
public class User {
    
    private String username;
    
    private String pass;

    public User(String username, String pass) {
        this.username = username;
        this.pass = pass;
    }
    
    public User(){
        this.username="";
        this.pass="";
    }
    
    public User(User cpy){
        this.username=cpy.getUsername();
        this.pass=cpy.getPass();
    }
    @XmlElement
    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @XmlElement
    public String getUsername() {
        return username;
    }

    public void setUsername(String user) {
        this.username = user;
    }

    @Override
    public String toString() {
        return "User{" + "username=" + username + ", pass=" + pass + '}';
    }
    
    
    public String Serialize(){
        StringWriter writer = new StringWriter();
        JAXBContext context;
        try {
            context = JAXBContext.newInstance(User.class);
            Marshaller m = context.createMarshaller();
            m.marshal(this, writer);
            //System.out.println(writer.toString());
            return writer.toString();
        } catch (JAXBException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            return "No se pudo serializar";
        }
    }
    
    public User Deserialize(String Serial){
        User A1 = new User();
        JAXBContext context;
        try {
            context = JAXBContext.newInstance(User.class);
            Unmarshaller m = context.createUnmarshaller();
            

            return (User)m.unmarshal(new StringReader(Serial));
        } catch (JAXBException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
           return A1;   
        }
    }
}
