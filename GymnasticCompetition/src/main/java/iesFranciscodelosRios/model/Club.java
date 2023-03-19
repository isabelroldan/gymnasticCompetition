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
    private String nombre;
    private ArrayList<Gymnast> gymnasts;

    public Club() {

    }

    public Club(String nombre) {
        this.nombre = nombre;
        this.gymnasts = new ArrayList<>();
    }

    public boolean addGymnast(Gymnast gymnast) {
        boolean result=false;
        try {
            if(!gymnasts.contains(gymnast)){
                gymnasts.add(gymnast);
                result=true;
            }
        }catch (NullPointerException e){

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
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "Club{" +
                "nombre='" + nombre + '\'' +
                ", gymnasts=" + gymnasts +
                '}';
    }
}