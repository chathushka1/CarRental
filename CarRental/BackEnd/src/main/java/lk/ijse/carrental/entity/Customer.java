package lk.ijse.carrental.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.util.Date;

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
    private String cId;
    private String name;
    private String address;
    private String eMail;
    private String contact;
    private String nic;
    private String licenseNumber;
    private String nicPhoto;
    private String licensePhoto;
    private Date date;


    @OneToOne(cascade = CascadeType.ALL)
    private User user;


}
