package iesFranciscodelosRios.model;

public class Person{
    protected String DNI;
    protected String Name;
    protected int Phone=0;
    protected String Mail;

    public Person(){
        
    }
    public Person(String DNI, String name, int phone, String mail) {
        this.DNI = DNI;
        this.Name = name;
        this.Phone = phone;
        this.Mail = mail;
    }

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

    @Override
    public String toString() {
        return "Person{" +
                "DNI='" + DNI + '\'' +
                ", Name='" + Name + '\'' +
                ", Phone=" + Phone +
                ", Mail='" + Mail + '\'' +
                '}';
    }


}
