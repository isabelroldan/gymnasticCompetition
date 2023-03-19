package iesFranciscodelosRios.Test.Judge;

import iesFranciscodelosRios.Controller.ControllerJudge;
import iesFranciscodelosRios.Repos.JudgeRepo;
import iesFranciscodelosRios.Utils.XMLManager;

public class TestJudge {
    public static void main(String[] args) {
        ControllerJudge c=ControllerJudge.get_intance();
        c.main();
        XMLManager.writeXML(JudgeRepo.get_instance(),"Judges.xml");
    }
}
