package iesFranciscodelosRios.GUI;

public class Gui{

    public static void mainMenu() {
        System.out.println("0. Exit\n" +
                "1. Gymnastics manager\n" +
                "2. Competitions manager\n" +
                "3. Save and Exit");
    }
    public static void crudGymnastic() {
        System.out.println("0. Back\n" +
                "1. Federate gymnast\n" +
                "2. Search gymnast\n" +
                "3. Modify gymnast\n" +
                "4. Delete gymnast\n" +
                "5. Show all gymnast");
    }
    public static void updateGymnast() {
        System.out.println("0. Back\n" +
                "1. Gymnastic modify\n" +
                "2. Telephone modify\n" +
                "3. Email modify\n" +
                "4. Category\n" +
                "5. Club");
    }
    public static void competitionManager() {
        System.out.println("0. Back\n" +
                "1. Manage competition\n"+
                "2. Manage participations\n"+
                "3. Manage trials\n"+
                "4. Manage group");
    }
    public static void crudCompetition() {
        System.out.println("0. Back\n"+
                "1. Create competition\n"+
                "2. Competition update\n"+
                "3. Search competition\n"+
                "4. Delete competition\n"+
                "5. Show all competitions");
    }
    public static void updateCompetitions() {
        System.out.println("0. Back\n"+
                "1. Description\n"+
                "2. Date create\n");
    }
    public static void crudParticipations() {
        System.out.println("0. Back\n"+
                "1. Create participation\n"+
                "2. Update participation\n"+
                "3. Search participation\n"+
                "4. Delete participation\n");
    }
    public static void updateParticipation() {
        System.out.println("0. Back\n"+
                "1. Update hour\n"+
                "2. Update score\n");
    }
    public static void crudTrials() {
        System.out.println("0. Back\n"+
                "1. Create trial\n"+
                "2. Update trial\n"+
                "3. Search trial\n"+
                "4. Delete trial\n");
    }
    /*Este deberia estar incluido en trial*/
    public static void trial(){
        System.out.println("0. Back\n" +
                "1. Enter participation\n"+
                "2. Show all participations\n"+
                "4. Score a participant"+
                "5. Show winner\n");
    }
    public static void updateTrial() {
        System.out.println("0. Back\n"+
                "1. Update type\n"+
                "2. Update category\n"+
                "3. Update kit");
    }

    public static void crudGroup() {
        System.out.println("0. Back\n"+
                "1. Create group\n"+
                "2. Show groups\n"+
                "3. Update group\n"+
                "4. Delete group\n"+
                "5. Enter gymnast\n"+
                "6. Delete Gymnast");
    }

    public static void updateGroup() {
        System.out.println("0. Back\n"+
                "1. Club");
    }
}
