package com.employee.service;

import com.employee.dao.EmployeeDao;
import com.employee.model.Employee;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.*;


import java.util.List;

/**
 * Service For EmployeeDao
 */

@Service
public class EmployeeService
{

    @Autowired()
    private EmployeeDao employeeDao;

    public void setEmployeeDao(EmployeeDao employeeDao)
    {
        this.employeeDao = employeeDao;
    }

    @Transactional
    public List<Employee> listEmployees()
    {
        return this.employeeDao.listEmployees();
    }

    @Transactional
    public void addEmployee(Employee employee)
    {
        this.employeeDao.addEmployee(employee);

       if(!listEmployees().contains(employee))

       {
           System.err.println("Service ADD in IF");
           this.employeeDao.addEmployee(employee);
           System.err.println("Service ADD in IF after Dao");
       }
       else
           {
               System.err.println("Service ADD in ELSE");
              this.employeeDao.updateEmployee(employee);
           }


    }
    @Transactional
    public void updateEmployee(Employee employee)
    {
        this.employeeDao.updateEmployee(employee);

      if(this.listEmployees().contains(employee))
        {
            System.err.println("Service UPDATE in IF");
            this.employeeDao.updateEmployee(employee);
        }
        else
        {
            System.err.println("Service UPDATE in ELSE");
            this.employeeDao.addEmployee(employee);
        }


    }
    @Transactional
    public void removeEmployee(String id)
    {
        this.employeeDao.removeEmployee(id);
    }

    @Transactional
    public Employee getEmployeeById(String passport)
    {
        return this.employeeDao.getEmployeeById(passport);
    }

}
