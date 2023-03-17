package iesFranciscodelosRios.Repos;

import iesFranciscodelosRios.Utils.Read;
import iesFranciscodelosRios.Utils.Utils;
import iesFranciscodelosRios.model.Club;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.HashMap;
import java.util.Map;
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class RepoClub {
    private Map<String,Club> clubs= new HashMap<>();
    @XmlTransient
    private static RepoClub _instance=null;
    private RepoClub(){

    }
    public boolean addClub(Club aux){
        boolean result=false;
        if(!clubs.containsKey(aux.getNombre())){
            clubs.put(aux.getNombre(),aux);
            result=true;
        }
        return result;
    }
    public boolean removeClub(String name){
        boolean result=false;
        if(clubs.containsKey(name) && Utils.confirm("Are you sure that you like remove the "+name+" club?")){
            clubs.remove(name);
            result=true;
        }
        return result;
    }
    public boolean updateClub(String name){
        boolean result=false;
        if(clubs.containsKey(name) && Utils.confirm("Are you sure that you like update the name of the "+name+" club?")){
            clubs.get(name).setNombre(Read.readString("Enter a new name"));
            result=true;
        }
        return result;
    }
    public Club searchClub(String name){
        return clubs.get(name);
    }
    public Map<String,Club> getClubs(){
        return clubs;
    }
    public static RepoClub get_instance(){
        if(_instance==null){
            _instance=new RepoClub();
        }
        return _instance;
    }
}
