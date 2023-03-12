package iesFranciscodelosRios.interfaces;
import iesFranciscodelosRios.model.Gymnast;
public interface iRepoGymnast {
	boolean addGymnast(Gymnast gym);
	boolean modifyGymnast(String DNI);
	boolean deleteGymnast(String DNI);
	Gymnast showGymnast(String dni);
	void ShowAll();
}
