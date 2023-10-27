package lk.ijse.carrental.service;

import lk.ijse.carrental.dto.DriverDTO;

import java.util.List;

/**
 * `@authority` Chathushka Madumal
 * hp
 * 08:19
 * 2023-10-27
 * FrontEnd
 */
public interface DriverService {
    void addDriver(DriverDTO dto);
    void deleteDriver(String id);
    List<DriverDTO> getAllDriver();
    DriverDTO findDriver(String id);
    void updateDriver(DriverDTO c);
}
