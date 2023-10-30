package lk.ijse.carrental.service;

import lk.ijse.carrental.dto.CustomerDTO;

import java.util.List;

/**
 * `@authority` Chathushka Madumal
 * hp
 * 22:51
 * 2023-10-25
 * FrontEnd
 */
public interface CustomerService {
    void saveCustomer(CustomerDTO customer);

    void updateCustomer(CustomerDTO customer);

    void deleteCustomer(String id);

    CustomerDTO searchCustomer(String id);

    List<CustomerDTO> getAllCustomers();

    String generateCustomerIds();

    int countRegisteredCustomers();

    int countDailyRegisteredCustomers(String date);

    CustomerDTO searchUserFromCustomer(String id);

    CustomerDTO findCustomerToReserve(String nic);
}
