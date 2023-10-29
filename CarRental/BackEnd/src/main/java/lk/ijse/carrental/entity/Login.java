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
 * 19:51
 * 2023-10-29
 * FrontEnd
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Entity
public class Login {
    @Id
    private String loginId;
    private String username;
    private String password;
}
