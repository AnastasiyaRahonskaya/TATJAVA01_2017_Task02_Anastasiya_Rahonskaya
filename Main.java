import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

/**
 * Start point of the program
 * Program represents rental sporting goods store.
 * User is allowed to put <= three units out of
 * available in the shop.
 */
public class Main {
  /**
   * User enters title of sport equipment he wants to rent.
   * If such unit is available program adds it to the user's basket,
   * otherwise suitable message appears. Than program offers the user
   * to enter another unit.
   * Available capacity of the basket is three units.
   * After user rented all units he wanted, program shows
   * the content of user's basket and information about the units
   * that are available after user did rent.
   * All units are presented in txt file
   *
   * @param args - cmd argument
   */
  public static void main(String[] args) {
    Shop shop = new Shop();
    RentUnit rentUnit = new RentUnit();
    Map<SportEquipment, Integer> goods;
    ArrayList<String> units;
    ArrayList<String> rentUnitList = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    String usersAnswer, titleRent;
    int iter = 1;
    goods = shop.getGoodsFromFile();
    shop.getInformationAboutTheGoodsBeforeRent(goods);
    do {
      System.out.println("Please, enter title of sport equipment you want to rent:");
      titleRent = scanner.nextLine();
      rentUnitList.add(titleRent);
      shop.isAvailable(titleRent);
      units = rentUnit.findUnitInTheShop(titleRent, goods);
      System.out.println("Would you like to rent one more item? y/n");
      usersAnswer = scanner.nextLine();
      if (rentUnit.checkCapacityOfTheBasket(units)) {
        System.out.println("Sorry, your basket's capacity reached the limit.");
        break;
      }
      iter++;
    } while (usersAnswer.equals("y"));

    System.out.println("\nGoods you are rented:");
    rentUnit.getRentUnits(units);
    System.out.println("\nGoods are available:");
    shop.getInformationAboutTheGoodsAfterRent(rentUnitList);
  }
}