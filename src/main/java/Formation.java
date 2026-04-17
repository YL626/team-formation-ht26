import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
public class Formation {

    private static String inputFile;


    private static void intakeInputInfo(String filename) throws IOException{
        Reader inputReader = new FileReader(filename);
        Iterable<CSVRecord> entries = CSVFormat.DEFAULT.parse(inputReader);
        for (CSVRecord entry: entries){
        }
        inputReader.close();
    } 

    private static void formationRunner(String[] args) throws FileNotFoundException, IOException{
        inputFile = args[0];

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
