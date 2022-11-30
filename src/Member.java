public class Member {

    private String fName;
    private String lName;
    private int birthYear;
    private int memberID;
    private boolean isJunior = false;


    public Member(int memberID, String fName, String lName, int birthYear) {
        this.memberID = memberID;
        this.fName = fName;
        this.lName = lName;
        this.birthYear = birthYear;
        isJunior = (2022 - birthYear < 18) ? true : false;
    }

    public int getMemberID() {
        return memberID;
    }

    @Override
    public String toString() {
        return "Member{" +
                "fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", birthYear=" + birthYear +
                ", isJunior=" + isJunior +
                '}';
    }
}
