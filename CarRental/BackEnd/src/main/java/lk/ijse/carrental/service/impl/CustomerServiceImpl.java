package lk.ijse.carrental.service.impl;

import lk.ijse.carrental.dto.CustomerDTO;
import lk.ijse.carrental.entity.Customer;
import lk.ijse.carrental.repo.CustomerRepo;
import lk.ijse.carrental.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

/**
 * `@authority` Chathushka Madumal
 * hp
 * 22:57
 * 2023-10-25
 * FrontEnd
 */
@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepo customerRepo;

    @Autowired
    ModelMapper mapper;
    @Override
    public void addCustomer(CustomerDTO dto) {
        if (!customerRepo.existsById(dto.getCId())) {
            customerRepo.save(mapper.map(dto, Customer.class));
        } else {
            throw new RuntimeException(dto.getCId() + " Customer Already Exists !!!");
        }
    }

    @Override
    public void deleteCustomer(String id) {
        if (customerRepo.existsById(id)) {
            customerRepo.deleteById(id);
        } else {
            throw new RuntimeException(id + "No Please Check The Correct Id..!");
        }
    }

    @Override
    public List<CustomerDTO> getAllCustomer() {
        List<Customer> all = customerRepo.findAll();
        return mapper.map(all, new TypeToken<List<CustomerDTO>>() {}.getType());
    }

    @Override
    public CustomerDTO findCustomer(String id) {
        if (customerRepo.existsById(id)) {
            Customer customer = customerRepo.findById(id).get();
            return mapper.map(customer, CustomerDTO.class);
        } else {
            throw new RuntimeException(id + "No Please Check The Correct Id..!");
        }
    }

    @Override
    public void updateCustomer(CustomerDTO c) {
        if (customerRepo.existsById(c.getCId())) {
            customerRepo.save(mapper.map(c, Customer.class));
        } else {
            throw new RuntimeException(c.getCId() + "No Please Check The Correct Id..!");
        }
    }

    @Override
    public int registeredCustomerCount() {
        return customerRepo.registeredCusCount();
    }

    @Override
    public int dailyRegisteredCustomerCount(String date) {
        return customerRepo.dailyRegisteredCusCount(date);
    }


    @Override
    public CustomerDTO searchUserCustomer(String id) {
        Customer customer = customerRepo.searchCustomer(id);
        return mapper.map(customer, CustomerDTO.class);
    }

    @Override
    public CustomerDTO findCustomerToReserve(String nic) {
        Customer customer = customerRepo.searchCustomer(nic);
        return mapper.map(customer, CustomerDTO.class);
    }

    @Override
    public String cusIdGenerate() {
        return customerRepo.generateCId();
    }
}
