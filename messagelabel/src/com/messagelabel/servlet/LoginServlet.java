package com.messagelabel.servlet;

import com.messagelabel.common.Validate;
import com.messagelabel.dao.CustomerDao;
import com.messagelabel.dao.MessageDao;
import com.messagelabel.dao.impl.CustomerDaoImpl;
import com.messagelabel.dao.impl.MessageDaoImpl;
import com.messagelabel.entity.Customer;
import com.messagelabel.entity.Message;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by quyuan on 2017/10/25.
 */
@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=gb2312");

        //用户入库
        String name = Validate.validStringNull(request.getParameter("name"));
        CustomerDao customerDao = new CustomerDaoImpl();
        customerDao.add(name);
        int cus_id = customerDao.getLastId();
        int count = 0;

        //随机选100个message
        ArrayList<Message> arrayList = new ArrayList<>();
        Random rand = new Random();
        int mes_id;
        MessageDao messageDao = new MessageDaoImpl();
        for(int i=0;i<100;i++) {
            Message message = null;
            while (message == null) {
                mes_id = rand.nextInt(168464) + 10000;
                message = messageDao.selectById(mes_id);
                if (message != null) {
                    if (message.text.length() < 10) {
                        message = null;
                    }
                }
            }
            arrayList.add(message);
        }

        //传值 count--当前是第几条 cus_id--用户id arrayList--message列表
        request.getSession().setAttribute("count", count);
        request.getSession().setAttribute("cus_id",cus_id);
        request.getSession().setAttribute("arrayList",arrayList);
        response.sendRedirect("ShowServlet?count="+count);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
