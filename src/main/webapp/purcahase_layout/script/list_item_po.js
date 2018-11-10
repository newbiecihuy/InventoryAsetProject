/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var editor; // use a global for the submit and return data rendering in the examples
$(document).ready(function () {
    var tbl_grid_list_item_po = $("#grid_list_item_po").DataTable({
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
            url: createDynamicURL() + "/ceatePOItemServlet",
            dataType: "json", //jsonp
            dataSrc: 'rows'
        },
        columns: [{
                data: "no_itemPo",
                targets: "no_itemPo",
                bSortable: true
            }, {
                data: "id_po",
                targets: "id_po",
                bAutoWidth: true,
                visible: false,
                searchable: false
            }, {
                data: "id_supplier_po",
                targets: "id_supplier_po",
                bAutoWidth: true,
                visible: false,
                searchable: false
            }, {
                data: "id_categories_po",
                targets: "id_categories_po",
                bAutoWidth: true,
                visible: false,
                searchable: true
            }, {
                data: "id_product_po",
                targets: "id_product_po",
                bAutoWidth: true,
                visible: false,
                searchable: true
            }, {
                data: "supplier_name_po",
                targets: "supplier_name_po",
                bAutoWidth: true,
                visible: false,
                searchable: true
            }, {
                data: "supplier_code_po",
                targets: "supplier_code_po",
                bAutoWidth: true,
                visible: false,
                searchable: true
            }, {
                data: "supplier_tax_po",
                targets: "supplier_tax_po",
                bAutoWidth: true,
                visible: false,
                searchable: true
            }, {
                data: "product_name_po",
                targets: "product_name_po",
                bAutoWidth: true,
                searchable: true
            }, {
                data: "pice_item_po",
                targets: "pice_item_po",
                bAutoWidth: true,
                searchable: true
            }, {
                data: "action_item_po",
                targets: "action_item_po",
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
                            if (row_po["status_po"] !== "No Item") {
//                            $("i#list_item").css("background-color", "blue");
                                return"<a href='#'><i class='fa fa-check-square-o' title='inactive'></i></a>\n\
                               <a  id='addItemPo' href='#' onclick='javascript:addPoItemFunc(" + JSON.stringify(data_form_po) + ")'><i class='fa fa-plus' title='Add Item'></i></a>\n\
                               <a  id='listtemPo' href='#' onclick='javascript:listPoItemFunc(" + JSON.stringify(data_form_po) + ")''><i id='list_item' class='fa fa-list fa-fw'  title='List Item'></i></a>\n\
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
        order: [[1, 'asc']]
    });
    tbl_grid_list_item_po.on('order.dt search.dt', function () {
        tbl_grid_list_item_po.column(0, {search: 'applied', order: 'applied'}).nodes().each(function (cell, i) {
            cell.innerHTML = i + 1;
        });
    }).draw();
    $('#grid_list_item_po tbody').on('click', 'tr', function (item) {
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
