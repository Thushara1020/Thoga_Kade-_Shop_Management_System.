package model.dto;

public class SupplierDTO {
    private String supplierId;
    private String name;
    private String companyName;
    private String address;
    private String city;
    private String province;
    private String postalCode;
    private String phone;

    public SupplierDTO(String supplierId, String name, String companyName, String address, String city, String province, String postalCode, String phone) {
        this.supplierId = supplierId;
        this.name = name;
        this.companyName = companyName;
        this.address = address;
        this.city = city;
        this.province = province;
        this.postalCode = postalCode;
        this.phone = phone;
    }

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierID(String supplierId) {
        this.supplierId = supplierId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompany(String companyName) {
        this.companyName = companyName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhoneNo(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "SupplierDTO{" +
                "supplierId='" + supplierId + '\'' +
                ", name='" + name + '\'' +
                ", companyName='" + companyName + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", province='" + province + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
