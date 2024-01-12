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

public class MerchandiseController {
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
    void Merchandise(ActionEvent event) {
        try {
            URL url = Paths.get("./src/Inventory/views/MerchandiseFXML.fxml").toUri().toURL();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(url);
            Parent TransactionsViewParent = loader.load();
            Scene transactionsScene = new Scene(TransactionsViewParent);


            // get stage info
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
    void Shirt(ActionEvent event) {
        try {
            URL url = Paths.get("./src/Inventory/views/Merchandise_Shirt.fxml").toUri().toURL();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(url);
            Parent TransactionsViewParent = loader.load();
            Scene transactionsScene = new Scene(TransactionsViewParent);


            // get stage info
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
    void Bag(ActionEvent event) {
        try {
            URL url = Paths.get("./src/Inventory/views/Merchandise_Bag.fxml").toUri().toURL();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(url);
            Parent TransactionsViewParent = loader.load();
            Scene transactionsScene = new Scene(TransactionsViewParent);


            // get stage info
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

            // access the controller of Products view to use controller to pass in user to initData()
            ProductsViewController controller = loader.getController();
            controller.initData();

            // get stage info
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

            // access the controller of Products view to use controller to pass in user to initData()
            //WelcomeController controller = loader.getController();

            // get stage info
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

            // access the controller of Products view to use controller to pass in user to initData()
            //MenuController controller = loader.getController();
            //controller.initData();

            // get stage info
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

            // access the controller of Products view to use controller to pass in user to initData()
            InventoryHomeController controller = loader.getController();
            controller.initData();

            // get stage info
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
