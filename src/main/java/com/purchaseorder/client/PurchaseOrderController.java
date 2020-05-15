package com.purchaseorder.client;

import com.purchaseorder.model.Purchaseorder;
import com.purchaseorder.service.PurchaseOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Controller for Purchaseorder
 */

@Controller
public class PurchaseOrderController
{
    private PurchaseOrderService purchaseOrderService;

    @Autowired
    @Qualifier(value = "purchaseorderService")
    public void setPurchaseOrderService(PurchaseOrderService purchaseOrderService)
    {
        this.purchaseOrderService = purchaseOrderService;
    }

    /**
     * List on the page
     */

    @RequestMapping(value = "purchaseorder", method = RequestMethod.GET)
    public String listPurchaseorder(Model model)
    {
        model.addAttribute("purchaseorder", new Purchaseorder());
        model.addAttribute("listpurchaseorder", this.purchaseOrderService.listPurchaseorder());
        return "purchaseorder";
    }

    /**
     *  add Order to model
     */

    @RequestMapping(value = "purchaseorder/add", method = RequestMethod.POST)
    public String addPurchaseorder(@Valid @ModelAttribute("purchaseorder") Purchaseorder purchaseorder, BindingResult result)
    {
        try
        {
            if(result.hasErrors())
            {
                return "purchaseorder";
            }
            if(!purchaseOrderService.listPurchaseorder().contains(purchaseorder))
            {
                System.err.println("Controller ADD in IF");
                this.purchaseOrderService.addPurchaseorder(purchaseorder);
            }
            else
            {
                System.err.println("Controller ADD in ELSE");
                this.purchaseOrderService.updatePurchaseorder(purchaseorder);

            }
            return "redirect:/purchaseorder";
        }
        catch (Exception e)
        {
            return "errorpurchaserorder";
        }
    }

    /**
     * edit Order
     */

    @RequestMapping("/editorder/{number}")
    public String updatePurchaseorder(@PathVariable("number") String number, Model model)
    {
        try
        {
            model.addAttribute("purchaseorder",this.purchaseOrderService.getPurchaseorderById(number));
            model.addAttribute("listpurchaseorder", this.purchaseOrderService.listPurchaseorder());

            System.err.println("controller UPDATED");
            return "purchaseorder";
        }
        catch (Exception e)
        {
            return "errorpurchaserorder";
        }
    }

    /**
     * Remove Order by number of order
     */

    @RequestMapping("/removeorder/{number}")
    public String removePurchaseorder(@PathVariable("number") String number)
    {
        try
        {
            this.purchaseOrderService.removePurchaseorder(number);
            return "redirect:/purchaseorder";
        }
        catch (Exception e)
        {
            return "errorpurchaserorder";
        }
    }

    /**
     * Order data on the other jsp-page
     */

    @RequestMapping("purchaseorderdata/{number}")
    public String purchaseorderdata(@PathVariable("number") String number, Model model)
    {
        model.addAttribute("purchaseorder", this.purchaseOrderService.getPurchaseorderById(number));
        return "purchaseorderdata";
    }
}
