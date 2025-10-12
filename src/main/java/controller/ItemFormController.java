package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.dto.ItemDTO;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ItemFormController implements Initializable {
    ObservableList<ItemDTO> itemDTOS = FXCollections.observableArrayList(
            new ItemDTO("I006", "Rice (5kg)", "Grocery", 20, 1150.00),
            new ItemDTO("I007", "Sugar (1kg)", "Grocery", 35, 290.00),
            new ItemDTO("I008", "Dhal (1kg)", "Grocery", 25, 420.00),
            new ItemDTO("I009", "Coconut Oil (1L)", "Grocery", 15, 950.00),
            new ItemDTO("I010", "Wheat Flour (1kg)", "Grocery", 30, 280.00),
            new ItemDTO("I011", "Tea (100g)", "Beverages", 50, 150.00),
            new ItemDTO("I012", "Coffee (100g)", "Beverages", 40, 250.00),
            new ItemDTO("I013", "Milk (1L)", "Dairy", 60, 130.00)

    );

    @FXML
    private TableColumn<?, ?> colCategory;

    @FXML
    private TableColumn<?, ?> colDescription;

    @FXML
    private TableColumn<?, ?> colItemId;

    @FXML
    private TableColumn<?, ?> colPrice;

    @FXML
    private TableColumn<?, ?> colQty;

    @FXML
    private Label lblTitle;

    @FXML
    private AnchorPane mainContent;

    @FXML
    private TableView<ItemDTO> tblItems;

    @FXML
    private TextField txtCategory;

    @FXML
    private TextField txtDescription;

    @FXML
    private TextField txtItemId;

    @FXML
    private TextField txtPrice;

    @FXML
    private TextField txtQty;

    @FXML
    void btnAddItem(ActionEvent event) {
        String itemId = txtItemId.getText();
        String description = txtDescription.getText();
        String category = txtCategory.getText();
        int qty;
        double price;
        try {
            qty = Integer.parseInt(txtQty.getText());
            price = Double.parseDouble(txtPrice.getText());
        } catch (NumberFormatException e) {
            // Handle invalid number format
            System.out.println("Invalid number format for quantity or price.");
            return;
        }

        ItemDTO newItem = new ItemDTO(itemId, description, category, qty, price);
        itemDTOS.add(newItem);

    }

    @FXML
    void btnClearItem(ActionEvent event) {
        txtItemId.clear();
        txtDescription.clear();
        txtCategory.clear();
        txtQty.clear();
        txtPrice.clear();

    }

    @FXML
    void btnCustomerOnAction(ActionEvent event) {
        Stage stage = new Stage();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/custome_form.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.setTitle("DashBoard Customer Form");
        stage.show();

    }

    @FXML
    void btnDashboardOnAction(ActionEvent event) {
        Stage stage = (Stage) mainContent.getScene().getWindow();
        stage.close();

    }

    @FXML
    void btnDeleteItem(ActionEvent event) {
        ItemDTO selectedItem = tblItems.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            itemDTOS.remove(selectedItem);
            // Clear input fields after deletion
            txtItemId.clear();
            txtDescription.clear();
            txtCategory.clear();
            txtQty.clear();
            txtPrice.clear();
        }

    }

    @FXML
    void btnEmployeeOnAction(ActionEvent event) {

    }

    @FXML
    void btnItemOnAction(ActionEvent event) {
        Stage stage = new Stage();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/item_form_fxml.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.setTitle("Item Form");
        stage.show();

    }

    @FXML
    void btnLogoutOnAction(ActionEvent event) {
        Stage stage = new Stage();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/login_form_fxml.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.setTitle("Login Form");
        stage.show();

    }

    @FXML
    void btnSetiting(ActionEvent event) {

    }

    @FXML
    void btnSupplierOnAction(ActionEvent event) {
        Stage stage = new Stage();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/supplier_form_fxml.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.setTitle("Supplier Form");
        stage.show();

    }

    @FXML
    void btnUpdateItem(ActionEvent event) {
        ItemDTO selectedItem = tblItems.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            selectedItem.setItemCode(txtItemId.getText());
            selectedItem.setDescription(txtDescription.getText());
            selectedItem.setCategory(txtCategory.getText());
            try {
                selectedItem.setQtyOnHand(Integer.parseInt(txtQty.getText()));
                selectedItem.setUnitPrice(Double.parseDouble(txtPrice.getText()));
            } catch (NumberFormatException e) {
                // Handle invalid number format
                System.out.println("Invalid number format for quantity or price.");
                return;
            }
            tblItems.refresh();
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colItemId.setCellValueFactory(new PropertyValueFactory<>("itemCode"));
        colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        colCategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        colQty.setCellValueFactory(new PropertyValueFactory<>("qtyOnHand"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));

        tblItems.setItems(itemDTOS);

        tblItems.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                txtItemId.setText(newValue.getItemCode());
                txtDescription.setText(newValue.getDescription());
                txtCategory.setText(newValue.getCategory());
                txtQty.setText(String.valueOf(newValue.getQtyOnHand()));
                txtPrice.setText(String.valueOf(newValue.getUnitPrice()));
            }
        });
    }
}
