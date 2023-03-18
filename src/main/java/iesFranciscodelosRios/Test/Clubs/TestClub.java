package iesFranciscodelosRios.Test.Clubs;

import iesFranciscodelosRios.Controller.ClubController;
import iesFranciscodelosRios.Repos.RepoClub;
import iesFranciscodelosRios.Utils.XMLManager;

public class TestClub {
    public static void main(String[] args) {
        ClubController c=ClubController.get_instance();
        c.main();
        XMLManager.writeXML(RepoClub.get_instance(),"Clubs.xml");
    }
}
