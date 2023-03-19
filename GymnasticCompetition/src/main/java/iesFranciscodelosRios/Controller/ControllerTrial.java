package iesFranciscodelosRios.Controller;
import iesFranciscodelosRios.Utils.Read;
import iesFranciscodelosRios.interfaces.*;
import iesFranciscodelosRios.GUI.*;
import iesFranciscodelosRios.model.*;

public class ControllerTrial {

    public void main(Trial t, Competition c) {
        boolean end = false;
        do {
            Gui.trial();
            switch (Read.readInt("Enter a valid option")) {
                case 0:
                    end=true;
                    break;
                case 1:
                    addParticipant(t, c);
                    break;
                case 2:
                    showAll(t);
                    break;
                case 3:
                    score(t);
                    break;
                case 4:
                    showWinner(t);
                    break;
                case 5:


            }
        } while (!end);
    }
    private void addParticipant(Trial t, Competition c){
        int key=Read.readInt("Enter a bib number");
        if(c.showParticipation(key)!=null){
            if(t.addParticipant(c.showParticipation(key))){
                System.out.println("The participant with bib number "+key+" was added");
            }else{
                System.out.println("The participant with number "+key+" already participates in the trial");
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
    private void score(Trial t){
        System.out.println(t.score(Read.readInt("Enter the participant's bib number"),Read.readInt("point it from 0/10")));
    }
    private void showWinner(Trial t){
        if(t.getWinner()!=null){
            for (Participation p:t.getWinner()){
                System.out.println(p);
            }
        }else{
            System.out.println("There are no participants in the trial ");
        }
    }

}
