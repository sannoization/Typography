package com.purchaseorder.model;

import com.customer.model.Customer;
import com.employee.model.Employee;
import com.service.model.ServiceEntity;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.sql.Date;
import java.util.List;
import java.util.Objects;

/**
 * Entity class for purchaseorder table
 */

@Entity
@Embeddable
@Table(name = "purchaseorder")
public class Purchaseorder
{
    public Purchaseorder() {}

    @Id
    @Column(name = "number")
    @NotBlank(message = "enter number")
    @Size(min = 1, max = 5, message = "number should be between 1 and 5 characters")
    private String number;

    @Column(name = "placementdate")
    private Date placementdate;

    @Column(name = "exercisedate")
    private Date exercisedate;

    @Column(name = "price")
    @NotNull(message = "enter price")
    private Long price;

    @Column(name = "service")
    @NotBlank(message = "enter phone")
    @Pattern(regexp = "[0-9][0-9][0-9][0-9]", message = "service must be 4 numbers")
    private String service;

    @Column(name = "employee")
    @NotBlank(message = "enter number")
    @Pattern(regexp = "[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]", message = "passport must be 10 numbers")
    private String employee;

    /**
     * One-to-many with Service Entity by partnumber
     */

    @OneToMany(mappedBy = "partnumber", cascade = CascadeType.REMOVE)
    private List <ServiceEntity> serviceEntities;

    /**
     * One-to-many with Employee by passport
     */

    @OneToMany(mappedBy = "passport", cascade = CascadeType.REMOVE)
    private List <Employee> employees;

    /**
     *  Many-to-many with Customer
     *  join to OrderList
     */

    @ManyToMany
    @JoinTable(name = "orderlist",
            joinColumns = @JoinColumn(name = "numoforder"),
            inverseJoinColumns = @JoinColumn(name = "customer"))
    private List <Customer> customers;

    /**
     * Getters, Setters
     */

    public List<Customer> getCustomers()
    {
        return customers;
    }

    public void setCustomers(List<Customer> customers)
    {
        this.customers = customers;
    }

    public List<Employee> getEmployees()
    {
        return employees;
    }

    public void setEmployees(List<Employee> employees)
    {
        this.employees = employees;
    }

    public List <ServiceEntity> getServiceEntities()
    {
        return serviceEntities;
    }

    public void setServiceEntities(List <ServiceEntity> serviceEntities)
    {
        this.serviceEntities = serviceEntities;
    }


    public String getNumber()
    {
        return number;
    }

    public void setNumber(String number)
    {
        this.number = number;
    }

    public Date getPlacementdate()
    {
        return placementdate;
    }

    public void setPlacementdate(Date placementdate)
    {
        this.placementdate = placementdate;
    }

    public Date getExercisedate()
    {
        return exercisedate;
    }

    public void setExercisedate(Date exercisedate)
    {
        this.exercisedate = exercisedate;
    }

    public Long getPrice()
    {
        return price;
    }

    public void setPrice(Long price)
    {
        this.price = price;
    }

    public String getService()
    {
        return service;
    }

    public void setService(String service)
    {
        this.service = service;
    }

    public String getEmployee()
    {
        return employee;
    }

    public void setEmployee(String employee)
    {
        this.employee = employee;
    }

    /**
     * Override equals() and hashCode()
     */

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (!(o instanceof com.purchaseorder.model.Purchaseorder))
            return false;
        com.purchaseorder.model.Purchaseorder purchaseorder = (com.purchaseorder.model.Purchaseorder) o;
        return Objects.equals(getNumber(), purchaseorder.getNumber());
    }

    @Override
    public int hashCode()
    {
        int result = number.hashCode();
        result = 31 * result + placementdate.hashCode();
        result = 31 * result + exercisedate.hashCode();
        result = 31 * result + price.hashCode();
        result = 31 * result + service.hashCode();
        result = 31 * result + employee.hashCode();
        return result;
    }

    /**
     * Override toString() for logging
     */

    @Override
    public String toString()
    {
        return "Purchaseorder{" +
                "number=" + number +
                ", placementdate=" + placementdate +
                ", exercisedate=" + exercisedate +
                ", price=" + price +
                ", service='" + service + '\'' +
                ", employee='" + employee + '\'' +
                '}';
    }
}
