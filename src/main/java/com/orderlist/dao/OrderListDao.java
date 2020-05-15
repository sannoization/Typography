package com.orderlist.dao;

import com.orderlist.model.Orderlist;
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
public class OrderListDao
{
    /**
     * Session Factory + Setter
     */

    @Autowired
    private SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sf)
    {
        this.sessionFactory = sf;
    }

    /**
     * Logging
     */

    Logger logger = Logger.getLogger(OrderListDao.class.getName());

    /**
     * List of Orders with customers
     * @return
     */

    public List<Orderlist> listOrderLists()
    {
        Session session = this.sessionFactory.getCurrentSession();
        List<Orderlist> orderlistList =
                session.createQuery("select p from Orderlist p").list();

        for(Orderlist p: orderlistList)
        {

            logger.info(p.toString());
        }
        return orderlistList;
    }

    /**
     * Add New Order
     * @param orderList
     */
    public void addOrderList(Orderlist orderList) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(orderList);
        logger.info("orderList added: " + orderList);
    }

    /**
     * Update Order
     * @param c
     */
    public void updateOrderList(Orderlist c) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(c);
        logger.info("orderList updated: " + c);
    }

    /**
     * Remove Order
     * @param numoforder
     */
    public void removeOrderList(String numoforder) {
        Session session = this.sessionFactory.getCurrentSession();
        List<Orderlist> orderlistList =
                session.createQuery("select c from Orderlist c where c.numoforder =" + "'"+numoforder+"'").list();

        for (Orderlist c : orderlistList)
        {
            session.delete(c);
            logger.info("orderList removed: " + c);
        }
    }

    /**
     * Get Order By id
     * @param numoforder
     * @return orderList
     */
    public Orderlist getOrderListById(String numoforder) {
        Session session = this.sessionFactory.getCurrentSession();
        Orderlist orderList = new Orderlist();
        List<Orderlist> orderlistList =
                session.createQuery("select c from Orderlist c where c.numoforder ="+"'"+numoforder+"'").list();
        for (Orderlist c : orderlistList)
        {
            orderList =c;
        }

        logger.info("OrderList found: " + orderList);

        return orderList;
    }
}
