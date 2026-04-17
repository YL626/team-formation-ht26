import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;


public class Formation {

    private static String inputFile;
    private static int totalTeams;
    private static int totalStudents = 0;
    private static int maxStudents = 108;

    private static Team[] teams;
    private static ArrayList<Student> allStudents = new ArrayList<>();


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

    private static void findNumOfTeams(){

    }

    private static void studentSetup(){

    }

    private static void entryReader(CSVRecord entry){
        String studentID = entry.get(8).trim();
        String firstName = entry.get(1).trim();
        String lastName = entry.get(2).trim();
        String compSciLevel = entry.get(13).trim();
        String mlFamiliarity = entry.get(14).trim();
        String xpGIS = entry.get(15).trim();
        String xpAWS = entry.get(16).trim();



    }


    private static void formationRunner(String[] args) throws FileNotFoundException, IOException{
        String inputFile = args[0];
        intakeInputInfo(inputFile);
        //intake and create students
        
    }


    public static void main(String[] args){
        try {
            formationRunner(args);
        } catch (FileNotFoundException noFile){
            System.err.println("Error: " + noFile.getMessage());
            return;
        } catch (IOException ioException){
            System.err.println("Error: " + ioException.getMessage());
            return;
        } catch (NumberFormatException wrongNum){
            System.err.println("Error: " + wrongNum.getMessage());
            return;
        } catch (IllegalArgumentException wrongArg){
            System.err.println("Error: " + wrongArg.getMessage());
            return;
        }
    }
    
}
