/* ========================================================================
 * Bootstrap Common
 * ========================================================================
 * Copyright 2016 chenb
 * showmecoo
 * ======================================================================== */
if (typeof jQuery === 'undefined') {
  throw new Error('Bootstrap EXTEND\'s JavaScript requires jQuery')
}

bsui = {
	getChildNodes : function (h, g) {
		if (!h) {
			return
		}
		var b = h.childNodes;
		var f = [];
		for (var d = 0, a = b.length; d < a; d++) {
			var j = b[d];
			if (j.nodeType == 1 || g === true) {
				f.push(j)
			}
		}
		return f
	},
	removeNode : function (a) {
		jQuery(a).remove()
	},
	copyTo : function (c, b) {
		if (c && b) {
			for (var a in b) {
				c[a] = b[a]
			}
		}
		return c
	},
	copyIf : function (c, b) {
		if (c && b) {
			for (var a in b) {
				if (mini.isNull(c[a])) {
					c[a] = b[a]
				}
			}
		}
		return c
	},
	isElement : function (a) {
		return a && a.appendChild
	},
	isDate : function (a) {
		return !!(a && a.getFullYear)
	},
	isArray : function (a) {
		return !!(a && !!a.unshift)
	},
	isNull : function (a) {
		return a === null || a === undefined
	},
	isNumber : function (a) {
		return !isNaN(a) && typeof a == "number"
	},
	getAttr : function (el, attr) {
		if (attr == "value" && (isIE6 || isIE7)) {
			var d = el.attributes[attr];
			return d ? d.value : null
		}
		var f = el.getAttribute(attr);
		if (typeof f == "function") {
			f = el.attributes[attr].value
		}
		if (!f && attr == "onload") {
			var i = el.getAttributeNode ? el.getAttributeNode(attr) : null;
			if (i) {
				f = i.nodeValue
			}
		}
		return f
	},
	ParseString : function(el, attrs, b){
		for (var d = 0, a = b.length; d < a; d++) {
			var attr = b[d];
			var f = bsui.getAttr(el, attr);
			if (f) {
				attrs[attr] = f
			}
		}
	},
	ParseBool : function (el, attrs, b) {
		for (var d = 0, a = b.length; d < a; d++) {
			var attr = b[d];
			var f = bsui.getAttr(el, attr);
			if (f) {
				attrs[attr] = f == "true" ? true : false
			}
		}
	},
	ParseInt : function (el, attrs, b) {
		for (var d = 0, a = b.length; d < a; d++) {
			var attr = b[d];
			var f = parseInt(bsui.getAttr(el, attr));
			if (!isNaN(f)) {
				attrs[attr] = f
			}
		}
	},
	ParseColumns : function (el) {
		var columns = [];
		var cs = bsui.getChildNodes(el);
		for (var i = 0, l = cs.length; i < l; i++) {
			var node = cs[i];
			var column = {};
			bsui.ParseString(node, column, ["name", "field","type"]);
			bsui.ParseBool(node, column, []);
			columns.push(column);
		}
		return columns
	}
};

/* ========================================================================
 * Bootstrap TABLE
 * ========================================================================
 * Copyright 2016 chenb
 * showmecoo
 * ======================================================================== */

+function ($) {
	
	// TABLE OPTIONS
	// ======================
	TABLE_STATIC = {
		components:{},
		get:function(id){
			return TABLE_STATIC.components[id];
		}
	};

	// TABLE CLASS DEFINITION
	// ======================
	/**
	* id 		: 表格ID
	* options 	：表格配置信息
	* element   : 表格页面元素
	* dataField : 表格原始数据集合
	* attrs     
	*	columns	: 表格头每列字段信息，包括字段名、字段显示名、特殊字段标识
	* 
	**/
	var TABLE = function (element, options) {
		debugger;
		this.id = $(element).attr('id');
		this.options = options;
		this.element = element;
		this.dataField = {};
		this.attrs = this.getAttr() || {};
		this.create();
	};

	TABLE.prototype.create = function(){
		var pNode = this.element.parentNode;

		var tableNode = this.createTableRow(pNode,this.element);
		this.createHeadRow(tableNode,this.attrs.columns);

		bsui.removeNode(this.element);
		this.element = tableNode;
		pNode.appendChild(tableNode);
	}

	TABLE.prototype.getAttr = function(){
		var attrs = {};
		var cs = bsui.getChildNodes(this.element);
		for (var i = 0, l = cs.length; i < l; i++) {
			var node = cs[i];
			var property = jQuery(node).attr("property");
			if (!property) {
				continue
			}
			property = property.toLowerCase();
			if (property == "columns") {
				attrs.columns = bsui.ParseColumns(node) || {};
				bsui.removeNode(node)
			}
		}
		bsui.ParseString(this.element, attrs, []);
		return attrs
	}

	TABLE.prototype.setAttr = function(options){
		this['options'] = options;
	}

	TABLE.prototype.createTableRow = function(pNode,tNode){
		var tableNode = document.createElement("table");
		tableNode.className = tNode.className;
		tableNode.id = tNode.id;
		pNode.appendChild(tableNode);
		return tableNode;
	}

	TABLE.prototype.createHeadRow = function(t,columns){
		var head = document.createElement("thead");
		var tr = document.createElement("tr");
		for(var b=0,len=columns.length;b<len;b++){
			var column = columns[b];
			var th = this.createHeadNodes(column);
			tr.appendChild(th);
		}
		head.appendChild(tr);
		t.appendChild(head);
	}


	TABLE.prototype.createHeadNodes = function(column){
		var inn = "";
		var th = document.createElement("th");
		if(column["type"] == "checkcolumn"){
			inn = this.createInputHTML() + " ";
		}
		th.innerHTML = inn + column["name"];
		return th;
	}

	TABLE.prototype.createRowsHTML = function(column,index){
		var tr = document.createElement("tr");
		tr.id = this.getId("tr",index);
		for(var i=0,len=this.attrs.columns.length;i<len;i++){
			var td = this.createNodesHTML(this.attrs.columns[i],column,index,cellIndex);
			tr.appendChild(td);
		}
		this.dataField[tr.id] = column; 
		return tr;
	}

	TABLE.prototype.createNodesHTML = function(h,column,index,cellIndex){
		var td = document.createElement("td");
		var inn = "";
		if(h["type"] == "checkcolumn"){
			inn = this.createInputHTML(index,cellIndex);
		}
		if(h["field"] && column[h["field"]]){
			inn = inn + column[h["field"]];
		}
		td.innerHTML = inn;
		return td;

	}

	TABLE.prototype.createInputHTML = function(index,cellIndex){
		var i = '<INPUT id="' + this.getId("input",0,1) + '" type="checkbox" />';
		if(index){
			i = '<INPUT id="' + this.getId("input",index) + '" type="checkbox" />';
		}
		return i;
	}

	TABLE.prototype.setData = function(data){
		debugger;
		if(!data)return;
		var body = document.createElement("tbody");
		for(var i=0,len=data.length;i<len;i++){
			var tr = this.createRowsHTML(data[i],i+1);
			body.appendChild(tr);
		}
		this.element.appendChild(body);
	}

	TABLE.prototype.getDataByRowIndex = function(index){
		var rowId = this.getId("tr",index);
		var rowData = this.dataField[rowId] || {};
		return rowData;
	}

	TABLE.prototype.getId = function(type,index,cellIndex){
		var uid = this.id;
		if(type == "tr"){
			uid = uid +"_tr" + "_"+ index
		}else if(type == "td"){
			uid = uid +"_td" + "_"+ index + "_"+ cellIndex
		}else if(type == "input"){
			uid = uid +"_input" + "_"+ index + "_"+ cellIndex
		}
		return uid;
	}

	$(function () {
		var arr=[
			'.table'	
		];
		$(arr.join(',')).each(function(){
			var $this   = $(this);
			var id = $(this).attr('id');
			var options = {};
			var tableObj = new TABLE(this,options);
			TABLE_STATIC.components[id] = tableObj;
		});
	})
}(jQuery);