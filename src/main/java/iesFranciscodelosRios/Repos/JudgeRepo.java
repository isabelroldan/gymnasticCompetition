package iesFranciscodelosRios.Repos;

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
    private final static Logger logger = iesFranciscodelosRios.Utils.Logger.CreateLogger("iesFranciscodelosRios.Repos.RepoGymnast");
    private ArrayList<Judge> judges = new ArrayList<>();
    @XmlTransient
    private static JudgeRepo _instance = null;

    private JudgeRepo() {
        _instance = new JudgeRepo();
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
        } finally {
            logger.warning("Warning. method add. It has not been executed correctly");
        }
        return true;
    }

    public boolean remove(String dni) {
        try {
            for (Judge j : judges) {
                if (j.getDNI().equalsIgnoreCase(dni)) {
                    judges.remove(j);
                    return true;
                }
            }
        } catch (NullPointerException e) {
            logger.severe("Error method remove. " + e.getMessage());
        } finally {
            logger.warning("Warning. method remove. It has not been executed correctly");
        }
        return false;
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
            logger.warning("Warning. method search. It has not been executed correctly");
        }
        return result;
    }

    public ArrayList<Judge> getJudges() {
        return judges;
    }

    public static JudgeRepo get_instance() {
        if (_instance == null) {
            return _instance;
        }
        return _instance;
    }
}
