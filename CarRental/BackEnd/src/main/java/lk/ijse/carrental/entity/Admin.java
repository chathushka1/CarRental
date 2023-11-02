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
 * 14:22
 * 2023-11-02
 * FrontEnd
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity
public class Admin {
    @Id
    private String adminId;
    private String name;
    private String address;
    private String contact;
    private String email;
    private String username;
    private String password;
}
