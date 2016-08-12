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

FormUI_STATIC = {
	controlClass:"form-control",
	labelClass:"",
	colSize:"col-sm-",
	components:{},
	dateDivParam:{
		"data-date":"1979-09-16T05:25:07Z",
		"data-date-format":"dd MM yyyy - HH:ii p"
	},
	get:function(id){
		return this.components[id];
	}
}

// FormUI CLASS DEFINITION
// ======================
/**
* parentId 		: 容器ID
* components    : 
**/
var FormUI = function(options){
	this.id = options["id"] || "form";
	this.parentId = options["parentId"];
	this.data = options["data"];

	this.typeKey = options["typeKey"] || "type";
	this.nameKey = options["nameKey"] || "name";
	this.fieldKey = options["fieldKey"] || "field";
	this.childNodesKey = options["childNodesKey"] || "childNodes";

	this.formDivSize = options["formDivSize"] || "6";
	this.formDivLabelSize = options["formDivLabelSize"] || "4"; 
	this.formClass = options["formClass"] || "form-inline";
	this.formDivClass = options["formDivClass"] || "from-group";
	this.formButtonClass = options["formButtonClass"] || "btn btn-sm btn-primary";

	this.dateDivClass = options["dateDivClass"] || "input-group date form_datetime";
	this.dateInputSize = options["dateInputSie"] || 14;
	this.init();

	FormUI_STATIC.components[this.id] = this;
	bsui.parse();
}

FormUI.prototype.init = function(){
	var a = {};
	a[this.id] = {};
	this.components = a;
	this.createForm();
}

FormUI.prototype.appendForm = function(data){
	var formNode = document.getElementById(this.id);
	if(formNode){
		var childNodes = this.data[this.childNodesKey];
		for(var i=0,len=childNodes.length;i<len;i++){
			var childNode = childNodes[i];
			var child = this.createFormChild(childNode);
			formNode.appendChild(child);
		}
	}
}

FormUI.prototype.createForm = function(){
	var parentNode = document.getElementById(this.parentId);
	if(!parentNode)return;
	var formNode = document.createElement("form");
	var childNodes = this.data[this.childNodesKey];
	for(var i=0,len=childNodes.length;i<len;i++){
		var childNode = childNodes[i];
		var child = this.createFormChild(childNode);
		formNode.appendChild(child);
	}
	for(var i in this.data){
		if(this.data.hasOwnProperty(i)){
			if(i != this.childNodesKey){
				formNode.setAttribute(i,this.data[i]);
			}
		}
	}
	formNode.className = this.formClass;
	formNode.setAttribute("role","form");
	parentNode.appendChild(formNode);
}

FormUI.prototype.createFormChild = function(childNode){
	if(!childNode)return;
	var divNode = document.createElement("div");
	var saveObj = {};
	saveObj[this.fieldKey] = childNode[this.fieldKey] || "default";
	saveObj[this.nameKey] = childNode[this.nameKey] || "default";
	divNode.id = this.createId("div",saveObj[this.fieldKey])
	divNode.className = this.formDivClass + " " +  FormUI_STATIC.colSize+this.formDivSize;
	if(childNode[this.childNodesKey]){
		var nodes = childNode[this.childNodesKey];
		for(var i=0,len=nodes.length;i<len;i++){
			var node = nodes[i];
			if(node){
				this.replaceProperty(node,"toggle","data-toggle");
				this.replaceProperty(node,"target","data-target");
				var column = this.createFormColumn(saveObj,node);
				if(column.length){
					for(var j=0,jlen=column.length;j<jlen;j++){
						divNode.appendChild(column[j]);
					}
				}else{
					divNode.appendChild(column);
				}
			}
		}
	}
	return divNode;
}

FormUI.prototype.createFormColumn = function(saveObj,node){
	if(!saveObj || !node)return;
	var type = node[this.typeKey]
	var _create = {
		text:function(scope,saveObj,node){
			return scope["createFormText"](saveObj)
		},
		label:function(scope,saveObj,node){
			return scope["createFormLabel"](saveObj,node)
		},
		html:function(scope,saveObj,node){

		},
		button:function(scope,saveObj,node){
			return scope["createFormButton"](saveObj,node)
		},
		datetime:function(scope,saveObj,node){
			return scope["createFormDatetime"](saveObj,node)
		}
	}
	return _create[type](this,saveObj,node);
}

FormUI.prototype.createFormText = function(saveObj){
	var id = this.createId("text",saveObj[this.fieldKey]);
	var textObj = document.createElement("input");
	var save = {"type":"text","id":id,"field":saveObj[this.fieldKey]};
	var component = this.components[this.id][save.field];

	if(component && component["forId"]){
		var forId = component["forId"];
		if(document.getElementById(forId))
			document.getElementById(forId).setAttribute("forId",id);
		bsui.copyTo(component,save);
	}else{
		component = save;
	}
	textObj.setAttribute("type",save.type);
	textObj.setAttribute("id",id);
	textObj.setAttribute("placeholder",saveObj[this.nameKey]);
	textObj.className = FormUI_STATIC.controlClass;
	return textObj;
}

FormUI.prototype.createFormLabel = function(saveObj,node){
	var field = saveObj[this.fieldKey];
	var component = this.components[this.id][field] || {};
	var labelObj = document.createElement("label");

	labelObj.id = this.createId("label",saveObj[this.fieldKey])
	labelObj.innerHTML = saveObj[this.nameKey];
	labelObj.className = FormUI_STATIC.labelClass + " " +  FormUI_STATIC.colSize + this.formDivLabelSize;
	if(component["id"]){
		var forId = component["id"];
		component["forId"] = labelObj.id;
		labelObj.setAttribute("for",forId);
	}else{
		component["forId"] = labelObj.id;
		this.components[this.id][field] = component;
	}
	for(var i in node){
		if(node.hasOwnProperty(i)){
			if(i !="type"){
				labelObj.setAttribute(i,node[i]);
			}
		}
	}
	return labelObj;
}

FormUI.prototype.createFormButton = function(saveObj,node){
	var p = document.createElement("p");
	var button = document.createElement("button");
	p.className = this.formDivClass + " " +  FormUI_STATIC.colSize+this.formDivSize;
	button.className = this.formButtonClass
	for(var i in node){
		if(node.hasOwnProperty(i) && i != "type"){
			button.setAttribute(i,node[i]);
		}
	}
	button.innerHTML = saveObj[this.nameKey];
	p.appendChild(button);
	return p;
}

FormUI.prototype.createFormDatetime = function(saveObj,node){
	var dateDiv = document.createElement("div");
	var readOnlyInput = '<input class="form-control" type="text" size='+ this.dateInputSize 
		+' value="" readonly>'
	var span = '<span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>';

	var id = this.createId("text",saveObj[this.fieldKey]);
	var textObj = document.createElement("input");

	var save = {"type":"text","id":id,"field":saveObj[this.fieldKey]};
	var component = this.components[this.id][save.field];

	if(component && component["forId"]){
		var forId = component["forId"];
		if(document.getElementById(forId))
			document.getElementById(forId).setAttribute("forId",id);
		bsui.copyTo(component,save);
	}else{
		component = save;
	}
	dateDiv.className = this.dateDivClass;
	dateDiv.innerHTML = readOnlyInput + span;
	for(var i in FormUI_STATIC.dateDivParam){
		if(FormUI_STATIC.dateDivParam.hasOwnProperty(i)){
			dateDiv.setAttribute(i,FormUI_STATIC.dateDivParam[i]);
		}
	}
	
	dateDiv.setAttribute("data-link-field",id);
	textObj.setAttribute("type","hidden");
	textObj.setAttribute("id",id);
	return [dateDiv,textObj];
}

FormUI.prototype.replaceProperty = function(obj,oldPro,repPro){
	if(obj.hasOwnProperty(oldPro)){
		obj[repPro] = obj[oldPro];
		delete obj[oldPro];
	}
}

FormUI.prototype.resetTextData = function(textArr){
	for(var i=0,len=textArr.length;i<len;i++){
		var field = textArr[i];
		var componentObj = this.components[this.id][field];
		if(componentObj){
			var textObjId = componentObj["id"];
			var textObj = document.getElementById(textObjId);
			if(textObj){
				textObj.value = "";
			}
		}
	}
}

FormUI.prototype.setTextData = function(data){
	for(var c in data){
		if(data.hasOwnProperty(c)){
			var field = c;
			var componentObj = this.components[this.id][field];
			if(componentObj){
				var textObjId = componentObj["id"];
				var textObj = document.getElementById(textObjId);
				if(textObj && data[field]){
					textObj.value = data[field];
				}
			}
		}
	}
}

FormUI.prototype.getTextData = function(textArr){
	var returnObj = {};
	for(var i=0,len=textArr.length;i<len;i++){
		var field = textArr[i];
		var componentObj = this.components[this.id][field];
		if(componentObj){
			var textObjId = componentObj["id"];
			var textObj = document.getElementById(textObjId);
			if(textObj){
				returnObj[field] = textObj.value;
			}
		}
	}
	return returnObj;
}

FormUI.prototype.createId = function(type,field){
	var uid = this.id;
	if(type == "form"){
		uid = "form" + "_"+ uid
	}else if(type == "label"){
		uid = "label" + "_"+ field + "_"+ uid
	}else if(type == "text"){
		uid = "text" + "_"+ field + "_"+ uid
	}else if(type == "div"){
		uid = "div" + "_"+ field + "_"+ uid
	}
	return uid;
}


/* ========================================================================
 * 表格分页
 * ========================================================================
 * Copyright 2016 chenb
 * showmecoo
 * ======================================================================== */
PageUI_STATIC = {
	component:{},
	pageComponentClass:"dataTables_paginate",
	firstPageText:"首页",
	firstPageClass:"first paginate_button",
	lastPageText:"最后一页",
	lastPageClass:"last paginate_button",
	previousPageText:"上一页",
	previousPageClass:"previous paginate_button",
	nextPageText:"下一页",
	nextPageClass:"next paginate_button",
	buttonClass:"paginate_button",
	activeButtonClass:"paginate_active",
	disabledButtonClass:"paginate_button_disabled",
	showPageSize:3

}

/* ========================================================================
 * 分页
 * ========================================================================
 * Copyright 2016 chenb
 * showmecoo
 * ======================================================================== */
function PageUI(options){
	debugger;
	this.id = options["id"] || "";
	this.pageIndex = options["pageIndex"] || 1;
	this.pageSize = options["pageSize"] || 10;
	this.totalCount = options["totalCount"] || 10;
	this.component = {};
	this.init();
	PageUI_STATIC.component[this.id] = this;
}

PageUI.prototype.init = function(){
	this.createComponent();
}

PageUI.prototype.setPageIndex = function(i){
	this.pageIndex = parseInt(i);
}

PageUI.prototype.createComponent = function(){
	var componentObj = document.getElementById(this.id);
	if(!componentObj.className){
		componentObj.className = PageUI_STATIC.pageComponentClass;
	}
	this.component[this.id] = componentObj;
	this.getPages();
	this.createFirstButton();
	this.createPreviousButton();
	this.createPages();
	this.createNextButton();
	this.createLastButton();
	this.getButtonClass();
}

PageUI.prototype.createFirstButton = function(){
	var a = document.createElement("a");
	a.id = this.createId("first",this.id);
	a.innerHTML = PageUI_STATIC.firstPageText;

	bsui.jq_on(a, "click", this.firstButtonClick, this);
	this.component["first"] = a.id;
	this.component[this.id].appendChild(a);
}

PageUI.prototype.firstButtonClick = function(o){
	var flag = o.target.getAttribute("disable");
	if(flag == "false"){
		this.pageIndex = 1;
		this.changePage();
	}
}

PageUI.prototype.createLastButton = function(){
	var a = document.createElement("a");
	a.id = this.createId("last",this.id);
	a.innerHTML = PageUI_STATIC.lastPageText;

	bsui.jq_on(a, "click", this.lastButtonClick, this);
	this.component["last"] = a.id;
	this.component[this.id].appendChild(a);
}

PageUI.prototype.lastButtonClick = function(o){
	var flag = o.target.getAttribute("disable");
	if(flag == "false"){
		this.pageIndex = this.totalCount;
		this.changePage();
	}
}

PageUI.prototype.createPreviousButton = function(){
	var a = document.createElement("a");
	a.id = this.createId("previous",this.id);
	a.innerHTML = PageUI_STATIC.previousPageText;

	bsui.jq_on(a,"click",this.previousClick,this);
	this.component["previous"] = a.id;
	this.component[this.id].appendChild(a);
}

PageUI.prototype.previousClick = function(o){
	var flag = o.target.getAttribute("disable");
	if(flag == "false"){
		this.pageIndex = this.pageIndex - 1;
		this.changePage();
	}
}

PageUI.prototype.createNextButton = function(){
	var a = document.createElement("a");
	a.id = this.createId("next",this.id);
	a.innerHTML = PageUI_STATIC.nextPageText;

	bsui.jq_on(a,"click",this.nextClick,this);
	this.component["next"] = a.id;
	this.component[this.id].appendChild(a);
}

PageUI.prototype.nextClick = function(o){
	var flag = o.target.getAttribute("disable");
	if(flag == "false"){
		this.pageIndex = this.pageIndex + 1;
		this.changePage();
	}
}

PageUI.prototype.changePage = function(){
	var nodeId = this.component["pageSpan"];
	var node = document.getElementById(nodeId);
	var childNodes = node.childNodes;
	while(node.hasChildNodes()){
		node.removeChild(node.lastChild);
	}
	this.getPages();
	this.getButtonClass();
	this.createPages();
}

PageUI.prototype.createPages = function(){
	var span;
	var pages = this.component["pages"];
	var spanObj = document.getElementById(this.component["pageSpan"]);
	if(!spanObj){
		span = document.createElement("span");
		span.id = this.createId("span");
		this.component["pageSpan"] = span.id;
	}else{
		span = document.getElementById(spanObj.id);
	}
	for(var i=1;i<=pages.length;i++){
		var id = this.createId("page",i);
		var page = pages[id];
		var a = document.createElement("a");
		a.id = page["id"];
		a.innerHTML = page["text"];
		if(parseInt(a.innerHTML) == this.pageIndex){
			a.className = PageUI_STATIC.activeButtonClass
		}else
			a.className = PageUI_STATIC.buttonClass;
		 
		if(page["type"] == "button"){
			bsui.jq_on(a,"click",this.showPageClick,this);
		}
		span.appendChild(a);
	}
	if(!spanObj){
		this.component[this.id].appendChild(span);
	}
}

PageUI.prototype.getButtonClass = function(buttons){
	var buts = buttons || ["first","last","previous","next"];
	for(var i=0,len=buts.length;i<len;i++){
		var type = buts[i];
		var id = this.component[type];
		var a = document.getElementById(id);
		if(type == "next" || type == "last"){
			if(this.totalCount == 0 || this.pageIndex == this.totalCount){
				a.className = PageUI_STATIC[type+"PageClass"] +" "+ PageUI_STATIC.disabledButtonClass;
				a.setAttribute("disable","true");
			}else{
				a.className = PageUI_STATIC[type+"PageClass"];
				a.setAttribute("disable","false");
			}
		}else if(type == "first" || type == "previous"){
			if(this.pageIndex <= 1){
				a.className = PageUI_STATIC[type+"PageClass"] +" "+ PageUI_STATIC.disabledButtonClass;
				a.setAttribute("disable","true");
			}else{
				a.className = PageUI_STATIC[type+"PageClass"];
				a.setAttribute("disable","false");
			}
		}
	}
}

PageUI.prototype.getPages = function(){ 
	var _getPages = {
		getPageNums:function(scope){
			var num = 0;
			var indexs = [];
			var pages = {length:0};
			for(var i=scope.pageIndex;i<=scope.totalCount;i++){
				if(num < PageUI_STATIC.showPageSize){
					indexs.push(i);
					num ++;
				}else
					break;
			}
			if(indexs.length>0 && indexs[0] > 1){ 
				scope.buildPage(pages,"show","..");
			}
			for(var i=0,len=indexs.length;i<len;i++){
				scope.buildPage(pages,"button",indexs[i]);
			}
			if(indexs.length>0 && indexs[indexs.length-1] < scope.totalCount){
				scope.buildPage(pages,"show","..");
			}
			return pages;
		}
	}
	this.component["pages"] = _getPages["getPageNums"](this);
}

PageUI.prototype.buildPage = function(pages,type,text){
	var len = parseInt(pages["length"]) + 1;
	var id = this.createId("page",len);
	var pageShow = {"id":id,"type":type,"text":text};
	pages["length"] = len;
	pages[id] = pageShow;
}


PageUI.prototype.showPageClick = function(o){
	var target = o.target;
	if(target){
		this.pageIndex = parseInt(target.innerHTML);
		this.changePage();
	}
}

PageUI.prototype.createId = function(type,index){
	var uid = this.id;
	if(type == "first"){
		uid = "first" + "_"+ uid
	}else if(type == "last"){
		uid = "last"  + "_"+ uid
	}else if(type == "previous"){
		uid = "previous" + "_"+ uid
	}else if(type == "next"){
		uid = "next" + "_"+ uid
	}else if(type == "span"){
		uid = "span" + "_"+ uid
	}else if(type == "page"){
		uid = "page" + "_"+ index + "_" + uid;
	}
	return uid;
}

PageUI.prototype.getId = function(id,type,index){
	var arr = id.split("_");

}