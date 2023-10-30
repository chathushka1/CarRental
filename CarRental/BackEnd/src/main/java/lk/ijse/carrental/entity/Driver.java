package lk.ijse.carrental.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;


/**
 * `@authority` Chathushka Madumal
 * hp
 * 08:12
 * 2023-10-27
 * FrontEnd
 */

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString

public class Driver {

    @Id
    private String dId;
    private String dName;
    private String dAddress;
    private String dContact;
    private String dEmail;
    private String dLicenseNumber;
    private String dLicensePhoto;
    private LocalDate dRegisteredDate;

}
