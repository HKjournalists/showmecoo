/**
 * 根据data集合内容操作nui控件
 * @param data 数据集合
 * @param operatorType hide:显示/隐藏控件 0:隐藏 1:显示 | hideNormal:显示/隐藏普通控件 0:隐藏 1:显示 | set:设置控件值 | setGrid:设置表格 | able:启用/禁用控件 0:禁用 1:启用
 * @param operatorArr nuiData中实际需要操作的id集合
 * @param operatorMap nui控件id与data集合映射集合
 */
function operatorNui(data,operatorType,operatorArr,operatorMap){
	if(!operatorType)return;
	var operatorFun = {
		clear:function(id,map){
			var realId = id;
			if(map && map[id])
				realId = map[id];
			if(!document.getElementById(realId))return;
			document.getElementById(realId).value = "";
		},
		set:function(id,value,map){
			var realId = id;
			if(map && map[id])
				realId = map[id];
			if(!document.getElementById(realId))return;
			document.getElementById(realId).value = value;
		},
		hideNormal:function(id,type,map){
			var realId = id;
			if(map && map[id])
				realId = map[id];
			if(!document.getElementById(realId))return;
			if(type == '0'){
				document.getElementById(realId).style.display = 'none';
			}else
				document.getElementById(realId).style.display = '';
		},
		able:function(id,type,map){
			var realId = id;
			if(map && map[id])
				realId = map[id];
			if(!document.getElementById(realId))return;
			if(type == '0'){
				document.getElementById(realId).disable = "disable";
			}else
				document.getElementById(realId).disable = "";
		}
	};
	for(var i=0,len=operatorArr.length;i<len;i++){
		var operatorId = operatorArr[i];
		operatorFun[operatorType](operatorId,data[operatorId],operatorMap);
	}
}


function getFieldsValue(ids,fieldType){
	var data = {};
	var s = "_";
	for(var i=0,len=ids.length;i<len;i++){
		var _id = ids[i];
		var o = document.getElementById(_id);
		var v = o.value;
		if(fieldType == 0){
			data[_id] = v;
		}else if(fieldType < 0){
			var a = _id.split(s);
			_id = a[a.length-1];
			data[_id] = v;
		}
	}
	return data;
}


/* ========================================================================
 * 导航
 * ========================================================================
 * Copyright 2016 chenb
 * showmecoo
 * ======================================================================== */

Nav_STATIC = {
	menuCss:"nav nav-sidebar",
	mainCss:"active"
};

// Nav CLASS DEFINITION
// ======================
/**
* parentId 		: 容器ID
* mainPage 		：当前页面名字
**/
var Nav = function(options){
	debugger;
	options = options || {};
	this.menus = options["menus"] || "menus";
	this.parentId = options["parentId"] || "";
	this.data = options["data"] || "data";
	//child
	this.name = options["name"] || "name";
	this.childMenus = options["childMenus"] || "childMenus";
	this.href = options["href"] || "href";
	this.mainPage = options["mainPage"] || "";
	this.init();
};

Nav.prototype.init = function(){
	this.createMenu();
}

Nav.prototype.createMenu = function(){
	var d = this.data[this.menus];
	var p = document.getElementById(this.parentId);
	if(!p)return;
	for(var i=0,len=d.length;i<len;i++){
	var menu = d[i];
	var m = this.createMenuHtml(menu);
	p.appendChild(m);
  }
}

Nav.prototype.createMenuHtml = function(m){
	var u = document.createElement("ul");
	var menus = m[this.childMenus];
	u.className = Nav_STATIC.menuCss;
	for(var i=0,len=menus.length;i<len;i++){
		var childMenu = menus[i];
		var cm = this.createChildMenus(childMenu);
		u.appendChild(cm);
	} 
	return u;
}

Nav.prototype.createChildMenus = function(childMenu){
	var l = document.createElement("li");
	var a = document.createElement("a");
	a.href = childMenu["href"];
	a.innerHTML = childMenu["name"];
	if(this.mainPage && childMenu["href"].indexOf(this.mainPage) != -1)
		l.className = Nav_STATIC.mainCss;
	l.appendChild(a);
	return l;
}

/* ========================================================================
 * 表单
 * ========================================================================
 * Copyright 2016 chenb
 * showmecoo
 * ======================================================================== */

 function FormUI(options){
 	this.parentId = options["parentId"];
 	
 }