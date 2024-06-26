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
    void saveCustomer(CustomerDTO dto);

    void updateCustomer(CustomerDTO dto);

    CustomerDTO searchCustomer(String customerId);

    void deleteCustomer(String customerId);

    List<CustomerDTO> getAllCustomers();

    boolean findCustomerByUsername(String username);

    boolean findCustomerByPassword(String password);

    CustomerDTO findCustomerByUsernameAndPassword(String username, String password);

    String generateCustomerId();

    void updateCustomerStatus(String id);

    List<CustomerDTO> getAllPendingCustomers();

    List<CustomerDTO> getAllAcceptedCustomers();

    void uploadCustomerImages(String nicfPath, String nicbPath, String licenceImgPath, String id);

    int getCountOfCustomersRegistered();
}
