package Inventory.controllers;

import Inventory.models.Product;
import Inventory.services.DBHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class AddDeleteProductController {
        @FXML
        private Label brandLabel;

        @FXML
        private Label categoryLabel;

        @FXML
        private Label descLabel;

        @FXML
        private Label messageLabel;

        @FXML
        private Button noButton;

        @FXML
        private Label productNameLabel;

        @FXML
        private Label quantityLabel;

        @FXML
        private Label typeLabel;

        @FXML
        private Label unitsLabel;

        @FXML
        private Label upcLabel;

        @FXML
        private Button yesButton;

        private Product theProduct;

        private boolean yesOrNo;

        String addOrDelete;

        private DBHandler dbHandler = new DBHandler();

        public void initData(Product product, String addOrDeleteInput) {

                theProduct = product;
                yesOrNo = false;
                addOrDelete = addOrDeleteInput;

                upcLabel.setText(theProduct.getSKU());
                productNameLabel.setText(theProduct.getProductName());
                categoryLabel.setText(theProduct.getProductCategory());
                brandLabel.setText(theProduct.getProductBrand());
                descLabel.setText(theProduct.getProductDesc());
                typeLabel.setText(theProduct.getProductProperty());
                quantityLabel.setText(Integer.toString(theProduct.getQuantity()));
                unitsLabel.setText(theProduct.getUnits());


                if (addOrDelete.equals("add")) {
                        messageLabel.setText("Are you sure you want to add this new product to the database?");
                }
                else if (addOrDeleteInput.equals("delete")) {
                        messageLabel.setText("Are you sure you want to delete this product from the database?");
                } else if (addOrDeleteInput.equals("usage")) {
                        messageLabel.setText("Are you sure you want to add usage to this product from the database?");
                }
        }

        public boolean getResult() {
                return yesOrNo;
        }

        public void noButtonPressed(ActionEvent event) {
                yesOrNo = false;
                closeWindow(event);
        }

        public void yesButtonPressed(ActionEvent event) {
                yesOrNo = true;
                closeWindow(event);
        }



        public void closeWindow(ActionEvent event) {
                Stage stage = (Stage)noButton.getScene().getWindow();
                stage.close();
        }





}
