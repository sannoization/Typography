package com.orderlist.model;

import com.customer.model.Customer;
import com.purchaseorder.model.Purchaseorder;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * Entity class for orderlist table
 */

@Entity
@Embeddable
@Table(name = "orderlist")
public class Orderlist implements Serializable
{
    public Orderlist() {}

    @Id
    @Column(name = "numoforder")
    @NotBlank(message = "enter number of order")
    @Size(min = 1, max = 5, message = "number should be between 1 and 5 characters")
    private String numoforder;

    @Id
    @Column(name = "customer",length = 10)
    @NotBlank(message = "enter customer passport")
    @Pattern(regexp = "[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]", message = "passport must be 10 numbers")
    private String customer;

    /**
     * Getters, Setters
     */

    public String getNumoforder()
    {
        return numoforder;
    }

    public void setNumoforder(String numoforder)
    {
        this.numoforder = numoforder;
    }

    public String getCustomer()
    {
        return customer;
    }

    public void setCustomer(String customer)
    {
        this.customer = customer;
    }

    /**
     * Override equals() and hashCode()
     */

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (!(o instanceof Orderlist))
            return false;
        Orderlist orderList = (Orderlist) o;
        return Objects.equals(getNumoforder(), orderList.getNumoforder());
    }

    @Override
    public int hashCode()
    {
        int result = numoforder.hashCode();
        result = 31 * result +customer.hashCode();
        return result;
    }

    /**
     * Override toString() for logging
     */

    @Override
    public String toString()
    {
        return "OrderList{" +
                "numoforder=" + numoforder +
                ", customer=" + customer +
                '}';
    }
}
