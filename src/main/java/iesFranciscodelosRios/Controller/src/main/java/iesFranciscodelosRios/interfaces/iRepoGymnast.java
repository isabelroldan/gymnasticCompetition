package iesFranciscodelosRios.interfaces;
import iesFranciscodelosRios.model.Gymnast;
import iesFranciscodelosRios.model.Person;
import java.util.ArrayList;

public interface iRepoGymnast {
	boolean addGymnast(Gymnast gymnast);
	boolean modifyGymnast(String DNI);
	boolean deleteGymnast(String DNI);
	Gymnast showGymnast(String DNI);
	void ShowAll();
}
