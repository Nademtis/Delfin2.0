import java.io.File;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

public class Coach {
    Ui ui = new Ui();
    Filehandler filehandler = new Filehandler();

    public void menu() {
        Menu cMenu = new Menu("---COACH MENU---", "...", new String[]{"1. View teams sorted by age",
                "2. Register new personal records", "etc"});
        cMenu.printMenu();
        int choice = cMenu.readChoice();

        do {
            switch (choice) {
                case 1 -> System.out.println("View team sorted by age"); //TODO teamsSortedByAge();
                case 2 -> System.out.println("Register new Record");    //TODO RegisterNewRecord();
            }
        }while(0<1);

    }

//Method written by Emil, Laurits & Mathias
    public void viewAgeSortedTeams() {
        ArrayList<CompSwimmer> compList = filehandler.getCompList();

        ui.println("Competition swimmers under 18: ");
        for (int i = 0; i < compList.size(); i++) {
            if(LocalDateTime.now().getYear() - compList.get(i).getBirthYear() < 18 ){
                ui.println(compList.get(i).getfName() + " " + compList.get(i).getlName());
            }
        }

        ui.println("\n");

        ui.println("Competition swimmers over 18: ");
        for (int i = 0; i < compList.size(); i++) {
            if(LocalDateTime.now().getYear() - compList.get(i).getBirthYear() > 18 ){
                ui.println(compList.get(i).getfName() + " " + compList.get(i).getlName());
            }
        }

    }


}
