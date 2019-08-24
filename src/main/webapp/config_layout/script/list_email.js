/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var editor; // use a global for the submit and return data rendering in the examples
$(document).ready(function () {
    var tbl_grid_email_config = $("#grid_email_config").DataTable({
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

        ], ajax: {
            url: createDynamicURL() + "/protocolServlet",
            dataType: "json", //jsonp
            dataSrc: 'rows'
        },
        columns: [{
                data: "no_protocol",
                targets: "no_protocol",
                bSortable: true
            }, {
                data: "idProtocol",
                targets: "idProtocol",
                bAutoWidth: true,
                visible: false,
                searchable: false
            }, {
                data: "smtpHost",
                targets: "smtpHost",
                bAutoWidth: true,
                visible: true,
                searchable: false,
                mRender: function (data_smtpHost, type_smtpHost, row_smtpHost) {
                    if (data_smtpHost === "" || row_smtpHost["isActive"] === "NON") {
                        return "<b>DISABLE</b>";
                    } else {
//                        return data_pict_1;
                        return data_smtpHost;
//                        return "<a href='" + data_pict_1 + " 'target='_blank' class='btn btn-info'>" + "<font color='#f2f2f2' size='2em'>" + "Display" + "</font>" + "</a>";
                    }
                }
            }, {
                data: "smtpSocketFactoryPort",
                targets: "smtpSocketFactoryPort",
                bAutoWidth: true,
                visible: true,
                searchable: false,
                mRender: function (data_smtpSocketFactoryPort, type_smtpSocketFactoryPort, row_smtpSocketFactoryPort) {
                    if (data_smtpSocketFactoryPort === "" || row_smtpSocketFactoryPort["isActive"] === "NON") {
                        return "<b>DISABLE</b>";
                    } else {
//                        return data_pict_1;
                        return data_smtpSocketFactoryPort;
//                        return "<a href='" + data_pict_1 + " 'target='_blank' class='btn btn-info'>" + "<font color='#f2f2f2' size='2em'>" + "Display" + "</font>" + "</a>";
                    }
                }
            }, {
                data: "smtpSocketFactoryClass",
                targets: "smtpSocketFactoryClass",
                bAutoWidth: true,
                visible: true,
                searchable: false,
                mRender: function (data_smtpSocketFactoryClass, type_smtpSocketFactoryClass, row_smtpSocketFactoryClass) {
                    if (data_smtpSocketFactoryClass === "" || row_smtpSocketFactoryClass["isActive"] === "NON") {
                        return "<b>DISABLE</b>";
                    } else {
//                        return data_pict_1;
                        return data_smtpSocketFactoryClass;
//                        return "<a href='" + data_pict_1 + " 'target='_blank' class='btn btn-info'>" + "<font color='#f2f2f2' size='2em'>" + "Display" + "</font>" + "</a>";
                    }
                }
            }, {
                data: "smtpPort",
                targets: "smtpPort",
                bAutoWidth: true,
                visible: true,
                searchable: false,
                mRender: function (data_smtpPort, type_smtpPort, row_smtpPort) {
                    if (data_smtpPort === "" || row_smtpPort["isActive"] === "NON") {
                        return "<b>DISABLE</b>";
                    } else {
//                        return data_pict_1;
                        return data_smtpPort;
//                        return "<a href='" + data_pict_1 + " 'target='_blank' class='btn btn-info'>" + "<font color='#f2f2f2' size='2em'>" + "Display" + "</font>" + "</a>";
                    }
                }
            }, {
                data: "email",
                targets: "email",
                bAutoWidth: true,
                visible: true,
                searchable: false,
                mRender: function (data_email, type_email, row_email) {
                    if (data_email === "" || row_email["isActive"] === "NON") {
                        return "<b>DISABLE</b>";
                    } else {
//                        return data_pict_1;
                        return data_email;
//                        return "<a href='" + data_pict_1 + " 'target='_blank' class='btn btn-info'>" + "<font color='#f2f2f2' size='2em'>" + "Display" + "</font>" + "</a>";
                    }
                }
            }, {
                data: "email_pass",
                targets: "email_pass",
                bAutoWidth: true,
                visible: false,
                searchable: false
            }, {
                data: "isActive",
                targets: "isActive",
                bAutoWidth: true,
                visible: false,
                searchable: false
            }, {
                data: "action_email",
                targets: "action_email",
                mRender: function (data_app, type_app, row_app) {
                    if (row_app["idProtocol"] !== null) {
                        return"<a href='#'><i class='fa fa-check-square-o activeRecord' rel='13' title='inactive'></i>\n\
                               <a href='#'><i class='fa fa-edit' aria-hidden='true' title='Edit></i> \n\
                               <a href='#' onclick='return confirm('Delete Data ?')'> <i class='fa fa-trash' aria-hidden='true' title='Delete'></i>";
//                      return "<a href='" + data_pict_1 + " 'target='_blank' class='btn btn-info'>" + "<font color='#f2f2f2' size='2em'>" + "Display" + "</font>" + "</a>";
                    }
                }
            }], createdRow: function (row, data, index) {

            if (data["isActive"] === "NON") {
//                $(row).addClass('red');
                $(row).css('color', 'red');
            }
        },
        order: [[1, 'asc']]
    });
    tbl_grid_email_config.on('order.dt search.dt', function () {
        tbl_grid_email_config.column(0, {search: 'applied', order: 'applied'}).nodes().each(function (cell, i) {
            cell.innerHTML = i + 1;
        });
    }).draw();
    $('#grid_email_config tbody').on('click', 'tr', function (item) {

        var data = tbl_grid_email_config.row(this).data();
        var ids = $.map(tbl_grid_email_config.rows('.selected').data(), function (item) {
            return item[0];
        });
    });
});