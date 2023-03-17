package iesFranciscodelosRios.Test;
import iesFranciscodelosRios.Repos.*;
import iesFranciscodelosRios.Controller.GymnastController;
import iesFranciscodelosRios.Utils.XMLManager;

public class testgymnast {
    public static void main(String[] args) {
        GymnastController c=new GymnastController();
        c.main();
        XMLManager.writeXML(RepoGymnast.get_instance(),"Gymnastes.xml");
    }

}

