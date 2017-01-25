import java.util.ArrayList;
import java.util.Map;

/**
 * Class contains methods
 * connected with rent
 */
public class RentUnit {
  private ArrayList<String> units = new ArrayList<>();

  /**
   * methods finds if an unit is the the shop
   *
   * @param titleRent - unit's title user wants to rent
   * @param goods     - goods in the shop
   * @return list of units in the shop
   */
  public ArrayList<String> findUnitInTheShop(String titleRent, Map<SportEquipment, Integer> goods) {
    for (Map.Entry<SportEquipment, Integer> entry : goods.entrySet()) {
      if (titleRent.equals(entry.getKey().getTitle())) {
        units.add(entry.getKey().getCategory() + " " + entry.getKey().getTitle() + " " + entry.getKey().getPrice());
      }
    }
    return units;
  }

  /**
   * method gets units user ranted
   *
   * @param rentedUnitsList - list of units' titles user wants to rent
   */
  public void getRentUnits(ArrayList<String> rentedUnitsList) {
    if (rentedUnitsList.size() == 0) {
      System.out.println("You are rented nothing.");
    }
    for (int i = 0; i < rentedUnitsList.size(); i++) {
      System.out.println(rentedUnitsList.get(i));
    }
  }

  /**
   * method checks if the capacity of the basket
   * allow user to add one more unit
   *
   * @param rentedUnitsList - list of units' titles user wants to rent
   * @return true if the capacity of the basket
   * allow user to add one more unit,
   * otherwise false
   */
  public boolean checkCapacityOfTheBasket(ArrayList<String> rentedUnitsList) {
    return rentedUnitsList.size() >= 3;
  }
}