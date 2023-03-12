package iesFranciscodelosRios.interfaces;
import iesFranciscodelosRios.model.Competition;
public interface iRepoCompetition {
	boolean addCompetition();
	boolean modifyCompetition();
	boolean deleteCompetition();
	Competition showCompetition(String name);
	
}
