import java.util.List;
import java.util.ArrayList;

public class Team {

    private int totalTeamSkillScore = 0;

    private List<Student> members = new ArrayList<>();

    public void Team(Student leader) {
        totalTeamSkillScore += leader.getTotalScore();
        members.add(leader);
    }
    
}
