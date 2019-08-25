<%-- 
    Document   : form_item_po
    Created on : Sep 20, 2018, 3:00:04 PM
    Author     : newbiecihuy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<body>
    <%
        String purchase_id = "";
        if (request.getParameter("purchase_id") != null) {
            purchase_id = request.getParameter("purchase_id");
        }
        String supplier_id_form_create_po = "";
        if (request.getParameter("supplier_id_form_create_po") != null) {
            supplier_id_form_create_po = request.getParameter("supplier_id_form_create_po");
        }
        String id_add_item_po = "";
        if (request.getParameter("id_add_item_po") != null) {
            id_add_item_po = request.getParameter("id_add_item_po");
        }
        String action_edit_item_po = "";
        if (request.getParameter("action_edit_item_po") != null) {
            action_edit_item_po = request.getParameter("action_edit_item_po");
        }
        String tax_item_po = "";
        if (request.getParameter("tax_item_po") != null) {
            tax_item_po = request.getParameter("tax_item_po");
        }
        String tax_po = "";
        if (request.getParameter("tax_po_val") != null) {
            tax_po = request.getParameter("tax_po_val");
        }
        int id_product_purchase = 0;
        if (request.getParameter("id_product_purchase") != null) {
            id_product_purchase = Integer.parseInt(request.getParameter("id_product_purchase"));
        }
        String val_tax_po = "";
        if (request.getParameter("val_tax_po") != null) {
            val_tax_po = request.getParameter("val_tax_po");
        }
    %>  
    <section class="content-header">
        <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
            <li class="active">Purchase Order</li>
            <li class="active">Add Item Purcahse</li>
        </ol>
    </section>
    <div class="panel panel-default">
        <div class="panel-body">
            <form>
                <table cellpadding="0" cellspacing="0"  style="border: 0px">
                    <td class="controls">
                        <a href="index.jsp?url=purcahase_layout&pages=grid_form_po" class="btn btn-success" role="button" aria-pressed="true"><font color='#b6c5cd' size='2em'>View list P&#8228;O&#8228;</font></a>
                    </td>
                </table>
            </form>
            &nbsp;
            <form id="form_create_po"  name="form_create_po" class="form-horizontal" method="POST" action="" class="display" >
                <!--<p id="content_form_delegate" class="message success" ></p>-->
                <legend class="display ui-widget ui-widget-header ui-corner-all">Add Item Purcahse</legend>
                <!--                <div id="ajaxResponse_form_create_po" class="resp"></div>-->
                <div id="ajaxResponse_form_create_po"></div>
                <table  name="data_table" id="data_table" class="table display dataTable no-footer table-hover dt-responsive nowrap" cellspacing="0" width="100%">
                    <input type="hidden" readonly="readonly"  name="purchase_id" id="purchase_id" value="<% out.println(purchase_id);%>"/>
                    <input type="hidden" readonly="readonly" name="supplier_id_form_create_po" id="supplier_id_form_create_po" value="<% out.println(supplier_id_form_create_po);%>"/>
                    <input type="hidden" readonly="readonly" name="id_add_item_po" id="id_add_item_po" value="<% out.println(id_add_item_po);%>"/>
                    <input type="hidden" name="id_product_purchase" id="id_product_purchase" value="<% out.println(id_product_purchase);%>"/>
                    <input type="hidden" name="action_edit_item_po" id="action_edit_item_po" value="<% out.println(action_edit_item_po);%>"/>
                    <input type="hidden" name="tax_item_po" id="tax_item_po" value="<% out.println(tax_item_po);%>" /><!--onblur="taxfunc()"-->
                    <input type="hidden" name="tax_po_val" id="tax_po_val" placeholder="TAX" value="<% out.println(tax_po);%>" />
                    <input type="hidden" name="val_tax_po" id="val_tax_po" class="form-control-static" placeholder="TAX" value="<% out.println(val_tax_po);%>" /></td>
                    <input type="hidden" name="action_delete_item_po" id="action_delete_item_po"/>

                    <tr>
                        <td>Description Item&nbsp;:</td>
                        <td>Qty &nbsp;:</td>
                        <td>Unit &nbsp;:</td>
                        <td >Unit Price &nbsp;:</td>
                        <td>Discount &nbsp;:</td>
                        <td>Total Price&nbsp;:</td>
                        <td> &nbsp;</td>
                    </tr>
                    <tr>
                        <td class="display"><input type="text" required="" name="item_name_po" id="item_name_po" class="form-control-static uppercase" placeholder="Like Sugar"  onchange="item_supEmpty()"/></td>
                        <td class="display"><input type="number" required="" min="1" value="0" name="qtty_po" id="qtty_po" class="form-control-static uppercase" placeholder="Qty" onchange="discount(0)"/></td>
                        <td class="display"><input type="text" required="" name="unit_item_po" id="unit_item_po" class="form-control-static uppercase" placeholder="Unit"/></td>
                        <td class="display"><input type="text" readonly required="" name="unit_price_po" id="unit_price_po" class="form-control-static uppercase" placeholder="IDR" onblur="format_rupiah(0)" onchange="discount(0)"/></td>
                        <td class="display"><input type="number" min="0" value="0" name="discount_item_po" id="discount_item_po" class="form-control-static uppercase" placeholder="Discount" onchange="discount(0)"/></td>
                        <td class="display"><input type="text" readonly name="price_po" id="price_po" class="form-control-static uppercase" placeholder="in IDR" ></td><!--onfocus="discount()"/-->
                        <td class="display"><input type="hidden" readonly required="" name="id_product" id="id_product" class="form-control-static uppercase"/></td>

                        <td class="display"><button class="btn-primary"  onclick="add_row();"><i class="fa fa fa-plus-square"></i></button>&nbsp;</td>
                        <!--<button class="btn-warning" onclick="remove(id)return false;" id="remove_row"><i class="fa fa-minus-square"></i></button>-->

                    </tr>
                    <tbody id="itemlist">
                    </tbody>
                    <tr >
                        <td class="control-label"  align="left"> <input type="text" readonly required="" name="sub_total" id="sub_total" class="form-control-static"  placeholder="SubTotal"/></td>
                    </tr>
                    <tr >
                        <td class="control-label"  align="left"><input type="text" readonly required="" name="total_price_po" id="total_price_po" class="form-control-static" placeholder="IDR"/>
                    </tr>
                </table>
                <button type="submit" id="btn_form_create_po" class="btn btn-primary">Submit</button>
                <!--<input type="submit" value="Submit" class="btn btn-primary"/>-->
                <button type="reset"  id="btn_reset_form_create_delegate" onclick="myFunction_reset_form_create_po()" class="btn btn-primary">Reset</button>
            </form>
        </div>
    </div>
</body>
