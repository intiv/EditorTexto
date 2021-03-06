package editortexto;

import java.io.StringReader;
import java.io.StringWriter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "user")
public class User {

    private String username;
    private String pass;
    private final int id;
    
    public User(String username, String pass, int id) {
        this.username = username;
        this.pass = pass;
        this.id=id;
    }

    public User() {
        this.username = "";
        this.pass = "";
        this.id=-1;
    }

    public User(User cpy) {
        this.username = cpy.getUsername();
        this.pass = cpy.getPass();
        this.id=cpy.getId();
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

    public String Serialize() {
        StringWriter writer = new StringWriter();
        JAXBContext context;
        try {
            context = JAXBContext.newInstance(User.class);
            Marshaller m = context.createMarshaller();
            m.marshal(this, writer);
            return writer.toString();
        } catch (JAXBException ex) {
            return "No se pudo serializar";
        }
    }

    public User Deserialize(String Serial) {
        JAXBContext context;
        try {
            context = JAXBContext.newInstance(User.class);
            Unmarshaller m = context.createUnmarshaller();
            return (User) m.unmarshal(new StringReader(Serial));
        } catch (JAXBException ex) {
            return null;
        }
    }

    @XmlElement
    public int getId() {
        return id;
    }
    

}
