<%-- 
    Document   : add_category_form
    Created on : Sep 13, 2018, 10:01:18 AM
    Author     : newbiecihuy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<body>
    <%
        String category_name = " ";
        if (request.getParameter("category_name") != null) {
            category_name = request.getParameter("category_name");
        }
        String category_desc = " ";
        if (request.getParameter("category_desc") != null) {
            category_desc = request.getParameter("category_desc");
        }
    %>
    <section class="content-header">
        <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
            <li class="active">category</li>
            <li class="active">add</li>
        </ol>
    </section>
    <div class="panel panel-default">
        <div class="panel-body">
            <form>
                <table cellpadding="0" cellspacing="0"  style="border: 0px">
                    <td class="controls">
                        <a href="index.jsp?url=item_layout&pages=list_categories" class="btn btn-success" role="button" aria-pressed="true"><font color='#b6c5cd' size='2em'>view Categories</font></a>
                    </td>
                </table>
            </form>
            <form id="form_add_categories" name="form_add_categories" method="POST" action="">
                <!--<div id="form_add_categories_response" class="resp"></div>-->
                <div id="form_add_categories_response"></div>
                <div class="box-body">
                    <div class="form-group">
                        <label for="categories" class="req">Category Name &nbsp;:</label>
                        <input type="text" name="category_name" id="category_name" class="form-control  uppercase" value="<% out.println(category_name);%>"/>
                        <input type="hidden" name="category_id" id="category_id" value="<% out.println(request.getParameter("category_id"));%>"/>
                        <input type="hidden" name="action_insert_category" id="action_insert_category"/>
                        <input type="hidden" name="action_edit_category" id="action_edit_category" value="<% out.println(request.getParameter("action_edit_category"));%>"/>
                        <input type="hidden" name="action_delete_category" id="action_delete_category"/>
                        <span class="required-server"> </span>
                    </div> 
                    <div class="form-group">
                        <label for="desc_category" class="req">Desciption &nbsp;:</label>
                        <textarea  name="category_desc" id="category_desc"  placeholder="Desciption"  class="form-control ui-widget-content sw uppercase"><% out.println(category_desc);%></textarea>
                        <span class="required-server"> </span>
                    </div>
                </div>
                <div class="box-footer" align="center">
                    <button type="submit" class="btn btn-primary" id="btn_daftar">Submit</button>
                    <button type="reset"  class="btn btn-danger" value="Reset" id="btn_reset" onclick="myFunction_reset_formCategory()">RESET</button>
                </div>
            </form>
        </div>
    </div>
</body>
