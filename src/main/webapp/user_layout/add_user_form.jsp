<%-- 
    Document   : add_user_form
    Created on : Sep 7, 2018, 2:50:42 PM
    Author     : newbiecihuy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<body>
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
                <table cellpadding="0" cellspacing="0"  style="border: 0px" class="table">
                    <td class="controls">
                        <a href="index.jsp?url=user_layout&pages=list_users"  class="btn btn-success" role="button" aria-pressed="true"><font color='#b6c5cd' size='2em'>View Users</font></a>
                    </td>
                </table>
            </form>
            <form id="form_add_pic" name="form_add_pic" method="POST" action="" onload="editUserFunc()">
                <div id="form_add_user_response" class="resp"></div>
                <div  class="box-body">
                    <div id="div_username" class="form-group">
                        <label for="userName" class="req">User Name &nbsp;:</label>
                        <input type="text" name="userName" id="userName" oninput="cekUserName()" placeholder="User Name" class="form-control uppercase" onchange="setEditUserFunc()"/>
                        <input type="hidden" name="id_user" id="id_user"/>
                        <input type="hidden" name="action_insert" id="action_insert"/>
                        <input type="hidden" name="action_edit" id="action_edit"/>
                        <input type="hidden" name="action_delete" id="action_delete"/>
                        <span class="required-server"> </span>
                    </div> 
                    <div class="form-group">
                        <label for="email" class="req">E-Mail &nbsp;:</label>
                        <input type="text"  name="email" id="email" oninput="cekEmail()"  class=" required ui-widget-content form-control " onchange="setEditUserFunc()"/>
                        <span class="required-server"> </span>
                    </div>
                    <div class="form-group">
                        <label for="address" class="req">Address&nbsp;:</label>
                        <textarea  name="address" id="address"  placeholder="Adress"  class="form-control ui-widget-content sw uppercase" onfocus="setEditUserFunc()"></textarea>
                        <span class="required-server"> </span>
                    </div>
                    <div class="form-group">
                        <label for="roleName" class="req"> Role &nbsp;:</label>
                        <input type="text" name="roleName" id="roleName" class="form-control  uppercase" data-required="true" onfocus="setEditUserFunc()"/>
                        <span class="required-server"> </span>
                    </div>
                    <div class="form-group">
                        <label for="nomorIMEI" class="req">Nomor IMEI &nbsp;:</label>
                        <input type="text" name="nomorIMEI" id="nomorIMEI" class="required ui-widget-content form-control " onfocus="setEditUserFunc()"/>
                        <span class="required-server"> </span>
                    </div>

                    <div class="form-group">
                        <label for="phone" class="req"> Phone &nbsp;:</label>
                        <input type="text" id="phone" name="phone" value="" class="form-control" data-required="true" onfocus="setEditUserFunc()"> 
                        <span class="required-server"> </span>
                    </div>


                    <!--                    <div class="form-group">
                                            <label for="gender" class="req">  Gender &nbsp;:</label>
                                            <div>
                                                <input type="radio" name="gender"  id="gender" value="m"> Male<br>
                                                <input type="radio" name="gender"  id="gender" value="f"> Female<br>
                                                <p id="content_gender" >
                    
                                                </p>
                                            </div>
                                            <span class="required-server">   </span>
                    
                                        </div>-->
                    <div class="form-group">
                        <label for="gender" class="req">  Gender &nbsp;:</label>
                        <label class="checkbox-inline" for="is_active_a">

                            <input type="radio" name="gender" id="gender" value="m"> Male
                        </label>
                        <label class="checkbox-inline" for="reg_chbox_b">
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
</body>