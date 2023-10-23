package lk.ijse.carrental.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * `@authority` Chathushka Madumal
 * hp
 * 12:35
 * 2023-10-23
 * FrontEnd
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class UserDTO {

    private String UserId;
    private String UserName;
    private String UserPassword;
}
