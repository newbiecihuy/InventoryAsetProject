<%-- 
    Document   : list_items
    Created on : Sep 11, 2018, 11:42:01 AM
    Author     : newbiecihuy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<body>
    <script type="text/javascript" src="item_layout/script/list_items.js"></script>
    <section class="content-header">
        <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
            <li class="active">Items</li>
        </ol>
    </section>
    <div class="row mar-left-space">
        <div class="col-sm-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <div>
                        <span class="panel-title">Manage Items</span>
                        <span class="right-float">
                            <span class="right-float"><a href="index.jsp?url=item_layout&pages=form_add_item"  class="btn btn-info" role="button" aria-pressed="true"><font color='#f2f2f2' size='2em'>Add&#45;Item</font></a></span>
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
                    <form  name="tbl_grid_items" id="tbl_grid_items" class="display" >
                        <table name="grid_items" id="grid_items" class="table display dataTable no-footer table-hover dt-responsive display nowrap" cellspacing="0" width="100%">
                            <thead>
                                <tr>
                                    <th class="no">No.</th>
                                    <th class="id_product">Product Id</th>
                                    <th class="supplier_name">Supplier Name</th>
                                    <th class="supplier_id">Supplier Id</th>
                                     <th class="product_name">Item Name</th>
                                    <th class="product_code">Item Code</th>     
                                    <th class="price_item">Price Item</th>
                                    <th class="sell_price">Sales Price</th>
                                    <th class="id_stock">id_stock</th>
                                    <th class="estemated_date_before">estemated_date_before</th>
                                    <th class="estemated_date_after">estemated_date_after</th>
                                    <th class="category_id">category Id</th>
                                    <th class="name_category">Category</th>                                    
                                    <th class="description">Item Description</th>     
                                    <th class="status_item">Status</th>  
                                    <th class="create_date">Create Date</th> 
                                    <th class="pic">Pic</th>      
                                    <th class="action_item">Action</th>  
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
</body>
