package ma.amarghad.customerservice.web;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import lombok.AllArgsConstructor;
import ma.amarghad.customerservice.dto.CustomerRequest;
import ma.amarghad.customerservice.entities.Customer;
import ma.amarghad.customerservice.mapper.CustomerMapper;
import ma.amarghad.customerservice.repository.CustomerRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
@WebService(serviceName = "CustomerWS")
public class CustomerSoapService {
    private CustomerRepository customerRepository;
    private CustomerMapper customerMapper;

    @WebMethod
    public List<Customer> customerList(){
        return customerRepository.findAll();
    }
    @WebMethod
    public Customer customerById(@WebParam(name="id") Long id){
        return customerRepository.findById(id).get();
    }
    @WebMethod
    public Customer saveCustomer(@WebParam(name = "customer") CustomerRequest customerRequest){
        Customer customer = customerMapper.from(customerRequest);
        return customerRepository.save(customer);
    }
}
