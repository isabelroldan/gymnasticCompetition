package iesFranciscodelosRios.Controller;
import iesFranciscodelosRios.Utils.Read;
import iesFranciscodelosRios.interfaces.*;
import iesFranciscodelosRios.GUI.*;
public class ControllerTrial implements iController{
    iGUI GUI= new Gui();
    @Override
    public void main() {
        boolean end=false;
        do {
            GUI.crudTrials();
            switch (Read.readInt("Enter a valid option")){
                case 0:
                    break;
                case 1:
                    add();
                    break;
                case 2:
                    modify();
                    break;
                case 3:
                    show();
                    break;
                case 4:
                    delete();
                    break;
                case 5:



            }
        }while (!end);
    }

    @Override
    public void add() {

    }

    @Override
    public void show() {

    }

    @Override
    public void delete() {

    }

    @Override
    public void modify() {

    }

    @Override
    public void showAll() {

    }
}
