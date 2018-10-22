/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * https://www.w3schools.com/howto/tryit.asp?filename=tryhow_js_form_steps
 */
//$(document).ready(function () {
var currentTab = 0; // Current tab is set to be the first tab (0)
showTab(currentTab); // Display the current tab

function showTab(n) {
    // This function will display the specified tab of the form ...

    var x = document.getElementsByClassName("tab");
//        for (var n = 0; n < x.length; n += 1) {
    x[n].style.display = "block";

    // ... and fix the Previous/Next buttons:
    if (n === 0) {
        document.getElementById("prevBtn").style.display = "none";
    } else {
        document.getElementById("prevBtn").style.display = "inline";
    }
    if (n === (x.length - 1)) {
        document.getElementById("nextBtn").innerHTML = "Submit";
        document.getElementById("nextBtn").onclick = foo2;
    } else {
        document.getElementById("nextBtn").innerHTML = "Next";
//        document.getElementById('nextBtn').onclick = null;
    }
    // ... and run a function that displays the correct step indicator:
    fixStepIndicator(n);
//        }

}

function nextPrev(n) {
    // This function will figure out which tab to display
    var x = document.getElementsByClassName("tab");
    // Exit the function if any field in the current tab is invalid:
    if (n === 1 && !validateForm())
        return false;
    // Hide the current tab:
    x[currentTab].style.display = "none";
    // Increase or decrease the current tab by 1:
    currentTab = currentTab + n;
    // if you have reached the end of the form... :
    if (currentTab >= x.length) {
        //...the form gets submitted:
        document.getElementById("form_add_po").submit();
        return false;
    }
    // Otherwise, display the correct tab:
    showTab(currentTab);
}

function validateForm() {
    // This function deals with validation of the form fields
    var x, y, i, valid = true;
    x = document.getElementsByClassName("tab");
    y = x[currentTab].getElementsByTagName("input");
    // A loop that checks every input field in the current tab:
    for (i = 0; i < y.length; i++) {
        // If a field is empty...
        if (document.getElementById("supplier_name_po").value === "") {
            y[i].className += " invalid";
            valid = false;
        }
        if (document.getElementById("supplier_code").value === "") {
            y[i].className += " invalid";
            valid = false;
        }
//        if (document.getElementById("po_type").value === "") {
//            y[i].className += " invalid";
//            valid = false;
//        }
//        if (document.getElementById("payment_term").value === "") {
//            y[i].className += " invalid";
//            valid = false;
//        }

//        var k = document.getElementById("delivery_term").value;
//        if (k === "0") {
//            y[i].className += " invalid";
//            valid = false;
//        }
//        if (k === "") {
//            y[i].className += " invalid";
//            valid = false;
//        }
//        if (isNaN(k))
//        {
//            y[i].className += " invalid";
//            valid = false;
//        }
//            if (y[i].value === "") {
//                // add an "invalid" class to the field:
//                y[i].className += " invalid";
//                // and set the current valid status to false:
//                valid = false;
//            }
    }
    // If the valid status is true, mark the step as finished and valid:
    if (valid) {
        document.getElementsByClassName("step")[currentTab].className += " finish";
    }
    return valid; // return the valid status
}

function fixStepIndicator(n) {
    // This function removes the "active" class of all steps...
    var i, x = document.getElementsByClassName("step");
    for (i = 0; i < x.length; i++) {
        x[i].className = x[i].className.replace(" active", "");
    }
    //... and adds the "active" class to the current step:
    x[n].className += " active";
}

//});
function foo2() {
//    alert("HELLO WORLD");
//    alert(JSON.stringify($('#form_add_po').serializeObject()));
//    console.log(JSON.stringify($('#form_add_po').serializeObject()));
    
}