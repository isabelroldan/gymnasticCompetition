package iesFranciscodelosRios.Controller;

import iesFranciscodelosRios.Enum.Category;
import iesFranciscodelosRios.Enum.Kit;
import iesFranciscodelosRios.Enum.Type;
import iesFranciscodelosRios.GUI.Gui;
import iesFranciscodelosRios.Repos.CompetitionRepo;
import iesFranciscodelosRios.Repos.RepoClub;
import iesFranciscodelosRios.Repos.RepoGymnast;
import iesFranciscodelosRios.Utils.Read;
import iesFranciscodelosRios.Utils.XMLManager;
import iesFranciscodelosRios.model.Club;
import iesFranciscodelosRios.model.Competition;
import iesFranciscodelosRios.model.Group;
import iesFranciscodelosRios.model.Gymnast;
import iesFranciscodelosRios.model.Participation;
import iesFranciscodelosRios.model.Trial;

public class ControllerCompetition {
	private final CompetitionRepo repo= XMLManager.readXML(CompetitionRepo.get_instance(),"Competitions.xml");
	private CompetitionRepo competitionRepo = CompetitionRepo.get_instance();
	private RepoGymnast repoGymnast = RepoGymnast.get_instance();
	private Competition competition; //esto deberia ser un repo . para de este modo saber a que competicion desea realizar cambios el usuario
	private RepoClub repoClub = RepoClub.get_instance();
	private static ControllerCompetition _instance = null;
		public void mainMenu() {
			boolean exit = false;
			
			while(!exit) {
				Gui.mainMenu();
				
				switch(Read.readInt("Enter a valid option")) {
					case 1:
						GymnastController gc= GymnastController.get_instance();
						gc.main();
						break;
					
					case 2:
						manageCompetitions();
						break;
					case 3:
						ClubController cc=ClubController.get_instance();
						cc.main();
						break;
					case 4:
						ControllerJudge jc=ControllerJudge.get_intance();
						jc.main();
					case 0:
						exit = true;
						
						break;
						
					default:
				    	System.out.println("Choose a valid option from the menu...");
				    	break;
				}
			}
		}
		
		public void competitionManager() {
			boolean exit = false;
			
			while(!exit) {
				Gui.competitionManager();
				
				switch(Read.readInt("Enter a valid option")) {
					case 1:
						manageParticipation();
						
						break;
						
					case 2:
						manageTrials();
						
						break;
						
					case 3:
						manageGroup();
						
					case 0:
						exit = true;
						break;
						
					default:
				    	System.out.println("Choose a valid option from the menu...");
				    	
				    	break;
				}
			}
		}
		
		public void manageCompetitions() {
			boolean exit = false;
					
					while(!exit) {
						Gui.crudCompetition();
						
						switch(Read.readInt("Enter a valid option")) {
							case 1:
								createCompetition();
								
								break;
							
							case 2:
								updateCompetition();
								
								break;
								
							case 3: 
								searchCompetition();
								if(competition!=null){
									competitionManager();
								}
								break;
								
							case 4: 
								deleteCompetition();
								
								break;
								
							case 5: 
								showAllCompetitions();
								
								break;
							case 0:
								exit = true;
								break;
								
							default:
						    	System.out.println("Choose a valid option from the menu...");
						    	
						    	break;
						}
					}
				}
		
		
		public Competition createCompetition() {
		    String name = Read.readString("Enter the name of the competition: ");
		    System.out.println();
		    String description = Read.readString("Enter the description of the competition: ");
		    System.out.println();
		    
		    String initialDate = null;
		    
		    boolean valid = false;
		    while(!valid) {
		        initialDate = Read.readString("Enter the initial date of the competition(dd/MM/yyyy): ");
		        if (Read.readDate(initialDate)) {
		            System.out.println("The entered date is valid");
		            valid = true;
		        } else {
		            System.out.println("The entered date isn't valid");
		        }
		    }
		    
		    System.out.println();
		    
		    Competition competition = new Competition(name, description, initialDate);
		    if (competitionRepo.addCompetition(competition)) {
		        System.out.println("It has been created successfully");
		    } else {
		        System.out.println("Something went wrong, try again");
		    }
		    return competition;
		}
		
		public void searchCompetition() {
			String name = Read.readString("Enter the name of the competition to search: ");
			
			Competition competition = competitionRepo.searchCompetition(name);
			
			if(competition==null) {
				System.out.println("The name you entered does not exist in our database...");
			}else {
				System.out.println(competition);
				this.competition=competition;
			}
		}
		
		public void deleteCompetition() {
			String name = Read.readString("Enter the name of the competition to delete: ");
			Competition competition = competitionRepo.searchCompetition(name);
			
			if(competition==null) {
				System.out.println("The name you entered does not exist in our database...");
			}else {
				competitionRepo.removeCompetition(competition);
			}
		}
		
		public void updateCompetition() {
			boolean exit = false;
			
			while(!exit) {
				System.out.println();
				String name = Read.readString("Enter the name of the competition to change: ");
				Gui.updateCompetitions();
				
				switch(Read.readInt("Enter a valid option")) {
					case 1:
						Competition competition = competitionRepo.searchCompetition(name);
						
						if(competition == null) {
							System.out.println("The name you entered does not exist in our database...");
						}else {
							String description = Read.readString("Enter the new competition description: ");
							competition.setDescription(description);
						}
						
						break;
						
					case 2:
						competition = competitionRepo.searchCompetition(name);
						
						if(competition == null) {
							System.out.println("The name you entered does not exist in our database...");
						}else {
							String initialDate = null;
							boolean valid = false;
							
							while(!valid) {
								initialDate = Read.readString("Enter the new competition initial date: ");
								if (Read.readDate(initialDate)) {
									competition.setInitialDate(initialDate);
						            System.out.println("The entered date is valid");
						            valid = true;
						        } else {
						            System.out.println("The entered date isn't valid");
						        }
							}
						}
						
						break;
						
					case 0:
						exit = true;
						
						break;
					
					default:
						System.out.println();
				    	System.out.println("Choose a valid option from the menu...");
				    	System.out.println();
				    	
				    	break;
				}
			}
			
		}
		
		public void showAllCompetitions() {
			competitionRepo.showAllCompetitions();
		}
		
		public void manageParticipation() {
			boolean exit = false;
			
			while(!exit) {
				Gui.crudPaticipations();
				
				switch(Read.readInt("Enter a valid option")) {
					case 1:
						createParticipation();
						
						break;
					
					case 2:
						updateParticipation();
						
						break;
						
					case 3: 
						searchParticipation();
						
						break;
					
						
					case 4: 
						deleteParticipation();
						
						break;
						
					//case 5: 
						//showAllParticipations();
						
						//break;
					case 0:
						mainMenu();
						exit = true;
						
						break;
						
					default:
						System.out.println();
				    	System.out.println("Choose a valid option from the menu...");
				    	System.out.println();
				    	
				    	break;
				}
			}
		}
		
		public Participation createParticipation() {
			Integer dorsalNumber = Read.readInt("Enter the dorsal number of the participation: ");
			String initialHour = Read.readString("Enter the initial hour of the participation: ");
			
			Participation participation=new Participation(dorsalNumber,initialHour);
			if (competition.addParticipation(participation, dorsalNumber) == true) {
				System.out.println("It has been created successfully");
			} else {
				System.out.println("Something went wrong try again");
			}
			manageParticipation();
			return participation;
		}
		
		public void searchParticipation() {
			Integer dorsalNumber = Read.readInt("Enter the dorsal number of the participation to search: ");
			//CompetitionRepo competitionRepo = new CompetitionRepo();
			
			Participation participation = competition.showParticipation(dorsalNumber);
			
			if(participation==null) {
				System.out.println("The dorsal number you entered does not exist in our database...");
			}else {
				System.out.println(participation.toString());
				
				manageParticipation();
			}
		}
		
		public void deleteParticipation() {
			Integer dorsalNumber = Read.readInt("Enter the dorsal number of the participation to search: ");
			
			Participation participation = competition.showParticipation(dorsalNumber);
			
			
			if(participation==null) {
				System.out.println("The dorsal number you entered does not exist in our database...");
			}else {
				competition.removeParticipation(participation, dorsalNumber);
			}
			manageParticipation();
		}
		
		public void updateParticipation() {
			boolean exit = false;
			
			while(!exit) {
				System.out.println();
				Integer dorsalNumber = Read.readInt("Enter the dorsal number of the participation to search: ");
				Gui.updateParticipation();
				
				switch(Read.readInt("Enter a valid option")) {
					case 1:
						Participation participation = competition.showParticipation(dorsalNumber);
						
						if(participation == null) {
							System.out.println("The dorsal number you entered does not exist in our database...");
						}else {
							String initialHour = Read.readString("Enter the new initial hour of participation: ");
							participation.setInitialHour(initialHour);
							manageParticipation();
						}
						
						break;
						
					case 2:
						participation = competition.showParticipation(dorsalNumber);
						
						if(participation == null) {
							System.out.println("The dorsal number you entered does not exist in our database...");
						}else {
							int points = Read.readInt("Enter the new points of participation: ");
							participation.setPoints(points);
							manageParticipation();
						}
						
						
						break;
						
					case 0:
						manageParticipation();
						exit = true;
						
						break;
					
					default:
						System.out.println();
				    	System.out.println("Choose a valid option from the menu...");
				    	System.out.println();
				    	
				    	break;
				}
			}
		}
		
		//public void showAllParticipations() {
			//System.out.println();
			//competition.showAllParticipation();
		//}
		
		public void manageTrials() {
			boolean exit = false;
			
			while(!exit) {
				Gui.crudTrials();
				
				switch(Read.readInt("Enter a valid option")) {
					case 1:
						createTrial();
						break;
						
					case 2:
						Trial t=manageTrial();
						if(t!=null){
							ControllerTrial c=ControllerTrial.get_instance();
							c.main(t,competition);
						}
						break;
					
						
					case 3:
						deleteTrial();
						
						break;
					case 0:
						exit = true;
						
						break;
						
					default:
				    	System.out.println("Choose a valid option from the menu...");
				    	break;
				}
			}
		}
		
		public Trial createTrial() {
			Type type = Type.fromName(Read.readString("Enter the type of the trial: "));
			System.out.println();
			Category category = Category.fromName(Read.readString("Enter the category of the trial: "));
			System.out.println();
			Kit kit = Kit.fromName(Read.readString("Enter the kit of the trial: "));
			System.out.println();
			//fromName-----------------------------------------
			Trial trial = new Trial(type, category, kit);
			if (competition.addTrial(trial) == true) {
				System.out.println("It has been created successfully");
			} else {
				System.out.println("Something went wrong try again");
			}
			return trial;
		}
		
		public Trial manageTrial() {
			Type type = Type.valueOf(Read.readString("Enter the type of the trial: "));
			Category category = Category.valueOf(Read.readString("Enter the category of the trial: "));
			Kit kit = Kit.valueOf(Read.readString("Enter the kit of the trial: "));
			
			Trial trial = competition.showTrial(type, category, kit);
			
			if(trial==null) {
				System.out.println("The name you entered does not exist in our database...");
			}else {
				System.out.println(trial);
			}
			return trial;
		}
		
		public void deleteTrial() {
			Type type = Type.valueOf(Read.readString("Enter the type of the trial: "));
			System.out.println();
			Category category = Category.valueOf(Read.readString("Enter the category of the trial: "));
			System.out.println();
			Kit kit = Kit.valueOf(Read.readString("Enter the kit of the trial: "));
			System.out.println();
			
			Trial trial = competition.showTrial(type, category, kit);
			
			
			if(trial==null) {
				System.out.println("The dorsal number you entered does not exist in our database...");
			}else {
				competition.removeTrial(trial);
			}
		}
		
		public void manageGroup() {
			boolean exit = false;
			
			while(!exit) {
				Gui.crudGroup();
				
				switch(Read.readInt("Enter a valid option")) {
					case 1:
						createGroup();
						
						break;
					
					case 2:
						updateGroup();
						
						break;
						
					case 3: 
						searchGroup();
						
						break;
					
						
					case 4: 
						deleteGroup();
						
						break;
						
					case 5: 
						insertGymnast();
						
						break;
						
					case 6:
						removeGymnast();
						
						break;
						
					case 0:
						mainMenu();
						exit = true;
						
						break;
						
					default:
				    	System.out.println("Choose a valid option from the menu...");
				    	break;
				}
			}
		}
		///////////////////////////////
		public Group createGroup() {
			String name = Read.readString("Enter the name of the group: ");
			System.out.println();
			String nameClub = Read.readString("Enter the club of the group: ");
			System.out.println();
			Club club = repoClub.searchClub(nameClub);
			Group group = new Group(name, club);
			if (competition.addGroup(group) == true) {
				System.out.println("It has been created successfully");
			} else {
				System.out.println("Something went wrong try again");
			}
			return group;
		}
		
		public void updateGroup() {
			boolean exit = false;
			
			while(!exit) {
				System.out.println();
				String name = Read.readString("Enter the name of the group to search:  ");
				System.out.println();
				
				Gui.updateGroup();
				
				switch(Read.readInt("Enter a valid option")) {
					case 1:
						Group group = competition.showGroup(name);
						
						if(group == null) {
							System.out.println("The name you entered does not exist in our database...");
						}else {
							String nameClub = Read.readString("Enter the new group club: ");
							Club club = repoClub.searchClub(nameClub);
							group.setClub(club);
							manageGroup();
						}
						
						break;
						
					case 0:
						exit = true;
						
						break;
					
					default:
				    	System.out.println("Choose a valid option from the menu...");
				    	break;
				}
			}
		}
		
		public void searchGroup() {
			String name = Read.readString("Enter the name of the group to search: ");
			
			Group group = competition.showGroup(name);
			
			if(group==null) {
				System.out.println("The name you entered does not exist in our database...");
			}else {
				System.out.println(group.toString());
				
				manageGroup();
			}
		}
		
		public void deleteGroup() {
			String name = Read.readString("Enter the name of the group to delete: ");
			Group group = competition.showGroup(name);
			
			if(group==null) {
				System.out.println("The name you entered does not exist in our database...");
			}else {
				competition.removeGroup(group);
				manageGroup();
			}
		}
		
		public void insertGymnast() {
			String groupName = Read.readString("Enter the name of the group to which the gymnast is to be inserted: ");
			String dni = Read.readString("Enter the DNI of the gymnast to inserted: ");
			Gymnast gymnast = repoGymnast.showGymnast(dni);
			
			
			if(gymnast == null) {
				System.out.println("The DNI you entered does not exist in our database...");
			}else {
				competition.insertGymnast(groupName, gymnast);
				manageGroup();
			}
		}
		
		public void removeGymnast() {
			String groupName = Read.readString("Enter the name of the group to which the gymnast is to be inserted: ");
			Group group = competition.showGroup(groupName);
			String dni = Read.readString("Enter the DNI of the gymnast to inserted: ");
			Gymnast gymnast = repoGymnast.showGymnast(dni);
			
			
			if(gymnast == null && group == null) {
				System.out.println("The DNI or the group name you entered does not exist in our database...");
			}else {
				competition.removeGymnast(group, gymnast);
				manageGroup();
			}
		}
		
		public static ControllerCompetition get_instance() {
			if(_instance == null) {
				_instance = new ControllerCompetition();
			}
			return _instance;
		}
		
		
}
