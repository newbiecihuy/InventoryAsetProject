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

                    <form  name="tbl_grid_supplier" id="tbl_grid_supplier" class="display" >
                        <table name="grid_supplier" id="grid_supplier" class="table display dataTable no-footer table-hover table-bordered dt-responsive display nowrap" cellspacing="0" width="100%">
                            <thead class="thc">
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
                                    <th class="listItem">List Item</th>     
                                    <th class="action_supp">Action</th>     

                                </tr>
                            </thead>

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
            <li><a tabindex="0" href="#"  id="approve_supp" name="approve_supp" onclick="myFunctionUploadDataUser()">Approve</a></li>
            <li><a tabindex="0" href="#"  id="rejcet_supp" name="rejcet_supp">Reject</a></li>
        </ul>
    </div>
</body>
