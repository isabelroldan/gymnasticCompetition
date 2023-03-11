package iesFranciscodelosRios.model;

import iesFranciscodelosRios.Enum.Category;
import iesFranciscodelosRios.Enum.Kit;
import iesFranciscodelosRios.Enum.Type;
import iesFranciscodelosRios.interfaces.*;

import javax.naming.LimitExceededException;
import java.util.*;

public final class Trial implements iTrial {
    private final iParticipation i = new Participation();
    private Type type;
    private Category category;
    private Kit kit;
    private HashMap<Integer, Participation> participations = new HashMap<>();

    public Trial() {

    }

    public Trial(Type type, Category category, Kit kit) {
        this.type = type;
        this.category = category;
        this.kit = kit;
    }

    /**
     * Este metodo analizara las puntuaciones de todos los gimnastas y los agrupara en un arrayList. acto seguido
     * analiza el arrayList y elimina los gimnastas con menor puntuacion
     * @return el ArrayList con los participantes con maxima puntuacion. Si es mayor a 0. si no devuelve null
     */
    public ArrayList<Participation> getWinner() {
        ArrayList<Participation> maxPoints = new ArrayList<>();
        maxPoints.add(new Participation());
        try {
            for (Participation aux : participations.values()) {
                if (aux.getPoints() >= maxPoints.get(maxPoints.size() - 1).getPoints() && aux.getPoints() != 0) {
                    maxPoints.add(aux);
                    if(maxPoints.get(maxPoints.indexOf(aux)-1)!=null){
                        if(maxPoints.get(maxPoints.indexOf(aux)-1).getPoints()<aux.getPoints()){
                            maxPoints.remove(maxPoints.indexOf(aux)-1);
                        }
                    }
                }
            }
            if(maxPoints.get(0)!=null && maxPoints.get(0).getPoints()>0){
                return maxPoints;
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @param b
     * @return
     */
    @Override
    public boolean addParticipant(Participation b) {
        if (b != null) {
            for (Participation c : participations.values()) {
                if (c.getDorsal() == b.getDorsal()) {
                    return false;
                }
            }
            participations.put(b.getDorsal(), b);
            return true;
        }
        return false;
    }

    public boolean score() {
        return false;
    }

    public ArrayList<Participation> showAllParticipants() {
        return null;
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

    /**
     * En principio este setParticipations lo he creado para poder usarlo en los test pero tal vez deberia ser eliminado
     * al igual que el getParticipations
     */
    public void setParticipations(HashMap<Integer, Participation> p) {
        this.participations = p;
    }

    public HashMap<Integer, Participation> getParticipations() {
        return participations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trial trial = (Trial) o;
        return type == trial.type && category == trial.category && kit == trial.kit;
    }
}
