/**
 * Class contains constructor and getters
 * for SportEquipment's class fields
 */
public class SportEquipment {
  private Category category;
  private String title;
  private int price;

  /**
   * constructor of class SportEquipment
   *
   * @param category - category of sport equipment
   * @param title    - title of sport equipment
   * @param price    - prise of sport equipment
   */
  public SportEquipment(Category category, String title, int price) {
    this.category = category;
    this.title = title;
    this.price = price;
  }

  /**
   * getter for category
   *
   * @return category
   */
  public String getCategory() {
    String categoryString = category.getCategory();
    return categoryString;
  }

  /**
   * getter for title
   *
   * @return title
   */
  public String getTitle() {
    return title;
  }

  /**
   * getter for price
   *
   * @return price
   */
  public int getPrice() {
    return price;
  }
}