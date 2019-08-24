/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var editor; // use a global for the submit and return data rendering in the examples
$(document).ready(function () {
    var table_grid_company = $("#grid_company").DataTable({
        bJQueryUI: false,
        bStateSave: true,
        autoFill: true,
        paging: true,
        dom: 'Bfrtip',
        select: true,
        responsive: true,
        scrollY: "300px",
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
        "processing": true,
        "serverSide": true,
        ajax: {
            url: "/FieldServiceSolution/companyDataServlet",
            dataType: "json", //jsonp
            dataSrc: 'rows'
        },
        columns: [{
                data: "noCompany",
                targets: "noCompany",
                bSortable: true
            }, {
                data: "idCompany",
                targets: "idCompany",
                bAutoWidth: true,
                visible: false,
                searchable: false,
            }, {
                data: "companyName",
                targets: "companyName",
                bAutoWidth: true,
                visible: true,
                searchable: false,
                mRender: function (data_companyName, type_companyName, row_companyName) {
                    if (data_companyName === "" || row_companyName["isActive_company"] === "false") {
                        return "<b>DISABLE</b>";
                    } else {
//                        return data_pict_1;
                        return data_companyName;
//                        return "<a href='" + data_pict_1 + " 'target='_blank' class='btn btn-info'>" + "<font color='#f2f2f2' size='2em'>" + "Display" + "</font>" + "</a>";
                    }
                }
            }, {
                data: "companyAddrs",
                targets: "companyAddrs",
                bAutoWidth: true,
                visible: true,
                searchable: false,
                mRender: function (data_companyAddrs, type_companyAddrs, row_companyAddrs) {
                    if (data_companyAddrs === "" || row_companyAddrs["isActive_company"] === "false") {
                        return "<b>DISABLE</b>";
                    } else {
//                        return data_pict_1;
                        return data_companyAddrs;
//                        return "<a href='" + data_pict_1 + " 'target='_blank' class='btn btn-info'>" + "<font color='#f2f2f2' size='2em'>" + "Display" + "</font>" + "</a>";
                    }
                }
            }, {
                data: "companyTitle",
                targets: "companyTitle",
                bAutoWidth: true,
                visible: true,
                searchable: false,
                mRender: function (data_companyTitle, type_companyTitle, row_companyTitle) {
                    if (data_companyTitle === "" || row_companyTitle["isActive_company"] === "false") {
                        return "<b>DISABLE</b>";
                    } else {
//                        return data_pict_1;
                        return data_companyTitle;
//                        return "<a href='" + data_pict_1 + " 'target='_blank' class='btn btn-info'>" + "<font color='#f2f2f2' size='2em'>" + "Display" + "</font>" + "</a>";
                    }
                }

            }, {
                data: "companyLogo",
                targets: "companyLogo",
                bAutoWidth: true,
                visible: true,
                searchable: false,
                mRender: function (data_companyLogo, type_pict_1, row_pict_1) {
                    if (data_companyLogo === "" || row_pict_1["isActive_company"] === "false") {
                        return "<b>DISABLE</b>";
                    } else {
//                        return data_pict_1;
                        return "<a href='" + 'tmpCompanyLogo/' + data_companyLogo + " 'target='_blank' class='btn btn-info'>" + "<font color='#f2f2f2' size='2em'>" + "Display" + "</font>" + "</a>";
//                        return "<a href='" + data_pict_1 + " 'target='_blank' class='btn btn-info'>" + "<font color='#f2f2f2' size='2em'>" + "Display" + "</font>" + "</a>";
                    }
                }
            }, {
                data: "isActive_company",
                targets: "isActive_company",
                bAutoWidth: true,
                visible: false,
                searchable: false
            }], createdRow: function (row, data, index) {

            if (data["isActive_company"] === "false") {
//                $(row).addClass('red');
                $(row).css('color', 'red');
            }
        },
        asSorting: [[1, 'desc']]

    });
    table_grid_company.on('order.dt search.dt', function () {
        table_grid_company.column(0, {search: 'applied', order: 'applied'}).nodes().each(function (cell, i) {
            cell.innerHTML = i + 1;
        });
    }).draw();
    $('#grid_company tbody').on('click', 'tr', function (item) {
        var data = table_grid_company.row(this).data();
        var ids = $.map(table_grid_company.rows('.selected').data(), function (item) {
            return item[0];
        });
        $('#edit_company_config').click(function () {
            alert('FEATURE IN PROGRESS');
            return;
        });
        $('#delete_company_config').click(function () {
            var id_company_delete = [];
            var rows = $('tr.selected');
            var rowData = table_grid_company.rows(rows).data();
            $.each($(rowData), function (key, value) {
                id_company_delete.push(value["idCompany"]); //"name" being the value of your first column.
            });
            var isi_id_company_delete = "";
            for (i = 0; i < id_company_delete.length; i++) {
                isi_id_company_delete = id_company_delete[i];
            }

            var dataJSONDelete = {
                action_form_company: "Delete",
                id_form_company: isi_id_company_delete
            };
            $.ajax({
                type: "POST",
                url: "/FieldServiceSolution/companyDataServlet",
                dataType: "json",
                data: {JSONFile: "[" + JSON.stringify(dataJSONDelete) + "]"}, // look here!
                success: function (response) {
                    //our country code was correct so we have some information to display
                    if (response.RC === "1xpld") {

                        $("#ajaxResponse_form_submit_company").html("<div><p><b>" + "SUCCES DELETE DATA" + "</b></p></div>");
//                        $('#btn_ubmit_form_email_config').prop('disabled', true);
                        location.reload();
//                        return;
                    } else {
                        $("#ajaxResponse_form_submit_company").html("<div><p><b>Invalid!</b></p></div>");
                    }
                },
                //If there was no resonse from the server
                error: function (jqXHR, textStatus, errorThrown) {
                    console.log("Something really bad happened " + textStatus);
                    $("#form_email_config").html(jqXHR.responseText);
                }
            });
        });
        $('#actived_company_config').click(function () {
            if (table_grid_company.rows('.selected').data().length === 0) {
                alert('row(s) selected');
                return;
            }

            var id_company_enable = [];
            var rows = $('tr.selected');
            var data_isActive = [];
            var rowData = table_grid_company.rows(rows).data();
            $.each($(rowData), function (key, value) {
                id_company_enable.push(value["idCompany"]); //"name" being the value of your first column.
                data_isActive.push(value["isActive_company"]);
            });
            var isi_id_company_enable = "";
            var isi_data_isActive = "";
            for (i = 0; i < id_company_enable.length; i++) {
                isi_id_company_enable = id_company_enable[i];
                isi_data_isActive = data_isActive[i];
            }

            var dataJSON_Enable = {
                action_form_company: "ENABLE",
                id_form_company: isi_id_company_enable,
                isActive_company: isi_data_isActive
            };
            $.ajax({
                type: "POST",
                url: "/FieldServiceSolution/companyDataServlet",
                dataType: "json",
                data: {JSONFile: "[" + JSON.stringify(dataJSON_Enable) + "]"}, // look here!
                success: function (response) {
                    //our country code was correct so we have some information to display
                    if (response.RC === "1xpl") {

                        $("#ajaxResponse_enable_company").html("<div><p><b>" + "CONFIG ENABLED" + "</b></p></div>");
//                        $('#btn_ubmit_form_email_config').prop('disabled', true);
                        location.reload();
//                        return;
                    } else {
                        $("#ajaxResponse_enable_company").html("<div><p><b>Invalid!</b></p></div>");
                    }
                },
                //If there was no resonse from the server
                error: function (jqXHR, textStatus, errorThrown) {
                    console.log("Something really bad happened " + textStatus);
                    $("#table_grid_company").html(jqXHR.responseText);
                }
            });
        });
    });
});

