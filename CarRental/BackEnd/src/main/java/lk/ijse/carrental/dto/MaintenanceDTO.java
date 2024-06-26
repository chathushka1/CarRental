package lk.ijse.carrental.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * `@authority` Chathushka Madumal
 * hp
 * 23:50
 * 2023-11-02
 * FrontEnd
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class MaintenanceDTO {
    private String maintenanceId;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private String date;
    private String details;
    private CarDTO car;
    private double cost;

}
