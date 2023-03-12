package iesFranciscodelosRios.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Competition {
    private String name;
    private String description;
    private String initialDate;
    ArrayList<Trial> trials = new ArrayList<Trial>();

    Map<Integer, Participation> participations = new HashMap<>();


    public boolean addTrial(Trial trial) {
        boolean result = false;
        if(trial!=null && !isTrial(trial)) {
            trials.add(trial);
            result = true;
        }

        return result;
    }


    public Trial showTrial(String type, String category, String kit) {
        return null;
    }

    public boolean changeTrial(Trial trial) {
        return false;
    }

    public boolean removeTrial(Trial trial) {
        return false;
    }


    public boolean isTrial(Trial trial) {
        return false;
    }


    public boolean addParticipation(Participation participation, int key) {
        return false;
    }

    public Participation showParticipation(int dorsalNumber) {
        return null;
    }

    public void showAllParticipation(){

    }

    public boolean removeParticipation(Participation participation, int key) {
        return false;
    }

    public boolean changeParticipation(Map<Integer, Participation> participation) {
        return false;
    }

    public boolean isParticipation(Participation participation) {
        return false;
    }

}