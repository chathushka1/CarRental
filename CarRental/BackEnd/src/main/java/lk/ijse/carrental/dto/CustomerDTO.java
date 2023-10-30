package lk.ijse.carrental.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;


/**
 * `@authority` Chathushka Madumal
 * hp
 * 12:25
 * 2023-10-23
 * FrontEnd
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CustomerDTO {
    private String customerId;
    private String customerName;
    private LocalDate registeredDate;
    private String customerEmail;
    private String customerNIC;
    private String customerAddress;
    private String customerContact;
    private String customerDrivingLicenseId;
    private String customerDrivingLicenseImage;

    private UserDTO users;
}
