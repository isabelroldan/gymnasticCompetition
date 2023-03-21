package iesFranciscodelosRios.Repos;



import iesFranciscodelosRios.model.Competition;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Logger;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public final class CompetitionRepo {
	@XmlTransient
	private final static Logger logger= iesFranciscodelosRios.Utils.Logger.CreateLogger("iesFranciscodelosRios.Repos.Competition");
	@XmlElement(name="Competition")
    private ArrayList<Competition> competitions = new ArrayList<>();
	
	@XmlTransient
	private static CompetitionRepo _instance = null;
    public CompetitionRepo() {
    	
    }

    /**
     * Add a competition
     *
     * @param competition add
     * @return True if it has been added successfully and false if not
     */
    public boolean addCompetition(Competition competition) {
        boolean result = false;
        try {
        	if (competition != null && !isCompetition(competition)) {
                competitions.add(competition);
                result = true;
            }
        }catch (NullPointerException e) {
        	logger.severe("An Error Occurred: "+e.getMessage());
        }finally{
        	if(!result) {
        		logger.warning("addCompetition failed to initialize");
        	}
        }
        

        return result;
    }

    /**
     * To see a competition
     *
     * @param name: competition key
     * @return The competition sought by the parameters
     */
    public Competition searchCompetition(String name) {
        Competition competition = null;
        if (competitions != null) {
            Iterator<Competition> it = competitions.iterator();
            while (it.hasNext()) {
                Competition Competition = it.next();
                if (Competition.getName().equalsIgnoreCase(name)) {
                    return Competition;
                }

            }
        }


        return competition;
    }

    /**
     * Method to change a competition
     *
     * @param competition to change
     * @return true if the change was successful and false if not
     */
    public boolean changeCompetition(Competition competition) {
        boolean result = false;

        if (competition != null && searchCompetition(competition.getName()) != null) {
            Iterator<Competition> it = competitions.iterator();
            while (it.hasNext()) {
                Competition competitions = it.next();
                if (competitions.equals(competition)) {
                    competitions = competition;
                    result = true;
                }
            }
        }

        return result;
    }

    /**
     * Method to delete a competition
     *
     * @param competition to delete
     * @return true if the delete was successful and false if not
     */
    public boolean removeCompetition(Competition competition) {
        boolean result = false;
        try {
        	if (competitions != null && searchCompetition(competition.getName()) != null) {
                Iterator<Competition> it = competitions.iterator();
                while (it.hasNext()) {
                    Competition competitions = it.next();
                    if (competitions.equals(competition)) {
                        it.remove();
                        result = true;
                    }
                }
            }
        }catch (Exception e) {
        	logger.severe("An Error Ocurred: "+e.getMessage());
        }finally {
        	if (!result) {
        		logger.warning("removeCompetition failed to initialize");
        	}
        }
        


        return result;
    }

    /**
     * Look for competition
     *
     * @param competition to search
     * @return true if found and false if not
     */
    public boolean isCompetition(Competition competition) {
        boolean result = false;
        Iterator<Competition> it = competitions.iterator();
        while (it.hasNext()) {
            Competition competitions = it.next();
            if (competitions != null && competition.equals(competitions)) {
                result = true;
                break;
            }

        }

        return result;
    }

    public void showAllCompetitions() {
    	try {
    		for (Competition competition : competitions) {
                System.out.println(competition);
            }
    	}catch (NullPointerException e) {
    		logger.severe("An Error Ocurred: "+e.getMessage());
    	}
        
    }

    public static void set_instance(CompetitionRepo _instance) {
        CompetitionRepo._instance = _instance;
    }

    public static CompetitionRepo get_instance() {
    	if(_instance == null) {
    		_instance = new CompetitionRepo();
    	}
    	return _instance;
    }

}