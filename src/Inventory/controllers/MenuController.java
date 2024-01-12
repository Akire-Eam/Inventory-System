package Inventory.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;

public class MenuController {
    @FXML
    private Button MenuButton;

    @FXML
    private Button homeButton;

    @FXML
    private Label label;

    @FXML
    private Label label1;

    @FXML
    private Label label11;

    @FXML
    private Button productsButton;

    @FXML
    private Button signOutButton;

    @FXML
    private Label title;

    @FXML
    void Appetizers(ActionEvent event) {
        try {
            URL url = Paths.get("./src/Inventory/views/AppetizersFXML.fxml").toUri().toURL();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(url);
            Parent TransactionsViewParent = loader.load();
            Scene transactionsScene = new Scene(TransactionsViewParent);

            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

            window.setScene(transactionsScene);
            window.show();

        }catch (MalformedURLException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }


    @FXML
    void Desserts(ActionEvent event) {
        try {
            URL url = Paths.get("./src/Inventory/views/DessertsFXML.fxml").toUri().toURL();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(url);
            Parent TransactionsViewParent = loader.load();
            Scene transactionsScene = new Scene(TransactionsViewParent);

            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

            window.setScene(transactionsScene);
            window.show();

        }catch (MalformedURLException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void Drinks(ActionEvent event) {
        try {
            URL url = Paths.get("./src/Inventory/views/DrinksFXML.fxml").toUri().toURL();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(url);
            Parent TransactionsViewParent = loader.load();
            Scene transactionsScene = new Scene(TransactionsViewParent);

            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

            window.setScene(transactionsScene);
            window.show();

        }catch (MalformedURLException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void MainCourse(ActionEvent event) {
        try {
            URL url = Paths.get("./src/Inventory/views/MainCourseFXML.fxml").toUri().toURL();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(url);
            Parent TransactionsViewParent = loader.load();
            Scene transactionsScene = new Scene(TransactionsViewParent);


            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

            window.setScene(transactionsScene);
            window.show();

        }catch (MalformedURLException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void Merchandise(ActionEvent event) {
        try {
            URL url = Paths.get("./src/Inventory/views/MerchandiseFXML.fxml").toUri().toURL();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(url);
            Parent TransactionsViewParent = loader.load();
            Scene transactionsScene = new Scene(TransactionsViewParent);

            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

            window.setScene(transactionsScene);
            window.show();

        }catch (MalformedURLException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void SideDishes(ActionEvent event) {
        try {
            URL url = Paths.get("./src/Inventory/views/SideDishFXML.fxml").toUri().toURL();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(url);
            Parent TransactionsViewParent = loader.load();
            Scene transactionsScene = new Scene(TransactionsViewParent);

            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

            window.setScene(transactionsScene);
            window.show();

        }catch (MalformedURLException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void changeToProductScene(ActionEvent event) {
        try {

            URL url = Paths.get("./src/Inventory/views/Product.fxml").toUri().toURL();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(url);
            Parent productsViewParent = loader.load();
            Scene productsScene = new Scene(productsViewParent);

            ProductsViewController controller = loader.getController();
            controller.initData();

            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

            window.setScene(productsScene);
            window.show();

        }catch (MalformedURLException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void signOutButtonPressed(ActionEvent event) {
        try {
            URL url = Paths.get("./src/Inventory/views/WelcomeInventoryFXML.fxml").toUri().toURL();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(url);
            Parent productViewParent = loader.load();
            Scene loginScene = new Scene(productViewParent);


            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

            window.setScene(loginScene);
            window.show();

        }catch (MalformedURLException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void changeToMenuScene(ActionEvent event) {
        try {
            URL url = Paths.get("./src/Inventory/views/MenuFXML.fxml").toUri().toURL();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(url);
            Parent TransactionsViewParent = loader.load();
            Scene transactionsScene = new Scene(TransactionsViewParent);


            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

            window.setScene(transactionsScene);
            window.show();

        }catch (MalformedURLException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void changeToHomeScreen(ActionEvent event) {

        try {
            URL url = Paths.get("./src/Inventory/views/HomeFXML.fxml").toUri().toURL();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(url);
            Parent loginViewParent = loader.load();
            Scene homeScene = new Scene(loginViewParent);

            InventoryHomeController controller = loader.getController();
            controller.initData();


            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

            window.setScene(homeScene);
            window.show();

        }catch (MalformedURLException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
