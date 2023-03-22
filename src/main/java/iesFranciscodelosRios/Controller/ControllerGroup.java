package iesFranciscodelosRios.Controller;

import iesFranciscodelosRios.Enum.Category;
import iesFranciscodelosRios.GUI.Gui;
import iesFranciscodelosRios.Repos.*;
import iesFranciscodelosRios.Utils.Read;
import iesFranciscodelosRios.model.*;

public class ControllerGroup {
	private static ControllerGroup _instance=null;

	private ControllerGroup() {

	}

	/**
	 * Controller for manage group
	 */
	public void manageGroup(Competition c) {
		boolean exit = false;

		while (!exit) {
			Gui.crudGroup();

			switch (Read.readInt("Enter a valid option")) {
			case 1:
				createGroup(c);
				break;
			case 2:
				searchGroup(c);
				break;
			case 3:
				updateGroup(c);
				break;
			case 4:
				deleteGroup(c);
				break;
			case 5:
				insertGymnast(c);
				break;
			case 6:
				removeGymnast(c);
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

	/**
	 * Controller for create group
	 * 
	 * @return group
	 */
	public Group createGroup(Competition c) {
		String name = Read.readString("Enter the name of the group: ");
		String nameClub = Read.readString("Enter the club of the group: ");
		Club club = RepoClub.get_instance().searchClub(nameClub);
		Group group = new Group(name, club, Category.fromName(Read.readString("Enter a category for this grouo [Prebenjamin,Benjamin,Alevin...")));
		if (c.addGroup(group)) {
			System.out.println("It has been created successfully");
		} else {
			System.out.println("Something went wrong try again");
		}
		return group;
	}

	/**
	 * Controller for update group
	 */
	public void updateGroup(Competition c) {
		boolean exit = false;

		while (!exit) {
			String name = Read.readString("Enter the name of the group to search:  ");

			Gui.updateGroup();

			switch (Read.readInt("Enter a valid option")) {
			case 1:
				Group group = c.showGroup(name);
				if (group == null) {
					System.out.println("The name you entered does not exist in our database...");
				} else {
					String nameClub = Read.readString("Enter the new group club: ");
					Club club = RepoClub.get_instance().searchClub(nameClub);
					group.setClub(club);
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

	/**
	 * Controller for search group
	 */
	public void searchGroup(Competition c) {
		String name = Read.readString("Enter the name of the group to search: ");

		Group group = c.showGroup(name);

		if (group == null) {
			System.out.println("The name you entered does not exist in our database...");
		} else {
			System.out.println(group);
		}
	}

	/**
	 * Controller for delete group
	 */
	public void deleteGroup(Competition c) {
		String name = Read.readString("Enter the name of the group to delete: ");
		Group group = c.showGroup(name);

		if (group == null) {
			System.out.println("The name you entered does not exist in our database...");
		} else {
			c.removeGroup(group);
		}
	}

	/**
	 * Controller for insert gymnast in a group
	 */
	public void insertGymnast(Competition c) {
		String groupName = Read.readString("Enter the name of the group to which the gymnast is to be inserted: ");
		String dni = Read.readString("Enter the DNI of the gymnast to inserted: ");
		Gymnast gymnast = RepoGymnast.get_instance().showGymnast(dni);

		if (gymnast == null) {
			System.out.println("The DNI you entered does not exist in our database...");
		} else {
			c.insertGymnast(groupName, gymnast);
		}
	}

	/**
	 * Controller for remove gymnast in a group
	 */
	public void removeGymnast(Competition c) {
		String groupName = Read.readString("Enter the name of the group to which the gymnast is to be inserted: ");
		Group group = c.showGroup(groupName);
		String dni = Read.readString("Enter the DNI of the gymnast to inserted: ");
		Gymnast gymnast = RepoGymnast.get_instance().showGymnast(dni);

		if (gymnast == null && group == null) {
			System.out.println("The DNI or the group name you entered does not exist in our database...");
		} else {
			c.removeGymnast(group, gymnast);
		}
	}

	public static ControllerGroup get_instance() {
		if(_instance==null){
			_instance=new ControllerGroup();
		}
		return _instance;
	}
}
