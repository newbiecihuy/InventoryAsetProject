<%-- 
    Document   : list_email
    Created on : Sep 13, 2018, 3:11:26 PM
    Author     : newbiecihuy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<body>
    <script type="text/javascript" src="config_layout/script/list_email.js"></script>
    <section class="content-header">
        <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
            <li class="active">Email</li>
        </ol>
        <div class="row mar-left-space">
            <div class="col-sm-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <div>
                            <span class="panel-title">list E-mail</span>
                            <span class="right-float"><a href="index.jsp?url=config_layout&pages=email_config" class='btn btn-info'><font color='#f2f2f2' size='2em'>E-mail&#45;Config</font></a></span>
                        </div>

                        <div class="clearfix"></div>  
                    </div> 
                    <div class="table-responsive">    
                        <!--                        <div id="introducerGrid_wrapper" class="dataTables_wrapper no-footer">
                                                    <div class="dataTables_length" id="introducerGrid_length"><label>Show 
                                                            <select name="introducerGrid_length" aria-controls="introducerGrid" class="">
                                                                <option value="10">10</option><option value="25">25</option><option value="50">50</option><option value="100">100
                                                                </option></select> entries</label></div>
                                                    <form>
                                                        <table cellpadding="0" cellspacing="0" class="table">
                                                            <div class="control-group">
                                                                <td class="controls">
                        
                                                                </td>
                                                            </div>
                                                        </table>
                                                    </form>-->
                        <form  name="tbl_grid_email_config" id="tbl_grid_email_config" class="display" >
                            <table name="grid_email_config" id="grid_email_config" class="table display dataTable no-footer table-hover table-bordered dt-responsive display nowrap" cellspacing="0" width="100%">
                                <thead>
                                    <tr>
                                        <th class="no_protocol">No.</th>
                                        <th class="idProtocol">idProtocol</th>
                                        <th class="smtpHost">Smtp Host</th>
                                        <th class="smtpSocketFactoryPort">Smtp Socket Factory Port</th>    
                                        <th class="smtpSocketFactoryClass">Smtp Socket Factory Class</th> 
                                        <th class="smtpPort">Smtp Port</th>  
                                        <th class="email">E-mail</th>
                                        <th class="email_pass">pass</th>
                                        <th class="isActive">active</th>
                                        <th class="action_email">Action</th>    
                                    </tr>
                                </thead>
                                <!--                                    <tfoot>
                                                                        <tr>
                                                                            <th>..</th>
                                                                            <th>Id</th>
                                                                            <th>Date Register</th>
                                                                            <th>User Name</th>
                                                                            <th>Gender</th>    
                                                                            <th>IMEI</th>               
                                                                            <th>Role Name</th>
                                                                            <th>E-MAIL</th>                    
                                                                            <th>Status</th>                    
                                                                            <th>Last Login</th>
                                                                            <th>--</th>
                                                                            <th>--</th>
                                                                        </tr>
                                                                    </tfoot>-->
                                <tbody>
                                </tbody>
                            </table>
                        </form>

                        <div id="contextMenu" class="dropdown clearfix">
                            <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu" style="display:block;position:static;margin-bottom:5px;">
                                <li><a tabindex="0" href="#" class="glyphicon glyphicon-remove-sign"></a></li>
                                <li class="divider"></li>
                                <li><a tabindex="0" href="#"  id="upload_users_details" name="upload_users_details" onclick="myFunctionUploadDataUser()">UPLOAD DATA</a></li>
                                <li><a tabindex="0" href="#"  id="edit_users_details" name="edit_users_details">EDIT</a></li>
                                <!--<li><a tabindex="0" href="#"  onclick="myFunction_report_excel_details()">Report Excel</a></li>-->
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
