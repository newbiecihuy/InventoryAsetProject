<%-- 
    Document   : list_stock_item
    Created on : Sep 13, 2018, 3:04:48 PM
    Author     : newbiecihuy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<body>
    <script type="text/javascript" src="item_layout/script/list_stock_item.js"></script>
    <section class="content-header">
        <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
            <li class="active">List Item &#91;raw&#93;</li>
        </ol>
    </section>
    <div class="row mar-left-space">
        <div class="col-sm-12">
            <div class="panel panel-default">
                <div class="panel-heading">
<!--                    <div>
                        <span class="panel-title">Manage Item P&#8228;O&#8228;</span>
                        <span class="right-float">
                            <span class="right-float"><a href="index.jsp?url=purcahase_layout&pages=grid_form_po" class="btn btn-success" role="button" aria-pressed="true"><font color='#f2f2f2' size='2em'>View list P&#8228;O&#8228;</font></a></span>
                        </span>
                    </div>-->

                    <div class="clearfix"></div>  
                </div>
                <div class="table-responsive">    

                    <form  name="tbl_grid_list_stock_item" id="tbl_grid_list_stock_item" class="display" >
                        <table name="grid_list_stock_item" id="grid_list_stock_item" class="table display dataTable no-footer table-hover table-bordered dt-responsive display nowrap" cellspacing="0" width="100%">
                             <thead class="thc">
                                <tr>
                                    <th class="no_item_raw">No.</th>
                                    <th class="id_item_raw">id_item</th>
                                    <th class="id_supplier_raw">idSupplier</th>
                                    <th class="id_categories_raw">idCategories</th>
                                    <th class="categories_raw">Categories</th>  
                                    <th class="item_code_raw">Item Code</th>
                                    <th class="item_name_raw">Item Name</th>
                                    <th class="item_desc_raw">Desc</th>
                                    <th class="id_stock_raw">id_stock_raw</th>
                                    <th class="item_stock_raw">Stock</th>
                                    <th class="item_sell_price_raw">Price</th>
                                </tr>
                            </thead>

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
            <script type="text/javascript" >
                var purchase_id = getUrlQueryString('purchase_id');

                if (purchase_id !== "") {
                    $("#purchase_id").val(purchase_id);
                } else {
                    $("#purchase_id").val("");
                }
                var supplier_id_po = getUrlQueryString('supplier_id_form_create_po');
                if (supplier_id_po !== "") {
                    $("#supplier_id_form_create_po").val(supplier_id_po);
                } else {
                    $("#supplier_id_form_create_po").val("");
                }
            </script>
        </div>
    </div>
</body>