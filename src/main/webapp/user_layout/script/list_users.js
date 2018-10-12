/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var editor; // use a global for the submit and return data rendering in the examples
$(document).ready(function () {
    var table_grid_users = $("#grid_users").DataTable({
        processing: true,
        serverSide: true,
        colReorder: true,
        bJQueryUI: false,
        bStateSave: true,
        autoFill: true,
        paging: true,
        dom: 'Bfrtip',
        select: true,
        responsive: true,
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
//        colReorder:true,
        ajax: {
            url: createDynamicURL() + "/userServlet",
            datatype: "json",
            type: 'GET',
            dataSrc: 'rows'
        },
        columns: [{
                data: "no",
                targets: "no",
                bSortable: true
            }, {
                data: "id_user",
                targets: "id_user",
                bAutoWidth: true,
                visible: false,
                searchable: false
            }, {
                data: "user_name",
                targets: "user_name",
                bAutoWidth: true,
                visible: true,
                searchable: true
            }, {
                data: "gender",
                targets: "gender",
                bAutoWidth: true,
                visible: true,
                searchable: true,
                mRender: function (data_gender, type_gender, row_gender) {
                    if (data_gender === 'M') {
                        return "Male";
                    }
                    if (data_gender === 'F') {
                        return "Female";
                    }

                }
            }, {
                data: "address",
                targets: "address",
                bAutoWidth: true,
                visible: true,
                searchable: false
            }, {
                data: "imei",
                targets: "imei",
                bAutoWidth: true,
                visible: true,
                searchable: true
            }, {
                data: "phone",
                targets: "phone",
                bAutoWidth: true,
                visible: true,
                searchable: true
            }, {
                data: "role_name",
                targets: "role_name",
                bAutoWidth: true,
                visible: true,
                searchable: true
            }, {
                data: "email",
                targets: "email",
                bAutoWidth: true,
                visible: true,
                searchable: true
            }, {
                data: "status_user",
                targets: "status_user",
                bAutoWidth: true,
                visible: true,
                searchable: true
            }, {
                data: "register_date",
                targets: "register_date",
                bAutoWidth: true,
                visible: true,
                searchable: true
            }, {
                data: "last_login",
                targets: "last_login",
                bAutoWidth: true,
                visible: true,
                searchable: true
            }, {
                data: "jses_id",
                targets: "jses_id",
                bAutoWidth: true,
                visible: true,
                searchable: true
            }, {
                data: "getDevice_id_login",
                targets: "getDevice_id_login",
                bAutoWidth: true,
                visible: true,
                searchable: true
            }, {
                data: "action_user",
                targets: "action_user",
                mRender: function (data_app, type_app, row_app) {
                    if (row_app["id_user"] !== null) {
                        var va_id_user = row_app["id_user"];
                        var va_user_name = row_app["user_name"];
                        var va_gender = row_app["gender"];
                        var va_address = row_app["address"];
                        var va_imei = row_app["imei"];
                        var va_phone = row_app["phone"];
                        var va_role_name = row_app["role_name"];
                        var va_email = row_app["email"]; //,supplier_name,supplier_code,address,contact_name,contact_num,status_supp
                        var va_status_user = row_app["status_user"]; // <a href='#'id='updateDataUser' onclick='javascript:myFunc(" + supplier_id + ")'><i class='fa fa-edit'title='Edit'></i></a>\n\

                        var data_users = {
                            id_user: va_id_user,
                            user_name: va_user_name,
                            gender: va_gender,
                            imei: va_imei,
                            phone: va_phone,
                            address: va_address,
                            role_name: va_role_name,
                            email: va_email,
                            status_user: va_status_user
                        };
                        return"<a href='#'><i class='fa fa-check-square-o activeRecord' rel='13' title='inactive'></i></a>\n\
                               <a id='updateDataUser' href='#' onclick='return editUserFunc(" + JSON.stringify(data_users) + ")'><i class='fa fa-edit activeRecord' rel='13' title='Edit'></i></a>\n\
                               <a href='#' onclick='return deleteUserFunc(" + JSON.stringify(data_users) + ")'><i class='fa fa-trash activeRecord' rel='13'title='Delete'></i></a>";
//                      return "<a href='" + data_pict_1 + " 'target='_blank' class='btn btn-info'>" + "<font color='#f2f2f2' size='2em'>" + "Display" + "</font>" + "</a>";
                    }
                }
            }],
        order: [[1, 'desc']]
    });
    table_grid_users.on('order.dt search.dt', function () {
        table_grid_users.column(0, {search: 'applied', order: 'applied'}).nodes().each(function (cell, i) {
            cell.innerHTML = i + 1;
        });
    }).draw();
    $('#grid_users tbody').on('click', 'tr', function (item) {
        var data = table_grid_users.row(this).data();
        $('#edit_users_details').click(function () {

            console.log("Insert myFunction_edit");
            var ids = $.map(table_grid_users.rows('.selected').data(), function (item) {
                return item[0];
            });
            console.log(ids);
            if (table_grid_users.rows('.selected').data().length === 0) {
                alert(' row(s) selected');
                return;
            }

        });
    });
});
//function editUserFunc(data_users) {//, supplier_name, supplier_code, address, contact_name, contact_num, status_supp
//
////    alert(data_users.gender);
//    var myParam = "data_users=" + data_users;
//    window.location = "index.jsp?url=user_layout&pages=add_user_form&" + myParam;
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
//    $("#form_upload_excel_user").dialog({
//        autoOpen: false,
//        title: "Upload Data Users",
//        show: "blind",
//        hide: "explode",
//        modal: true,
//        width: 350,
//        zIndex: 1,
//        buttons: [{
//                text: 'Upload',
//                class: 'btn btn-primary',
//                click: function () {
//                    console.log("@ here");
//                    var data_upload_excel_user = new FormData($('#form_upload_excel_user')[0]);
//                    console.log("data_upload_delegate" + data_upload_excel_user);
//                    $.ajax({
//                        type: "POST",
//                        url: "/FieldServiceSolution/uploadDataUsersServlet", //uploadDataUsersServlet
//                        data: data_upload_excel_user,
//                        cache: false,
//                        processData: false, // Do'nt process the files
//                        contentType: false, // Set content type to false as jQuery will tell the server its a query string request                       
//                        success: function (response) {
//                            if (response.RC === "1") {
//                                alert("Success");
//                            } else if (response.RC === "x0s") {
//
//                                alert("No File Found");
//                            } else {
//                                alert("Fail Upload");
//                            }
//                        }, error: function (jqXHR, textStatus, errorThrown) {
//                            alert("Something really bad happened " + textStatus);
//                        }
//                    });
//                }
//            }, {
//                text: 'Clear',
//                class: 'btn btn-primary',
//                click: function () {
//
//                    document.getElementById("form_upload_excel_user").reset();
//                    $('#excel_upload_users').css('background', '');
////                    $('#pic_delegate').css('background', '');
//
////                    return;
//                }
//            }]
//    });
}


