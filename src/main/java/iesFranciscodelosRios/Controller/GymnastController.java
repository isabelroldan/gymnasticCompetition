package iesFranciscodelosRios.Controller;


import iesFranciscodelosRios.Enum.Category;
import iesFranciscodelosRios.GUI.Gui;
import iesFranciscodelosRios.Repos.RepoClub;
import iesFranciscodelosRios.Repos.RepoGymnast;
import iesFranciscodelosRios.interfaces.*;
import iesFranciscodelosRios.Utils.*;
import iesFranciscodelosRios.model.Club;
import iesFranciscodelosRios.model.Gymnast;


/**
 * clase GymnastController que implementa la interfaz iController
 * Esta interfaz tiene los metodos a utilizar en esta clase
 */
public class GymnastController implements iController {
    private static GymnastController _instance =null;

    private GymnastController() {
    }
    /**
     * menu encargado de controlar las opciones del CRUD relacionado con gimnasta
     */
    @Override
    public void main() {
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
        String Dni= Read.readDNI("Enter Gymnast DNI: ");
        String Name=Read.readString("Enter Gymnast Name");
        String surname=Read.readString("Enter  Gymnast Surname");
        String phone=null;
        while (phone==null){
            phone=Read.readTelephoneNumber();
        }
        String mail=null;
        while(mail==null){
            mail=Read.readMail();
        }
        Category cat=null;
        while(cat==null){
            cat=Category.fromName(Read.readString("insert Gymnast cathegory: "));
        }
        Club club=null;
        while(club==null){
            String cname=Read.readString("Insert Gymnast's new club name: ");
            club=RepoClub.get_instance().searchClub(cname);
            if(club==null && Utils.confirm("Club doesn't exist,creating a club with the name "+cname) && RepoClub.get_instance().addClub(club)){
                club=RepoClub.get_instance().searchClub(cname);
            }
        }

        if(RepoGymnast.get_instance().addGymnast(new Gymnast(Dni,Name,phone,surname,mail,cat,club.getName()))){
            RepoClub.get_instance().searchClub(club.getName()).addGymnast(RepoGymnast.get_instance().showGymnast(Dni));
            System.out.println("Gymnast Added");
        }else {
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
        Gymnast gym = RepoGymnast.get_instance().showGymnast(DNI);
        if (gym != null) {
            System.out.println("Gymnast Founded: " + gym);
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
        boolean deleted = RepoGymnast.get_instance().deleteGymnast(DNI);
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
        Gymnast gym = RepoGymnast.get_instance().showGymnast(DNI);
        if (gym != null) {
            System.out.println("Gymnast Found: " + gym);
            boolean end=false;
            do {
                Gui.updateGymnast();
                switch (Read.readInt("Select Option")) {
                    case 0:
                        System.out.println("Go Back");
                        end=true;
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
                        gym.setClub(Read.readString("Insert Gymnast's new club name: "));
                        break;
                    default:
                        System.out.println("Wrong Option");
                }
            } while (!end);
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

        RepoGymnast.get_instance().ShowAll();
    }
    public static GymnastController get_instance() {
        if(_instance == null){
            _instance = new GymnastController();
        }
        return _instance;
    }
}