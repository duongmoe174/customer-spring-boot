package com.duong.customerboot.controller;

import com.duong.customerboot.model.Customer;
import com.duong.customerboot.model.CustomerForm;
import com.duong.customerboot.model.Province;
import com.duong.customerboot.service.customer.ICustomerService;
import com.duong.customerboot.service.province.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

@Controller
@RequestMapping("/customers")
@CrossOrigin("*")
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private IProvinceService provinceService;

    @Autowired
    private Environment environment;

    @GetMapping("/list")
    public ModelAndView showListCustomer(){
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("customers", customerService.findAll());
        return modelAndView;
    }

    @GetMapping("")
    public ResponseEntity<Iterable<Customer>> allCustomer() {
        Iterable<Customer> customers = customerService.findAll();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @GetMapping("/provinces")
    public ResponseEntity<Iterable<Province>> allProvince() {
        Iterable<Province> provinces = provinceService.findAll();
        return new ResponseEntity<>(provinces, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Customer> createCustomer (@ModelAttribute CustomerForm customerForm) {
        MultipartFile file = customerForm.getImage();
        String fileName = file.getOriginalFilename();
        String fileUpload = environment.getProperty("upload.path").toString();
        String name = customerForm.getName();
        String email = customerForm.getEmail();
        Province province = customerForm.getProvince();
        Customer customer = new Customer(name,email, fileName, province);
        customer.setImage(fileName);
        try {
            FileCopyUtils.copy(customerForm.getImage().getBytes(), new File(fileUpload + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        customerService.save(customer);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Customer> deleteCustomer (@PathVariable Long id) {
        Optional<Customer> customerOptional = customerService.findById(id);
        if(!customerOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        customerService.remove(id);
        return new ResponseEntity<>(customerOptional.get(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getById (@PathVariable Long id) {
        Optional<Customer> customerOptional = customerService.findById(id);
        if (!customerOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("edit/{id}")
    public ResponseEntity<Customer> updateCustomer (@PathVariable Long id, @ModelAttribute Customer customer) {
        Optional<Customer> customerOptional = customerService.findById(id);
        if(!customerOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            customer.setId(id);
            customerService.save(customer);
            return new ResponseEntity<>(customer, HttpStatus.OK);
        }
    }
}
