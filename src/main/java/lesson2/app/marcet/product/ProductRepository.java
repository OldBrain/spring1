package lesson2.app.marcet.product;

import lesson2.app.marcet.product.Product;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ProductRepository {
  Product findById(Long id);

  List<Product> findAll();
}
