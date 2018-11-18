<%-- 
    Document   : add_supllier_form
    Created on : Sep 10, 2018, 10:59:51 AM
    Author     : newbiecihuy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<body>
    
    <section class="content-header">
        <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
            <li class="active">supllier</li>
            <li class="active">add</li>
        </ol>
    </section>
    <div class="panel panel-default">
        <div class="panel-body">
            <form>
                <table cellpadding="0" cellspacing="0"  style="border: 0px">
                    <td class="controls">
                        <a href="index.jsp?url=supllier_layout&pages=list_suplliers" class="btn btn-success" role="button" aria-pressed="true"><font color='#b6c5cd' size='2em'>View Suppliers</font></a>
                    </td>
                </table>
            </form>
            <form id="form_add_supplier" name="form_add_supplier" method="POST" action="">
                <div id="form_add_supplier_response" class="resp"></div>
                <div class="box-body">
                    <div class="form-group">
                        <label for="supplier_name" class="req">Supplier Name &nbsp;:</label>
                        <input type="text" name="supplier_name" id="supplier_name" class="form-control ui-widget-content sw uppercase" value="<%-- out.println(supplier_name);--%>" />
                        <input type="hidden" name="supplier_id" id="supplier_id" value="<%--out.println(supplier_id);--%>"/>
                        <input type="hidden" name="action_insert_supp" id="action_insert_supp"  class="form-control ui-widget-content sw uppercase"/>
                        <input type="hidden" name="action_edit_supp" id="action_edit_supp"  class="form-control ui-widget-content sw uppercase" value="<%--out.println(request.getParameter("action_edit_supp"));--%>"/>
                        <input type="hidden" name="action_delete_supp" id="action_delete_supp"  class="form-control ui-widget-content sw uppercase"/>
                        <span class="required-server"> </span>
                    </div> 
                    <div class="form-group">
                        <label for="supplier_code" class="req">Supplier Code&nbsp;:</label>
                        <input type="text" name="supplier_code" id="supplier_code"  placeholder="Suplier Code" class="form-control ui-widget-content sw uppercase" value="<%--out.println(supplier_code);--%>"/>
                        <span class="required-server"> </span>
                    </div>
                    <div class="form-group">
                        <label for="address_supplier" class="req">Address&nbsp;:</label>
                        <textarea  name="address_supplier" id="address_supplier"  placeholder="Adress"  class="form-control ui-widget-content sw uppercase"><%-- out.println(address_supplier);--%></textarea>
                        <span class="required-server"> </span>
                    </div>
                    <div class="form-group">
                        <label for="contact_suplier_name" class="req">Contact Name &nbsp;:</label>
                        <input type="text" name="contact_suplier_name" id="contact_suplier_name" class="form-control ui-widget-content sw uppercase" data-required="true" value="<%--out.println(contact_suplier_name);--%>" />
                        <span class="required-server"> </span>
                    </div>
                    <div class="form-group">
                        <label for="cotact_suplier_num" class="req">Contact Number &nbsp;:</label>
                        <input type="text" name="cotact_suplier_num" id="cotact_suplier_num"  class="required ui-widget-content form-control uppercase" value="<%--out.println(cotact_suplier_num);--%>"/>
                        <span class="required-server"> </span>
                    </div>
                    <div class="form-group">
                        <label for="tax" class="req">Tax &nbsp;:</label>
                        <label class="checkbox-inline" for="is_active_a">
                            <input type="checkbox" class="inline checkbox" name="tax" id="tax"><i id="checkbox_value" style="color:whitesmoke" class=""></i>
                        </label>
                    </div>



                    <!--                    <div class="form-group">
                                            <label for="status" class="req">  Status &nbsp;:</label>
                                            <div>
                                                <input type="radio" name="Status_"  id="gender" value="m"> Male<br>
                                                <input type="radio" name="gender"  id="gender" value="f"> Female<br>
                                                <p id="content_gender" >
                    
                                                </p>
                                            </div>
                                            <span class="required-server">   </span>
                    
                                        </div>-->

                </div>
                <div class="box-footer" align="center">
                    <button type="submit" class="btn btn-primary" id="btn_add_supplier">Submit</button>
                    <button type="reset"  class="btn btn-danger" value="Reset" id="btn_reset" onclick="myFunction_reset_formSupplier()">RESET</button>
                </div>

            </form> 
        </div>
    </div>
    <script type="text/javascript" >
        var supplier_name = getUrlQueryString('supplier_name');
        if (supplier_name !== "") {
            $("#supplier_name").val(supplier_name);
        } else {
            $("#supplier_name").val("");
        }
        var supplier_id = getUrlQueryString('supplier_id');
        if (supplier_id !== "") {
            $("#supplier_id").val(supplier_id);
        } else {
            $("#supplier_id").val("");
        }
        var action_edit_supp = getUrlQueryString('action_edit_supp');
        if (action_edit_supp !== "") {
            $("#action_edit_supp").val(action_edit_supp);
        } else {
            $("#action_edit_supp").val("");
        }
        var supplier_code = getUrlQueryString('supplier_code');
        if (supplier_code !== "") {
            $("#supplier_code").val(supplier_code);
        } else {
            $("#supplier_code").val("");
        }

        var address_supplier = getUrlQueryString('address_supplier');
        if (address_supplier !== "") {
            $("#address_supplier").val(address_supplier);
        } else {
            $("#address_supplier").val("");
        }
        var contact_suplier_name = getUrlQueryString('contact_suplier_name');
        if (contact_suplier_name !== "") {
            $("#contact_suplier_name").val(contact_suplier_name);
        } else {
            $("#contact_suplier_name").val("");
        }
        var cotact_suplier_num = getUrlQueryString('cotact_suplier_num');
        if (cotact_suplier_num !== "") {
            $("#cotact_suplier_num").val(cotact_suplier_num);
        } else {
            $("#cotact_suplier_num").val("");
        }
        var tax = getUrlQueryString('tax');
        if (tax === "1") {
            $("#tax").attr('checked', 'checked');
            $('#checkbox_value').text($('#tax').val());
        } else {
//            $("#tax").attr('checked', '');
            $('#checkbox_value').text($('#tax').val());
//            document.getElementById("checkbox_value").value = "false";
        }

    </script>
</body>
