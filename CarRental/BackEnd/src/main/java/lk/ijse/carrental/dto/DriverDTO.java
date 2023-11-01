package lk.ijse.carrental.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

/**
 * `@authority` Chathushka Madumal
 * hp
 * 08:17
 * 2023-10-27
 * FrontEnd
 */

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class DriverDTO {
    private String dId;
    private String dName;
    private String dAddress;
    private String dContact;
    private String dEmail;
    private String dLicenseNumber;
    private String dLicensePhoto;
    private LocalDate dRegisteredDate;

    private UserDTO userDTO;
}
