package com.complexquery;


import com.customer.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Controller for Complex Queries
 */
@Controller
public class ComplexQueryController
{

    private ComplexQueryService complexQueryService;

    @Autowired
    @Qualifier(value = "complexqueryService")
    public void setComplexQueryService(ComplexQueryService complexQueryService)
    {
        this.complexQueryService = complexQueryService;
    }

    /**
     * Cash Employee
     * @param model
     * @return qcashemployees
     */
    @RequestMapping(value = "qcashemployees", method = RequestMethod.GET)
    public String cashEmployees(Model model)
    {
        model.addAttribute("CashEmployees", this.complexQueryService.cashEmployees());
        return "qcashemployees";
    }

    /**
     * Join Query
     * @param model
     * @return qjointable1
     */
    @RequestMapping(value = "qjointable1", method = RequestMethod.GET)
    public String JoinTable1(Model model)
    {
        model.addAttribute("customer", new Customer());
        model.addAttribute("JoinTable1", this.complexQueryService.JoinTable1());
        return "qjointable1";
    }
}
