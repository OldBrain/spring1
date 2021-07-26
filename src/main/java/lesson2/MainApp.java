package lesson2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lesson2.view.controller.Controller;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp extends Application {
  AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigApp.class);

  @Override
  public void start(Stage primaryStage) throws Exception {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("/view.fxml"));
    Parent root = loader.load();
    Scene scene = new Scene(root, 800, 370);
    primaryStage.setScene(scene);
    primaryStage.show();
    Controller controller = loader.getController();
    controller.setContext(context);
  }
}
