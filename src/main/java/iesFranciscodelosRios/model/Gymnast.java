package iesFranciscodelosRios.model;

import iesFranciscodelosRios.Enum.Category;
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
    private Club Club;

    /**
     * Constructores por defecto y full-equip
     */

    public Gymnast() {

    }

    public Gymnast(String DNI, String name, int phone, String mail, Category cat, Club club) {
        super(DNI, name, phone, mail);
        this.cat = cat;
        this.Club = club;
    }

    /**
     * Getters de categoria y club
     */
    public Category getCat() {
        return cat;
    }

    public Club getClub() {
        return Club;
    }

    /**
     * setters de categoria y club
     */
    public void setCat(Category cat) {

        this.cat = cat;
    }

    public void setClub(Club club) {

        Club = club;
    }

    /**
     * toString de la clase gymnast
     * que concatena con el to string de persona
     */
    @Override
    public String toString() {
        return super.toString() +"\n\t" +
                "Category: " + cat + "\n\t" +
                "Club: " + Club +"\n\t";
    }
}