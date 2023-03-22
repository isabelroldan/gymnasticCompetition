package iesFranciscodelosRios.model;

import java.util.*;

import iesFranciscodelosRios.Enum.Category;
import iesFranciscodelosRios.Enum.Kit;
import iesFranciscodelosRios.Enum.Type;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class Competition {

    private String name;
    private String description;
    private Date initialDate;
    private ArrayList<Trial> trials = new ArrayList<>();
    private Map<Integer, Participation> participations = new HashMap<>();
    private ArrayList<Group> groups = new ArrayList<>();
    private Judge judge;

    public Competition(String name, String description, Date initialDate) {
        this.name = name;
        this.description = description;
        this.initialDate = initialDate;
    }


    public Competition() {
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setInitialDate(Date initialDate) {
        this.initialDate = initialDate;
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
    public Trial searchTrial(Type type, Category category, Kit kit) {
        Trial trial = null;
        if (trials != null) {
            Iterator<Trial> it = trials.iterator();
            while (it.hasNext()) {
                Trial Trial = it.next();
                if (trial.getType().equals(type) && trial.getCategory().equals(category) && trial.getKit().equals(kit)) {
                    trial = Trial;
                }
            }
        }
        return trial;
    }
    public void showAllTrial(){
        if(trials!=null){
            for (Trial t:trials){
                System.out.println(t);
            }
        }
    }


    public boolean removeTrial(Trial trial) {
        if (trial == null) {
            return false;
        }

        Type trialType = trial.getType();
        Category trialCategory = trial.getCategory();
        Kit trialKit = trial.getKit();

        if (trialType == null || trialCategory == null || trialKit == null) {
            return false;
        }

        Trial matchingTrial = searchTrial(trialType, trialCategory, trialKit);

        if (matchingTrial == null || !matchingTrial.equals(trial)) {
            return false;
        }

        Iterator<Trial> it = trials.iterator();
        while (it.hasNext()) {
            if (it.next().equals(trial)) {
                it.remove();
                return true;
            }
        }

        return false;
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
        Iterator<Integer> it = participations.keySet().iterator();//tambien se puede recorer con un forEach
        while (it.hasNext()) {
            Integer key = it.next();
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
                group = it.next();
                if (group.getName().equals(name)) {
                    return group;
                }
            }
        }
        return group;
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

    /**
     * Insert gymnasts to a group
     *
     * @param groupName: Name of the group to insert into
     * @param gymnast:   to insert in group
     * @return true if add was successful and false if not
     */
    public boolean insertGymnast(String groupName, Gymnast gymnast) {
        boolean result = false;

        Group group = showGroup(groupName);
        if (group != null && group.getGymasts().size()<=4 && group.getClub().equals(gymnast.getClub()) && group.getCategory().equals(gymnast.getCat())) {
            group.getGymasts().add(gymnast);
            result = true;
        }

        return result;
    }

    /**
     * Remove gymnasts to a group
     *
     * @param group:   group to delete into
     * @param gymnast: to delete in group
     * @return true if remove was successful and false if not
     */
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