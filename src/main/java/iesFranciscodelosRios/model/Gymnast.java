package iesFranciscodelosRios.model;
import iesFranciscodelosRios.Enum.Category;

public class Gymnast extends Person{
    private Category cat;
    private String Club;

    public Gymnast(String DNI, String name, int phone, String mail, Category cat, String club) {
        super(DNI, name, phone, mail);
        this.cat = cat;
        this.Club = club;
    }

    public Category getCat() {
        return cat;
    }

    public void setCat(Category cat) {
        this.cat = cat;
    }

    public String getClub() {
        return Club;
    }

    public void setClub(String club) {
        Club = club;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Gymnast{" +
                "cat=" + cat +
                ", Club='" + Club + '\'' +
                '}';
    }

}
