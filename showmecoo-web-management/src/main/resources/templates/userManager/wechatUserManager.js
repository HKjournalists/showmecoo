$(function(){
  
  wechatUserNavInit();
  wechatUserFormInit();
  wechatUserModalFormInit();

  //模态页面加载完成后回调事件
  $('#wechatUserInfoModal').on('shown.bs.modal',function(){
    wechatUserModalDataInit();
  })
});

wumPage = {
  modalType:"",
  modalField:["username","nickname","sex","city","country"
    ,"language","subscribe_time","remark","headimgurl"]
};

function wechatUserNavInit(){
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
  var options = {data:a,parentId:"nav-content",mainPage:"wechatUserManager.html"}
  var b = new Nav(options);
}

function wechatUserFormInit(){
  var formData = {action:"#",childNodes:[
    {field:"nickname",name:"微信昵称",childNodes:[
      {type:"label",style:"margin-top:5px;"},{type:"text"}
    ]},
    {field:"username",name:"用户名",childNodes:[
      {type:"label",style:"margin-top:5px;"},{type:"text"}
    ]},
    {field:"subscribe_time",name:"关注时间",childNodes:[
      {type:"label",style:"margin-top:5px;"},{type:"datetime"}
    ]},
    {field:"button",name:"查询",childNodes:[
      {type:"button",style:"margin-top:5px;",onclick:"searchWechatUserData()"}
    ]}
  ]}
  var c = new FormUI({parentId:"wechatUserForm",id:"wufContent",data:formData});
}

function wechatUserModalFormInit(){
  var formData = {childNodes:[
    {field:"username",name:"用户名",childNodes:[
      {type:"label",style:"margin-top:5px;"},{type:"text"}
    ]},
    {field:"nickname",name:"微信昵称",childNodes:[
      {type:"label",style:"margin-top:5px;"},{type:"text"}
    ]},
    {field:"sex",name:"性别",childNodes:[
      {type:"label",style:"margin-top:5px;"},{type:"text"}
    ]},
    {field:"city",name:"城市",childNodes:[
      {type:"label",style:"margin-top:5px;"},{type:"text"}
    ]},
    {field:"country",name:"国家",childNodes:[
      {type:"label",style:"margin-top:5px;"},{type:"text"}
    ]},
    {field:"language",name:"语言",childNodes:[
      {type:"label",style:"margin-top:5px;"},{type:"text"}
    ]},
    {field:"subscribe_time",name:"关注时间",childNodes:[
      {type:"label",style:"margin-top:5px;"},{type:"datetime"}
    ]},
    {field:"remark",name:"备注",childNodes:[
      {type:"label",style:"margin-top:5px;"},{type:"text"}
    ]},
    {field:"headimgurl",name:"头像url",childNodes:[
      {type:"label",style:"margin-top:5px;"},{type:"text"}
    ]}
  ]}
  var c1 = new FormUI({parentId:"wechatUserModalForm",id:"wumfContent",data:formData});
}

function wechatUserTableDataInit(data){
  var arr = {pager:{totalCount:10,id:"datatable_paginate"},
  data:[{username:"1",password:"2",phone:"3",email:"4",roleid:"5"}
  ,{username:"11",password:"12",phone:"13",email:"14",roleid:"15"}
  ,{username:"21",password:"22",phone:"23",email:"24",roleid:"25"}
  ,{username:"21fda",password:"224132",phone:"vc23",email:"2r4",roleid:"25f"}]};

  var table = TABLE_STATIC.get("wechatUserTable");
  table.setData(arr);
}

function wechatUserModalDataInit(){
  var formObj = FormUI_STATIC.get("wumfContent");
  formObj.resetTextData(wumPage.modalField);
  
  var table = TABLE_STATIC.get("wechatUserTable");
  var rows = table.getSelectRows();
  if(rows && rows[0]){
    var data = rows[0]["data"];
    var formObj = FormUI_STATIC.get("wumfContent");
    formObj.setTextData(data);
  }

  if(wumPage.modalType == "add"){
    addWechatUser();
  }
}

function searchWechatUserData(){
  var formObj = FormUI_STATIC.get("wufContent");
  var arr = formObj.getTextData(["username","nickname","subscribe_time"]);
  var passData = {data:arr,type:"search"}
  wechatUserTableDataInit();
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
  var formObj = FormUI_STATIC.get("wumfContent");
  var arr = formObj.getTextData(wumPage.modalField);
  var passData = {data:arr,type:wumPage.modalType}
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
  wumPage.modalType = "";
}

function resetModal(){
  var formObj = FormUI_STATIC.get("wumfContent");
  formObj.resetTextData(wumPage.modalField);
}

function addWechatUser(){
  wumPage.modalType = "add";
  var formObj = FormUI_STATIC.get("wumfContent");
  if(formObj && formObj.resetTextData){
    formObj.resetTextData(wumPage.modalField);
  }
}

function editWechatUser(){
  wumPage.modalType = "edit";
}

function delWechatUser(){
  var table = TABLE_STATIC.get("wechatUserTable");
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
