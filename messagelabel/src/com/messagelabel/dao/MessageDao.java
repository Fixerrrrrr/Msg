package com.messagelabel.dao;

import com.messagelabel.entity.Message;

/**
 * Created by quyuan on 2017/10/25.
 */
public interface MessageDao {
    /**
     * 修改flag值
     * @param id
     * @param flag
     * @return
     */
    int updateFlag(int id,int flag);

    /**
     * 查询
     * @param id
     * @return
     */
    Message selectById(int id);

    int updateSubmit(int id);

    Message select(int id);

    int deleteFlags(int id);
}
