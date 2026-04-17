import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Team {

    private int totalTeamSkillScore = 0;
    private int teamSize = 0;
    private List<Student> members = new ArrayList<>();


    public void Team(Student leader) {
        totalTeamSkillScore += leader.getTotalScore();
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
