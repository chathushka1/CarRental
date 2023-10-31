package lk.ijse.carrental.service.impl;

import lk.ijse.carrental.dto.CarDTO;
import lk.ijse.carrental.entity.Car;
import lk.ijse.carrental.repo.CarRepo;
import lk.ijse.carrental.service.CarService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.smartcardio.Card;
import java.util.List;

/**
 * `@authority` Chathushka Madumal
 * hp
 * 19:36
 * 2023-10-29
 * FrontEnd
 */
@Service
@Transactional
public class CarServiceImpl implements CarService {

    @Autowired
    CarRepo carRepo;

    @Autowired
    ModelMapper mapper;

    @Override
    public void saveCar(CarDTO dto) {
        if (!carRepo.existsById(dto.getCarId())) {
            carRepo.save(mapper.map(dto, Car.class));
        } else {
            throw new RuntimeException(dto.getCarId() + " " + "Car Already Exists..!");
        }

    }

    @Override
    public void updateCar(CarDTO dto) {
        if (carRepo.existsById(dto.getCarId())) {
            carRepo.save(mapper.map(dto, Car.class));
        } else {
            throw new RuntimeException(dto.getCarId() + " " + "No Such Car..! Please Check The Car ..!");
        }

    }

    @Override
    public void deleteCar(String id) {
        if (carRepo.existsById(id)) {
            carRepo.deleteById(id);
        } else {
            throw new RuntimeException(id + " " + "No Such Car..! Please Check The Correct Id..!");
        }

    }

    @Override
    public CarDTO searchCar(String id) {
        if (carRepo.existsById(id)) {
            Car car = carRepo.findById(id).get();
            return mapper.map(car, CarDTO.class);
        } else {
            throw new RuntimeException(id + " " + "No Such Car..! Please Check The Correct Id..!");
        }

    }

    @Override
    public List<CarDTO> getAllCars() {
        List<Car> carList = carRepo.findAll();
        return mapper.map(carList,new TypeToken<List<CarDTO>>(){}.getType());

    }

    @Override
    public String generateCarIds() {
        return carRepo.generateCarId();

    }

    @Override
    public String searchRegNumberIsExists(String reg) {
        return carRepo.searchRegNumberIsExists(reg);

    }

    @Override
    public void carAvailableOrNot(String available, String id) {
        carRepo.carAvailableOrNot(available,id);

    }

    @Override
    public List<CarDTO> sortAccordingToPassengersByAscending() {
        return null;
    }

    @Override
    public List<CarDTO> sortAccordingToPassengersByDescending() {
        return null;
    }

    @Override
    public List<CarDTO> sortAccordingToDailyRatePriceByDescending() {
        return null;
    }

    @Override
    public List<CarDTO> sortAccordingToDailyRatePriceByAscending() {
        return null;
    }

    @Override
    public List<CarDTO> sortAccordingToMonthlyRatePriceByAscending() {
        return null;
    }

    @Override
    public List<CarDTO> sortAccordingToMonthlyRatePriceByDescending() {
        return null;
    }

    @Override
    public List<CarDTO> findByTransmissionType(String type) {
        return null;
    }

    @Override
    public List<CarDTO> findByBrand(String brand) {
        return null;
    }

    @Override
    public List<CarDTO> findByType(String type) {
        return null;
    }

    @Override
    public List<CarDTO> findByFuelType(String fuelType) {
        return null;
    }

    @Override
    public List<CarDTO> findByColour(String colour) {
        return null;
    }

    @Override
    public int noOfAvailableOrReservedCars(String availability) {
        return 0;
    }

    @Override
    public int needMaintenanceOrUnderMaintenanceCars(String maintain) {
        return 0;
    }
}
