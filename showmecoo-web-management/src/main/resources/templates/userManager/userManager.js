$(function(){
	
	userNavInit();
	userFormInit();
	userModalFormInit();

	//模态页面加载完成后回调事件
	$('#useInfoModal').on('shown.bs.modal',function(){
		userModalDataInit();
	})
});

umPage = {
	modalType:"",
	modalField:["username","password","phone","email","rolename"
		,"openid","createdate","lastlogindate"]
};

function userNavInit(){
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
	var options = {data:a,parentId:"nav-content",mainPage:"userManager.html"}
	var b = new Nav(options);
}

function userFormInit(){
	var formData = {action:"#",childNodes:[
		{field:"username",name:"用户名",childNodes:[
		  {type:"label",style:"margin-top:5px;"},{type:"text"}
		]},
		{field:"phone",name:"手机号码",childNodes:[
		  {type:"label",style:"margin-top:5px;"},{type:"text"}
		]},
		{field:"email",name:"邮箱",childNodes:[
		  {type:"label",style:"margin-top:5px;"},{type:"text"}
		]},
		{field:"openid",name:"微信id",childNodes:[
		  {type:"label",style:"margin-top:5px;"},{type:"text"}
		]},
		{field:"createdate",name:"注册时间",childNodes:[
		  {type:"label",style:"margin-top:5px;"},{type:"datetime"}
		]},
		{field:"lastlogindate",name:"最后登陆时间",childNodes:[
		  {type:"label",style:"margin-top:5px;"},{type:"datetime"}
		]},
		{field:"button",name:"查询",childNodes:[
		  {type:"button",style:"margin-top:5px;",onclick:"searchUserData()"}
		]}
	]}
	var c = new FormUI({parentId:"userForm",id:"ufContent",data:formData});
}

function userModalFormInit(){
	var formData = {childNodes:[
		{field:"username",name:"用户名",childNodes:[
		  {type:"label",style:"margin-top:5px;"},{type:"text"}
		]},
		{field:"password",name:"密码",childNodes:[
		  {type:"label",style:"margin-top:5px;"},{type:"text"}
		]},
		{field:"phone",name:"手机号码",childNodes:[
		  {type:"label",style:"margin-top:5px;"},{type:"text"}
		]},
		{field:"email",name:"邮箱",childNodes:[
		  {type:"label",style:"margin-top:5px;"},{type:"text"}
		]},
		{field:"rolename",name:"角色名",childNodes:[
		  {type:"label",style:"margin-top:5px;"},{type:"text"}
		]},
		{field:"openid",name:"微信id",childNodes:[
		  {type:"label",style:"margin-top:5px;"},{type:"text"}
		]},
		{field:"createdate",name:"注册时间",childNodes:[
		  {type:"label",style:"margin-top:5px;"},{type:"datetime"}
		]},
		{field:"lastlogindate",name:"最后登陆时间",childNodes:[
		  {type:"label",style:"margin-top:5px;"},{type:"datetime"}
		]}
	]}
	var c1 = new FormUI({parentId:"userModalForm",id:"umfContent",data:formData});
}

function userTableDataInit(data){
	var arr = {pager:{totalCount:10,id:"datatable_paginate"},
	data:[{username:"1",password:"2",phone:"3",email:"4",roleid:"5"}
	,{username:"11",password:"12",phone:"13",email:"14",roleid:"15"}
	,{username:"21",password:"22",phone:"23",email:"24",roleid:"25"}
	,{username:"21fda",password:"224132",phone:"vc23",email:"2r4",roleid:"25f"}]};

	var table = TABLE_STATIC.get("userTable");
	table.setData(arr);
}

function userModalDataInit(){
	var formObj = FormUI_STATIC.get("umfContent");
	formObj.resetTextData(umPage.modalField);
	
	var table = TABLE_STATIC.get("userTable");
	var rows = table.getSelectRows();
	if(rows && rows[0]){
		var data = rows[0]["data"];
		var formObj = FormUI_STATIC.get("umfContent");
		formObj.setTextData(data);
	}

	if(umPage.modalType == "add"){
		addUser();
	}
}

function searchUserData(){
	var formObj = FormUI_STATIC.get("ufContent");
	var arr = formObj.getTextData(umPage.modalField);
	var passData = {data:arr,type:"search"}
	userTableDataInit();
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
	var formObj = FormUI_STATIC.get("umfContent");
	var arr = formObj.getTextData(umPage.modalField);
	var passData = {data:arr,type:umPage.modalType}
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
	umPage.modalType = "";
}

function resetModal(){
	var formObj = FormUI_STATIC.get("umfContent");
	formObj.resetTextData(umPage.modalField);
}

function addUser(){
	umPage.modalType = "add";
	var formObj = FormUI_STATIC.get("umfContent");
	if(formObj && formObj.resetTextData){
		formObj.resetTextData(umPage.modalField);
	}
}

function editUser(){
	umPage.modalType = "edit";
}

function delUser(){
	var table = TABLE_STATIC.get("userTable");
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

