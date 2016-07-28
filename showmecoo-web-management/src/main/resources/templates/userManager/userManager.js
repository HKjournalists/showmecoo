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
	var arr = [{username:"1",password:"2",phone:"3",email:"4",roleid:"5"}
		,{username:"11",password:"12",phone:"13",email:"14",roleid:"15"}
		,{username:"21",password:"22",phone:"23",email:"24",roleid:"25"}
		,{username:"21fda",password:"224132",phone:"vc23",email:"2r4",roleid:"25f"}];

	var table = TABLE_STATIC.get("userTable");

	table.setData(arr);
	var data = table.getDataByRowIndex(2);
	



	//test
	$('#useInfoModal').on('hide.bs.modal',function(){

	})

	$(document).on('click', '[data-toggle="modal"]', function (e) {
		
	})
});