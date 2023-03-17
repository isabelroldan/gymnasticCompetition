package iesFranciscodelosRios.Test.Trial;

import iesFranciscodelosRios.Controller.ControllerTrial;
import iesFranciscodelosRios.Enum.*;
import iesFranciscodelosRios.Utils.Read;
import iesFranciscodelosRios.model.Competition;
import iesFranciscodelosRios.model.Judge;
import iesFranciscodelosRios.model.Participation;
import iesFranciscodelosRios.model.Trial;

import java.util.HashMap;

public class TestTrial {
    public static void main(String[] args) {
        Trial t=new Trial(Type.INDIVIDUAL,Category.BENJAMIN,Kit.HOOP);
        Competition competition=new Competition("prueba","dxd","14-03-2023");
        competition.addTrial(t);
        competition.setJudge(new Judge("54592015C","Juez1",123,"prueba@prueba.com", Read.readPassword()));
        HashMap<Integer, Participation>participations=new HashMap<>();
        participations.put(1,new Participation<>(1,"00:01"));
        participations.put(2,new Participation<>(2,"00:04"));
        participations.put(3,new Participation<>(3,"00:05"));
        participations.put(4,new Participation<>(4,"00:06"));
        participations.put(5,new Participation<>(5,"00:01"));
        t.setParticipations(participations);
        ControllerTrial c=ControllerTrial.get_instance();
        c.main(t,competition);
    }
}
