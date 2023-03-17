package iesFranciscodelosRios.model;

import iesFranciscodelosRios.Enum.Category;
import iesFranciscodelosRios.Enum.Kit;
import iesFranciscodelosRios.Enum.Type;
import iesFranciscodelosRios.interfaces.*;
import java.util.*;
import java.util.logging.Logger;

public final class Trial implements iTrial {
    private final static Logger logger= iesFranciscodelosRios.Utils.Logger.CreateLogger("model.Trial");
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
     *
     * @return el ArrayList con los participantes con maxima puntuacion. Si es mayor a 0. si no devuelve null
     */
    public ArrayList<Participation> getWinner() {
        ArrayList<Participation>result=null;
        ArrayList<Participation> aux=new ArrayList<>();
        try{
            for (Integer key : participations.keySet()){
                aux.add(participations.get(key));
            }
            Collections.sort(aux);
            result=aux;
        }catch (NullPointerException e){
            e.printStackTrace();
            logger.severe("Error. method getWinner. The participating collection is null");
        }catch (ArrayIndexOutOfBoundsException e){
            logger.severe("Error. method getWinner. The participation array is smaller than desired");
        } finally {
            if(result==null){
                logger.warning("Warning. method getWinner. It has not been executed correctly");
            }
        }
        return result;
    }

    /**
     *  Agrega una participacion si esta no existe ya en la coleccion
     * @param b participacion
     * @return devuelve true i lo ha agregado y false en caso contrario
     */
    @Override
    public boolean addParticipant(Participation b) {
        boolean end=false;
        try{
            if (b != null) {
                if (!participations.containsKey(b.getDorsal())) {
                    participations.put(b.getDorsal(), b);
                    logger.info("OK. method addParticipant. it was executed correctly");
                    end=true;
                }
            }
        }catch (NullPointerException e){
            e.printStackTrace();
            logger.severe("Error. method addParticipant. The participating collection is null");
        }finally {
            if(!end){
                logger.warning("Warning. method addParticipant. It has not been executed correctly");
            }
        }
        return end;
    }

    /**
     * Si se cumple el criterio de puntuacion se le asignara al usuario con el dorsal asignado
     * la puntuacion correspondiente a su actuacion.
     * este metodo deberia ser usado por un jurado
     * @param points puntos asignados al participante
     * @return devuelve true si se cumple el criterio y false en caso contrario
     */
    public boolean score(Integer dorsal,int points) {
        boolean end=false;
        try {
            if(searchParticipant(dorsal)!=null){
                if(points<=10 && points>=0){
                    searchParticipant(dorsal).setPoints(points);
                    end=true;
                }
            }
        }catch (ArithmeticException e){
            e.printStackTrace();
            logger.severe("Error. method score. An arithmetic error occurred");
        }catch (NullPointerException e){
            e.printStackTrace();
            logger.severe("Error. method score. The participating collection is null");
        } finally {
            if(!end){
                logger.warning("Warning. method score. It has not been executed correctly");
            }
        }
        return end;
    }

    /**
     * Metodo el cual buscara por la clave primaria si el objeto existe en la lista. si lo encuentra devuelve
     * el objeto . si no devuelve null
     * @param dorsal clave primaria para buscar . debe ser el dorsal del participante
     * @return devuelve el objeto encontrado o null
     */
    public Participation searchParticipant(Integer dorsal){
        Participation result=null;
        if(participations!=null && participations.get(dorsal)!=null){
            result=participations.get(dorsal);
        }
        return result;
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

    public HashMap<Integer, Participation> getParticipations() {
        return participations;
    }

    public void setParticipations(HashMap<Integer, Participation> participations) {
        this.participations = participations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trial trial = (Trial) o;
        return type == trial.type && category == trial.category && kit == trial.kit;
    }
}


