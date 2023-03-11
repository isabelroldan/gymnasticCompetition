package iesFranciscodelosRios.Test.Trial;

import iesFranciscodelosRios.Enum.Category;
import iesFranciscodelosRios.Enum.Kit;
import iesFranciscodelosRios.Enum.Type;
import iesFranciscodelosRios.Utils.Read;
import iesFranciscodelosRios.model.Participation;
import iesFranciscodelosRios.model.Trial;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestTrial {
    private static Logger logger= Logger.getLogger("iesFranciscodelosRios.Test.TestTrial");
    private static Trial t=new Trial(Type.INDIVIDUAL, Category.BENJAMIN, Kit.HOOP);
    public static void main(String[] args) {
        iesFranciscodelosRios.Utils.Logger.CreateFile(logger,"LogTrial");
        logger.setLevel(Level.ALL);
        testAddParticipant();
        testGetWinner();
        testScore();
    }
    public static void testAddParticipant(){
        try{
            HashMap<Integer, Participation> a=new HashMap<>();
            a.put(1,new Participation(0));
            a.put(2,new Participation(1));
            a.put(3,new Participation(2));
            t.setParticipations(a);
            if(t.addParticipant(new Participation(4))){
                logger.info("OK TestAddParticipant agrego un participante al hashMap");
            }else{
                logger.info("OK. TestAddParticipant no puedo insertar participante en el hashMap");
            }
        }catch (Exception e){
            e.printStackTrace();
            logger.log(Level.SEVERE,"Error");
        }
    }
    public static void testGetWinner(){
        try{
            HashMap<Integer,Participation> aux=t.getParticipations();
            for (Map.Entry<Integer,Participation> e:aux.entrySet()){
                e.getValue().setPoints((int)(Math.random()*10));
                aux.put(e.getKey(),e.getValue());
            }
            for (Participation p:t.getWinner()){
                System.out.println(p);
            }
            logger.info("OK. testGetWinner se comprobo correctamente");
        }catch (Exception e){
            e.printStackTrace();
            logger.log(Level.SEVERE,"ERROR");
        }
    }
    public static void testScore(){
        int dorsal=Read.readInt("Introduce el dorsal del usuario");
        if(t.score(dorsal,Read.readInt("introduce puntuacion"))){
            System.out.println(t.searchParticipant(dorsal));
            logger.info("OK se establecio puntuacion correctamente");
        }else{
            logger.warning("No se pudo establecer puntuacion");
        }
    }
}
