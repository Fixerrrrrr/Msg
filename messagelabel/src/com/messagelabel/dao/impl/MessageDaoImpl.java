package com.messagelabel.dao.impl;

import com.messagelabel.dao.BaseDao;
import com.messagelabel.dao.MessageDao;
import com.messagelabel.entity.Message;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by quyuan on 2017/10/25.
 */
public class MessageDaoImpl extends BaseDao implements MessageDao {
    @Override
    public int updateFlag(int id, int flag) {
        String cur_flag = "Flag" + flag; //
        String sql = "UPDATE message SET " + cur_flag +
                " = 1 WHERE ID = ?";
        Object[] param = {id};
        int result = this.exceuteUpdate(sql, param);
        return result;
    }

    @Override
    public int updateSubmit(int id) {
        String sql = "UPDATE message SET Submit = 1 WHERE ID = ?";
        Object[] param = {id};
        int result = this.exceuteUpdate(sql, param);
        return result;
    }

    @Override
    public Message selectById(int id) {
        String sql = "select * from message where ID=? and submit=0";
        Object[] param = {id};
        ResultSet rs = this.executeQuery(sql, param);
        try {
            if (rs.next()) {
                Message message = new Message();
                message.id = rs.getInt("ID");
                message.text = rs.getString("Text");
                return message;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll(null, null, rs);
        }
        return null;
    }

    @Override
    public Message select(int id) {
        String sql = "select * from message where ID=?";
        Object[] param = {id};
        ResultSet rs = this.executeQuery(sql, param);
        try {
            if (rs.next()) {
                Message message = new Message();
                message.text = rs.getString("Text");
                message.id = rs.getInt("ID");
                return message;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll(null, null, rs);
        }
        return null;
    }

    @Override
    public int deleteFlags(int id) {
        String sql = "update message set Flag1=0,Flag2=0,Flag3=0,Flag4=0,Flag5=0,Flag6=0,Flag7=0,Flag8=0,Flag9=0,Flag10=0,Flag11=0,Flag12=0,Flag13=0," +
                "Flag14=0,Flag15=0,Flag16=0,Flag17=0,Flag18=0,Flag19=0,Flag20=0,Flag21=0,Flag22=0,Flag23=0,Flag24=0,Flag25=0,Flag26=0,Flag27=0,Flag28=0,Flag29=0,Flag30=0,Flag31=0,Flag32=0," +
                "Flag33=0,Flag34=0,Flag35=0,Flag36=0,Flag37=0,Flag38=0,Flag39=0,Flag40=0,Flag41=0,Flag42=0,Flag43=0,Flag44=0,Flag45=0,Flag46=0,Flag47=0,Flag48=0,Flag49=0,Flag50=0,Flag51=0,Flag52=0,Flag53=0,Flag54=0," +
                "Flag55=0,Flag56=0,Flag57=0,Flag58=0,Flag59=0,Flag60=0,Flag61=0,Flag62=0,Flag63=0,Flag64=0,Flag65=0,Flag66=0,Flag67=0,Flag68=0,Flag69=0,Flag70=0,Flag71=0,Flag72=0,Flag73=0,Flag74=0,Flag75=0,Flag76=0,Flag77=0,Flag78=0,Flag79=0,Flag80=0," +
                "Flag81=0,Flag82=0,Flag83=0,Flag84=0,Flag85=0,Flag86=0,Flag87=0,Flag88=0,Flag89=0,Flag90=0,Flag91=0,Flag92=0,Flag93=0,Flag94=0,Flag95=0,Flag96=0,Flag97=0,Flag98=0,Flag99=0,Flag100=0,Flag101=0,Flag102=0,Flag103=0,Flag104=0,Flag105=0,Flag106=0,Flag107=0,Flag108=0,Flag109=0 where id =?";
        Object[] param = {id};
        int result = this.exceuteUpdate(sql, param);
        return result;
    }
}
