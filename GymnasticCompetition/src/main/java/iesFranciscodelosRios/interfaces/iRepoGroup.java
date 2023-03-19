package iesFranciscodelosRios.interfaces;
import iesFranciscodelosRios.model.Group;
public interface iRepoGroup {
	boolean addGroup();
	boolean modifyGroup();
	boolean deleteGroup();
	Group showGroup(String name);
}
