package iesFranciscodelosRios.model;

import iesFranciscodelosRios.Enum.Category;
import iesFranciscodelosRios.Enum.Kit;
import iesFranciscodelosRios.Enum.Type;
import iesFranciscodelosRios.interfaces.*;

import java.util.*;
import java.util.logging.Logger;

public final class Trial implements iTrial {
    private final static Logger logger = iesFranciscodelosRios.Utils.Logger.CreateLogger("model.Trial");
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
     * Este metodo genera 3 colecciones donde almacenar los ganadores .el proceso para saber la posicion de un
     * participante es al comprobar si la puntuacion del siguiente participante en una coleccion ordenada
     * es igual a la del anterior participante (que al estar ordenada la lista es el que mayor puntuacion tendra).
     * @return devuelve un arrayList con 3 colecciones en las cuales se almacenan los participantes ganadores segun su
     * posicion de puntuacion
     */
    public ArrayList<ArrayList<Participation>> getWinner() {
        ArrayList<ArrayList<Participation>> result=null;
        try {
            ArrayList<Participation> sortedList = new ArrayList<>(participations.values());
            sortedList.removeIf(p -> p.getPoints() == 0);
            Collections.sort(sortedList);
            int position = 0;
            ArrayList<Participation> first = new ArrayList<>();
            ArrayList<Participation> second = new ArrayList<>();
            ArrayList<Participation> third = new ArrayList<>();
            for (int i = 0; i < sortedList.size() && position <= 2; i++) {
                Participation currentParticipation = sortedList.get(i);
                switch (position) {
                    case 0:
                        first.add(currentParticipation);
                        break;
                    case 1:
                        second.add(currentParticipation);
                        break;
                    case 2:
                        third.add(currentParticipation);
                        break;
                }
                if (i + 1 < sortedList.size() && sortedList.get(i + 1).getPoints() != currentParticipation.getPoints()) {
                    position++;
                }
            }
            result=new ArrayList<>();
            result.add(first);
            result.add(second);
            result.add(third);
        } catch (NullPointerException e) {
            e.printStackTrace();
            logger.severe("Error. method getWinner. The participating collection is null");
        } catch (ArrayIndexOutOfBoundsException e) {
            logger.severe("Error. method getWinner. The participation array is smaller than desired");
        } finally {
            if (result == null) {
                logger.warning("Warning. method getWinner. It has not been executed correctly");
            }
        }
        return result;
    }

    /**
     * Agrega una participacion si esta no existe ya en la coleccion
     *
     * @param b participacion
     * @return devuelve true i lo ha agregado y false en caso contrario
     */
    @Override
    public boolean addParticipant(Participation b) {
        boolean end = false;
        try {
            if (b != null) {
                if (!participations.containsKey(b.getDorsal())) {
                    participations.put(b.getDorsal(), b);
                    logger.info("OK. method addParticipant. it was executed correctly");
                    end = true;
                }
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
            logger.severe("Error. method addParticipant. The participating collection is null");
        } finally {
            if (!end) {
                logger.warning("Warning. method addParticipant. It has not been executed correctly");
            }
        }
        return end;
    }

    public boolean login(Judge j, String dni, char[] password) {
        boolean result = false;
        try {
            if (j.getDNI().equalsIgnoreCase(dni) && Arrays.equals(j.getPassword(), password)) {
                result = true;
            }
        } catch (NullPointerException e) {
            logger.severe("Error " + e.getMessage());
        }
        return result;
    }

    /**
     * Si se cumple el criterio de puntuacion se le asignara al usuario con el dorsal asignado
     * la puntuacion correspondiente a su actuacion.
     * este metodo deberia ser usado por un jurado
     *
     * @param points puntos asignados al participante
     * @return devuelve true si se cumple el criterio y false en caso contrario
     */
    public boolean score(Integer dorsal, int points) {
        boolean end = false;
        try {
            if (searchParticipant(dorsal) != null) {
                if (points <= 10 && points >= 0) {
                    searchParticipant(dorsal).setPoints(points);
                    end = true;
                }
            }
        } catch (ArithmeticException e) {
            e.printStackTrace();
            logger.severe("Error. method score. An arithmetic error occurred");
        } catch (NullPointerException e) {
            e.printStackTrace();
            logger.severe("Error. method score. The participating collection is null");
        } finally {
            if (!end) {
                logger.warning("Warning. method score. It has not been executed correctly");
            }
        }
        return end;
    }

    /**
     * Metodo el cual buscara por la clave primaria si el objeto existe en la lista. si lo encuentra devuelve
     * el objeto . si no devuelve null
     *
     * @param dorsal clave primaria para buscar . debe ser el dorsal del participante
     * @return devuelve el objeto encontrado o null
     */
    public Participation searchParticipant(Integer dorsal) {
        Participation result = null;
        if (participations != null && participations.get(dorsal) != null) {
            result = participations.get(dorsal);
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
