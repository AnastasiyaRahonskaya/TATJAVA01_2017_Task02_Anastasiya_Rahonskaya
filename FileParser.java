/**
 * Class is for parsing given txt file
 */
public class FileParser {
  /**
   * method parsers category
   *
   * @param data - data from file
   * @return category
   */
  public Category parserCategory(String data) {
    Category category = new Category(data.split("\\s+")[0]);
    return category;
  }

  /**
   * method parsers title
   *
   * @param data - data from file
   * @return title
   */
  public String parserTitle(String data) {
    return data.split("\\s+")[1];
  }

  /**
   * method parsers price
   *
   * @param data - data from file
   * @return price
   */
  public int parserPrice(String data) {
    return Integer.parseInt(data.split("\\s+")[2]);
  }

  /**
   * method parsers quantity
   *
   * @param data - data from file
   * @return quantity
   */
  public int parserQuantity(String data) {
    return Integer.parseInt(data.split("\\s+")[3]);
  }
}