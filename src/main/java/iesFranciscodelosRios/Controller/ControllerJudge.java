package iesFranciscodelosRios.Controller;

import iesFranciscodelosRios.GUI.Gui;
import iesFranciscodelosRios.Repos.JudgeRepo;
import iesFranciscodelosRios.Utils.Read;
import iesFranciscodelosRios.Utils.Utils;
import iesFranciscodelosRios.Utils.XMLManager;
import iesFranciscodelosRios.model.Judge;

import java.util.ArrayList;

public final class ControllerJudge {
    private JudgeRepo judgeRepo= XMLManager.readXML(JudgeRepo.get_instance(),"Judges.xml");
    private static ControllerJudge _intance=null;
    private ControllerJudge() {
        boolean end=false;
        do {
            Gui.crudJudge();
            switch (Read.readInt("Enter any option valid")){
                case 0:
                    end=true;
                    break;
                case 1:
                    add();
                    break;
                case 2:
                    remove();
                    break;
                case 3:
                    search();
                    break;
                case 4:
                    showAll();
                    break;
                default:
                    System.out.println("Please enter a option valid");
                    break;
            }
        }while (!end);
    }
    public void add(){
        if(judgeRepo.add(new Judge(Read.readDNI("enter a valid ID and one that is not registered"),Read.readString("Enter a name of the judge"),Read.readTelephoneNumber(),Read.readMail(),Read.readPassword()))){
            System.out.println("Ok. The judge was added correctly");
        }else{
            System.out.println("Error. Could not add judge");
        }
    }
    public void remove(){
        if(judgeRepo.remove(Read.readDNI("Enter the ID of the judge you want to delete"))){
            System.out.println(Utils.verde+"Ok. It was deleted correctly"+Utils.b);
        }else{
            System.out.println(Utils.rojo+"could not delete"+Utils.b);
        }
    }
    public void search(){
        Judge aux=judgeRepo.search(Read.readDNI("Enter the ID of the judge you want to search for"));
        if(aux!=null){
            System.out.println(aux);
        }else{
            System.out.println("The judge was not found");
        }
    }
    public void showAll(){
       ArrayList<Judge> aux= judgeRepo.getJudges();
       if(aux!=null){
            for (Judge j:aux){
                System.out.println(j);
            }
       }else{
           System.out.println("There are no judges");
       }
    }
    public ControllerJudge get_intance() {
        if(_intance==null){
            _intance=new ControllerJudge();
        }
        return _intance;
    }
}
