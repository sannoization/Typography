package com.orderlist.service;

import com.orderlist.dao.OrderListDao;
import com.orderlist.model.Orderlist;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.*;


import java.util.List;


@Service
public class OrderListService
{
    @Autowired
    private OrderListDao orderListDao;

    public void setOrderListDao(OrderListDao orderListDao)
    {
        this.orderListDao = orderListDao;
    }

    @Transactional
    public List <Orderlist> listOrderLists()
    {
        return this.orderListDao.listOrderLists();
    }

    @Transactional
    public void addOrderList(Orderlist orderList)
    {
        this.orderListDao.addOrderList(orderList);

        if(!listOrderLists().contains(orderList))
        {
            System.err.println("Service ADD in IF");
            this.orderListDao.addOrderList(orderList);
            System.err.println("Service ADD in IF after Dao");
        }
        else
        {
            System.err.println("Service ADD in ELSE");
            this.orderListDao.updateOrderList(orderList);
        }
    }

    @Transactional
    public void updateOrderList(Orderlist orderList)
    {
        this.orderListDao.updateOrderList(orderList);
        if(this.listOrderLists().contains(orderList))
        {
            System.err.println("Service UPDATE in IF");
            this.orderListDao.addOrderList(orderList);
        }
        else
        {
            System.err.println("Service UPDATE in ELSE");
            this.orderListDao.addOrderList(orderList);
        }
    }

    @Transactional
    public void removeOrderList(String numoforder)
    {
        this.orderListDao.removeOrderList(numoforder);
    }

    @Transactional
    public Orderlist getOrderListById(String numoforder)
    {
        return this.orderListDao.getOrderListById(numoforder);
    }
}
