package com.messagelabel.dao;

import com.messagelabel.entity.Customer;

/**
 * Created by quyuan on 2017/10/25.
 */
public interface CustomerDao {

    int add(String name);

    int updateCount(int id);

    int getLastId();

    int getCount(int id);
}
