import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;


public class Formation {

    private static int numOfTeams;

    private static int totalStudents = 0;
    private static int maxStudents = 108;

    private static ArrayList<Team> allTeams = new ArrayList<>();
    private static PriorityQueue<Team> pqTeams = new PriorityQueue<>(Comparator.comparingInt(Team::getTeamScore));

    private static ArrayList<Student> allStudents = new ArrayList<>();

    private static boolean teamWithThreeNeeded = false;


    private static void intakeInputInfo(String filename) throws IOException{
        Reader inputReader = new FileReader(filename);
        Iterable<CSVRecord> entries = CSVFormat.DEFAULT.parse(inputReader);
        for (CSVRecord entry: entries){
            if (entry.get(6).isEmpty()){
                continue;
            }
            entryReader(entry);
        }
        inputReader.close();
    } 



    //PLEASE REMEMBER TO FIX LEFTOVER STUDENT HANDLING
    private static void findNumOfTeams(){
        numOfTeams = totalStudents / 4;
        int remaining = totalStudents % 4;
        switch (remaining) {
            case 0 -> {
                System.out.println("Tremendous, no leftover students!");
                System.out.println(numOfTeams);
            }
            case 3 -> {
                numOfTeams++;
                teamWithThreeNeeded = true;
                System.out.println("One team of 3 must be made");
                System.out.println(numOfTeams);
            }
            default -> {
                System.out.println("Warning: " + remaining + " students are leftover, please assign them a team manually.");
                System.out.println(numOfTeams);
            }
        }
    }

    private static int compSciLevelScore(String compSciLevel){
        Character level = compSciLevel.charAt(0);
        return Character.isDigit(level) ? Character.getNumericValue(level) : 0;
    }

    private static int mlFamiliarityScore(String mlFamiliarity){
        Character familiarity = mlFamiliarity.charAt(0);
        return switch (familiarity) {
            case 'A' -> 3;
            case 'I' -> 2;
            case 'B' -> 1;
            default -> 0;
        };
    }

    private static int gisScore(String xpGIS){
        Character responseSignal = xpGIS.charAt(0);
        return responseSignal.equals('Y') ? 3 : 0;
    }

    private static int awsScore(String xpAWS){
        Character responseSignal = xpAWS.charAt(0);
        return responseSignal.equals('Y') ? 2 : 0;
    }

    private static void entryReader(CSVRecord entry){
        String studentID = entry.get(8).trim();
        String firstName = entry.get(1).trim();
        String lastName = entry.get(2).trim();
        String compSciLevel = entry.get(13).trim();
        String mlFamiliarity = entry.get(14).trim();
        String xpGIS = entry.get(15).trim();
        String xpAWS = entry.get(16).trim();

        Student currentStudent = new Student(studentID);

        currentStudent.setFirstName(firstName);
        currentStudent.setLastName(lastName);
        currentStudent.setCompSciNum(compSciLevelScore(compSciLevel));
        currentStudent.setFamilarML(mlFamiliarityScore(mlFamiliarity));
        currentStudent.setExpGIS(gisScore(xpGIS));
        currentStudent.setExpAWS(awsScore(xpAWS));
        allStudents.add(currentStudent);
        totalStudents++;
    }

    private static void sortStudentsHigh2Low(){
        allStudents.sort(Comparator.comparing(Student::getTotalScore).reversed());
    }

    private static void makeTeamswithLeaders(){
        for (int i = 0; i < numOfTeams; i++){
            Student leader = allStudents.get(0);
            allStudents.remove(0);
            Team newTeam = new Team(leader, i+1);
            allTeams.add(newTeam);
            pqTeams.add(newTeam);
        }
    }

    private static void fillTeams(){
        for (Student student : allStudents){
            Team highestTeam = pqTeams.poll();
            highestTeam.addTeamMember(student);
            if (highestTeam.hasSpace()){
                pqTeams.add(highestTeam);
            }
        }
    }

    private static void displayTeams(){
        int count = 1;
        for (Team team :allTeams){
            System.out.println("Team " + count);
            team.showTeamMembers();
            count++;
        }
    }


    private static void formationRunner(String[] args) throws FileNotFoundException, IOException{
        String inputFile = args[0];
        intakeInputInfo(inputFile);
        sortStudentsHigh2Low();
        findNumOfTeams();
        makeTeamswithLeaders();
        fillTeams();
        displayTeams();
    }


    public static void main(String[] args){
        try {
            formationRunner(args);
        } catch (FileNotFoundException noFile){
            System.err.println("Error: " + noFile.getMessage());
        } catch (IOException ioException){
            System.err.println("Error: " + ioException.getMessage());
        } catch (NumberFormatException wrongNum){
            System.err.println("Error: " + wrongNum.getMessage());
        } catch (IllegalArgumentException wrongArg){
            System.err.println("Error: " + wrongArg.getMessage());
        }
    }
    
}
