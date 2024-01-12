package Inventory.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.paint.Paint;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import Inventory.models.Product;
import Inventory.services.DBConnection;
import Inventory.services.DBHandler;
import Inventory.services.ParseNumbers;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class ProductsViewController implements Initializable {

    private ObservableList<Product> allItems = FXCollections.observableArrayList();


    private ObservableList<Product> all = FXCollections.observableArrayList();;

    @FXML
    private TableColumn<?, ?> BrandColumn;

    @FXML
    private TableColumn<?, ?> CategoryColumn;

    @FXML
    private TableColumn<?, ?> DescriptionColumn;

    @FXML
    private TableColumn<?, ?> QuantityColumn;

    @FXML
    private TableColumn<?, ?> TypeColumn;

    @FXML
    private TableColumn<?, ?> UnitsColumn;

    @FXML
    private RadioButton addRadioBtn;

    @FXML
    private RadioButton bulkRadioBtn;

    @FXML
    private Label buttonStatus;

    @FXML
    private Button categoriesButton;

    @FXML
    private RadioButton deleteRadioBtn;

    @FXML
    private RadioButton usageRadioBtn;

    @FXML
    private RadioButton findRadioBtn;

    @FXML
    private Button homeButton;

    @FXML
    private Label label;

    @FXML
    private Label label1;

    @FXML
    private Label label11;

    @FXML
    private TextField productDescTextField;
    @FXML
    private TextField unitsTextField;

    @FXML
    private TextField productBrandTextField;

    @FXML
    private TextField productCategoryTextField;

    @FXML
    private TableColumn<?, ?> productNameColumn;

    @FXML
    private TextField productNameTextField;

    @FXML
    private TextField productTypeTextField;

    @FXML
    private Button productsButton;

    @FXML
    private TableView<Product> productsTable;

    @FXML
    private TextField quantityTextField;

    @FXML
    private TextField CSVTextField;

    @FXML
    private Button refreshButton;

    @FXML
    private Button signOutButton;

    @FXML
    private Button submitButton;

    @FXML
    private Label title;

    @FXML
    private TableColumn<?, ?> upcColumn;

    @FXML
    private TextField upcTextField;

    @FXML ToggleGroup toggleGroup;

    private ObservableList<Product> productsList = FXCollections.observableArrayList();

    private DBHandler handler = new DBHandler();
    private static Set<Integer> generatedSKUNumbers = new HashSet<>();



    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        updateTable();
    }

    public void initData() {
        // UPC column
        upcColumn = new TableColumn<Product, String>("UPC");
        upcColumn.setMinWidth(200);

        // product name column
        productNameColumn = new TableColumn<>("Product Name");
        productNameColumn.setMinWidth(200);

        // product category column
        CategoryColumn = new TableColumn<>("Category");
        CategoryColumn.setMinWidth(200);

        // product brand column
        BrandColumn = new TableColumn<>("Brand");
        BrandColumn.setMinWidth(150);


        // product description column
        DescriptionColumn = new TableColumn<>("Description");
        DescriptionColumn.setMinWidth(200);

        // product type column
        TypeColumn = new TableColumn<>("Type");
        TypeColumn.setMinWidth(200);

        // in stock quantity column
        QuantityColumn = new TableColumn<>("Stock Quantity");
        QuantityColumn.setMinWidth(100);

        // Units column
        UnitsColumn = new TableColumn<>("Units");
        UnitsColumn.setMinWidth(200);
    }


    public void updateTable() {

        try {

            // load the data from database into an observableList
            ArrayList<Product> arrayList = handler.getAllProducts();
            productsList = FXCollections.observableArrayList(arrayList);

            // add the items to the JavaFX table
            productsTable.setItems(productsList);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void radioButtonChanged() {
        try {

            buttonStatus.setText("");


            if (this.toggleGroup.getSelectedToggle() == null) {
                buttonStatus.setText("*Please select either Usage, Add, or Delete*");
                buttonStatus.setTextFill(Paint.valueOf("red"));
                return;
            }

            if (this.toggleGroup.getSelectedToggle().equals(this.addRadioBtn)) {
                upcTextField.setVisible(true);
                upcTextField.setManaged(true);
                productNameTextField.setManaged(true);
                productNameTextField.setVisible(true);
                productCategoryTextField.setVisible(true);
                productCategoryTextField.setManaged(true);
                productTypeTextField.setVisible(true);
                productTypeTextField.setManaged(true);
                productBrandTextField.setVisible(true);
                productBrandTextField.setManaged(true);
                productDescTextField.setVisible(true);
                productDescTextField.setManaged(true);
                quantityTextField.setVisible(true);
                quantityTextField.setManaged(true);
                unitsTextField.setVisible(true);
                unitsTextField.setManaged(true);
                CSVTextField.setVisible(false);
                CSVTextField.setManaged(false);

                submitButton.setText("Add Product");
            }
            else if (this.toggleGroup.getSelectedToggle().equals(this.deleteRadioBtn)) {
                upcTextField.setVisible(true);
                upcTextField.setManaged(true);
                productNameTextField.setManaged(true);
                productNameTextField.setVisible(true);
                productCategoryTextField.setVisible(false);
                productCategoryTextField.setManaged(false);
                productTypeTextField.setVisible(false);
                productTypeTextField.setManaged(false);
                productBrandTextField.setVisible(false);
                productBrandTextField.setManaged(false);
                quantityTextField.setVisible(false);
                quantityTextField.setManaged(false);
                productDescTextField.setVisible(false);
                productDescTextField.setManaged(false);
                unitsTextField.setVisible(false);
                unitsTextField.setManaged(false);
                CSVTextField.setVisible(false);
                CSVTextField.setManaged(false);

                submitButton.setText("Delete Product");
            } else if (this.toggleGroup.getSelectedToggle().equals(this.usageRadioBtn)) {
                upcTextField.setVisible(false);
                upcTextField.setManaged(false);
                productNameTextField.setManaged(true);
                productNameTextField.setVisible(true);
                productCategoryTextField.setVisible(false);
                productCategoryTextField.setManaged(false);
                productTypeTextField.setVisible(false);
                productTypeTextField.setManaged(false);
                productBrandTextField.setVisible(false);
                productBrandTextField.setManaged(false);
                quantityTextField.setVisible(true);
                quantityTextField.setManaged(true);
                productDescTextField.setVisible(false);
                productDescTextField.setManaged(false);
                unitsTextField.setVisible(false);
                unitsTextField.setManaged(false);
                CSVTextField.setVisible(false);
                CSVTextField.setManaged(false);

                submitButton.setText("Add Usage");
            } else if (this.toggleGroup.getSelectedToggle().equals(this.bulkRadioBtn)) {
                upcTextField.setVisible(false);
                upcTextField.setManaged(false);
                productNameTextField.setManaged(false);
                productNameTextField.setVisible(false);
                productCategoryTextField.setVisible(false);
                productCategoryTextField.setManaged(false);
                productTypeTextField.setVisible(false);
                productTypeTextField.setManaged(false);
                productBrandTextField.setVisible(false);
                productBrandTextField.setManaged(false);
                quantityTextField.setVisible(false);
                quantityTextField.setManaged(false);
                productDescTextField.setVisible(false);
                productDescTextField.setManaged(false);
                unitsTextField.setVisible(false);
                unitsTextField.setManaged(false);
                CSVTextField.setVisible(true);
                CSVTextField.setManaged(true);

                submitButton.setText("Bulk Add");
            } else if (this.toggleGroup.getSelectedToggle().equals(this.findRadioBtn)) {
                upcTextField.setVisible(true);
                upcTextField.setManaged(true);
                productNameTextField.setManaged(true);
                productNameTextField.setVisible(true);
                productCategoryTextField.setVisible(true);
                productCategoryTextField.setManaged(true);
                productTypeTextField.setVisible(false);
                productTypeTextField.setManaged(false);
                productBrandTextField.setVisible(false);
                productBrandTextField.setManaged(false);
                quantityTextField.setVisible(false);
                quantityTextField.setManaged(false);
                productDescTextField.setVisible(false);
                productDescTextField.setManaged(false);
                unitsTextField.setVisible(false);
                unitsTextField.setManaged(false);
                CSVTextField.setVisible(false);
                CSVTextField.setManaged(false);

                submitButton.setText("Find Product");
            }

        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void submitButtonClicked() {
        try {
            buttonStatus.setText("");
            if (this.toggleGroup.getSelectedToggle() == null) {
                buttonStatus.setText("*Please select either Usage, Add, or Delete*");
                buttonStatus.setTextFill(Paint.valueOf("red"));
                return;
            }
            else if (this.toggleGroup.getSelectedToggle().equals(this.addRadioBtn)) {
                addProduct();
            } else if (this.toggleGroup.getSelectedToggle().equals(this.deleteRadioBtn)) {
                deleteProduct();
            } else if (this.toggleGroup.getSelectedToggle().equals(this.usageRadioBtn)) {
                addUsage();
            } else if (this.toggleGroup.getSelectedToggle().equals(this.bulkRadioBtn)) {
                readCSV();
            } else if (this.toggleGroup.getSelectedToggle().equals(this.findRadioBtn)) {
                findProduct();
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void readCSV() {
        boolean success = false;
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choose a CSV file to import");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("CSV Files", "*.csv"));
        File selectedFile = fileChooser.showOpenDialog(null);
        BufferedReader br;
        Connection connection = DBConnection.getConnection();
        if (selectedFile != null) {
            try {
                String query = "INSERT INTO product(sku, productName, productCategory, productBrand, productProperty, productDesc, quantity, units) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
                String queryID = "select sku from product where productName = ? and productCategory=? and productBrand = ? and productProperty = ? and productDesc = ? and quantity = ? and units = ?";
                br = new BufferedReader(new FileReader(selectedFile));
                String text;
                if ((text = br.readLine()) != null) {
                    text.split(",");
                }
                while ((text = br.readLine()) != null) {
                    int orderNumber = 0;
                    String[] data = text.split(",");
                    StringBuilder items = new StringBuilder();
                    connection.setAutoCommit(false);
                    // put the order into the database
                    PreparedStatement preparedStatement = connection.prepareStatement(query);
                    preparedStatement.setString(1, data[0]);
                    preparedStatement.setString(2, data[1]);
                    preparedStatement.setString(3, data[2]);
                    preparedStatement.setString(4, data[3]);
                    preparedStatement.setString(5, data[4]);
                    preparedStatement.setString(6, data[5]);
                    preparedStatement.setString(7, data[6]);
                    preparedStatement.setString(8, data[7]);
                    preparedStatement.executeUpdate();
                    connection.commit();
                    PreparedStatement preparedStatement2 = connection.prepareStatement(queryID);
                    preparedStatement2.setString(1, data[0]);
                    preparedStatement2.setString(2, data[1]);
                    preparedStatement2.setString(3, data[2]);
                    preparedStatement2.setString(4, data[3]);
                    preparedStatement2.setString(5, data[4]);
                    preparedStatement2.setString(6, data[5]);
                    preparedStatement2.setString(7, data[6]);
                    preparedStatement.setString(8, data[7]);

                }
                success = true;
            } catch (IOException | SQLException e) {
                success = false;
                e.printStackTrace();
            }
        }
        if (success) {
            successReadMessage();
        }
    }


    public void writeCSV(ActionEvent event) {
        boolean success;

        try {

            PrintWriter pw = new PrintWriter(new File("inventory.csv"));
            StringBuilder sb = new StringBuilder();

            Connection connection = DBConnection.getConnection();
            ResultSet rs = null;
            String query = "select * from product";
            PreparedStatement ps = connection.prepareStatement(query);
            rs = ps.executeQuery();

            sb.append("sku,productName,productCategory,productBrand,productProperty,productDesc,quantity,units");
            sb.append("\r\n");
            while(rs.next()) {
                sb.append(rs.getString("sku"));
                sb.append(",");
                sb.append(rs.getString("productName"));
                sb.append(",");
                sb.append(rs.getString("productCategory"));
                sb.append(",");
                sb.append(rs.getString("productBrand"));
                sb.append(",");
                sb.append(rs.getString("productProperty"));
                sb.append(",");
                sb.append(rs.getString("productDesc"));
                sb.append(",");
                sb.append(rs.getInt("quantity"));
                sb.append(",");
                sb.append(rs.getString("units"));
                sb.append("\r\n");

            }

            pw.write(sb.toString());
            pw.close();
            success = true;
        }
        catch (IOException | SQLException e) {
            success = false;
            e.printStackTrace();
        }
        if (success) {
            successWriteMessage(event);
        }
    }

    private void successReadMessage() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("The data has been successfully added.");
        alert.showAndWait();
        update();
    }

    public void update() {

        Connection connection = DBConnection.getConnection();
        try {
            String query = "select sku, productName, productCategory, productBrand, productProperty, productDesc, quantity, units from product";
            PreparedStatement stmt = connection.prepareStatement(query);
            ResultSet results1 = stmt.executeQuery();
            while(results1.next()) {
                Product order = new Product(results1.getString(1), results1.getString(2), results1.getString(3), results1.getString(4),
                        results1.getString(5), results1.getString(6), results1.getInt(7), results1.getString(8));
                order.setSku(results1.getString("sku"));
                order.setQuantity(results1.getInt("quantity"));
                order.setProductName(results1.getString("productName"));
                order.setProductCategory(results1.getString("productCategory"));
                order.setProductBrand(results1.getString("productBrand"));
                order.setProductProperty(results1.getString("productProperty"));
                order.setProductDesc(results1.getString("productDesc"));
                order.setUnits(results1.getString("units"));
                allItems.add(order);
                all.add(order);
            }
            productsTable.setItems(allItems);
        } catch(SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    private void successWriteMessage(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("The data has been successfully exported.");
        alert.showAndWait();
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

    public void addUsage() {
        try {
            final String ACTION = "create";

            String quantityString = quantityTextField.getText();
            String Name = productNameTextField.getText();




            if (!ParseNumbers.isParsableInt(quantityString)) {
                buttonStatus.setText("*Make sure quantity are in number format*");
                buttonStatus.setTextFill(Paint.valueOf("red"));
                return;
            }

            int quantity = Integer.parseInt(quantityString);


            if (Name.isBlank()) {
                buttonStatus.setText("Please enter a product name to search for");
                buttonStatus.setTextFill(Paint.valueOf("red"));
                return;
            }


            ArrayList<Product> foundProducts = handler.findProductsByName(Name);


            if (foundProducts == null || foundProducts.size() == 0) {
                buttonStatus.setText("There were no products matching the search criteria");
                buttonStatus.setTextFill(Paint.valueOf("red"));
                return;
            }

            else if (foundProducts.size() != 1) {
                buttonStatus.setText("There were more than 1 product matching the search criteria");
                buttonStatus.setTextFill(Paint.valueOf("red"));
                return;
            }


            boolean confirmed = showPopup(foundProducts.get(0), "usage");


            if (!confirmed) {
                buttonStatus.setText("Product Usage was not updated");
                buttonStatus.setTextFill(Paint.valueOf("red"));
                return;
            }


            Product dbProduct = handler.getProductByName(Name);
            int inStock = dbProduct.getQuantity();

            if (quantity > inStock) {
                buttonStatus.setText("There is not enough stock to add that transaction");
                buttonStatus.setTextFill(Paint.valueOf("red"));
                return;
            }



            boolean adjusted = handler.subtractProductQuantity(quantity, dbProduct.getProductName());


            if (adjusted) {
                upcTextField.clear();
                productNameTextField.clear();
                productBrandTextField.clear();
                productCategoryTextField.clear();
                productTypeTextField.clear();
                quantityTextField.clear();
                productDescTextField.clear();
                unitsTextField.clear();

                buttonStatus.setText("Quantity usage successfully added");
                buttonStatus.setTextFill(Paint.valueOf("green"));

                updateTable();
            }

        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void findProduct() {
        ArrayList<Product> foundProducts = null;

        try {

            final String ACTION = "read";

            String productCatString = productCategoryTextField.getText();
            String upc = upcTextField.getText();
            String productName = productNameTextField.getText();

            if (productCatString.isBlank() && upc.isBlank() && productName.isBlank()) {
                buttonStatus.setText("Please enter a SKU, a product name or a product category to search for");
                buttonStatus.setTextFill(Paint.valueOf("red"));
                return;
            }

            foundProducts = handler.findProductsBySKUOrNameOrCat(productCatString, upc, productName);

            if (foundProducts != null) {
                productsList.clear();
                productsTable.getItems().clear();
                productsList = FXCollections.observableArrayList(foundProducts);

                productsTable.setItems(productsList);
            }

        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteProduct() {
        try {
            final String ACTION = "delete";

            String upc = upcTextField.getText();
            String productName = productNameTextField.getText();


            if (upc.isBlank() && productName.isBlank()) {
                buttonStatus.setText("Please enter an ID, a UPC or a product name to search for");
                buttonStatus.setTextFill(Paint.valueOf("red"));
                return;
            }

            if (productName.isBlank()) {
                ArrayList<Product> foundProducts = handler.findProductsBySKU(upc);


                if (foundProducts == null || foundProducts.size() == 0) {
                    buttonStatus.setText("There were no products matching the search criteria");
                    buttonStatus.setTextFill(Paint.valueOf("red"));
                    return;
                }

                else if (foundProducts.size() != 1) {
                    buttonStatus.setText("There were more than 1 product matching the search criteria");
                    buttonStatus.setTextFill(Paint.valueOf("red"));
                    return;
                }


                boolean confirmed = showPopup(foundProducts.get(0), "delete");


                if (!confirmed) {
                    buttonStatus.setText("Product was not deleted");
                    buttonStatus.setTextFill(Paint.valueOf("red"));
                    return;
                }

                boolean added = handler.deleteProductSKU(foundProducts.get(0).getSKU());;


                if (added) {
                    upcTextField.clear();
                    productNameTextField.clear();
                    productBrandTextField.clear();
                    productCategoryTextField.clear();
                    productTypeTextField.clear();
                    quantityTextField.clear();
                    productDescTextField.clear();
                    unitsTextField.clear();

                    buttonStatus.setText("Quantity successfully added");
                    buttonStatus.setTextFill(Paint.valueOf("blue"));

                    updateTable();
                }
                return;
            }


            ArrayList<Product> foundProducts = handler.findProductsByName(productName);


            if (foundProducts == null || foundProducts.size() == 0) {
                buttonStatus.setText("There were no products matching the search criteria");
                buttonStatus.setTextFill(Paint.valueOf("red"));
                return;
            }

            else if (foundProducts.size() != 1) {
                buttonStatus.setText("There were more than 1 product matching the search criteria");
                buttonStatus.setTextFill(Paint.valueOf("red"));
                return;
            }


            boolean confirmed = showPopup(foundProducts.get(0), "delete");


            if (!confirmed) {
                buttonStatus.setText("Product was not deleted");
                buttonStatus.setTextFill(Paint.valueOf("red"));
                return;
            }

            boolean added = handler.deleteProduct(foundProducts.get(0).getProductName());


            if (added) {
                upcTextField.clear();
                productNameTextField.clear();
                productBrandTextField.clear();
                productCategoryTextField.clear();
                productTypeTextField.clear();
                quantityTextField.clear();
                productDescTextField.clear();
                unitsTextField.clear();

                buttonStatus.setText("Product successfully deleted");
                buttonStatus.setTextFill(Paint.valueOf("blue"));

                updateTable();
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
    }


    public void addProduct() {
        try {
            final String ACTION = "create";

            String sku = upcTextField.getText();
            String productName = productNameTextField.getText();
            String productBrand = productBrandTextField.getText();
            String quantityString = quantityTextField.getText();
            String productCategory = productCategoryTextField.getText();
            String productProperty = productTypeTextField.getText();
            String productDesc = productDescTextField.getText();
            String units = unitsTextField.getText();


            if (!ParseNumbers.isParsableInt(quantityString)) {
                buttonStatus.setText("*Make sure quantity are in number format*");
                buttonStatus.setTextFill(Paint.valueOf("red"));
                return;
            }

            int quantity = Integer.parseInt(quantityString);


            if (productName.isBlank() && productCategory.isBlank() && !quantityString.isBlank()) {
                ArrayList<Product> foundProducts = handler.findProductsBySKU(sku);


                if (foundProducts == null || foundProducts.size() == 0) {
                    buttonStatus.setText("There were no products matching the search criteria");
                    buttonStatus.setTextFill(Paint.valueOf("red"));
                    return;
                }

                else if (foundProducts.size() != 1) {
                    buttonStatus.setText("There were more than 1 product matching the search criteria");
                    buttonStatus.setTextFill(Paint.valueOf("red"));
                    return;
                }


                boolean confirmed = showPopup(foundProducts.get(0), "add");


                if (!confirmed) {
                    buttonStatus.setText("Quantity was not added");
                    buttonStatus.setTextFill(Paint.valueOf("red"));
                    return;
                }

                boolean added = handler.addProductQuantity(quantity, foundProducts.get(0).getSKU());;


                if (added) {
                    upcTextField.clear();
                    productNameTextField.clear();
                    productBrandTextField.clear();
                    productCategoryTextField.clear();
                    productTypeTextField.clear();
                    quantityTextField.clear();
                    productDescTextField.clear();
                    unitsTextField.clear();

                    buttonStatus.setText("Quantity successfully added");
                    buttonStatus.setTextFill(Paint.valueOf("blue"));

                    updateTable();
                }
                return;
            } else if (sku.isBlank()) {

                String categoryInitials = "" + productCategory.toUpperCase().charAt(0) + productCategory.toUpperCase().charAt(productCategory.length() - 1);
                String itemInitials = "" + productName.toUpperCase().charAt(0) + productName.toUpperCase().charAt(productName.length() - 1);
                Random random = new Random();
                int randomNumber = random.nextInt(10000); // range from 0 to 9999
                while (generatedSKUNumbers.contains(randomNumber)) {
                    randomNumber = random.nextInt(10000);
                }
                generatedSKUNumbers.add(randomNumber);
                sku = categoryInitials + itemInitials + "-" + String.format("%04d", randomNumber);

                Product newProduct = new Product(sku, productName, productCategory, productBrand, productProperty, productDesc, quantity, units);


                boolean confirmed = showPopup(newProduct, "add");


                if (!confirmed) {
                    buttonStatus.setText("Product was not saved to the database");
                    buttonStatus.setTextFill(Paint.valueOf("red"));
                    return;
                }

                boolean added = handler.insertProduct(newProduct);


                if (added) {
                    upcTextField.clear();
                    productNameTextField.clear();
                    productBrandTextField.clear();
                    productCategoryTextField.clear();
                    productTypeTextField.clear();
                    quantityTextField.clear();
                    productDescTextField.clear();
                    unitsTextField.clear();
                    buttonStatus.setText("Product successfully added");
                    buttonStatus.setTextFill(Paint.valueOf("green"));
                }


                updateTable();
            } else {
                buttonStatus.setText("*Make sure to input quantity or only input sku if you want to restock an item*");
                buttonStatus.setTextFill(Paint.valueOf("red"));
                return;
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
    }


    private boolean showPopup(Product newProduct, String addOrDelete) {
        boolean confirmed = false;

        try {
            URL url = Paths.get("./src/Inventory/views/AddDeleteProducts.fxml").toUri().toURL();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(url);
            Parent productsViewParent = loader.load();
            Scene addProductScene = new Scene(productsViewParent);



            AddDeleteProductController controller = loader.getController();
            controller.initData(newProduct, addOrDelete);


            Stage window = new Stage();
            window.setScene(addProductScene);
            window.initModality(Modality.APPLICATION_MODAL);
            window.initOwner(submitButton.getScene().getWindow());
            window.showAndWait();
            confirmed = controller.getResult();

        }catch(Exception e) {
            e.printStackTrace();
        }
        return confirmed;
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


    public void changeToMenuScene(ActionEvent event) {

        try {
            URL url = Paths.get("./src/Inventory/views/MenuFXML.fxml").toUri().toURL();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(url);
            Parent MenuViewParent = loader.load();
            Scene MenuScene = new Scene(MenuViewParent);


            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

            window.setScene(MenuScene);
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

