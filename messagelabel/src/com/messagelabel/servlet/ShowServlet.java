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
import java.util.Map;
import java.util.Random;

/**
 * Created by quyuan on 2017/10/25.
 */
@WebServlet(name = "ShowServlet")
public class ShowServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=gb2312");

        //获取当前是第几条
        int count = Integer.parseInt(request.getParameter("count"));
        int cus_id = (Integer) request.getSession().getAttribute("cus_id");
        if(count==100){
            count=0;
        }

        //从list里获取当前message
        ArrayList<Message> arrayList = (ArrayList<Message>) request.getSession().getAttribute("arrayList");
        Message message = arrayList.get(count);
        CustomerDao customerDao = new CustomerDaoImpl();

        if( customerDao.getCount(cus_id)==100){
            PrintWriter out=response.getWriter();
            out.print("<script type='' language='javascript'>alert('已完成,感谢您的帮助!');location.href='login.jsp'; </script>");
            out.flush();
            out.close();
        }
        //获取当前message的flag
       /* ArrayList<Integer> flag = new ArrayList<>();
        if(message.Flag1) flag.add(1);
        if(message.Flag2) flag.add(2);
        if(message.Flag3) flag.add(3);
        if(message.Flag4) flag.add(4);
        if(message.Flag5) flag.add(5);
        if(message.Flag6) flag.add(6);
        if(message.Flag7) flag.add(7);
        if(message.Flag8) flag.add(8);
        if(message.Flag9) flag.add(9);
        if(message.Flag10) flag.add(10);
        if(message.Flag11) flag.add(11);
        if(message.Flag12) flag.add(12);
        if(message.Flag13) flag.add(13);
        if(message.Flag14) flag.add(14);
        if(message.Flag15) flag.add(15);
        if(message.Flag16) flag.add(16);
        if(message.Flag17) flag.add(17);
        if(message.Flag18) flag.add(18);
        if(message.Flag19) flag.add(19);
        if(message.Flag20) flag.add(20);
        if(message.Flag21) flag.add(21);
        if(message.Flag22) flag.add(22);
        if(message.Flag23) flag.add(23);
        if(message.Flag24) flag.add(24);
        if(message.Flag25) flag.add(25);
        if(message.Flag26) flag.add(26);
        if(message.Flag27) flag.add(27);
        if(message.Flag28) flag.add(28);
        if(message.Flag29) flag.add(29);
        if(message.Flag30) flag.add(30);
        if(message.Flag31) flag.add(31);
        if(message.Flag32) flag.add(32);
        if(message.Flag33) flag.add(33);
        if(message.Flag34) flag.add(34);
        if(message.Flag35) flag.add(35);
        if(message.Flag36) flag.add(36);
        if(message.Flag37) flag.add(37);
        if(message.Flag38) flag.add(38);
        if(message.Flag39) flag.add(39);
        if(message.Flag40) flag.add(40);
        if(message.Flag41) flag.add(41);
        if(message.Flag42) flag.add(42);
        if(message.Flag43) flag.add(43);
        if(message.Flag44) flag.add(44);
        if(message.Flag45) flag.add(45);
        if(message.Flag46) flag.add(46);
        if(message.Flag47) flag.add(47);
        if(message.Flag48) flag.add(48);
        if(message.Flag49) flag.add(49);
        if(message.Flag50) flag.add(50);
        if(message.Flag51) flag.add(51);
        if(message.Flag52) flag.add(52);
        if(message.Flag53) flag.add(53);
        if(message.Flag54) flag.add(54);
        if(message.Flag55) flag.add(55);
        if(message.Flag56) flag.add(56);
        if(message.Flag57) flag.add(57);
        if(message.Flag58) flag.add(58);
        if(message.Flag59) flag.add(59);
        if(message.Flag60) flag.add(60);
        if(message.Flag61) flag.add(61);
        if(message.Flag62) flag.add(62);
        if(message.Flag63) flag.add(63);
        if(message.Flag64) flag.add(64);
        if(message.Flag65) flag.add(65);
        if(message.Flag66) flag.add(66);
        if(message.Flag67) flag.add(67);
        if(message.Flag68) flag.add(68);
        if(message.Flag69) flag.add(69);
        if(message.Flag70) flag.add(70);
        if(message.Flag71) flag.add(71);
        if(message.Flag72) flag.add(72);
        if(message.Flag73) flag.add(73);
        if(message.Flag74) flag.add(74);
        if(message.Flag75) flag.add(75);
        if(message.Flag76) flag.add(76);
        if(message.Flag77) flag.add(77);
        if(message.Flag78) flag.add(78);
        if(message.Flag79) flag.add(79);
        if(message.Flag80) flag.add(80);
        if(message.Flag81) flag.add(81);
        if(message.Flag82) flag.add(82);
        if(message.Flag83) flag.add(83);
        if(message.Flag84) flag.add(84);
        if(message.Flag85) flag.add(85);
        if(message.Flag86) flag.add(86);
        if(message.Flag87) flag.add(87);
        if(message.Flag88) flag.add(88);
        if(message.Flag89) flag.add(89);
        if(message.Flag90) flag.add(90);
        if(message.Flag91) flag.add(91);
        if(message.Flag92) flag.add(92);
        if(message.Flag93) flag.add(93);
        if(message.Flag94) flag.add(94);
        if(message.Flag95) flag.add(95);
        if(message.Flag96) flag.add(96);
        if(message.Flag97) flag.add(97);
        if(message.Flag98) flag.add(98);
        if(message.Flag99) flag.add(99);
        if(message.Flag100) flag.add(100);
        if(message.Flag101) flag.add(101);
        if(message.Flag102) flag.add(102);
        if(message.Flag103) flag.add(103);
        if(message.Flag104) flag.add(104);
        if(message.Flag105) flag.add(105);
        if(message.Flag106) flag.add(106);
        if(message.Flag107) flag.add(107);
        if(message.Flag108) flag.add(108);
        if(message.Flag109) flag.add(109);
        if(message.Flag110) flag.add(110);
        if(message.Flag111) flag.add(111);
        if(message.Flag112) flag.add(112);
        if(message.Flag113) flag.add(113);
        if(message.Flag114) flag.add(114);
        if(message.Flag115) flag.add(115);
        if(message.Flag116) flag.add(116);
        if(message.Flag117) flag.add(117);
        if(message.Flag118) flag.add(118);
        if(message.Flag119) flag.add(119);
        if(message.Flag120) flag.add(120);
        if(message.Flag121) flag.add(121);
        if(message.Flag122) flag.add(122);
        if(message.Flag123) flag.add(123);
        if(message.Flag124) flag.add(124);
        if(message.Flag125) flag.add(125);
        if(message.Flag126) flag.add(126);
        if(message.Flag127) flag.add(127);
        if(message.Flag128) flag.add(128);
        if(message.Flag129) flag.add(129);
        if(message.Flag130) flag.add(130);
        if(message.Flag131) flag.add(131);
        if(message.Flag132) flag.add(132);
        if(message.Flag133) flag.add(133);*/
        //向jsp传值 flag用于还原选项 list用于sidebar message用于展示text
        request.setAttribute("arrayList", arrayList);
//        request.setAttribute("flag",flag);
        request.setAttribute("message", message);
        request.getRequestDispatcher("index.jsp?count="+count).forward(request, response);


        //        if(count ==100){
//            PrintWriter out=response.getWriter();
//            out.print("<script type='' language='javascript'>alert('已完成,感谢您的帮助');location.href='login.jsp'; </script>");
//            out.flush();
//            out.close();
//        }
//        Random rand = new Random();
//        int mes_id;
//        MessageDao messageDao = new MessageDaoImpl();
//        Message message = null;
//        while(message == null){
//            mes_id = rand.nextInt(168464)+10000;
//            message = messageDao.selectById(mes_id);
//            if(message!=null){
//                if(message.text.length()<10){
//                    message=null;
//                }
//            }
//        }
//

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
