package iesFranciscodelosRios.GUI;

import iesFranciscodelosRios.Utils.Utils;

public final class Gui{

    public static void mainMenu() {
        System.out.println(Utils.b+"0. Save and Exit\n" +
                "1. Gymnastics manager\n" +
                "2. Competitions manager\n" +
                "3. Clubs manager\n"+
                "4. Judge manager");
    }
    public static void crudGymnastic() {
        System.out.println(Utils.b+"0. Back\n" +
                "1. Federate gymnast\n" +
                "2. Search gymnast\n" +
                "3. Modify gymnast\n" +
                "4. Delete gymnast\n" +
                "5. Show all gymnast");
    }
    public static void updateGymnast() {
        System.out.println(Utils.b+"0. Back\n" +
                "1. Gymnastic modify\n" +
                "2. Telephone modify\n" +
                "3. Email modify\n" +
                "4. Category\n" +
                "5. Club");
    }
    public static void competitionManager() {
        System.out.println(Utils.b+"0. Back\n"+
                "1. Manage participations\n"+
                "2. Manage trials\n"+
                "3. Manage Group\n"+
                "4. Add Judge on this Competition\n"+
                "5. Show all Participation on this competition");
    }
    public static void crudCompetition() {
        System.out.println(Utils.b+"0. Back\n"+
                "1. Create competition\n"+
                "2. Competition update\n"+
                "3. Manage competitions\n"+
                "4. Delete competition\n"+
                "5. Show all competitions");
    }
    public static void updateCompetitions() {
        System.out.println(Utils.b+"0. Back\n"+
                "1. Description\n"+
                "2. Date create\n");
    }
    public static void crudPaticipations() {
        System.out.println(Utils.b+"0. Back\n"+
                "1. Create participation\n"+
                "2. Update participation\n"+
                "3. Search participation\n"+
                "4. Delete participation\n"+
                "5. Show all participations");
    }
    public static void updateParticipation() {
        System.out.println(Utils.b+"0. Back\n"+
                "1. Update dorsal\n"+
                "2. Update participation\n"+
                "3. Update hour\n"+
                "4. Update score\n");
    }
    public static void crudTrials() {
        System.out.println(Utils.b+"0. Back\n"+
                "1. Create trial\n"+
                "2. Search trial\n"+
                "3. Show all trials on this competition\n"+
                "4. Manage trial\n"+
                "5. Delete trial\n");
    }
    /*Este deberia estar incluido en trial*/
    public static void trial(){
        System.out.println(Utils.b+"0. Back\n" +
                "1. Enter participation\n"+
                "2. Search participant\n"+
                "3. Show all participations\n"+
                "4. Judge manager\n"+
                "5. Show winner\n");
    }

    public static void crudGroup() {
        System.out.println(Utils.b+"0. Back\n"+
                "1. Create group\n"+
                "2. Show groups\n"+
                "3. Update group\n"+
                "4. Delete group\n"+
                "5. Enter gymnast\n"+
                "6. Delete Gymnast");
    }
    public static void crudClub(){
        System.out.println(Utils.b+"0. Back\n"+
                "1. Create club\n"+
                "2. Delete club\n"+
                "3. search club\n"+
                "4. Show clubs");
    }
    // Este metodo se implementa en controllerTrial
    public static void JudgeManager(){
        System.out.println(Utils.b+"0. Back\n"+
                "1. Score ");
    }
    public static void crudJudge(){
        System.out.println(Utils.b+"0. Back\n"+
                "1. Register new Judge\n"+
                "2. Remove some judge\n"+
                "3. search some judge\n"+
                "4. Show all judges");
    }
    public static void updateGroup() {
        System.out.println("0. Back\n"+
                "1. Club");
    }
}
