/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var editor; // use a global for the submit and return data rendering in the examples
$(document).ready(function () {
    var tbl_grid_items = $("#grid_items").DataTable({
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
        pageLength: 100,
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
            url: createDynamicURL() + "/itemServlet",
            dataType: "json", //jsonp
            dataSrc: 'rows'
        },
        columns: [{
                data: "no",
                targets: "no",
                bSortable: true
            }, {
                data: "id_product",
                targets: "id_product",
                bAutoWidth: true,
                visible: false,
                searchable: false
            }, {
                data: "supplier_name",
                targets: "supplier_name",
                bAutoWidth: true,
                visible: true,
                searchable: false
            }, {
                data: "supplier_id",
                targets: "supplier_id",
                bAutoWidth: true,
                visible: false,
                searchable: false
            }, {
                data: "product_name",
                targets: "product_name",
                bAutoWidth: true,
                visible: true,
                searchable: true
            }, {
                data: "product_code",
                targets: "product_code",
                bAutoWidth: true,
                visible: true,
                searchable: true
            }, {
                data: "price_item",
                targets: "price_item",
                bAutoWidth: true,
                visible: true,
                searchable: true,
                mRender: function (data_priceItem, type_priceItem, row_priceItem) {
//                    return data_priceItem;
                    var number = data_priceItem;
                    var number_string = number.toString();
                    var sisa = number_string.length % 3;
                    var rupiah = number_string.substr(0, sisa);
                    var ribuan = number_string.substr(sisa).match(/\d{3}/g);
                    if (ribuan) {
                        var separator = sisa ? '.' : '';
                        rupiah += separator + ribuan.join('.');
                    }
                    return rupiah;
                }
            }, {
                data: "sell_price",
                targets: "sell_price",
                bAutoWidth: true,
                visible: false,
                searchable: true,
                mRender: function (data_price, type_price, row_price) {
//                    return data_priceItem;
                    var number = data_price;
                    var number_string = number.toString();
                    var sisa = number_string.length % 3;
                    var rupiah = number_string.substr(0, sisa);
                    var ribuan = number_string.substr(sisa).match(/\d{3}/g);
                    if (ribuan) {
                        var separator = sisa ? '.' : '';
                        rupiah += separator + ribuan.join('.');
                    }
                    return rupiah;
                }
            }, {
                data: 'id_stock',
                targets: "id_stock",
                bAutoWidth: true,
                visible: false,
                searchable: false
            }, {
                data: "estemated_date_before",
                targets: "estemated_date_before",
                bAutoWidth: true,
                visible: false,
                searchable: true
            }, {
                data: "estemated_date_after",
                targets: "estemated_date_after",
                bAutoWidth: true,
                visible: false,
                searchable: true
            }, {
                data: "category_id",
                targets: "category_id",
                bAutoWidth: true,
                visible: false,
                searchable: false
            }, {
                data: "name_category",
                targets: "name_category",
                bAutoWidth: true,
                visible: true,
                searchable: true
            }, {
                data: "description",
                targets: "description",
                bAutoWidth: true,
                visible: true,
                searchable: true
            }, {
                data: "status_item",
                targets: "status_item",
                bAutoWidth: true,
                visible: true,
                searchable: true,
                mRender: function (data_item, type_item, row_item) {
                   if (data_item === 0) {
                        return "<a href='#'><font color='c89907',font-weight: 900;>"+"Waiting"+"</font></a>";  //Not Approved
                    }
                    if (data_item === 1) {
                        return "<a href='#'><font color='0bbc43',font-weight: 900;>"+"Approved"+"</font></a>";
//                        return"<a href='#' onclick='javascript:suplierExcelReport(" + JSON.stringify(data_record_supplier) + ")' >" + "Active" + "</a>";
                    }
                    if (data_item === 2) {
                        return"<a href='#'><font color='d50808',font-weight: 900;>"+"Rejected"+"</font></a>";
                    }

                }
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
                data: "stock",
                targets: "stock",
                bAutoWidth: true,
                visible: false,
                searchable: true
            }, {
                data: "action_item",
                targets: "action_item",
                mRender: function (data, type, row) {
                    if (row["id_product"] !== null) {
                        var va_id_product = row["id_product"];
                        var va_supplier_name = row["supplier_name"];
                        var va_supplier_id = row["supplier_id"];
                        var va_product_code = row["product_code"];
                        var va_create_date = row["create_date"];
                        var va_product_name = row["product_name"];
                        var va_price_item = row["price_item"];
                        var va_estemated_date_before = row["estemated_date_before"];
                        var va_estemated_date_after = row["estemated_date_after"];
                        var va_category_id = row["category_id"];
                        var va_name_category = row["name_category"];
                        var va_description = row["description"];
                        var va_status_item = row["status_item"];
                        var va_id_stock = row["id_stock"];
                        var va_stock = row["stock"];
                        var data_Items = {
                            id_product: va_id_product,
                            supplier_name: va_supplier_name,
                            supplier_id: va_supplier_id,
                            product_code: va_product_code,
                            create_date: va_create_date,
                            product_name: va_product_name,
                            price_item: va_price_item,
                            estemated_date_before: va_estemated_date_before,
                            estemated_date_after: va_estemated_date_after,
                            category_id: va_category_id,
                            name_category: va_name_category,
                            description: va_description,
                            id_stock: va_id_stock,
                            status_item: va_status_item,
                            stock: va_stock
                        };
                        if (va_stock !== 0) {
                            return"<a href='#'><i class='fa fa-check-square-o' title='inactive'></i></a>\n\
                                 <a href='#' onclick='javascript:viewStockFunc(" + JSON.stringify(data_Items) + ")'><i class='fa fa fa-shopping-basket' title='view-stock'></i></a>\n\
                                 <a id='updateDataItem' href='#' onclick='javascript:editItemFunc(" + JSON.stringify(data_Items) + ")'><i class='fa fa-edit'title='Edit'></i></a>\n\
                                 <a href='#'><i class='fa fa-trash' title='Delete'></i></a>";
//                      return "<a href='" + data_pict_1 + " 'target='_blank' class='btn btn-info'>" + "<font color='#f2f2f2' size='2em'>" + "Display" + "</font>" + "</a>";
                        } else {
                            return"<a href='#'><i class='fa fa-check-square-o' title='inactive'></i></a>\n\
                               <a href='#'><i class='fa fa fa-shopping-basket' style='color:#e0e0d1;' title='empty'></i></a>\n\
                               <a id='updateDataItem' href='#' onclick='javascript:editItemFunc(" + JSON.stringify(data_Items) + ")'><i class='fa fa-edit'title='Edit'></i></a>\n\
                               <a href='#' onclick='javascript:deleteItemFunc(" + JSON.stringify(data_Items) + ")'><i class='fa fa-trash' title='Delete'></i></a>";
                        }
                    }
                }
            }],
        order: [[1, 'asc']]
    });
    tbl_grid_items.on('order.dt search.dt', function () {
        tbl_grid_items.column(0, {search: 'applied', order: 'applied'}).nodes().each(function (cell, i) {
            cell.innerHTML = i + 1;
        });
    }).draw();
    $('#grid_categories tbody').on('click', 'tr', function (item) {
        var data = tbl_grid_items.row(this).data();
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



function myFunctionUploadDataUser() {
    console.log("Insert myFunctionUploadDataUser");
    $("#form_upload_excel_user").dialog().dialog("open");
    $(".hidden_upload_excel_user").removeClass("hidden_upload_excel_user");
    //     $("#pic_delegate").autocomplete("autocompleteTechnicianServlet");
    $('#form_upload_excel_user').dialog("widget").position({
        my: 'left top',
        at: 'left bottom'
    });
    $("#form_upload_excel_user").dialog({
        autoOpen: false,
        title: "Upload Data Users",
        show: "blind",
        hide: "explode",
        modal: true,
        width: 350,
        zIndex: 1,
        buttons: [{
                text: 'Upload',
                class: 'btn btn-primary',
                click: function () {
                    console.log("@ here");
                    var data_upload_excel_user = new FormData($('#form_upload_excel_user')[0]);
                    console.log("data_upload_delegate" + data_upload_excel_user);
                    $.ajax({
                        type: "POST",
                        url: "/FieldServiceSolution/uploadDataUsersServlet", //uploadDataUsersServlet
                        data: data_upload_excel_user,
                        cache: false,
                        processData: false, // Do'nt process the files
                        contentType: false, // Set content type to false as jQuery will tell the server its a query string request                       
                        success: function (response) {
                            if (response.RC === "1") {
                                alert("Success");
                            } else if (response.RC === "x0s") {

                                alert("No File Found");
                            } else {
                                alert("Fail Upload");
                            }
                        }, error: function (jqXHR, textStatus, errorThrown) {
                            alert("Something really bad happened " + textStatus);
                        }
                    });
                }
            }, {
                text: 'Clear',
                class: 'btn btn-primary',
                click: function () {

                    document.getElementById("form_upload_excel_user").reset();
                    $('#excel_upload_users').css('background', '');
//                    $('#pic_delegate').css('background', '');

//                    return;
                }
            }]
    });
}



