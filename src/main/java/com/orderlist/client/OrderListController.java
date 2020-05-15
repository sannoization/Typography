package com.orderlist.client;

import com.orderlist.model.Orderlist;
import com.orderlist.service.OrderListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Controller for OrderList
 */

@Controller
public class OrderListController
{
    private OrderListService orderListService;

    @Autowired
    @Qualifier(value = "orderListService")
    public void setOrderListService(OrderListService orderListService)
    {
        this.orderListService = orderListService;
    }

    /**
     * List on the page
     */

    @RequestMapping(value = "orderlist", method = RequestMethod.GET)
    public String listOrderLists(Model model)
    {
        model.addAttribute("orderList", new Orderlist());
        model.addAttribute("listOrderLists", this.orderListService.listOrderLists());
        return "orderlist";
    }

    /**
     *  add OrderList to model
     */

    @RequestMapping(value = "/orderlist/add", method = RequestMethod.POST)
    public String addOrderList(@Valid @ModelAttribute("orderList") Orderlist orderList, BindingResult result)
    {
        try
        {
            if(result.hasErrors())
            {
                return "orderlist";
            }
            if(!orderListService.listOrderLists().contains(orderList))
            {
                System.err.println("Controller ADD in IF");
                this.orderListService.addOrderList(orderList);
            }
            else
            {
                System.err.println("Controller ADD in ELSE");
                this.orderListService.updateOrderList(orderList);
            }
            return "redirect:/orderlist";
        }
        catch (Exception e)
        {
            return "errororderlist";
        }

    }

    /**
     * edit OrderList
     */

    @RequestMapping("/editorderlist/{numoforder}")
    public String updateOrderList(@PathVariable("numoforder") String numoforder, Model model)
    {
        try
        {
            model.addAttribute("orderList", this.orderListService.getOrderListById(numoforder));
            model.addAttribute("listOrderLists", this.orderListService.listOrderLists());

            System.err.println("Controller UPDATED");
            return "orderlist";
        }
        catch (Exception e)
        {
            return "errororderlist";
        }
    }

    /**
     * Remove OrderList by number of order
     */

    @RequestMapping("/removeorderlist/{numoforder}")
    public String removeOrderList(@PathVariable("numoforder") String numoforder)
    {
        try
        {
            this.orderListService.removeOrderList(numoforder);
            return "redirect:/orderlist";
        }
        catch (Exception e)
        {
            return "errororderlist";
        }

    }

    /**
     * Order data on the other jsp-page
     */

    @RequestMapping("orderlistdata/{numoforder}")
    public String orderListData(@PathVariable("numoforder") String numoforder, Model model)
    {
        model.addAttribute("orderList", this.orderListService.getOrderListById(numoforder));

        return "orderlistdata";
    }
}
