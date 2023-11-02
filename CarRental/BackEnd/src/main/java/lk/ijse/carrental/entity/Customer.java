package lk.ijse.carrental.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * `@authority` Chathushka Madumal
 * hp
 * 12:19
 * 2023-10-23
 * FrontEnd
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Customer {
 @Id
 private String customerId;
 private String name;
 private String address;
 private int contactNo;
 private String email;
 private String nicNo;
 private String nicFrontImg;
 private String nicBackImg;
 private String licenceNo;
 private String licenceImg;
 private String username;
 private String password;
 private String status;

/* @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
 private List<CarRent> rentals = new ArrayList<>();*/

 @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
 private List<Payment> payments = new ArrayList<>();
}
