/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var editor; // use a global for the submit and return data rendering in the examples
$(document).ready(function () {
    var purchase_id = document.getElementById("purchase_id").value;
    var supplier_id_po = document.getElementById("supplier_id_form_create_po").value;
    var servletParam = "/ceatePOItemServlet?";
    if (purchase_id !== "") {
        servletParam = "/ceatePOItemServlet?purchase_id=" + purchase_id + "&supplier_id_po=" + supplier_id_po;
    }
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
            url: createDynamicURL() + servletParam,
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
                searchable: true,
                mRender: function (data_tax_po, type_tax_po, row_tax_po) {
                    if (data_tax_po === 1) {
                        return "tax";
                    } else {
                        return "--";
                    }
                }
            }, {
                data: "product_name_po",
                targets: "product_name_po",
                bAutoWidth: true,
                searchable: true
            }, {
                data: "qtty_item_po",
                targets: "qtty_item_po",
                bAutoWidth: true,
                searchable: true
            }, {
                data: "price_item_po",
                targets: "price_item_po",
                bAutoWidth: true,
                searchable: true
            }, {
                data: "pic_item_po",
                targets: "pic_item_po",
                bAutoWidth: true,
                visible: false,
                searchable: true
            }, {
                data: "is_delete",
                targets: "is_delete",
                bAutoWidth: true,
                visible: false,
                searchable: true
            }, {
                data: "action_item_po",
                targets: "action_item_po",
                mRender: function (data_po, type_po, row_po) {
                    if (row_po["id_po"] !== null) {
                        var va_id_po = row_po["id_po"];
                        var va_id_supplier_po = row_po["id_supplier_po"];
                        var va_id_categories_po = row_po["id_categories_po"];
                        var va_id_product_po = row_po["id_product_po"];
                        var va_supplier_name_po = row_po["supplier_name_po"];
                        var va_supplier_code_po = row_po["supplier_code_po"];
                        var va_supplier_tax_po = row_po["supplier_tax_po"];
                        var va_product_name_po = row_po["product_name_po"];
                        var va_qtty_item_po = row_po["qtty_item_po"];
                        var va_price_item_po = row_po["price_item_po"];
                        var va_pic = row_po["pic"];
                        var va_is_delete = row_po["is_delete"];

                        var data_item_po = {
                            id_po: va_id_po,
                            id_supplier_po: va_id_supplier_po,
                            id_categories_po: va_id_categories_po,
                            id_product_po: va_id_product_po,
                            supplier_name_po: va_supplier_name_po,
                            supplier_code_po: va_supplier_code_po,
                            supplier_tax_po: va_supplier_tax_po,
                            product_name_po: va_product_name_po,
                            qtty_item_po: va_qtty_item_po,
                            price_item_po: va_price_item_po,
                            pic: va_pic,
                            is_delete: va_is_delete

                        };
                        if (row_po["is_delete"] === "0") {//active
//                            $("i#list_item").css("background-color", "blue");
                            return"<a id='updateDataPo' href='#' onclick='javascript:editItemPoFunc(" + JSON.stringify(data_item_po) + ")'><i class='fa fa-edit'title='Edit Item'></i></a>\n\
                               <a href='#' onclick='javascript:deleteItemPoFunc(" + JSON.stringify(data_item_po) + ")'><i class='fa fa-trash 'title='Delete'></i></a>";
                        } else {
//                            $("i#list_item").css("background-color", "#e0e0d1");
                            return"<a id='updateDataPo' href='#' onclick=''><i class='fa fa-edit' style='color:#e0e0d1;' title='Edit Item'></i></a>\n\
                               <a href='#' onclick='javascript:deleteItemPoFunc(" + JSON.stringify(data_item_po) + ")'><i class='fa fa-trash ' title='Delete'></i></a>";
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
        var data = tbl_grid_list_item_po.row(this).data();
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
