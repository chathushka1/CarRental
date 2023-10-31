package lk.ijse.carrental.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * `@authority` Chathushka Madumal
 * hp
 * 19:53
 * 2023-10-31
 * FrontEnd
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CarRentDTO {

    private String rentId;
    private String date;
    private String pickUpDate;
    private String returnDate;
    private String status;

    CustomerDTO customerDTO;
    CarDTO carDTO;
    DriverDTO driverDTO;
}
