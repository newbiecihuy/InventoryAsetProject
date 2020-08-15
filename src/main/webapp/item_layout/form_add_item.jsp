<%-- 
    Document   : form_add_item
    Created on : Sep 11, 2018, 11:41:30 AM
    Author     : newbiecihuy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<body>
    <%
        String price = "0";
        if (request.getParameter("price_item") != null) {
            price = request.getParameter("price_item");
        }
        int supplier_id = 0;
        if (request.getParameter("supplier_id_item") != null) {
            supplier_id = Integer.parseInt(request.getParameter("supplier_id_item"));
        }
        int id_product = 0;
        if (request.getParameter("id_product") != null) {
            id_product = Integer.parseInt(request.getParameter("id_product"));
        }
        int category_id = 0;
        if (request.getParameter("category_id") != null) {
            category_id = Integer.parseInt(request.getParameter("category_id"));
        }
        int id_stock = 0;
        if (request.getParameter("id_stock") != null) {
            id_stock = Integer.parseInt(request.getParameter("id_stock"));
        }
        String supplier_name_item = "";
        if (request.getParameter("supplier_name_item") != null) {
            supplier_name_item = request.getParameter("supplier_name_item");
        }
        String item_name = "";
        if (request.getParameter("item_name") != null) {
            item_name = request.getParameter("item_name");
        }
        String product_code = "";
        if (request.getParameter("product_code") != null) {
            product_code = request.getParameter("product_code");
        }
        String categories_name = "";
        if (request.getParameter("categories_name") != null) {
            categories_name = request.getParameter("categories_name");
        }
        String estemated_date_before = "";
        if (request.getParameter("estemated_date_before") != null) {
            estemated_date_before = request.getParameter("estemated_date_before");
        }
        String estemated_date_after = "";
        if (request.getParameter("estemated_date_after") != null) {
            estemated_date_after = request.getParameter("estemated_date_after");
        }
        String descr = "";
        if (request.getParameter("descr") != null) {
            descr = request.getParameter("descr");
        }

    %>
    <section class="content-header">
        <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
            <li class="active">item</li>
            <li class="active">add</li>
        </ol>
    </section>
    <div class="panel panel-default ">
        <!--<div class="col-md-6 con">-->
            <div class="panel-body">
                <form>
                    <table cellpadding="0" cellspacing="0"  style="border: 0px">
                        <td class="controls">
                            <a href="index.jsp?url=item_layout&pages=list_items" class='btn btn-success'><font color='#b6c5cd' size='2em'>View Item</font></a>
                        </td>
                    </table>
                </form>
                <form id="form_add_item" name="form_add_item" method="POST" action="">
                    <!--<div id="ajaxResponse_form_add_item" class="resp"></div>-->
                    <div id="ajaxResponse_form_add_item"></div>
                    <div class="box-body">

                        <div class="form-group">
                            <label for="supplier_name">Supllier Name &nbsp;:</label>
                            <input type="text" name="supplier_name" id="supplier_name"  class="form-control ui-widget-content sw uppercase" value="<% out.println(supplier_name_item);%>"  onblur="supplier_item_empty()"/>
                            <input type="hidden" name="supplier_id" id="supplier_id"  class="form-control ui-widget-content sw uppercase" value="<% out.println(supplier_id);%>" />
                            <span class="required-server"> </span>
                        </div>
                        <div class="form-group">
                            <label for="title" class="required">Item Name &nbsp;:</label>
                            <input type="text"  class="form-control ui-widget-content sw uppercase" id="item_name" name="item_name" placeholder="Like Sugar" value="<% out.println(item_name);%>">
                            <input type="hidden" class="form-control" id="id_product" class="form-control ui-widget-content sw uppercase" name="id_product" value="<% out.println(id_product);%>" >
                            <input type="hidden" name="action_insert_item" id="action_insert_item" class="form-control ui-widget-content sw uppercase" />
                            <input type="hidden" name="action_edit_item" id="action_edit_item" class="form-control ui-widget-content sw uppercase" value="<% out.println(request.getParameter("action_edit_item"));%>" />
                            <input type="hidden" name="action_delete_item" id="action_delete_item" class="form-control ui-widget-content sw uppercase"/>
                            <span class="required-server"> </span>
                        </div>
                        <div class="form-group">
                            <label for="product_code">Product Code &nbsp;:</label>
                            <input type="text" name="product_code" id="product_code" class="form-control ui-widget-content sw uppercase" value="<% out.println(product_code);%>">
                            <span class="required-server"> </span>
                        </div>

                        <div class="form-group">
                            <label for="categories_name">Category &nbsp;:</label>
                            <input type="text" class="form-control ui-widget-content sw uppercase"id="categories_name" name="categories_name" value="<% out.println(categories_name);%>" onblur="categories_empty()">
                            <input type="hidden" class="form-control ui-widget-content sw uppercase" id="category_id" name="category_id"  value="<% out.println(category_id);%>">
                            <span class="required-server"> </span>
                        </div>
                        <div class="form-group">
                            <label for="price_item">Price &nbsp;:</label>
                            <!--<input required="" type="number" min="1" class="form-control uppercase" id="price_item" name="price_item"  onblur="price_item_cek()">-->
                            <input  type="text" required min="1"  class="form-control" id="price_item" name="price_item" oninput="cekNumber()" value="<% out.println(price);%>" >
                            <input  type="hidden" class="form-control ui-widget-content sw uppercase" id="id_stock" name="id_stock" value="<% out.println(id_stock);%>">

                            <p id="content_form_error_item" ></p>
                        </div>
                        <div class="form-group">
                            <label for="estemated_date_before">Before Date &nbsp;:</label>
                            <input type="text" class="form-control ui-widget-content sw datePick" id="estemated_date_before" name="estemated_date_before" value="<% out.println(estemated_date_before);%>" placeholder="dd/MM/yyyy">
                            <span class="required-server"> </span>
                        </div>
                        <div class="form-group">
                            <label for="estemated_date_after">After Date &nbsp;:</label>
                            <input type="text" class="form-control ui-widget-content sw datePick" id="estemated_date_after" name="estemated_date_after" value="<% out.println(estemated_date_after);%>"  placeholder="dd/MM/yyyy">
                            <span class="required-server"> </span>
                        </div>
                        <div class="form-group">
                            <label for="title" class="required">Item Description &nbsp;:</label>
                            <textarea class="form-control ui-widget-content sw uppercase" id="descr" name="descr" placeholder="Item Description"><% out.println(descr);%></textarea>
                            <span class="required-server"> </span>
                        </div>
                    </div>
                    <div class="box-footer">
                        <button type="submit" class="btn btn-primary" id="btn_add_item">Submit</button>
                        <button type="reset"  class="btn btn-danger" value="Reset" id="btn_reset" onclick="myFunction_reset_form_add_item()">RESET</button>
                    </div>
                </form> 
            </div>
        <!--</div>-->
    </div>
</body>



