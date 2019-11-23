<%-- 
    Document   : list_categories
    Created on : Sep 13, 2018, 10:01:48 AM
    Author     : newbiecihuy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<body>
    <script type="text/javascript" src="item_layout/script/list_categories.js"></script>
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
                            <span class="right-float"><a href="index.jsp?url=item_layout&pages=add_category_form"  class="btn btn-info" role="button" aria-pressed="true"><font color='#f2f2f2' size='2em'>Add&#45;Category</font></a></span>
                        </span>
                    </div>

                    <div class="clearfix"></div>  
                </div>
                <div class="table-responsive">    
                 <div id="grid_categories_response"></div>
                    <form  name="tbl_grid_categories" id="tbl_grid_categories" class="display" >
                        <table name="grid_categories" id="grid_categories" class="table display dataTable no-footer table-hover table-bordered dt-responsive display nowrap" cellspacing="0" width="100%">
                            <thead class="thc">
                                <tr>
                                    <th class="no">No.</th>
                                    <th class="category_id">Id</th>
                                    <th class="name_categories">Category</th>         
                                    <th class="is_delete">Status</th> 
                                    <th class="create_date">Create Date</th> 
                                    <th class="pic">pic</th>      
                                    <th class="action_category">Action</th>  
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
                </div>
            </div>
        </div>
    </div>
    <div id="contextMenu" class="dropdown clearfix">
        <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu" style="display:block;position:static;margin-bottom:5px;">
            <li><a tabindex="0" href="#" class="glyphicon glyphicon-remove-sign"></a></li>
            <li class="divider"></li>
            <li><a tabindex="0" href="#"  id="upload_users_details" name="upload_users_details" onclick="myFunctionUploadDataUser()">UPLOAD DATA</a></li>
            <li><a tabindex="0" href="#"  id="edit_users_details" name="edit_users_details">EDIT</a></li>
            <!--<li><a tabindex="0" href="#"  onclick="myFunction_report_excel_details()">Report Excel</a></li>-->
        </ul>
    </div>
</body>