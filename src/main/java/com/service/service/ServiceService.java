package com.service.service;

import com.service.model.ServiceEntity;
import com.service.dao.ServiceDao;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.*;

import java.util.List;


@Service
public class ServiceService
{
    @Autowired
    private ServiceDao serviceDao;

    public void setServiceDao(ServiceDao serviceDao)
    {
        this.serviceDao = serviceDao;
    }

    @Transactional
    public List <ServiceEntity> listService() {return this.serviceDao.listService();}

    @Transactional
    public void addService(ServiceEntity serviceEntity)
    {
        this.serviceDao.addService(serviceEntity);

        if(!listService().contains(serviceEntity))
        {
            System.err.println("Service ADD in IF");
            this.serviceDao.addService(serviceEntity);
            System.err.println("Service ADD in IF after Dao");
        }
        else
        {
            System.err.println("Service ADD in ELSE");
            this.serviceDao.updateService(serviceEntity);
        }
    }

    @Transactional
    public void updateService(ServiceEntity serviceEntity)
    {
        this.serviceDao.updateService(serviceEntity);
        if(this.listService().contains(serviceEntity))
        {
            System.err.println("Service UPDATE in IF");
            this.serviceDao.updateService(serviceEntity);
        }
        else
        {
            System.err.println("Service UPDATE in ELSE");
            this.serviceDao.addService(serviceEntity);
        }
    }

    @Transactional
    public void removeService(String id) {this.serviceDao.removeService(id);}

    @Transactional
    public ServiceEntity getServiceById(String id) {return this.serviceDao.getServiceById(id);}



}
