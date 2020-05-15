package com.service.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Objects;

/**
 * Entity class for service table
 */

@Entity
@Embeddable
@Table( name = "service")
public class ServiceEntity
{
    public ServiceEntity() {}

    @Id
    @Column(name = "partnumber", length = 5)
    @NotBlank(message = "enter number of part")
    @Pattern(regexp = "[0-9][0-9][0-9][0-9]", message = "service number must be 4 numbers")
    private String partnumber;

    @Column(name = "name")
    @NotBlank(message = "enter name")
    @Size(max = 30, message = "name should be less than 30 characters")
    private String name;

    @Column(name = "price")
    @NotNull(message = "enter price")
    @PositiveOrZero(message = "price should be positive or zero")
    private Long price;

    @Column(name = "amount")
    @NotNull(message = "enter how many")
    @Positive(message = "price should be positive or zero")
    private Integer amount;

    @Column(name = "material")
    @NotBlank(message = "enter material")
    @Size(max = 30, message = "should be less than 30 characters")
    private String material;

    @Column(name = "options")
    @NotBlank(message = "enter number of part")
    @Size(max = 100, message = "options should be less than 100 characters")
    private String options;

    /**
     * Getters, Setters
     */

    public String getPartnumber()
    {
        return partnumber;
    }

    public void setPartnumber(String partnumber)
    {
        this.partnumber = partnumber;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Long getPrice()
    {
        return price;
    }

    public void setPrice(Long price)
    {
        this.price = price;
    }

    public Integer getAmount()
    {
        return amount;
    }

    public void setAmount(Integer amount)
    {
        this.amount = amount;
    }

    public String getMaterial()
    {
        return material;
    }

    public void setMaterial(String material)
    {
        this.material = material;
    }

    public String getOptions()
    {
        return options;
    }

    public void setOptions(String options)
    {
        this.options = options;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (!(o instanceof ServiceEntity))
            return false;
        ServiceEntity serviceEntity = (ServiceEntity) o;
        return Objects.equals(getPartnumber(), serviceEntity.getPartnumber());
    }

    @Override
    public int hashCode()
    {
        int result = partnumber.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + material.hashCode();
        result = 31 * result + price.hashCode();
        result = 31 * result + amount.hashCode();
        result = 31 * result + options.hashCode();
        return result;
    }

    @Override
    public String toString()
    {
        return "Service{" +
                "partnumber='" + partnumber + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", amount=" + amount +
                ", material='" + material + '\'' +
                ", options='" + options + '\'' +
                '}';
    }
}
