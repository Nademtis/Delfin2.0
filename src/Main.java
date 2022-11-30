import javax.imageio.IIOException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    public void run() throws IOException {

        Coach c = new Coach();
        c.viewAgeSortedTeams();

        String[] chairmanMenuChoices = {"1.Create new member", "2.Check member with given memberID",
                "3.Print all fitness members", "4.Print all fitness members"};
        Menu chairmanMenu = new Menu("Chairman Menu", "Pick the number:", chairmanMenuChoices);

        do {
            chairmanMenu.printMenu();
            switch (chairmanMenu.readChoice()) {
                case 1:
                    new Chairman().createMember();
                    break;
                case 2:
                    new Chairman().checkMember();
                    break;
                case 3:
                    new Chairman().getFitnessMembers();
                    break;
                case 4:
                    new Chairman().getCompMembers();
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        } while (1 > 0);
    }
}