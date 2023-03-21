package iesFranciscodelosRios.model;

import iesFranciscodelosRios.Enum.Category;
import iesFranciscodelosRios.Repos.RepoClub;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 * clase gymnast que hereda de la clase person
 */

@XmlAccessorType(XmlAccessType.FIELD)
public class Gymnast extends Person{
    /**
     * Creacion de categoria y club
     */
    private Category cat;
    private String Club;

    /**
     * Constructores por defecto y full-equip
     */

    public Gymnast() {

    }

    public Gymnast(String DNI, String name, String phone,String surname, String mail, Category cat, String club) {
        super(DNI, name,surname, phone, mail);
        this.cat = cat;
        this.Club = club;
    }

    /**
     * Getters de categoria y club
     */
    public Category getCat() {
        return cat;
    }

    public String getClub() {
        return Club;
    }

    /**
     * setters de categoria y club
     */
    public void setCat(Category cat) {

        this.cat = cat;
    }

    public void setClub(String name) {
        Club = RepoClub.get_instance().searchClub(name).getName();
    }

    /**
     * toString de la clase gymnast
     * que concatena con el to string de persona
     */
    @Override
    public String toString() {
        return super.toString() +"\n\t" +
                "Category: " + cat + "\n\t" +
                "Club: "+Club +"\n\t";
    }

}