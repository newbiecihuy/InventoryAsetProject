/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var editor; // use a global for the submit and return data rendering in the examples
$(document).ready(function () {
    var table_grid_categories = $("#grid_categories").DataTable({
        processing: true,
        serverSide: true,
        colReorder: true,
        bJQueryUI: false,
        bStateSave: true,
        autoFill: true,
        paging: true,
        dom: 'Bfrtip',
        select: true,
        scrollY: "240px",
        scrollCollapse: true,
        lengthMenu: [[100, 200, 300, 400, 500, -1], [100, 200, 300, 400, 500, "All"]],
        pageLength:100,
        language: {
         processing: '<i class="fa fa-spinner fa-spin fa-3x fa-fw"  style="color:#3399ff"></i>'
        },
        buttons: [
            'pageLength',
            {
                text: 'Reload',
                class: 'btn btn-primary',
                action: function (e, dt, node, config) {
                    dt.ajax.reload();
                }
            }

        ],
//        processing: true,
//        serverSide: true,
        ajax: {
            url: createDynamicURL() + "/categoryServlet",
            dataType: "json", //jsonp
            dataSrc: 'rows'
        },
        columns: [{
                data: "no",
                targets: "no",
                bSortable: true
            }, {
                data: "category_id",
                targets: "category_id",
                bAutoWidth: true,
                visible: false,
                searchable: false
            }, {
                data: "name_categories",
                targets: "name_categories",
                bAutoWidth: true,
                visible: true,
                searchable: true
            }, {
                data: "create_date",
                targets: "create_date",
                bAutoWidth: true,
                visible: true,
                searchable: true
            }, {
                data: "pic",
                targets: "pic",
                bAutoWidth: true,
                visible: true,
                searchable: true
            }, {
                data: "is_delete",
                targets: "is_delete",
                bAutoWidth: true,
                visible: true,
                searchable: true,
                mRender: function (data_sup, type_sup, row_sup) {
                    if (data_sup === '0') {
                        return "<a class='btn btn-danger'>NActive";
                    }
                    if (data_sup === '1') {
                        return "<a class='btn btn-success'>Active";
                    }

                }
            }, {
                data: "action_category",
                targets: "action_category",
                mRender: function (data_app, type_app, row_app) {
                    if (row_app["category_id"] !== null) {
                        var va_category_id = row_app["category_id"];
                        var va_name_categories = row_app["name_categories"];
                        var va_category_desc = row_app["category_desc"];

                        var data_categories = {
                            category_id: va_category_id,
                            name_categories: va_name_categories,
                            category_desc: va_category_desc
                        };
                        return"<a href='#'><i class='fa fa-check-square-o' title='inactive'></i></a>\n\
                               <a id='updateDataCategories' href='#' onclick='javascript:editCategoriesFunc(" + JSON.stringify(data_categories) + ")'><i class='fa fa-edit'title='Edit'></i></a>\n\
                               <a href='#' onclick='javascript:deleteCategoriesFunc(" + JSON.stringify(data_categories) + ")'><i class='fa fa-trash ' title='Delete'></i></a>";
//                      return "<a href='" + data_pict_1 + " 'target='_blank' class='btn btn-info'>" + "<font color='#f2f2f2' size='2em'>" + "Display" + "</font>" + "</a>";
                    }
                }
            }],
        order: [[1, 'asc']]
    });
    table_grid_categories.on('order.dt search.dt', function () {
        table_grid_categories.column(0, {search: 'applied', order: 'applied'}).nodes().each(function (cell, i) {
            cell.innerHTML = i + 1;
        });
    }).draw();
    $('#grid_categories tbody').on('click', 'tr', function (item) {
        var data = table_grid_categories.row(this).data();
//        $('#edit_users_details').click(function () {
//
//            console.log("Insert myFunction_edit");
//            var ids = $.map(table_grid_supplier.rows('.selected').data(), function (item) {
//                return item[0];
//            });
//            console.log(ids);
//            if (table_grid_users.rows('.selected').data().length === 0) {
//                alert(' row(s) selected');
//                return;
//            }
//
//        });

    });
//    $('#updateDataSupp').on('click', function () {
//
//        window.location = "index.jsp?url=supllier_layout&pages=add_supllier_form";
//    });
//function myFunc(supplier_id) {//, supplier_name, supplier_code, address, contact_name, contact_num, status_supp
//
////    alert(supplier_id);
//        var myParam = "msupplierid=" + supplier_id;
//        window.location = "index.jsp?url=supllier_layout&pages=add_supllier_form&" + encodeURIComponent(myParam);
////    $("#supplier_id").value(supplier_id);
//    }
});



//function myapproveSupFunc() {
//    console.log("Insert myapproveSupFunc");
//    $("#form_upload_excel_user").dialog().dialog("open");
//    $(".hidden_upload_excel_user").removeClass("hidden_upload_excel_user");
//    //     $("#pic_delegate").autocomplete("autocompleteTechnicianServlet");
//    $('#form_upload_excel_user').dialog("widget").position({
//        my: 'left top',
//        at: 'left bottom'
//    });
//    $("#form_upload_excel_user").dialog({
//        autoOpen: false,
//        title: "Upload Data Users",
//        show: "blind",
//        hide: "explode",
//        modal: true,
//        width: 350,
//        zIndex: 1,
//        buttons: [{
//                text: 'Upload',
//                class: 'btn btn-primary',
//                click: function () {
//                    console.log("@ here");
//                    var data_upload_excel_user = new FormData($('#form_upload_excel_user')[0]);
//                    console.log("data_upload_delegate" + data_upload_excel_user);
//                    $.ajax({
//                        type: "POST",
//                        url: "/FieldServiceSolution/uploadDataUsersServlet", //uploadDataUsersServlet
//                        data: data_upload_excel_user,
//                        cache: false,
//                        processData: false, // Do'nt process the files
//                        contentType: false, // Set content type to false as jQuery will tell the server its a query string request                       
//                        success: function (response) {
//                            if (response.RC === "1") {
//                                alert("Success");
//                            } else if (response.RC === "x0s") {
//
//                                alert("No File Found");
//                            } else {
//                                alert("Fail Upload");
//                            }
//                        }, error: function (jqXHR, textStatus, errorThrown) {
//                            alert("Something really bad happened " + textStatus);
//                        }
//                    });
//                }
//            }, {
//                text: 'Clear',
//                class: 'btn btn-primary',
//                click: function () {
//
//                    document.getElementById("form_upload_excel_user").reset();
//                    $('#excel_upload_users').css('background', '');
////                    $('#pic_delegate').css('background', '');
//
////                    return;
//                }
//            }]
//    });
//}


