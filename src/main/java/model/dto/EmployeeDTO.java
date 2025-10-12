package model.dto;

public class EmployeeDTO {
    private String employeeID;
    private String name;
    private String nic;
    private String dob;
    private String positon;
    private double salary;
    private String contactNumber;
    private String address;
    private String joinedDate;
    private String status;

    public EmployeeDTO(String employeeID, String name, String nic, String dob, String positon, double salary, String contactNumber, String address, String joinedDate, String status) {
        this.employeeID = employeeID;
        this.name = name;
        this.nic = nic;
        this.dob = dob;
        this.positon = positon;
        this.salary = salary;
        this.contactNumber = contactNumber;
        this.address = address;
        this.joinedDate = joinedDate;
        this.status = status;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getPositon() {
        return positon;
    }

    public void setPositon(String positon) {
        this.positon = positon;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getJoinedDate() {
        return joinedDate;
    }

    public void setJoinedDate(String joinedDate) {
        this.joinedDate = joinedDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "EmployeeDTO{" +
                "employeeID='" + employeeID + '\'' +
                ", name='" + name + '\'' +
                ", nic='" + nic + '\'' +
                ", dob='" + dob + '\'' +
                ", positon='" + positon + '\'' +
                ", salary=" + salary +
                ", contactNumber='" + contactNumber + '\'' +
                ", address='" + address + '\'' +
                ", joinedDate='" + joinedDate + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
