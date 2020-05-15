package com.customer.service;

import com.customer.model.Customer;
import com.customer.dao.CustomerDao;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.*;

import java.util.List;

@Service
public class CustomerService
{
    @Autowired
    private CustomerDao customerDao;

    public void setCustomerDao(CustomerDao customerDao)
    {
        this.customerDao = customerDao;
    }

    @Transactional
    public List <Customer> listCustomers() {return this.customerDao.listCustomers();}

    @Transactional
    public void addCustomer(Customer customer)
    {
        this.customerDao.addCustomer(customer);

        if(!listCustomers().contains(customer))
        {
            System.err.println("Service ADD in IF");
            this.customerDao.addCustomer(customer);
            System.err.println("Service ADD in IF after Dao");
        }
        else
        {
            System.err.println("Service ADD in ELSE");
            this.customerDao.updateCustomer(customer);
        }
    }

    @Transactional
    public void updateCustomer(Customer customer)
    {
        this.customerDao.updateCustomer(customer);
        if(this.listCustomers().contains(customer))
        {
            System.err.println("Service UPDATE in IF");
            this.customerDao.updateCustomer(customer);
        }
        else
        {
            System.err.println("Service UPDATE in ELSE");
            this.customerDao.addCustomer(customer);
        }
    }

    @Transactional
    public void removeCustomer(String id) {this.customerDao.removeCustomer(id);}

    @Transactional
    public Customer getCustomerById(String id) {return this.customerDao.getCustomerById(id);}

}
