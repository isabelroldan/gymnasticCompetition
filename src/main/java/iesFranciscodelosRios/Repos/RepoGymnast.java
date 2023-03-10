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
    public boolean modifyGymnast(String DNI) {
        boolean result=false;

        return result;
    }

    @Override
    public boolean deleteGymnast(String DNI) {
        boolean result=false;

        return result;
    }

    @Override
    public Gymnast showGymnast(String DNI) {

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
