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
    void saveDriver(DriverDTO dto);

    void updateDriver(DriverDTO dto);

    void deleteDriver(String licenceNo);

    DriverDTO searchDriver(String licenceNo);

    List<DriverDTO> getAllDrivers();

    boolean findDriverByUsername(String username);

    boolean findDriverByPassword(String password);

    DriverDTO findDriverByUsernameAndPassword(String username, String password);

    void updateDriverNonAvailable(String licenceNo);

    void updateDriverAvailable(String licenceNo);

    List<DriverDTO> getAllAvailableDrivers();

    List<DriverDTO> getAllNonAvailableDrivers();

    int getCountOfDriversByStatus(boolean availability);

    List<DriverDTO> getRandomDriver();
}
