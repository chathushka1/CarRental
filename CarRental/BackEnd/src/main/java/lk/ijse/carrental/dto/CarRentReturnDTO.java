package lk.ijse.carrental.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * `@authority` Chathushka Madumal
 * hp
 * 19:54
 * 2023-11-03
 * FrontEnd
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CarRentReturnDTO {
    private String returnId;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private String date;
    private double noOfKm;
    private CarRentDTO rental;
    private PaymentDTO payment;
}
