package iesFranciscodelosRios.Repos;

import iesFranciscodelosRios.Utils.Utils;
import iesFranciscodelosRios.model.Club;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class RepoClub {
    @XmlTransient
    private final static Logger logger = iesFranciscodelosRios.Utils.Logger.CreateLogger("iesFranciscodelosRios.Repos.RepoClub");
    private Map<String, Club> clubs = new HashMap<>();
    @XmlTransient
    private static RepoClub _instance = null;

    private RepoClub() {
        //clubs= XMLManager.readXML(RepoClub.this,"Clubs.xml").getClubs();
    }

    public boolean addClub(Club aux) {
        boolean result = false;
        try {
            for (String key : clubs.keySet()) {
                if (key.equalsIgnoreCase(aux.getName())) {
                    return false;
                }
            }
            clubs.put(aux.getName(), aux);
            result = true;
        } catch (NullPointerException e) {
            logger.severe("Error method addClub " + e.getMessage());
        } finally {
            if (!result) {
                logger.warning("Warning. method add. It has not been executed correctly");
            }
        }
        return result;
    }

    public boolean removeClub(String name) {
        boolean result = false;
        try {
            if (clubs.containsKey(name) && Utils.confirm("Are you sure that you like remove the " + name + " club?")) {
                clubs.remove(name);
                result = true;
            }
        } catch (NullPointerException e) {
            logger.severe("Error method removeClub " + e.getMessage());
        } finally {
            if(!result){
                logger.warning("Warning. method removeClub. It has not been executed correctly");
            }
        }
        return result;
    }

    public Club searchClub(String name) {
        Club result=null;
        try{
            for (String clubName:clubs.keySet()){
                if(clubName.equalsIgnoreCase(name)){
                    result=clubs.get(clubName);
                }
            }
        }catch (NullPointerException e) {
            logger.severe("Error method searchClub " + e.getMessage());
        } finally {
            if(result==null){
                logger.warning("Warning. method searchClub. It has not been executed correctly");
            }
        }
        return result;
    }

    public Map<String, Club> getClubs() {
        return clubs;
    }

    public static void set_instance(RepoClub _instance) {
        RepoClub._instance = _instance;
    }

    public static RepoClub get_instance() {
        if (_instance == null) {
            _instance = new RepoClub();
        }
        return _instance;
    }
}
