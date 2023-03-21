package iesFranciscodelosRios.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlTransient;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Logger;
@XmlAccessorType(XmlAccessType.FIELD)
public final class Club {
    @XmlTransient
    private final static Logger logger= iesFranciscodelosRios.Utils.Logger.CreateLogger("model.Trial");
    private String name;
    private ArrayList<Gymnast> gymnasts=new ArrayList<>();

    public Club() {

    }

    public Club(String name) {
        this.name = name;
        this.gymnasts = new ArrayList<>();
    }

    public boolean addGymnast(Gymnast gymnast) {
        System.out.println(gymnast.hashCode());
        boolean result=false;
        try {
            if(!gymnasts.contains(gymnast)){
                gymnasts.add(gymnast);
                result=true;
            }
        }catch (NullPointerException e) {
            logger.severe("Error method addGymnast " + e.getMessage());
        } finally {
            if(!result){
                logger.warning("Warning. method addGymnast. It has not been executed correctly");
            }
        }
        return result;
    }
    public boolean removeGymnast(String dni){
        boolean result=true;
        Iterator<Gymnast> it= gymnasts.iterator();
        while (it.hasNext()){
            Gymnast aux=it.next();
            if(aux.getDNI().equalsIgnoreCase(dni)){
                gymnasts.remove(aux);
                result=true;
            }
        }
        return result;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Club: \n\t" +
                "Name: " + name + "\n\t" +
                "Gymnasts: " + gymnasts;
    }
}
