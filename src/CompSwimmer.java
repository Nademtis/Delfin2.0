public class CompSwimmer extends Member {

    private double pb;
    private String discipline;

    public CompSwimmer(int memberID, String fName, String lName, int birthYear, String discipline, double pb) {
        super(memberID, fName, lName, birthYear);
        this.discipline = discipline;
        this.pb = pb;
    }

    public double getPb(){
        return pb;
    }

    public String getDiscipline() {
        return discipline;
    }
}
