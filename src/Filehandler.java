import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Filehandler {

    private final String fileName = "memberData.txt";
    private ArrayList<Member> memberList = new ArrayList<>();
    private ArrayList<CompSwimmer> compList = new ArrayList<>();
    private ArrayList<FitnessSwimmer> fitnessList = new ArrayList<>();

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

    public ArrayList getCompList() {
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
        //ArrayList<Member> memberList = new ArrayList<>();
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
        //return memberList;
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

        Member newMember = new Member(memberID, fName, lName, birthYear);
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

            CompSwimmer newCompMember = new CompSwimmer(memberID, fName, lName, birthYear);
            compList.add(newCompMember);
        }
    }
}
