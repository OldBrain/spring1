package lesson2.app.marcet.cart;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CartService {

  public void grateCart(String username, List<Long> itemsIds) {
    Cart cart = new Cart();
    cart.insetProduct(itemsIds);
    grateOrder(username, itemsIds);
    grateOrder(username, cart.getCartList());
    System.out.println(cart.toString());
  }

  private void grateOrder(String username, List<Long> itemsIds) {
    //User user = userService.findByUsername(username);
    // order.grateOrder(user,cart.getCartList)
  }
}
