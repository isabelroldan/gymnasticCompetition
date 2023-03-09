package iesFranciscodelosRios.model;

import iesFranciscodelosRios.Enum.Category;
import iesFranciscodelosRios.Enum.Kit;
import iesFranciscodelosRios.Enum.Type;
import iesFranciscodelosRios.interfaces.iParticipation;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Trial{
    private iParticipation i=new Participation();
    private Type type;
    private Category category;
    private Kit kit;
    private HashMap<String,Participation> participations=new HashMap<>();

    public Trial() {

    }

    public Trial(Type type, Category category, Kit kit) {
        this.type = type;
        this.category = category;
        this.kit = kit;
    }

    /**
     * Este metodo analizara el hashMap de participantes que tiene asociado la prueba. Y comprobara el participante con
     * la puntuacion maxima gracias a iterarlo
     * @return el participante con maxima puntuacion. Si es mayor a 0. si no devuelve null
     */
    public Participation getWinner(){
        Participation maxPoints=null;
        Iterator<Map.Entry<String,Participation>> it= participations.entrySet().iterator();
        while (it.hasNext()){
            Map.Entry<String,Participation> aux= it.next();
            if(aux.getValue().getPoints()>maxPoints.getPoints() && aux.getValue().getPoints()!=0){
                maxPoints=aux.getValue();
            }
        }
        return maxPoints;
    }

    public Type getType() {
        return type;
    }

    public Category getCategory() {
        return category;
    }

    public Kit getKit() {
        return kit;
    }
}
