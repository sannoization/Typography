package com.complexquery;

import com.customer.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ComplexQueryService
{
    @Autowired
    private ComplexQueryDao complexQueryDao;

    public void setComplexQueryDao(ComplexQueryDao complexQueryDao)
    {
        this.complexQueryDao = complexQueryDao;
    }

    @Transactional
    public List<Object> cashEmployees()
    {
        return this.complexQueryDao.cashEmployees();
    }

    @Transactional
    public List<Object> JoinTable1()
    {
        return this.complexQueryDao.JoinTable1();
    }
}
