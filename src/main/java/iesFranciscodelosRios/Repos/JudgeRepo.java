package iesFranciscodelosRios.Repos;

import iesFranciscodelosRios.Utils.Read;
import iesFranciscodelosRios.Utils.Utils;
import iesFranciscodelosRios.model.Judge;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.ArrayList;
import java.util.logging.Logger;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public final class JudgeRepo {
    @XmlTransient
    private final static Logger logger = iesFranciscodelosRios.Utils.Logger.CreateLogger("iesFranciscodelosRios.Repos.RepoJudge");
    private ArrayList<Judge> judges = new ArrayList<>();
    @XmlTransient
    private static JudgeRepo _instance = null;

    private JudgeRepo() {
    }

    public boolean add(Judge j) {
        try {
            for (Judge judge : judges) {
                if (judge.equals(j)) {
                    return false;
                }
            }
            judges.add(j);
        } catch (NullPointerException e) {
            logger.severe("Error method add " + e.getMessage());
        }
        return true;
    }

    public boolean remove(String dni, char[] password) {
        boolean result = false;
        try {
            if (search(dni) != null && Utils.confirm("Are you sure to delete this judge?") && search(dni).login(password)) {
                judges.remove(search(dni));
                result = true;
            }
        } catch (NullPointerException e) {
            logger.severe("Error method remove. " + e.getMessage());
        } finally {
            if (!result) {
                logger.warning("Warning. method remove. It has not been executed correctly");
            }
        }
        return result;
    }

    public Judge search(String dni) {
        Judge result = null;
        try {
            for (Judge aux : judges) {
                if (aux.getDNI().equalsIgnoreCase(dni)) {
                    result = aux;
                }
            }
        } catch (NullPointerException e) {
            logger.severe("Error method search. " + e.getMessage());
        } finally {
            if (result == null) {
                logger.warning("Warning. method search. It has not been executed correctly");
            }
        }
        return result;
    }

    public ArrayList<Judge> getJudges() {
        return judges;
    }

    public static void set_instance(JudgeRepo _instance) {
        JudgeRepo._instance = _instance;
    }

    public static JudgeRepo get_instance() {
        if (_instance == null) {
            _instance = new JudgeRepo();
        }
        return _instance;
    }
}
