package iesFranciscodelosRios.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;


public class Person{
    /**
     * Creacion de las clases protegidas DNI,Name,Phone y Mail
     */
    protected String DNI;
    protected String Name;
    protected int Phone;
    protected String Mail;

    /**
     * Constructores por defecto y full-equip
     */
    public Person() {

    }

    public Person(String DNI, String name, int phone, String mail) {
        this.DNI = DNI;
        this.Name = name;
        this.Phone = phone;
        this.Mail = mail;
    }

    /**
     * Getters and setters
     */
    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getPhone() {
        return Phone;
    }

    public void setPhone(int phone) {
        Phone = phone;
    }

    public String getMail() {
        return Mail;
    }

    public void setMail(String mail) {
        Mail = mail;
    }

    /**
     * Equals
     */
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Person other = (Person) obj;
        if (DNI == null) {
            if (other.DNI != null)
                return false;
        } else if (!DNI.equals(other.DNI))
            return false;
        if (Phone != other.Phone)
            return false;
        return true;
    }

    /**
     *To String
     */
    @Override
    public String toString() {
        return "Gymnast: \n\t" +
                "DNI='" + DNI + "\n\t" +
                "Name:'" + Name + "\n\t" +
                "Phone:" + Phone +"\n\t"+
                "Mail:'" + Mail;
    }


}
