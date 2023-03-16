package iesFranciscodelosRios.model;

import java.util.ArrayList;
import java.util.Iterator;

public class Club {
    private String nombre;
    private ArrayList<Gymnast> gymnasts;

    public Club(String nombre) {
        this.nombre = nombre;
        this.gymnasts = new ArrayList<>();
    }

    public boolean addGymnast(Gymnast gymnast) {
        boolean result=false;
        if(!gymnasts.contains(gymnast)){
            gymnasts.add(gymnast);
            result=true;
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
}
