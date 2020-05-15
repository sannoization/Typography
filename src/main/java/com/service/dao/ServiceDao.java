package com.service.dao;

import com.service.model.ServiceEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.logging.Logger;
import java.util.List;

/**
 * DAO for OrderList Model
 */

@Repository
public class ServiceDao
{
    /**
     * Session Factory + Setter
     */
    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory)
    {
        this.sessionFactory = sessionFactory;
    }

    /**
     * Logging
     */

    Logger logger = Logger.getLogger(com.service.dao.ServiceDao.class.getName());

    /**
     * List on page
     * @return
     */
    public List <ServiceEntity> listService()
    {
        Session session = this.sessionFactory.getCurrentSession();
        List <ServiceEntity> serviceEntityList =
                session.createQuery("select p from ServiceEntity p").list();
        for(ServiceEntity p: serviceEntityList)
        {

            logger.info(p.toString());
        }
        return serviceEntityList;
    }

    /**
     * Add service
     * @param serviceEntity
     */
    public void addService(ServiceEntity serviceEntity)
    {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(serviceEntity);

        logger.info("service added: " + serviceEntity);
    }

    /**
     * Update Service
     * @param serviceEntity
     */
    public void updateService(ServiceEntity serviceEntity)
    {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(serviceEntity);

        logger.info("service updated: " + serviceEntity);
    }

    /**
     * Remove Service
     * @param id
     */
    public void removeService(String id)
    {
        Session session = this.sessionFactory.getCurrentSession();
        List <ServiceEntity> serviceEntityList =
                session.createQuery("select s from ServiceEntity s where s.partnumber ="+"'"+id+"'").list();
        for (ServiceEntity s: serviceEntityList)
        {
            session.delete(s);
            logger.info("service removed: " + s);
        }
    }

    /**
     * Get Service by Id
     * @param id
     * @return serviceEntity
     */
    public ServiceEntity getServiceById(String id)
    {
        Session session = this.sessionFactory.getCurrentSession();
        ServiceEntity serviceEntity = new ServiceEntity();
        List <ServiceEntity> serviceEntityList =
                session.createQuery("select  c from ServiceEntity c where c.partnumber ="+"'"+id+"'").list();
        for (ServiceEntity c: serviceEntityList)
        {
            serviceEntity = c;
        }
        logger.info("service found: " + serviceEntity);
        return serviceEntity;
    }
}
