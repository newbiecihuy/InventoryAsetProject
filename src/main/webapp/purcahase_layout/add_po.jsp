<%-- 
    Document   : add_po
    Created on : Sep 22, 2018, 5:51:43 PM
    Author     : newbiecihuy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<body>
    <section class="content-header">
        <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
            <li class="active">Purchase Order</li>
            <li class="active">add</li>
        </ol>
    </section>
    <div class="panel panel-default">
        <div class="panel-body ">
            <form>
                <table cellpadding="0" cellspacing="0"  style="border: 0px">
                    <td class="controls">
                        <a href="index.jsp?url=purcahase_layout&pages=grid_form_po" class="btn btn-success" role="button" aria-pressed="true"><font color='#b6c5cd' size='2em'>View list P&#8228;O&#8228;</font></a>
                    </td>
                </table>
            </form>
            <form id="form_add_po" name="form_add_po" class=" " method="POST" action="">
                <div id="ajaxResponse_form_add_po" class="resp"></div>
                <div class="box-body">

                    <div class="tab">
                        <h3>Supplier</h3>
                        <div class="form-group">
                            <label for="supplier_name_po" class="required">Supplier Name &nbsp;:</label>
                            <input type="text"  class="form-control" id="supplier_name_po" name="supplier_name_po" placeholder="Supplier Name" value="" onchange="supplier_empty()" required>
                            <span class="form-error"></span>
                        </div>
                        <div class="form-group">
                            <label for="supplier_code_po" class="required">Supplier Code &nbsp;:</label>
                            <input type="text" class="form-control" id="supplier_code_po"  placeholder="Supplier Code" name="supplier_code_po" value="" onchange="supplier_code_empty()" required>
                            <input type="text" class="form-control invisible" id="supplier_id_po" name="supplier_id_po" value="">
                            <input type="text" class="form-control invisible" id="purchase_id" name="purchase_id" value="">
                            <input type="text" class="form-control invisible" name="action_insert_po" id="action_insert_po" value=""/>
                            <input type="text" class="form-control invisible" name="action_edit_po" id="action_edit_po" value=""/>
                            <input type="text" class="form-control invisible"name="action_delete_po" id="action_delete_po" value=""/>
                            <input type="text" class="form-control invisible" name="tax_po" id="tax_po" value=""/>
                            <span class="form-error"></span>
                        </div>
                    </div>
                    <div class="tab">
                        <h3>Date P&#8228;O&#8228;</h3>
                        <div class="form-group">
                            <label for="tgl_input_po">Date &nbsp;:</label>
                            <input type="text" class="form-control datePick" id="tgl_input_po"  placeholder="dd/MM/yyyy" name="tgl_input_po" value="">
                            <span class="form-error"></span>
                        </div>

                        <div class="form-group">
                            <label for="po_type" class="required">Type &nbsp;:</label>
                            <input type="text"  class="form-control" id="po_type"  placeholder="P&#8228;O&#8228; Type" name="po_type" onchange="type_po_empty()" value="">
                            <span class="form-error"></span>
                        </div>
                        <div class="form-group">
                            <label for="payment_term" class="required">Payment Term &nbsp;:</label>
                            <input type="text" class="form-control" id="payment_term"  placeholder="Payment Term" name="payment_term" value="">
                            <span class="form-error"></span>
                        </div>
                        <div class="form-group">
                            <label for="delivery_term" class="required">Delivery Term &nbsp;:</label>
                            <input type="text"  required min="1"  class="form-control" id="delivery_term"  placeholder="Like 3 Day" oninput="cekNumber()" name="delivery_term"value="">
                            <p id="content_form_error" ></p>
                        </div>
                        <div class="form-group">
                            <label for="transport_mode" class="required">Transport Mode &nbsp;:</label>
                            <input type="text" required="" class="form-control" id="transport_mode"  placeholder="Like Expedition" name="transport_mode" value="">
                            <span class="form-error"></span>
                        </div>
                        <div class="form-group">
                            <label for="quotation_number" class="required">Quotation Number &nbsp;:</label>
                            <input type="text" required="" class="form-control" id="quotation_number"  placeholder="" name="quotation_number" value="">
                            <span class="form-error"></span>
                        </div>
                        <div class="form-group">
                            <label for="rfq_number" class="required">RFQ Number &nbsp;:</label>
                            <input type="text"  class="form-control" id="rfq_number"  placeholder="" name="rfq_number" value="">
                            <input type="text"  class="form-control invisible" name="id_po_type" id="id_po_type" value=""/>
                            <span class="form-error"></span>
                        </div>
                    </div>
                    <div class="tab">
                        <h3>Delivery Point&comma; Invoice &amp; Bank Transfer</h3>
                        <!--<section>-->
                        <div class="form-group">
                            <label for="purchase_desc" class="required">Description &nbsp;:</label>
                            <input type="text" class="form-control" id="purchase_desc"  placeholder="" name="purchase_desc" value="">
                            <span class="form-error"></span>
                        </div>
                        <div class="form-group">
                            <label for="invoice_to" class="required">Invoice To &nbsp;:</label>
                            <input type="text" required="" class="form-control" id="invoice_to"  placeholder="Invoice To" name="invoice_to" value="">
                            <span class="form-error"></span>
                        </div>
                        <div class="form-group">
                            <label for="dlvr_point" class="required">Delivery Point &nbsp;:</label>
                            <input type="text"  class="form-control" id="dlvr_point"  placeholder="Delivery Point" name="dlvr_point" value="">
                            <span class="form-error"></span>
                        </div>
                        <button type="submit" class="btn btn-primary" id="btn_add_supplier">Submit</button>
                        <button type="reset"  class="btn btn-danger" value="Reset" id="btn_reset" onclick="myFunction_reset_addPO()">RESET</button>
                        <!--</section>-->
                    </div>
                    <!--                        
                    <a href='#' class="btn btn-primary" onclick="add_input(); return false;" ><i class="fa fa fa-plus-square"></i> Add</a>
                    <a href='#' class="btn btn-warning" onclick="remove_form(); return false;"><i class="fa fa-minus-square"></i> Remove</a>
                    <button type="submit" class="btn btn-primary" id="btn_add_supplier">Submit</button>
                    <button type="reset"  class="btn btn-danger" value="Reset" id="btn_reset" onclick="myFunction_reset_addPO()">RESET</button>
                    
                </div>-->
                    <div style="overflow:auto;">
                        <div style="float:right;">
                            <button type="button" id="prevBtn" onclick="nextPrev(-1)">Previous</button>
                            <button type="button" id="nextBtn" onclick="nextPrev(1)">Next</button>
                        </div>
                    </div>
                    <div style="text-align:center;margin-top:40px;">
                        <span class="step"></span>
                        <span class="step"></span>
                    </div>
                </div>
                <!--                <div class="box-footer" align="center">
                                    <button type="submit" class="btn btn-primary" id="btn_add_supplier">Submit</button>
                                    <button type="reset"  class="btn btn-danger" value="Reset" id="btn_reset" onclick="myFunction_reset_addPO()">RESET</button>
                                </div>-->
            </form>
        </div>
    </div>
    <script type="text/javascript" >
        var purchase_id = getUrlQueryString('purchase_id');
        if (purchase_id !== "") {
            $("#purchase_id").val(purchase_id);
        } else {
            $("#purchase_id").val("");
        }
        var supplier_name_po = getUrlQueryString('supplier_name_po');
        if (supplier_name_po !== "") {
            $("#supplier_name_po").val(supplier_name_po);
        } else {
            $("#supplier_name_po").val("");
        }
        var supplier_code_po  = getUrlQueryString('supplier_code_po');
        if (supplier_code_po !== "") {
            $("#supplier_code_po").val(supplier_code_po);
        } else {
            $("#supplier_code_po").val("");
        }
        var supplier_id_po = getUrlQueryString('supplier_id_po');
        if (supplier_id_po !== "") {
            $("#supplier_id_po").val(supplier_id_po);
        } else {
            $("#supplier_id_po").val("");
        }
        var action_edit_po = getUrlQueryString('action_edit_po');
        if (action_edit_po !== "") {
            $("#action_edit_po").val(action_edit_po);
        } else {
            $("#action_edit_po").val("");
        }
        var tax_po = getUrlQueryString('tax_po');
        if (tax_po !== "") {
            $("#tax_po").val(tax_po);
        } else {
            $("#tax_po").val("");
        }
        var tgl_input_po = getUrlQueryString('tgl_input_po');
        if (tgl_input_po !== "") {
            $("#tgl_input_po").val(tgl_input_po);
        } else {
            $("#tgl_input_po").val("");
        }
        var po_type = getUrlQueryString('po_type');
        if (po_type !== "") {
            $("#po_type").val(po_type);
        } else {
            $("#po_type").val("");
        }
        var payment_term = getUrlQueryString('payment_term');
        if (payment_term !== "") {
            $("#payment_term").val(payment_term);
        } else {
            $("#payment_term").val("");
        }
        var delivery_term = getUrlQueryString('delivery_term');
        if (delivery_term !== "") {
            $("#delivery_term").val(delivery_term);
        } else {
            $("#delivery_term").val("");
        }
        var transport_mode = getUrlQueryString('transport_mode');
        if (transport_mode !== "") {
            $("#transport_mode").val(transport_mode);
        } else {
            $("#transport_mode").val("");
        }
        var quotation_number = getUrlQueryString('quotation_number');
        if (quotation_number !== "") {
            $("#quotation_number").val(quotation_number);
        } else {
            $("#quotation_number").val("");
        }
        var rfq_number = getUrlQueryString('rfq_number');
        if (rfq_number !== "") {
            $("#rfq_number").val(rfq_number);
        } else {
            $("#rfq_number").val("");
        }
        //        var id_po_type = getUrlQueryString('id_po_type');

        var purchase_desc = getUrlQueryString('purchase_desc');
        if (purchase_desc !== "") {
            $("#purchase_desc").val(purchase_desc);
        } else {
            $("#purchase_desc").val("");
        }
        var invoice_to = getUrlQueryString('invoice_to');
        if (invoice_to !== "") {
            $("#invoice_to").val(invoice_to);
        } else {
            $("#invoice_to").val("");
        }
        var dlvr_point = getUrlQueryString('dlvr_point');
        if (dlvr_point !== "") {
            $("#dlvr_point").val(dlvr_point);
        } else {
            $("#dlvr_point").val("");
        }
    </script>
</body>
