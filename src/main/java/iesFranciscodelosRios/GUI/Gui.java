package iesFranciscodelosRios.GUI;

import iesFranciscodelosRios.interfaces.iGUI;

public class Gui implements iGUI {

    @Override
    public void mainMenu() {
        System.out.println("0. Exit\n" +
                "1. Gymnastics manager\n" +
                "2. Competitions manager\n" +
                "3. Save and Exit");
    }

    @Override
    public void crudGymnastic() {
        System.out.println("0. Back\n" +
                "1. Federate gymnast\n" +
                "2. Search gymnast\n" +
                "3. Modify gymnast\n" +
                "4. Delete gymnast\n" +
                "5. Show all gymnast");
    }

    @Override
    public void updateGymnast() {
        System.out.println("0. Back\n" +
                "1. Gymnastic modify\n" +
                "2. Telephone modify\n" +
                "3. Email modify\n" +
                "4. Category\n" +
                "5. Club");
    }

    @Override
    public void competitionManager() {
        System.out.println("0. Back\n" +
                "1. Manage competition\n" +
                "2. Manage participations\n" +
                "3. Manage trials");
    }

    /*Esto deberia implementarse en repo_competition*/
    @Override
    public void crudCompetition() {
        System.out.println("0. Back\n" +
                "1. Create competition\n" +
                "2. Competition update\n" +
                "3. Search competition\n" +
                "4. Delete competition\n" +
                "5. Show all competitions");
    }

    /*Esto deberia implementarse dentro de competition*/
    @Override
    public void updateCompetitions() {
        System.out.println("0. Back\n" +
                "1. Description\n" +
                "2. Date create\n");
    }

    /*Lo implementaremos en competition para dejar constancia de todos los participantes que
    participaran en una competicion
    */
    @Override
    public void crudPaticipations() {
        System.out.println("0. Back\n" +
                "1. Create participation\n" +
                "2. Update participation\n" +
                "3. Search participation\n" +
                "4. Delete participation\n" +
                "5. Score");
    }

    @Override
    public void updateParticipation() {
        System.out.println("0. Back\n" +
                "1. Update dorsal\n" +
                "2. Update participation\n" +
                "3. Update hour\n" +
                "4. Update score\n");
    }

    /*Este crud deberia implementarse en competition*/
    @Override
    public void crudTrials() {
        System.out.println("0. Back\n" +
                "1. Create trial\n" +
                "2. Update trial\n" +
                "3. Search trial\n" +
                "4. Delete trial\n");
    }

    /*Este deberia estar incluido en trial*/
    public void trial() {
        System.out.println("0. Back\n" +
                "1. Enter participation\n" +
                "2. Show all participations\n" +
                "4. Score a participant" +
                "5. Show winner\n");
    }

    /*Este deberia implementarse en competition*/
    @Override
    public void updateTrial() {
        System.out.println("0. Back\n" +
                "1. Update type\n" +
                "2. Update category\n" +
                "3. Update kit");
    }

    @Override
    public void crudGroup() {
        System.out.println("0. Back\n" +
                "1. Create group\n" +
                "2. Show groups\n" +
                "3. Update group\n" +
                "4. Delete group\n" +
                "5. Enter gymnast\n" +
                "6. Delete Gymnast");
    }

    @Override
    public void updateGroup() {
        System.out.println("0. Back\n" +
                "1. Club");
    }
}
