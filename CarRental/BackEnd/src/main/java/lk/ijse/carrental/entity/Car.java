package lk.ijse.carrental.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

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
    private String carId;
    private String registrationNo;
    private String colour;
    private String brand;
    private String type;
    private String fuelType;
    private String transmissionType;
    private int noOfPassengers;
    private int freeKmForDay;
    private int freeKmForMonth;
    private double pricePerExtraKM;
    private double dailyRatePrice;
    private double monthlyRatePrice;
    private int totalDistanceTraveled;
    private String availableOrNot;
    private String damageOrNot;
    private String underMaintainOrNot;
    private String fontViewImage;
    private String backViewImage;
    private String sideViewImage;
    private String interiorViewImage;

    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL)
    private List<CarRent> rentals = new ArrayList<>();
}
