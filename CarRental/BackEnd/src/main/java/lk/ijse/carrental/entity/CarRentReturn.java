package lk.ijse.carrental.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

/**
 * `@authority` Chathushka Madumal
 * hp
 * 19:52
 * 2023-11-03
 * FrontEnd
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity
public class CarRentReturn {
    @Id
    private String returnId;
    private String date;
    private double noOfKm;

    @OneToOne(cascade = {CascadeType.DETACH,CascadeType.REFRESH})
    @JoinColumn(name = "rentId", referencedColumnName = "rentId", nullable = false)
    private CarRent rental;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "paymentId", referencedColumnName = "paymentId", nullable = false)
    private Payment payment;
}
