package com.employee.dao;

import com.employee.model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.logging.Logger;
import java.util.List;

/**
 * DAO for Employee Model
 */

@Repository
public class EmployeeDao
{
    /**
     * Session Factory + Setter
     */

    @Autowired(required = true)
    private SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sf)
    {
        this.sessionFactory = sf;
    }

    /**
     * Logging
     */

    Logger logger = Logger.getLogger(EmployeeDao.class.getName());

    /**
     * List Employee
     * @return employeeList
     */
    public List<Employee> listEmployees()
    {
        Session session = this.sessionFactory.getCurrentSession();
        List<Employee> employeeList =
                session.createQuery("SELECT p FROM Employee p").list();
        for(Employee p: employeeList)
        {

            logger.info(p.toString());
        }
        return employeeList;
    }

    /**
     * Add Employee
     * @param employee
     */

    public void addEmployee(Employee employee) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(employee);
        logger.info("employee added: " + employee);
    }

    /**
     * Update Employee
     * @param c
     */

    public void updateEmployee(Employee c) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(c);
        logger.info("employee updated: " + c);
    }

    /**
     * Remove Employee
     * @param id
     */
    public void removeEmployee(String id) {
        Session session = this.sessionFactory.getCurrentSession();
        List<Employee> employeeList =
                session.createQuery("select c from Employee c where c.passport =" + "'"+id+"'").list();

        for (Employee c : employeeList)
        {
            session.delete(c);
            logger.info("Employee removed: " + c);
        }
    }

    /**
     * Get Employee by passport
     * @param id
     * @return employee
     */

    public Employee getEmployeeById(String id) {
        Session session = this.sessionFactory.getCurrentSession();
        Employee employee = new Employee();
        List<Employee> employeeList =
                session.createQuery("select  c from Employee c where c.passport ="+"'"+id+"'").list();
        for (Employee c : employeeList)
        {
           employee =c;
        }
        logger.info("Employee found: " + employee);
        return employee;
    }


}
