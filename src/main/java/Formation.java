import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

public class Formation {

    private static int numOfTeams;

    private static int enrolledStudents = 0;
    private static int maxStudents = 108;

    private static ArrayList<Team> allTeams = new ArrayList<>();
    private static PriorityQueue<Team> pqTeams = new PriorityQueue<>(Comparator.comparingInt(Team::getTeamScore));

    private static ArrayList<Student> allStudents = new ArrayList<>();
    private static ArrayList<Student> leftoverStudents = new ArrayList<>();


    public static boolean isReserved(String userID){
        switch (userID) {
            case "id1":
                return true;
            case "id2":
                return true;
            case "id3": 
                return true;
            case "id4":
                return true;
            case "id5":
                return true;
            case "id6": 
                return true;
            case "id7":
                return true;
            case "id8":
                return true;
            case "id9": 
                return true;
            case "id10":
                return true;
            case "id11":
                return true;
            case "id12": 
                return true;
            case "id13":
                return true;
            case "id14":
                return true;
            case "id15": 
                return true;
            case "id16":
                return true;
            case "id17":
                return true;
            case "id18": 
                return true;
            case "id19":
                return true;
            case "id20":
                return true;
            case "id21": 
                return true;
            case "id22":
                return true;
            case "id23":
                return true;
            case "id24": 
                return true;
            default:
                break;
        }
        return false;
    }

    private static void intakeReservedStudentsInfo(String filename) throws IOException{
        int count = 0;
        Reader inputReader = new FileReader(filename);
        Iterable<CSVRecord> entries = CSVFormat.DEFAULT.parse(inputReader);
        for (CSVRecord entry : entries) {
            if (count == 0) {
                count++;
                continue;
            }
            if (isReserved(entry.get(8))){
                entryReader(entry);
            }
        }
    }

    private static void intakeInputInfo(String filename) throws IOException {
        int count = 0;
        Reader inputReader = new FileReader(filename);
        Iterable<CSVRecord> entries = CSVFormat.DEFAULT.parse(inputReader);
        for (CSVRecord entry : entries) {
            if (count == 0) {
                count++;
                continue;
            }
            if (isReserved(entry.get(8))){
                continue;
            }
            if (entry.get(6).isEmpty()) {
                continue;
            }
            if (enrolledStudents<maxStudents){
                entryReader(entry);
            }

        }
        inputReader.close();
    }

    private static void findNumOfTeams() {
        numOfTeams = enrolledStudents / 4;
        int remaining = enrolledStudents % 4;
        switch (remaining) {
            case 0 -> {
                System.out.println("Tremendous, no leftover students!");
                System.out.println("Total teams: " + numOfTeams);
            }
            case 3 -> {
                numOfTeams++;
                System.out.println("One team of 3 must be made");
                System.out.println("Total teams: " + numOfTeams);
            }
            default -> {
                System.out.println("Warning: " + remaining + " students are leftover, watch for uneven teams.");
                System.out.println("Total teams: " + numOfTeams);
            }
        }
    }

    private static int compSciLevelScore(String compSciLevel) {
        Character level = compSciLevel.charAt(0);
        return Character.isDigit(level) ? Character.getNumericValue(level) : 0;
    }

    private static int mlFamiliarityScore(String mlFamiliarity) {
        Character familiarity = mlFamiliarity.charAt(0);
        return switch (familiarity) {
            case 'A' -> 3;
            case 'I' -> 2;
            case 'B' -> 1;
            default -> 0;
        };
    }

    private static int gisScore(String xpGIS) {
        Character responseSignal = xpGIS.charAt(0);
        return responseSignal.equals('Y') ? 3 : 0;
    }

    private static int awsScore(String xpAWS) {
        Character responseSignal = xpAWS.charAt(0);
        return responseSignal.equals('Y') ? 2 : 0;
    }

    private static void entryReader(CSVRecord entry) {
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
        enrolledStudents++;
    }

    private static void sortStudentsLow2High() {
        allStudents.sort(Comparator.comparingInt(Student::getTotalScore));
    }

    private static void makeTeamswithLeaders() {
        for (int i = 0; i < numOfTeams; i++) {
            int lastIndex = allStudents.size() - 1;
            Student leader = allStudents.get(lastIndex);
            allStudents.remove(lastIndex);
            Team newTeam = new Team(leader, i + 1);
            allTeams.add(newTeam);
            pqTeams.add(newTeam);
        }
    }

    private static void fillTeams() {
        for (int i = allStudents.size() - 1; i >= 0; i--) {
            if (pqTeams.isEmpty()) {
                leftoverStudents.add(allStudents.get(i));
                continue;
            }

            Team weakestTeam = pqTeams.poll();
            weakestTeam.addTeamMember(allStudents.get(i));

            if (weakestTeam.hasSpace()) {
                pqTeams.add(weakestTeam);
            }
        }
    }

    private static void spreadLeftovers() {
        PriorityQueue<Team> weakestTeams = new PriorityQueue<>(Comparator.comparingInt(Team::getTeamScore));
        weakestTeams.addAll(allTeams);

        for (Student leftover : leftoverStudents) {
            Team weakestTeam = weakestTeams.poll();
            weakestTeam.addTeamMember(leftover);
            weakestTeams.add(weakestTeam);
        }
    }

    private static void exportPublicCSV() throws IOException {
        try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("public_teams.csv")))) {
            int count = 1;
            for (Team team : allTeams) {
                pw.println("Team " + count);
                pw.println(team.teamMembersArray());
                count++;
            }
        }
    }

    private static void exportOrganizerCSV() throws IOException {
        try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("teams_with_personal_data.csv")))) {
            int count = 1;
            for (Team team : allTeams) {
                pw.println("Team " + count);
                pw.println(team.showTeamMemberswithID());
                pw.println("Skill Score: " + team.getTeamScore());
                count++;
            }
        }
    }

    private static void formationRunner(String[] args) throws FileNotFoundException, IOException {
        String inputFile = args[0];
        intakeReservedStudentsInfo(inputFile);
        intakeInputInfo(inputFile);
        sortStudentsLow2High();
        findNumOfTeams();
        makeTeamswithLeaders();
        fillTeams();
        spreadLeftovers();
        exportPublicCSV();
        exportOrganizerCSV();
    }

    public static void main(String[] args) {
        try {
            formationRunner(args);
        } catch (FileNotFoundException noFile) {
            System.err.println("Error: " + noFile.getMessage());
        } catch (IOException ioException) {
            System.err.println("Error: " + ioException.getMessage());
        } catch (NumberFormatException wrongNum) {
            System.err.println("Error: " + wrongNum.getMessage());
        } catch (IllegalArgumentException wrongArg) {
            System.err.println("Error: " + wrongArg.getMessage());
        }
    }

}
