package lesson2.app.marcet.product;

public class Product {
  private Long id;
  private String title;
  private float price;


  public Product(Long id, String title, float price) {
    this.id = id;
    this.title = title;
    this.price = price;
  }

  public Long getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public float getPrice() {
    return price;
  }

}
