package iesFranciscodelosRios.Test.Trial;

import iesFranciscodelosRios.Controller.ControllerTrial;
import iesFranciscodelosRios.Enum.*;
import iesFranciscodelosRios.model.Competition;
import iesFranciscodelosRios.model.Trial;

public class TestTrial {
    public static void main(String[] args) {
        Trial t=new Trial(Type.INDIVIDUAL,Category.BENJAMIN,Kit.HOOP);
        Competition competition=new Competition("prueba","dxd","14-03-2023");
        competition.addTrial(t);
        ControllerTrial c=new ControllerTrial();
        c.main(t,competition);
    }
}
