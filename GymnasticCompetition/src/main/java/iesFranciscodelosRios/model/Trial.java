package iesFranciscodelosRios.model;

import iesFranciscodelosRios.Enum.Category;
import iesFranciscodelosRios.Enum.Kit;
import iesFranciscodelosRios.Enum.Type;
import iesFranciscodelosRios.interfaces.*;

import java.util.*;

public final class Trial implements iTrial {
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
        ArrayList<Participation> maxPoints = new ArrayList<>();
        maxPoints.add(new Participation());
        for (Participation aux : participations.values()) {
            if (aux.getPoints() >= maxPoints.get(maxPoints.size() - 1).getPoints() && aux.getPoints() != 0) {
                maxPoints.add(aux);
                if (maxPoints.get(maxPoints.indexOf(aux) - 1) != null) {
                    if (maxPoints.get(maxPoints.indexOf(aux) - 1).getPoints() < aux.getPoints()) {
                        maxPoints.remove(maxPoints.indexOf(aux) - 1);
                    }
                }
            }
        }
        if (maxPoints.get(0) != null && maxPoints.get(0).getPoints() > 0) {
            return maxPoints;
        }
        return null;
    }

    /**
     *  Agrega una participacion si esta no existe ya en la coleccion
     * @param b participacion
     * @return devuelve true i lo ha agregado y false en caso contrario
     */
    @Override
    public boolean addParticipant(Participation b) {
        if (b != null) {
            if (!participations.containsKey(b.getDorsal())) {
                participations.put(b.getDorsal(), b);
                return true;
            }
        }
        return false;
    }

    /**
     * Si se cumple el criterio de puntuacion se le asignara al usuario con el dorsal asignado
     * la puntuacion correspondiente a su actuacion.
     * este metodo deberia ser usado por un jurado
     * @param points puntos asignados al participante
     * @return devuelve true si se cumple el criterio y false en caso contrario
     */
    public boolean score(Integer dorsal,int points) {
        if(searchParticipant(dorsal)!=null){
            if(points<=10 && points>=0){
                searchParticipant(dorsal).setPoints(points);
                return true;
            }
        }
        return false;
    }

    /**
     * Metodo el cual buscara por la clave primaria si el objeto existe en la lista. si lo encuentra devuelve
     * el objeto . si no devuelve null
     * @param dorsal clave primaria para buscar . debe ser el dorsal del participante
     * @return devuelve el objeto encontrado o null
     */
    public Participation searchParticipant(Integer dorsal){
        return participations.get(dorsal);
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

    public void setType(Type type) {
		this.type = type;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public void setKit(Kit kit) {
		this.kit = kit;
	}

	/**
     * En principio este setParticipations lo he creado para poder usarlo en los test pero tal vez deberia ser eliminado
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
