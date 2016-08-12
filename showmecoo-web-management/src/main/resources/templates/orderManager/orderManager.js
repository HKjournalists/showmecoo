$(function(){
	
	orderNavInit();
	orderFormInit();
	orderModalFormInit();

	//模态页面加载完成后回调事件
	$('#orderInfoModal').on('shown.bs.modal',function(){
		orderModalDataInit();
	})
});

omPage = {
	modalType:"",
	modalField:["link_name","phone","show_addr","show_date","show_fee"
		,"request_mark","create_date","modify_date","username","nickname"]
};

function orderNavInit(){
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
	var options = {data:a,parentId:"nav-content",mainPage:"orderManager.html"}
	var b = new Nav(options);
}

function orderFormInit(){
	var formData = {action:"#",childNodes:[
		{field:"link_name",name:"联系人姓名",childNodes:[
		  {type:"label",style:"margin-top:5px;"},{type:"text"}
		]},
		{field:"phone",name:"手机号码",childNodes:[
		  {type:"label",style:"margin-top:5px;"},{type:"text"}
		]},
		{field:"show_date",name:"演出时间",childNodes:[
		  {type:"label",style:"margin-top:5px;"},{type:"datetime"}
		]},
		{field:"username",name:"用户名",childNodes:[
		  {type:"label",style:"margin-top:5px;"},{type:"text"}
		]},
		{field:"nickname",name:"微信昵称",childNodes:[
		  {type:"label",style:"margin-top:5px;"},{type:"datetime"}
		]},
		{field:"button",name:"查询",childNodes:[
		  {type:"button",style:"margin-top:5px;",onclick:"searchOrderData()"}
		]}
	]}
	var c = new FormUI({parentId:"orderForm",id:"ofContent",data:formData});
}

function orderModalFormInit(){
	var formData = {childNodes:[
		{field:"link_name",name:"联系人姓名",childNodes:[
		  {type:"label",style:"margin-top:5px;"},{type:"text"}
		]},
		{field:"phone",name:"联系电话",childNodes:[
		  {type:"label",style:"margin-top:5px;"},{type:"text"}
		]},
		{field:"show_addr",name:"演出地址",childNodes:[
		  {type:"label",style:"margin-top:5px;"},{type:"text"}
		]},
		{field:"show_date",name:"演出时间",childNodes:[
		  {type:"label",style:"margin-top:5px;"},{type:"text"}
		]},
		{field:"show_fee",name:"预计演出金额",childNodes:[
		  {type:"label",style:"margin-top:5px;"},{type:"text"}
		]},
		{field:"request_mark",name:"演出需求",childNodes:[
		  {type:"label",style:"margin-top:5px;"},{type:"text"}
		]},
		{field:"username",name:"下单人用户",childNodes:[
		  {type:"label",style:"margin-top:5px;"},{type:"text"}
		]},
		{field:"nickname",name:"下单人微信",childNodes:[
		  {type:"label",style:"margin-top:5px;"},{type:"text"}
		]},
		{field:"create_date",name:"定单创建时间",childNodes:[
		  {type:"label",style:"margin-top:5px;"},{type:"datetime"}
		]},
		{field:"modify_date",name:"订单修改时间",childNodes:[
		  {type:"label",style:"margin-top:5px;"},{type:"datetime"}
		]},
		{field:"modify_username",name:"订单修改人",childNodes:[
		  {type:"label",style:"margin-top:5px;"},{type:"text"}
		]}
	]}
	var c1 = new FormUI({parentId:"orderModalForm",id:"omfContent",data:formData});
}

function orderTableDataInit(data){
	var arr = {pager:{totalCount:10,id:"datatable_paginate"},
	data:[{username:"1",password:"2",phone:"3",email:"4",roleid:"5"}
	,{username:"11",password:"12",phone:"13",email:"14",roleid:"15"}
	,{username:"21",password:"22",phone:"23",email:"24",roleid:"25"}
	,{username:"21fda",password:"224132",phone:"vc23",email:"2r4",roleid:"25f"}]};

	var table = TABLE_STATIC.get("orderTable");
	table.setData(arr);
}

function orderModalDataInit(){
	var formObj = FormUI_STATIC.get("omfContent");
	formObj.resetTextData(omPage.modalField);
	
	var table = TABLE_STATIC.get("orderTable");
	var rows = table.getSelectRows();
	if(rows && rows[0]){
		var data = rows[0]["data"];
		var formObj = FormUI_STATIC.get("omfContent");
		formObj.setTextData(data);
	}

	if(omPage.modalType == "add"){
		addOrder();
	}
}

function searchOrderData(){
	var formObj = FormUI_STATIC.get("ofContent");
	var arr = formObj.getTextData(omPage.modalField);
	var passData = {data:arr,type:"search"}
	orderTableDataInit();
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
	var formObj = FormUI_STATIC.get("omfContent");
	var arr = formObj.getTextData(omPage.modalField);
	var passData = {data:arr,type:omPage.modalType}
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
	omPage.modalType = "";
}

function resetModal(){
	var formObj = FormUI_STATIC.get("omfContent");
	formObj.resetTextData(omPage.modalField);
}

function addOrder(){
	omPage.modalType = "add";
	var formObj = FormUI_STATIC.get("omfContent");
	if(formObj && formObj.resetTextData){
		formObj.resetTextData(omPage.modalField);
	}
}

function editOrder(){
	omPage.modalType = "edit";
}

function delOrder(){
	var table = TABLE_STATIC.get("orderTable");
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



