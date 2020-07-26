/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var editor; // use a global for the submit and return data rendering in the examples
$(document).ready(function () {
    var tbl_grid_form_po = $("#grid_form_po").DataTable({
        serverSide: true,
        processing: true,
        autoFill: true,
        paging: true,
        dom: 'Bfrtip',
        select: true,
        scrollY: "240px",
        scrollCollapse: true,
        aoColumnDefs: [
            {bSortable: false, aTargets: ["_all"]}
        ],
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
            url: createDynamicURL() + "/createPOServlet",
            dataType: "json", //jsonp
            dataSrc: 'rows'
        },
        columns: [{
                data: "no",
                targets: "no"
            }, {
                data: "purchase_id",
                targets: "purchase_id",
                bAutoWidth: true,
                visible: false,
                searchable: false
            }, {
                data: "purchase_code",
                targets: "purchase_code",
                bAutoWidth: true,
                searchable: true,
                mRender: function (data_pcCode, type_pcCode, row_pcCode) {
                    var va_purchase_id = row_pcCode["purchase_id"];
                    var va_purchase_code = row_pcCode["purchase_code"];
                    var va_supplier_id = row_pcCode["supplier_id"];
                    var data_record_po = {
                        purchase_id: va_purchase_id,
                        supplier_id: va_supplier_id
                    };
                    if (row_pcCode["is_delete"] === "0") { //0 = Active, 1=NActive
                        if (row_pcCode["status_po"] !== "No Item") { //No Item
                            return"<a href='#' onclick='javascript:purchasePdfReport(" + JSON.stringify(data_record_po) + ")' >" + data_pcCode + "</a>";
                        } else {
                            return data_pcCode;
                        }
//
                    } else {
                        return data_pcCode;
                    }
                }
            }, {
                data: "supplier_id",
                targets: "supplier_id",
                bAutoWidth: true,
                visible: false,
                searchable: true
            }, {
                data: "supplier_name",
                targets: "supplier_name",
                bAutoWidth: true,
                searchable: true
            }, {
                data: "supplier_code",
                targets: "supplier_code",
                bAutoWidth: true,
                visible: false,
                searchable: true
            }, {
                data: "supplier_tax",
                targets: "supplier_tax",
                bAutoWidth: true,
                visible: false,
                searchable: true
            }, {
                data: "tgl_input_po",
                targets: "tgl_input_po",
                bAutoWidth: true,
                searchable: true
            }, {
                data: "po_type",
                targets: "po_type",
                bAutoWidth: true,
                searchable: true
            }, {
                data: "payment_term",
                targets: "payment_term",
                visible: false,
                bAutoWidth: true,
                searchable: true
            }, {
                data: "delivery_term",
                targets: "delivery_term",
                bAutoWidth: true,
                searchable: true
            }, {
                data: "transport_mode",
                targets: "transport_mode",
                bAutoWidth: true,
                searchable: true
            }, {
                data: "quotation_number",
                targets: "quotation_number",
                bAutoWidth: true,
                searchable: true
            }, {
                data: "rfq_number",
                targets: "rfq_number",
                bAutoWidth: true,
                visible: false,
                searchable: true
            }, {
                data: "dlvr_point",
                targets: "dlvr_point",
                bAutoWidth: true,
                searchable: true
            }, {
                data: "invoice_to",
                targets: "invoice_to",
                bAutoWidth: true,
                searchable: true
            }, {
                data: "purchase_desc",
                targets: "purchase_desc",
                bAutoWidth: true,
                visible: false
            }, {
                data: "status_po",
                targets: "status_po",
                bAutoWidth: true,
                visible: true
            }, {
                data: "pic",
                targets: "pic",
                bAutoWidth: true,
                visible: true,
                searchable: true
            }, {
                data: "is_approve",
                targets: "is_approve",
                bAutoWidth: true,
                visible: false,
                searchable: false,
                mRender: function (data_sup, type_sup, row_sup) {
                    if (data_sup === 1) {
                        return "Approve";
                    }
                    if (data_sup === 0) {
                        return "NotApprove";
                    }
                    if (data_sup === 2) {
                        return "Reject";
                    }

                }
            }, {
                data: "is_delete",
                targets: "is_delete",
                bAutoWidth: true,
                visible: false,
                searchable: true,
                mRender: function (data_sup, type_sup, row_sup) {
                    if (data_sup === '1') {
                        return "NActive";
                    }
                    if (data_sup === '0') {
                        return "Active";
                    }

                }
            }, {
                data: "action_po",
                targets: "action_po",
                mRender: function (data_po, type_po, row_po) {
                    if (row_po["purchase_id"] !== null) {
                        var va_purchase_id = row_po["purchase_id"];
                        var va_purchase_code = row_po["purchase_code"];
                        var va_supplier_id = row_po["supplier_id"];
                        var va_supplier_name = row_po["supplier_name"];
                        var va_tax = row_po["supplier_tax"];
                        var va_tgl_input_po = row_po["tgl_input_po"];
                        var va_po_type = row_po["po_type"];
                        var va_payment_term = row_po["payment_term"];
                        var va_delivery_term = row_po["delivery_term"];
                        var va_transport_mode = row_po["transport_mode"];
                        var va_quotation_number = row_po["quotation_number"];
                        var va_rfq_number = row_po["rfq_number"];
                        var va_dlvr_point = row_po["dlvr_point"];
                        var va_invoice_to = row_po["invoice_to"];
                        var va_purchase_desc = row_po["purchase_desc"];
                        var va_pic = row_po["pic"];
                        var va_is_delete = row_po["is_delete"];
                        var va_supplier_code = row_po["supplier_code"];

                        var data_form_po = {
                            purchase_id: va_purchase_id,
                            purchase_code: va_purchase_code,
                            supplier_id: va_supplier_id,
                            supplier_name: va_supplier_name,
                            supplier_code: va_supplier_code,
                            supplier_tax: va_tax,
                            tgl_input_po: va_tgl_input_po,
                            po_type: va_po_type,
                            payment_term: va_payment_term,
                            delivery_term: va_delivery_term,
                            transport_mode: va_transport_mode,
                            quotation_number: va_quotation_number,
                            rfq_number: va_rfq_number,
                            dlvr_point: va_dlvr_point,
                            invoice_to: va_invoice_to,
                            purchase_desc: va_purchase_desc,
                            pic: va_pic,
                            is_delete: va_is_delete

                        };
                        if (row_po["is_delete"] === "0") {//active
                            if (row_po["status_po"] !== "No Item" ) {
//                            $("i#list_item").css("background-color", "blue");
                                return"<a href='#'><i class='fa fa-check-square-o' title='inactive'></i></a>\n\
                               <a id='addItemPo' href='#' onclick='javascript:addPoItemFunc(" + JSON.stringify(data_form_po) + ")'><i class='fa fa-plus' title='Add Item'></i></a>\n\
                               <a id='listtemPo' href='#' onclick='javascript:listPoItemFunc(" + JSON.stringify(data_form_po) + ")'><i id='list_item' class='fa fa-list fa-fw'  title='List Item'></i></a>\n\
                               <a id='updateDataPo' href='#' onclick='javascript:editPoFunc(" + JSON.stringify(data_form_po) + ")'><i class='fa fa-edit'title='Edit PO'></i></a>\n\
                               <a href='#' onclick='javascript:deletePoFunc(" + JSON.stringify(data_form_po) + ")'><i class='fa fa-trash ' title='Delete'></i></a>";
                            } else if (row_po["status_po"] === "No Item") {
//                            $("i#list_item").css("background-color", "#e0e0d1");
                                return"<a href='#'><i class='fa fa-check-square-o' title='inactive'></i></a>\n\
                               <a  id='addItemPo' href='#' onclick='javascript:addPoItemFunc(" + JSON.stringify(data_form_po) + ")'><i class='fa fa-plus' title='Add Item'></i></a>\n\
                               <a  id='listtemPo' href='#'><i id='list_item' class='fa fa-list fa-fw' style='color:#e0e0d1;'  title='List Item'></i></a>\n\
                               <a id='updateDataPo' href='#' onclick='javascript:editPoFunc(" + JSON.stringify(data_form_po) + ")'><i class='fa fa-edit'title='Edit PO'></i></a>\n\
                               <a href='#' onclick='javascript:deletePoFunc(" + JSON.stringify(data_form_po) + ")'><i class='fa fa-trash ' title='Delete'></i></a>";
                            }
                        }
//                      return "<a href='" + data_pict_1 + " 'target='_blank' class='btn btn-info'>" + "<font color='#f2f2f2' size='2em'>" + "Display" + "</font>" + "</a>";
                    }
                }
            }],
//        order: [[1, 'asc']]
        asSorting: [[1, 'desc']]
    });
    tbl_grid_form_po.on('order.dt search.dt', function () {
        tbl_grid_form_po.column(0, {search: 'applied', order: 'applied'}).nodes().each(function (cell, i) {
            cell.innerHTML = i + 1;
        });
    }).draw();
    $('#grid_form_po tbody').on('click', 'tr', function (item) {
        var data = tbl_grid_form_po.row(this).data();
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

//function myFunctionCreatePO() {
//    console.log("Insert myFunctionCreatePO");
//
//    //     $('#form_add_delegate').modal("show");
//    $("#form_add_po").dialog().dialog("open");
//    $(".invisible").removeClass("invisible");
//    //     $("#pic_delegate").autocomplete("autocompleteTechnicianServlet");
//    $('#form_add_po').dialog("widget").position({
//        my: 'left top',
//        at: 'left bottom'
//    });
//    $("#form_add_po").dialog({
//        autoOpen: false,
//        title: "Create PO",
//        show: "blind",
//        hide: "explode",
//        modal: true,
//        width: 450, // overcomes width:'auto' and maxWidth bug
//        height: 600,
//        maxWidth: 600,
//        fluid: true, //new option
//        resizable: false,
//        buttons: [{
//                text: 'Submit',
//                class: 'btn btn-primary',
//                click: function () {
//                    console.log("@ here");
//                    var supplier_name = $("#supplier_name").val();
//                    var tgl_input_po = $("#tgl_input_po").val();
//                    if ($("#supplier_name").val() === "") {
//                        $('#supplier_name').css('background', '#e74c3c');
//                        return false;
//                    }
//                    if ($("#tgl_input_po").val() === "") {
//                        $('#tgl_input_po').css('background', '#e74c3c');
//                        return false;
//                    }
//                    if (confirm("New Data PO\n\n"
//                            + "Supplier    :" + supplier_name + "\n\n"
//                            + "Date  :" + tgl_input_po + "\n\n"
//                            ) === true) {
//                        $('#supplier_name').css('background', '');
//                        $('#tgl_input_po').css('background', '');
//                    } else {
//                        console.log("cancel");
//                        $('#supplier_name').css('background', '');
//                        $('#tgl_input_po').css('background', '');
//                        return false;
//                    }
//                    var data_delegate = $("#form_add_po").serialize();
//                    console.log("data_delegate" + data_delegate);
//                    $.ajax({
//                        type: "POST",
//                        url: createDynamicURL() + "/createDelegationServlet",
//                        data: data_delegate
//                    });
//                    document.getElementById("form_add_po").reset();
////                    document.getElementById("tbl_delegate").reset();
////                    $('#tbl_delegate').ajax.reload(function (json) {
////
////                    });
//
//                    $('#tbl_grid_form_po').ajax.reload();
//                    location.reload();
//                    return;
//                }
//            }, {
//                text: 'Clear',
//                class: 'btn btn-primary',
//                click: function () {
//
//                    document.getElementById("form_add_po").reset();
//                    $('#supplier_name').css('background', '');
//                    $('#tgl_input_po').css('background', '');
//
////                    return;
//                }
//            }],
//        close: function () {
//            // Close code here (incidentally, same as Cancel code)
////            $('#tbl_delegate').ajax.reload();
//            document.getElementById("form_add_delegate").reset();
//            location.reload();
//            return;
////            return;
//        }
//    })
//}
//$(function () {
//    $('body').on('contextmenu', 'tr', function (e) {
//        e.preventDefault();
//        alert(this.id);
//    });
//});
