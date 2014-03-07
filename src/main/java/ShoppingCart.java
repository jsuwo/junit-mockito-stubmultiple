import java.util.List;

public class ShoppingCart {

  private List<Product> products;

  public ShoppingCart(List<Product> products) {
    this.products = products;
  }

  public double getSubTotal() {

    double total = 0;

    for (Product p : products) {
      total += p.getPrice();  
    }

    return total;

  }

}
