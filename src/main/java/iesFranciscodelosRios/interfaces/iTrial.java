package iesFranciscodelosRios.interfaces;
import iesFranciscodelosRios.model.Participation;

import java.util.ArrayList;

public interface iTrial {
    ArrayList<Participation> getWinner();
    boolean addParticipant(Participation b);
    boolean score(Integer dorsal,int points);
    Participation searchParticipant(Integer dorsal);
}
