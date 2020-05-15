package com.complexquery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


@Repository
public class ComplexQueryDao
{
    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory)
    {
        this.sessionFactory = sessionFactory;
    }
    Logger logger = Logger.getLogger(ComplexQueryDao.class.getName());

    /**
     * Join Query
     * @return joinTable
     */
    public  List<Object> JoinTable1()
    {
        Session session = this.sessionFactory.getCurrentSession();
        List<Object> joinTable =
                session.createQuery("select new List (ol.numoforder, c.namecustomer, c.lastnamecustomer,s.name,o.price) " +
                        "from Orderlist ol, Purchaseorder o, ServiceEntity s, Customer c " +
                        "where (ol.numoforder = o.number and o.service = s.partnumber and ol.customer = c.passport)").list();
        for (Object p: joinTable)
        {
            logger.info("joinTable Successful: "+p.toString());
        }
        return joinTable;
    }

    /**
     * Sum cash of employees
     * @return cashEmployee
     */
    public List<Object> cashEmployees()
    {
        Session session = this.sessionFactory.getCurrentSession();
        List <Object> cashEmployee = (List)
               session.createQuery("SELECT new List(SUM(p.price), s.nameemployee, s.lastnameemployee) " +
                    "FROM Employee s, Purchaseorder p " +
                    "WHERE (p.employee = s.passport) " +
                    "GROUP BY s.nameemployee, s.lastnameemployee").list();

        for (Object p: cashEmployee)
        {
            logger.info("selected cash of employees"+p.toString());
        }
        return cashEmployee;
    }
}
