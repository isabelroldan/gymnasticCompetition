package iesFranciscodelosRios;

import iesFranciscodelosRios.Controller.ControllerCompetition;

public class Execute {
    public static void main(String[] args) {

        ControllerCompetition c=ControllerCompetition.get_instance();
        c.mainMenu();
    }
}
