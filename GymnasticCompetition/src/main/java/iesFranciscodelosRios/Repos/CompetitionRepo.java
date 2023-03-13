package iesFranciscodelosRios.Repos;


import iesFranciscodelosRios.model.Competition;

import java.util.ArrayList;
import java.util.Iterator;

public class CompetitionRepo {
    ArrayList<Competition> competitions = new ArrayList<Competition>();

    /**
     * Add a competition
     *
     * @param competition add
     * @return True if it has been added successfully and false if not
     */
    public boolean addCompetition(Competition competition) {
        boolean result = false;
        if (competition != null && !isCompetition(competition)) {
            competitions.add(competition);
            result = true;
        }

        return result;
    }

    /**
     * To see a competition
     *
     * @param name: competition key
     * @return The competition sought by the parameters
     */
    public Competition showCompetition(String name) {
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

        if (competition != null && showCompetition(competition.getName()) != null) {
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

        if (competitions != null && showCompetition(competition.getName()) != null) {
            Iterator<Competition> it = competitions.iterator();
            while (it.hasNext()) {
                Competition competitions = it.next();
                if (competitions.equals(competition)) {
                    it.remove();
                    result = true;
                }
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

    public void showAllCompetitions(ArrayList<Competition> competitions) {
        for (Competition competition : competitions) {
            System.out.println(competition);
        }
    }

}