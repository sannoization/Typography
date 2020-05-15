package com.customer.client;

import com.customer.model.Customer;
import com.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Controller for Customer
 */

@Controller
public class CustomerController
{
    private CustomerService customerService;

    @Autowired
    @Qualifier(value = "customerService")
    public void setCustomerService(CustomerService ps) {this.customerService = ps;}

    /**
     * List on the page
     */

    @RequestMapping(value = "customers", method = RequestMethod.GET)
    public String listCustomers(Model model)
    {
        model.addAttribute("customer", new Customer());
        model.addAttribute("listCustomers", this.customerService.listCustomers());
        return "customers";
    }

    /**
     *  add customer to model
     */

    @RequestMapping(value = "/customers/add", method = RequestMethod.POST)
    public String addCustomer(@Valid @ModelAttribute("customer") Customer customer, BindingResult result)
    {
        try
        {
            if(result.hasErrors())
            {
                return "customers";
            }
            if(!customerService.listCustomers().contains(customer))
            {
                System.err.println("Controller ADD in IF");
                this.customerService.addCustomer(customer);
            }
            else
            {
                System.err.println("Controller ADD in ELSE");
                this.customerService.updateCustomer(customer);
            }
            return "redirect:/customers";
        }
        catch (Exception e)
        {
            return "errorcustomer";
        }
    }

    /**
     * Remove Customer by passport
     */

    @RequestMapping("/removecustomer/{passport}")
    public String removeCustomer(@PathVariable("passport") String passport)
    {
        try
        {
            this.customerService.removeCustomer(passport);
            return "redirect:/customers";
        }
        catch (Exception e)
        {
            return "errorcustomer";
        }

    }

    /**
     * edit Customer
     */

    @RequestMapping("/editcustomer/{passport}")
    public String updateCustomer(@PathVariable("passport") String passport, Model model)
    {
        try
        {
            model.addAttribute("customer", this.customerService.getCustomerById(passport));
            model.addAttribute("listcustomers", this.customerService.listCustomers());
            System.err.println("Controller UPDATED");
            return "customers";
        }
        catch (Exception e)
        {
            return "errorcustomer";
        }
    }

    /**
     * Customer data on the other jsp-page
     */

    @RequestMapping("customerdata/{passport}")
    public String customerData(@PathVariable("passport") String passport, Model model)
    {
        model.addAttribute("customer", this.customerService.getCustomerById(passport));

        return "customerdata";
    }
}
