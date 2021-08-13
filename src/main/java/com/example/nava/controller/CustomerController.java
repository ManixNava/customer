package com.example.nava.controller;

import com.example.nava.dto.CustomerDTO;
import com.example.nava.model.Customer;
import com.example.nava.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    CustomerService customerService;

    /** Por cuestiones de tiempo pongo los comentarios en español XD
     * @brief Servicio para guardar un Customer
     * @body CustomerDTO: Objeto con los datos del Customer que se quiere guardar
     * @author Manuel Nava
     * **/
    @PostMapping("/customers")
    public ResponseEntity<Customer> saveCustomer(@RequestBody CustomerDTO customerDTO){
        return new ResponseEntity<>(customerService.save(customerDTO), HttpStatus.CREATED);
    }

    /**  Lo ideal para este servicio (put) sería recibir el id del Customer y en el body los nuevos datos
     * @brief Servicio para actualizar un Customer
     * @param id of the account to update
     * @body CustomerDTO: Objeto con los datos del Customer que se quiere guardar
     * @author Manuel Nava
     * **/
    @PutMapping("/customers/{id}")
    public ResponseEntity<Customer> updateCustomerById(@PathVariable("id") String id, @RequestBody CustomerDTO customerDTO){
        Customer customer = customerService.updateById(id, customerDTO);
        if(customer != null) {
            return new ResponseEntity<>(customer, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /** Dejo servicio con la ruta que fue solicitado
     * @brief Servicio para actualizar un Customer
     * @body CustomerDTO: Objeto con los datos del Customer que se quiere guardar
     * @author Manuel Nava
     * **/
    @PutMapping("/customers")
    public ResponseEntity<Customer> updateCustomer(@RequestBody CustomerDTO customerDTO){
        Customer customer = customerService.update(customerDTO);
        if(customer != null) {
            return new ResponseEntity<>(customer, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * @brief Servicio para obtener todos los usuarios
     * @author Manuel Nava
     * **/
    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> getAllCustomers() {
        List<Customer> customers = customerService.getAll();
        return new ResponseEntity<>(customers, HttpStatus.OK);
//        if(customers.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        } else {
//            return new ResponseEntity<>(customers, HttpStatus.OK);
//        }
    }

    /**
     * @brief Servicio para obtener un Customer por ID
     * @param id: ID de la cuenta a obtener
     * @author Manuel Nava
     * **/
    @GetMapping("/customers/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable("id") String id) {
        Customer customers = customerService.getById(id);
        if(customers == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(customers, HttpStatus.OK);
        }
    }

    /**
     * @brief Servicio para eliminar un Customer por ID.
     *          También podríamos hacer borrado lógico y solo creariamos una variable booleana que
     *          indique si el registro está activo o no. Entonces cambiaríamos esa variable a false
     * @param id: ID de la cuenta a borrar
     * @author Manuel Nava
     * **/
    @DeleteMapping("/customers/{id}")
    public ResponseEntity<Customer> deleteCustomer(@PathVariable("id") String id) {
        if(customerService.deleteById(id)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
