import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Chairman {
    Ui ui = new Ui();
    Scanner in = new Scanner(System.in);

    Filehandler filehandler = new Filehandler();

    public void createMember() throws IOException {
        int newId = filehandler.nextAvailableMemberId();
        filehandler.saveNewMemberInFile(userInputForNewMember());
        System.out.println("New member was added with the ID:" + newId);
    }

    public void checkMember() {
        ArrayList<Member> memberList = filehandler.getAllMembersList();
        int memberId;

        System.out.println("Write the MemberID:");
        memberId = in.nextInt();
        try {
            System.out.println(memberList.get(memberId));
        } catch (Exception e) {
            System.out.println("ID: " + memberId + " is invalid or not in the system.");
        }
    }

    public void getFitnessMembers() {
        System.out.println(filehandler.getFitnessList());
    }

    public void getCompMembers() {
        System.out.println(filehandler.getCompList());
    }

    private String userInputForNewMember() {
        System.out.println("Insert members first name: ");
        String fName = in.nextLine();
        System.out.println("Insert members last name: ");
        String lName = in.nextLine();
        System.out.println("Insert members birth year: ");
        String birthYear = in.nextLine();
        System.out.println("Does the user want an (1)Active or (2)Passive membership?");
        int i = in.nextInt();
        boolean isActive = (i == 1);
        System.out.println("Does the user want to have a (1)Fitness or (2)Competition membership?");
        i = in.nextInt();
        boolean isFitness = (i == 1);
        boolean isComp = (i == 2);
        //TODO IF isComp=true skal brugeren vælge en dicipline, som skal gemmes med
        String compChoice = "noDiscipline";
        if (isComp == true) {
            compChoice = compChoice();
        }
        String newMemberData = fName + ";" + lName + ";" + birthYear + ";" + isActive + ";" + isFitness + ";" + isComp + ";"
                + compChoice + ";" + "0.0" + ";";
        //System.out.println(newMemberData); //For debugging
        return newMemberData;
    }

    private String compChoice() {
        String choice = "";

        Menu compMenu = new Menu("Choose the discipline", "Please type a number between 1 and 5: \n",
                new String[]{"1. Crawl", "2. Breaststroke", "3. Butterfly", "4. Backstroke", "5. Medley"});
        compMenu.printMenu();
        int numChoice = -1;
        boolean validChoice = false;
        while (!validChoice) {
            if (numChoice < 1 || numChoice > 5)
                numChoice = compMenu.readChoice();
            else
                validChoice = true;
        }
        switch (numChoice) {
            case 1 -> choice = "Crawl";
            case 2 -> choice = "Breaststroke";
            case 3 -> choice = "Butterfly";
            case 4 -> choice = "Backstroke";
            case 5 -> choice = "Medley";
        }

        return choice;
    }
}
