package iesFranciscodelosRios.Repos;

import iesFranciscodelosRios.interfaces.iRepoGymnast;
import iesFranciscodelosRios.model.Gymnast;
import java.util.ArrayList;

public class RepoGymnast implements iRepoGymnast {

    ArrayList<Gymnast> gymnastes=new ArrayList<Gymnast>();
    @Override
    public boolean addGymnast(Gymnast gym) {
        boolean result=false;
        if (gymnastes.contains(gym))
            System.out.println("gymnast already exist");
        else {
            gymnastes.add(gym);
            result = true;
            System.out.println("Added New Gymnast");
        }
        return result;
    }
    @Override
    public boolean deleteGymnast(String DNI) {
        Gymnast gym = showGymnast(DNI);
        if (gym != null) {
            return gymnastes.remove(gym);
        } else {
            return false;
        }
    }

    @Override
    public Gymnast showGymnast(String DNI) {
        for (Gymnast gymnast : gymnastes){
            if(gymnast.getDNI().equals(DNI)){
                return gymnast;
            }
        }
        return null;
    }

    @Override
    public void ShowAll() {
        if (gymnastes.isEmpty()) {
            System.out.println("No Gymnastes added.");
        } else {
            System.out.println("Gymnast List:");
            for (Gymnast gymnast : gymnastes) {
                System.out.println(gymnastes.toString());
            }
        }

    }
}
