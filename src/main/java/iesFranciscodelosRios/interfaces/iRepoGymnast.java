package iesFranciscodelosRios.interfaces;
import iesFranciscodelosRios.model.Gymnast;
public interface iRepoGymnast {
	boolean addGymnast();
	boolean modifyGymnast();
	boolean deleteGymnast();
	Gymnast showGymnast(String dni);
}
