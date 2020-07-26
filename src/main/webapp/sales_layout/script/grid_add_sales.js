/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var editor; // use a global for the submit and return data rendering in the examples
$(document).ready(function () {
    var tbl_grid_add_sales = $("#grid_add_sales").DataTable({
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
            url: createDynamicURL() + "/createSales",
            dataType: "json", //jsonp
            dataSrc: 'rows'
        },
        columns: [{
                data: "no",
                targets: "no"
            }
            }, {
                data: "sales_order_id",
                targets: "sales_order_id",
                bAutoWidth: true,
                visible: false,
                searchable: false
            }, {
                data: "sales_order_code",
                targets: "sales_order_code",
                bAutoWidth: true,
                visible: true,
                searchable: true
            }, {
                data: "customer_name",
                targets: "customer_name",
                bAutoWidth: true,
                visible: true,
                searchable: true
            }, {
                data: "customer_code",
                targets: "customer_code",
                bAutoWidth: true,
                visible: true,
                searchable: true
            }, {
                data: "supplier_tax",
                targets: "supplier_tax",
                bAutoWidth: true,
                visible: true,
                searchable: true
            }, {
                data: "tgl_input_so",
                targets: "tgl_input_so",
                bAutoWidth: true,
                visible: true,
                searchable: true
            }, {
                data: "so_type",
                targets: "so_type",
                bAutoWidth: true,
                visible: true,
                searchable: true
            }, {
                data: "payment_term_so",
                targets: "payment_term_so",
                bAutoWidth: true,
                visible: true,
                searchable: true
            }, {
                data: "delivery_term_so",
                targets: "delivery_term_so",
                bAutoWidth: true,
                visible: true,
                searchable: true
            }, {
                data: "transport_mode_so",
                targets: "transport_mode_so",
                bAutoWidth: true,
                visible: true,
                searchable: true
            }, {
                data: "quotation_number_so",
                targets: "quotation_number_so",
                bAutoWidth: true,
                visible: true,
                searchable: true
            }, {
                data: "rfq_number_so",
                targets: "rfq_number_so",
                bAutoWidth: true,
                visible: false,
                searchable: false
            }, {
                data: "dlvr_point_so",
                targets: "dlvr_point_so",
                bAutoWidth: true,
                visible: true,
                searchable: true
            }, {
                data: "invoice_to_so",
                targets: "invoice_to_so",
                bAutoWidth: true,
                visible: true,
                searchable: true
            }, {
                data: "so_desc",
                targets: "so_desc",
                bAutoWidth: false,
                visible: true,
                searchable: true
            }, {
                data: "status_so",
                targets: "status_so",
                bAutoWidth: false,
                visible: true,
                searchable: true
            }, {
                data: "pic",
                targets: "pic",
                bAutoWidth: false,
                visible: true,
                searchable: true
            }, {
                data: "is_approve",
                targets: "is_approve",
                bAutoWidth: false,
                visible: true,
                searchable: true,
                mRender: function (data_is_approve_so, type_is_approve_so, row_is_approve_so) {
                    if (data_is_approve_so === 1) {
                        return "Approve";
                    }
                    if (data_is_approve_so === 0) {
                        return "NotApprove";
                    }
                    if (data_is_approve_so === 2) {
                        return "Reject";
                    }

                }
            }, {
                data: "is_delete",
                targets: "is_delete",
                bAutoWidth: false,
                visible: true,
                searchable: true,
                mRender: function (data_is_delete_so, type_is_delete_so, row_is_delete_so) {
                    if (data_is_delete_so === '1') {
                        return "NActive";
                    }
                    if (data_is_delete_so === '0') {
                        return "Active";
                    }

                }
            }, {
                data: "action_so",
                targets: "action_so",
                bAutoWidth: false,
                visible: true,
                searchable: true
            }]
//        order: [[1, 'asc']]
        , asSorting: [[1, 'desc']]
    });
    tbl_grid_add_sales.on('order.dt search.dt', function () {
        tbl_grid_add_sales.column(0, {search: 'applied', order: 'applied'}).nodes().each(function (cell, i) {
            cell.innerHTML = i + 1;
        });
    }).draw();
    $('#grid_add_sales tbody').on('click', 'tr', function (item) {
        var data = tbl_grid_add_sales.row(this).data();
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