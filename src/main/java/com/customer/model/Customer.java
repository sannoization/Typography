package com.customer.model;

import com.purchaseorder.model.Purchaseorder;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Objects;

/**
 * Entity class for customer table
 */

@Entity
@Embeddable
@Table(name = "customer")
public class Customer
{
    public Customer() {}

    @Id
    @Column(name = "passport", length = 10)
    @NotBlank(message = "enter passport")
    @Pattern(regexp = "[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]", message = "passport must be 10 numbers")
    private String passport;

    @Column(name = "namecustomer")
    @NotBlank(message = "enter name")
    @Size(max = 30, message = "name must be less than 30 characters")
    private String namecustomer;

    @Column(name = "patronymiccustomer")
    @NotBlank(message = "enter patronymic")
    @Size(max = 30, message = "patronymic must be less than 30 characters")
    private String patronymiccustomer;

    @Column(name = "lastnamecustomer")
    @NotBlank(message = "enter last name")
    @Size(max = 30, message = "last name must be less than 30 characters")
    private String lastnamecustomer;

    @Column(name = "phone", length = 10)
    @NotBlank(message = "enter phone")
    @Pattern(regexp = "[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]", message = "phone must be 10 numbers")
    private String phone;

    /**
     *  Many-to-many with purchaseorder
     *  join to OrderList
     */

    @ManyToMany
    @JoinTable(name = "orderlist",
            joinColumns = @JoinColumn(name = "customer"),
            inverseJoinColumns = @JoinColumn(name = "numoforder"))
    private List <Purchaseorder> purchaseorders;

    /**
     * Getters, Setters
     */

    public List<Purchaseorder> getPurchaseorders()
    {
        return purchaseorders;
    }

    public void setPurchaseorders(List<Purchaseorder> purchaseorders)
    {
        this.purchaseorders = purchaseorders;
    }

    public String getPassport()
    {
        return passport;
    }

    public void setPassport(String passport)
    {
        this.passport = passport;
    }

    public String getNamecustomer()
    {
        return namecustomer;
    }

    public void setNamecustomer(String namecustomer)
    {
        this.namecustomer = namecustomer;
    }

    public String getPatronymiccustomer()
    {
        return patronymiccustomer;
    }

    public void setPatronymiccustomer(String patronymiccustomer)
    {
        this.patronymiccustomer = patronymiccustomer;
    }

    public String getLastnamecustomer()
    {
        return lastnamecustomer;
    }

    public void setLastnamecustomer(String lastnamecustomer)
    {
        this.lastnamecustomer = lastnamecustomer;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    /**
     * Override toString() for logging
     */

    @Override
    public String toString()
    {
        return "Customer{ " +
                "passport='" + passport + '\'' +
                ", firstname='" + namecustomer + '\'' +
                ", patronymic='" + patronymiccustomer + '\'' +
                ", lastname='" + lastnamecustomer + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    /**
     * Override equals() and hashCode()
     */

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (!(o instanceof com.customer.model.Customer))
            return false;
        com.customer.model.Customer customer = (com.customer.model.Customer) o;
        return Objects.equals(getPassport(), customer.getPassport());
    }

    @Override
    public int hashCode()
    {
        int result = passport.hashCode();
        result = 31 * result + namecustomer.hashCode();
        result = 31 * result + patronymiccustomer.hashCode();
        result = 31 * result + lastnamecustomer.hashCode();
        result = 31 * result + phone.hashCode();
        return result;
    }
}