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

public class SideDishesController {
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
    void SideDishes(ActionEvent event) {
        try {
            URL url = Paths.get("./src/Inventory/views/SideDishFXML.fxml").toUri().toURL();

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
    void Fishball(ActionEvent event) {
        try {
            URL url = Paths.get("./src/Inventory/views/SideDish_Fishball.fxml").toUri().toURL();

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
    void FrenchFries(ActionEvent event) {
        try {
            URL url = Paths.get("./src/Inventory/views/SideDish_FrenchFries.fxml").toUri().toURL();

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
    void Kikiam(ActionEvent event) {
        try {
            URL url = Paths.get("./src/Inventory/views/SideDish_Kikiam.fxml").toUri().toURL();

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
    void KwekKwek(ActionEvent event) {
        try {
            URL url = Paths.get("./src/Inventory/views/SideDish_KwekKwek.fxml").toUri().toURL();

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
    void BeefShawarma(ActionEvent event) {
        try {
            URL url = Paths.get("./src/Inventory/views/SideDish_Shawarma.fxml").toUri().toURL();

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
