package iesFranciscodelosRios.interfaces;

import iesFranciscodelosRios.Enum.Category;
import iesFranciscodelosRios.Enum.Kit;
import iesFranciscodelosRios.Enum.Type;
import iesFranciscodelosRios.model.Participation;

public interface iTrial {
    ArrayList<Participation> getWinner();
    boolean addParticipant(Participation b);
    boolean score();
    ArrayList<Participation> showAllParticipants();
}
