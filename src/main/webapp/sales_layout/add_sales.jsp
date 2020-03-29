<%-- 
    Document   : add_sales
    Created on : Jun 3, 2019, 7:49:14 AM
    Author     : newbiecihuy
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<body>
    <section class="content-header">
        <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
            <li class="active">Sales Order</li>
            <li class="active">add</li>
        </ol>
    </section>
    <div class="panel panel-default">
        <div class="panel-body ">
            <form>
                <table cellpadding="0" cellspacing="0"  style="border: 0px">
                    <td class="controls">
                        <a href="index.jsp?url=sales_layout&pages=grid_add_sales" class="btn btn-success" role="button" aria-pressed="true"><font color='#b6c5cd' size='2em'>View list S&#8228;O&#8228;</font></a>
                    </td>
                </table>
            </form>
            <form id="form_add_po" name="form_add_po" class=" " method="POST" action="">
                <div id="ajaxResponse_form_add_sales" class="resp"></div>
                <div class="box-body">

                    <div class="tab">
                        <h3>Merchant</h3>
                        <div class="form-group">
                            <label for="supplier_name_po" class="required">Customer Name &nbsp;:</label>
                            <input type="text"  class="form-control" id="customer_name_so" name="customer_name_so" placeholder="Customer Name" value="" onchange="merchant_empty()" required>
                            <span class="form-error"></span>
                        </div>
                        <div class="form-group">
                            <label for="supplier_code_po" class="required">Customer Code &nbsp;:</label>
                            <input type="text" class="form-control" id="customer_code_so"  placeholder="Customer Code" name="customer_code_so" value="" onchange="merchant_code_empty()" required>
                            <input type="text" class="form-control invisible" id="merchant_id_so" name="customer_id_so" value="">
                            <input type="text" class="form-control invisible" id="purchase_id" name="sales_order_id" value="">
                            <input type="text" class="form-control invisible" name="action_insert_so" id="action_insert_so" value=""/>
                            <input type="text" class="form-control invisible" name="action_edit_so" id="action_edit_so" value=""/>
                            <input type="text" class="form-control invisible" name="action_delete_so" id="action_delete_so" value=""/>
                            <input type="text" class="form-control invisible" name="tax_so" id="tax_po" value=""/>
                            <span class="form-error"></span>
                        </div>
                    </div>
                    <div class="tab">
                        <h3>Date S&#8228;O&#8228;</h3>
                        <div class="form-group">
                            <label for="tgl_input_po">Date &nbsp;:</label>
                            <input type="text" class="form-control datePick" id="tgl_input_so"  placeholder="dd/MM/yyyy" name="tgl_input_so" value="">
                            <span class="form-error"></span>
                        </div>

                        <!--                        <div class="form-group">
                                                    <label for="po_type" class="required">Type &nbsp;:</label>
                                                    <input type="text"  class="form-control" id="po_type"  placeholder="P&#8228;O&#8228; Type" name="po_type" onchange="type_po_empty()" value="">
                                                    <span class="form-error"></span>
                                                </div>-->
                        <div class="form-group">
                            <label for="payment_term" class="required">Payment Term &nbsp;:</label>
                            <input type="text" class="form-control" id="payment_term_so"  placeholder="Payment Term" name="payment_term_so" value="">
                            <span class="form-error"></span>
                        </div>
                        <div class="form-group">
                            <label for="delivery_term_so" class="required">Delivery Term &nbsp;:</label>
                            <input type="text"  required min="1"  class="form-control" id="delivery_term_so"  placeholder="Like 3 Day" oninput="cekNumber()" name="delivery_term_so" value="" >
                            <p id="content_form_error" ></p>
                        </div>
                        <div class="form-group">
                            <label for="transport_mode" class="required">Transport Mode &nbsp;:</label>
                            <input type="text" required="" class="form-control" id="transport_mode_so"  placeholder="Like Expedition" name="transport_mode_so" value="">
                            <span class="form-error"></span>
                        </div>
                        <div class="form-group">
                            <label for="quotation_number" class="required">Quotation Number &nbsp;:</label>
                            <input type="text" required="" class="form-control" id="quotation_number_so"  placeholder="" name="quotation_number_so" value="">
                            <span class="form-error"></span>
                        </div>
                        <div class="form-group">
                            <label for="rfq_number" class="required">RFQ Number &nbsp;:</label>
                            <input type="text"  class="form-control" id="rfq_number_so"  placeholder="" name="rfq_number_so" value="">
                            <input type="text"  class="form-control invisible" name="id_so_type" id="id_so_type" value=""/>
                            <span class="form-error"></span>
                        </div>
                    </div>
                    <div class="tab">
                        <h3>Delivery Point&comma; Invoice &amp; Bank Transfer</h3>
                        <!--<section>-->
                        <div class="form-group">
                            <label for="so_desc" class="required">Description &nbsp;:</label>
                            <input type="text" class="form-control" id="so_desc"  placeholder="" name="so_desc" value="">
                            <span class="form-error"></span>
                        </div>
                        <div class="form-group">
                            <label for="invoice_to_so" class="required">Invoice To &nbsp;:</label>
                            <input type="text" required="" class="form-control" id="invoice_to_so"  placeholder="Invoice To" name="invoice_to_so" value="">
                            <span class="form-error"></span>
                        </div>
                        <div class="form-group">
                            <label for="dlvr_pointso" class="required">Delivery Point &nbsp;:</label>
                            <input type="text"  class="form-control" id="dlvr_point_so"  placeholder="Delivery Point" name="dlvr_point_so" value="">
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
        var sales_order_id = getUrlQueryString('sales_order_id');
        if (sales_order_id !== "") {
            $("#sales_order_id").val(sales_order_id);
        } else {
            $("#sales_order_id").val("");
        }
        var customer_name_so = getUrlQueryString('customer_name_so');
        if (customer_name_so !== "") {
            $("#customer_name_so").val(customer_name_so);
        } else {
            $("#customer_name_so").val("");
        }
        var customer_code_so = getUrlQueryString('customer_code_so');
        if (customer_code_so !== "") {
            $("#customer_code_so").val(customer_code_so);
        } else {
            $("#customer_code_so").val("");
        }
        var customer_id_so = getUrlQueryString('customer_id_so');
        if (customer_id_so !== "") {
            $("#customer_id_so").val(customer_id_so);
        } else {
            $("#customer_id_so").val("");
        }
        var action_edit_so = getUrlQueryString('action_edit_so');
        if (action_edit_so !== "") {
            $("#action_edit_so").val(action_edit_so);
        } else {
            $("#action_edit_so").val("");
        }
        var tax_po = getUrlQueryString('tax_po');
        if (tax_po !== "") {
            $("#tax_po").val(tax_po);
        } else {
            $("#tax_po").val("");
        }
        var tgl_input_so = getUrlQueryString('tgl_input_so');
        if (tgl_input_so !== "") {
            $("#tgl_input_so").val(tgl_input_so);
        } else {
            $("#tgl_input_so").val("");
        }
        var so_type = getUrlQueryString('so_type');
        if (so_type !== "") {
            $("#so_type").val(so_type);
        } else {
            $("#so_type").val("");
        }
        var payment_term_so = getUrlQueryString('payment_term_so');
        if (payment_term_so !== "") {
            $("#payment_term_so").val(payment_term_so);
        } else {
            $("#payment_term_so").val("");
        }
        var delivery_term_so = getUrlQueryString('delivery_term_so');
        if (delivery_term_so !== "") {
            $("#delivery_term_so").val(delivery_term_so);
        } else {
            $("#delivery_term_so").val("");
        }
        var transport_mode_so = getUrlQueryString('transport_mode_so');
        if (transport_mode_so !== "") {
            $("#transport_mode_so").val(transport_mode_so);
        } else {
            $("#transport_mode_so").val("");
        }
        var quotation_number_so = getUrlQueryString('quotation_number_so');
        if (quotation_number_so !== "") {
            $("#quotation_number_so").val(quotation_number_so);
        } else {
            $("#quotation_number_so").val("");
        }
        var rfq_number_so = getUrlQueryString('rfq_number_so');
        if (rfq_number_so !== "") {
            $("#rfq_number_so").val(rfq_number_so);
        } else {
            $("#rfq_number_so").val("");
        }
        //        var id_po_type = getUrlQueryString('id_po_type');

        var so_desc = getUrlQueryString('so_desc');
        if (so_desc !== "") {
            $("#so_desc").val(so_desc);
        } else {
            $("#so_desc").val("");
        }
        var invoice_to_so = getUrlQueryString('invoice_to_so');
        if (invoice_to_so !== "") {
            $("#invoice_to_so").val(invoice_to_so);
        } else {
            $("#invoice_to_so").val("");
        }
        var dlvr_point_so = getUrlQueryString('dlvr_point_so');
        if (dlvr_point_so !== "") {
            $("#dlvr_point_so").val(dlvr_point);
        } else {
            $("#dlvr_point_so").val("");
        }
    </script>
</body>
