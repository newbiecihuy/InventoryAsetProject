/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(function() {
  
  var $contextMenu = $("#contextMenu");
  
  $("body").on("contextmenu", "table tr", function(e) {
    $contextMenu.css({
      display: "block",
      left: e.pageX,
      top: e.pageY
    });
    return false;
  });
  
  $contextMenu.on("click", "a", function() {
     $contextMenu.hide();
  });
  
});