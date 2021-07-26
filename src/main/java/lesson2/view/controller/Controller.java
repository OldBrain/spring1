package lesson2.view.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.MultipleSelectionModel;
import lesson2.app.marcet.cart.CartService;
import lesson2.app.marcet.product.MemoryProductRepositoryImp;
import lesson2.app.marcet.product.Product;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;


public class Controller implements Initializable {

  private String SelectedProductFromCart;

  public void setContext(AnnotationConfigApplicationContext context) {
    this.context = context;
  }

  AnnotationConfigApplicationContext context;
  @FXML
  private ComboBox<String> productComboBox;
  @FXML
  private Button InitButton;
  @FXML
  private Button addButton;
  @FXML
  private Button deleteButton;
  @FXML
  private Button grateOrderButton;
  @FXML
  private ListView<String> cartListView;

  private String productItem;


  public Controller() {
  }

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    selectCartItem();
  }

  private void selectCartItem() {
    MultipleSelectionModel<String> cartSelectionModel = cartListView.getSelectionModel();
    cartSelectionModel.selectedItemProperty().
        addListener((changed, oldValue, newValue) -> SelectedProductFromCart = newValue);
  }

  public void initComboBox() {
    productComboBox.getItems().clear();
    for (Product pr : getAllProducts()) {
      productComboBox.getItems().add(pr.getId() + " | " + pr.getTitle() + " | " + pr.getPrice());
    }
    productComboBox.getSelectionModel().select(0);
  }

  private List<Product> getAllProducts() {
    MemoryProductRepositoryImp productRepository
        = context.getBean(MemoryProductRepositoryImp.class);
    List<Product> productList = productRepository.findAll();
    return productList;
  }

  public void selectProduct(ActionEvent actionEvent) {
    ComboBox<String> element = (ComboBox<String>) actionEvent.getSource();
    productItem = element.getSelectionModel().getSelectedItem();
  }

  @FXML
  public void pressButtonInitBox(ActionEvent actionEvent) {
    initComboBox();
  }

  public void pressButtonAddToCart(ActionEvent actionEvent) {
    cartListView.getItems().add(productItem);
    System.out.println(productItem);
  }

  public void deleteItemFromCart(ActionEvent actionEvent) {
    cartListView.getItems().removeAll(SelectedProductFromCart);
  }

  public void placeAnOrder(ActionEvent actionEvent) {
    CartService cartService = context.getBean(CartService.class);
    cartService.grateCart("User", getCartIds());
    cartListView.getItems().clear();
  }

  private List<Long> getCartIds() {
    List<Long> result = new ArrayList<>();
    for (String item : cartListView.getItems()) {
      result.add(Long.parseLong(item.split("|")[0]));
    }
    return result;
  }
}
