package iesFranciscodelosRios.Repos;

import iesFranciscodelosRios.model.Gymnast;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Logger;
import javax.xml.bind.annotation.*;
import iesFranciscodelosRios.interfaces.iRepoGymnast;
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public final class RepoGymnast implements iRepoGymnast  {
    @XmlTransient
    private final static Logger logger= iesFranciscodelosRios.Utils.Logger.CreateLogger("iesFranciscodelosRios.Repos.RepoGymnast");
    @XmlElement(name="Gymnast")
    private ArrayList<Gymnast> gymnastes=new ArrayList<>();
    @XmlTransient
    private static RepoGymnast _instance =null;
    private RepoGymnast() {

    }
    /**
     * metodo encargado de añadir un gimnasta al arraylist
     * recibe los datos del gimnasta
     * @return true si se añade correctamente, false si exsiste
     */
    @Override
    public boolean addGymnast(Gymnast gym) {
        boolean result=false;
        try {
            if (!gymnastes.contains(gym) || gym.getPhone() == null || gym.getMail() == null || gym.getCat() == null) {
                gymnastes.add(gym);
                result = true;
            }
        }catch (NullPointerException e){
            logger.severe("An Error Occurred: "+e.getMessage());

        }finally {
            if(!result){
                logger.warning("addGymnast failed to initialize");
            }
        }
        return result;
    }

    /**
     * metodo encargado de elminar los datos del gimnasta buscandolo mediante su DNI
     * @param DNI del gimnasta existente
     * @return gimnasta eliminado=true false=no se ha borrado
     */
    @Override
    public boolean deleteGymnast(String DNI) {
        boolean result = false;
        try {
            Gymnast gym = showGymnast(DNI);
            if (gym != null) {
                result = gymnastes.remove(gym);
                if(result){
                    System.out.println("Gymnast with DNI: "+DNI+" has been deleted successfully");
                }
            }
        } catch (Exception e) {
            logger.severe("An Error Occurred: " + e.getMessage());
        } finally {
            if (!result) {
                logger.warning("deleteGymnast failed to initialize ");
            }
        }
        return result;
    }

    /**
     *Netodo que muestra los datos del gimnasta
     * @param DNI del gimnasta a mostrar
     * @return datos del gimnasta en pantalla
     */
    @Override
    public Gymnast showGymnast(String DNI) {
        Gymnast result = null;
        for (Gymnast gymnast : gymnastes){
            if(gymnast.getDNI().equals(DNI)){
                result=gymnast;
            }
        }
        return result;
    }

    /**
     *Muestra todos los datos almacenados del arrayList
     */
    public void ShowAll() {
        boolean result=false;
        try {
            if (gymnastes.isEmpty()) {
                System.out.println("No Gymnastes added.");
            } else {
                System.out.println("Gymnast List:");
                Collections.sort(gymnastes);
                for (Gymnast gymnast : gymnastes) {
                    System.out.println(gymnast);
                }
                result=true;
            }
        }catch (NullPointerException e){
            logger.severe("An Error Occurred: "+e.getMessage());
        }finally {
            if (!result) {
                logger.warning("ShowAll failed to initialize");
            }

        }
    }

    public static void set_instance(RepoGymnast _instance) {
        RepoGymnast._instance = _instance;
    }

    public static RepoGymnast get_instance() {
        if(_instance == null){
            _instance = new RepoGymnast();
        }
        return _instance;
    }


}