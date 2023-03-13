package iesFranciscodelosRios.interfaces;
import iesFranciscodelosRios.model.Gymnast;
public interface iRepoGymnast {
	boolean addGymnast(Gymnast gym);
	boolean deleteGymnast(String DNI);
	Gymnast showGymnast(String dni);
}
