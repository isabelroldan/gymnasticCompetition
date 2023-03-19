package iesFranciscodelosRios.Controller;


import iesFranciscodelosRios.Enum.Category;
import iesFranciscodelosRios.GUI.Gui;
import iesFranciscodelosRios.Repos.RepoClub;
import iesFranciscodelosRios.Repos.RepoGymnast;
import iesFranciscodelosRios.interfaces.*;
import iesFranciscodelosRios.Utils.*;
import iesFranciscodelosRios.model.Gymnast;


/**
 * clase GymnastController que implementa la interfaz iController
 * Esta interfaz tiene los metodos a utilizar en esta clase
 */
public class GymnastController implements iController {
    private RepoGymnast repoGym = XMLManager.readXML(RepoGymnast.get_instance(),"Gymnastes.xml");
    private static GymnastController _instance =null;

    private GymnastController() {
    }

    @Override
    public void main() {
        /**
         * menu encargado de controlar las opciones del CRUD relacionado con gimnasta
         */

        boolean end = false;
        do {
            Gui.crudGymnastic();
            switch (Read.readInt("Select Option")) {
                case 0:
                    System.out.println("Thanks for using this program");
                    end = true;
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

        } while (!end);

    }

    /**
     * Metodo que es encarga de obtener los datos del gimnasta a crear, este metodo llama al arrayList creado
     * en el repositorio de gimnasta
     */
    @Override
    public void add() {
        if (repoGym.addGymnast(new Gymnast(
                Read.readDNI("Insert Gymnast's DNI: "),
                Read.readString("Insert Gymnast's name: "),
                Read.readTelephoneNumber(),
                Read.readMail(),
                Category.fromName(Read.readString("Insert Gymnast's Category:")),
                RepoClub.get_instance().searchClub(Read.readString("Insert Gymnast's new club name: "))))) {
            System.out.println("Gymnast Added");
        }else{
            System.out.println("Try Again");
        }

    }

    /**
     * Metodo encatgado de pedir el DNI del gimnasta a buscar,si es distinto de null
     * llama al metodo show de RepoGymnast, y si es null da un mensaje de error
     */
    @Override
    public void show() {
        String DNI = Read.readDNI("Insert Gymnast's DNI to search: ");
        Gymnast gym = repoGym.showGymnast(DNI);
        if (gym != null) {
            System.out.println("Gymnast Founded: " + gym.toString());
        } else {
            System.out.println("404 Gymnast Not Found");
        }
    }

    /**
     * metodo encargado de recibir un DNI que llama al metodo delete en el repositorio para eliminar el gimnasta
     * buscado por su DNI,
     */
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

    /**
     * metodo que pide el DNI de un gimnasta creado y despues muestra un
     * menu con las opciones a modificar
     */
    @Override
    public void modify() {
        String DNI = Read.readDNI("Insert Gymnast's DNI to Modify: ");
        Gymnast gym = repoGym.showGymnast(DNI);
        if (gym != null) {
            System.out.println("Gymnast Found: " + gym.toString());
            int opt;
            do {
                Gui.updateGymnast();
                switch (opt = Read.readInt("Select Option")) {
                    case 0:
                        System.out.println("Go Back");
                        break;
                    case 1:
                        gym.setName(Read.readString("Insert Gymnast's new name: "));
                        break;
                    case 2:
                        gym.setPhone(Read.readTelephoneNumber());
                        break;
                    case 3:
                        gym.setMail(Read.readMail());
                        break;
                    case 4:
                        gym.setCat(Category.fromName(Read.readString("Insert Gymnast's new category: ")));
                        break;
                    case 5:
                        gym.setClub(RepoClub.get_instance().searchClub(Read.readString("Insert Gymnast's new club name: ")));
                        break;
                    default:
                        System.out.println("Wrong Option");
                }
            } while (opt != 5);
        } else {
            System.out.println("404 Gymnast Not Found");
        }

    }

    /**
     * metodo que llama al metodo showALL
     * hace que muestre todos los datos almacenados
     * en el ArrayList
     */
    @Override
    public void showAll() {

        repoGym.ShowAll();
    }
    public static GymnastController get_instance() {
        if(_instance == null){
            _instance = new GymnastController();
        }
        return _instance;
    }

}
