public class Student {
    private String firstName;
    private String lastName;
    private String email;
    private boolean checkedIn;
    private int compSciNum;
    private int familiarML;
    private int expGIS;
    private int expAWS;
    private int totalScore;

    public Student(String ID){
        firstName = "";
        lastName = "";
        email = "";
        checkedIn = false;
        compSciNum = 0;
        familiarML = 0;
        expGIS = 0;
        expAWS = 0;
        totalScore = 0;

    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public String getFirstName(){
        return firstName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public String getLastName(){
        return lastName;
    }

    public void setTotalScore(){
        totalScore = compSciNum + familiarML + expGIS + expAWS;
    }

    public int getTotalScore(){
        return totalScore;
    }
}
