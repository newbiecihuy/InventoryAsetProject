<%-- 
    Document   : index
    Created on : Feb 23, 2019, 11:07:14 AM
    Author     : newbiecihuy
--%>
<%
    String username = "gudang";//admin
    String rolename = "gudang";
    String dataCookies = "";
    String ip = request.getRemoteAddr();
    String hostname = request.getRemoteHost();
    String title = "";
    Cookie cookieUsername = null;
    if (request.isUserInRole("admin")) {
        rolename = "admin";
        username = request.getUserPrincipal().getName();
        cookieUsername = new Cookie("username", username);
        response.addCookie(cookieUsername);
        cookieUsername.setMaxAge(50 * 50); //Time is in Minutes
    }
    if (request.isUserInRole("gudang")) {
        rolename = "gudang";
        username = request.getUserPrincipal().getName();
        cookieUsername = new Cookie("username", username);
        response.addCookie(cookieUsername);
        cookieUsername.setMaxAge(50 * 50); //Time is in Minutes
    }
    if (username != "") {
        title = "Supply Chain Management";
    } else {
        title = "Login Page";
    }

%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@include file="inc/header.jsp"%>

<body>

    <div id="wrapper">

        <!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top bg-clr" role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a  href="index.jsp" class="navbar-brand font-header"><span class="logo-lg"><%=title%></span></a>
            </div>
            <%
                if (username != "") {
            %>  
            <%
                if (rolename == "admin") {
            %>  
            <%@include file="inc/sidebar.jsp"%>
            <%}else if (rolename == "gudang") {%>
            <%@include file="inc/sidebar_gudang.jsp"%>
            <%}%>
            <%}%>
            <!-- /.navbar-header -->
            <ul class="nav navbar-top-links navbar-right">
                <li>	
                    <%

                        if (username != "") {
                    %>  
                    <a href="<%= response.encodeURL("logoutServlet")%>" class="font-log"><i class="fa fa-sign-out "></i>
                        Sign out
                        <%}%>
                    </a>
                </li>
            </ul>
        </nav>


    </div>
    <div id="main-content" class="clearfix">
        <div style='margin-left:245px;padding:10px;'>
            <!--
            source: http://stackoverflow.com/questions/9110148/include-another-jsp-file
            -->
            <%
                if (request.getParameter("pages") != null) {
                    String pages = request.getParameter("pages");
                    String ref = request.getParameter("url");
            %>
            <jsp:include page='<%=ref + "/" + pages + ".jsp"%>'/>
            <%}%>		     
            <%

                if (username != "") {
            %>  

            <%--include file="page/main.jsp"--%>
            <%--<%@include file="page/index.jsp"%>--%>
            <%} else {%>
            <%@include file="login.jsp"%>

            <%}%>

        </div>
    </div>
    <!-- /#wrapper -->

    <!-- jQuery -->
    <!--    <script src="vendor/jquery/jquery.min.js"></script>
    
         Bootstrap Core JavaScript 
        <script src="vendor/bootstrap/js/bootstrap.min.js"></script>
    
         Metis Menu Plugin JavaScript 
        <script src="vendor/metisMenu/metisMenu.min.js"></script>
    
         Morris Charts JavaScript 
        <script src="vendor/raphael/raphael.min.js"></script>
        <script src="vendor/morrisjs/morris.min.js"></script>
        <script src="data/morris-data.js"></script>
    
         Custom Theme JavaScript 
        <script src="dist/js/sb-admin-2.js"></script>-->
    <%@include file="inc/js.jsp"%>
</body>

</html>
