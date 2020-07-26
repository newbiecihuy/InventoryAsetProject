/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var editor; // use a global for the submit and return data rendering in the examples
$(document).ready(function () {
//    var purchase_id = document.getElementById("purchase_id").value;
//    var supplier_id_po = document.getElementById("supplier_id_form_create_po").value;
    var servletParam = "/stockItemRaw?";
//    if (purchase_id !== "") {
//        servletParam = "/stockItemRaw?purchase_id=" + purchase_id + "&supplier_id_po=" + supplier_id_po;
//    }
    var tbl_grid_list_stock_item = $("#grid_list_stock_item").DataTable({
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
            url: createDynamicURL() + servletParam,
            dataType: "json", //jsonp
            dataSrc: 'rows'
        },
        columns: [{
                data: "no_item_raw",
                targets: "no_item_raw",
                bSortable: true
            }, {
                data: "id_item_raw",
                targets: "id_item_raw",
                bAutoWidth: true,
                visible: false,
                searchable: false
            }, {
                data: "id_supplier_raw",
                targets: "id_supplier_raw",
                bAutoWidth: true,
                visible: false,
                searchable: false
            }, {
                data: "id_categories_raw",
                targets: "id_categories_raw",
                bAutoWidth: true,
                visible: false,
                searchable: true
            }, {
                data: "categories_raw",
                targets: "categories_raw",
                bAutoWidth: true,
                visible: true,
                searchable: true
            }, {
                data: "item_code_raw",
                targets: "item_code_raw",
                bAutoWidth: true,
                visible: true,
                searchable: true
            }, {
                data: "item_name_raw",
                targets: "item_name_raw",
                bAutoWidth: true,
                visible: true,
                searchable: true
            }, {
                data: "item_desc_raw",
                targets: "item_desc_raw",
                bAutoWidth: true,
                searchable: true

            }, {
                data: "id_stock_raw",
                targets: "id_stock_raw",
                bAutoWidth: true,
                visible: false,
                searchable: true
            }, {
                data: "item_stock_raw",
                targets: "item_stock_raw",
                bAutoWidth: true,
                visible: true,
                searchable: true
            }, {
                data: "item_sell_price_raw",
                targets: "item_sell_price_raw",
                bAutoWidth: true,
                searchable: true
            }],
        order: [[1, 'asc']]
    });
    tbl_grid_list_stock_item.on('order.dt search.dt', function () {
        tbl_grid_list_stock_item.column(0, {search: 'applied', order: 'applied'}).nodes().each(function (cell, i) {
            cell.innerHTML = i + 1;
        });
    }).draw();
    $('#grid_list_item_po tbody').on('click', 'tr', function (item) {
        var data = tbl_grid_list_stock_item.row(this).data();
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


