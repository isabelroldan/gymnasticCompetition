package iesFranciscodelosRios.interfaces;

import iesFranciscodelosRios.Enum.Category;
import iesFranciscodelosRios.Enum.Kit;
import iesFranciscodelosRios.Enum.Type;
import iesFranciscodelosRios.model.Participation;

public interface iTrial {
    Type getType();
    Kit getKit();
    Category getCategory();
    Participation getWinner();
}
