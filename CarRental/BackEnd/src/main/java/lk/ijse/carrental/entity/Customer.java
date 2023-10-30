package lk.ijse.carrental.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.time.LocalDate;
import java.util.Date;

/**
 * `@authority` Chathushka Madumal
 * hp
 * 12:19
 * 2023-10-23
 * FrontEnd
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Customer {
   @Id
    private String customerId;
    private String customerName;
    private LocalDate registeredDate;
    private String customerEmail;
    private String customerNIC;
    private String customerAddress;
    private String customerContact;
    private String customerDrivingLicenseId;
    private String customerDrivingLicenseImage;


    @OneToOne(cascade = CascadeType.ALL)
    private User users;


}
