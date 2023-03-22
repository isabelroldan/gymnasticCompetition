package iesFranciscodelosRios.Controller;

import iesFranciscodelosRios.Enum.*;
import iesFranciscodelosRios.GUI.Gui;
import iesFranciscodelosRios.Repos.*;
import iesFranciscodelosRios.Utils.*;
import iesFranciscodelosRios.model.*;

import java.util.Date;

public class ControllerCompetition {
    private Competition competition; //esto deberia ser un repo . para de este modo saber a que competicion desea realizar cambios el usuario
    private static ControllerCompetition _instance = null;

    public void mainMenu() {
        RepoClub.set_instance(XMLManager.readXML(RepoClub.get_instance(), "Clubs.xml"));
        RepoGymnast.set_instance(XMLManager.readXML(RepoGymnast.get_instance(), "Gymnastes.xml"));
        CompetitionRepo.set_instance(XMLManager.readXML(CompetitionRepo.get_instance(), "Competitions.xml"));
        XMLManager.readXML(CompetitionRepo.get_instance(), "Competitions.xml");
        JudgeRepo.set_instance(XMLManager.readXML(JudgeRepo.get_instance(), "Judges.xml"));
        boolean exit = false;

        while (!exit) {
            Gui.mainMenu();

            switch (Read.readInt("Enter a valid option")) {
                case 1:
                    GymnastController gc = GymnastController.get_instance();
                    gc.main();
                    break;

                case 2:
                    manageCompetitions();
                    break;
                case 3:
                    ClubController cc = ClubController.get_instance();
                    cc.main();
                    break;
                case 4:
                    ControllerJudge jc = ControllerJudge.get_intance();
                    jc.main();
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

    public void competitionManager() {
        boolean exit = false;

        while (!exit) {
            Gui.competitionManager();

            switch (Read.readInt("Enter a valid option")) {
                case 1:
                    manageParticipation();
                    break;
                case 2:
                    manageTrials();
                    break;

                case 3:
                    ControllerGroup cg = ControllerGroup.get_instance();
                    cg.manageGroup(competition);
                    break;
                case 4:
                    competition.showAllParticipation();
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

        while (!exit) {
            Gui.crudCompetition();

            switch (Read.readInt("Enter a valid option")) {
                case 1:
                    createCompetition();
                    break;
                case 2:
                    updateCompetition();
                    break;
                case 3:
                    searchCompetition();
                    if (competition != null) {
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
        String description = Read.readString("Enter the description of the competition: ");

        Date initialDate = null;

        boolean valid = false;
        while (!valid) {
            initialDate = Read.readDate("Enter the initial date of the competition(dd/MM/yyyy): ");
            if (initialDate != null) {
                System.out.println("The entered date is valid");
                valid = true;
            } else {
                System.out.println("The entered date isn't valid");
            }
        }

        Competition competition = new Competition(name, description, initialDate);
        if (CompetitionRepo.get_instance().addCompetition(competition)) {
            System.out.println("It has been created successfully");
        } else {
            System.out.println("Something went wrong, try again");
        }
        return competition;
    }

    public void searchCompetition() {
        String name = Read.readString("Enter the name of the competition to search: ");

        Competition competition = CompetitionRepo.get_instance().searchCompetition(name);

        if (competition == null) {
            System.out.println("The name you entered does not exist in our database...");
        } else {
            System.out.println(competition);
            this.competition = competition;
        }
    }

    public void deleteCompetition() {
        String name = Read.readString("Enter the name of the competition to delete: ");
        Competition competition = CompetitionRepo.get_instance().searchCompetition(name);

        if (competition == null) {
            System.out.println("The name you entered does not exist in our database...");
        } else {
            CompetitionRepo.get_instance().removeCompetition(competition);
        }
    }

    public void updateCompetition() {
        boolean exit = false;

        while (!exit) {
            String name = Read.readString("Enter the name of the competition to change: ");
            Gui.updateCompetitions();

            switch (Read.readInt("Enter a valid option")) {
                case 1:
                    Competition competition = CompetitionRepo.get_instance().searchCompetition(name);

                    if (competition == null) {
                        System.out.println("The name you entered does not exist in our database...");
                    } else {
                        String description = Read.readString("Enter the new competition description: ");
                        competition.setDescription(description);
                    }

                    break;

                case 2:
                    competition = CompetitionRepo.get_instance().searchCompetition(name);

                    if (competition == null) {
                        System.out.println("The name you entered does not exist in our database...");
                    } else {
                        Date initialDate;
                        boolean valid = false;

                        while (!valid) {
                            initialDate = Read.readDate("Enter the new competition initial date: ");
                            if (initialDate != null) {
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
                    System.out.println("Choose a valid option from the menu...");
                    break;
            }
        }

    }

    public void showAllCompetitions() {
        CompetitionRepo.get_instance().showAllCompetitions();
    }

    public void manageParticipation() {
        boolean exit = false;

        while (!exit) {
            Gui.crudPaticipations();

            switch (Read.readInt("Enter a valid option")) {
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
                case 5:
                    showAllCompetitions();
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

    public Participation createParticipation() {
        Integer dorsalNumber = Read.readInt("Enter the dorsal number of the participation: ");
        String initialHour = Read.readString("Enter the initial hour of the participation: ");

        Participation participation = new Participation(dorsalNumber, initialHour);
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

        if (participation == null) {
            System.out.println("The dorsal number you entered does not exist in our database...");
        } else {
            System.out.println(participation.toString());

            manageParticipation();
        }
    }

    public void deleteParticipation() {
        Integer dorsalNumber = Read.readInt("Enter the dorsal number of the participation to search: ");

        Participation participation = competition.showParticipation(dorsalNumber);


        if (participation == null) {
            System.out.println("The dorsal number you entered does not exist in our database...");
        } else {
            competition.removeParticipation(participation, dorsalNumber);
        }
        manageParticipation();
    }

    public void updateParticipation() {
        boolean exit = false;

        while (!exit) {
            Integer dorsalNumber = Read.readInt("Enter the dorsal number of the participation to search: ");
            Gui.updateParticipation();

            switch (Read.readInt("Enter a valid option")) {
                case 1:
                    Participation participation = competition.showParticipation(dorsalNumber);

                    if (participation == null) {
                        System.out.println("The dorsal number you entered does not exist in our database...");
                    } else {
                        String initialHour = Read.readString("Enter the new initial hour of participation: ");
                        participation.setInitialHour(initialHour);
                        manageParticipation();
                    }
                    break;
                case 2:
                    participation = competition.showParticipation(dorsalNumber);

                    if (participation == null) {
                        System.out.println("The dorsal number you entered does not exist in our database...");
                    } else {
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
                    System.out.println("Choose a valid option from the menu...");
                    break;
            }
        }
    }
    public void manageTrials() {
        boolean exit = false;
        while (!exit) {
            Gui.crudTrials();

            switch (Read.readInt("Enter a valid option")) {
                case 1:
                    createTrial();
                    break;

                case 2:
                    Trial t = manageTrial();
                    if (t != null) {
                        ControllerTrial c = ControllerTrial.get_instance();
                        c.main(t, competition);
                    }
                    break;
                case 3:
                    competition.showAllTrial();
                    break;
                case 4:
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
        Category category = Category.fromName(Read.readString("Enter the category of the trial: "));
        Kit kit = Kit.fromName(Read.readString("Enter the kit of the trial: "));
        Trial trial = new Trial(type, category, kit);
        if (type!=null && category!=null && kit!=null && competition.addTrial(trial)) {
            System.out.println("It has been created successfully");
        } else {
            System.out.println("Something went wrong try again");
        }
        return trial;
    }

    public Trial manageTrial() {
        Type type = Type.fromName(Read.readString("Enter the type of the trial: "));
        Category category = Category.fromName(Read.readString("Enter the category of the trial: "));
        Kit kit = Kit.fromName(Read.readString("Enter the kit of the trial: "));

        Trial trial = competition.searchTrial(type, category, kit);

        if (trial == null) {
            System.out.println("The name you entered does not exist in our database...");
        } else {
            System.out.println(trial);
        }
        return trial;
    }

    public void deleteTrial() {
        Type type = Type.fromName(Read.readString("Enter the type of the trial: "));
        Category category = Category.fromName(Read.readString("Enter the category of the trial: "));
        Kit kit = Kit.fromName(Read.readString("Enter the kit of the trial: "));

        Trial trial = competition.searchTrial(type, category, kit);


        if (trial == null) {
            System.out.println("The dorsal number you entered does not exist in our database...");
        } else {
            competition.removeTrial(trial);
        }
    }

    public static ControllerCompetition get_instance() {
        if (_instance == null) {
            _instance = new ControllerCompetition();
        }
        return _instance;
    }


}
