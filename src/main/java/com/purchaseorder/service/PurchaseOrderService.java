package com.purchaseorder.service;

import com.purchaseorder.model.Purchaseorder;
import com.purchaseorder.dao.PurchaseorderDao;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.*;

import java.util.List;

@Service
public class PurchaseOrderService
{
    @Autowired
    private PurchaseorderDao purchaseorderDao;

    public void setPurchaseorderDao(PurchaseorderDao purchaseorderDao)
    {
        this.purchaseorderDao = purchaseorderDao;
    }

    @Transactional
    public List <Purchaseorder> listPurchaseorder()
    {
        return this.purchaseorderDao.listPurchaseorder();
    }

    @Transactional
    public void addPurchaseorder(Purchaseorder purchaseorder)
    {
        this.purchaseorderDao.addPurchaseorder(purchaseorder);

        if(!listPurchaseorder().contains(purchaseorder))
        {
            System.err.println("Service ADD in IF");
            this.purchaseorderDao.addPurchaseorder(purchaseorder);
        }
        else
        {
            System.err.println("Service ADD in ELSE");
            this.purchaseorderDao.updatePurchaseorder(purchaseorder);
        }
    }

    @Transactional
    public void updatePurchaseorder(Purchaseorder purchaseorder)
    {
        this.purchaseorderDao.updatePurchaseorder(purchaseorder);
        if(this.listPurchaseorder().contains(purchaseorder))
        {
            System.err.println("Service UPDATE in IF");
            this.purchaseorderDao.updatePurchaseorder(purchaseorder);
        }
        else
        {
            System.err.println("Service UPDATE in ELSE");
            this.purchaseorderDao.addPurchaseorder(purchaseorder);
        }
    }

    @Transactional
    public void removePurchaseorder(String number)
    {
        this.purchaseorderDao.removePurchaseorder(number);
    }

    @Transactional
    public Purchaseorder getPurchaseorderById(String number)
    {
        return this.purchaseorderDao.getPurchaseorderById(number);
    }
}
