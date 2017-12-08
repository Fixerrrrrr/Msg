<%@ page import="com.messagelabel.entity.Message" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: quyuan
  Date: 2017/10/25
  Time: 上午11:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    //text
    Message message = (Message) request.getAttribute("message");
    String text = message.text;
    text = text.replaceAll("【(.*?)】", "【<a  onclick = \"window.open('http://www.baidu.com/s?wd=$1')\" style = 'cursor:pointer'>$1</a>】");
    //sidebar
    List messages = (List) request.getAttribute("arrayList");
    int mes_id = message.id;
    int count = Integer.parseInt(request.getParameter("count"));
    request.getSession().setAttribute("mes_id", mes_id);
    List<Integer> flags = (List) request.getAttribute("flag");
%>
<html>
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">

    <!-- Canonical -->
    <link rel="canonical" href="">

    <title>第<%=count+1%>条</title>

    <!-- Main Styles CSS -->
    <link href="css/main.css" rel="stylesheet">
    <link rel="stylesheet" href="css/bootstrap.css">
    <link rel="stylesheet" href="css/selectric.css">
    <link rel="stylesheet" href="css/style.css">

    <script src="js/jquery-3.2.1.js"></script>
    <script src="js/jquery.selectric.js"></script>
    <script src="js/bootstrap.js"></script>
    <script src="js/custom.js"></script>

    <style>
        /*.main-nav{*/
        /*display: none;*/
        /*}*/

        .count{
            font-size: 24px;
            font-weight: 400;
            color: whitesmoke;
            margin-top: 10px;
            position: relative;
            top: 5px;
        }
    </style>
</head>

<body>

<div id="wrapper">

    <aside id="sideBar">
        <ul class="main-nav page1">
            <%
                for (int i = 0; i < 20; i++) {
            %>
            <li>
                <a href="ShowServlet?count=<%=i%>"><%=i+1%>. <%=((Message) messages.get(i)).text.substring(0, 10)%>...</a>
            </li>
            <%}%>
        </ul>
        <ul class="main-nav page2">
            <%
                for (int i = 20; i < 40; i++) {
            %>
            <li>
                <a href="ShowServlet?count=<%=i%>"><%=i+1%>. <%=((Message) messages.get(i)).text.substring(0, 10)%>...</a>
            </li>
            <%}%>
        </ul>
        <ul class="main-nav page3">
            <%
                for (int i = 40; i < 60; i++) {
            %>
            <li>
                <a href="ShowServlet?count=<%=i%>"><%=i+1%>. <%=((Message) messages.get(i)).text.substring(0, 10)%>...</a>
            </li>
            <%}%>
        </ul>
        <ul class="main-nav page4">
            <%
                for (int i = 60; i < 80; i++) {
            %>
            <li>
                <a href="ShowServlet?count=<%=i%>"><%=i+1%>. <%=((Message) messages.get(i)).text.substring(0, 10)%>...</a>
            </li>
            <%}%>
        </ul>
        <ul class="main-nav page5">
            <%
                for (int i = 80; i < 100; i++) {
            %>
            <li>
                <a href="ShowServlet?count=<%=i%>"><%=i+1%>. <%=((Message) messages.get(i)).text.substring(0, 10)%>...</a>
            </li>
            <%}%>
        </ul>
        <script>

            $(document).ready(function () {
                <%
                    for(int i=0;i<100;i++){
                        if(((Message)messages.get(i)).submit){
                %>
                $(".main-nav li a:eq(<%=i%>)").before("<span style='color:rgb(20, 255, 60);'>{已提交}</span>")
                <%
                        }
                    }
                %>
            });
        </script>
        <%--<script>--%>
        <%--function p1(){--%>
        <%--$(".page1").show();--%>
        <%--$(".page2").hide();--%>
        <%--$(".page3").hide();--%>
        <%--$(".page4").hide();--%>
        <%--$(".page5").hide();--%>
        <%--}--%>
        <%--function p2(){--%>
        <%--$(".page1").hide();--%>
        <%--$(".page2").show();--%>
        <%--$(".page3").hide();--%>
        <%--$(".page4").hide();--%>
        <%--$(".page5").hide();--%>
        <%--}--%>
        <%--function p3(){--%>
        <%--$(".page1").hide();--%>
        <%--$(".page2").hide();--%>
        <%--$(".page3").show();--%>
        <%--$(".page4").hide();--%>
        <%--$(".page5").hide();--%>
        <%--}--%>
        <%--function p4(){--%>
        <%--$(".page1").hide();--%>
        <%--$(".page2").hide();--%>
        <%--$(".page3").hide();--%>
        <%--$(".page4").show();--%>
        <%--$(".page5").hide();--%>
        <%--}--%>
        <%--function p5(){--%>
        <%--$(".page1").hide();--%>
        <%--$(".page2").hide();--%>
        <%--$(".page3").hide();--%>
        <%--$(".page4").hide();--%>
        <%--$(".page5").show();--%>
        <%--}--%>
        <%--</script>--%>
        <%--<ul class="page">--%>
        <%--<li><a value="1" onclick="p1()">1</a></li>--%>
        <%--<li><a value="2" onclick="p2()">2</a></li>--%>
        <%--<li><a value="3" onclick="p3()">3</a></li>--%>
        <%--<li><a value="4" onclick="p4()">4</a></li>--%>
        <%--<li><a value="5" onclick="p5()">5</a></li>--%>
        <%--</ul>--%>
    </aside>

    <!-- Main Section -->
    <section class="main-section">
        <!-- Add Your Content Inside -->
        <div class="content">
            <img src="img/createtask_fill.png" id="menuToggler">
            <span class="count"><%=count+1%>/100</span>
            <div class="message">
                <p class="text">
                    <%=text%>
                </p>
                <script>
                    function next() {
                        var form = document.getElementById("form");
                        form.action = "SubmitServlet?count="+<%=count%>;
                        <%--form.setParameter("count",<%=count%>);--%>
                        form.submit();
                    }
                </script>
                <a class="buttona" onclick="next()">提 交</a>

            </div>
            <!--<button id="menuToggler" class="btn btn-primary">Press me to toggle</button>-->
            <!-- Remove This Before You Start -->
            <form id="form" method="post">
                <div class="rksx ">
                    <span class="res_header">人口属性</span>
                    <div class="res">
                        <span class="res_header_title">性别：</span>
                        <div class="res_body">
                            <select name="xb">
                                <option value="0">未看出</option>
                                <option value="1">男</option>
                                <option value="2">女</option>
                            </select>
                        </div>
                    </div>


                    <div class="res">
                        <span class="res_header_title">年龄：</span>

                        <div class="res_body">
                            <select name="nl">
                                <option value="0">未看出</option>
                                <option value="3">18岁以下</option>
                                <option value="4">19-24</option>
                                <option value="5">25-34</option>
                                <option value="6">35-49</option>
                                <option value="7">50岁以上</option>
                            </select>
                        </div>
                    </div>

                    <div class="res">
                        <span class="res_header_title">月收入：</span>

                        <div class="res_body">
                            <select name="ysr">
                                <option value="0">未看出</option>
                                <option value="8">2000元以下</option>
                                <option value="9">2001-4000元</option>
                                <option value="10">4000-6000元</option>
                                <option value="11">6001-8000元</option>
                                <option value="12">8000-10000元</option>
                                <option value="13">10000元以上</option>
                            </select>
                        </div>
                    </div>

                    <div class="res">
                        <span class="res_header_title">婚姻状态：</span>

                        <div class="res_body">
                            <select name="hyzt">
                                <option value="0">未看出</option>
                                <option value="14">未婚</option>
                                <option value="15">已婚</option>
                                <option value="16">离异</option>

                            </select>
                        </div>
                    </div>

                    <div class="res">
                        <span class="res_header_title">身份职业：</span>


                        <div class="res_body">
                            <select name="sfzy">
                                <option value="0">未看出</option>
                                <option value="17">学生</option>
                                <option value="18">职员</option>
                                <option value="19">企业管理者、企业主</option>
                            </select>
                        </div>
                    </div>
                    <div class="res">
                        <span class="res_header_title">受教育程度：</span>

                        <div class="res_body">
                            <select name="sjycd">
                                <option value="0">未看出</option>
                                <option value="20">高中(中专)及以下</option>
                                <option value="21">大专及本科</option>
                                <option value="22">硕士</option>
                                <option value="23">博士</option>
                            </select>
                        </div>
                    </div>

                    <div class="res">
                        <span class="res_header_title">关键人生阶段：</span>

                        <div class="res_body">
                            <select name="gjrsjd">
                                <option value="0">未看出</option>
                                <option value="24">学生时期</option>
                                <option value="25">求职时期</option>
                                <option value="26">适婚时期</option>
                                <option value="27">孕产时期</option>
                                <option value="28">育儿时期</option>
                                <option value="29">事业成熟期</option>
                                <option value="30">老年黄金期</option>
                            </select>
                        </div>
                    </div>
                    <div class="res">
                        <span class="res_header_title">所在行业：</span>

                        <div class="res_body">
                            <select name="szhy">
                                <option value="0">未看出</option>
                                <option value="31">广告|媒体|文体娱乐</option>
                                <option value="32">机械制造</option>
                                <option value="33">计算机|互联网|通信电子</option>
                                <option value="34">建筑</option>
                                <option value="35">教育</option>
                                <option value="36">金融|银行|保险|房地产</option>
                                <option value="37">旅游</option>
                                <option value="38">贸易|零售</option>
                                <option value="39">制药医疗|保健</option>
                                <option value="40">住宿|餐饮|服务业</option>
                            </select>
                        </div>
                    </div>
                </div>

                <div class="gmqx">
                    <span class="res_header">购买倾向</span>

                    <div class="res">
                        <span class="res_header_title">服饰箱包：</span>
                        <div class="res_body">
                            <select name="fsxb">
                                <option value="0">未看出</option>
                                <option value="41">服装</option>
                                <option value="42">鞋靴</option>
                                <option value="43">配饰</option>
                                <option value="44">箱包</option>
                                <option value="45">其他</option>
                            </select>
                        </div>
                    </div>
                    <div class="res">
                        <span class="res_header_title">母婴：</span>
                        <div class="res_body">
                            <select name="my">
                                <option value="0">未看出</option>
                                <option value="46">童装玩具</option>
                                <option value="47">孕产用品</option>
                                <option value="48">奶食</option>
                                <option value="49">其他</option>
                            </select>
                        </div>
                    </div>
                    <div class="res">
                        <span class="res_header_title">电子产品：</span>
                        <div class="res_body">
                            <select name="dzcp">
                                <option value="0">未看出</option>
                                <option value="50">家电</option>
                                <option value="51">数码</option>
                                <option value="52">手机</option>
                                <option value="53">其他</option>
                            </select>
                        </div>
                    </div>
                    <div class="res">
                        <span class="res_header_title">美妆|个人护理：</span>
                        <div class="res_body">
                            <select name="mzgrhl">
                                <option value="0">未看出</option>
                                <option value="54">美妆</option>
                                <option value="55">洗护</option>
                                <option value="56">保健品</option>
                                <option value="57">医疗药品</option>
                                <option value="58">其他</option>
                            </select>
                        </div>
                    </div>
                    <div class="res">
                        <span class="res_header_title">文体活动：</span>
                        <div class="res_body">
                            <select name="wthd">
                                <option value="0">未看出</option>
                                <option value="59">图书</option>
                                <option value="60">教育培训</option>
                                <option value="61">乐器</option>
                                <option value="62">健身运动</option>
                                <option value="63">其他</option>
                            </select>
                        </div>
                    </div>
                    <div class="res">
                        <span class="res_header_title">娱乐活动：</span>
                        <div class="res_body">
                            <select name="ylhd">
                                <option value="0">未看出</option>
                                <option value="64">游戏</option>
                                <option value="65">影视周边</option>
                                <option value="66">票券</option>
                                <option value="67">旅游出行</option>
                                <option value="68">其他</option>
                            </select>
                        </div>
                    </div>
                    <div class="res">
                        <span class="res_header_title">食品：</span>
                        <div class="res_body">
                            <select name="sp">
                                <option value="0">未看出</option>
                                <option value="69">美食</option>
                                <option value="70">生鲜</option>
                                <option value="71">零食</option>
                                <option value="72">其他</option>
                            </select>
                        </div>
                    </div>
                    <div class="res">
                        <span class="res_header_title">家养：</span>
                        <div class="res_body">
                            <select name="jy">
                                <option value="0">未看出</option>
                                <option value="73">鲜花园艺</option>
                                <option value="74">宠物水族</option>
                                <option value="75">农资</option>
                                <option value="76">其他</option>
                            </select>
                        </div>
                    </div>
                    <div class="res">
                        <span class="res_header_title">住宅汽车：</span>
                        <div class="res_body">
                            <select name="zzqc">
                                <option value="0">未看出</option>
                                <option value="77">房产</option>
                                <option value="78">装修建材</option>
                                <option value="79">家具家饰家纺</option>
                                <option value="80">汽车</option>
                                <option value="81">其他</option>
                            </select>
                        </div>
                    </div>

                    <div class="res">
                        <span class="res_header_title">生活服务：</span>
                        <div class="res_body">
                            <select name="shfw">
                                <option value="0">未看出</option>
                                <option value="82">日用品百货</option>
                                <option value="83">快递</option>
                                <option value="84">打车租车代驾</option>
                                <option value="85">餐饮服务</option>
                                <option value="86">酒店服务</option>
                                <option value="87">手机业务</option>
                                <option value="88">其他</option>
                            </select>
                        </div>
                    </div>
                    <div class="res">
                        <span class="res_header_title">财经金融：</span>
                        <div class="res_body">
                            <select name="cjjr">
                                <option value="0">未看出</option>
                                <option value="89">投资理财</option>
                                <option value="90">借贷</option>
                                <option value="91">存款</option>
                                <option value="92">彩票</option>
                                <option value="93">其他</option>
                            </select>
                        </div>
                    </div>

                </div>
                <div class="grgz">
                    <span class="res_header">个人关注</span>

                    <div class="res">
                        <span class="res_header_title">娱乐：</span>
                        <div class="res_body">
                            <select name="yl">
                                <option value="0">未看出</option>
                                <option value="94">游戏</option>
                                <option value="95">文学</option>
                                <option value="96">动漫</option>
                                <option value="97">视频</option>
                                <option value="98">音乐舞蹈</option>
                                <option value="99">其他</option>
                            </select>
                        </div>

                    </div>
                    <div class="res">
                        <span class="res_header_title">生活信息：</span>
                        <div class="res_body">
                            <select name="shxx">
                                <option value="0">未看出</option>
                                <option value="100">地图</option>
                                <option value="101">购物</option>
                                <option value="102">天气</option>
                                <option value="103">违章查询</option>
                                <option value="104">其他</option>
                            </select>
                        </div>
                    </div>

                    <div class="res">
                        <span class="res_header_title">商务信息：</span>
                        <div class="res_body">
                            <select name="swxx">
                                <option value="0">未看出</option>
                                <option value="105">商务信息</option>
                            </select>
                        </div>
                    </div>

                    <div class="res">
                        <span class="res_header_title">招聘信息：</span>
                        <div class="res_body">
                            <select name="zpxx">
                                <option value="0">未看出</option>
                                <option value="106">社会招聘</option>
                                <option value="107">兼职</option>
                                <option value="108">校园招聘</option>
                                <option value="109">其他</option>
                            </select>
                        </div>
                    </div>
                </div>

            </form>
        </div>
        <!-- /.content -->
    </section>
    <!-- /.main-section -->


</div>
<script>
    $(function () {
        $('select').selectric();
    })
</script>
<!-- Call functions on document ready -->
<script>
    $(document).ready(function () {
        // Call Menu Toggler
        appMaster.menuToggler();
        // Example Call anotherFunction
        appMaster.anotherFunction();
    });
</script>


</body>

</html>
