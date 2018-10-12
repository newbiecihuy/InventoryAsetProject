<%-- 
    Document   : form_po
    Created on : Sep 20, 2018, 10:00:17 AM
    Author     : newbiecihuy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<body>
    <script type="text/javascript" src="purcahase_layout/script/grid_form_po.js"></script>
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
                        <span class="panel-title">Create P&#8228;O</span>
                        <span class="right-float">
                            <span class="right-float"><a href="index.jsp?url=purcahase_layout&pages=add_po"  class="btn btn-info" role="button" aria-pressed="true"><font color='#f2f2f2' size='2em'>Add&#45;P&#8228;O&#8228;</font></a></span>
                        </span>
                    </div>

                    <div class="clearfix"></div>  
                </div>
                <div class="table-responsive">    

                    <form  name="tbl_grid_form_po" id="tbl_grid_form_po" class="display" >
                        <table name="grid_form_po" id="grid_form_po" class="table display dataTable no-footer table-hover dt-responsive display nowrap" cellspacing="0" width="100%">
                            <thead>
                                <tr>
                                    <th class="no">No.</th>
                                    <th class="purchase_id">Id</th>
                                    <th class="purchase_code">P&#8228;O&#8228; Number</th>                                    
                                    <th class="supplier_id">supplier_id</th>     
                                    <th class="supplier_name">Supplier Name</th> 
                                    <th class="tgl_input_po">P&#8228;O&#8228; Date</th> 
                                    <th class="po_type">P&#8228;O&#8228; Type</th> 
                                    <th class="delivery_term">Delivery Term</th> 
                                    <th class="transport_mode">Transport Mode</th> 
                                    <th class="quotation_number">Quotation Number</th>
                                    <th class="dlvr_point">Delivery Point</th> 
                                    <th class="invoice_to">Invoice To</th> 
                                    <th class="purchase_desc">Desc</th> 
                                    <th class="status_po">Status</th> 
                                    <th class="pic">pic</th>      
                                    <th class="is_approve">Approval </th>      
                                    <th class="is_delete">Is_delete </th>      
                                    <th class="action_po">Action</th>  
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
    <!--    <form id="form_add_po" name="form_add_po" class="invisible " method="POST" action="">
            <div id="ajaxResponse_form_add_po" class="resp"></div>
            <div class="box-body hidden_add_po">
                <div class="form-group">
                    <label for="title" class="required">Supplier Name &nbsp;:</label>
                    <input type="text" class="form-control" id="supplier_name" name="supplier_name" placeholder="Supplier Name" onblur="supplier_empty()">
                    <input type="hidden" class="form-control" id="supplier_id" name="supplier_id">
                    <input type="hidden" class="form-control" id="purchase_id" name="purchase_id">
                    <input type="hidden" name="action_insert_po" id="action_insert_po" value=""/>
                    <input type="hidden" name="action_edit_po" id="action_edit_po"/>
                    <input type="hidden" name="action_delete_po" id="action_delete_po"/>
    
                    <span class="form-error"></span>
                </div>
                <div class="form-group">
                    <label for="supplier_code"class="required">Supplier Code &nbsp;:</label>
                    <input type="text" class="form-control" id="supplier_code"  placeholder="Supplier Name" name="supplier_code" onblur="supplier_empty()">
                    <span class="form-error"></span>
                </div>
                <div class="form-group">
                    <label for="tgl_input_po">Date &nbsp;:</label>
                    <input type="text" class="form-control datePick" id="tgl_input_po"  placeholder="dd/MM/yyyy" name="tgl_input_po">
                    <span class="form-error"></span>
                </div>
                <div class="form-group">
                    <label for="supplier_code"class="required">Type &nbsp;:</label>
                    <input type="text" class="form-control" id="po_type"  placeholder="P&#8228;O&#8228; Type" name="po_type" onblur="supplier_empty()">
                    <span class="form-error"></span>
                </div>
                <div class="form-group">
                    <label for="delivery_term"class="required">Delivery Term &nbsp;:</label>
                    <input type="number" required="" min="1" value="0" class="form-control" id="delivery_term"  placeholder="Like 3" name="delivery_term">
                    <span class="form-error"></span>
                </div>
                <div class="form-group">
                    <label for="transport_mode"class="required">Transport Mode &nbsp;:</label>
                    <input type="text" required="" class="form-control" id="transport_mode"  placeholder="Like Expedition" name="transport_mode">
                    <span class="form-error"></span>
                </div>
                <div class="form-group">
                    <label for="transport_mode"class="required">Quotation Number &nbsp;:</label>
                    <input type="text" required="" class="form-control" id="quotation_number"  placeholder="" name="quotation_number">
                    <span class="form-error"></span>
                </div>
                <div class="form-group">
                    <label for="transport_mode"class="required">RFQ Number &nbsp;:</label>
                    <input type="text" class="form-control" id="rfq_number"  placeholder="" name="rfq_number">
                    <span class="form-error"></span>
                </div>
    
                <div class="form-group">
                    <label for="purchase_desc"class="required">Description &nbsp;:</label>
                    <input type="text" class="form-control" id="purchase_desc"  placeholder="Description" name="purchase_desc">
                    <span class="form-error"></span>
                </div>
    
            </div>
        </form>-->

    <!--    <div id="contextMenu" class="dropdown clearfix">
            <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu" style="display:block;position:static;margin-bottom:5px;">
                <li><a tabindex="0" href="#" class="glyphicon glyphicon-remove-sign"></a></li>
                <li class="divider"></li>
                <li><a tabindex="0" href="#"  id="create_po" name="create_po" onclick="myFunctionCreatePO()">CREATE PO</a></li>
                <li><a tabindex="0" href="#"  onclick="myFunction_report_excel_details()">Report Excel</a></li>
            </ul>
        </div>-->

</body>
