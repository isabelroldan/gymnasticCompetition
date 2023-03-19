package iesFranciscodelosRios.Controller;

import iesFranciscodelosRios.Enum.Category;
import iesFranciscodelosRios.Enum.Kit;
import iesFranciscodelosRios.Enum.Type;
import iesFranciscodelosRios.GUI.Gui;
import iesFranciscodelosRios.Repos.CompetitionRepo;
import iesFranciscodelosRios.Repos.RepoClub;
import iesFranciscodelosRios.Repos.RepoGymnast;
import iesFranciscodelosRios.Utils.Read;
import iesFranciscodelosRios.model.Club;
import iesFranciscodelosRios.model.Competition;
import iesFranciscodelosRios.model.Group;
import iesFranciscodelosRios.model.Gymnast;
import iesFranciscodelosRios.model.Participation;
import iesFranciscodelosRios.model.Trial;

public class ControllerCompetition {
	//ArrayList Trial Map<Integer, Participation> participations = new HashMap<>();
	CompetitionRepo competitionRepo = new CompetitionRepo();
	RepoGymnast repoGymnast = new RepoGymnast();
	Competition competition = new Competition();
	RepoClub repoClub = new RepoClub();
	private static ControllerCompetition _instance = null;
		public void mainMenu() {
			boolean exit = false;
			
			while(!exit) {
				Gui.mainMenu();
				
				switch(Read.readInt("Enter a valid option")) {
					case 1:
						//gymnastics manager
						
						break;
					
					case 2:
						competitionManager();
						
						break;
						
					case 3: 
						//save and exit
						
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
		
		public void competitionManager() {
			boolean exit = false;
			
			while(!exit) {
				Gui.competitionManager();
				
				switch(Read.readInt("Enter a valid option")) {
					case 1:
						manageCompetition();
						
						break;
					
					case 2:
						manageParticipation();
						
						break;
						
					case 3: 
						manageTrial();
						
						break;
						
					case 4:
						manageGroup();
						
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
		
		public void manageCompetition() {
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
								
								break;
							
								
							case 4: 
								deleteCompetition();
								
								break;
								
							case 5: 
								showAllCompetitions();
								
								break;
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
		
		
		public Competition createCompetition() {
		    String name = Read.readString("Enter the name of the competition: ");
		    System.out.println();
		    String description = Read.readString("Enter the description of the competition: ");
		    System.out.println();
		    
		    String initialDate = null;
		    
		    boolean valid = false;
		    while(!valid) {
		        initialDate = Read.readString("Enter the initial date of the competition(dd/MM/yyyy): ");
		        if (Read.findOutDate(initialDate)) {
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
		        manageCompetition();
		    } else {
		        System.out.println("Something went wrong, try again");
		    }
		    return competition;
		}
		
		public void searchCompetition() {
			String name = Read.readString("Enter the name of the competition to search: ");
			
			Competition competition = competitionRepo.showCompetition(name);
			
			if(competition==null) {
				System.out.println("The name you entered does not exist in our database...");
			}else {
				System.out.println(competition.toString());
				
				manageCompetition();
			}
		}
		
		public void deleteCompetition() {
			String name = Read.readString("Enter the name of the competition to delete: ");
			Competition competition = competitionRepo.showCompetition(name);
			
			if(competition==null) {
				System.out.println("The name you entered does not exist in our database...");
			}else {
				competitionRepo.removeCompetition(competition);
				manageCompetition();
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
						Competition competition = competitionRepo.showCompetition(name);
						
						if(competition == null) {
							System.out.println("The name you entered does not exist in our database...");
						}else {
							String description = Read.readString("Enter the new competition description: ");
							competition.setDescription(description);
							manageCompetition();
						}
						
						break;
						
					case 2:
						competition = competitionRepo.showCompetition(name);
						
						if(competition == null) {
							System.out.println("The name you entered does not exist in our database...");
						}else {
							String initialDate = null;
							boolean valid = false;
							
							while(!valid) {
								initialDate = Read.readString("Enter the new competition initial date: ");
								if (Read.findOutDate(initialDate)) {
									competition.setInitialDate(initialDate);
						            System.out.println("The entered date is valid");
						            valid = true;
						        } else {
						            System.out.println("The entered date isn't valid");
						        }
							}
							
							manageCompetition();
						}
						
						break;
						
					case 0:
						manageCompetition();
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
				Gui.crudParticipations();
				
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
			System.out.println();
			String initialHour = Read.readString("Enter the initial hour of the participation: ");
			System.out.println();
			int points = Read.readInt("Enter the points of the participation: ");
			System.out.println();
			
			Participation participation=new Participation(dorsalNumber,initialHour,points);
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
		
		public void manageTrial() {
			boolean exit = false;
			
			while(!exit) {
				Gui.crudTrials();
				
				switch(Read.readInt("Enter a valid option")) {
					case 1:
						createTrial();
						
						break;
					
					case 2:
						updateTrial();
						
						break;
						
					case 3: 
						searchTrial();
						
						break;
					
						
					case 4: 
						deleteTrial();
						
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
			manageTrial();
			return trial;
		}
		
		
		public void updateTrial() {
			boolean exit = false;
			
			while(!exit) {
				System.out.println();
				Type type = Type.valueOf(Read.readString("Enter the type of the trial: "));
				System.out.println();
				Category category = Category.valueOf(Read.readString("Enter the category of the trial: "));
				System.out.println();
				Kit kit = Kit.valueOf(Read.readString("Enter the kit of the trial: "));
				System.out.println();
				Gui.updateTrial();
				
				switch(Read.readInt("Enter a valid option")) {
					case 1:
						Trial trial = competition.showTrial(type, category, kit);
						
						if(competition == null) {
							System.out.println("The type, category and kit you entered does not exist in our database...");
						}else {
							type = Type.valueOf(Read.readString("Enter the new trial type: "));
							trial.setType(type);
							manageTrial();
						}
						
						break;
						
					case 2:
						trial = competition.showTrial(type, category, kit);
						
						if(competition == null) {
							System.out.println("The type, category and kit you entered does not exist in our database...");
						}else {
							category = Category.valueOf(Read.readString("Enter the new category type: "));
							trial.setCategory(category);
							manageTrial();
						}
						
						break;
						
					case 3:
						trial = competition.showTrial(type, category, kit);
						
						if(competition == null) {
							System.out.println("The type, category and kit you entered does not exist in our database...");
						}else {
							kit = Kit.valueOf(Read.readString("Enter the new kit type: "));
							trial.setKit(kit);
							manageTrial();
						}
						
						break;
						
					case 0:
						manageCompetition();
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
		
		public void searchTrial() {
			Type type = Type.valueOf(Read.readString("Enter the type of the trial: "));
			System.out.println();
			Category category = Category.valueOf(Read.readString("Enter the category of the trial: "));
			System.out.println();
			Kit kit = Kit.valueOf(Read.readString("Enter the kit of the trial: "));
			System.out.println();
			
			Trial trial = competition.showTrial(type, category, kit);
			
			if(trial==null) {
				System.out.println("The name you entered does not exist in our database...");
			}else {
				System.out.println(trial.toString());
				
				manageTrial();
			}
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
			manageTrial();
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
						System.out.println();
				    	System.out.println("Choose a valid option from the menu...");
				    	System.out.println();
				    	
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
			manageGroup();
			
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
						manageCompetition();
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
