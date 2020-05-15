package com.service.client;

import com.service.model.ServiceEntity;
import com.service.service.ServiceService;
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
 * Controller for Service
 */

@Controller
public class ServiceController
{
    private ServiceService serviceService;

    @Autowired
    @Qualifier(value = "serviceService")
    public void setServiceService(ServiceService serviceService)
    {
        this.serviceService = serviceService;
    }

    /**
     * List on the page
     */

    @RequestMapping(value ="serviceentity", method = RequestMethod.GET)
    public String listService(Model model) {
        model.addAttribute("serviceentity", new ServiceEntity());
        model.addAttribute("listservice", this.serviceService.listService());
        return "serviceentity";
    }

    /**
     *  add Service to model
     */

    @RequestMapping(value = "/serviceentity/add", method = RequestMethod.POST)
    public String addService(@Valid @ModelAttribute("serviceentity") ServiceEntity serviceEntity, BindingResult result)
    {
        try
        {
            if(result.hasErrors())
            {
                return "serviceentity";
            }
            if(!serviceService.listService().contains(serviceEntity))
            {
                System.err.println("Controller ADD in IF");
                this.serviceService.addService(serviceEntity);
            }
            else
            {
                System.err.println("Controller ADD in ELSE");
                this.serviceService.updateService(serviceEntity);
            }
            return "redirect:/serviceentity";
        }
        catch (Exception e)
        {
            return "errorservice";
        }
    }

    /**
     * Remove Service by part number
     */

    @RequestMapping("/removeserviceentity/{partnumber}")
    public String removeService(@PathVariable("partnumber") String partnumber)
    {
        try
        {
            this.serviceService.removeService(partnumber);
            return "redirect:/serviceentity";
        }
        catch (Exception e)
        {
            return "errorservice";
        }
    }

    /**
     * edit Service
     */

    @RequestMapping("/editserviceentity/{partnumber}")
    public String updateService(@PathVariable("partnumber") String partnumber, Model model)
    {
        try
        {
            model.addAttribute("serviceentity", this.serviceService.getServiceById(partnumber));
            model.addAttribute("listservice", this.serviceService.listService());
            System.err.println("Controller UPDATED");
            return "serviceentity";
        }
        catch (Exception e)
        {
            return "errorservice";
        }
    }

    /**
     * Service data on the other jsp-page
     */
    @RequestMapping("servicedata/{partnumber}")
    public String serviceData(@PathVariable("partnumber") String partnumber, Model model)
    {
        model.addAttribute("serviceentity", this.serviceService.getServiceById(partnumber));

        return "servicedata";
    }
}
