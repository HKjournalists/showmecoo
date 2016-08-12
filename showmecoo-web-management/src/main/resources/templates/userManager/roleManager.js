$(function(){
	
	roleNavInit();
	roleFormInit();
	roleModalFormInit();

	//模态页面加载完成后回调事件
	$('#roleInfoModal').on('shown.bs.modal',function(){
		roleModalDataInit();
	})
});

rmPage = {
	modalType:"",
	modalField:["rolename","roledesc","create_username","update_username"
		,"createdate","modifydate"]
};

function roleNavInit(){
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
	var options = {data:a,parentId:"nav-content",mainPage:"roleManager.html"}
	var b = new Nav(options);
}

function roleFormInit(){
	var formData = {action:"#",childNodes:[
		{field:"rolename",name:"角色名",childNodes:[
		  {type:"label",style:"margin-top:5px;"},{type:"text"}
		]},
		{field:"button",name:"查询",childNodes:[
		  {type:"button",style:"margin-top:5px;",onclick:"searchRoleData()"}
		]}
	]}
	var c = new FormUI({parentId:"roleForm",id:"rfContent",data:formData});
}

function roleModalFormInit(){
	var formData = {childNodes:[
		{field:"rolename",name:"角色名",childNodes:[
		  {type:"label",style:"margin-top:5px;"},{type:"text"}
		]},
		{field:"roledesc",name:"角色描述",childNodes:[
		  {type:"label",style:"margin-top:5px;"},{type:"text"}
		]},
		{field:"create_username",name:"创建者名称",childNodes:[
		  {type:"label",style:"margin-top:5px;"},{type:"text"}
		]},
		{field:"update_username",name:"修改者名称",childNodes:[
		  {type:"label",style:"margin-top:5px;"},{type:"text"}
		]},
		{field:"createdate",name:"创建时间",childNodes:[
		  {type:"label",style:"margin-top:5px;"},{type:"datetime"}
		]},
		{field:"modifydate",name:"修改时间",childNodes:[
		  {type:"label",style:"margin-top:5px;"},{type:"datetime"}
		]}
	]}
	var c1 = new FormUI({parentId:"roleModalForm",id:"rmfContent",data:formData});
}

function roleTableDataInit(data){
	var arr = {pager:{totalCount:10,id:"datatable_paginate"},
	data:[{rolename:"1",roledesc:"2",create_username:"3",email:"4",roleid:"5"}
	,{rolename:"11",roledesc:"12",create_username:"13",email:"14",roleid:"15"}
	,{rolename:"21",roledesc:"22",create_username:"23",email:"24",roleid:"25"}
	,{rolename:"21fda",roledesc:"224132",create_username:"vc23",email:"2r4",roleid:"25f"}]};

	var table = TABLE_STATIC.get("roleTable");
	table.setData(arr);
}

function roleModalDataInit(){
	var formObj = FormUI_STATIC.get("rmfContent");
	formObj.resetTextData(rmPage.modalField);
	
	var table = TABLE_STATIC.get("roleTable");
	var rows = table.getSelectRows();
	if(rows && rows[0]){
		var data = rows[0]["data"];
		var formObj = FormUI_STATIC.get("rmfContent");
		formObj.setTextData(data);
	}

	if(rmPage.modalType == "add"){
		addRole();
	}
}

function searchRoleData(){
	var formObj = FormUI_STATIC.get("rfContent");
	var arr = formObj.getTextData(["rolename"]);
	var passData = {data:arr,type:"search"}
	roleTableDataInit();
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
	var formObj = FormUI_STATIC.get("rmfContent");
	var arr = formObj.getTextData(rmPage.modalField);
	var passData = {data:arr,type:rmPage.modalType}
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
	rmPage.modalType = "";
}

function resetModal(){
	var formObj = FormUI_STATIC.get("rmfContent");
	formObj.resetTextData(rmPage.modalField);
}

function addRole(){
	debugger;
	rmPage.modalType = "add";
	var formObj = FormUI_STATIC.get("rmfContent");
	if(formObj && formObj.resetTextData){
		formObj.resetTextData(rmPage.modalField);
	}
}

function editRole(){
	rmPage.modalType = "edit";
}

function delRole(){
	var table = TABLE_STATIC.get("roleTable");
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