package iesFranciscodelosRios.Controller;

import iesFranciscodelosRios.GUI.Gui;
import iesFranciscodelosRios.Repos.RepoClub;
import iesFranciscodelosRios.Utils.Read;
import iesFranciscodelosRios.Utils.XMLManager;
import iesFranciscodelosRios.model.Club;

import java.util.Map;

public class ClubController {
    private final RepoClub repo= XMLManager.readXML(RepoClub.get_instance(),"Clubs.xml");
    public static ClubController _instance=null;
    public void main(){
        boolean end=false;
        do {
            Gui.crudClub();
            switch (Read.readInt("Enter any option")){
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
                    System.out.println("Enter a valid option");
                    break;
            }
        }while (!end);
    }
    public void createClub(){
        if(repo.addClub(new Club(Read.readString("Enter a club name that does not exist")))){
            System.out.println("The club has been created successfully");
        }else{
            System.out.println("Could not create club");
        }
    }
    public void deleteClub(){
        if(repo.removeClub("Enter the name of the club you want to delete")){
            System.out.println("Ok. it was deleted correctly");
        }else{
            System.out.println("Could not delete club");
        }
    }
    public void searchClub(){
        String name=Read.readString("Enter the name of the club you want to search for");
        if(repo.searchClub(name)!=null){
            System.out.println(repo.searchClub(name));
        }else{
            System.out.println("The searched club was not found");
        }
    }
    public void showClubs(){
        Map<String,Club> aux=repo.getClubs();
        if(aux!=null){
            for (String key: repo.getClubs().keySet()){
                System.out.println(aux.get(key));
            }
        }else{
            System.out.println("No clubs available");
        }
    }
    public static ClubController get_instance() {
        if(_instance==null){
            _instance=new ClubController();
        }
        return _instance;
    }
}
