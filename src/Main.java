import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        new Main().run();
//        new Coach().viewTop5();

    }

    private void run() throws IOException {
        String[] MenuChoices = {"1. Chairman Menu", "2. Choach Menu",
                "3. Cashier Menu", "9. Exit program"};
        Menu mainMenu = new Menu("Welcome back", "Pick the number:", MenuChoices);
        boolean runWhile = true;
        do {
            mainMenu.printMenu();
            switch (mainMenu.readChoice()) {
                case 1:
                    new Chairman().chairmanMenu();
                    break;
                case 2:
                    new Coach().coachMenu();
                    break;
                case 3:
                    new Cashier().cashierMenu();
                    break;
                case 9:
                    System.out.println("Exiting Program...");
                    runWhile = false;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        } while (runWhile);
    }
}