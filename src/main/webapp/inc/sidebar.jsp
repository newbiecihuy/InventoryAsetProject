<%-- 
    Document   : sidebar
    Created on : Jul 15, 2018, 3:15:55 PM
    Author     : newbiecihuy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<input type="hidden" id="username" name="username" readonly="true" value="<%= username%>" size="8px"/>
<input type="hidden" id="rolename" name="rolename"  readonly="true" value="<%= rolename%>" size="8px"/>
<!--<script>
    $(function () {
        $('.has-spinner').click(function () {
            $(this).toggleClass('active');
        });
    });
</script>-->

<div class="navbar-default  bg-cl sidebar" style="min-height: 1000px;" role="navigation">
    <div class="sidebar-nav navbar-collapse">
        <ul class="nav" id="side-menu">
            <li class="sidebar-search">
                <!--                <div class="profile_pic">
                                    <img src="https://image.shutterstock.com/image-vector/user-account-circle-profile-line-260nw-272552858.jpg" alt="img" class="img-circle profile_img mCS_img_loaded">
                                </div>-->
                <div class="profile_info" style="width:88%;margin: 9px auto auto 12px;border-radius: 5px;padding-top: 8px;border: 1px solid #505050;">
                    <table style="color: white;font-size:1em;">
                        <tbody>
                            <tr>
                                <td style="width:30px;text-align: center;">
                                    <small>
                                        <i style="color: #24c7bc!important;font-size: 15px;" class="fa fa-map" aria-hidden="true"></i>
                                    </small>
                                </td>
                                <td style="padding-left: 10px; font-size:12px;">
                                </td>
                            </tr>
                            <tr>
                                <td style="width:30px;text-align: center;">
                                    <small>
                                        <i style="color: #24c7bc!important;font-size: 12px;" class="fa fa-globe" aria-hidden="true"></i>
                                    </small>
                                </td>
                                <td style="padding-left: 10px; font-size:10px;">
                                </td>
                            </tr>
                            <tr>
                                <td style="width:30px;text-align: center;">
                                    <small>
                                        <i style="color: #24c7bc!important;font-size: 12px;" class="fa fa-id-card" aria-hidden="true"></i>
                                    </small>
                                </td>
                                <td style="padding-left: 10px; font-size:10px;">
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </li>

            <li>
                <!--<div class="input-group custom-search-form hidden">-->
                <!--                    <input type="text" class="form-control" placeholder="Search...">
                                    <span class="input-group-btn">
                                        <button class="btn btn-default" type="button">
                                            <i class="fa fa-search"></i>
                                        </button>
                                    </span>-->
                <!--<a href="#" class="font-cl"><i class="header"></i>MAIN NAVIGATION</a>-->
                <!--                &nbsp;--> 
                <div  class="hero-unit-clock">
                    <div id="clock" align="center"  style="width:150px; height:25px; color:#FFFBCC;"></div>

                </div>
            </li>   
            <li>
                <!-- <a href="#" class="dropdown-toggle"><i class="fa fa-bar-chart-o fa-fw"></i> Charts<span class="fa arrow"></span></a>-->
                <a href="#" class="dropdown-toggle font-cl"><i class="fa fa-dashboard fa-fw"></i>Dashboard<span class="fa arrow"></span></a>
                <ul class="nav nav-second-level submenu">
                    <li class="has-spinner" >
                        <a href="index.jsp?url=dashboard_layout&pages=pie_chart" class="font-cl has-spinner"><span class="spinner"><i class="fa fa fa-circle-o-notch fa-spin" style="font-size:14px;color:red"></i></span> Pie Chart</a>
                    </li>
                    <li class="has-spinner" >
                        <a href="index.jsp?url=dashboard_layout&pages=bar_chart"  class="font-cl has-spinner"><span class="spinner"><i class="fa fa fa-circle-o-notch fa-spin" style="font-size:14px;color:red"></i></span> Bar Chart</a>
                    </li>
                </ul>
            </li>

            <li>
                <a href="#" class="dropdown-toggle font-cl"><i class="fa fa-list fa-fw"></i> Supplier Manager<span class="fa arrow"></span></a>
                <ul class="nav nav-second-level submenu">
                    <li class="has-spinner" >
                        <a href="index.jsp?url=supllier_layout&pages=add_supllier_form" class="font-cl has-spinner"><span class="spinner"><i class="fa fa fa-circle-o-notch fa-spin" style="font-size:14px;color:red"></i></span> Add Supplier</a>
                    </li>
                    <li class="has-spinner" >
                        <a href="index.jsp?url=supllier_layout&pages=list_suplliers" class="font-cl has-spinner"><span class="spinner"><i class="fa fa fa-circle-o-notch fa-spin" style="font-size:14px;color:red"></i></span> View Supplier</a>
                    </li>
                </ul>
                <!-- /.nav-second-level -->
            </li>
            <li>
                <a href="#" class="dropdown-toggle font-cl"><i class="fa fa-list fa-fw"></i> Item Manager<span class="fa arrow"></span></a>
                <ul class="nav nav-second-level submenu">

                    <li class="has-spinner" >
                        <a href="index.jsp?url=item_layout&pages=form_add_item" class="font-cl has-spinner"><span class="spinner"><i class="fa fa fa-circle-o-notch fa-spin" style="font-size:14px;color:red"></i></span> Add Item</a>
                    </li>
                    <!--                    <li>
                                            <a href="index.jsp?url=item_layout&pages=add_stock_item" class="font-cl"><i class="fa fa fa-circle-o-notch fa-spin" style="font-size:14px;color:red"></i> Add Stock</a>
                                        </li>-->
                    <li class="has-spinner" >
                        <a href="index.jsp?url=item_layout&pages=list_items" class="font-cl has-spinner"><span class="spinner"><i class="fa fa fa-circle-o-notch fa-spin" style="font-size:14px;color:red"></i></span> View Item</a>
                    </li>
                    <!--                    <li class="has-spinner" >
                                            <a href="index.jsp?url=item_layout&pages=add_category_form" class="font-cl"><i class="fa fa fa-circle-o-notch fa-spin" style="font-size:14px;color:red"></i> Add Categories</a>
                                        </li>-->
                    <li class="has-spinner" >
                        <a href="index.jsp?url=item_layout&pages=list_categories" class="font-cl has-spinner"><span class="spinner"><i class="fa fa fa-circle-o-notch fa-spin" style="font-size:14px;color:red"></i></span> View Categories</a>
                    </li>
<!--                    <li class="has-spinner" >
                        <a href="index.jsp?url=item_layout&pages=list_stock_item" class="font-cl"><i class="fa fa fa-circle-o-notch fa-spin" style="font-size:14px;color:red"></i> View Stock</a>
                    </li>-->
                </ul>
                <!-- /.nav-second-level -->
            </li>
            <li>
                <a href="#" class="dropdown-toggle font-cl"><i class="fa fa-list fa-fw"></i> Flow Data Aset<span class="fa arrow"></span></a>
                <ul class="nav nav-second-level submenu">
                    <li class="has-spinner" >
                        <a href="index.jsp?url=flow_aset_layout&pages=form_permintaan" class="font-cl has-spinner"><span class="spinner"><i class="fa fa fa-circle-o-notch fa-spin" style="font-size:14px;color:red"></i></span> Form Request</a>
                    </li>
                </ul>
            </li>
            <!--            <li>
                            <a href="#" class="dropdown-toggle font-cl"><i class="fa fa-list fa-fw"></i> Stock Manager<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level submenu">
                                <li class="has-spinner" >
                                    <a href="index.jsp?url=item_layout&pages=add_stock_item" class="font-cl"><i class="fa fa fa-circle-o-notch fa-spin" style="font-size:14px;color:red"></i> Add Stock</a>
                                </li>
                                <li class="has-spinner" >
                                    <a href="index.jsp?url=item_layout&pages=list_stock_item" class="font-cl"><i class="fa fa fa-circle-o-notch fa-spin" style="font-size:14px;color:red"></i> View Stock</a>
                                </li>
                            </ul>
                             /.nav-second-level 
                        </li>-->
            <li>
                <a href="#" class="dropdown-toggle font-cl"><i class="fa fa-list fa-fw"></i> Puchase Order Menu<span class="fa arrow"></span></a>
                <ul class="nav nav-second-level submenu">
                    <!--                    <li class="has-spinner" >
                                            <a href="index.jsp?url=purcahase_layout&pages=form_po" class="font-cl"><i class="fa fa fa-circle-o-notch fa-spin" style="font-size:14px;color:red"></i> Create PO</a>
                                        </li>-->
                    <li class="has-spinner" >
                        <a href="index.jsp?url=purcahase_layout&pages=add_po" class="font-cl has-spinner"><span class="spinner"><i class="fa fa fa-circle-o-notch fa-spin" style="font-size:14px;color:red"></i></span> Create PO</a>
                    </li> 
                    <li class="has-spinner" >
                        <a href="index.jsp?url=purcahase_layout&pages=grid_form_po" class="font-cl has-spinner"><span class="spinner"><i class="fa fa fa-circle-o-notch fa-spin" style="font-size:14px;color:red"></i></span>View list P&#8228;O&#8228;</a>
                    </li>
                    <!--                    <li>
                                            <a href="index.jsp?url=purcahase_layout&pages=list_po" class="font-cl"><i class="fa fa fa-circle-o-notch fa-spin" style="font-size:14px;color:red"></i> List PO</a>
                                        </li>-->
                </ul>
                <!-- /.nav-second-level -->
            </li>
<!--            <li> on Progress
                <a href="#" class="dropdown-toggle font-cl"><i class="fa fa-list fa-fw"></i> Sales Order Menu<span class="fa arrow"></span></a>
                <ul class="nav nav-second-level submenu">
                    <li class="has-spinner" >
                        <a href="index.jsp?url=sales_layout&pages=sales" class="font-cl"><i class="fa fa fa-circle-o-notch fa-spin" style="font-size:14px;color:red"></i> Create SO</a>
                    </li>
                                        <li>
                                            <a href="index.jsp?url=sales_layout&pages=list_po" class="font-cl"><i class="fa fa fa-circle-o-notch fa-spin" style="font-size:14px;color:red"></i> List SO</a>
                                        </li>
                </ul>
                 /.nav-second-level 
            </li>
            <li>
                <a href="#" class="dropdown-toggle font-cl"><i class="fa fa-list fa-fw"></i> Sales Report<span class="fa arrow"></span></a>
                <ul class="nav nav-second-level submenu">
                    <li class="has-spinner" >
                        <a href="index.jsp?url=sales_layout&pages=sales" class="font-cl">View Sales</a>
                    </li>
                </ul>
                 /.nav-second-level 
            </li>-->
            <li>
                <a href="#" class="dropdown-toggle font-cl"><i class="fa fa-users fa-fw"></i>User Manager<span class="fa arrow"></span></a>
                <ul class="nav nav-second-level submenu">
                    <li class="has-spinner" >
                        <a href="index.jsp?url=user_layout&pages=add_user_form" class="font-cl has-spinner"><span class="spinner"><i class="fa fa fa-circle-o-notch fa-spin" style="font-size:14px;color:red"></i></span> Add User</a>
                    </li>
                    <li class="has-spinner" >
                        <a href="index.jsp?url=user_layout&pages=list_users" class="font-cl has-spinner"><span class="spinner"><i class="fa fa fa-circle-o-notch fa-spin" style="font-size:14px;color:red"></i></span> View Users</a>
                    </li>
                </ul>
                <!-- /.nav-second-level -->
            </li>
            <li>
                <a href="#" class="dropdown-toggle font-cl"><i class="fa fa-tasks fa-fw" aria-hidden="true" ></i>Config<span class="fa arrow"></span></a>
                <ul class="nav nav-second-level submenu">
                    <li class="has-spinner" >
                        <a href="index.jsp?url=config_layout&pages=list_email" class="font-cl has-spinner"><span class="spinner"><i class="fa fa fa-circle-o-notch fa-spin" style="font-size:14px;color:red"></i></span> Email Config</a>
                    </li>
                    <li>
                        <!--<a href="index.jsp?url=form_layout&pages=buttons" class="font-cl"><i class="fa fa fa-circle-o-notch fa-spin" style="font-size:14px;color:red"></i> View Stock</a>-->
                    </li>
                </ul>
                <!-- /.nav-second-level -->
            </li>
            <!--            <li>
                            <a href="#" class="dropdown-toggle"><i class="fa fa-sitemap fa-fw"></i> Multi-Level Dropdown<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level submenu">
                                <li>
                                    <a href="#">Second Level Item</a>
                                </li>
                                <li>
                                    <a href="#">Second Level Item</a>
                                </li>
                                <li>
                                    <a href="#" class="dropdown-toggle">Third Level <span class="fa arrow"></span></a>
                                    <ul class="nav nav-third-level submenu">
                                        <li>
                                            <a href="#">Third Level Item</a>
                                        </li>
                                        <li>
                                            <a href="#">Third Level Item</a>
                                        </li>
                                        <li>
                                            <a href="#">Third Level Item</a>
                                        </li>
                                        <li>
                                            <a href="#">Third Level Item</a>
                                        </li>
                                    </ul>
                                     /.nav-third-level 
                                </li>
                            </ul>
                             /.nav-second-level 
                        </li>-->
            <!--            <li>
                            <a href="#" class="dropdown-toggle font-cl"><i class="fa fa-files-o fa-fw"></i> Sample Pages<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level submenu">
                                <li>
                                    <a href="index.jsp?url=form_layout&pages=blank" class="font-cl">Blank Page</a>
                                </li>
                                <li>
                                    <a href="index.jsp?url=form_layout&pages=login" class="font-cl">Login Page</a>
                                </li>
                            </ul>
                             /.nav-second-level 
                        </li>-->

            <li>
                <a href="<%= response.encodeURL("logoutServlet")%>" class="dropdown-toggle font-cl"><i class="fa fa-sign-out fa-fw" aria-hidden="true" ></i>Sign out</a>
            </li>
            <!--            <li>
                            <div  class="hero-unit-clock">
                                <div id="clock" align="center"  style="width:150px; height:25px; color:#FFFBCC;"></div>
            
                            </div>
                        </li>   -->
        </ul>
    </div>
    <!-- /.sidebar-collapse -->
</div>
<!-- /.navbar-static-side -->