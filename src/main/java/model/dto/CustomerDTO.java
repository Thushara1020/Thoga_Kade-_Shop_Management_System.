package model.dto;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {
    private String custID;
    private String title;
    private String name;
    private String bod;
    private double salary;
    private String address;
    private String city;
    private String province;
    private String postalCode;
}
