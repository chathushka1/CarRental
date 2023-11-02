package lk.ijse.carrental.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

/**
 * `@authority` Chathushka Madumal
 * hp
 * 09:26
 * 2023-10-29
 * FrontEnd
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class CarDTO {
    private String registrationNO;
    private String brand;
    private String type;
    private int noOfPassengers;
    private String transmissionType;
    private String fuelType;
    private String color;
    private String frontView;
    private String backView;
    private String sideView;
    private String internalView;
    private double dailyRate;
    private double monthlyRate;
    private double freeKmForPrice;
    private double freeKmForDuration;
    private double lossDamageWaiver;
    private double priceForExtraKm;
    private double completeKm;
    private String status;

}
