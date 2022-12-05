import java.io.IOException;
import java.util.Scanner;

public class Chairman {
    Ui ui = new Ui();
    Scanner in = new Scanner(System.in);
    Filehandler filehandler = new Filehandler();

    public void chairmanMenu() throws IOException {
        String[] chairmanMenuChoices = {"1. Create new member", "2. Check member with given memberID",
                "3. Print all fitness members", "4. Print all fitness members", "9. Exit chairman menu"};
        Menu chairmanMenu = new Menu("Chairman Menu", "Pick the number:", chairmanMenuChoices);
        boolean runWhile = true;
        do {
            chairmanMenu.printMenu();
            switch (chairmanMenu.readChoice()) {
                case 1:
                    createMember();
                    break;
                case 2:
                    filehandler.checkMember();
                    break;
                case 3:
                    getFitnessMembers();
                    break;
                case 4:
                    getCompMembers();
                    break;
                case 9:
                    System.out.println("Going back to main menu...");
                    runWhile = false;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        } while (runWhile);
    }

    public void createMember() throws IOException {
        int newId = filehandler.nextAvailableMemberId();
        filehandler.saveNewMemberInFile(userInputForNewMember());
        System.out.println("New member was added with the ID:" + newId);
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
        in.nextLine();//Scannerbug
        boolean isActive = (i == 1);
        System.out.println("Does the user want to have a (1)Fitness or (2)Competition membership?");
        i = in.nextInt();
        in.nextLine();//Scannerbug
        boolean isFitness = (i == 1);
        boolean isComp = (i == 2);
        //TODO IF isComp=true skal brugeren vælge en dicipline, som skal gemmes med
        String compChoice = "noDiscipline";
        if (isComp == true) {
            compChoice = compChoice();
        }
        //TODO giv member en mulighed for at betal on the spot
        System.out.println("Has the user payed? Write true/false");
        boolean hasPayed = Boolean.parseBoolean(in.nextLine());

//        System.out.println("Date for registration: ");
//        //LocalDateTime.now().getYear()
//        System.out.println("Has the member payed?");
//
//        // Print to see what it returns System.out.println(LocalDateTime.now().getYear());

        String newMemberData = fName + ";" + lName + ";" + birthYear + ";" + isActive + ";" + isFitness + ";" + isComp + ";"
                + compChoice + ";" + "0.0" + ";" + hasPayed + ";" ;
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
