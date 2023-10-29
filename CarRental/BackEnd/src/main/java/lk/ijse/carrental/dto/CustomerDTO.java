package lk.ijse.carrental.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.util.Date;

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
    private String cId;
    private String name;
    private String address;
    private String eMail;
    private String contact;
    private String nic;
    private String licenseNumber;
    private String nicPhoto;
    private String licensePhoto;
    private LocalDate date;

    private UserDTO users;
}
