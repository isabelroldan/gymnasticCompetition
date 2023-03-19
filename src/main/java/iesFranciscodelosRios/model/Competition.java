package iesFranciscodelosRios.model;

import java.util.*;

import iesFranciscodelosRios.Enum.Category;
import iesFranciscodelosRios.Enum.Kit;
import iesFranciscodelosRios.Enum.Type;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Competition {

    private String name;
    private String description;
    private String initialDate;
    private ArrayList<Trial> trials = new ArrayList<>();
    private Map<Integer, Participation> participations = new HashMap<>();
    private ArrayList<Group> groups = new ArrayList<>();
    private Judge judge;

    public Competition(String name, String description, String initialDate) {
        this.name = name;
        this.description = description;
        this.initialDate = initialDate;
    }


    public Competition() {
        this("", "", "");
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }


    public String getInitialDate() {
        return initialDate;
    }


    public void setInitialDate(String initialDate) {
        this.initialDate = initialDate;
    }


    public ArrayList<Trial> getTrials() {
        return trials;
    }


    public void setTrials(ArrayList<Trial> trials) {
        this.trials = trials;
    }


    public Map<Integer, Participation> getParticipations() {
        return participations;
    }


    public void setParticipations(Map<Integer, Participation> participations) {
        this.participations = participations;
    }


    public ArrayList<Group> getGroups() {
        return groups;
    }


    public void setGroups(ArrayList<Group> groups) {
        this.groups = groups;
    }


    @Override
    public int hashCode() {
        return Objects.hash(name);
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Competition other = (Competition) obj;
        return Objects.equals(name, other.name);
    }

    @Override
    public String toString() {
        return "Competition "
                + "\n\tName:" + name
                + "\n\tDescription=" + description
                + "\n\tInitial date=" + initialDate;
    }

    /**
     * Add a trial
     *
     * @param trial add
     * @return True if it has been added successfully and false if not
     */
    public boolean addTrial(Trial trial) {
        boolean result = false;
        if (trial != null && !isTrial(trial)) {
            trials.add(trial);
            result = true;
        }

        return result;
    }

    /**
     * To see a trial
     *
     * @param type:     trial key
     * @param category: trial key
     * @param kit:      trial key
     * @return The trial sought by the parameters
     */
    public Trial showTrial(Type type, Category category, Kit kit) {
        Trial trial = null;
        if (trials != null) {
            Iterator<Trial> it = trials.iterator();
            while (it.hasNext()) {
                Trial Trial = it.next();
                if (trial.getType().equals(type) &&
                        trial.getCategory().equals(category) &&
                        trial.getKit().equals(kit)) {
                    return trial;
                }
            }
        }
        return trial;
    }

    /**
     * Method to change a trial
     *
     * @param trial to change
     * @return true if the change was successful and false if not
     */
    public boolean changeTrial(Trial trial) {
        boolean result = false;

        if (trial != null) {
            Type trialType = trial.getType();
            if (trialType != null) {
                Category trialCategory = trial.getCategory();
                if (trialCategory != null) {
                    Kit trialKit = trial.getKit();
                    if (trialKit != null) {
                        if (showTrial(trial.getType(), trial.getCategory(), trial.getKit()) != null) {
                            Iterator<Trial> it = trials.iterator();
                            while (it.hasNext()) {
                                Trial trials = it.next();
                                if (trials.equals(trial)) {
                                    trials = trial;
                                    result = true;
                                }
                            }
                        }
                    }
                }
            }
        }

        return result;
    }

    /**
     * Method to delete a trial
     *
     * @param trial to delete
     * @return true if the delete was successful and false if not
     */
    public boolean removeTrial(Trial trial) {
        boolean result = false;

        if (trial != null) {
            Type trialType = trial.getType();
            if (trialType != null) {
                Category trialCategory = trial.getCategory();
                if (trialCategory != null) {
                    Kit trialKit = trial.getKit();
                    if (trialKit != null) {
                        if (showTrial(trial.getType(), trial.getCategory(), trial.getKit()) != null) {
                            Iterator<Trial> it = trials.iterator();
                            while (it.hasNext()) {
                                Trial trials = it.next();
                                if (trials.equals(trial)) {
                                    it.remove();
                                    result = true;
                                }
                            }
                        }
                    }
                }
            }
        }

        return result;
    }

    /**
     * Look for trial
     *
     * @param trial to search
     * @return true if found and false if not
     */
    public boolean isTrial(Trial trial) {
        boolean result = false;
        Iterator<Trial> it = trials.iterator();
        while (it.hasNext()) {
            Trial trials = it.next();
            if (trials != null && trial.equals(trials)) {
                result = true;
                break;
            }

        }

        return result;
    }

    /**
     * Add a participation
     *
     * @param participation add
     * @param key           add
     * @return True if it has been added successfully and false if not
     */
    public boolean addParticipation(Participation participation, int key) {
        boolean result = false;
        if (participation != null && !isParticipation(participation)) {
            participations.put(participation.getDorsal(), participation);
            result = true;
        }

        return result;
    }

    /**
     * To see a participation
     *
     * @param dorsalNumber participation key
     * @return The participation sought by the parameters
     */
    public Participation showParticipation(int dorsalNumber) {

        Participation participation = null;
        Iterator<Integer> it = participations.keySet().iterator();
        while (it.hasNext()) {
            Integer key = it.next();
            participation = participations.get(dorsalNumber);
        }

        return participation;
    }

    /**
     * To see all participations
     */
    public void showAllParticipation() {
        Participation participation = null;
        Iterator<Integer> it = participations.keySet().iterator();//tambien se puede recorer con un forEach
        while (it.hasNext()) {
            Integer key = it.next();
            //esto te da el valor perteneciente a esa key:
            System.out.println(participations.get(key));
        }
    }

    /**
     * Method to delete a participation
     *
     * @param participation to delete
     * @return true if the delete was successful and false if not
     */
    public boolean removeParticipation(Participation participation, int key) {
        boolean result = false;
        if (participation != null && !isParticipation(participation)) {
            participations.remove(participation.getDorsal(), participation);
            result = true;
        }

        return result;
    }

    /**
     * Method to change a particpation
     *
     * @param participation to change
     * @return true if the change was successful and false if not
     */
    public boolean changeParticipation(Participation participation) {
        boolean result = false;

        if (participation != null && showParticipation((participation).getDorsal()) != null) {
            Iterator<Integer> it = participations.keySet().iterator();
            while (it.hasNext()) {
                Integer key = it.next();
                if (participations.equals(participation)) {
                    participations.put(participation.getDorsal(), participation);
                    result = true;
                }
            }
        }

        return result;
    }

    /**
     * Look for participation
     *
     * @param participation to search
     * @return true if found and false if not
     */
    public boolean isParticipation(Participation participation) {
        boolean result = false;
        Iterator<Integer> it = participations.keySet().iterator();
        while (it.hasNext()) {
            Integer key = it.next();
            if (participations != null && participation.equals(participations)) {
                result = true;
                break;
            }

        }

        return result;
    }

    /**
     * Add a group
     *
     * @param group add
     * @return True if it has been added successfully and false if not
     */
    public boolean addGroup(Group group) {
        boolean result = false;
        if (group != null && !isGroup(group)) {
            groups.add(group);
            result = true;
        }

        return result;
    }

    /**
     * To see a group
     *
     * @param name: group key
     * @return The group sought by the parameters
     */
    public Group showGroup(String name) {
        Group group = null;
        if (groups != null) {
            Iterator<Group> it = groups.iterator();
            while (it.hasNext()) {
                Group Group = it.next();
                if (group.getName().equals(name)) {
                    return group;
                }
            }
        }
        return group;
    }

    /**
     * Method to change a group
     *
     * @param group to change
     * @return true if the change was successful and false if not
     */
    public boolean changeGroup(Group group) {
        boolean result = false;

        if (group != null && showGroup(group.getName()) != null) {
            Iterator<Group> it = groups.iterator();
            while (it.hasNext()) {
                Group groups = it.next();
                if (groups.equals(group)) {
                    groups = group;
                    result = true;
                }
            }
        }

        return result;
    }

    /**
     * Method to delete a group
     *
     * @param group to delete
     * @return true if the delete was successful and false if not
     */
    public boolean removeGroup(Group group) {
        boolean result = false;


        if (groups != null && showGroup(group.getName()) != null) {
            Iterator<Group> it = groups.iterator();
            while (it.hasNext()) {
                Group groups = it.next();
                if (groups.equals(group)) {
                    it.remove();
                    result = true;
                }
            }
        }


        return result;
    }

    /**
     * Look for group
     *
     * @param group to search
     * @return true if found and false if not
     */
    public boolean isGroup(Group group) {
        boolean result = false;
        Iterator<Group> it = groups.iterator();
        while (it.hasNext()) {
            Group groups = it.next();
            if (groups != null && group.equals(groups)) {
                result = true;
                break;
            }

        }

        return result;
    }

    public boolean insertGymnast(String groupName, Gymnast gymnast) {
        boolean result = false;

        Group group = null;
        for (Group g : groups) {
            if (g.getName().equals(groupName)) {
                group = g;
                break;

            }
        }

        if (group == null) {
            result = false;
        }

        if (group.getGymasts() == null) {
            group.setGymasts(new ArrayList<>());
        }

        if (group.getClub() == gymnast.getClub()) {
            group.getGymasts().add(gymnast);
            result = true;
        }

        return result;
    }

    public boolean removeGymnast(Group group, Gymnast gymnast) {
        boolean result = false;

        if (group != null && gymnast != null) {
            ArrayList<Gymnast> gymnasts = group.getGymasts();

            if (gymnasts != null && gymnasts.contains(gymnast)) {
                gymnasts.remove(gymnast);
                result = true;
            }
        }

        return result;
    }
    public Judge getJudge() {
        return judge;
    }

    public void setJudge(Judge judge) {
        this.judge = judge;
    }

}