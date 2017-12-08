package com.messagelabel.servlet;

import com.messagelabel.common.BeanRefUtil;
import com.messagelabel.dao.CustomerDao;
import com.messagelabel.dao.MessageDao;
import com.messagelabel.dao.impl.CustomerDaoImpl;
import com.messagelabel.dao.impl.MessageDaoImpl;
import com.messagelabel.entity.Message;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by quyuan on 2017/10/25.
 */
@WebServlet(name = "SubmitServlet")
public class SubmitServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=gb2312");

        MessageDao messageDao = new MessageDaoImpl();
        CustomerDao customerDao = new CustomerDaoImpl();
        String[] cate = {"xb", "nl", "ysr", "hyzt", "sfzy", "sjycd", "gjrsjd", "szhy", "fsxb", "my", "dzcp", "mzgrhl", "wthd", "ylhd", "sp",
                "jy", "zzqc", "shfw", "cjjr", "yl", "shxx", "swxx", "zpxx"};

        int count = Integer.parseInt(request.getParameter("count"));
        ArrayList<Message> arrayList =  (ArrayList<Message>)request.getSession().getAttribute("arrayList");
        int mes_id = (Integer) request.getSession().getAttribute("mes_id");
        int cus_id = (Integer) request.getSession().getAttribute("cus_id");

        //更改为已提交
        messageDao.updateSubmit(mes_id);
        //更改数据库里的flag
        Message message = arrayList.get(count);
        if(!message.submit){
            message.submit=true;
            customerDao.updateCount(cus_id);
        }
        messageDao.deleteFlags(mes_id);
        System.out.println(mes_id);
        for (int i = 0; i < 23; i++) {
            int temp = Integer.parseInt(request.getParameter(cate[i]));
            if (temp != 0) {
                messageDao.updateFlag(mes_id, temp);
                /*if(temp ==1) message.Flag1 = true;
                if(temp ==2) message.Flag2 = true;
                if(temp ==3) message.Flag3 = true;
                if(temp ==4) message.Flag4 = true;
                if(temp ==5) message.Flag5 = true;
                if(temp ==6) message.Flag6 = true;
                if(temp ==7) message.Flag7 = true;
                if(temp ==8) message.Flag8 = true;
                if(temp ==9) message.Flag9 = true;
                if(temp ==10) message.Flag10 = true;
                if(temp ==11) message.Flag11 = true;
                if(temp ==12) message.Flag12 = true;
                if(temp ==13) message.Flag13 = true;
                if(temp ==14) message.Flag14 = true;
                if(temp ==15) message.Flag15 = true;
                if(temp ==16) message.Flag16 = true;
                if(temp ==17) message.Flag17 = true;
                if(temp ==18) message.Flag18 = true;
                if(temp ==19) message.Flag19 = true;
                if(temp ==20) message.Flag20 = true;
                if(temp ==21) message.Flag21 = true;
                if(temp ==22) message.Flag22 = true;
                if(temp ==23) message.Flag23 = true;
                if(temp ==24) message.Flag24 = true;
                if(temp ==25) message.Flag25 = true;
                if(temp ==26) message.Flag26 = true;
                if(temp ==27) message.Flag27 = true;
                if(temp ==28) message.Flag28 = true;
                if(temp ==29) message.Flag29 = true;
                if(temp ==30) message.Flag30 = true;
                if(temp ==31) message.Flag31 = true;
                if(temp ==32) message.Flag32 = true;
                if(temp ==33) message.Flag33 = true;
                if(temp ==34) message.Flag34 = true;
                if(temp ==35) message.Flag35 = true;
                if(temp ==36) message.Flag36 = true;
                if(temp ==37) message.Flag37 = true;
                if(temp ==38) message.Flag38 = true;
                if(temp ==39) message.Flag39 = true;
                if(temp ==40) message.Flag40 = true;
                if(temp ==41) message.Flag41 = true;
                if(temp ==42) message.Flag42 = true;
                if(temp ==43) message.Flag43 = true;
                if(temp ==44) message.Flag44 = true;
                if(temp ==45) message.Flag45 = true;
                if(temp ==46) message.Flag46 = true;
                if(temp ==47) message.Flag47 = true;
                if(temp ==48) message.Flag48 = true;
                if(temp ==49) message.Flag49 = true;
                if(temp ==50) message.Flag50 = true;
                if(temp ==51) message.Flag51 = true;
                if(temp ==52) message.Flag52 = true;
                if(temp ==53) message.Flag53 = true;
                if(temp ==54) message.Flag54 = true;
                if(temp ==55) message.Flag55 = true;
                if(temp ==56) message.Flag56 = true;
                if(temp ==57) message.Flag57 = true;
                if(temp ==58) message.Flag58 = true;
                if(temp ==59) message.Flag59 = true;
                if(temp ==60) message.Flag60 = true;
                if(temp ==61) message.Flag61 = true;
                if(temp ==62) message.Flag62 = true;
                if(temp ==63) message.Flag63 = true;
                if(temp ==64) message.Flag64 = true;
                if(temp ==65) message.Flag65 = true;
                if(temp ==66) message.Flag66 = true;
                if(temp ==67) message.Flag67 = true;
                if(temp ==68) message.Flag68 = true;
                if(temp ==69) message.Flag69 = true;
                if(temp ==70) message.Flag70 = true;
                if(temp ==71) message.Flag71 = true;
                if(temp ==72) message.Flag72 = true;
                if(temp ==73) message.Flag73 = true;
                if(temp ==74) message.Flag74 = true;
                if(temp ==75) message.Flag75 = true;
                if(temp ==76) message.Flag76 = true;
                if(temp ==77) message.Flag77 = true;
                if(temp ==78) message.Flag78 = true;
                if(temp ==79) message.Flag79 = true;
                if(temp ==80) message.Flag80 = true;
                if(temp ==81) message.Flag81 = true;
                if(temp ==82) message.Flag82 = true;
                if(temp ==83) message.Flag83 = true;
                if(temp ==84) message.Flag84 = true;
                if(temp ==85) message.Flag85 = true;
                if(temp ==86) message.Flag86 = true;
                if(temp ==87) message.Flag87 = true;
                if(temp ==88) message.Flag88 = true;
                if(temp ==89) message.Flag89 = true;
                if(temp ==90) message.Flag90 = true;
                if(temp ==91) message.Flag91 = true;
                if(temp ==92) message.Flag92 = true;
                if(temp ==93) message.Flag93 = true;
                if(temp ==94) message.Flag94 = true;
                if(temp ==95) message.Flag95 = true;
                if(temp ==96) message.Flag96 = true;
                if(temp ==97) message.Flag97 = true;
                if(temp ==98) message.Flag98 = true;
                if(temp ==99) message.Flag99 = true;
                if(temp ==100) message.Flag100 = true;
                if(temp ==101) message.Flag101 = true;
                if(temp ==102) message.Flag102 = true;
                if(temp ==103) message.Flag103 = true;
                if(temp ==104) message.Flag104 = true;
                if(temp ==105) message.Flag105 = true;
                if(temp ==106) message.Flag106 = true;
                if(temp ==107) message.Flag107 = true;
                if(temp ==108) message.Flag108 = true;
                if(temp ==109) message.Flag109 = true;
                if(temp ==110) message.Flag110 = true;
                if(temp ==111) message.Flag111 = true;
                if(temp ==112) message.Flag112 = true;
                if(temp ==113) message.Flag113 = true;
                if(temp ==114) message.Flag114 = true;
                if(temp ==115) message.Flag115 = true;
                if(temp ==116) message.Flag116 = true;
                if(temp ==117) message.Flag117 = true;
                if(temp ==118) message.Flag118 = true;
                if(temp ==119) message.Flag119 = true;
                if(temp ==120) message.Flag120 = true;
                if(temp ==121) message.Flag121 = true;
                if(temp ==122) message.Flag122 = true;
                if(temp ==123) message.Flag123 = true;
                if(temp ==124) message.Flag124 = true;
                if(temp ==125) message.Flag125 = true;
                if(temp ==126) message.Flag126 = true;
                if(temp ==127) message.Flag127 = true;
                if(temp ==128) message.Flag128 = true;
                if(temp ==129) message.Flag129 = true;
                if(temp ==130) message.Flag130 = true;
                if(temp ==131) message.Flag131 = true;
                if(temp ==132) message.Flag132 = true;
                if(temp ==133) message.Flag133 = true;*/
            }
        }
        //更改list里的flag
        arrayList.set(count,message);

        //换下一条
        count = count + 1;
//        customerDao.updateCount(cus_id,count);
//        request.getSession().setAttribute("count",count);
        request.getSession().setAttribute("arrayList",arrayList);
        response.sendRedirect("ShowServlet?count="+count);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
