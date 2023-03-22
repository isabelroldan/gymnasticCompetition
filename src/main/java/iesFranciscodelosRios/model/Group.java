package iesFranciscodelosRios.model;

import iesFranciscodelosRios.Enum.Category;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import java.util.ArrayList;

@XmlAccessorType(XmlAccessType.FIELD)
public class Group {

    private String Name;

    private ArrayList<Gymnast> gymasts=new ArrayList<>();

    private Club club;
    private Category category;

    public Group(String name, Club club, Category category) {
        Name = name;
        this.club = club;
        this.category=category;
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

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }

    public Category getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "Group: \n\t" +
                "Name: " + Name + "\n\t" +
                "Club:"+club;
    }
}



