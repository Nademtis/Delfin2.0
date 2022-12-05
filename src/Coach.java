import java.time.LocalDateTime;
import java.util.ArrayList;

//TODO Add editFile so he can change the record time for each ( f.editMember(memberId, 9, "true");) - Laurits & Martin
public class Coach {
    Ui ui = new Ui();
    Filehandler filehandler = new Filehandler();

    public void coachMenu() {
        Menu cMenu = new Menu("---COACH MENU---", "...", new String[]{"1. View teams sorted by age",
                "2. View top 5", "3. Register new personal records", "4. View swimmers personal record"});
        //int choice = cMenu.readChoice();
        boolean runWhile = true;
        do {
            cMenu.printMenu();
            switch (cMenu.readChoice()) {
                case 1 -> new Coach().viewAgeSortedTeams();
                case 2 -> new Coach().viewTop5();
                case 3 -> new Coach().registerNewRecord();
                case 4 -> System.out.println("View swimmers pb"); //TODO viewPersonalBest();
                default -> runWhile = false;
            }
        } while (runWhile);
    }

    //Method written by Emil, Laurits & Mathias
    public void viewAgeSortedTeams() {
        ArrayList<CompSwimmer> compList = filehandler.getCompList();

        ui.println("Competition swimmers under 18: ");
        for (int i = 0; i < compList.size(); i++) {
            if (LocalDateTime.now().getYear() - compList.get(i).getBirthYear() < 18) {
                ui.println(compList.get(i).getfName() + " " + compList.get(i).getlName());
            }
        }

        ui.println("\n");

        ui.println("Competition swimmers over 18: ");
        for (int i = 0; i < compList.size(); i++) {
            if (LocalDateTime.now().getYear() - compList.get(i).getBirthYear() > 18) {
                ui.println(compList.get(i).getfName() + " " + compList.get(i).getlName());
            }
        }
    }
}
