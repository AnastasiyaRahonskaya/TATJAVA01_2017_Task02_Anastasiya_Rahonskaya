import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Class contains the information about the goods
 * at the beginning and in the end of rent and if
 * the item is available
 */
public class Shop {
  private Map<SportEquipment, Integer> goods;
  private ArrayList<String> goodsList;
  private FileReader fileReader;
  private FileParser fileParser;
  private Category category;
  private String title;
  private int price;
  private int quantity;


  /**
   * method gets information about the goods
   * in the shop from txt file
   *
   * @return goods in the shop
   */
  public Map<SportEquipment, Integer> getGoodsFromFile() {
    goods = new HashMap<>();
    goodsList = new ArrayList<>();
    fileReader = new FileReader();
    fileReader.readFile(goodsList);
    fileParser = new FileParser();

    for (int i = 0; i < goodsList.size(); i++) {
      category = fileParser.parserCategory(goodsList.get(i));
      title = fileParser.parserTitle(goodsList.get(i));
      price = fileParser.parserPrice(goodsList.get(i));
      quantity = fileParser.parserQuantity(goodsList.get(i));
      goods.put(new SportEquipment(category, title, price), quantity);
    }
    return goods;
  }

  /**
   * methods gets the information about
   * the goods before rent
   *
   * @param goods - goods in the shop
   */
  public void getInformationAboutTheGoodsBeforeRent(Map<SportEquipment, Integer> goods) {
    System.out.println("Goods are available:");
    for (Map.Entry<SportEquipment, Integer> entry : goods.entrySet()) {
      System.out.println(entry.getKey().getCategory() + " " + entry.getKey().getTitle() + " " + entry.getKey().getPrice() + " " + entry.getValue());
    }
  }

  /**
   * methods gets the information about
   * the goods after rent
   *
   * @param rentUnitList - list of units' titles user wants to rent
   */
  public void getInformationAboutTheGoodsAfterRent(ArrayList<String> rentUnitList) {
    for (Map.Entry<SportEquipment, Integer> entry : goods.entrySet()) {
      int quantityLeft = entry.getValue();
      for (int i = 0; i < rentUnitList.size(); i++) {
        if (rentUnitList.get(i).equals(entry.getKey().getTitle())) {
          quantityLeft--;
        }
      }
      System.out.println(entry.getKey().getCategory() + " " + entry.getKey().getTitle() + " " + entry.getKey().getPrice() + " " + quantityLeft);
    }
  }

  /**
   * method shows if unit the user wants
   * to rent is available
   *
   * @param titleRent - unit's title user wants to rent
   */
  public void isAvailable(String titleRent) {
    String s = "Sorry! The item you want isn't available. Choose something else.";
    for (Map.Entry<SportEquipment, Integer> entry : goods.entrySet()) {
      if (titleRent.equals(entry.getKey().getTitle())) {
        s = "The item you want is available and added to your basket.";
      }
    }
    System.out.println(s);
  }
}