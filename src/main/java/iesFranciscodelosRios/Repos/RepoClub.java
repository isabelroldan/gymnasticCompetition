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
    private final static Logger logger = iesFranciscodelosRios.Utils.Logger.CreateLogger("iesFranciscodelosRios.Repos.RepoGymnast");
    private Map<String, Club> clubs = new HashMap<>();
    @XmlTransient
    private static RepoClub _instance = null;

    private RepoClub() {

    }

    public boolean addClub(Club aux) {
        boolean result = false;
        try {
            for (String key : clubs.keySet()) {
                if (key.equalsIgnoreCase(aux.getNombre())) {
                    return false;
                }
            }
            clubs.put(aux.getNombre(), aux);
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
            logger.warning("Warning. method removeClub. It has not been executed correctly");
        }
        return result;
    }

    public Club searchClub(String name) {
        return clubs.get(name);
    }

    public Map<String, Club> getClubs() {
        return clubs;
    }

    public static RepoClub get_instance() {
        if (_instance == null) {
            _instance = new RepoClub();
        }
        return _instance;
    }
}
