<%@ page import="java.util.List" %>
<%@ page import="Entity.Message" %>
<%@ page import="Entity.Utilisateur" %>
<%@ page import="Dao.MessageDaoImpl" %>
<%@ page import="Dao.UserDaoImpl" %><%--
  Created by IntelliJ IDEA.
  User: henda
  Date: 19/05/2023
  Time: 22:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" />
    <link href="style/chatstyle.css" rel="stylesheet">
    <meta http-equiv="refresh" content="6; URL=Chatmainpage.jsp">

</head>
<body>
<% MessageDaoImpl messageDaoimpl=new MessageDaoImpl(); %>
<% UserDaoImpl userDaoimpl =new UserDaoImpl(); %>

<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" />
<div class="container">
    <div class="row clearfix">
        <div class="col-lg-12">
            <div class="card chat-app">
                <div id="plist" class="people-list">
                    <div class="input-group">
                        <div class="input-group-prepend">
                            <span class="input-group-text"><i class="fa fa-search"></i></span>
                        </div>
                        <input type="text" class="form-control" placeholder="Search...">
                    </div>
                    <ul class="list-unstyled chat-list mt-2 mb-0">

                        <%  List<Utilisateur> utilisateurs=userDaoimpl.getAllusers(); %>
                        <% for (Utilisateur u: utilisateurs){
                               if(u.getPermission()==1){
                        %>

                        <li class="clearfix">
                            <img src="https://bootdey.com/img/Content/avatar/avatar1.png" alt="avatar">
                            <div class="about">
                                <div class="name"><%=u.getNom()%></div>
                                <div class="status"> <i class="fa fa-circle offline"></i> <strong>admin</strong> </div>
                            </div>
                        </li>
                        <% }%>

                        <li class="clearfix">
                            <img src="https://bootdey.com/img/Content/avatar/avatar1.png" alt="avatar">
                            <div class="about">
                                <div class="name"><%=u.getNom()%></div>
                                <div class="status"> <i class="fa fa-circle online"></i> <button>ban</button> </div>
                            </div>
                        </li>

                        <%}%>


                    </ul>
                </div>
                <div class="chat" >
                    <div class="chat-header clearfix">
                        <div class="row">
                            <div class="col-lg-6">
                                <a href="javascript:void(0);" data-toggle="modal" data-target="#view_info">
                                    <img src="https://bootdey.com/img/Content/avatar/avatar2.png" alt="avatar">
                                </a>
                                <div class="chat-about">
                                    <h6 class="m-b-0">Aiden Chavez</h6>
                                    <small>Last seen: 2 hours ago</small>
                                </div>
                            </div>
                            <div class="col-lg-6 hidden-sm text-right">
                                <a href="javascript:void(0);" class="btn btn-outline-secondary"><i class="fa fa-camera"></i></a>
                                <a href="javascript:void(0);" class="btn btn-outline-primary"><i class="fa fa-image"></i></a>
                                <a href="javascript:void(0);" class="btn btn-outline-info"><i class="fa fa-cogs"></i></a>
                                <a href="javascript:void(0);" class="btn btn-outline-warning"><i class="fa fa-question"></i></a>
                            </div>
                        </div>
                    </div>
                    <form action="ServletChat" method="post" id="messageForm">

                        <div class="chat-history" id="chat-history-container">
                            <ul class="m-b-0">
                                <%
                                    List<Message> messgs = messageDaoimpl.getAllmsgs();
                                    if (messgs != null) {
                                        for (Message s : messgs) {
                                %>
                                <% if(s.getUtil().getIdUtil().equals(session.getId())){ %>
                                <li class="clearfix">
                                    <div class="message-data text-right">
                                    <span class="message-data-time float-right"><%=s.getLocalDateTime()%>
                                                             <strong><%=s.getUtil().getNom()%></strong>
                                    </span>
                                    </div>

                                    </br>  <div class="message other-message float-right"> <%= s.getMessage()%> </div>
                                </li>
                                <% }else {

                                %>
                                <li class="clearfix">
                                    <div class="message-data">
                                    <span class="message-data-time">
                                        <strong><%=s.getUtil().getNom()%></strong>
                                        <%=s.getLocalDateTime()%></span>
                                    </div>
                                    <div class="message my-message"><%= s.getMessage()%></div>
                                </li>

                            </ul>
                            <%
                                        } }}
                            %>
                        </div>
                        <div class="chat-message clearfix">
                            <div class="input-group mb-0">
                                <div class="input-group-prepend">
                                    <span class="input-group-text"><i class="fa fa-send"></i></span>
                                </div>
                                <input type="text" class="form-control" placeholder="Enter text here..." name="text">

                            </div>
                        </div>
                        <button type="submit">send</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</div>


</body>
</html>
