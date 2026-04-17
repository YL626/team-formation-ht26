import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Team {

    private int totalTeamSkillScore = 0;
    private int teamSize = 0;
    private List<Student> members = new ArrayList<>();
    private int teamID;


    public void Team(Student leader, int teamID) {
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

    public void showTeamMembers(){
        String[] membersOfTeam = new String[5];
        for (int i = 0; i < teamSize; i++){
            membersOfTeam[i] = members.get(i).getFirstName() + " " + members.get(i).getLastName() + " " + members.get(i).getID();
        }
        Arrays.toString(membersOfTeam);
    }

    public int size(){
        return teamSize;
    }

    public int getTeamScore(){
        return totalTeamSkillScore;
    }
    
}
