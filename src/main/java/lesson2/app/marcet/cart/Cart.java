package lesson2.app.marcet.cart;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Cart {
  private  List<Long> cartList = new ArrayList();

  public void insetProduct(List<Long> cartIds) {
    cartList = cartIds;
  }
  public void deleteProduct(long id) {
    cartList.remove(id);
  }
  public List<Long> getCartList() {
    return cartList;
  }

  @Override
  public String toString() {
    return "Корзина сформирована{" +
        "ProductID=" + cartList +
        '}';
  }
}
