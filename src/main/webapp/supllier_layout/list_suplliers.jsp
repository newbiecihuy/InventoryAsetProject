<%-- 
    Document   : list_suplliers
    Created on : Sep 10, 2018, 11:00:35 AM
    Author     : newbiecihuy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<body>
    <script type="text/javascript" src="supllier_layout/script/list_suplliers.js"></script>
    <section class="content-header">
        <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
            <li class="active">suppliers</li>
        </ol>
    </section>
    <div class="row mar-left-space">
        <div class="col-sm-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <div>
                        <span class="panel-title">Manage Suplliers</span>
                        <span class="right-float">
                            <span class="right-float"><a href="index.jsp?url=supllier_layout&pages=add_supllier_form"  class="btn btn-info" role="button" aria-pressed="true"><font color='#f2f2f2' size='2em'>Add&#45;Supplier</font></a></span>
                        </span>
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
                    <form  name="tbl_grid_supplier" id="tbl_grid_supplier" class="display" >
                        <table name="grid_supplier" id="grid_supplier" class="table display dataTable no-footer table-hover dt-responsive display nowrap" cellspacing="0" width="100%">
                            <thead>
                                <tr>
                                    <th class="no">No.</th>
                                    <th class="supplier_id">Id</th>
                                    <th class="supplier_name">Supplier Name</th>
                                    <th class="supplier_code">Supplier Code</th>
                                    <th class="address">Supplier Address</th>
                                    <th class="contact_name">Contact Name</th>    
                                    <th class="contact_num">Contact Number</th>   
                                    <th class="tax">tax</th> 
                                    <th class="status_supp">Status</th>     
                                    <th class="created_date">Added Date</th>
                                    <th class="action_supp">Action</th>     

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

<!--                    <div id="contextMenu" class="dropdown clearfix">
                        <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu" style="display:block;position:static;margin-bottom:5px;">
                            <li><a tabindex="0" href="#" class="glyphicon glyphicon-remove-sign"></a></li>
                            <li class="divider"></li>
                            <li><a tabindex="0" href="#"  id="upload_users_details" name="upload_users_details" onclick="myFunctionUploadDataUser()">UPLOAD DATA</a></li>
                            <li><a tabindex="0" href="#"  id="edit_users_details" name="edit_users_details">EDIT</a></li>
                            <li><a tabindex="0" href="#"  onclick="myFunction_report_excel_details()">Report Excel</a></li>
                        </ul>
                    </div>-->
                </div>
            </div>
        </div>
    </div>
</body>
