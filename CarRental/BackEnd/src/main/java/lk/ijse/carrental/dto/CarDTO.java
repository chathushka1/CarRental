package lk.ijse.carrental.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
