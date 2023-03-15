
package iesFranciscodelosRios.model;

import iesFranciscodelosRios.Enum.Category;


/**
 * clase gymnast que hereda de la clase person
 */
public class Gymnast extends Person{
    /**
     * Creacion de categoria y club
     */
    private Category cat;
    private String Club;

    /**
     * constructor full-equip
     */
    public Gymnast(String DNI, String name, int phone, String mail, Category cat, String club) {
        super(DNI, name, phone, mail);
        this.cat = cat;
        this.Club = club;
    }

    /**
     * Getters de categoria y club
     * @return
     */
    public Category getCat() {
        return cat;
    }

    public String getClub() {
        return Club;
    }

    /**
     * setters de categoria y club
     * @param cat
     */
    public void setCat(Category cat) {
        this.cat = cat;
    }

    public void setClub(String club) {
        Club = club;
    }

    /**
     * toString de la clase gymnast
     */
    @Override
    public String toString() {
        return super.toString() +
                "Gymnast{" +
                "cat=" + cat +
                ", Club='" + Club + '\'' +
                '}';
    }


}
