
/* global CryptoJS, Storage */
$(function () {
    $('a, button').click(function () {
        $(this).toggleClass('active');
    });
});
//function start() {
//    showDataDashboard();
//    myDahsboardReport();
//}
//window.onload = start;
//

function createDynamicURL()
{
//The variable to be returned
    var URL = "/inventoryaset/";
    //The variables containing the respective IDs
//    var companyID=...
//    var branchID=...
//    var employeeID=...
//
//    //Forming the variable to return    
//    URL+="company=";
//    URL+=companyID;
//    URL+="/branch=";
//    URL+=branchID;
//    URL+="/employee=";
//    URL+=employeeID;
//    URL+="/info";
//    URL = "/InventoryAsetProject/";
    return URL;
}
/*
 * 
 * * 
 * hide parameter function
 * https://jennamolby.com/how-to-display-dynamic-content-on-a-page-using-url-parameters/
 * https://gist.github.com/ScottKaye/5158488
 */
function getURLParameter(name) {
    return decodeURI((RegExp(name + '=' + '(.+?)(&|$)').exec(location.search) || [, null])[1]);
}

function hideURLParams() {
//Parameters to hide (ie ?success=value, ?error=value, etc)
    var hide = ['success', 'error'];
    for (var h in hide) {
        if (getURLParameter(h)) {
            history.replaceState(null, document.getElementsByTagName("title")[0].innerHTML, window.location.pathname);
        }
    }
}
window.onload = hideURLParams;
// end hide parameter function
//
//document.querySelectorAll('.\\3A \\`\\(');
//
//Get URL Parameters With JavaScript
//https://html-online.com/articles/get-url-parameters-javascript/
//function getUrlVars() {
//    var vars = {};
//    var parts = window.location.href.replace(/[?&]+([^=&]+)=([^&]*)/gi, function(m,key,value) {
//        vars[key] = value;
//    });
//    return vars;
//}
//end Get URL Parameters With JavaScript
//https://stackoverflow.com/questions/3757929/posting-data-into-javascript-from-an-url
//https://www.dte.web.id/2012/04/set-value-based-url-in-address-bar.html
function getUrlQueryString(param) {
    var outObj = {};
    var qs = window.location.search;
    if (qs !== "") {
        qs = decodeURIComponent(qs.replace(/\?/, ""));
        var paramsArray = qs.split("&");
        var length = paramsArray.length;
        for (var i = 0; i < length; ++i) {
            var nameValArray = paramsArray[i].split("=");
            nameValArray[0] = nameValArray[0].toLowerCase();
            if (outObj[nameValArray[0]]) {
                outObj[nameValArray[0]] = outObj[nameValArray[0]] + ";" + nameValArray[1];
            } else {
                if (nameValArray.length > 1) {
                    outObj[nameValArray[0]] = nameValArray[1];
                } else {
                    outObj[nameValArray[0]] = true;
                }
            }
        }
    }
    var retVal = param ? outObj[param.toLowerCase()] : qs;
    return retVal ? retVal : "";
}
//end Get URL Parameters With JavaScript
$(document).ready(function () {
    /* parse json fucntion()
     * http://stackoverflow.com/questions/1184624/convert-form-data-to-javascript-object-with-jquery
     * http://jsfiddle.net/sxGtM/3/
     */
    $.fn.serializeObject = function ()
    {
        var o = {};
        var a = this.serializeArray();
        $.each(a, function () {
            if (o[this.name] !== undefined) {
                if (!o[this.name].push) {
                    o[this.name] = [o[this.name]];
                }
                o[this.name].push(this.value || '');
            } else {
                o[this.name] = this.value || '';
            }
        });
        return o;
    };
    //
    $(function () {
        $(".datePick").datepicker({dateFormat: "dd/mm/yy", changeMonth: true, changeYear: true}); //, minDate: 0
    });
    $(function () {
        $(".datePick_report").datepicker({dateFormat: "dd/mm/yy", changeMonth: true, changeYear: true});
    });
    $(function () {
        $("#tgl_service_details_start").datepicker().datepicker("setDate", new Date());
    });
    // form_add_pic  
    $("#form_add_pic").submit(function () {

        var userName = $("#userName").val();
        var email = $("#email").val();
        if ($("#userName").val() === "") {
            $('#userName').css('background', '#e74c3c');
            return false;
        } else {
            $('#userName').css('background', '');
        }
        if ($("#email").val() === "") {

            $('#email').css('background', '#e74c3c');
            return false;
        } else {
            $('#email').css('background', '');
        }
        if ($("#roleName").val() === "") {

            $('#roleName').css('background', '#e74c3c');
            return false;
        } else {
            $('#roleName').css('background', '');
        }
        if ($("#address").val() === "") {
            $('#address').css('background', '#e74c3c');
            return false;
        } else {
            $('#address').css('background', '');
        }

        var b = 0;
        var chk = document.getElementsByName("gender");
        for (j = 0; j < chk.length; j++) {
            if (chk.item(j).checked === false) {
                b++;
            }
            if (chk.item(j).checked === true) {


            }
        }
        var pesan = $("#content_gender");
        if (b === chk.length) {
            pesan.text("choose").removeClass('success').addClass('error').css({
                'color': 'red',
                'background': 'url() 1px 0 no-repeat'
            });
//            alert("Field Koneksi tidak boleh kosong");A
            return false;
        } else {
            pesan.text("").removeClass('success').addClass('error').css({});
        }

        if (confirm("Technician\n\n"
                + "Name    :" + userName + "\n\n"
                + "Email    :" + email + "\n\n"
                ) === true) {
            $('#userName').css('background', '');
            $('#userPass').css('background', '');
            $('#address').css('background', '');
            $('#email').css('background', '');
            $('#gender').css('background', '');
        } else {
            console.log("cancel");
            $('#userName').css('background', '');
            $('#userPass').css('background', '');
            $('#address').css('background', '');
            $('#email').css('background', '');
            $('#gender').css('background', '');
            return false;
        }

//        var data_add_pic = {
//            userName: $("#userName").val(),
//            address: $("#address").val(),
//            email: $("#email").val(),
//            gender: $("#gender").val(),
//            action: $("#action").val(),
//            roleName: $("#roleName").val(),
//            nomorIMEI: $("#nomorIMEI").val(),
//            action_insert: $("#action_insert").val(),
//            action_edit: $("#action_edit").val(),
//            action_delete: $("#action_delete").val()
//        };

//        console.log("isi data_add_pic" + data_add_pic);
        $.ajax({
            type: "POST",
            url: createDynamicURL() + "/userServlet",
//            data: {JSONFile: data_add_pic}, // look here!
            data: {JSONFile: "[" + JSON.stringify($('#form_add_pic').serializeObject()) + "]"}, // look here!
            success: function (response) {
                //our country code was correct so we have some information to display
                if (response.RC === "1") {
                    $("#form_add_user_response").html("<div><p><b>" + "User " + userName + response.msg + "</b></p></div>");
                    $('#btn_add_pic').prop('disabled', true);
                } else if (response.RC === "2") {
                    $("#form_add_user_response").html("<div><p><b>" + "User " + userName + " Already Registered" + "</b></p></div>").addClass('error').css({});
                } else if (response.RC === "3") {
                    $("#form_add_user_response").html("<div><p><b>" + "User " + userName + response.msg + "</b></p></div>").addClass('error').css({});
                    $('#btn_add_pic').prop('disabled', true);
                }
                //display error message
                else {
                    $("#form_add_user_response").html("<div><p><b>Invalid!</b></p></div>").addClass('error').css({});
                }
            },
            //If there was no resonse from the server
            error: function (jqXHR, textStatus, errorThrown) {
                console.log("Something really bad happened " + textStatus);
                $("#form_add_user_response").html(jqXHR.responseText);
            }

        });
        return false;
//        $('#form_add_pic')[0].reset();
//        return;
    });
    // form_add_supplier  
    $('#checkbox_value').text($('#tax').val());
    $("#tax").on('change', function () {
        if ($(this).is(':checked')) {
            $(this).attr('value', 'on');
        } else {
            $(this).attr('value', 'off');
        }

        $('#checkbox_value').text($('#tax').val());
    });
//    if ($("#tax").attr('checked', 'checked')) {
//        $('#checkbox_value').text('true');
//    }
    $("#form_add_supplier").submit(function () {

        var supplier_name = $("#supplier_name").val();
        var address_supplier = $("#address_supplier").val();
        var contact_suplier_name = $("#contact_suplier_name").val();
        var cotact_suplier_num = $("#cotact_suplier_num").val();
        var supplier_code = $("#supplier_code").val();
        var checkbox_value = $('#tax').val();
        var txt_val = "";

        if ($("#supplier_name").val() === "") {

            $('#supplier_name').css('background', '#e74c3c');
            return false;
        } else {
            $('#supplier_name').css('background', '');
        }
        if ($("#address_supplier").val() === "") {

            $('#address_supplier').css('background', '#e74c3c');
            return false;
        } else {
            $('#address_supplier').css('background', '');
        }
        if ($("#contact_suplier_name").val() === "") {

            $('#contact_suplier_name').css('background', '#e74c3c');
            return false;
        } else {
            $('#contact_suplier_name').css('background', '');
        }
        if ($("#cotact_suplier_num").val() === "") {

            $('#cotact_suplier_num').css('background', '#e74c3c');
            return false;
        } else {
            $('#cotact_suplier_num').css('background', '');
        }
        if (checkbox_value === "on" || checkbox_value === "true") {
            txt_val = "active";
        } else {
            txt_val = "dis active";
        }
//        var checkedValue = $('.messageCheckbox:checked').val();
//        $('#checkbox-value').text($('#tax').val());
//        $("#tax").on('change', function () {
//            if ($(this).is(':checked')) {
//                $(this).attr('value', 'true');
//            } else {
//                $(this).attr('value', 'false');
//            }
//
//            $('#checkbox-value').text($('#checkbox1').val());
//        });
        if (confirm("Supllier Data \n\n"
                + "Name    :" + supplier_name + "\n\n"
                + "Address    :" + address_supplier + "\n\n"
                + "Contact Person    :" + contact_suplier_name + "\n\n"
                + "Contact Number    :" + cotact_suplier_num + "\n\n"
                + "Tax    :" + txt_val + "\n\n"
                ) === true) {
            $('#supplier_name').css('background', '');
            $('#address_supplier').css('background', '');
            $('#contact_suplier_name').css('background', '');
            $('#cotact_suplier_num').css('background', '');
        } else {
            console.log("cancel");
            $('#supplier_name').css('background', '');
            $('#address_supplier').css('background', '');
            $('#contact_suplier_name').css('background', '');
            $('#cotact_suplier_num').css('background', '');
            return false;
        }


//        var data_add_supplier = {
//            supplier_name: $("#supplier_name").val(),
//            address_supplier: $("#address_supplier").val(),
//            contact_suplier_name: $("#contact_suplier_name").val(),
//            cotact_suplier_num: $("#cotact_suplier_num").val(),
//            action_insert_supp: $("#action_insert_supp").val(),
//            action_edit_supp: $("#action_edit_supp").val(),
//            action_delete: $("#action_delete").val()
//        };
//        console.log("isi data_add_supplier" + data_add_supplier);
        $.ajax({
            type: "POST",
            url: createDynamicURL() + "/supplierServlet",
//            data: {JSONFile: data_add_supplier}, // look here!
            data: {JSONFile: "[" + JSON.stringify($('#form_add_supplier').serializeObject()) + "]"}, // look here!
            success: function (response) {
                //our country code was correct so we have some information to display
                if (response.RC === "1") {

                    $("#form_add_supplier_response").html("<div class='alert alert-success' role='alert'><button type='button' class='close' data-dismiss='alert'>&times;</button><p><b>" + "Supplier  " + supplier_name + response.msg + "</b></p></div>");
//                    $('#btn_add_supplier').prop('disabled', true);
                } else if (response.RC === "2") {
                    $("#form_add_supplier_response").html("<div class='alert alert-warning' role='alert'><button type='button' class='close' data-dismiss='alert'>&times;</button><p><b>" + "Supplier " + supplier_name + " Already Registered" + "</b></p></div>").addClass('error').css({});
                } else if (response.RC === "3") {
                    $("#form_add_supplier_response").html("<div class='alert alert-success' role='alert'><button type='button' class='close' data-dismiss='alert'>&times;</button><p><b>" + "Supplier " + supplier_name + response.msg + "</b></p></div>").addClass('error').css({});
                    $('#btn_add_supplier').prop('disabled', true);
                } else if (response.RC === "33") {
                    $("#form_add_supplier_response").html("<div class='alert alert-warning' role='alert'><button type='button' class='close' data-dismiss='alert'>&times;</button><p><b>" + "Supplier code" + supplier_code + response.msg + "</b></p></div>").addClass('error').css({});
                }
                //display error message
                else {
                    $("#form_add_supplier_response").html("<div class='alert alert-danger' role='alert'><button type='button' class='close' data-dismiss='alert'>&times;</button><p><b>Invalid!</b></p></div>").addClass('error').css({});
                }
            },
            //If there was no resonse from the server
            error: function (jqXHR, textStatus, errorThrown) {
                console.log("Something really bad happened " + textStatus);
                $("#form_add_supplier_response").html(jqXHR.responseText);
            }

        });
        return false;
//        $('#form_add_supplier')[0].reset();
//        return;
    });
//    
//     // form_add_categories  
    $("#form_add_categories").submit(function () {
        var category_name = $("#category_name").val();
        var category_desc = $("#category_desc").val();
        if ($("#category_name").val() === "") {

            $('#category_name').css('background', '#e74c3c');
            return false;
        } else {
            $('#category_name').css('background', '');
        }

        if ($("#category_desc").val() === "") {

            $('#category_desc').css('background', '#e74c3c');
            return false;
        } else {
            $('#category_desc').css('background', '');
        }

        if (confirm("Data Category \n\n"
                + "Category    :" + category_name + "\n\n"
                + "description   :" + category_desc + "\n\n"
                ) === true) {
            $('#category_name').css('background', '');
            $('#category_desc').css('background', '');
        } else {
            console.log("cancel");
            $('#category_name').css('background', '');
            $('#category_desc').css('background', '');
            return false;
        }


        $.ajax({
            type: "POST",
            url: createDynamicURL() + "/categoryServlet",
//            data: {JSONFile: data_add_supplier}, // look here!
            data: {JSONFile: "[" + JSON.stringify($('#form_add_categories').serializeObject()) + "]"}, // look here!
            success: function (response) {
                //our country code was correct so we have some information to display
                if (response.RC === "1") {
                    $("#form_add_categories_response").html("<div class='alert alert-success' role='alert'><button type='button' class='close' data-dismiss='alert'>&times;</button><p><b>" + "Category  " + category_name + " Has been Recorded" + "</b></p></div>");
                } else if (response.RC === "2") {
                    $("#form_add_categories_response").html("<div class='alert alert-warning' role='alert'><button type='button' class='close' data-dismiss='alert'>&times;</button><p><b>" + "Category " + category_name + " Already Registered" + "</b></p></div>").addClass('error').css({});
                } else {

                    $("#form_add_categories_response").html("<div class='alert alert-danger' role='alert'><button type='button' class='close' data-dismiss='alert'>&times;</button><p><b>Invalid!</b></p></div>").addClass('error').css({});
                }
            },
            //If there was no resonse from the server
            error: function (jqXHR, textStatus, errorThrown) {
                console.log("Something really bad happened " + textStatus);
                $("#form_add_categories_response").html(jqXHR.responseText);
            }

        });
        return false;
    });
    // form_add_item  
    $("#form_add_item").submit(function () {

        var item_name = $("#item_name").val();
        var categori_name = $("#categories_name").val();
        var description = $("#description").val();
        var product_code = $("#product_code").val();
        if ($("#item_name").val() === "") {

            $('#item_name').css('background', '#e74c3c');
            return false;
        } else {
            $('#item_name').css('background', '');
        }

        if ($("#categori_name").val() === "") {

            $('#categori_name').css('background', '#e74c3c');
            return false;
        } else {
            $('#categori_name').css('background', '');
        }

//        if ($("#description").val() === "") {
//
//            $('#description').css('background', '#e74c3c');
//            return false;
//        } else {
//            $('#description').css('background', '');
//        }

        if (confirm("Data Item \n\n"
                + "Name    :" + item_name + "\n\n"
                + "Category    :" + categori_name + "\n\n"
                + "Description    :" + description + "\n\n"
                ) === true) {
            $('#item_name').css('background', '');
            $('#categori_name').css('background', '');
            $('#description').css('background', '');
        } else {
            console.log("cancel");
            $('#item_name').css('background', '');
            $('#categori_name').css('background', '');
            $('#description').css('background', '');
            return false;
        }

        var data_add_item = {
            item_name: $("#item_name").val(),
            categori_name: $("#categori_name").val(),
            supplier_name: $("#supplier_name").val(),
            description: $("#description").val()
        };
        console.log("isi data_add_item" + data_add_item);

        $.ajax({
            type: "POST",
            url: createDynamicURL() + "/itemServlet",
//            data: {JSONFile: data_add_item}, // look here!
            data: {JSONFile: "[" + JSON.stringify($('#form_add_item').serializeObject()) + "]"}, // look here!
            success: function (response) {
                //our country code was correct so we have some information to display
                if (response.RC === "1") {
                    $("#ajaxResponse_form_add_item").html("<div class='alert alert-success' role='alert'><button type='button' class='close' data-dismiss='alert'>&times;</button><p><b>" + "Item  " + item_name + response.msg + "</b></p></div>");
                } else if (response.RC === "2") {
                    $("#ajaxResponse_form_add_item").html("<div class='alert alert-warning' role='alert'><button type='button' class='close' data-dismiss='alert'>&times;</button><p><b>" + "Item " + item_name + " Already Registered" + "</b></p></div>").addClass('error').css({});
                } else if (response.RC === "3") {
                    $("#ajaxResponse_form_add_item").html("<div class='alert alert-success' role='alert'><button type='button' class='close' data-dismiss='alert'>&times;</button><p><b>" + "Item " + item_name + response.msg + "</b></p></div>").addClass('error').css({});
                } else if (response.RC === "4") {
                    $("#ajaxResponse_form_add_item").html("<div class='alert alert-danger' role='alert'><button type='button' class='close' data-dismiss='alert'>&times;</button><p><b>" + product_code + response.msg + "</b></p></div>").addClass('error').css({});
                } else if (response.RC === "44") {
                    $("#ajaxResponse_form_add_item").html("<div class='alert alert-warning' role='alert'><button type='button' class='close' data-dismiss='alert'>&times;</button><p><b>" + "Item " + item_name + " Supplier Not found" + "</b></p></div>").addClass('error').css({});
                }
                //display error message
                else {
                    $("#ajaxResponse_form_add_item").html("<div class='alert alert-danger' role='alert'><button type='button' class='close' data-dismiss='alert'>&times;</button><p><b>Invalid!</b></p></div>").addClass('error').css({});
                }
            },
            //If there was no resonse from the server
            error: function (jqXHR, textStatus, errorThrown) {
                console.log("Something really bad happened " + textStatus);
                $("#ajaxResponse_form_add_item").html(jqXHR.responseText);
            }

        });
        return false;
//        $('#form_add_item')[0].reset();
//        return;
    });

    $("#form_add_po").submit(function () {
        var supplier_name = $("#supplier_name_po").val();
        var date = $("#tgl_input_po").val();
        var supplier_code = $("#supplier_code_po").val();
        if ($("#supplier_name_po").val() === "") {

            $('#supplier_name_po').css('background', '#e74c3c');
            return false;
        } else {
            $('#supplier_name_po').css('background', '');
        }

//        if ($("#tgl_input_po").val() === "") {
//
//            $('#tgl_input_po').css('background', '#e74c3c');
//            return false;
//        } else {
//            $('#tgl_input_po').css('background', '');
//        }


        if (confirm("Data Item \n\n"
                + "Supplier       :" + supplier_name + "\n\n"
                + "Supplier Code  :" + supplier_code + "\n\n"
                + "date           :" + date + "\n\n"

                ) === true) {
            $('#supplier_name_po').css('background', '');
            $('#tgl_input_po').css('background', '');
            $('#supplier_code_po').css('background', '');
            $('#po_type').css('background', '');
            $('#delivery_term').css('background', '');
            $('#transport_mode').css('background', '');
            $('#quotation_number').css('background', '');
            $('#rfq_number').css('background', '');
            $('#purchase_desc').css('background', '');
        } else {
            console.log("cancel");
            $('#supplier_name_po').css('background', '');
            $('#tgl_input_po').css('background', '');
            $('#supplier_code_po').css('background', '');
            $('#po_type').css('background', '');
            $('#delivery_term').css('background', '');
            $('#transport_mode').css('background', '');
            $('#quotation_number').css('background', '');
            $('#rfq_number').css('background', '');
            $('#purchase_desc').css('background', '');
            return false;
        }

        $.ajax({
            type: "POST",
            url: createDynamicURL() + "/createPOServlet",
//            data: {JSONFile: data_add_item}, // look here!
            data: {JSONFile: "[" + JSON.stringify($('#form_add_po').serializeObject()) + "]"}, // look here!
            success: function (response) {
                //our country code was correct so we have some information to display
                if (response.RC === "1") {

                    $("#ajaxResponse_form_add_po").html("<div class='alert alert-success' role='alert'><button type='button' class='close' data-dismiss='alert'>&times;</button><p><b>" + "Purchase Order   " + response.msg + "</b></p></div>");
                } else if (response.RC === "2") {
                    $("#ajaxResponse_form_add_po").html("<div class='alert alert-warning' role='alert'><button type='button' class='close' data-dismiss='alert'>&times;</button><p><b>" + "Purchase Order " + response.msg + "</b></p></div>");
                } else if (response.RC === "3") {
                    $("#ajaxResponse_form_add_po").html("<div class='alert alert-warning' role='alert'><button type='button' class='close' data-dismiss='alert'>&times;</button><p><b>" + "Purchase Order " + "" + response.msg + "</b></p></div>").addClass('error').css({});
                } else if (response.RC === "4") {
                    $("#ajaxResponse_form_add_po").html("<div class='alert alert-danger' role='alert'><button type='button' class='close' data-dismiss='alert'>&times;</button><p><b>" + "Purchase Order " + "" + response.msg + "</b></p></div>").addClass('error').css({});
                }
                //display error message
                else {
                    $("#ajaxResponse_form_add_po").html("<div class='alert alert-danger' role='alert'><button type='button' class='close' data-dismiss='alert'>&times;</button><p><b>Invalid!</b></p></div>");
                }
            },
            //If there was no resonse from the server
            error: function (jqXHR, textStatus, errorThrown) {
                console.log("Something really bad happened " + textStatus);
                $("#ajaxResponse_form_add_po").html(jqXHR.responseText);
            }

        });
        return false;
    });
//    
    $("#form_upload").submit(function () {


        if ($("#excel").val() === "") {

            $('#excel').css('background', '#e74c3c');
            return false;
        } else {
            $('#excel').css('background', '');
        }

    });
//form_upload_version
//    $("#form_upload_version").submit(function () {
//
//        if ($("#version_apk").val() === "") {
//
//            $('#version_apk').css('background', '#e74c3c');
//            return false;
//        } else {
//            $('#version_apk').css('background', '');
//        }
//
//        if ($("#deskripsi_apk").val() === "") {
//
//            $('#deskripsi_apk').css('background', '#e74c3c');
//            return false;
//        } else {
//            $('#deskripsi_apk').css('background', '');
//        }
//        if ($("#fileApk").val() === "") {
//            $('#fileApk').css('background', '#e74c3c');
//            return false;
//        } else {
//            $('#fileApk').css('background', '');
//        }
//    });

//form_email_config
    $("#form_email_config").submit(function () {
        if ($("#smtpHost").val() === "") {

            $('#smtpHost').css('background', '#e74c3c');
            return false;
        } else {
            $('#smtpHost').css('background', '');
        }
        if ($("#smtpSocketFactoryPort").val() === "") {

            $('#smtpSocketFactoryPort').css('background', '#e74c3c');
            return false;
        } else {
            $('#smtpSocketFactoryPort').css('background', '');
        }
        if ($("#smtpSocketFactoryClass").val() === "") {

            $('#smtpSocketFactoryClass').css('background', '#e74c3c');
            return false;
        } else {
            $('#smtpSocketFactoryClass').css('background', '');
        }
        if ($("#smtpPort").val() === "") {

            $('#smtpPort').css('background', '#e74c3c');
            return false;
        } else {
            $('#smtpPort').css('background', '');
        }
        if ($("#email_form_config").val() === "") {

            $('#email_form_config').css('background', '#e74c3c');
            return false;
        } else {
            $('#email_form_config').css('background', '');
        }

        $.ajax({
            type: "POST",
            url: createDynamicURL() + "/protocolServlet",
            dataType: "json",
            data: {JSONFile: "[" + JSON.stringify($('#form_email_config').serializeObject()) + "]"}, // look here!
//           data: {rows:rowValues, columns:columnValues},
            success: function (response) {
                //our country code was correct so we have some information to display
                if (response.RC === "1") {

                    $("#ajaxResponse_form_email_config").html("<div class='alert alert-success' role='alert'><button type='button' class='close' data-dismiss='alert'>&times;</button><p><b>" + "SUCCES" + "</b></p></div>");
                    $('#btn_ubmit_form_email_config').prop('disabled', true);
                }
                //display error message
                else {
                    $("#ajaxResponse_form_email_config").html("<div class='alert alert-success' role='alert'><button type='button' class='close' data-dismiss='alert'>&times;</button><p><b>Invalid!</b></p></div>").addClass('error').css({});
                }
            },
            //If there was no resonse from the server
            error: function (jqXHR, textStatus, errorThrown) {
                console.log("Something really bad happened " + textStatus);
                $("#form_email_config").html(jqXHR.responseText);
            }
//
//
        });
        return false;
    });
//form_submit_company
    $("#form_submit_company").submit(function () {

        if ($("#companyName").val() === "") {

            $('#companyName').css('background', '#e74c3c');
            return false;
        } else {
            $('#companyName').css('background', '');
        }
        if ($("#address").val() === "") {

            $('#address').css('background', '#e74c3c');
            return false;
        } else {
            $('#address').css('background', '');
        }
        $('#action_form_company').val('INPUT');
        $.ajax({
            type: "POST",
            url: createDynamicURL() + "/companyDataServlet",
            dataType: "json",
            data: {JSONFile: "[" + JSON.stringify($('#form_submit_company').serializeObject()) + "]"}, // look here!
//           data: {rows:rowValues, columns:columnValues},
            success: function (response) {
                //our country code was correct so we have some information to display
                if (response.RC === "1pers") {

                    $("#ajaxResponse_form_submit_company").html("<div class='alert alert-success' role='alert'><button type='button' class='close' data-dismiss='alert'>&times;</button><p><b>" + "SUCCES" + "</b></p></div>");
                    $('#btn_submit_form_company').prop('disabled', true);
                } else if (response.RC === "1persD") {
                    $("#ajaxResponse_form_submit_company").html("<div class='alert alert-warning' role='alert'><button type='button' class='close' data-dismiss='alert'>&times;</button><p><b>" + "Data Duplicate" + "</b></p></div>");
                    $('#btn_submit_form_company').prop('disabled', true);
                }
                //display error message
                else {
                    $("#ajaxResponse_form_submit_company").html("<div class='alert alert-danger' role='alert'><button type='button' class='close' data-dismiss='alert'>&times;</button><p><b>Invalid!</b></p></div>");
                }
            },
            //If there was no resonse from the server
            error: function (jqXHR, textStatus, errorThrown) {
                console.log("Something really bad happened " + textStatus);
                $("#ajaxResponse_form_submit_company").html(jqXHR.responseText);
            }


        });
        return false;
    });
    $("#form_add_param").submit(function () {

        $.ajax({
            type: "POST",
            url: createDynamicURL() + "/parameterServlet",
            dataType: "json",
            data: {JSONFile: "[" + JSON.stringify($('#form_add_param').serializeObject()) + "]"}, // look here!
//           data: {rows:rowValues, columns:columnValues},
            success: function (response) {
                //our country code was correct so we have some information to display
                if (response.RC === "1") {

                    $("#form_add_param_response").html("<div class='alert alert-success' role='alert'><button type='button' class='close' data-dismiss='alert'>&times;</button><p><b>" + "SUCCES" + "</b></p></div>");
                    $('#btn_daftar_param').prop('disabled', true);
                } else if (response.RC === "2") {
                    $("#form_add_param_response").html("<div class='alert alert-warning' role='alert'><button type='button' class='close' data-dismiss='alert'>&times;</button><p><b>" + "Data Duplicate" + "</b></p></div>");
//                    $('#btn_submit_form_company').prop('disabled', true);
                }
                //display error message
                else {
                    $("#form_add_param_response").html("<div class='alert alert-danger' role='alert'><button type='button' class='close' data-dismiss='alert'>&times;</button><p><b>Invalid!</b></p></div>");
                }
            },
            //If there was no resonse from the server
            error: function (jqXHR, textStatus, errorThrown) {
                console.log("Something really bad happened " + textStatus);
                $("#form_add_param_response").html(jqXHR.responseText);
            }


        });
        return false;
    });
    $("#form_create_po").submit(function () {

        $.ajax({
            type: "POST",
            url: createDynamicURL() + "/ceatePOItemServlet",
//            data: {JSONFile: data_add_item}, // look here!
            data: {JSONFile: "[" + JSON.stringify($('#form_create_po').serializeObject()) + "]"}, // look here!
            success: function (response) {
                //our country code was correct so we have some information to display
                if (response.RC === "1") {

                    $("#ajaxResponse_form_create_po").html("<div class='alert alert-success' role='alert'><button type='button' class='close' data-dismiss='alert'>&times;</button><p><b>" + "Purchase Order   " + "" + response.msg + "</b></p></div>");
                    document.getElementById("btn_form_create_po").disabled = true;
                } else if (response.RC === "2") {
                    $("#ajaxResponse_form_create_po").html("<div class='alert alert-warning' role='alert'><button type='button' class='close' data-dismiss='alert'>&times;</button><p><b>" + "Purchase Order " + "" + response.msg + "</b></p></div>");
                } else if (response.RC === "xx0") {
                    $("#ajaxResponse_form_create_po").html("<div class='alert alert-warning' role='alert'><button type='button' class='close' data-dismiss='alert'>&times;</button><p><b>" + "Purchase Order " + "" + response.msg + "</b></p></div>");
                } else if (response.RC === "3") {
                    $("#ajaxResponse_form_create_po").html("<div class='alert alert-danger' role='alert'><button type='button' class='close' data-dismiss='alert'>&times;</button><p><b>" + "Purchase Order " + "" + response.msg + "</b></p></div>");
                    document.getElementById("btn_form_create_po").disabled = true;
                }

                //display error message
                else {
                    $("#ajaxResponse_form_add_po").html("<div><p><b>Invalid!</b></p></div>").addClass('error').css({});
                }
            },
            //If there was no resonse from the server
            error: function (jqXHR, textStatus, errorThrown) {
                console.log("Something really bad happened " + textStatus);
                $("#ajaxResponse_form_add_po").html(jqXHR.responseText);
            }

        });
        return false;
    });
//form_report_excel_field_service_details
//    $("#form_report_excel_field_service_details").submit(function () {
//})
//source https://stackoverflow.com/questions/35203019/how-can-i-send-an-ajax-request-on-button-click-from-a-form-with-2-buttons
//    $("#btn_barchart").click(function (e) {
//        e.preventDefault();
////        alert("form_bar_chart");
//        var dataString = $("#form_bar_chart").serialize();
//        $.ajax({
//            type: "GET",
//            url: createDynamicURL() + "/dataBarChartServlet",
//            data: dataString,
//            success: function (result) {
////                alert('ok');
////                document.getElementById("form_bar_chart").reset();
//            },
//            error: function (result) {
//                alert('error');
//            }
//        });
//        return false;
//    });
//    $("#btn_piechart").click(function (e) {
////        alert("form_pie_chart");
//        e.preventDefault();
//        var dataString = $("#form_pie_chart").serialize();
//        $.ajax({
//            type: "GET",
//            url: createDynamicURL() + "/dataPieChartServlet",
//            data: dataString,
//            success: function (result) {
////                alert('ok');
////                document.getElementById("form_pie_chart").reset();
//            },
//            error: function (result) {
//                alert('error');
//            }
//        });
//        return false;
//    });
//autocomplete
//    console.log($("#roleName").val());
    $("#roleName").autocomplete({
        minLength: 1,
        cacheLength: 1,
        autoFocus: true,
        scroll: true,
        source: createDynamicURL() + "/autoCompleteRolenameServlet"
    }).autocomplete("option", "appendTo", "#form_add_pic");
//
//    $("#supplier_code").autocomplete({
//        minLength: 2,
//        autoFocus: true,
//        source: createDynamicURL() + "/autoCompleteSupplierCode"
//    }).autocomplete("option", "appendTo", "#form_add_item");
//    //
//    $("#supplier_name").autocomplete({
//        minLength: 2,
//        autoFocus: true,
//        source: createDynamicURL() + "/autoCompleteSupplierName"
//    }).autocomplete("option", "appendTo", "#form_add_item");
//    
////    
    $("#supplier_name").autocomplete({
        minLength: 1,
        cacheLength: 1,
        autoFocus: true,
        scroll: true,
        source: createDynamicURL() + "/autoCompleteSupplierName"
    }).autocomplete("option", "appendTo", "#form_add_supplier");
    $("#supplier_name_po").autocomplete({
        minLength: 1,
        cacheLength: 1,
        autoFocus: true,
        scroll: true,
        source: createDynamicURL() + "/autoCompleteSupplierName"
    }).autocomplete("option", "appendTo", "#form_add_po");
    $("#supplier_code_po").autocomplete({
        minLength: 1,
        cacheLength: 1,
        autoFocus: true,
        scroll: true,
        source: createDynamicURL() + "/autoCompleteSupplierCode"
    }).autocomplete("option", "appendTo", "#form_add_po");
    $("#po_type").autocomplete({
        minLength: 1,
        cacheLength: 1,
        autoFocus: true,
        scroll: true,
        source: createDynamicURL() + "/autoCompleteTypePO"
    }).autocomplete("option", "appendTo", "#form_add_po");
//    

    $("#product_name").autocomplete({
        minLength: 1,
        cacheLength: 1,
        autoFocus: true,
        scroll: true,
        source: createDynamicURL() + "/autoCompleteProductName"
    }).autocomplete("option", "appendTo", "#form_edit_delegate_details");
    $("#categories_name").autocomplete({
        minLength: 1,
        cacheLength: 1,
        autoFocus: true,
        scroll: true,
        source: createDynamicURL() + "/autoCompleteCategoryName"
    }).autocomplete("option", "appendTo", "#form_add_item");
    $("#supplier_name").autocomplete({
        minLength: 1,
        cacheLength: 1,
        autoFocus: true,
        scroll: true,
        source: createDynamicURL() + "/autoCompleteSupplierName"
    }).autocomplete("option", "appendTo", "#form_add_item");
//            
    $('body').on('click', '#item_name_po', function () {
        $(this).autocomplete({
            source: function (request, response) {
                $.ajax({
                    url: createDynamicURL() + "/getItemPOServlet",
                    dataType: "json",
                    method: "GET",
                    data: {
                        term: request.term,
                        idSupplier: $("#supplier_id_form_create_po").val()
                    }, success: function (data) {
                        response($.map(data, function (item) {
                            var code = item.split("|");
                            return {
                                label: code[0],
                                value: code[0],
                                data: item
                            };
                        }));
                    }
                });
            },
//            autoFocus: true,
            minLength: 1,
            scroll: true,
            select: function (event, ui) {
//                var output = ui.item.data.split("|");
//                $('#item_name_po').val(output[1]);
            },
            delay: 300
        }).autocomplete("option", "appendTo", "#form_create_po");
    });



});
/* end $(document).ready(function ()}); */

function myFunction_reset_excel_service_details() {
    document.getElementById("form_report_excel_field_service_details").reset();
    $('#tgl_excel_service_details_start').css('background', '');
    $('#tgl_excel_service_details_end').css('background', '');
//    $('#nama_teknisi_field_service').css('background', '');
    return false;
}
function myFunction_reset_form_company() {
    document.getElementById("form_submit_company").reset();
    $('#companyName').css('background', '');
    $('#address').css('background', '');
    $('#title_company').css('background', '');
    return false;
}


function myFunction_reset_form_upload() {
    document.getElementById("form_upload").reset();
    $('#excel').css('background', '');
    return false;
}

function myFunction_reset_formVersion() {
    document.getElementById("form_upload_version").reset();
    $('#fileApk').css('background', '');
    return false;
}
function myFunction_reset_formUser() {
    document.getElementById("form_add_pic").reset();
    $('#userName').css('background', '');
    $('#userPass').css('background', '');
    $('#address').css('background', '');
    $('#email').css('background', '');
    $("#content_pass").text("").removeClass('error');
    $("#content_userName").text("").removeClass('error');
    $("#content_email").text("").removeClass('error');
    $('#btn_add_pic').prop('disabled', false);
    return false;
}
function myFunction_reset_formSupplier() {
    document.getElementById("form_add_supplier").reset();
    $('#supplier_name').css('background', '');
    $('#address_supplier').css('background', '');
    $('#conttact_suplier_name').css('background', '');
    $('#conttact_suplier_num').css('background', '');
    $('#btn_add_supplier').prop('disabled', false);
    return false;
}
function myFunction_reset_formCategory() {
    document.getElementById("form_add_categories").reset();
    $('#category_name').css('background', '');
    $('#category_desc').css('background', '');
    return false;
}
function myFunction_form_add_param() {
    document.getElementById("form_add_param").reset();
}
function myFunction_reset_form_add_item() {
    document.getElementById("form_add_item").reset();
}
function  myFunction_reset_form_create_po() {
    document.getElementById("form_create_po").reset();
//    $('#btn_form_create_po').prop('disabled', false);
    document.getElementById("btn_form_create_po").disabled = false;
}
//function myFunction_reset_form_email_config() {
//    document.getElementById("form_email_config").reset();
//    $('#smtpHost').css('background', '');
//    $('#smtpSocketFactoryPort').css('background', '');
//    $('#smtpSocketFactoryClass').css('background', '');
//    $('#smtpPort').css('background', '');
//    $("#content_smtpHost").text("").removeClass('error');
//    $("#content_email_config").text("").removeClass('error');
//    $("#content_pass_email_config").text("").removeClass('error');
//    return false;
//
//}
function cekEmail() {
    var pesan_email = $("#form_add_user_response");
//    var pesan_email_2 = $("#content_email_config");d
//    var email_form_config = $("#email_form_config").val();
    var email = $("#email").val();
    var regex = /^([0-9a-zA-Z]([-_\\.]*[0-9a-zA-Z]+)*)@([0-9a-zA-Z]([-_\\.]*[0-9a-zA-Z]+)*)[\\.]([a-zA-Z]{2,9})$/;
    //    if (email !== "") {
    if (!regex.test(email)) {
        pesan_email.text("Invalid Email...!!!!!!").removeClass('success').addClass('error').css({
            'color': 'red',
            'background': 'url() 1px 0 no-repeat'
        });
        $("#email").focus();
        return false;
    } else {
        pesan_email.text("").removeClass('error');
        $("#email").focus();
        return false;
    }

}


function cekUserName() {
    var pesan_userName = $("#form_add_user_response");
    var userName = $("#userName").val();
    var minchar = 5;
    if (userName.length < minchar) {

        pesan_userName.text("Minimum Name's Length 5 Characters").removeClass('success').addClass('error').css({
            'color': 'red'
        });
        $("#userName").focus();
        return false;
    } else {

        $("#content_userName").text("").removeClass('error');
        $("#userName").focus();
        return false;
    }
    return cekUserName();
}

function cekPass() {
    var pesan_userName = $("#form_add_user_response");
    var userPass = $("#userPass").val();
    var minchar = 5;
    if (userPass !== "") {
        if (userPass.length < minchar) {

            $("#form_add_user_response").text("Minimum Password's Length 5 Characters").removeClass('success').addClass('error').css({
                'color': 'red'
                        //                           
            });
            $("#userPass").focus();
            return false;
        } else {

            $("#content_pass").text("").removeClass('error');
            $("#userPass").focus();
            return false;
        }
    }
    return cekPass();
}

//match password funct using native javascript
//function checkPass() {
//	  if (document.getElementById('password_view').value == document.getElementById('password_view2').value) {
//	    document.getElementById('e_password').style.color = 'green';
//	    document.getElementById('e_password').innerHTML = 'matching';
//	  } else {
//	    document.getElementById('e_password').style.color = 'red';
//	    document.getElementById('e_password').innerHTML = 'not matching';
//	  }
//	}

function cekPass_email_config() {
    var minchar = 5;
    var pass_email_config = $("#pass_email_config").val();
    if (pass_email_config !== "") {
        if (pass_email_config.length < minchar) {
            $("#content_pass_email_config").text("Minimum Password's Length 5 Characters").removeClass('success').addClass('error').css({
                'color': 'red'
                        //                           
            });
            $("#pass_email_config").focus();
            return false;
        } else {

            $("#content_pass_email_config").text("").removeClass('error');
            $("#pass_email_config").focus();
            return false;
        }
    }
    return cekPass_email_config();
}
function isNumber() {
    var x = $('#smtpPort').val();
    var regex = /^[0-9]+$/;
    if (x === "") {
        $('#smtpPort').css('background', '#e74c3c');
        return false;
    } else {
        $('#smtpPort').css('background', '');
        if (!x.match(regex))
        {
            $("#content_smtpPort").text("Must input numbers").removeClass('success').addClass('error').css({
                'color': 'red'
                        //                           
            });
            $("#smtpPort").focus();
            return false;
        } else {
            $("#content_smtpPort").text("").removeClass('error');
            $("#smtpPort").focus();
            return false;
        }
    }

}
function cekNumber() {
    var k = $('#delivery_term').val();
    var i = $('#price_item').val();
    var regex = /^[0-9]+$/;
    if (i === '0') {
        $("#content_form_error_item").text("Can't be 0").removeClass('success').addClass('error').css({
            'color': 'red'
                    //                           
        });
        $("#price_item").focus();
    } else {
        $("#content_form_error_item").text("").removeClass('error');
        $("#price_item").focus();
    }
    if (k === "0") {
        $("#content_form_error").text("Can't be 0").removeClass('success').addClass('error').css({
            'color': 'red'
                    //                           
        });
        $("#delivery_term").focus();
        document.getElementById("prevBtn").disabled = true;
        document.getElementById("nextBtn").disabled = true;
        return false;
    } else {
        document.getElementById("prevBtn").disabled = false;
        document.getElementById("nextBtn").disabled = false;
    }
    if (k === "") {
        $('#delivery_term').css('background', '#e74c3c');
        document.getElementById("prevBtn").disabled = true;
        document.getElementById("nextBtn").disabled = true;
        return false;
    } else {
        document.getElementById("prevBtn").disabled = false;
        document.getElementById("nextBtn").disabled = false;
    }
    if (!k.match(regex))
    {
        $("#content_form_error").text("Must input numbers").removeClass('success').addClass('error').css({
            'color': 'red'
                    //                           
        });
        $("#delivery_term").focus();
        document.getElementById("prevBtn").disabled = true;
        document.getElementById("nextBtn").disabled = true;
        return false;
    } else {
        $("#content_form_error").text("").removeClass('error');
        $("#delivery_term").focus();
        document.getElementById("prevBtn").disabled = false;
        document.getElementById("nextBtn").disabled = false;
        return false;
    }
    if (!i.match(regex))
    {
        $("#content_form_error_item").text("Must input numbers").removeClass('success').addClass('error').css({
            'color': 'red'
                    //                           
        });
        $("#price_item").focus();
        document.getElementById("btn_add_item").disabled = true;
        document.getElementById("btn_add_item").disabled = true;
        return false;
    } else {
        $("#content_form_error_item").text("").removeClass('error');
        $("#price_item").focus();
        document.getElementById("btn_add_item").disabled = false;
        document.getElementById("btn_add_item").disabled = false;
        return false;
    }
}
//
function  myFunction_reset_form_create_delegate() {
    var button = document.getElementById("btn_form_create_delegate");
    document.getElementById("form_create_delegate").reset();
    $('#nama_merchant').css('background', '');
    $('#kota_merchant').css('background', '');
    $('#alamat_merchant').css('background', '');
    $('#province_merchant').css('background', '');
//    $('#mid_merchant').css('background', '');
    //    $('#tid_merchant').css('background', '');
    $('input#mid_merchant').css('background', '');
    $('input#tid_merchant').css('background', '');
    //input[name^="price"]'
    //    $('#btn_form_create_delegate').removeAttr('disabled');
    $('#btn_form_create_delegate').prop('disabled', false);
    //    button.disabled = !button.disabled;
    $('#ajaxResponse_form_delegate').empty();
    return false;
}
function myFunctionExcelFieldService() {

    var tgl_excel_service_details_start = $('#tgl_excel_service_details_start').val();
    var tgl_excel_service_details_end = $('#tgl_excel_service_details_end').val();
    window.location = createDynamicURL() + "/excelFieldServiceDetailsServlet?tgl_excel_service_details_start=" + tgl_excel_service_details_start + "&tgl_excel_service_details_end=" + tgl_excel_service_details_end;
}
//    if (nama_teknisi_field_service !== "" && tgl_excel_service_details_start !== "" && tgl_excel_service_details_end !== "") {

//        url = createDynamicURL() + "/excelFieldServiceServlet?nama_teknisi_field_service=" + nama_teknisi_field_service + "&tgl_excel_service_details_start=" + tgl_excel_service_details_start + "&tgl_excel_service_details_end" + tgl_excel_service_details_end;
//        window.location = url;
//        return false;
//        $.ajax({
//            type: "GET",
//            url: '/InventoryAsetProject/excelFieldServiceServlet',
//            data: ({nama_teknisi_field_service: nama_teknisi_field_service, tgl_excel_service_details_start: tgl_excel_service_details_start, tgl_excel_service_details_end: tgl_excel_service_details_end})
//            dataType: "text"
//            success: function (data) {
//                 Run the code here that needs
//    to access the data returned
//                return data;
//            },
//            error: function () {
//                alert('Error occured');
//            }
//        });
//    } else {
//        $.ajax({
//            type: "GET",
//            url: '/InventoryAsetProject/excelFieldServiceServlet',
//            data: ({nama_teknisi_field_service: nama_teknisi_field_service})
//            dataType: "text"
//            success: function (data) {
//                 Run the code here that needs
//    to access the data returned
//                return data;
//            },
//            error: function () {
//                alert('Error occured');
//            }
//        });
//    }
//    if (nama_teknisi_field_service === "" && tgl_excel_service_details_start !== "" && tgl_excel_service_details_end !== "") {

//        url = createDynamicURL() + "/excelFieldServiceDetailsServlet?tgl_excel_service_details_start=" + tgl_excel_service_details_start + "&tgl_excel_service_details_end" + tgl_excel_service_details_end;
//                window.location = url;
//        return false;
//        $.ajax({
//            type: "GET",
//            url: '/InventoryAsetProject/excelFieldServiceDetailsServlet',
//            data: ({tgl_excel_service_details_start: tgl_excel_service_details_start, tgl_excel_service_details_end: tgl_excel_service_details_end})
//            dataType: "text"
//            success: function (data) {
// Run the code here that needs
//    to access the data returned
//                return data;
//            },
//            error: function () {
//                alert('Error occured');
//            }
//        });
//        window.location = createDynamicURL() + "/excelFieldServiceDetailsServlet?tgl_excel_service_details_start=" + tgl_excel_service_details_start + "&tgl_excel_service_details_end=" + tgl_excel_service_details_end;

//    } else if (nama_teknisi_field_service === "" && tgl_excel_service_details_start === "" && tgl_excel_service_details_end === "") {

//        url = createDynamicURL() + "/excelFieldServiceDetailsServlet?nama_teknisi_field_service=" + nama_teknisi_field_service + "&tgl_excel_service_details_start=" + tgl_excel_service_details_start + "&tgl_excel_service_details_end" + tgl_excel_service_details_end;
//                window.location = url;
//        return false;
//        $.ajax({
//            type: "GET",
//            url: '/InventoryAsetProject/excelFieldServiceDetailsServlet',
//            data: ({tgl_excel_service_details_start: tgl_excel_service_details_start, tgl_excel_service_details_end: tgl_excel_service_details_end})
//            data: ({"tgl_excel_service_details_start": tgl_excel_service_details_start, "tgl_excel_service_details_end": tgl_excel_service_details_end}),
//            dataType: "text"
//            success: function (data) {
// Run the code here that needs
//    to access the data returned
//                return data;
//            },
//            error: function () {
//                alert('Error occured');
//            }
//        });
//    }

//    window.location = url;

//        if ($("#nama_teknisi_field_service").val() === "") {
//
//        }else{
//            
//        }
//        $.ajax({
//            type: "POST",
//            url: createDynamicURL() + "/excelFieldServiceServlet"
//            dataType: "json",
//            data: {JSONFile: "[" + JSON.stringify($('#form_submit_company').serializeObject()) + "]"}, // look here!
//           data: {rows:rowValues, columns:columnValues},
//            success: function (response) {
//our country code was correct so we have some information to display
//                if (response.RC === "1pers") {

//                    $("#ajaxResponse_form_submit_company").html("<div><p><b>" + "SUCCES" + "</b></p></div>");
//                    $('#btn_submit_form_company').prop('disabled', true);
//                } else if (response.RC === "1persD") {
//                    $("#ajaxResponse_form_submit_company").html("<div><p><b>" + "Data Duplicate" + "</b></p></div>");
//                    $('#btn_submit_form_company').prop('disabled', true);
//                }
//display error message
//                else {
//                    $("#ajaxResponse_form_submit_company").html("<div><p><b>Invalid!</b></p></div>");
//                }
//            },
//If there was no resonse from the server
//            error: function (jqXHR, textStatus, errorThrown) {
//                console.log("Something really bad happened " + textStatus);
//                $("#ajaxResponse_report_excel_field_service_details").html(jqXHR.responseText);
//            }


//        });
//        return false;
//    });

//}

//function barchartFunction() {
////    alert("form_bar_chart");
//    var dataString = $("#form_bar_chart").serialize();
//    $.ajax({
//        type: "GET",
//        url: createDynamicURL() + "/dataBarChartServlet",
//        data: dataString
//    });
//
//    return false;
//}

//function piechartFunction() {
//    alert("form_pie_chart");
//    var dataString = $("#form_pie_chart").serialize();
//    $.ajax({
//        type: "GET",
//        url: createDynamicURL() + "/dataPieChartServlet",
//        data: dataString
//    });
//    return false;
//}

//function myDahsboardReport() {
//
////    http://www.mkyong.com/javascript/how-to-access-json-object-in-javascript/
////    var isi_urlDashboard = createDynamicURL() + "/dashBoardReportServlet";
//    var isi_urlDataJo = createDynamicURL() + "/dataJOServlet";
//
//    var i, x;
//    $.ajax({
//        type: 'GET',
//        url: isi_urlDataJo,
////          data: data,
//        async: false,
//        beforeSend: function (xhr) {
//            if (xhr && xhr.overrideMimeType) {
//                xhr.overrideMimeType('application/json;charset=utf-8');
//            }
//        },
//        dataType: 'json',
//        success: function (data) {
//            //Do stuff with the JSON data
////                var json = JSON.stringify(data.rows);
//            //[{"total_merchant":567,"total_visited":7,"total_jabodetabek":4,"total_bali":3,"total_yogya":0}]
////                alert("isi data total_merchant" + JSON.stringify(data.rows));
//            for (i in data.rows) {
////                    alert(data.rows[i].total_merchant);
////                    document.getElementById("total_merchant").innerHTML = data.rows[i].total_merchant;
//                if (data.rows[i].total_merchant !== "") {
//                    document.getElementById("total_merchant").innerHTML = data.rows[i].total_merchant;
//                } else {
//                    document.getElementById("total_merchant").innerHTML = "0";
//                }
//                if (data.rows[i].total_visited !== "") {
//                    document.getElementById("total_visited").innerHTML = data.rows[i].total_visited;
//                } else {
//                    document.getElementById("total_visited").innerHTML = "0";
//                }
//                if (data.rows[i].total_province !== "") {
//                    document.getElementById("total_province").innerHTML = data.rows[i].total_province;
//                } else {
//                    document.getElementById("total_province").innerHTML = "0";
//                }
//                if (data.rows[i].total_bali !== "") {
//                    document.getElementById("total_bali").innerHTML = data.rows[i].total_bali;
//                } else {
//                    document.getElementById("total_bali").innerHTML = "0";
//                }
//                if (data.rows[i].total_jabodetabek !== "") {
//                    document.getElementById("total_jabodetabek").innerHTML = data.rows[i].total_jabodetabek;
//                } else {
//                    document.getElementById("total_jabodetabek").innerHTML = "0";
//                }
//                if (data.rows[i].total_yogya !== "") {
//                    document.getElementById("total_yogya").innerHTML = data.rows[i].total_yogya;
//                } else {
//                    document.getElementById("total_yogya").innerHTML = "0";
//                }
//            }
//
//        }
//    });
//
//}

//function showDataDashboard() {
//
//    var isi_urlDashboard = createDynamicURL() + "/dashBoardReport";
//    var x;
//    $.ajax({
//        type: "GET",
//        url: isi_urlDashboard,
//        async: false,
//        beforeSend: function (xhr) {
//            if (xhr && xhr.overrideMimeType) {
//                xhr.overrideMimeType('application/json;charset=utf-8');
//            }
//        },
//        dataType: 'json',
//        success: function (data) {
////            alert(data.rows);
//            for (x in data.rows) {
//
//                if (data.rows[x].total_merchant_ok !== "") {
//                    document.getElementById("total_merchant_ok").innerHTML = data.rows[x].total_merchant_ok;
//                } else {
//                    document.getElementById("total_merchant_ok").innerHTML = "0";
//                }
//                if (data.rows[x].total_merchant_not_found !== "") {
//                    document.getElementById("total_merchant_not_found").innerHTML = data.rows[x].total_merchant_not_found;
//                } else {
//                    document.getElementById("total_merchant_not_found").innerHTML = "0";
//                }
//                if (data.rows[x].total_field_transaction !== "") {
//                    document.getElementById("total_field_transaction").innerHTML = data.rows[x].total_field_transaction;
//                } else {
//                    document.getElementById("total_field_transaction").innerHTML = "0";
//                }
//                if (data.rows[x].total_no_tent_card !== "") {
//                    document.getElementById("total_no_tent_card").innerHTML = data.rows[x].total_no_tent_card;
//                } else {
//                    document.getElementById("total_no_tent_card").innerHTML = "0";
//                }
//                if (data.rows[x].total_no_sign_door !== "") {
//                    document.getElementById("total_no_sign_door").innerHTML = data.rows[x].total_no_sign_door;
//                } else {
//                    document.getElementById("total_no_sign_door").innerHTML = "0";
//                }
//                if (data.rows[x].total_no_feature !== "") {
//                    document.getElementById("total_no_feature").innerHTML = data.rows[x].total_no_feature;
//                } else {
//                    document.getElementById("total_no_feature").innerHTML = "0";
//                }
//            }
//
//        }
//    });
//
//}


//function myFunction_form_upload() {
//
////    alert("form_upload");
//
//    var data_upload_excel_delegasi = new FormData($("#form_upload")[0]);
//    $.ajax({
//        type: "POST",
////        dataType: 'json',
//        url: createDynamicURL() + "/uploadDelegationServlet", //uploadDataExcelServlet
//        data: data_upload_excel_delegasi,
//        cache: false,
//        async: false,
//        timeout: 10000,
//        processData: false, // Do'nt process the files
//        contentType: false, // Set content type to false as jQuery will tell the server its a query string request                       
//        success: function (response) {
//
//            if (response.RC === "1") {
//
//                $("#content_form_upload").html("<div><b>Success Upload Job Order</b></div>");
////                alert("Success");
////                window.location.href = "index.jsp?ref=data_grid_custcare&pages=grid_no_jo";
//
//            } else if (response.RC === "x0s") {
//
////                alert("No File Found");
//                $("#content_form_upload").html("<div><b>No File Found !</b></div>");
//            } else if (response.RC === "00nmx") {
//
////                alert("Fail Upload File");
//                $("#content_form_upload").html("<div><b>Fail Upload  data Job Order !</b></div>");
//            } else if (response.RC === "typ0x") {
////                alert("type  Aset Not Listed");
//                $("#content_form_upload").html("<div><b>Type  Aset Not Found !</b></div>");
//            } else {
////                alert("Fail Upload");
//                $("#content_form_upload").html("<div><b>Fail Upload!</b></div>");
//            }
//        }, error: function (jqXHR, textStatus, errorThrown) {
////            alert("Something really bad happened " + textStatus);
//            $("#content_form_upload").html("<div><b>Something really bad happened" + textStatus + "</b></div>");
////            window.location.href = "index.jsp?ref=data_grid_custcare&pages=grid_no_jo";
//
////                            $("#form_upload_excel_delegate").html(jqXHR.responseText);
//        }
//
//    });
//    return false;
//}

function yahoo_mail() {
    $("#smtpSocketFactoryPort").val("465");
    $("#smtpSocketFactoryClass").val("javax.net.ssl.SSLSocketFactory");
    $("#smtpPort").val("465");
    $("#smtpHost").val("smtp.yahoo.com");
    return;
}
function google_mail() {
    $("#smtpSocketFactoryPort").val("465");
    $("#smtpSocketFactoryClass").val("javax.net.ssl.SSLSocketFactory");
    $("#smtpPort").val("465");
    $("#smtpHost").val("smtp.gmail.com");
    return;
}
function other_mail() {
    $("#smtpSocketFactoryPort").val("");
    $("#smtpPort").val("");
    $("#smtpHost").val("");
    $("#smtpSocketFactoryClass").val("false");
    return;
}

//function getVariable(variable) {
//    var query = window.location.search.substring(1);
//    var vars = query.split("&");
//    for (var i = 0; i < vars.length; i++) {
//        var pair = vars[i].split("=");
//        if (pair[0] === variable) {
//            return pair[1];
//        }
//    }
//    return (false);
//}

function editUserFunc(data_users) {//, supplier_name, supplier_code, address, contact_name, contact_num, status_supp

//    alert(data_users.gender);
    var param = "&userName=" + escape(data_users.user_name) + "&id_user=" + escape(data_users.id_user)
            + "&action_edit=" + "EDIT" + "&email=" + escape(data_users.email)
            + "&address=" + escape(data_users.address) + "&role_name=" + escape(data_users.role_name)
            + "&imei=" + escape(data_users.imei) + "&phone=" + escape(data_users.phone)
            + "&gender=" + escape(data_users.gender);
//    var isi_param = param.replace(/%20/g, "");
    window.location = "index.jsp?url=user_layout&pages=add_user_form" + param; //decodeURI(param)
}

function editSupplierFunc(data_supplier) {//, supplier_name, supplier_code, address, contact_name, contact_num, status_supp

//    var suppliername = data_supplier.supplier_name;
//    alert(suppliername);
//    console.log(data_supplier.supplier_name);
    var param = "&supplier_name=" + escape(data_supplier.supplier_name) + "&supplier_id=" + escape(data_supplier.supplier_id)
            + "&action_edit_supp=" + "EDIT" + "&supplier_code=" + escape(data_supplier.supplier_code)
            + "&address_supplier=" + escape(data_supplier.address) + "&contact_suplier_name=" + escape(data_supplier.contact_name)
            + "&cotact_suplier_num=" + escape(data_supplier.contact_num)
            + "&tax=" + escape(data_supplier.tax);
//    var isi_param = param.replace(/%20/g, "");
    window.location = "index.jsp?url=supllier_layout&pages=add_supllier_form" + param; //decodeURI(param);
//

}
//
function editCategoriesFunc(data_categories) {//, supplier_name, supplier_code, address, contact_name, contact_num, status_supp
//    alert(data_categories.category_id);
    var myParam = "&category_name=" + escape(data_categories.name_categories) + "&category_id=" + escape(data_categories.category_id)
            + "&action_edit_category=" + "EDIT" + "&category_desc=" + escape(data_categories.category_desc);
    window.location = "index.jsp?url=item_layout&pages=add_category_form" + myParam; //decodeURI(myParam)data_form_po.purchase_id;

}

function addPoItemFunc(data_form_po) {
    var tax_po_val = "";
    var message = "This Supplier Have Tax PPN, You want Activated for this tractions &#63;";
//    if (data_form_po.supplier_tax === "1") {
//        if (confirm("This Supplier Have Tax PPN, You want Activated for this tractions ? \n\n") === true) {
//
//            tax_po_val = "1";
//        } else {
//            tax_po_val = "0";
//
//        }
//    }
//var myParam = "purchase_id=" + escape(data_form_po.purchase_id) + "&supplier_id_form_create_po=" + escape(data_form_po.supplier_id)
//            + "&tax_item_po=" + escape(data_form_po.supplier_tax) + "&tax_po_val=" + escape(tax_po_val);
//    window.location = "index.jsp?url=purcahase_layout&pages=form_item_po&" + myParam; // decodeURI(myParam)
    $('<div></div>').appendTo('body')
            .html('<div><h5>' + message + '</h5></div>')
            .dialog({
                modal: true,
                title: '',
                zIndex: 10000,
                autoOpen: true,
                width: 'auto',
                resizable: false,
                show: "clip",
                class: "toggler",
                hide: "slide",
                buttons: [{
                        text: 'Yes',
                        class: 'btn btn-primary',
                        id: "btn_yes",
                        click: function () {
                            tax_po_val = "1";
//                          $('body').append('<h1>Confirm Dialog Result: <i>Yes</i></h1>');
                            var myParam = "purchase_id=" + escape(data_form_po.purchase_id) + "&supplier_id_form_create_po=" + escape(data_form_po.supplier_id)
                                    + "&tax_item_po=" + escape(data_form_po.supplier_tax) + "&tax_po_val=" + escape(tax_po_val);
                            window.location = "index.jsp?url=purcahase_layout&pages=form_item_po&" + myParam; // decodeURI(myParam)
                            $(this).dialog("close");
                        }
                    }, {
                        text: 'No',
                        class: 'btn btn-default',
                        id: "btn_no",
                        click: function () {
                            tax_po_val = "0";
//                        $('body').append('<h1>Confirm Dialog Result: <i>Yes</i></h1>');
                            var myParam = "purchase_id=" + escape(data_form_po.purchase_id) + "&supplier_id_form_create_po=" + escape(data_form_po.supplier_id)
                                    + "&tax_item_po=" + escape(data_form_po.supplier_tax) + "&tax_po_val=" + escape(tax_po_val);
                            window.location = "index.jsp?url=purcahase_layout&pages=form_item_po&" + myParam; // decodeURI(myParam)
                            $(this).dialog("close");
                        }
                    }],
                close: function (event, ui) {
                    tax_po_val = "0";
                    $(this).remove();
                }
            });
}

function listPoItemFunc(data_form_po) {
//    alert(data_form_po.purchase_id);
    var myParam = "purchase_id=" + escape(data_form_po.purchase_id) + "&supplier_id_form_create_po=" + escape(data_form_po.supplier_id);
    window.location = "index.jsp?url=purcahase_layout&pages=list_item_po&" + myParam; //data_form_po.purchase_id;
}
function editPoFunc(data_form_po) {
//    alert(data_form_po.purchase_id);

    var myParam = "purchase_id=" + escape(data_form_po.purchase_id) + "&supplier_name_po=" + escape(data_form_po.supplier_name)
            + "&supplier_code_po=" + escape(data_form_po.supplier_code)
            + "&supplier_id_po=" + escape(data_form_po.supplier_id) + "&action_edit_po=" + escape("EDIT")
            + "&tax_po=" + escape(data_form_po.supplier_tax) + "&tgl_input_po=" + escape(data_form_po.tgl_input_po)
            + "&po_type=" + escape(data_form_po.po_type) + "&payment_term=" + escape(data_form_po.payment_term)
            + "&delivery_term=" + escape(data_form_po.delivery_term) + "&transport_mode=" + escape(data_form_po.transport_mode)
            + "&quotation_number=" + escape(data_form_po.quotation_number) + "&rfq_number=" + escape(data_form_po.rfq_number)
            + "&purchase_desc=" + escape(data_form_po.purchase_desc) + "&invoice_to=" + escape(data_form_po.invoice_to)
            + "&dlvr_point=" + escape(data_form_po.dlvr_point);

//    alert("myParam value : " + myParam);
    window.location = "index.jsp?url=purcahase_layout&pages=add_po&" + myParam; //decodeURI(myParam)
}

function editItemFunc(data_Items) {
//    alert(data_item.price_item);
    var param = "&supplier_name_item=" + escape(data_Items.supplier_name) + "&supplier_id_item=" + escape(data_Items.supplier_id) + "&item_name=" + escape(data_Items.product_name)
            + "&id_product=" + escape(data_Items.id_product) + "&action_edit_item=" + "EDIT" + "&product_code=" + escape(data_Items.product_code)
            + "&categories_name=" + escape(data_Items.name_category) + "&category_id=" + escape(data_Items.category_id) + "&price_item=" + escape(data_Items.price_item)
            + "&estemated_date_before=" + escape(data_Items.estemated_date_before) + "&estemated_date_after=" + escape(data_Items.estemated_date_after)
            + "&description=" + escape(data_Items.description) + "&id_stock=" + escape(data_Items.id_stock);
//    var isi_param = param.replace(/%20/g, "");

    window.location = "index.jsp?url=item_layout&pages=form_add_item" + param;//decodeURI(param)
}
function viewStockFunc(data_Items) {
    var param = "&id_product=" + escape(data_Items.id_product) + "&supplier_name_item=" + escape(data_Items.supplier_name) + "&id_stock=" + escape(data_Items.id_stock);

    window.location = "index.jsp?url=item_layout&pages=list_stock_item" + param;//decodeURI(param)
}
function deleteUserFunc(data_users) {

    var data_delete_pic = {
        id_user: data_users.id_user,
        action_insert: $("#action_insert").val(),
        action_edit: $("#action_edit").val(),
        action_delete: "DELETE"
    };
    $.ajax({
        type: "POST",
        url: createDynamicURL() + "/userServlet",
        data: {JSONFile: data_delete_pic}, // look here!

        success: function (response) {
            //our country code was correct so we have some information to display
            if (response.RC === "1") {
                $("#form_add_user_response").html("<div><p><b>" + "User " + data_users.user_name + " Has been Recorded" + "</b></p></div>");
//                $('#btn_add_pic').prop('disabled', true);
            } else if (response.RC === "2") {
                $("#form_add_user_response").html("<div><p><b>" + "User " + data_users.user_name + " Already Registered" + "</b></p></div>").addClass('error').css({});
            }
            //display error message
            else {
                $("#form_add_user_response").html("<div><p><b>Invalid!</b></p></div>").addClass('error').css({});
            }
        },
        //If there was no resonse from the server
        error: function (jqXHR, textStatus, errorThrown) {
            console.log("Something really bad happened " + textStatus);
            $("#form_add_user_response").html(jqXHR.responseText);
        }

    });
}
function deleteSupplierFunc(data_supplier) {
//      alert(data_supplier.supplier_id);
    var data_delete_supplier = {
        supplier_id: escape(data_supplier.supplier_id),
        action_insert_supp: "",
        action_edit_supp: "",
        action_delete_supp: "DELETE"
    };
//    var data_delete_supplier = "id_user:" + escape(data_supplier.supplier_id) +",action_insert_supp:"+""+",action_edit_supp:"+""
//            +",action_delete:"+"DELETE";
//    alert(data_delete_supplier);
    $.ajax({
        type: "POST",
        url: createDynamicURL() + "/supplierServlet",
        data: {JSONFile: "[" + JSON.stringify(data_delete_supplier) + "]"}, // look here!

        success: function (response) {
            //our country code was correct so we have some information to display
            if (response.RC === "4") {
                $("#grid_supplier_response").html("<div class='alert alert-success' role='alert'><button type='button' class='close' data-dismiss='alert'>&times;</button><p><b>" + "Supplier  " + response.msg + "</b></p></div>");
//                    $('#btn_add_supplier').prop('disabled', true);
            } else if (response.RC === "2") {
                $("#grid_supplier_response").html("<div class='alert alert-warning' role='alert'><button type='button' class='close' data-dismiss='alert'>&times;</button><p><b>" + "Supplier " + response.msg + "</b></p></div>").addClass('error').css({});
            } else if (response.RC === "3") {
                $("#grid_supplier_response").html("<div class='alert alert-success' role='alert'><button type='button' class='close' data-dismiss='alert'>&times;</button><p><b>" + "Supplier " + response.msg + "</b></p></div>").addClass('error').css({});
            } else if (response.RC === "33") {
                $("#grid_supplier_response").html("<div class='alert alert-warning' role='alert'><button type='button' class='close' data-dismiss='alert'>&times;</button><p><b>" + "Supplier code" + response.msg + "</b></p></div>").addClass('error').css({});
            }
            //display error message
            else {
                $("#grid_supplier_response").html("<div class='alert alert-danger' role='alert'><button type='button' class='close' data-dismiss='alert'>&times;</button><p><b>Invalid!</b></p></div>").addClass('error').css({});
            }
        },
        //If there was no resonse from the server
        error: function (jqXHR, textStatus, errorThrown) {
            console.log("Something really bad happened " + textStatus);
            $("#grid_supplier_response").html(jqXHR.responseText);
        }

    });
}
function deleteCategoriesFunc(data_categories) {
    var data_delete_categories = {
        category_id: escape(data_categories.category_id),
        action_insert_category: "",
        action_edit_category: "",
        action_delete_category: "DELETE"
    };
    $.ajax({
        type: "POST",
        url: createDynamicURL() + "/categoryServlet",
        data: {JSONFile: "[" + JSON.stringify(data_delete_categories) + "]"}, // look here!

        success: function (response) {
            //our country code was correct so we have some information to display
            if (response.RC === "4") {
                $("#grid_categories_response").html("<div class='alert alert-success' role='alert'><button type='button' class='close' data-dismiss='alert'>&times;</button><p><b>" + "categories  " + response.msg + "</b></p></div>");
//                    $('#btn_add_supplier').prop('disabled', true);
            } else if (response.RC === "2") {
                $("#grid_categories_response").html("<div class='alert alert-warning' role='alert'><button type='button' class='close' data-dismiss='alert'>&times;</button><p><b>" + "categories " + response.msg + "</b></p></div>").addClass('error').css({});
            } else if (response.RC === "3") {
                $("#grid_categories_response").html("<div class='alert alert-success' role='alert'><button type='button' class='close' data-dismiss='alert'>&times;</button><p><b>" + "categories " + response.msg + "</b></p></div>").addClass('error').css({});
            } else if (response.RC === "33") {
                $("#grid_categories_response").html("<div class='alert alert-warning' role='alert'><button type='button' class='close' data-dismiss='alert'>&times;</button><p><b>" + "categories code" + response.msg + "</b></p></div>").addClass('error').css({});
            }
            //display error message
            else {
                $("#grid_categories_response").html("<div class='alert alert-danger' role='alert'><button type='button' class='close' data-dismiss='alert'>&times;</button><p><b>Invalid!</b></p></div>").addClass('error').css({});
            }
        },
        //If there was no resonse from the server
        error: function (jqXHR, textStatus, errorThrown) {
            console.log("Something really bad happened " + textStatus);
            $("#grid_categories_response").html(jqXHR.responseText);
        }

    });
}
function deleteItemFunc(data_Item) {
    var data_delete_Item = {
        id_product: escape(data_Item.id_product),
        id_stock: escape(data_Item.id_product),
        action_insert_item: "",
        action_edit_item: "",
        action_delete_item: "DELETE"
    };
    $.ajax({
        type: "POST",
        url: createDynamicURL() + "/itemServlet",
        data: {JSONFile: "[" + JSON.stringify(data_delete_Item) + "]"}, // look here!

        success: function (response) {
            //our country code was correct so we have some information to display
            if (response.RC === "4") {
                $("#grid_items_response").html("<div class='alert alert-success' role='alert'><button type='button' class='close' data-dismiss='alert'>&times;</button><p><b>" + "Item  " + response.msg + "</b></p></div>");
//                    $('#btn_add_supplier').prop('disabled', true);
            } else if (response.RC === "2") {
                $("#grid_items_response").html("<div class='alert alert-warning' role='alert'><button type='button' class='close' data-dismiss='alert'>&times;</button><p><b>" + "Item " + response.msg + "</b></p></div>").addClass('error').css({});
            } else if (response.RC === "3") {
                $("#grid_items_response").html("<div class='alert alert-success' role='alert'><button type='button' class='close' data-dismiss='alert'>&times;</button><p><b>" + "Item " + response.msg + "</b></p></div>").addClass('error').css({});
            } else if (response.RC === "33") {
                $("#grid_items_response").html("<div class='alert alert-warning' role='alert'><button type='button' class='close' data-dismiss='alert'>&times;</button><p><b>" + "Item code" + response.msg + "</b></p></div>").addClass('error').css({});
            }
            //display error message
            else {
                $("#grid_items_response").html("<div class='alert alert-danger' role='alert'><button type='button' class='close' data-dismiss='alert'>&times;</button><p><b>Invalid!</b></p></div>").addClass('error').css({});
            }
        },
        //If there was no resonse from the server
        error: function (jqXHR, textStatus, errorThrown) {
            console.log("Something really bad happened " + textStatus);
            $("#grid_items_response").html(jqXHR.responseText);
        }

    });
}
//
function myFunctionUploadDataUser() {
    alert("Hi there");
}
//Generate PDF
function purchasePdfReport(data_record_po) {
    var data_purchase_pdf_report = {
        purchase_id: escape(data_record_po.purchase_id),
        supplier_id: escape(data_record_po.supplier_id),
        action_insert_item: "pdf"
    };
    $.ajax({

    });
}
//Generate PDF
function soPdfReport(data_record_so) {
    var data_sales_pdf_report = {
        purchase_id: escape(data_record_so.sales_id),
        supplier_id: escape(data_record_so.mecrhant_id),
        action_insert_item: "pdf"
    };
    $.ajax({

    });
}
//End Generate PDF
//
//Generate Excel
function purchaseExcelReport(data_record_po) {

}
function suplierExcelReport(data_record_supplier) {
//    alert("isi param 1" + data_record_supplier.supplier_id);
    var isi_supplier_id = escape(data_record_supplier.supplier_id);
    var isi_supplier_name = escape(data_record_supplier.supplier_name);
    var dataString = {
        supplier_id: escape(isi_supplier_id),
        supplier_name: escape(isi_supplier_name)
    };
//    alert("isi dataString " + dataString.supplier_id);
    var param = "&jsonfield=" + JSON.stringify(dataString);
    // look here!
//    console.log("isi param" + param);
//    alert("isi param" + param.supplier_id);
//    return false;
// var param = "supplier_id="+escape(data_record_supplier.supplier_id);
    window.location = createDynamicURL() + "excelItemsSuplierServlet?" + param;
//    $.ajax({
//         url: createDynamicURL() + "excelItemsSuplierServlet?" + param;
//    });
}
//End Generate Excel
//
function categories_empty() {
    console.log("entered categories_empty function");
    var categories_name = $("#categories_name").val();
    var dataString = {categories_name: categories_name};
    console.log(dataString);
    $.ajax({
        type: "POST",
        url: createDynamicURL() + "/getCategoryServlet", //uploadDataExcelServlet
        data: {
            jsonfield: JSON.stringify(dataString) // look here!
        },
        dataType: "json",
        //if received a response from the server
        success: function (response) {
            //our country code was correct so we have some information to display
            if (response) {
                console.log(response.categories_name);
                $("#categories_name").val(response.categories_name);
                console.log(response.categori_id);
                $("#categori_id").val(response.categori_id);
            }
            //display error message
            else {
                $("#ajaxResponse_form_add_item").html("<div><b>Category Name's in Invalid!</b></div>");
            }
        },
        //If there was no resonse from the server
        error: function (jqXHR, textStatus, errorThrown) {
            console.log("Something really bad happened " + textStatus);
            $("#ajaxResponse_form_add_item").html(jqXHR.responseText);
        }
    });
}
function supplier_item_empty() {
    console.log("entered empty function");
    //get the form data and then serialize that
    var supplier_name = $("#supplier_name").val();
//    var dataString = {};
//    if (supplier_name !== "") {
    var dataString = {
        supplier_name: supplier_name

    };
    console.log(dataString);
    $.ajax({
        type: "POST",
        url: createDynamicURL() + "/dataSupplierServlet", //uploadDataExcelServlet
        data: {
            jsonfield: JSON.stringify(dataString) // look here!
        },
        dataType: "json",
        //if received a response from the server
        success: function (response) {
            //our country code was correct so we have some information to display
            if (response) {

                console.log(response.supplier_name);
                $("#supplier_name").val(response.supplier_name);
                console.log(response.supplier_id);
                $("#supplier_id").val(response.supplier_id);
            }
            //display error message
            else {
                $("#ajaxResponse_form_add_item").html("<div><b>Supplier Name in Invalid!</b></div>");
            }
        },
        //If there was no resonse from the server
        error: function (jqXHR, textStatus, errorThrown) {
            console.log("Something really bad happened " + textStatus);
            $("#ajaxResponse_form_add_item").html(jqXHR.responseText);
        }
    });
}
function supplier_empty() {
    console.log("entered empty function");
    //get the form data and then serialize that
    var supplier_name = $("#supplier_name_po").val();
    var dataString = {
        supplier_name: supplier_name

    };
//    }
//    if (supplier_code !== "") {
//        dataString = {supplier_code: supplier_code};
//    }
    console.log(dataString);
    $.ajax({
        type: "POST",
        url: createDynamicURL() + "/dataSupplierServlet", //uploadDataExcelServlet
        data: {
            jsonfield: JSON.stringify(dataString) // look here!
        },
        dataType: "json",
        //if received a response from the server
        success: function (response) {
            //our country code was correct so we have some information to display
            if (response) {

                console.log(response.supplier_name);
                $("#supplier_name_po").val(response.supplier_name);
                console.log(response.supplier_code);
                $("#supplier_code_po").val(response.supplier_code);
                console.log(response.supplier_code);
                $("#supplier_id_po").val(response.supplier_id);
                console.log(response.tax);
                $("#tax_po").val(response.tax);
            }
            //display error message
            else {
                $("#ajaxResponse_form_add_po").html("<div><b>Supplier Name in Invalid!</b></div>");
            }
        },
        //If there was no resonse from the server
        error: function (jqXHR, textStatus, errorThrown) {
            console.log("Something really bad happened " + textStatus);
            $("#ajaxResponse_form_add_po").html(jqXHR.responseText);
        }
    });
}
function supplier_code_empty() {
    console.log("entered empty function");
    var supplier_code_po = $("#supplier_code_po").val();
    var dataString = {
        supplier_code_po: supplier_code_po

    };
    console.log(dataString);
    $.ajax({
        type: "POST",
        url: createDynamicURL() + "/dataSupplierCodeServlet", //uploadDataExcelServlet
        data: {
            jsonfield: JSON.stringify(dataString) // look here!
        },
        dataType: "json",
        //if received a response from the server
        success: function (response) {
            //our country code was correct so we have some information to display
            if (response) {

                console.log(response.supplier_name);
                $("#supplier_name_po").val(response.supplier_name);
                console.log(response.supplier_code);
                $("#supplier_code_po").val(response.supplier_code);
                console.log(response.supplier_code);
                $("#supplier_id_po").val(response.supplier_id);
                console.log(response.tax);
                $("#tax_po").val(response.tax);
            }
            //display error message
            else {
                $("#ajaxResponse_form_add_po").html("<div><b>Supplier Code in Invalid!</b></div>");
            }
        },
        //If there was no resonse from the server
        error: function (jqXHR, textStatus, errorThrown) {
            console.log("Something really bad happened " + textStatus);
            $("#ajaxResponse_form_add_po").html(jqXHR.responseText);
        }
    });
}
//function getItem(value) {
//
//    var id_suplier = value;
//    item_supEmpty(id_suplier);
//}
function item_supEmpty() {
    var idSupplier = document.getElementById("supplier_id_form_create_po").value;
    var item_name_po = document.getElementById("item_name_po").value;
    var dataString = {
        idSupplier: idSupplier,
        item_name_po: item_name_po
    };
    console.log(dataString);
    $.ajax({
        type: "POST",
        url: createDynamicURL() + "/getItemSupplierServlet", //
        data: {
            jsonfield: JSON.stringify(dataString) // look here!
        },
        dataType: "json",
        //if received a response from the server
        success: function (response) {
            //our country code was correct so we have some information to display
            if (response) {
                console.log(response.item_name);
                $("#item_name_po").val(response.item_name_po);
                console.log(response.unit_price_po);
                $("#unit_price_po").val(response.unit_price_po);
                console.log(response.product_id);
                $("#id_product").val(response.product_id);
            }
            //display error message
            else {
                $("#ajaxResponse_form_delegate").html("<div><b>Item Names in Invalid!</b></div>");
            }
        },
        //If there was no resonse from the server
        error: function (jqXHR, textStatus, errorThrown) {
            console.log("Something really bad happened " + textStatus);
            $("#ajaxResponse_form_delegate").html(jqXHR.responseText);
        }
    });
}
function type_po_empty() {
    var val_po_type = document.getElementById("po_type").value;
    var dataString = {
        po_type: val_po_type
    };
    console.log(dataString);
    $.ajax({
        type: "POST",
        url: createDynamicURL() + "/getPaymentTermServlet", //uploadDataExcelServlet
        data: {
            jsonfield: JSON.stringify(dataString) // look here!
        },
        dataType: "json",
        //if received a response from the server
        success: function (response) {
            //some information to display
            if (response) {

                console.log(response.po_type);
                $("#po_type").val(response.po_type);
                console.log(response.payment_term);
                $("#payment_term").val(response.payment_term);
            }
            //display error message
            else {
                $("#payment_term").val('0');
//                $("#ajaxResponse_form_add_po").html("<div><b>Type Po in Invalid!</b></div>");
            }
        },
        //If there was no resonse from the server
        error: function (jqXHR, textStatus, errorThrown) {
            console.log("Something really bad happened " + textStatus);
            $("#ajaxResponse_form_add_po").html(jqXHR.responseText);
        }
    });
}


var j = 1;
function add_row() {

    var k = 0;

    var item_name_po = "";
//    alert("add_row");
//    var k = 1;
    var target = document.getElementById("form_create_po");
    var itemlist = document.getElementById('itemlist');
    var remove_row = document.getElementById('remove_row');
//      create element
    var row = document.createElement('tr');

    var td1 = document.createElement('td');
    td1.setAttribute('class', 'display');
    var td2 = document.createElement('td');
    td2.setAttribute('class', 'display');
    var td3 = document.createElement('td');
    td3.setAttribute('class', 'display');
    var td4 = document.createElement('td');
    td4.setAttribute('class', 'display');
    var td5 = document.createElement('td');
    td5.setAttribute('class', 'display');
    var td6 = document.createElement('td');
    td6.setAttribute('class', 'display');
    var td7 = document.createElement('td');
    td7.setAttribute('class', 'display');
    var td8 = document.createElement('td');
    td8.setAttribute('class', 'display');

    itemlist.appendChild(row);
    itemlist.appendChild(td1);
//    row.appendChild(td1);
//    row.appendChild(aksi);

//                CreTE element input
    var e_item_name = document.createElement('input');
    e_item_name.type = "text";
    e_item_name.id = "item_name_po";
    e_item_name.name = "item_name_po";
    e_item_name.placeholder = "Like Sugar";
    e_item_name.setAttribute('required', '');
    e_item_name.setAttribute('class', 'form-control-static uppercase');

    var e_id_product = document.createElement('input');
    e_id_product.type = "hidden";
    e_id_product.id = "id_product";
    e_id_product.name = "id_product";
    e_id_product.readOnly = true;

    var e_qtty_po = document.createElement('input');
    e_qtty_po.type = "number";
    e_qtty_po.id = "qtty_po";
    e_qtty_po.name = "qtty_po";
    e_qtty_po.setAttribute('required', '');
    e_qtty_po.setAttribute('min', '1');
    e_qtty_po.setAttribute('value', '0');
    e_qtty_po.setAttribute('class', 'form-control-static uppercase');
    e_qtty_po.setAttribute("onchange", discount);
//    e_qtty_po.addEventListener('onchange', discount);

    var e_unit_item_po = document.createElement('input');
    e_unit_item_po.type = "text";
    e_unit_item_po.id = "unit_item_po";
    e_unit_item_po.name = "unit_item_po";
    e_unit_item_po.placeholder = "Unit";
    e_unit_item_po.setAttribute('required', '');
    e_unit_item_po.setAttribute('class', 'form-control-static uppercase');
    e_unit_item_po.addEventListener('onblur', format_rupiah);

    var e_unit_price_po = document.createElement('input');
    e_unit_price_po.type = "text";
    e_unit_price_po.id = "unit_price_po";
    e_unit_price_po.name = "unit_price_po";
    e_unit_price_po.placeholder = "In IDR";
    e_unit_price_po.readOnly = true;
    e_unit_price_po.setAttribute('required', '');
    e_unit_price_po.setAttribute("onblur", format_rupiah);
    e_unit_price_po.setAttribute("onchange", discount);
    e_unit_price_po.setAttribute('class', 'form-control-static uppercase');

    var e_discount_item_po = document.createElement('input');
    e_discount_item_po.type = "number";
    e_discount_item_po.id = "discount_item_po";
    e_discount_item_po.name = "discount_item_po";
    e_discount_item_po.placeholder = "Discount";
    e_discount_item_po.setAttribute('min', '0');
    e_discount_item_po.setAttribute('value', '0');
    e_discount_item_po.setAttribute('class', 'form-control-static uppercase');
    e_discount_item_po.setAttribute("onchange", discount);
    e_qtty_po.addEventListener('onchange', discount);

    var e_price_po = document.createElement('input');
    e_price_po.type = "text";
    e_price_po.id = "price_po";
    e_price_po.name = "price_po";
    e_price_po.readOnly = true;
    e_price_po.placeholder = "IDR";
    e_price_po.setAttribute('class', 'form-control-static uppercase');

//
    var e_button_2 = document.createElement('button');
    e_button_2.setAttribute('class', 'btn-warning fa fa-minus-square');
    e_button_2.id = "remove_row";

    if (j > 0) {
        k = j;
        row.appendChild(td1);
        row.appendChild(td2);
        row.appendChild(td3);
        row.appendChild(td4);
        row.appendChild(td5);
        row.appendChild(td6);
        row.appendChild(td7);
        row.appendChild(td8);

        td1.appendChild(e_item_name);
        e_item_name.id = "item_name_po_" + k;

        td2.appendChild(e_qtty_po);
        e_qtty_po.id = "qtty_po_" + k;
        td3.appendChild(e_unit_item_po);
        e_unit_item_po.id = "unit_item_po_" + k;
        td4.appendChild(e_unit_price_po);
        e_unit_price_po.id = "unit_price_po_" + k;

        td5.appendChild(e_discount_item_po);
        e_discount_item_po.id = "discount_item_po_" + k;
        td6.appendChild(e_price_po);
        e_price_po.id = "price_po_" + k;
        td7.appendChild(e_id_product);
        e_id_product.id = "id_product_" + k;
        td8.appendChild(e_button_2);

        /* */
        $('body').on('focus', '#item_name_po_' + k, function () {
            $(this).autocomplete({
                source: function (request, response) {
                    $.ajax({
                        url: createDynamicURL() + "/getItemPOServlet", //getItemPOPrice
                        dataType: "json",
                        method: "GET",
                        data: {
                            term: request.term,
                            idSupplier: $("#supplier_id_form_create_po").val()
                        }, success: function (data) {
                            response($.map(data, function (item) {
                                var code = item.split("|");
                                return {
                                    label: code[0],
                                    value: code[0],
                                    data: item
                                };

                            }));
                        }

                    });
                },
                minLength: 1,
                scroll: true,
                select: function (event, ui) {
//                var output = ui.item.data.split("|");
//                $('#item_name_po_' + k).val(output[1]);
//                item_supEmpty_($('#item_name_po_' + k).val());
//                    alert("isi ui"+ui.item.data);
//                    item_name_po = ui.item.data;
                    e_item_name.onload = item_supEmpty_(k, ui.item.data);
//                   

                },
                delay: 300
            }).autocomplete("option", "appendTo", "#form_create_po");

//         

        });
        $('body').on('change', '#qtty_po_' + k, function () {
            discount(k);

        });
        $('body').on('blur', '#unit_price_po_' + k, function () {
            discount(k);
            format_rupiah(k);
        });
        $('body').on('change', '#discount_item_po_' + k, function () {
            discount(k);
        });

//        $("#qtty_po_" + k).focus(function () {
//            discount(k);
//        });
        j++;
//        if (e_qtty_po.value !== "") {
//            e_unit_price_po.onblur = format_rupiah(k);
//            e_unit_price_po.onchange = discount(k);
//            e_qtty_po.onchange = discount(k);
//        }
    }

    e_button_2.onclick = function () {
        row.parentNode.removeChild(row);
    };

}
//
function item_supEmpty_(k, item_name_po) {

    var idSupplier = $('#supplier_id_form_create_po').val();
    var isi_item_po = "";
//    alert("isi k" + k + ",item_name_po_ 2" + item_name_po);

    if (item_name_po !== "") {
        var dataString = {
            idSupplier: idSupplier,
            item_name_po: item_name_po
        };
        $.ajax({
            type: "POST",
            url: createDynamicURL() + "/getItemSupplierServlet", //
            data: {
                jsonfield: JSON.stringify(dataString) // look here!
            },
            dataType: "json",
            //if received a response from the server
            success: function (response) {
                //our country code was correct so we have some information to display
                if (response) {
                    console.log(response.item_name_po);
                    $("#item_name_po_" + k).val(response.item_name_po);
                    console.log(response.unit_price_po);
                    $("#unit_price_po_" + k).val(response.unit_price_po);
                    console.log(response.product_id);
                    $("#id_product_" + k).val(response.product_id);
                }

                //display error message
                else {
                    $("#ajaxResponse_form_delegate").html("<div><b>Item Names in Invalid!</b></div>");
                }
            },
            //If there was no resonse from the server
            error: function (jqXHR, textStatus, errorThrown) {
                console.log("Something really bad happened " + textStatus);
                $("#ajaxResponse_form_delegate").html(jqXHR.responseText);
            }
        });
    }

}
function remove(id) {
//    alert("id"+id);
    var ele = id + 'tr';
    var elem = document.getElementById(ele);
    return elem.parentNode.removeChild(elem);
}
/**/

/**/

function format_rupiah(k) {//used
    var nilai_a = 0;
    if (k === 0) {
        var number = document.getElementById("unit_price_po").value;
        var number_string = number.toString();
        var sisa = number_string.length % 3;
        var rupiah = number_string.substr(0, sisa);
        var ribuan = number_string.substr(sisa).match(/\d{3}/g);
        if (ribuan) {
            var separator = sisa ? '.' : '';
            rupiah += separator + ribuan.join('.');
        }
//        return  document.getElementById("unit_price_po").value = number_string; //rupiah;
        nilai_a = document.getElementById("unit_price_po");
        nilai_a.value = number_string;

    } else {
        var number = document.getElementById("unit_price_po_" + k).value;
        var number_string = number.toString();
        var sisa = number_string.length % 3;
        var rupiah = number_string.substr(0, sisa);
        var ribuan = number_string.substr(sisa).match(/\d{3}/g);
        if (ribuan) {
            var separator = sisa ? '.' : '';
            rupiah += separator + ribuan.join('.');
        }
//        return  document.getElementById("unit_price_po").value = number_string; //rupiah;
        nilai_a = document.getElementById("unit_price_po_" + k);
        nilai_a.value = number_string;
    }
    return nilai_a;
}


function discount(k) { // used
    var nilai_b = 0;
    var price = "";
    var qtty = "";
    var pricedNew = "";
    var i = "";
    var nilai_unit = "";
    var nilai_akhir = "";
    var diskon = "";
    var number_string = "";
    var sisa = "";
    var rupiah = "";
    var ribuan = "";
    if (k === 0) {
        price = document.getElementById("unit_price_po").value;
        qtty = document.getElementById("qtty_po").value;
        pricedNew = price; //price.split('.').join("");
        i = document.getElementById("discount_item_po").value;
        nilai_unit = "";
        nilai_akhir = "";
        diskon = "";
        if (qtty > 0 && pricedNew > 0) {
            nilai_unit = pricedNew * qtty;
            if (i > 0) {
                diskon = i * nilai_unit / 100;
                nilai_akhir = nilai_unit - diskon;
            } else {
                nilai_akhir = nilai_unit;
            }

        } else {
            nilai_akhir = pricedNew * 0;
        }

        number_string = nilai_akhir.toString();
        sisa = number_string.length % 3;
        rupiah = number_string.substr(0, sisa);
        ribuan = number_string.substr(sisa).match(/\d{3}/g);
        subTotal(number_string);
        nilai_b = document.getElementById("price_po");
        nilai_b.value = number_string;
//        nilai_b = document.getElementById("price_po_" + k).value;
    } else {
//        alert("masuk sini" + k);
        if (document.getElementById("qtty_po_" + k).value !== "") {
            price = document.getElementById("unit_price_po_" + k).value;
            qtty = document.getElementById("qtty_po_" + k).value;
            pricedNew = price;
            i = document.getElementById("discount_item_po_" + k).value;
            nilai_unit = "";
            nilai_akhir = "";
            diskon = "";
            if (qtty > 0 && pricedNew > 0) {
                nilai_unit = pricedNew * qtty;
                if (i > 0) {
                    diskon = i * nilai_unit / 100;
                    nilai_akhir = nilai_unit - diskon;
                } else {
                    nilai_akhir = nilai_unit;
                }

            } else {
                nilai_akhir = pricedNew * 0;
            }

            number_string = nilai_akhir.toString();
            sisa = number_string.length % 3;
            rupiah = number_string.substr(0, sisa);
            ribuan = number_string.substr(sisa).match(/\d{3}/g);
            subTotal(number_string);
            nilai_b = document.getElementById("price_po_" + k);
            nilai_b.value = number_string;
//        alert("isi number_string" + number_string);
//        if (number_string !== "") {
//            document.getElementById("price_po_" + k).value = number_string ;
//        }
        }
    }

    return nilai_b;
}

function subTotal(Nrupiah) {
    var item_price = Nrupiah;
    var rupiah = 0;
    if (item_price > 0) {
        var number_string = item_price.split('.').join("").toString();
//        var sisa = number_string.length % 3;
//        rupiah = number_string.substr(0, sisa);
//        var ribuan = number_string.substr(sisa).match(/\d{3}/g);
//        if (ribuan) {
//            var separator = sisa ? '.' : '';
//            rupiah += separator + ribuan.join('.');
//        }
    }
    total(number_string);//Nrupiah
    return  document.getElementById("sub_total").value = number_string;

}
function total(Ntotal) {
    var tax = document.getElementById("val_tax_po").value = '10';
    return  document.getElementById("total_price_po").value = Ntotal;
}
//element_unit_price_po.onchange = discount;
//element_qtty_po.onchange = discount; 



//
function add_input() {
//mencari element dengan id "formku" (yaitu table)
    var target = document.getElementById("form_add_po");
    // membuat element <tr>
    var tabel_row = document.createElement("tr");
    // membuat element <td>
    var tabel_col = document.createElement("div");
    tabel_col.setAttribute('class', 'form-group');
    // membuat element input untuk menambah form inputan
    var tambah = document.createElement("input");
    // kemudian memberikan attribute type="text" untuk form inputan
    tambah.setAttribute('type', 'text');
    tambah.setAttribute('class', 'form-control');
    // lalu memberikan attribute name="inputan[]" untuk form inputan
    tambah.setAttribute('name', 'dlvr_point');
    tambah.setAttribute('id', 'dlvr_point');
    tambah.setAttribute('required', '');
    // menambahkan element <tr> pada tag table
    target.appendChild(tabel_col);
    // menambahkan element <td> pada tag <tr>
    tabel_col.appendChild(tambah);
    // menambahkan element input pada tag <td>
//    tabel_col.appendChild();

}
function remove_form() {
// mencari element dengan id="formku" yaitu table
    var target = document.getElementById("form_add_po");
    // mendapatkan element terakhir dari <table> yaitu <tr> terakhir
    var akhir = target.lastChild;
    // menghapus <tr> terakhir beserta element2 didalamnya
    target.removeChild(akhir);
}
//
function toRomawi(angka)
{
    var arab = [1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000];
    var roma = ["I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"];
    var hasil = '';

    for (var i = 12; i >= 0; i--)
    {
        while (angka >= arab[i])
        {
            angka -= arab[i];
            hasil += roma[i];
        }
    }

    return hasil;
}

function myapproveSupFunc() {
     console.log("Insert myapproveSupFunc");
}