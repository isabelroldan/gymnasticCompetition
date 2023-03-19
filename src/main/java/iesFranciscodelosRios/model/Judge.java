package iesFranciscodelosRios.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import java.util.Objects;

@XmlAccessorType(XmlAccessType.FIELD)
public final class Judge extends Person{
    private char[] password;
    public Judge() {

    }

    public Judge(String DNI, String name, int phone, String mail, char[] password) {
        super(DNI, name, phone, mail);
        this.password = password;
    }

    public char[] getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Judge judge = (Judge) o;
        return Objects.equals(getDNI(), judge.getDNI());
    }
}
