<%-- 
    Document   : list_item_po
    Created on : Oct 24, 2018, 4:40:03 PM
    Author     : newbiecihuy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<body>
    <script type="text/javascript" src="purcahase_layout/script/list_item_po.js"></script>
    <section class="content-header">
        <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
            <li class="active">Item P&#8228;O&#8228;</li>
        </ol>
    </section>
    <div class="row mar-left-space">
        <div class="col-sm-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <div>
                        <span class="panel-title">Manage Item P&#8228;O&#8228;</span>
                        <span class="right-float">
                            <span class="right-float"><a href="index.jsp?ref=purcahase_layout&pages=grid_form_po"  class="btn btn-info" role="button" aria-pressed="true"><font color='#f2f2f2' size='2em'>Manage&#45;P&#8228;O&#8228;</font></a></span>
                        </span>
                    </div>

                    <div class="clearfix"></div>  
                </div>
                <div class="table-responsive">    

                    <form  name="tbl_grid_list_item_po" id="tbl_grid_list_item_po" class="display" >
                        <table name="grid_list_item_po" id="grid_list_item_po" class="table display dataTable no-footer table-hover dt-responsive display nowrap" cellspacing="0" width="100%">
                            <thead>
                                <tr>
                                    <th class="no_itemPo">No.</th>
                                    <th class="id_po">idPo</th>
                                    <th class="id_supplier_po">idSupplier</th>
                                    <th class="id_categories_po">idCategories</th>
                                    <th class="id_product_po">idproduct</th>
                                    <th class="supplier_name_po">supplier</th>
                                    <th class="supplier_code_po">supplier_code</th>
                                    <th class="supplier_tax_po">supplier_tax_po</th>
                                    <th class="product_name_po">Items</th>
                                    <th class="qtty_item_po">Qtty</th>
                                    <th class="price_item_po">Price</th>   
                                    <th class="pic_item_po">PIC</th>  
                                    <th class="is_delete">is_delete</th>  
                                    <th class="action_item_po">action</th> 
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
        </div>
    </div>
</body>