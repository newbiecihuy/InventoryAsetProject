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
                <table cellpadding="0" cellspacing="0"  style="border: 0px" class="table">
                    <td class="controls">
                        <a href="index.jsp?url=purcahase_layout&pages=grid_form_po" class="btn btn-success" role="button" aria-pressed="true"><font color='#b6c5cd' size='2em'>View list P&#8228;O&#8228;</font></a>
                    </td>
                </table>
            </form>
            <!--            <form id="form_add_po" action="">
                            <div id="ajaxResponse_form_add_po" class="resp"></div>
                             One "tab" for each step in the form: 
                            <div class="tab">
                                <label for="supplier_code_po" >Supplier Name &nbsp;:</label>
                                <p><input class="form-control" oninput="this.className = ''" id="supplier_name_po" required="" name="supplier_name_po" placeholder="Supplier Name" onchange="supplier_empty()"></p>
                                <label for="supplier_code_po" >Supplier Code &nbsp;:</label>
                                <p><input class="form-control" oninput="this.className = ''" id="supplier_code_po" required=""  placeholder="Supplier Code" name="supplier_code_po" onchange="supplier_code_empty()"></p>
                                <p><input class="form-control invisible" name="supplier_id_po" id="supplier_id_po"></p>
                                <p><input class="form-control invisible" name="purchase_id"  id="purchase_id"></p>
                                <p><input class="form-control invisible" name="action_insert_po" id="action_insert_po"/></p>
                                <p><input class="form-control invisible" name="action_edit_po" id="action_edit_po"/></p>
                                <p><input class="form-control invisible" name="action_delete_po" id="action_delete_po"/></p>
                                
            
                            </div>
                            <div class="tab">Contact Info:
                                <p><input placeholder="E-mail..." oninput="this.className = ''" name="email"></p>
                                <p><input placeholder="Phone..." oninput="this.className = ''" name="phone"></p>
                            </div>
                            <div class="tab">Birthday:
                                <p><input placeholder="dd" oninput="this.className = ''" name="dd"></p>
                                <p><input placeholder="mm" oninput="this.className = ''" name="nn"></p>
                                <p><input placeholder="yyyy" oninput="this.className = ''" name="yyyy"></p>
                            </div>
                            <div class="tab">Login Info:
                                <p><input placeholder="Username..." oninput="this.className = ''" name="uname"></p>
                                <p><input placeholder="Password..." oninput="this.className = ''" name="pword" type="password"></p>
                                <a href='#' class="btn btn-primary" onclick="add_input(); return false;" ><i class="fa fa fa-plus-square"></i> Add</a>
                                <a href='#' class="btn btn-warning" onclick="remove_form(); return false;"><i class="fa fa-minus-square"></i> Remove</a>
                            </div>
                            <div style="overflow:auto;">
                                <div style="float:right;">
                                    <button type="button" id="prevBtn" onclick="nextPrev(-1)">Previous</button>
                                    <button type="button" id="nextBtn" onclick="nextPrev(1)">Next</button>
                                </div>
                            </div>
                             Circles which indicates the steps of the form: 
                            <div style="text-align:center;margin-top:40px;">
                                <span class="step"></span>
                                <span class="step"></span>
                                <span class="step"></span>
                                <span class="step"></span>
                            </div>
                        </form>-->
            <form id="form_add_po" name="form_add_po" class=" " method="POST" action="">
                <div id="ajaxResponse_form_add_po" class="resp"></div>
                <div class="box-body">
                    <div class="tab">
                        <div class="form-group"> Supplier :
                            <label for="supplier_name_po" class="required">Supplier Name &nbsp;:</label>
                            <input  class="form-control" id="supplier_name_po" name="supplier_name_po" placeholder="Supplier Name" onchange="supplier_empty()" required>
                            <span class="form-error"></span>
                        </div>
                        <div class="form-group">
                            <label for="supplier_code_po" class="required">Supplier Code &nbsp;:</label>
                            <input class="form-control" id="supplier_code_po"  placeholder="Supplier Code" name="supplier_code_po" onchange="supplier_code_empty()" required>
                            <input  class="form-control invisible" id="supplier_id_po" name="supplier_id_po">
                            <input  class="form-control invisible" id="purchase_id" name="purchase_id">
                            <input  class="form-control invisible" name="action_insert_po" id="action_insert_po"/>
                            <input  class="form-control invisible" name="action_edit_po" id="action_edit_po"/>
                            <input  class="form-control invisible"name="action_delete_po" id="action_delete_po"/>
                            <span class="form-error"></span>
                        </div>
                    </div>
                    <div class="tab">
                        <div class="form-group">
                            <label for="tgl_input_po">Date &nbsp;:</label>
                            <input class="form-control datePick" id="tgl_input_po"  placeholder="dd/MM/yyyy" name="tgl_input_po">
                            <span class="form-error"></span>
                        </div>

                        <div class="form-group">
                            <label for="po_type" class="required">Type &nbsp;:</label>
                            <input  class="form-control" id="po_type"  placeholder="P&#8228;O&#8228; Type" name="po_type" onchange="type_po_empty()">
                            <span class="form-error"></span>
                        </div>
                        <div class="form-group">
                            <label for="payment_term" class="required">Payment Term &nbsp;:</label>
                            <input class="form-control" id="payment_term"  placeholder="Payment Term" name="payment_term" >
                            <span class="form-error"></span>
                        </div>
                        <div class="form-group">
                            <label for="delivery_term" class="required">Delivery Term &nbsp;:</label>
                            <input  required min="1"  class="form-control" id="delivery_term"  placeholder="Like 3 Day" oninput="cekNumber()" name="delivery_term">
                            <p id="content_form_error" ></p>
                        </div>
                        <div class="form-group">
                            <label for="transport_mode" class="required">Transport Mode &nbsp;:</label>
                            <input required="" class="form-control" id="transport_mode"  placeholder="Like Expedition" name="transport_mode">
                            <span class="form-error"></span>
                        </div>
                        <div class="form-group">
                            <label for="quotation_number" class="required">Quotation Number &nbsp;:</label>
                            <input required="" class="form-control" id="quotation_number"  placeholder="" name="quotation_number">
                            <span class="form-error"></span>
                        </div>
                        <div class="form-group">
                            <label for="transport_mode" class="required">RFQ Number &nbsp;:</label>
                            <input  class="form-control" id="rfq_number"  placeholder="" name="rfq_number">
                            <input  class="form-control invisible" name="id_po_type" id="id_po_type"/>
                            <span class="form-error"></span>
                        </div>

                    </div>
                    <div class="tab"> Delivery Point&comma; Invoice &amp; Bank Transfer
                        <div class="form-group">
                            <label for="purchase_desc" class="required">Description &nbsp;:</label>
                            <input class="form-control" id="purchase_desc"  placeholder="" name="purchase_desc">
                            <span class="form-error"></span>
                        </div>
                        <div class="form-group">
                            <label for="transport_mode" class="required">Invoice To &nbsp;:</label>
                            <input required="" class="form-control" id="invoice_to"  placeholder="Invoice To" name="invoice_to">
                            <span class="form-error"></span>
                        </div>
                        <div class="form-group">
                            <label for="transport_mode" class="required">Delivery Point &nbsp;:</label>
                            <input  class="form-control" id="dlvr_point"  placeholder="Delivery Point" name="dlvr_point">
                            <span class="form-error"></span>
                        </div>
                        <a href='#' class="btn btn-primary" onclick="add_input(); return false;" ><i class="fa fa fa-plus-square"></i> Add</a>
                        <a href='#' class="btn btn-warning" onclick="remove_form(); return false;"><i class="fa fa-minus-square"></i> Remove</a>
                        <!--                    <button type="submit" class="btn btn-primary" id="btn_add_supplier">Submit</button>
                                                <button type="reset"  class="btn btn-danger" value="Reset" id="btn_reset" onclick="myFunction_reset_addPO()">RESET</button>-->
                    </div>
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
</body>
