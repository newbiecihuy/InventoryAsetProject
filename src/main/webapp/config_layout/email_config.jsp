<%-- 
    Document   : email_config
    Created on : Sep 13, 2018, 3:50:37 PM
    Author     : newbiecihuy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<body>
    <section class="content-header">
        <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
            <li class="active">Email-config</li>
            <li class="active">add</li>
        </ol>
    </section>
    <div class="panel panel-default">
        <div class="panel-body">
            <form>
                <table cellpadding="0" cellspacing="0"  style="border: 0px" class="table">
                    <td class="controls">
                        <a href="index.jsp?url=config_layout&pages=list_email" class='btn btn-success'><font color='#b6c5cd' size='2em'>Back</font></a>
                    </td>
                </table>
            </form>
            <form  name="form_email_config" id="form_email_config" class="hidden_add_email_config form-horizontal" action="">
                <div id="ajaxResponse_form_email_config" class="resp"></div>
                <div class="box-body">
                    <table id="tbl_email_config" name="tbl_email_config"  cellpadding="0" cellspacing="0" class="display hidden_add_email_config">
                        <tr class="form-group">
                            <td class="control-label">
                                <a class='btn btn-info' id="yahoo" name="yahoo" onclick="yahoo_mail()">YAHOO</a>
                            </td>
                            <td class="control-label">
                                <a class='btn btn-info' id="gmail" name="gmail" onclick="google_mail()">GMAIL</a>
                            </td>
                            <td class="control-label">
                                <a class='btn btn-info' id="other_mail" name="other_mail" onclick="other_mail()">OTHER</a>
                            </td>
                        </tr>
                        <tr class="form-group">
                            &nbsp;
                        </tr>
                    </table>
                    <div class="form-group">
                        <label for="smtp" class="req">Smtp Host &nbsp;:</label>
                        <p id="content_smtpHost" ></p>
                        <input type="text" name="smtpHost" id="smtpHost"  placeholder="Smtp Host" class="uppercase"/>
                        <input type="hidden" name="action_insert_email" id="action_insert_email" value="INSERT"/>
                        <input type="hidden" name="action_edit_email" id="action_edit_email"/>
                        <input type="hidden" name="action_delete_email" id="action_delete_email"/>

                        <input type="hidden" name="email_config_val" id="email_config_val" />   
                        <input type="hidden" name="id_email_config" id="id_email_config" />
                        <input type="hidden" name="isActive" id="isActive" />
                    </div>
                    <div class="form-group">
                        <label for="smtp_Socketp" class="req">Smtp Socket Factory Port &nbsp;:</label>
                        <p id="content_smtpSocketFactoryPort" ></p>
                        <input type="text" name="smtpSocketFactoryPort" id="smtpSocketFactoryPort"  placeholder="Smtp Socket Factory" class="form-control uppercase"/>
                    </div>
                    <div class="form-group">
                        <label for="smtp_Socketpc" class="control-label">Smtp Socket Factory Class &nbsp;:</label>
                        <p id="content_smtpSocketFactoryClass" ></p>
                        <input type="text" readonly="readonly" name="smtpSocketFactoryClass" id="smtpSocketFactoryClass" class="form-control uppercase"/><!-- value="javax.net.ssl.SSLSocketFactory"-->
                    </div>
                    <div class="form-group">
                        <label for="smtp_port" class="control-label">Smtp Port &nbsp;:</label>
                        <p id="content_smtpPort" ></p>
                        <input type="text" name="smtpPort" id="smtpPort"  placeholder="Smtp Port" oninput="isNumber()" class="form-control uppercase"/>
                    </div>
                    <div class="form-group">
                        <label for="email" class="control-label"> E-MAIL &nbsp;:</label>
                        <p id="content_email_config" ></p>
                        <input type="text" size="" name="email_form_config" id="email_form_config" oninput="cekEmail_email_config()"  class="form-control required ui-widget-content"/> <!--readonly="readonly"-->
                    </div>
                    <div class="form-group">
                        <label for="psswd" class="control-label">Password &nbsp;:</label>
                        <p id="content_pass_email_config" ></p>
                        <input type="password" name="pass_email_config" id="pass_email_config" oninput="cekPass_email_config()" placeholder="Password" class="form-control"/>
                    </div>
                </div>
                <div class="box-footer" align="center">
                    <button type="submit" class="btn btn-primary" id="btn_daftar">Submit</button>
                    <button type="reset"  class="btn btn-danger" value="Reset" id="btn_reset" onclick="myFunction_reset_form_email_config()">RESET</button>
                </div>

            </form>
        </div>
    </div>
</body>

