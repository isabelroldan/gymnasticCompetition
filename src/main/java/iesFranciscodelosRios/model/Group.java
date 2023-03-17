package iesFranciscodelosRios.model;

import java.util.ArrayList;

public class Group {

    private String Name;

    private ArrayList<Gymnast> gymasts;

    private String club;

    public Group(String name, ArrayList<Gymnast> gymasts, String club) {
        Name = name;
        this.gymasts = gymasts;
        this.club = club;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public ArrayList<Gymnast> getGymasts() {
        return gymasts;
    }

    public void setGymasts(ArrayList<Gymnast> gymasts) {
        this.gymasts = gymasts;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    @Override
    public String toString() {
        return "Group{" +
                "Name='" + Name + '\'' +
                ", gymasts=" + gymasts +
                ", club=" + club +
                '}';
    }
}
