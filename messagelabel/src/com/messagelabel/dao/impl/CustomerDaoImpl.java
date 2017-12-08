package com.messagelabel.dao.impl;

import com.messagelabel.dao.BaseDao;
import com.messagelabel.dao.CustomerDao;
import com.messagelabel.entity.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by quyuan on 2017/10/25.
 */
public class CustomerDaoImpl extends BaseDao implements CustomerDao {


    @Override
    public int add(String name) {
        String sql = "INSERT INTO customer (name) VALUES (?)";
        Object[] param = {name};
        int result = this.exceuteUpdate(sql, param);
        return result;
    }

    @Override
    public int getLastId() {
        String sql = "select * from customer where id=(select max(id) from customer)";
        ResultSet rs = this.executeQuery(sql);
        try {
            if (rs.next()) {
               return rs.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll(null, null, rs);
        }
        return 0;
    }

    @Override
    public int updateCount(int id) {
        String sql = "UPDATE customer SET count = count+1 WHERE ID = ?";
        Object[] param = {id};
        int result = this.exceuteUpdate(sql, param);
        return result;
    }

    @Override
    public int getCount(int id) {
        String sql = "select * from customer where id=?";
        Object[] param = {id};
        ResultSet rs = this.executeQuery(sql, param);
        try {
            if (rs.next()) {
                return rs.getInt("count");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll(null, null, rs);
        }
        return 0;
    }
}
