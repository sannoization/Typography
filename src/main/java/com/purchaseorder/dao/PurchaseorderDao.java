package com.purchaseorder.dao;

import com.purchaseorder.model.Purchaseorder;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.logging.Logger;
import java.util.List;

/**
 * DAO for order Model
 */

@Repository
public class PurchaseorderDao
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

    Logger logger = Logger.getLogger(com.purchaseorder.model.Purchaseorder.class.getName());

    /**
     * List on the page
     */

    public List<Purchaseorder> listPurchaseorder()
    {
        Session session = this.sessionFactory.getCurrentSession();
        List<Purchaseorder> purchaseorderList =
                session.createQuery("select p from Purchaseorder p").list();

        for (Purchaseorder p: purchaseorderList)
        {
            logger.info(p.toString());
        }
        return purchaseorderList;
    }

    /**
     * Add New order
     * @param purchaseorder
     */
    public void addPurchaseorder(Purchaseorder purchaseorder)
    {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(purchaseorder);
        logger.info("purchaseorder added: " + purchaseorder);
    }

    /**
     * Update order
     * @param purchaseorder
     */
    public void updatePurchaseorder(Purchaseorder purchaseorder)
    {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(purchaseorder);
        logger.info("purchaseorder updated: " + purchaseorder);
    }

    /**
     * Remove Order
     * @param number
     */
    public void removePurchaseorder(String number)
    {
        Session session = this.sessionFactory.getCurrentSession();
        List<Purchaseorder> purchaseorderList =
                session.createQuery("select c from Purchaseorder c where c.number =" + "'" + number + "'").list();
        for (Purchaseorder c: purchaseorderList)
        {
            session.delete(c);
            logger.info("purchase order removed: " + c);
        }
    }

    /**
     * Get order by Number
     * @param number
     * @return purchaseorder
     */
    public Purchaseorder getPurchaseorderById(String number)
    {
        Session session = this.sessionFactory.getCurrentSession();
        Purchaseorder purchaseorder = new Purchaseorder();
        List<Purchaseorder> purchaseorderList =
                session.createQuery("select c from Purchaseorder c where c.number =" + "'" + number + "'").list();
        for (Purchaseorder c: purchaseorderList)
        {
            purchaseorder = c;
        }
        logger.info("Purchaseorder found: " + purchaseorder);
        return purchaseorder;
    }
}
