package Inventory.controllers;

import Inventory.models.Product;
import Inventory.services.DBHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ArrayList;

public class InventoryHomeController {


    @FXML
    private Button productsButton;


    @FXML
    private Button categoriesButton;

    @FXML
    private Button homeButton;

    @FXML
    private Button signOutButton;

    @FXML
    private TableView<Product> lowStockTable;

    @FXML
    private TableColumn<?,?> lowStockNameCol;

    @FXML
    private TableColumn<?,?> lowStockQuantityCol;

    @FXML
    private Label usernameDisplay;

    private ObservableList<Product> lowStockProdList = FXCollections.observableArrayList();


    private DBHandler handler = new DBHandler();

    public void initData() {
        updateLowStockTable();
    }

    public void updateLowStockTable() {

        try {
            lowStockNameCol = new TableColumn<Product, String>("Product Name");
            lowStockQuantityCol = new TableColumn<>("Quantity in Stock");

            ArrayList<Product> arrayList = handler.getProductsWithLowStock();
            lowStockProdList = FXCollections.observableArrayList(arrayList);

            lowStockTable.setItems(lowStockProdList);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void changeToProductScene(ActionEvent event) {

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

    public void signOutButtonPressed(ActionEvent event) {

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




}