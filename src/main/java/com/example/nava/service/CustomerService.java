package com.example.nava.service;

import com.example.nava.dto.CustomerDTO;
import com.example.nava.model.Customer;
import com.example.nava.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public Customer save(CustomerDTO customerDTO){
        // TODO: Hay una forma de mapear los objetos pero no creo que me de tiempo de buscarla para implementarla pero creo que sería lo mejor
        Customer customer = new Customer(customerDTO.getFirstName(),
                customerDTO.getLastName(),
                customerDTO.getDateOfBirth());
        return customerRepository.save(customer);
    }

    public Customer updateById(String id, CustomerDTO customerDTO){
        Optional<Customer> customerData = customerRepository.findById(id);
        if(customerData.isPresent()) {
            Customer customer = customerData.get();
            customer.setFirstName(customerDTO.getFirstName());
            customer.setLastName(customerDTO.getLastName());
            customer.setDateOfBirth(customerDTO.getDateOfBirth());
            return customerRepository.save(customer);
        } else {
            return null;
        }
    }

    public Customer update(CustomerDTO customerDTO){
        Optional<Customer> customerData = customerRepository.findById(customerDTO.getId());
        if(customerData.isPresent()) {
            Customer customer = customerData.get();
            customer.setFirstName(customerDTO.getFirstName());
            customer.setLastName(customerDTO.getLastName());
            customer.setDateOfBirth(customerDTO.getDateOfBirth());
            return customerRepository.save(customer);
        } else {
            return null;
        }
    }

    public List<Customer> getAll(){
        return customerRepository.findAll();
    }

    public Customer getById(String id){
        Optional<Customer> customer = customerRepository.findById(id);
        if(customer.isPresent()) {
            return customer.get();
        } else {
            return null;
        }
    }

    public Boolean deleteById(String id){
        Optional<Customer> customer = customerRepository.findById(id);
        if(customer.isPresent()) {
            customerRepository.delete(customer.get());
            return true;
        } else {
            return false;
        }
    }

}
