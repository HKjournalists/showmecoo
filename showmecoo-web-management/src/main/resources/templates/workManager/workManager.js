$(function(){
	
	workNavInit();
	workFormInit();
	workModalFormInit();

	//模态页面加载完成后回调事件
	$('#workInfoModal').on('shown.bs.modal',function(){
		workModalDataInit();
	})
});

wmPage = {
	modalType:"",
	modalField:["name","work_name","recommend_level","work_upload_name","visit_num"
		,"create_time","update_time","brief_introduction"]
};

function workNavInit(){
	//菜单测试数据
	var a = {menus:[{name:"用户管理",childMenus:[
	  {name:"用户管理",href:"../userManager/userManager.html"},
	  {name:"微信用户管理",href:"../userManager/wechatUserManager.html"},
	  {name:"角色管理",href:"../userManager/roleManager.html"},
	  {name:"用户角色管理",href:"../userManager/userRoleManager.html"}]},
	  {name:"艺人管理",childMenus:[{name:"艺人管理",href:"../actorManager/actorManager.html"}]},
	  {name:"作品管理",childMenus:[{name:"作品管理",href:"../workManager/workManager.html"}]},
	  {name:"订单管理",childMenus:[{name:"订单管理",href:"../orderManager/orderManager.html"}]}
	  ]};
	var options = {data:a,parentId:"nav-content",mainPage:"workManager.html"}
	var b = new Nav(options);
}

function workFormInit(){
	var formData = {action:"#",childNodes:[
		{field:"name",name:"艺人姓名",childNodes:[
		  {type:"label",style:"margin-top:5px;"},{type:"text"}
		]},
		{field:"nick_name",name:"艺人艺名",childNodes:[
		  {type:"label",style:"margin-top:5px;"},{type:"text"}
		]},
		{field:"button",name:"查询",childNodes:[
		  {type:"button",style:"margin-top:5px;",onclick:"searchWorkData()"}
		]}
	]}
	var c = new FormUI({parentId:"workForm",id:"wfContent",data:formData});
}

function workModalFormInit(){
	var formData = {childNodes:[
		{field:"name",name:"艺人名称",childNodes:[
		  {type:"label",style:"margin-top:5px;"},{type:"text"}
		]},
		{field:"work_name",name:"作品名称",childNodes:[
		  {type:"label",style:"margin-top:5px;"},{type:"text"}
		]},
		{field:"recommend_level",name:"推荐指数",childNodes:[
		  {type:"label",style:"margin-top:5px;"},{type:"text"}
		]},
		{field:"work_upload_name",name:"上传作品名称",childNodes:[
		  {type:"label",style:"margin-top:5px;"},{type:"text"}
		]},
		{field:"visit_num",name:"查看次数",childNodes:[
		  {type:"label",style:"margin-top:5px;"},{type:"text"}
		]},
		{field:"create_time",name:"上传时间",childNodes:[
		  {type:"label",style:"margin-top:5px;"},{type:"datetime"}
		]},
		{field:"update_time",name:"更新时间",childNodes:[
		  {type:"label",style:"margin-top:5px;"},{type:"datetime"}
		]},
		{field:"brief_introduction",name:"作品简介",childNodes:[
		  {type:"label",style:"margin-top:5px;"},{type:"text"}
		]}
	]}
	var c1 = new FormUI({parentId:"workModalForm",id:"wmfContent",data:formData});
}

function workTableDataInit(data){
	var arr = {pager:{totalCount:10,id:"datatable_paginate"},
	data:[{name:"1",password:"2",phone:"3",email:"4",roleid:"5"}
	,{name:"11",password:"12",phone:"13",email:"14",roleid:"15"}
	,{name:"21",password:"22",phone:"23",email:"24",roleid:"25"}
	,{name:"21fda",password:"224132",phone:"vc23",email:"2r4",roleid:"25f"}]};

	var table = TABLE_STATIC.get("workTable");
	table.setData(arr);
}

function workModalDataInit(){
	var formObj = FormUI_STATIC.get("wmfContent");
	formObj.resetTextData(wmPage.modalField);
	
	var table = TABLE_STATIC.get("workTable");
	var rows = table.getSelectRows();
	if(rows && rows[0]){
		var data = rows[0]["data"];
		var formObj = FormUI_STATIC.get("wmfContent");
		formObj.setTextData(data);
	}

	if(wmPage.modalType == "add"){
		addWork();
	}
}

function searchWorkData(){
	var formObj = FormUI_STATIC.get("wfContent");
	var arr = formObj.getTextData(wmPage.modalField);
	var passData = {data:arr,type:"search"}
	workTableDataInit();
/*
	bsui.ajax({
		url:'test.txt',
		data:passData,
		type:'POST',
		async:false,
		success:function(data){
			//userTableDataInit(data);
		}
	});*/
}

//修改保存
function closeModal(){
	var formObj = FormUI_STATIC.get("wmfContent");
	var arr = formObj.getTextData(wmPage.modalField);
	var passData = {data:arr,type:wmPage.modalType}
	/*
	bsui.ajax({
		url:'test.txt',
		data:passData,
		type:'POST',
		async:false,
		success:function(data){
			//alert(bsui.encode(data));
		}
	});*/
	wmPage.modalType = "";
}

function resetModal(){
	var formObj = FormUI_STATIC.get("wmfContent");
	formObj.resetTextData(wmPage.modalField);
}

function addWork(){
	wmPage.modalType = "add";
	var formObj = FormUI_STATIC.get("wmfContent");
	if(formObj && formObj.resetTextData){
		formObj.resetTextData(wmPage.modalField);
	}
}

function editWork(){
	wmPage.modalType = "edit";
}

function delWork(){
	var table = TABLE_STATIC.get("workTable");
	var rows = table.getSelectRows();
	var passData = {data:rows,type:"del"}
	/*
	bsui.ajax({
		url:'test.txt',
		data:passData,
		type:'POST',
		async:false,
		success:function(data){
			//alert(bsui.encode(data));
		}
	});*/
}

