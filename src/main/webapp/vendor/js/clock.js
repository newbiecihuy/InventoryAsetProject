/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/* Visit http://www.yaldex.com/ for full source code
 and get more free JavaScript, CSS and DHTML scripts! */
/* global Begin */

//<!-- Begin
//    var timerID = null;
//    var timerRunning = false;
//    function stopclock (){
//        if(timerRunning)
//            clearTimeout(timerID);
//        timerRunning = false;
//    }
//    function showtime () {
//        var now = new Date();
//        var hours = now.getHours();
//        var minutes = now.getMinutes();
//        var seconds = now.getSeconds()
//        var timeValue = "" + ((hours >12) ? hours -12 :hours)
//        if (timeValue === "0") timeValue = 12;
//        timeValue += ((minutes < 10) ? ":0" : ":") + minutes
//        timeValue += ((seconds < 10) ? ":0" : ":") + seconds
//        timeValue += (hours >= 12) ? " P.M." : " A.M."
//        document.clock.face.value = timeValue;
//        timerID = setTimeout("showtime()",1000);
//        timerRunning = true;
//    }
//    function startclock() {
//        stopclock();
//        showtime();
//    }
//    window.onload=startclock;
// End -->

//   function digclock()
//{
//	var d = new Date()
//	var t = d.toLocaleTimeString()
//	
//	document.getElementById("clock").innerHTML = t
//}
//
//setInterval(function(){digclock()},1000)
function digclock() {
    var currentTime = new Date();
    // Operating System Clock Hours for 12h clock
    var currentHoursAP = currentTime.getHours();
    // Operating System Clock Hours for 24h clock
    var currentHours = currentTime.getHours();
    // Operating System Clock Minutes
    var currentMinutes = currentTime.getMinutes();
    // Operating System Clock Seconds
    var currentSeconds = currentTime.getSeconds();
    // Adding 0 if Minutes & Seconds is More or Less than 10
    currentMinutes = (currentMinutes < 10 ? "0" : "") + currentMinutes;
    currentSeconds = (currentSeconds < 10 ? "0" : "") + currentSeconds;
    // Picking "AM" or "PM" 12h clock if time is more or less than 12
    var timeOfDay = (currentHours < 12) ? "AM" : "PM";
    // transform clock to 12h version if needed
    currentHoursAP = (currentHours > 12) ? currentHours - 12 : currentHours;
    // transform clock to 12h version after mid night
    currentHoursAP = (currentHoursAP === 0) ? 12 : currentHoursAP;
    // display first 24h clock and after line break 12h version
    var currentTimeString = currentHours + ":" + currentMinutes + ":" + currentSeconds;
    // print clock js in div #clock.
//    $("#clock").html(currentTimeString);}
    document.getElementById("clock").innerHTML = currentTimeString;
}

setInterval(function () {
    digclock()
}, 1000)
