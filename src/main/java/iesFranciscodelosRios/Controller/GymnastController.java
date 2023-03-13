package iesFranciscodelosRios.Controller;


import iesFranciscodelosRios.Enum.Category;
import iesFranciscodelosRios.GUI.GUI;
import iesFranciscodelosRios.Repos.RepoGymnast;
import iesFranciscodelosRios.interfaces.*;
import iesFranciscodelosRios.Utils.*;
import iesFranciscodelosRios.model.Gymnast;

public class GymnastController implements iController {
    private static iGUI myGUI=new GUI();
    RepoGymnast repoGym=new RepoGymnast();
    @Override
    public void main() {

        int opt;
        do{
            myGUI.crudGymnastic();
            switch (opt=Read.readInt("Select Option")){
                case 0:
                    System.out.println("Go Back");
                    break;
                case 1:
                    add();
                    break;
                case 2:
                    show();
                    break;
                case 3:
                    modify();
                    break;
                case 4:
                    delete();
                    break;
                case 5:
                    showAll();
                    break;
                default:
                    System.out.println("Wrong Option");
            }

        }while (opt!=5);

    }

    @Override
    public void add() {
        Gymnast gym=new Gymnast(
                Read.readDNI("Insert Gymnast's DNI: "),
                Read.readString("Insert Gymnast's name: "),
                Read.readInt("Insert Gymnast's phone: "),
                Read.readString("Insert Gymnast's mail: "),
                Category.fromName(Read.readString("Insert Gymnast's Category:")),
                Read.readString("Insert Gymnast Club's name: "));
        repoGym.addGymnast(gym);
    }

    @Override
    public void show() {
        String DNI=Read.readDNI("Insert Gymnast's DNI to search: ");
        Gymnast gym=repoGym.showGymnast(DNI);
        if (gym!= null) {
            System.out.println("Gymnast Founded: " + gym.toString());
        } else {
            System.out.println("404 Gymnast Not Found");
        }
    }

    @Override
    public void delete() {
        String DNI = Read.readDNI("Insert Gymnast's DNI to Delete: ");
        boolean deleted = repoGym.deleteGymnast(DNI);
        if (deleted) {
            System.out.println("Gymnast Deleted Successfully");
        } else {
            System.out.println("404 Gymnast Not Found");
        }
    }

    @Override
    public void modify() {
        String DNI = Read.readDNI("Insert Gymnast's DNI to Modify: ");
        Gymnast gym = repoGym.showGymnast(DNI);
        if (gym != null) {
            System.out.println("Gymnast Found: " + gym.toString());
            int opt;
            do {
                myGUI.updateGymnast();
                switch (opt = Read.readInt("Select Option")) {
                    case 0:
                        System.out.println("Go Back");
                        break;
                    case 1:
                        gym.setName(Read.readString("Insert Gymnast's new name: "));
                        break;
                    case 2:
                        gym.setPhone(Read.readInt("Insert Gymnast's new phone: "));
                        break;
                    case 3:
                        gym.setMail(Read.readString("Insert Gymnast's new mail: "));
                        break;
                    case 4:
                        gym.setCat(Category.fromName(Read.readString("Insert Gymnast's new category: ")));
                        break;
                    case 5:
                        gym.setClub(Read.readString("Insert Gymnast's new club name: "));
                        break;
                    default:
                        System.out.println("Wrong Option");
                }
            } while (opt != 0);
        } else {
            System.out.println("404 Gymnast Not Found");
        }

    }

    @Override
    public void showAll() {
        repoGym.ShowAll();
    }
}
