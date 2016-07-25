+function ($) {
  // TABLE CLASS DEFINITION
  // ======================
  var TABLE = function (element, options) {

  };
  
}(jQuery);


var tableClicTrkMap = {};
function tableClick(a){
	for(var i in tableClicTrkMap){
		if(document.getElementById(i))
			document.getElementById(i).className = "";
		delete tableClicTrkMap[i];
	}
	if(document.getElementById(a.id))
		document.getElementById(a.id).className = "warning";
	tableClicTrkMap[a.id] = "";
}            

$(function(){
	debugger;
	$('#useInfoModal').on('hide.bs.modal',function(){
		debugger;
	})

	$(document).on('click', '[data-toggle="modal"]', function (e) {
		//alert(2);
	})
});