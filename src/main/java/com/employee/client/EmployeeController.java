package com.employee.client;

import com.employee.model.Employee;
import com.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Controller for Employee
 */

@Controller
public class EmployeeController
{

    private EmployeeService employeeService;

    @Autowired
    @Qualifier(value = "employeeService")
    public void setEmployeeService(EmployeeService ps)
    {
        this.employeeService = ps;
    }


    /**
     * List on the start page
     */

    @RequestMapping(value ="employees", method = RequestMethod.GET)
    public String listEmployees(Model model) {

            model.addAttribute("employee", new Employee());
            model.addAttribute("listEmployees", this.employeeService.listEmployees());

        return "employees";
    }

    /**
     *  add employee to model
     */
    @RequestMapping(value ="/employees/add", method = RequestMethod.POST)
    public String addEmployee(@Valid @ModelAttribute("employee") Employee employee, BindingResult result)
    {
        try
        {
            if (result.hasErrors())
            {
                return "employees";
            }

            if (!employeeService.listEmployees().contains(employee))
            {
                System.err.println("Controller ADD in IF");
                this.employeeService.addEmployee(employee);
            } else
            {
                System.err.println("Controller ADD in ELSE");
                this.employeeService.updateEmployee(employee);
            }
            return "redirect:/employees";
        } catch (Exception e)
        {
            return "erroremployee";
        }
    }

    /**
     * Remove Employee by passport
     */
    @RequestMapping("/remove/{passport}")
    public String removeEmployee(@PathVariable("passport") String passport)
    {
        try
        {
            this.employeeService.removeEmployee(passport);
            return  "redirect:/employees";
        }
        catch (Exception e)
        {
            return "erroremployee";
        }
    }

    /**
     * edit Employee
     */
    @RequestMapping("/edit/{passport}")
    public String updateEmployee(@PathVariable("passport") String passport, Model model)
    {   try
        {
            model.addAttribute("employee", this.employeeService.getEmployeeById(passport));
            model.addAttribute("listemployees", this.employeeService.listEmployees());
            System.err.println("Controller updated");
            return "employees";
        }
        catch (Exception e)
        {
            return "/WEB-INF/pages/erroremployee.jsp";
        }
    }

    /**
     * Employee data on the other jsp-page
     */
    @RequestMapping("employeedata/{id}")
    public String employeeData(@PathVariable("id") String id, Model model){
        model.addAttribute("employee", this.employeeService.getEmployeeById(id));
        return "employeedata";
    }
}

