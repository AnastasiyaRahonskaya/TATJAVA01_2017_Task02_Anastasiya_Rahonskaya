import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.nio.file.Path;


/**
 * Class is for reading given txt file
 */
public class FileReader {
  private final String PATH = ".\\data.txt";

  /**
   * method reads file
   *
   * @param goodsList - available goods' list
   * @return available goods' list
   */
  public ArrayList<String> readFile(ArrayList<String> goodsList) {
    try {
      Path path = Paths.get(PATH);
      BufferedReader bufferedReader = Files.newBufferedReader(path);
      String line;
      while ((line = bufferedReader.readLine()) != null) {
        goodsList.add(line);
      }
      bufferedReader.close();
    } catch (Exception e) {
      System.out.println("Fail in file reader!");
    }
    return goodsList;
  }
}