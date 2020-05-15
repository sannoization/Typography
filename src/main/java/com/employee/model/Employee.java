package com.employee.model;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Objects;

/**
 * Entity class for employee table
 */

@Entity
@Embeddable
@Table(name = "employee")
public class Employee
{

    @Id
    @Column(name = "passport", length = 10)
    @NotBlank(message = "enter passport")
    @Pattern(regexp = "[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]", message = "passport must be 10 numbers")
    private String passport;

    @Column(name = "nameemployee")
    @NotBlank(message = "enter name")
    @Size(max = 30, message = "name must be less than 30 characters")
    private String nameemployee;

    @Column(name = "lastnameemployee")
    @NotBlank(message = "enter last name")
    @Size(max = 30, message = "last name must be less than 30 characters")
    private String lastnameemployee;

    @Column(name = "patronymicemployee")
    @NotBlank(message = "enter patronymic")
    @Size(max = 30, message = "patronymic must be less than 30 characters")
    private String patronymicemployee;

    @Column(name = "phone")
    @NotBlank(message = "enter phone")
    @Pattern(regexp = "8\\([0-9]{3}\\)[0-9]{3}-[0-9]{2}-[0-9]{2}", message = "fill phone like example")
    private String phone;

    /**
     * Getters, Setters
     */

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getNameemployee() {
        return nameemployee;
    }

    public void setNameemployee(String firstname) {
        this.nameemployee = firstname;
    }

    public String getPatronymicemployee()
    {
        return patronymicemployee;
    }

    public void setPatronymicemployee(String patronymicemployee)
    {
        this.patronymicemployee = patronymicemployee;
    }

    public String getLastnameemployee() {
        return lastnameemployee;
    }

    public void setLastnameemployee(String lastname) {
        this.lastnameemployee = lastname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Employee() { }

    /**
     * Override toString() for logging
     */

    @Override
    public String toString() {
        return "Employee{ " +
                "passport='" + passport +'\'' +
                ", firstname='" + nameemployee + '\'' +
                ", patronymic='"+ patronymicemployee + '\''+
                ", lastname='" + lastnameemployee + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    /**
     * Override equals() and hashCode()
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return Objects.equals(getPassport(), employee.getPassport());
    }

    @Override
    public int hashCode() {
        int result = passport.hashCode();
        result = 31 * result + nameemployee.hashCode();
        result = 31 * result + patronymicemployee.hashCode();
        result = 31 * result + lastnameemployee.hashCode();
        result = 31 * result + phone.hashCode();
        return result;
    }
}

