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
        pageLength: 10,
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
            }],
//        order: [[1, 'asc']]
        asSorting: [[1, 'desc']]
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