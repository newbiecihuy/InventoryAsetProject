<%-- 
    Document   : add_supllier_form
    Created on : Sep 10, 2018, 10:59:51 AM
    Author     : newbiecihuy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<body>
    <%
//        String supplier_name = null;
//        String supplier_code = null;
//        if (request.getParameter("supplier_name") != null) {
//            supplier_name = request.getParameter("supplier_name").replaceAll("\\s", "");
//        }
//        if (request.getParameter("supplier_code") != null) {
//            supplier_code = request.getParameter("supplier_code").replaceAll("\\s", "");
//        }
        String supplier_code = "";
        if (request.getParameter("supplier_code") != null) {
            supplier_code = request.getParameter("supplier_code");
        }
        String supplier_name = "";
        if (request.getParameter("supplier_name") != null) {
            supplier_name = request.getParameter("supplier_name");
        }
        int supplier_id = 0;
        if (request.getParameter("supplier_id") != null) {
            supplier_id = Integer.parseInt(request.getParameter("supplier_id"));
        }

        String address_supplier = "";
        if (request.getParameter("address_supplier") != null) {
            address_supplier = request.getParameter("address_supplier");
        }
        String contact_suplier_name = "";
        if (request.getParameter("contact_suplier_name") != null) {
            contact_suplier_name = request.getParameter("contact_suplier_name");
        }
        String cotact_suplier_num = "";
        if (request.getParameter("cotact_suplier_num") != null) {
            cotact_suplier_num = request.getParameter("cotact_suplier_num");
        }
    %>
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
                <table cellpadding="0" cellspacing="0"  style="border: 0px" class="table">
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
                        <input type="text" name="supplier_name" id="supplier_name" class="form-control ui-widget-content sw uppercase" value="<% out.println(supplier_name);%>" />
                        <input type="hidden" name="supplier_id" id="supplier_id" value="<% out.println(supplier_id);%>"/>
                        <input type="hidden" name="action_insert_supp" id="action_insert_supp"  class="form-control ui-widget-content sw uppercase"/>
                        <input type="hidden" name="action_edit_supp" id="action_edit_supp"  class="form-control ui-widget-content sw uppercase" value="<% out.println(request.getParameter("action_edit_supp"));%>"/>
                        <input type="hidden" name="action_delete_supp" id="action_delete_supp"  class="form-control ui-widget-content sw uppercase"/>
                        <span class="required-server"> </span>
                    </div> 
                    <div class="form-group">
                        <label for="supplier_code" class="req">Supplier Code&nbsp;:</label>
                        <input type="text" name="supplier_code" id="supplier_code"  placeholder="Suplier Code" class="form-control ui-widget-content sw uppercase" value="<% out.println(supplier_code);%>"/>
                        <span class="required-server"> </span>
                    </div>
                    <div class="form-group">
                        <label for="address_supplier" class="req">Address&nbsp;:</label>
                        <textarea  name="address_supplier" id="address_supplier"  placeholder="Adress"  class="form-control ui-widget-content sw uppercase"><% out.println(address_supplier);%></textarea>
                        <span class="required-server"> </span>
                    </div>
                    <div class="form-group">
                        <label for="contact_suplier_name" class="req">Contact Name &nbsp;:</label>
                        <input type="text" name="contact_suplier_name" id="contact_suplier_name" class="form-control ui-widget-content sw uppercase" data-required="true" value="<% out.println(contact_suplier_name);%>" />
                        <span class="required-server"> </span>
                    </div>
                    <div class="form-group">
                        <label for="cotact_suplier_num" class="req">Contact Number &nbsp;:</label>
                        <input type="text" name="cotact_suplier_num" id="cotact_suplier_num"  class="required ui-widget-content form-control uppercase" value="<% out.println(cotact_suplier_num);%>"/>
                        <span class="required-server"> </span>
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
</body>
