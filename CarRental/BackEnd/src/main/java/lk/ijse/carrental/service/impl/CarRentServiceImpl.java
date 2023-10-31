package lk.ijse.carrental.service.impl;

import lk.ijse.carrental.dto.CarRentDTO;
import lk.ijse.carrental.entity.CarRent;
import lk.ijse.carrental.repo.CarRentRepo;
import lk.ijse.carrental.repo.CarRepo;
import lk.ijse.carrental.service.CarRentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * `@authority` Chathushka Madumal
 * hp
 * 20:03
 * 2023-10-31
 * FrontEnd
 */
public class CarRentServiceImpl implements CarRentService {

    @Autowired
    CarRentRepo repo;

    @Autowired
    ModelMapper mapper;

    @Override
    public void addCarRent(CarRentDTO dto) {
        if (!repo.existsById(dto.getRentId())) {
            repo.save(mapper.map(dto,CarRent.class));
            //customerRepo.save(mapper.map(customer, Customer.class));
        } else {
            throw new RuntimeException("Booking Already Exists...");
        }
    }

    @Override
    public void updateCarRent(CarRentDTO dto) {
        if (repo.existsById(dto.getRentId())) {
            repo.save(mapper.map(dto, CarRent.class));
        } else {
            throw new RuntimeException("No Such CarRents To Update");
        }
    }

    @Override
    public void deleteCarRent(String rentId) {
        if (repo.existsById(rentId)) {
            repo.deleteById(rentId);
        } else {
            throw new RuntimeException("No Such CarRents To Delete");
        }
    }

    @Override
    public CarRentDTO searchCarRent(String rentId) {
        if (repo.existsById(rentId)) {
            return mapper.map(repo.findById(rentId).get(), CarRentDTO.class);
        } else {
            throw new RuntimeException("Car Rent Not Found...");
        }
    }

    @Override
    public List<CarRentDTO> getAllCarRents() {
        return null;
    }

    @Override
    public String generateRentId() {
        return null;
    }

    @Override
    public void updateCarRentStatus(String rentId, String status) {

    }

    @Override
    public List<CarRentDTO> getCarRentsByStatus(String status) {
        return null;
    }

    @Override
    public List<CarRentDTO> getCarRentsByDrivingLicenceNo(String status, String licenceNo) {
        return null;
    }

    @Override
    public int getTodayBookingCount(String today) {
        return 0;
    }

    @Override
    public List<CarRentDTO> getTodayBookings(String today) {
        return null;
    }

    @Override
    public List<CarRentDTO> getCarRentsByCustomerId(String customerId) {
        return null;
    }
}
