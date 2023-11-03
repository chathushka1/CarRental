package lk.ijse.carrental.service;

import lk.ijse.carrental.dto.CarRentReturnDTO;

import java.util.List;

/**
 * `@authority` Chathushka Madumal
 * hp
 * 20:12
 * 2023-11-03
 * FrontEnd
 */
public interface CarRentReturnService {
    void saveCarRentReturn(CarRentReturnDTO dto);

    void updateCarRentReturn(CarRentReturnDTO dto);

    void deleteCarRentReturn(String returnId);

    CarRentReturnDTO searchCarRentReturn(String returnId);

    List<CarRentReturnDTO> getAllCarRentReturns();

    String generateReturnId();
}
