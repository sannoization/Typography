package com.customer.dao;

import com.customer.model.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.logging.Logger;
import java.util.List;

/**
 * DAO for Customer Model
 */

@Repository
public class CustomerDao
{
    /**
     * Session Factory + Setter
     */

    @Autowired
    private SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sf)
    {
        this.sessionFactory = sf;
    }

    /**
     * Logging
     */
    Logger logger = Logger.getLogger(com.customer.dao.CustomerDao.class.getName());

    /**
     * List Customers
     * @return customerList
     */

    public List<Customer> listCustomers()
    {
        Session session = this.sessionFactory.getCurrentSession();
        List<Customer> customerList =
                session.createQuery("SELECT p FROM Customer p").list();
        for(Customer p: customerList)
        {
            logger.info(p.toString());
        }
        return customerList;
    }

    /**
     * Add customer
     * @param customer
     */
    public void addCustomer(Customer customer)
    {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(customer);
        logger.info("customer added: " + customer);
    }

    /**
     * Update Customer
     * @param customer
     */

    public void updateCustomer(Customer customer)
    {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(customer);
        logger.info("customer updated: " + customer);
    }

    /**
     * Remove Customer
     * @param id
     */

    public void removeCustomer(String id)
    {
        Session session = this.sessionFactory.getCurrentSession();
        List <Customer> customerList =
                session.createQuery("select c from Customer c where c.passport =" + "'"+id+"'").list();
        for(Customer c : customerList)
        {
            session.delete(c);
            logger.info("customer removed: " + c);
        }
    }

    /**
     * Get customer by passport
     * @param id
     * @return customer
     */
    public Customer getCustomerById(String id)
    {
        Session session = this.sessionFactory.getCurrentSession();
        Customer customer = new Customer();
        List <Customer> customerList =
                session.createQuery("select  c from Customer c where c.passport ="+"'"+id+"'").list();
        for (Customer c : customerList)
        {
            customer =c;
        }

        logger.info("Customer found: " + customer);

        return customer;
    }
}



