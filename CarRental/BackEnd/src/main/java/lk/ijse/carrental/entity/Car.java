package lk.ijse.carrental.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * `@authority` Chathushka Madumal
 * hp
 * 08:23
 * 2023-10-27
 * FrontEnd
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Car {

    @Id
    private String vId;
    private String vRegisterNumber;
    private String vType;
    private String vColor;
    private String vTransmissionType;
    private String vFuelType;
    private String vNumberOfPassenger;
    private String vFreeKmForDay;
    private String vFreeKmForMonth;
    private String vPricePerExtraKm;
    private String vWholeKm;
}
