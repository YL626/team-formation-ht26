import java.util.List;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Team {

    private int totalTeamSkillScore = 0;

    private List<Student> members = new ArrayList<>();

    public void Team(Student leader) {
        totalTeamSkillScore += leader.getTotalScore();
        members.add(leader);
    }

    public void addTeamMember(Student member){
        totalTeamSkillScore += member.getTotalScore();
        members.add(member);
    }

    public void showTeamMembers(){
        Array[String] membersOfTeam = new Array[5];
        for (Student member : members){
            membersOfTeam.add(member.getFirstName() + " " + member.getLastName() + " " + member.get);
        }
        Arrays.toString(membersOfTeam);
    }
    
}
