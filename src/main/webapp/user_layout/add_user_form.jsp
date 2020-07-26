<%-- 
    Document   : add_user_form
    Created on : Sep 7, 2018, 2:50:42 PM
    Author     : newbiecihuy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<body>
    <%--
        String userName = "";
        if (request.getParameter("userName") != null) {
            userName = request.getParameter("userName");
        }
        String id_user = "";
        if (request.getParameter("id_user") != null) {
            id_user = request.getParameter("id_user");
        }
        String action_edit = "";
        if (request.getParameter("action_edit") != null) {
            action_edit = request.getParameter("action_edit");
        }
        String email = "";
        if (request.getParameter("email") != null) {
            email = request.getParameter("email");
        }
        String address = "";
        if (request.getParameter("address") != null) {
            address = request.getParameter("address");
        }
        String roleName = "";
        if (request.getParameter("role_name") != null) {
            roleName = request.getParameter("role_name");
        }
        String nomorIMEI = "";
        if (request.getParameter("imei") != null) {
            nomorIMEI = request.getParameter("imei");
        }
        String phone = "";
        if (request.getParameter("phone") != null) {
            phone = request.getParameter("phone");
        }
        String gender = "";
        if (request.getParameter("gender") != null) {
            gender = request.getParameter("gender");
            if (gender == "f") {
                gender = request.getParameter("gender");
            }
            if (gender == "m") {
                gender = request.getParameter("gender");
            }
        }
    --%> 

    <script type="text/javascript" src="user_layout/script/list_users.js"></script>
    <section class="content-header">
        <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
            <li class="active">users</li>
            <li class="active">add</li>
        </ol>
    </section>
    <div id ="div_add_pic" class="panel panel-default"  >
        <div class="panel-body">
            <form>
                <table cellpadding="0" cellspacing="0"  style="border: 0px">
                    <td class="controls">
                        <a href="index.jsp?url=user_layout&pages=list_users"  class="btn btn-success" role="button" aria-pressed="true"><font color='#b6c5cd' size='2em'>View Users</font></a>
                    </td>
                </table>
            </form>
            <form id="form_add_pic" name="form_add_pic" method="POST" action="">
                <div id="form_add_user_response" class="resp"></div>
                <div  class="box-body">
                    <div id="div_username" class="form-group w-50">
                        <label for="userName" class="req">User Name &nbsp;:</label>
                        <input type="text" name="userName" id="userName" oninput="cekUserName()" placeholder="User Name" class="form-control uppercase" value="<%-- out.println(userName);--%>" />
                        <input type="hidden" readonly="readonly" name="id_user" id="id_user" value="<%--out.println(id_user);--%>" />
                        <input type="hidden" readonly="readonly" name="action_insert" id="action_insert"/>
                        <input type="hidden" readonly="readonly" name="action_edit" id="action_edit"  value="<%-- out.println(action_edit);--%>" />
                        <input type="hidden" readonly="readonly" name="action_delete" id="action_delete"/>
                        <span class="required-server"> </span>
                    </div> 
                    <div class="form-group w-50">
                        <label for="email" class="req">E-Mail &nbsp;:</label>
                        <input type="text"  name="email" id="email" oninput="cekEmail()"  class="required ui-widget-content form-control" value="<%-- out.println(email);--%>">
                        <span class="required-server"> </span>
                    </div>
                    <div class="form-group w-50">
                        <label for="address" class="req">Address&nbsp;:</label>
                        <textarea  name="address" id="address"  placeholder="Adress"  class="form-control sw uppercase"> <%-- out.println(address);--%></textarea>
                        <span class="required-server"> </span>
                    </div>
                    <div class="form-group w-50">
                        <label for="roleName" class="req"> Role &nbsp;:</label>
                        <input type="text" name="roleName" id="roleName" class="form-control  uppercase" data-required="true" value="<%-- out.println(roleName);--%>"/>
                        <span class="required-server"> </span>
                    </div>
                    <div class="form-group w-50">
                        <label for="nomorIMEI" class="req">Nomor IMEI &nbsp;:</label>
                        <input type="text" name="nomorIMEI" id="nomorIMEI" class="required ui-widget-content form-control" value="<%-- out.println(nomorIMEI);--%>"/>
                        <span class="required-server"> </span>
                    </div>

                    <div class="form-group w-50">
                        <label for="phone" class="req"> Phone &nbsp;:</label>
                        <input type="text" id="phone" name="phone" class="form-control" data-required="true" value="<%-- out.println(phone);--%>"/> 
                        <span class="required-server"> </span>
                    </div>


                    <!--                    <div class="form-group w-50">
                                            <label for="gender" class="req">  Gender &nbsp;:</label>
                                            <div>
                                                <input type="radio" name="gender"  id="gender" value="m"> Male<br>
                                                <input type="radio" name="gender"  id="gender" value="f"> Female<br>
                                                <p id="content_gender" >
                    
                                                </p>
                                            </div>
                                            <span class="required-server">   </span>
                    
                                        </div>-->
                    <div class="form-group w-50">
                        <label for="gender" class="req">  Gender &nbsp;:</label>
                        <label class="checkbox-inline" for="is_active_a">
                            <input type="radio" name="gender" id="gender" value="m"> Male
                        </label>
                        <label class="checkbox-inline" for="is_active_a">
                            <input type="radio"  name="gender" id="gender" value="f">Female
                        </label>
                        <p id="content_gender" />
                    </div>

                </div>
                <div class="box-footer" align="center">
                    <button type="submit" class="btn btn-primary" id="btn_add_pic">Submit</button>
                    <button type="reset"  class="btn btn-danger" value="Reset" id="btn_reset" onclick="myFunction_reset_formUser()">RESET</button>
                </div>

            </form> 

        </div>
    </div>
    <script type="text/javascript" >

        var userName = getUrlQueryString('userName');
        if (userName !== "") {
            document.getElementById("userName").value = userName;
        } else {
            document.getElementById("userName").value = "";
        }
        var id_user = getUrlQueryString('id_user');
        if (id_user !== "") {
            document.getElementById("id_user").value = id_user;
        } else {
            document.getElementById("id_user").value = "";
        }

        var action_edit = getUrlQueryString('action_edit');
        if (action_edit !== null) {
            document.getElementById("action_edit").value = action_edit;
        } else {
            document.getElementById("action_edit").value = "";
        }
        var email = getUrlQueryString('email');
        if (email !== null) {
            document.getElementById("email").value = email;
        } else {
            document.getElementById("email").value = "";
        }
        var address = getUrlQueryString('address');
        if (address !== null) {
            document.getElementById("address").value = address;
        } else {
            document.getElementById("address").value = "";
        }
        var roleName = getUrlQueryString('role_name');
        if (roleName !== null) {
            document.getElementById("roleName").value = roleName;
        } else {
            document.getElementById("roleName").value = "";
        }
        var nomorIMEI = getUrlQueryString('imei');
        if (nomorIMEI !== null) {
            document.getElementById("nomorIMEI").value = nomorIMEI;
        } else {
            document.getElementById("nomorIMEI").value = "";
        }
        var phone = getUrlQueryString('phone');
        if (phone !== null) {
            document.getElementById("phone").value = phone;
        } else {
            document.getElementById("phone").value = "";
        }
        var gender = getUrlQueryString('gender');
        if (gender !== null) {
            var radios = document.getElementsByName('gender');
            if (gender === "m") {
//                    document.getElementById("gender")[0].checked = true;
                document.getElementsByName('gender').gender[0].checked = true;
            }
            if (gender === "f") {
                document.getElementsByName('gender').gender[1].checked = true;
            }
        } else {
            document.getElementById("gender").value = "";
        }

    </script>
</body>
