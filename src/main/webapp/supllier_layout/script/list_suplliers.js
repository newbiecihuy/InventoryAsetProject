/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var editor; // use a global for the submit and return data rendering in the examples
$(document).ready(function () {
    var table_grid_supplier = $("#grid_supplier").DataTable({
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
            url: createDynamicURL() + "/supplierServlet",
            dataType: "json", //jsonp
            dataSrc: 'rows'
        },
        columns: [{
                data: "no",
                targets: "no",
                bSortable: true
            }, {
                data: "supplier_id",
                targets: "supplier_id",
                bAutoWidth: true,
                visible: false,
                searchable: false
            }, {
                data: "supplier_name",
                targets: "supplier_name",
                bAutoWidth: true,
                visible: true,
                searchable: true,
                mRender: function (data_supName, type_supName, row_supName) {
                    var va_supplier_id = row_supName["supplier_id"];
                    var va_supplier_name = row_supName["supplier_name"];
                    var data_record_supplier = {
                        supplier_id: va_supplier_id,
                        supplier_name: va_supplier_name
                    };
                    if (row_supName['status_supp'] === 1) {
//                        return "NActive";
                        return"<a href='#' onclick='javascript:suplierExcelReport(" + JSON.stringify(data_record_supplier) + ")' >" + data_supName.replace('&nbsp;', /%20/g) + "</a>";
//                        return"<a href='#' onclick='javascript:suplierExcelReport(" + va_supplier_id + ")' >" + data_supName.replace('&nbsp;', /%20/g) + "</a>";
                    } else {
                        return data_supName.replace('&nbsp;', /%20/g);
                    }
//                    return data_supName.replace('&nbsp;', /%20/g);

                }
            }, {
                data: "supplier_code",
                targets: "supplier_code",
                bAutoWidth: true,
                visible: true,
                searchable: true,
                mRender: function (data_supCode, type_supCode, row_supCode) {
                    return data_supCode.replace('&nbsp;', /%20/g);

                }
            }, {
                data: "address",
                targets: "address",
                bAutoWidth: true,
                visible: true,
                searchable: true
            }, {
                data: "contact_name",
                targets: "contact_name",
                bAutoWidth: true,
                visible: true,
                searchable: true
            }, {
                data: "contact_num",
                targets: "contact_num",
                bAutoWidth: true,
                visible: true,
                searchable: true
            }, {
                data: "tax",
                targets: "tax",
                bAutoWidth: true,
                visible: false
//                mRender: function (data_tax, type_tax, row_tax) {
//                    if (data_tax === '1') {
//                        return "active";
//                    }
//                    if (data_tax === '0') {
//                        return "Nactive";
//                    }
//
//                }
            }, {
                data: "status_supp",
                targets: "status_supp",
                bAutoWidth: true,
                visible: true,
                searchable: true,
                mRender: function (data_sup, type_sup, row_sup) {
                    var va_supplier_id = row_sup["supplier_id"];
                    var data_record_supplier = {
                        supplier_id: va_supplier_id
                    };
                    if (data_sup === 0) {
                        return "NotApproved";
                    }
                    if (data_sup === 1) {
                        return "Approved";
//                        return"<a href='#' onclick='javascript:suplierExcelReport(" + JSON.stringify(data_record_supplier) + ")' >" + "Active" + "</a>";
                    }
                    if (data_sup === 2) {
                        $(data_sup).css('color', 'red');
                        return "Rejected";
                    }
                }
            }, {
                data: "created_date",
                targets: "created_date",
                bAutoWidth: true,
                visible: true,
                searchable: true
            }, {
                data: "action_supp",
                targets: "action_supp",
                mRender: function (data_app, type_app, row_app) {
                    if (row_app["supplier_id"] !== null) {
                        var va_supplier_id = row_app["supplier_id"];
                        var va_supplier_name = row_app["supplier_name"];
                        var va_supplier_code = row_app["supplier_code"];
                        var va_address = row_app["address"];
                        var va_contact_name = row_app["contact_name"];
                        var va_contact_num = row_app["contact_num"]; //,supplier_name,supplier_code,address,contact_name,contact_num,status_supp
                        var va_tax = row_app["tax"];
                        var va_status_supp = row_app["status_supp"]; // <a href='#'id='updateDataUser' onclick='javascript:myFunc(" + supplier_id + ")'><i class='fa fa-edit'title='Edit'></i></a>\n\

                        var data_supplier = {
                            supplier_id: va_supplier_id,
                            supplier_name: va_supplier_name,
                            supplier_code: va_supplier_code,
                            address: va_address,
                            contact_name: va_contact_name,
                            contact_num: va_contact_num,
                            tax: va_tax,
                            status_supp: va_status_supp
                        };
                        return"<a href='#'><i class='fa fa-check-square-o' title='inactive'></i></a>\n\
                               <a id='updateDataSupp' href='#' onclick='javascript:editSupplierFunc(" + JSON.stringify(data_supplier) + ")'><i class='fa fa-edit'title='Edit'></i></a>\n\
                               <a href='#' onclick='javascript:deleteSupplierFunc(" + JSON.stringify(data_supplier) + ")'><i class='fa fa-trash ' title='Delete'></i></a>";
//                      return "<a href='" + data_pict_1 + " 'target='_blank' class='btn btn-info'>" + "<font color='#f2f2f2' size='2em'>" + "Display" + "</font>" + "</a>";
                    }
                }
            }],
        order: [[1, 'asc']]
    });
    table_grid_supplier.on('order.dt search.dt', function () {
        table_grid_supplier.column(0, {search: 'applied', order: 'applied'}).nodes().each(function (cell, i) {
            cell.innerHTML = i + 1;
        });
    }).draw();
    $('#grid_supplier tbody').on('click', 'tr', function (item) {
        var data = table_grid_supplier.row(this).data();
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
//function editSupplierFunc(data_supplier) {//, supplier_name, supplier_code, address, contact_name, contact_num, status_supp
//
//    alert(data_supplier.supplier_code);
////    var myParam = "msupplierid=" + supplier_id;
////    window.location = "index.jsp?url=supllier_layout&pages=add_supllier_form&" + encodeURIComponent(myParam);
////    $("#supplier_id").value(supplier_id);
//}


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

