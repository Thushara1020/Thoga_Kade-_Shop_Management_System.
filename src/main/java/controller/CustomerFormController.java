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
import model.dto.CustomerDTO;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CustomerFormController implements Initializable {
    ObservableList<CustomerDTO> customerDTOS = FXCollections.observableArrayList(
            new CustomerDTO("C001","Mr.","Thushara","2001/04/15",10000.00,"Pannipitiya","Maharagama","Western","10120"),
            new CustomerDTO("C002","Ms.","Kumari","2000/08/22",15000.00,"Colombo","Colombo","Western","01500"),
            new CustomerDTO("C003","Mr.","Nimal","1998/12/05",20000.00,"Kandy","Kandy","Central","20000"),
            new CustomerDTO("C004","Ms.","Sunethra","1995/03/30",25000.00,"Galle","Galle","Southern","80000"),
            new CustomerDTO("C005","Mr.","Ruwan","1992/07/18",30000.00,"Jaffna","Jaffna","Northern","40000"),
            new CustomerDTO("C006","Ms.","Anusha","1999/11/11",35000.00,"Matara","Matara","Southern","81000"),
            new CustomerDTO("C007","Mr.","Saman","1997/05/25",40000.00,"Negombo","Negombo","Western","11500"),
            new CustomerDTO("C008","Ms.","Dilani","2001/09/09",45000.00,"Kurunegala","Kurunegala","North Western","60000")
    );

    @FXML
    private TableColumn<?, ?> colAddress;

    @FXML
    private TableColumn<?, ?> colBOD;

    @FXML
    private TableColumn<?, ?> colCity;

    @FXML
    private TableColumn<?, ?> colCustID;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colPostalCode;

    @FXML
    private TableColumn<?, ?> colProvince;

    @FXML
    private TableColumn<?, ?> colSalary;

    @FXML
    private TableColumn<?, ?> colTitle;

    @FXML
    private Label lblTitle;

    @FXML
    private AnchorPane mainContent;

    @FXML
    private TableView<CustomerDTO> tblCustomers;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtBirthofDate;

    @FXML
    private TextField txtCustID;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtPostalCode;

    @FXML
    private TextField txtProvince;

    @FXML
    private TextField txtSalary;

    @FXML
    private TextField txtTitle;

    @FXML
    private TextField txtcity;

    @FXML
    void btnAddAction(ActionEvent event) {
        String id = txtCustID.getText();
        String title = txtTitle.getText();
        String name = txtName.getText();
        String bod = txtBirthofDate.getText();
        double salary = Double.parseDouble(txtSalary.getText());
        String address = txtAddress.getText();
        String city = txtcity.getText();
        String province = txtProvince.getText();
        String postalCode = txtPostalCode.getText();

        CustomerDTO newCustomer = new CustomerDTO(id, title, name, bod, salary, address, city, province, postalCode);
        customerDTOS.add(newCustomer);

        // Clear input fields after adding
        txtCustID.clear();
        txtTitle.clear();
        txtName.clear();
        txtBirthofDate.clear();
        txtSalary.clear();
        txtAddress.clear();
        txtcity.clear();
        txtProvince.clear();
        txtPostalCode.clear();

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
        CustomerDTO selectedCustomer = tblCustomers.getSelectionModel().getSelectedItem();
        if (selectedCustomer != null) {
            customerDTOS.remove(selectedCustomer);
            // Clear input fields after deletion
            txtCustID.clear();
            txtTitle.clear();
            txtName.clear();
            txtBirthofDate.clear();
            txtSalary.clear();
            txtAddress.clear();
            txtcity.clear();
            txtProvince.clear();
            txtPostalCode.clear();
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

    }

    @FXML
    void btnSetiting(ActionEvent event) {

    }

    @FXML
    void btnSupplierOnAction(ActionEvent event) {


    }

    @FXML
    void btnUpdateAction(ActionEvent event) {
        CustomerDTO selectedCustomer = tblCustomers.getSelectionModel().getSelectedItem();
        if (selectedCustomer != null) {
            selectedCustomer.setCustID(txtCustID.getText());
            selectedCustomer.setTitle(txtTitle.getText());
            selectedCustomer.setName(txtName.getText());
            selectedCustomer.setBod(txtBirthofDate.getText());
            selectedCustomer.setSalary(Double.parseDouble(txtSalary.getText()));
            selectedCustomer.setAddress(txtAddress.getText());
            selectedCustomer.setCity(txtcity.getText());
            selectedCustomer.setProvince(txtProvince.getText());
            selectedCustomer.setPostalCode(txtPostalCode.getText());
            tblCustomers.refresh();

            // Clear input fields after updating
            txtCustID.clear();
            txtTitle.clear();
            txtName.clear();
            txtBirthofDate.clear();
            txtSalary.clear();
            txtAddress.clear();
            txtcity.clear();
            txtProvince.clear();
            txtPostalCode.clear();
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colCustID.setCellValueFactory(new PropertyValueFactory<>("custID"));
        colTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colBOD.setCellValueFactory(new PropertyValueFactory<>("bod"));
        colSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colCity.setCellValueFactory(new PropertyValueFactory<>("city"));
        colProvince.setCellValueFactory(new PropertyValueFactory<>("province"));
        colPostalCode.setCellValueFactory(new PropertyValueFactory<>("postalCode"));

        tblCustomers.setItems(customerDTOS);

        // Auto fill text fields on row select
        tblCustomers.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                txtCustID.setText(newValue.getCustID());
                txtTitle.setText(newValue.getTitle());
                txtName.setText(newValue.getName());
                txtBirthofDate.setText(newValue.getBod());
                txtSalary.setText(String.valueOf(newValue.getSalary()));
                txtAddress.setText(newValue.getAddress());
                txtcity.setText(newValue.getCity());
                txtProvince.setText(newValue.getProvince());
                txtPostalCode.setText(newValue.getPostalCode());

            }
        });
    }
}
