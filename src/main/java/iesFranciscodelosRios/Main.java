package iesFranciscodelosRios;

import iesFranciscodelosRios.Controller.ControllerCompetition;
import iesFranciscodelosRios.Repos.CompetitionRepo;
import iesFranciscodelosRios.Repos.JudgeRepo;
import iesFranciscodelosRios.Repos.RepoClub;
import iesFranciscodelosRios.Repos.RepoGymnast;
import iesFranciscodelosRios.Utils.XMLManager;

public class Main {
    public static void main(String[] args) {
        ControllerCompetition c=ControllerCompetition.get_instance();
        c.mainMenu();
        XMLManager.writeXML(RepoGymnast.get_instance(),"Gymnastes.xml");
        XMLManager.writeXML(RepoClub.get_instance(),"Clubs.xml");
        XMLManager.writeXML(JudgeRepo.get_instance(),"Judges.xml");
        XMLManager.writeXML(CompetitionRepo.get_instance(),"Competitions.xml");
    }
}
