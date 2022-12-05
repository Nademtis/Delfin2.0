import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Filehandler {

    private final String fileName = "memberData.txt";
    private ArrayList<Member> memberList = new ArrayList<>();
    private ArrayList<CompSwimmer> compList = new ArrayList<>();
    private ArrayList<FitnessSwimmer> fitnessList = new ArrayList<>();
    Scanner in = new Scanner(System.in);

    //TODO skal loadFile() metoden below bruges? - HVIS saveNewMemberInFile() laver en ny memberData.txt, så behøver man ikke loadFile()-

//    public void loadFile() {
//        try {
//            File memberData = new File(fileName);
//            if (memberData.createNewFile()) {
//                //System.out.println("File created: " + memberData.getName());
//            } else {
//                //System.out.println("File already exists.");
//            }
//        } catch (IOException e) {
//            System.out.println("Something went wrong in Filehandler.createNewFile()");
//            e.printStackTrace();
//        }
//    }

    public ArrayList getAllMembersList() {
        updateMemberList();
        return memberList;
    }

    public ArrayList<CompSwimmer> getCompList() {
        updateCompList();
        return compList;
    }

    public ArrayList getFitnessList() {
        updateFitnessList();
        return fitnessList;
    }

    public void saveNewMemberInFile(String newMemberData) {
        try {
            FileWriter myWriter = new FileWriter(fileName, true);
            myWriter.write(nextAvailableMemberId() + ";" + newMemberData + "\n");
            myWriter.close();
        } catch (IOException e) {
            System.out.println("Something went wrong in FileHandler.saveNewMemberInFile()...");
            e.printStackTrace();
        }
    }

    public int nextAvailableMemberId() throws IOException {
        int nextId = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            while (reader.readLine() != null) {
                nextId++;
            }
        }
        return nextId;
    }

    private void updateMemberList() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String lineRead = reader.readLine();
            while (lineRead != null) {
                stringToMember(lineRead);
                lineRead = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void updateFitnessList() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String lineRead = reader.readLine();
            while (lineRead != null) {
                stringToFitness(lineRead);
                lineRead = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void updateCompList() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String lineRead = reader.readLine();
            while (lineRead != null) {
                stringToComp(lineRead);
                lineRead = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void stringToMember(String memberString) {
        String[] memberToken = memberString.split(";");
        List<String> list = Arrays.asList(memberToken);
        int memberID = Integer.parseInt(list.get(0));
        String fName = list.get(1);
        String lName = list.get(2);
        int birthYear = Integer.parseInt(list.get(3));
        boolean isActive = Boolean.parseBoolean(list.get(4));

        Member newMember = new Member(memberID, fName, lName, birthYear, isActive);
        memberList.add(newMember);
    }

    private void stringToFitness(String fitnessString) {
        String[] memberToken = fitnessString.split(";");
        List<String> list = Arrays.asList(memberToken);
        if (list.get(5).equals("true")) {
            int memberID = Integer.parseInt(list.get(0));
            String fName = list.get(1);
            String lName = list.get(2);
            int birthYear = Integer.parseInt(list.get(3));

            FitnessSwimmer newFitnessMember = new FitnessSwimmer(memberID, fName, lName, birthYear);
            fitnessList.add(newFitnessMember);
        }
    }

    private void stringToComp(String compString) {
        String[] memberToken = compString.split(";");
        List<String> list = Arrays.asList(memberToken);
        if (list.get(6).equals("true")) {
            int memberID = Integer.parseInt(list.get(0));
            String fName = list.get(1);
            String lName = list.get(2);
            int birthYear = Integer.parseInt(list.get(3));

            String discipline = list.get(7);
            double time = Double.parseDouble(list.get(8));

            CompSwimmer newCompMember = new CompSwimmer(memberID, fName, lName, birthYear, discipline, time);
            compList.add(newCompMember);
        }
    }

    public void editMember(int memberID, int tokenIndex, String newData) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String lineRead = reader.readLine();
            while (lineRead != null) {
                String[] memberToken = lineRead.split(";");
                List<String> list = Arrays.asList(memberToken);
                if (Integer.parseInt(list.get(0)) == (memberID)) {
                    editFile(tokenIndex, newData, list, memberID);
                    lineRead = null;
                } else {
                    lineRead = reader.readLine(); //goes to next line
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void checkMember() {
        ArrayList<Member> memberList = getAllMembersList();
        int memberId;

        System.out.println("Write the MemberID:");
        memberId = in.nextInt();
        try {
            System.out.println(memberList.get(memberId));
        } catch (Exception e) {
            System.out.println("ID: " + memberId + " is invalid or not in the system.");
        }
    }

    private void editFile(int tokenIndex, String newData, List<String> list, int memberId) throws IOException {

        List<String> lines = Files.readAllLines(Path.of("memberData.txt"));
        list.set(tokenIndex, newData);

        String newMemberData = list.get(0) + ";" + list.get(1) + ";" + list.get(2) + ";" + list.get(3) + ";" + list.get(4) + ";" + list.get(5) + ";"
                + list.get(6) + ";" + list.get(7) + ";" + list.get(8) + ";" + list.get(9) + ";";

        lines.set(memberId, newMemberData);
        Files.write(Path.of(fileName), lines);
    }
}
