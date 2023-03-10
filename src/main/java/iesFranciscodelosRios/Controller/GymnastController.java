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
                    delete();
                    break;
                case 4:
                    modify();
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
        Gymnast gym=new Gymnast(Read.readDNI("Insert Gymnast's DNI: "),
                Read.readString("Insert Gymnast's name: "),
                Read.readInt("Insert Gymnast's phone: "),
                Read.readString("Insert Gymnast's mail: "),
                Category.fromName(Read.readString("Insert Gymnast's Category:")),
                Read.readString("Insert Gymnast Club's name: "));
        repoGym.addGymnast(gym);
    }

    @Override
    public void show() {

    }

    @Override
    public void delete() {

    }

    @Override
    public void modify() {

    }

    @Override
    public void showAll() {
        repoGym.ShowAll();
    }
}
