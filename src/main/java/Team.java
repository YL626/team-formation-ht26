import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Team {

    private int totalTeamSkillScore = 0;
    private int teamSize = 0;
    private List<Student> members = new ArrayList<>();
    private int teamID;


    public Team(Student leader, int teamID) {
        totalTeamSkillScore += leader.getTotalScore();
        this.teamID = teamID;
        members.add(leader);
        teamSize++;
    }

    public void addTeamMember(Student member){
        totalTeamSkillScore += member.getTotalScore();
        members.add(member);
        teamSize++;
    }

    public String showTeamMemberswithID(){
        String[] membersOfTeam = new String[5];
        for (int i = 0; i < teamSize; i++){
            membersOfTeam[i] = members.get(i).getFirstName() + " " + members.get(i).getLastName() + " " + members.get(i).getID();
        }
        return Arrays.toString(membersOfTeam);
    }

    public String teamMembersArray() {
        ArrayList<String> membersOfTeam = new ArrayList<>();
        for (int i = 0; i < teamSize; i++) {
            membersOfTeam.add(
                members.get(i).getFirstName() + " "
                + members.get(i).getLastName()
            );
        }
        return membersOfTeam.toString();
    }

    public int size(){
        return teamSize;
    }

    public int getTeamScore(){
        return totalTeamSkillScore;
    }

    public boolean hasSpace(){
        return teamSize < 4;
    }

    public boolean hasLeftoverSpace(){
        return teamSize < 5;
    }
    
}
