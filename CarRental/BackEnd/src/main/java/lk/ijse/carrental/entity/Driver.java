package lk.ijse.carrental.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


/**
 * `@authority` Chathushka Madumal
 * hp
 * 08:12
 * 2023-10-27
 * FrontEnd
 */

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString

public class Driver {

    @Id
    private String licenceNo;
    private String name;
    private String address;
    private String contactNo;
    private String nicNo;
    private String username;
    private String password;
    private boolean availability;

    /*@OneToMany(mappedBy = "driver",cascade = CascadeType.ALL)
    private List<CarRent> rentals = new ArrayList<>();*/


}
