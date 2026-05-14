public class Student {
    private String ID;
    private String firstName;
    private String lastName;
    private int compSciNum;
    private int familiarML;
    private int expGIS;
    private int expAWS;
    private int totalScore;

    public Student(String ID){
        this.ID = ID;
        firstName = "";
        lastName = "";
        compSciNum = 0;
        familiarML = 0;
        expGIS = 0;
        expAWS = 0;
        totalScore = 0;

    }

    //ID
    public void setID(String ID){
        this.ID = ID;
    }
    public String getID(){
        return ID;
    }

    //First Name
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public String getFirstName(){
        return firstName;
    }

    //Last Name
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    public String getLastName(){
        return lastName;
    }

    //Highest Level Comp Sci class taken
    public void setCompSciNum(int compSciNum){
        this.compSciNum = compSciNum;
        totalScore += compSciNum;
    }
    public int getCompSciNum(){
        return compSciNum;
    }

    //Familiar Machine Learning
    public void setFamilarML(int familiarML){
        this.familiarML = familiarML;
        totalScore += familiarML;
    }
    public int getFamiliarML(){
        return familiarML;
    }

    //Experience with GIS
    public void setExpGIS(int expGIS){
        this.expGIS = expGIS;
        totalScore += expGIS;
    }
    public int getExpGIS(){
        return expGIS;
    }

    //Experience with AWS
    public void setExpAWS(int expAWS){
        this.expAWS = expAWS;
        totalScore += expAWS;
    }
    public int getExpAWS(){
        return expAWS;
    }

    //Student Score
    public int getTotalScore(){
        return totalScore;
    }

    
}
