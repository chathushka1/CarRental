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
 * 12:33
 * 2023-10-23
 * FrontEnd
 */

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class User {

    @Id
    private String UserId;
    private String UserName;
    private String UserPassword;

}
