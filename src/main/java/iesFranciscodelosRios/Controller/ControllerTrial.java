package iesFranciscodelosRios.Controller;
import iesFranciscodelosRios.Utils.Read;
import iesFranciscodelosRios.GUI.*;
import iesFranciscodelosRios.Utils.Utils;
import iesFranciscodelosRios.model.*;

import java.util.ArrayList;

public final class ControllerTrial {
    private static ControllerTrial _instance=null;

    private ControllerTrial(){

    }
    public void main(Trial t, Competition c) {
        boolean end = false;
        do {
            Gui.trial();
            switch (Read.readInt("Enter any option")) {
                case 0:
                    end=true;
                    break;
                case 1:
                    addParticipant(t, c);
                    break;
                case 2:
                    searchParticipant(t,Read.readInt("Enter a participant dorsal"));
                    break;
                case 3:
                    showAll(t);
                    break;
                case 4:
                    JudgeLogin(c,t);
                    break;
                case 5:
                    showWinner(t);
                    break;
                default:
                    System.out.println("Please enter a valid option");
                    break;
            }
        } while (!end);
    }
    public void JudgeManager(Trial t){
        boolean end=false;
        do {
            Gui.JudgeManager();
            switch (Read.readInt("Enter any option")){
                case 0:
                    end=true;
                    break;
                case 1:
                    score(t);
                    break;
                default:
                    System.out.println("Enter a valid option");
                    break;
            }
        }while (!end);
    }
    private void addParticipant(Trial t, Competition c){
        int key=Read.readInt("Enter a dorsal number");
        if(c.showParticipation(key)!=null){
            if(t.addParticipant(c,c.showParticipation(key))){
                System.out.println("The participant with dorsal number "+key+" was added");
            }else{
                System.out.println("The participant with number "+key+" hasn´t been added");
            }
        }else{
            System.out.println("the participant with the number "+key+" does not exist");
        }
    }
    private void showAll(Trial t){
        if(t.getParticipations()!=null){
            for (Participation p:t.getParticipations().values()){
                System.out.println(p);
            }
        }else{
            System.out.println("Trial has no participants added");
        }
    }
    private void searchParticipant(Trial t,int dorsal){
        if(t.searchParticipant(dorsal)!=null){
            System.out.println(t.searchParticipant(dorsal));
        }else{
            System.out.println("The participant with dorsal number "+dorsal+" has not been found");
        }
    }
    public void JudgeLogin(Competition c,Trial t){
        if(c.getJudge()!=null){
            if(c.getJudge().login(Read.readPassword())){
                System.out.println(Utils.verde+"OK. Login successfully\n"+Utils.b);
                JudgeManager(t);
            }else{
                System.out.println(Utils.rojo+"The username or password is not correct");
            }
        }else{
            System.out.println(Utils.rojo+"A jury must be inserted in the current competition"+Utils.b);
        }
    }
    private void score(Trial t){
        Participation aux=t.searchParticipant(Read.readInt("Enter the participant's dorsal number"));
        if(aux!=null){
            System.out.println(aux);
            if(t.score(aux.getDorsal(),Read.readInt("point it from 0/10"))){
                System.out.println(aux);
            }else{
                System.out.println("It was not possible to score the participant");
            }
        }else{
            System.out.println("The participant has not been found");
        }
    }
    private void showWinner(Trial t){
        ArrayList<ArrayList<Participation>>aux=t.getWinner();
        if(aux!=null){
            for(int i=0;i<aux.size();i++){
                switch (i){
                    case 0:
                        System.out.println(Utils.b+"Gold medal");
                        for (Participation p: aux.get(0)){
                            System.out.println(Utils.magenta+"\t"+p+Utils.b);
                        }
                        break;
                    case 1:
                        System.out.println(Utils.b+"Silver medal");
                        for (Participation p: aux.get(1)){
                            System.out.println(Utils.magenta+"\t"+p+Utils.b);
                        }
                        break;
                    case 2:
                        System.out.println(Utils.b+"Bronze medal");
                        for (Participation p: aux.get(2)){
                            System.out.println(Utils.magenta+"\t"+p+Utils.b);
                        }
                        break;
                }
            }
        }else{
            System.out.println("There are no participants in the trial ");
        }
    }

    public static ControllerTrial get_instance() {
        if(_instance==null){
            _instance=new ControllerTrial();
        }
        return _instance;
    }
}
