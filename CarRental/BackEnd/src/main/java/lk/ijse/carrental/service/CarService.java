package lk.ijse.carrental.service;

import lk.ijse.carrental.dto.CarDTO;



import java.util.List;

/**
 * `@authority` Chathushka Madumal
 * hp
 * 09:25
 * 2023-10-29
 * FrontEnd
 */

public interface CarService {
    void addCar(CarDTO dto);
    void deleteCar(String id);
    List<CarDTO> getAllCar();
    CarDTO findCar(String id);
    void updateCar(CarDTO c);
    String generateCarIds();
    int countRegisteredCars();

    CarDTO searchUserFromCar(String id);

    CarDTO findCarToReserve(String vNumber);
}
