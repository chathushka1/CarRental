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
    private int vNumberOfPassenger;
    private double vFreeKmForDay;
    private double vFreeKmForMonth;
    private double vPricePerExtraKm;
    private double vWholeKm;
    private String vUnderMaintain;
    private String vAvailable;
    private String vFrontView;
    private String vBackView;
    private String vSideView;
    private String vInterior;
}
