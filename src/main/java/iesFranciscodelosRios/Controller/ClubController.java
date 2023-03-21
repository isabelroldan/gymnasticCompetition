package iesFranciscodelosRios.Controller;

import iesFranciscodelosRios.GUI.Gui;
import iesFranciscodelosRios.Repos.RepoClub;
import iesFranciscodelosRios.Utils.Read;
import iesFranciscodelosRios.Utils.Utils;
import iesFranciscodelosRios.model.Club;

import java.util.Map;

public final class ClubController {
    public static ClubController _instance=null;
    private ClubController(){

    }
    public void main(){
        boolean end=false;
        do {
            Gui.crudClub();
            switch (Read.readInt(Utils.amarillo+"Enter any option"+Utils.b)){
                case 0:
                    end=true;
                    break;
                case 1:
                    createClub();
                    break;
                case 2:
                    deleteClub();
                    break;
                case 3:
                    searchClub();
                    break;
                case 4:
                    showClubs();
                    break;
                default:
                    System.out.println(Utils.rojo+"Enter a valid option"+Utils.b);
                    break;
            }
        }while (!end);
    }
    public void createClub(){
        if(RepoClub.get_instance().addClub(new Club(Read.readString("Enter a club name that does not exist")))){
            System.out.println(Utils.verde+"The club has been created successfully"+Utils.b);
        }else{
            System.out.println(Utils.rojo+"Could not create club"+Utils.b);
        }
    }
    public void deleteClub(){
        if(RepoClub.get_instance().removeClub(Read.readString("Enter the name of the club you want to delete"))){
            System.out.println(Utils.verde+"Ok. it was deleted correctly"+Utils.b);
        }else{
            System.out.println(Utils.rojo+"Could not delete club"+Utils.b);
        }
    }
    public void searchClub(){
        String name=Read.readString("Enter the name of the club you want to search for");
        if(RepoClub.get_instance().searchClub(name)!=null){
            System.out.println(RepoClub.get_instance().searchClub(name));
        }else{
            System.out.println(Utils.rojo+"The searched club was not found"+Utils.b);
        }
    }
    public void showClubs(){
        Map<String,Club> aux=RepoClub.get_instance().getClubs();
        if(!aux.isEmpty()){
            for (String key: RepoClub.get_instance().getClubs().keySet()){
                System.out.println(aux.get(key));
            }
        }else{
            System.out.println(Utils.rojo+"No clubs available"+Utils.b);
        }
    }

    public static void set_instance(ClubController _instance) {
        ClubController._instance = _instance;
    }

    public static ClubController get_instance() {
        if(_instance==null){
            _instance=new ClubController();
        }
        return _instance;
    }
}
