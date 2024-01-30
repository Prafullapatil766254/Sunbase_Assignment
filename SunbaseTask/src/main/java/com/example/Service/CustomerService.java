package com.example.Service;

import com.example.Model.CustomExceptions.CustomerNotFoundException;
import com.example.Model.CustomExceptions.InvalidCredentialsException;
import com.example.Model.Customer;
import com.example.Model.ResponsePojos.RequestResponse;
import com.example.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public ResponseEntity<String> createCustomer(Customer customer){
        String password = customer.getPassword();
        customer.setPassword(passwordEncoder.encode(password)); // saving password in encoded version in db

        customerRepository.save(customer);
        return new ResponseEntity<>("Customer added successfully.." , HttpStatus.OK);
    }

    public ResponseEntity<Customer> getCustomerById(Integer id){
        Customer customer = customerRepository.findById(id).orElse(null);

        if(customer == null){
            throw new CustomerNotFoundException("User with id "+id+" is not exists..");
        }
        return new ResponseEntity<>(customer , HttpStatus.OK);
    }

    public ResponseEntity<RequestResponse> updateCustomerPassword(Integer id, String oldPassword, String newPassword){
        Customer customer = customerRepository.findById(id).orElse(null);

        // will check whether customer is null or not means given id is valid or not..
        if(customer == null){
            throw new CustomerNotFoundException("User with id "+id+" does not exists..");
        }

        // matching whether the given password in right or wrong and if not correct then throwing invalid credentials exception
        String existingPasswordEncoded = customer.getPassword();

        if(!passwordEncoder.matches(oldPassword ,existingPasswordEncoded)){
           throw new InvalidCredentialsException("Invalid credentials..");
        }

        // if above all are false it means everything is okay so proceeding for change password..

        customer.setPassword(passwordEncoder.encode(newPassword));
        customerRepository.save(customer);
        RequestResponse response = new RequestResponse(HttpStatus.OK.value() , "Password changed successfully..");
        return new ResponseEntity<>(response , HttpStatus.OK);

    }

    public Page<Customer> getListOfCustomersByPage(Pageable pageable){
        Page<Customer> customers = customerRepository.findAll(pageable);
        return customers;
    }

    public ResponseEntity<RequestResponse> deleteCustomer(Integer id){
        Customer customer = customerRepository.findById(id).orElse(null);

        if(customer == null) {
            throw new CustomerNotFoundException("Customer with id "+id+" does not exists..");
        }

        customerRepository.delete(customer);
        RequestResponse response = new RequestResponse(HttpStatus.OK.value(), "Customer with id "+id+" deleted successfully..");
        return new ResponseEntity<>(response , HttpStatus.OK);
    }
}
