public class Member {

    private String fName;
    private String lName;
    private int birthYear;
    private int memberID;
    private boolean isJunior = false;
    private boolean hasPaid;

    private boolean isActive;

    public Member(int memberID, String fName, String lName, int birthYear, boolean hasPaid, boolean isActive) {
        this.memberID = memberID;
        this.fName = fName;
        this.lName = lName;
        this.birthYear = birthYear;
        isJunior = (2022 - birthYear < 18) ? true : false;
        this.hasPaid = hasPaid;
        this.isActive = isActive;
    }
    public Member(int memberID, String fName, String lName, int birthYear, boolean isActive) {
        this.memberID = memberID;
        this.fName = fName;
        this.lName = lName;
        this.birthYear = birthYear;
        isJunior = (2022 - birthYear < 18) ? true : false;
        this.isActive = isActive;
    }
    //Constructor uden hasPaid boolean
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

    public int getBirthYear() {
        return birthYear;
    }

    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    public boolean isActive(){
        return isActive;
    }

    public void setHasPaid(boolean hasPaid) {
        this.hasPaid = hasPaid;
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
