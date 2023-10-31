package lk.ijse.carrental.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * `@authority` Chathushka Madumal
 * hp
 * 19:41
 * 2023-10-31
 * FrontEnd
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity
public class CarRent {
    @Id
    private String rentId;
    private String date;
    private String pickUpDate;
    private String returnDate;
    private String status;

    @ManyToOne
    @JoinColumn(name = "customerId", referencedColumnName = "customerId", nullable = false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "registrationNo", referencedColumnName = "registrationNo", nullable = false)
    private Car car;

    @ManyToOne
    @JoinColumn(name = "dLicenseNumber", referencedColumnName = "dLicenseNumber")
    private Driver driver;
}
