package src.main.java.iesFranciscodelosRios.Controller;

import View.Menu;
import iesFranciscodelosRios.GUI.Gui;
import model.Library;
import utilities.Useful;

public class ControllerCompetition {
	//ArrayList Trial Map<Integer, Participation> participations = new HashMap<>();
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
		String initialDate = Read.readString("Enter the initial date of the competition(dd/MM/yyyy): ");
		if (Read.findOutDate(initialDate)) {
		    System.out.println("The entered date is valid");
		} else {
			System.out.println("The entered date isn't valid");
		}
		System.out.println();
		
		Competition competition = new Competition(name, description, initialDate);
		if (competitionRepo.addCompetition(competition) == true) {
			System.out.println("It has been created successfully");
			manageCompetition();
		} else {
			System.out.println("Something went wrong try again");
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
			competition.removeCompetition(competition);
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
					Competition competition = showCompetition(name);
					
					if(competition == null) {
						System.out.println("The name you entered does not exist in our database...");
					}else {
						String description = Read.readString("Enter the new competition description: ");
						competition.setDescription(description);
						manageCompetition();
					}
					
					break;
					
				case 2:
					Competition competition = showCompetition(name);
					
					if(competition == null) {
						System.out.println("The name you entered does not exist in our database...");
					}else {
						String initialDate = Read.readString("Enter the new competition initial date: ");
						competition.setDescription(initialDate);
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
