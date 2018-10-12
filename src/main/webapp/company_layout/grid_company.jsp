<%-- 
    Document   : grid_company
    Created on : Sep 28, 2018, 4:11:57 PM
    Author     : newbiecihuy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<body>
    <section class="content-header">
        <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
            <li class="active">category</li>
        </ol>
    </section>
    <div class="row mar-left-space">
        <div class="col-sm-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <div>
                        <span class="panel-title">Manage Category</span>
                        <span class="right-float">
                            <span class="right-float"><a href="index.jsp?ref=config&pages=form_company"  class="btn btn-info" role="button" aria-pressed="true"><font color='#f2f2f2' size='2em'>Manage&#45;Company Profile</font></a></span>
                        </span>
                    </div>

                    <div class="clearfix"></div>  
                </div>
                <div class="table-responsive">    

                    <form  name="tbl_grid_company" id="tbl_grid_company" class="display" >
                        <table name="grid_company" id="grid_company" class="table display dataTable no-footer table-hover dt-responsive display nowrap" cellspacing="0" width="100%">
                            <thead>
                                <tr>
                                    <th class="noCompany">No.</th>
                                    <th class="idCompany">idCompany</th>
                                    <th class="companyName">Company</th>
                                    <th class="companyAddrs">Address</th>    
                                    <th class="companyTitle">Title</th> 
                                    <th class="companyLogo">Logo</th>  
                                    <th class="isActive_company">Actived</th>
                                </tr>
                            </thead>

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
</body>

