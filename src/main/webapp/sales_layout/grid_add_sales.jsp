<%-- 
    Document   : sales
    Created on : Sep 25, 2018, 6:44:46 PM
    Author     : newbiecihuy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<body>
    <script type="text/javascript" src="sales_layout/script/grid_add_sales.js"></script>
    <section class="content-header">
        <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
            <li class="active">Purchase Order</li>
            <li class="active">add</li>
        </ol>
    </section>
    <div class="row mar-left-space">
        <div class="col-sm-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <div>
                        <span class="panel-title">Create S&#8228;O</span>
                        <span class="right-float">
                            <span class="right-float"><a href="index.jsp?url=sales_layout&pages=add_sales"  class="btn btn-info" role="button" aria-pressed="true"><font color='#f2f2f2' size='2em'>Add&#45;S&#8228;O&#8228;</font></a></span>
                        </span>
                    </div>

                    <div class="clearfix"></div>  
                </div>
                <div class="table-responsive">    
                    <form  name="tbl_grid_add_sales" id="tbl_grid_add_sales" class="display" >
                        <table name="grid_add_sales" id="grid_add_sales" class="table display dataTable no-footer table-hover dt-responsive display nowrap" cellspacing="0" width="100%">
                            <thead>
                                <tr>
                                    <th class="no">No.</th>
                                    <th class="purchase_id">Id</th>
                                    <th class="purchase_code">S&#8228;O&#8228; Number</th>                                    
                                    <th class="sales_id">sales_id</th>     
                                    <th class="merchant_name">Merchant Name</th> 
                                    <th class="merchant_code">Merchant Code</th> 
                                    <th class="supplier_tax">Tax</th> 
                                    <th class="tgl_input_so">P&#8228;O&#8228; Date</th> 
                                    <th class="so_type">P&#8228;O&#8228; Type</th> 
                                    <th class="payment_term">payment_term</th> 
                                    <th class="delivery_term">Delivery Term</th> 
                                    <th class="transport_mode">Transport Mode</th> 
                                    <th class="quotation_number">Quotation Number</th>
                                    <th class="rfq_number">rfq_number</th>
                                    <th class="dlvr_point">Delivery Point</th> 
                                    <th class="invoice_to">Invoice To</th> 
                                    <th class="purchase_desc">Desc</th> 
                                    <th class="status_so">Status</th> 
                                    <th class="pic">pic</th>      
                                    <th class="is_approve">Approval </th>      
                                    <th class="is_delete">Is_delete </th>      
                                    <th class="action_so">Action</th>  
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
            <li><a tabindex="0" href="#"  onclick="myFunction_report_excel_details()">Approve</a></li>
            <li><a tabindex="0" href="#"  onclick="myFunction_report_excel_details()">Report Excel</a></li>
        </ul>
    </div>
</body>
