package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.dto.SupplierDTO;

import java.net.URL;
import java.util.ResourceBundle;

public class SupplierFormController implements Initializable {
    ObservableList<SupplierDTO>supplierDTOS = FXCollections.observableArrayList(
            new SupplierDTO("S001","Thushara","WSO2","Maharagama","Colombo","Western","10230","0774027391"),
            new SupplierDTO("S002","Kumara","ABC Traders","Kandy","Kandy","Central","20000","0712345678"),
            new SupplierDTO("S003","Nimal","XYZ Supplies","Galle","Galle","Southern","80000","0759876543"),
            new SupplierDTO("S004","Sunil","DEF Distributors","Jaffna","Jaffna","Northern","40000","0723456789"),
            new SupplierDTO("S005","Ravi","GHI Wholesalers","Matara","Matara","Southern","81000","0788765432"),
            new SupplierDTO("S006","Saman","JKL Enterprises","Negombo","Negombo","Western","11500","0765432198"),
            new SupplierDTO("S007","Amal","MNO Suppliers","Anuradhapura","Anuradhapura","North Central","50000","0741234567"),
            new SupplierDTO("S008","Kamal","PQR Traders","Trincomalee","Trincomalee","Eastern","31000","0739876543")
    );

    @FXML
    private TableColumn<?, ?> colAddress;

    @FXML
    private TableColumn<?, ?> colCity;

    @FXML
    private TableColumn<?, ?> colCompany;

    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colPhoneNo;

    @FXML
    private TableColumn<?, ?> colPostalCode;

    @FXML
    private TableColumn<?, ?> colProvince;

    @FXML
    private Label lblTitle;

    @FXML
    private AnchorPane mainContent;

    @FXML
    private TableView<SupplierDTO> tblSupplier;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtCity;

    @FXML
    private TextField txtCompany;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtPhoneNo;

    @FXML
    private TextField txtPostalCode;

    @FXML
    private TextField txtProvince;

    @FXML
    private TextField txtSupplierId;

    @FXML
    void btnAddAction(ActionEvent event) {
        String supplierID = txtSupplierId.getText();
        String name = txtName.getText();
        String company = txtCompany.getText();
        String address = txtAddress.getText();
        String city = txtCity.getText();
        String province = txtProvince.getText();
        String postalCode = txtPostalCode.getText();
        String phoneNo = txtPhoneNo.getText();

        SupplierDTO newSupplier = new SupplierDTO(supplierID, name, company, address, city, province, postalCode, phoneNo);
        supplierDTOS.add(newSupplier);

    }

    @FXML
    void btnClearAction(ActionEvent event) {
        txtSupplierId.clear();
        txtName.clear();
        txtCompany.clear();
        txtAddress.clear();
        txtCity.clear();
        txtProvince.clear();
        txtPostalCode.clear();
        txtPhoneNo.clear();

    }

    @FXML
    void btnCustomerOnAction(ActionEvent event) {

    }

    @FXML
    void btnDashboardOnAction(ActionEvent event) {
        Stage stage = (Stage) mainContent.getScene().getWindow();
        stage.close();

    }

    @FXML
    void btnDeleteAction(ActionEvent event) {
        SupplierDTO selectedSupplier = tblSupplier.getSelectionModel().getSelectedItem();
        if (selectedSupplier != null) {
            supplierDTOS.remove(selectedSupplier);
            // Clear input fields after deletion
            txtSupplierId.clear();
            txtName.clear();
            txtCompany.clear();
            txtAddress.clear();
            txtCity.clear();
            txtProvince.clear();
            txtPostalCode.clear();
            txtPhoneNo.clear();
        }

    }

    @FXML
    void btnEmployeeOnAction(ActionEvent event) {

    }

    @FXML
    void btnItemOnAction(ActionEvent event) {
        Stage stage = (Stage) mainContent.getScene().getWindow();
        stage.close();

    }

    @FXML
    void btnLogoutOnAction(ActionEvent event) {
        mainContent.getScene().getWindow().hide();

    }

    @FXML
    void btnSetiting(ActionEvent event) {

    }

    @FXML
    void btnSupplierOnAction(ActionEvent event) {

    }

    @FXML
    void btnUpdateAction(ActionEvent event) {
        SupplierDTO selectedSupplier = tblSupplier.getSelectionModel().getSelectedItem();
        if (selectedSupplier != null) {
            selectedSupplier.setSupplierID(txtSupplierId.getText());
            selectedSupplier.setName(txtName.getText());
            selectedSupplier.setCompany(txtCompany.getText());
            selectedSupplier.setAddress(txtAddress.getText());
            selectedSupplier.setCity(txtCity.getText());
            selectedSupplier.setProvince(txtProvince.getText());
            selectedSupplier.setPostalCode(txtPostalCode.getText());
            selectedSupplier.setPhoneNo(txtPhoneNo.getText());
            tblSupplier.refresh();
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colId.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("supplierID"));
        colName.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("name"));
        colCompany.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("company"));
        colAddress.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("address"));
        colCity.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("city"));
        colProvince.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("province"));
        colPostalCode.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("postalCode"));
        colPhoneNo.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("phoneNo"));

        tblSupplier.setItems(supplierDTOS);



    }
}
