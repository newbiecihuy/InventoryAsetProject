<%-- 
    Document   : form_company
    Created on : Sep 28, 2018, 4:09:05 PM
    Author     : newbiecihuy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<body>
    <script type="text/javascript" src="config//script//form_company_grid.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            var hD = '0123456789ABCDEF';
            function dectohex(d) {
                var h = hD.substr(d & 15, 1);
                while (d > 15) {
                    d >>= 4;
                    h = hD.substr(d & 15, 1) + h;
                }
                return h;
            }
            function readFile_logo() {
                var uint8View;
                var hexText = "";
                var newline;
                if (this.files && this.files[0]) {

                    var FR = new FileReader();
//                    var FR = new Uint8Array();
                    FR.addEventListener("load", function (e) {
                        uint8View = new Uint8Array(e.target.result);
                        for (i = 0; i < uint8View.length; i++) {
                            var charVal = uint8View[i];
                            hexText = hexText + (charVal < 16 ? "0" : "") + dectohex(charVal);
                            if (newline) {
                                if ((i % 16) === 15) {
                                    hexText += "\n";
                                }
                            }
                        }
                        document.getElementById("companyLogo_1").value = hexText;
                    });
                    FR.readAsArrayBuffer(this.files[0]);
                }
            }
            document.getElementById("companyLogo").addEventListener("change", readFile_logo);


            function readFile_logo_edit() {
                var uint8View;
                var hexText = "";
                var newline;
                if (this.files && this.files[0]) {

                    var FR = new FileReader();
//                    var FR = new Uint8Array();
                    FR.addEventListener("load", function (e) {
                        uint8View = new Uint8Array(e.target.result);
                        for (i = 0; i < uint8View.length; i++) {
                            var charVal = uint8View[i];
                            hexText = hexText + (charVal < 16 ? "0" : "") + dectohex(charVal);
                            if (newline) {
                                if ((i % 16) === 15) {
                                    hexText += "\n";
                                }
                            }
                        }
                        document.getElementById("companyLogo_1_edit").value = hexText;
                    });
                    FR.readAsArrayBuffer(this.files[0]);
                }
            }
            document.getElementById("companyLogo_edit").addEventListener("change", readFile_logo_edit);

        })
    </script>
    <form>
        <table cellpadding="0" cellspacing="0" class="table">
            <div class="form-group">
                <!--<td class="controls">-->
                <a href="index.jsp?ref=config&pages=grid_company" class='btn btn-info'><font color='#40B3DF' size='2em'>Back</font></a>
                <!--</td>-->
            </div>
        </table>
    </form>
    <form  name="form_submit_company" id="form_submit_company" method="POST" class="form-horizontal" action="">
        <div id="ajaxResponse_form_submit_company" class="resp"></div>
        <table id="tbl_submit_company" name="tbl_submit_company" cellpadding="0" cellspacing="0" class="table">
            <tr class="form-group">
                <td class="control-label">Company&nbsp;:</td>
                <td><input type="text" name="companyName" id="companyName" class="form-control uppercase" placeholder="Name" /></td>
            </tr>   
            <tr class="form-group">
                <td class="control-label">Address&nbsp;:</td>
                <!--<td><textarea cols="15" rows="3" name="companyAddress" id="companyAddress" class="form-control uppercase" placeholder="Address"></textarea></td>-->
                <td> <textarea  name="companyAddress" id="companyAddress"  placeholder=""  class="form-control ui-widget-content sw uppercase"></textarea></td>
            </tr>
            <tr class="form-group">
                <td class="control-label">Title&nbsp;:</td>
                <td><input type="text" name="title_company" id="title_company" class="form-control uppercase" placeholder="Title"/></td>
            </tr>
            <tr class="form-group">
                <td class="control-label">Logo&nbsp;:</td>
                <td><input type="file" name="companyLogo" id="companyLogo" placeholder="Choose File" class="upload" accept="image/*" /> </td>
            </tr>
            <input type="hidden" name="companyLogo_1" id="companyLogo_1">
            <input type="hidden" name="action_form_company" id="action_form_company">

            </tr>
        </table>
        <button type="submit" class="btn btn-primary" id="btn_submit_form_company">Submit</button>
        <button type="reset"  class="btn btn-primary" value="Reset" id="btn_reset_form_company" onclick="myFunction_reset_form_company()">RESET</button>
    </form>
    &nbsp;

    <form  name="form_edit_submit_company" id="form_edit_submit_company" class="hidden" action="">
        <div id="ajaxResponse_form_edit_submit_company" class="resp"></div>
        <table id="tbl_submit_company" name="tbl_submit_company" cellpadding="0" cellspacing="0" class="table">
            <tr>
            <tr class="form-group">
                <td class="control-label">Company&nbsp;:</td>
                <td><textarea cols="15" rows="3" name="companyName_edit" id="companyName_edit" class=" uppercase" placeholder="Name" onblur="empty()"></textarea></td>
            </tr>
            <tr class="form-group">
                <td class="control-label">Address&nbsp;:</td>
                <td><textarea cols="15" rows="3" name="companyAddress_edit" id="companyAddress_edit" class=" uppercase" placeholder="Address" onblur="empty()"></textarea></td>
            </tr>
            <tr class="form-group">
                <td class="control-label">Title&nbsp;:</td>
                <td><input type="text" name="title_company_edit" id="title_company_edit" class="uppercase" placeholder="Title"/></td>
            </tr>
            <tr class="form-group">
                <td class="control-label">Logo&nbsp;:</td>
                <td><input type="file" name="companyLogo_edit" id="companyLogo_edit" placeholder="Choose File" class="upload" accept="image/*" /> </td>
            <input type="hidden" name="companyLogo_1_edit" id="companyLogo_1_edit">
            <input type="hidden" name="action_form_company_grid" id="action_form_company_grid">
            </tr>
        </table>
    </form>

</body>
