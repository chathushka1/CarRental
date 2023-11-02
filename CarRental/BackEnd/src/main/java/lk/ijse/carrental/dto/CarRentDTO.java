package lk.ijse.carrental.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * `@authority` Chathushka Madumal
 * hp
 * 23:39
 * 2023-11-02
 * FrontEnd
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CarRentDTO {
    private String rentId;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private String date;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private String pickUpDate;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private String returnDate;
    private String status;
    private CustomerDTO customer;
    private CarDTO car;
    private DriverDTO driver;
}
