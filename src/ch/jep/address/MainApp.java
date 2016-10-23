package ch.jep.address;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
public class MainApp extends Application {
    private Stage primaryStage;
    private BorderPane rootLayout;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("AddressApp");
        initRootLayout();
        showPersonOverview();
    }

    public void initRootLayout() {
        rootLayout = (BorderPane) loadLayout("view/RootLayout.fxml");
        Scene scene = new Scene(rootLayout);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Object loadLayout(String resourceName) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource(resourceName));
            return loader.load();
        } catch (IOException e) {
            throw new RuntimeException("Error while loading a layout from resources: ", e);
        }
    }

    public void showPersonOverview() {
        AnchorPane personOverview = (AnchorPane) loadLayout("view/PersonOverview.fxml");
        rootLayout.setCenter(personOverview);
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
}