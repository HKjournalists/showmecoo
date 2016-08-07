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
	idPre : "bsui-",
	idIndex : 1,
	events : [],
	bindCallbacks : [],
	newId : function (a) {
		return (a || bsui.idPre) + bsui.idIndex++
	},

	preventDefault : function () {
		if (window.event) {
			window.event.returnValue = false
		}
	},

	stopPropogation : function () {
		if (window.event) {
			window.event.cancelBubble = true
		}
	},

	findListener : function (h, g, f, d) {
		var c = bsui.events;
		for (var b = c.length - 1; b >= 0; b--) {
			var j = c[b];
			try {
				if (j[0] == h && j[1] == g && j[2] == f && j[3] == d) {
					return j
				}
			} catch (a) {}
		}
	},

	findParent : function (f,scope) {
		while(f){
			if(scope["components"][f.id]){
				return f;
			}
			f = f.parentNode
		}
		return null;
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
				if (bsui.isNull(c[a])) {
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
	}
};

bsui.copyIf(bsui,{
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
});

bsui.copyIf(bsui,{
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

	createDelegate : function (b, a) {
		if (!b) {
			return function () {}

		}
		return function () {
			return b.apply(a, arguments)
		}
	},

	getFunctoin : function (f) {
		if (typeof f != "string") {
			return null
		}
		var e = f.split(".");
		var d = null;
		for (var c = 0, a = e.length; c < a; c++) {
			var b = e[c];
			if (!d) {
				d = window[b]
			} else {
				d = d[b]
			}
			if (!d) {
				break
			}
		}
		return d
	},

	fireBindEvents : function () {
		for (var b = 0, a = bsui.bindCallbacks.length; b < a; b++) {
			var c = bsui.bindCallbacks[b];
			c[0].call(c[1])
		}
		bsui.bindCallbacks = [];
		bsui._EventTimer = null
	},

	bindEvents : function (b, a) {
		bsui.bindCallbacks.push([b, a]);
		if (!bsui._EventTimer) {
			bsui._EventTimer = setTimeout(function () {
					bsui.fireBindEvents()
				}, 50)
		}
	},

	on : function (type, fn, scope) {
		if (typeof fn == "string") {
			var f = bsui.getFunctoin(fn);
			if (!f) {
				var id = bsui.newId("__str_");
				window[id] = fn;
				eval("fn = function(e){var s = " + id + ";var fn = bsui.getFunctoin(s); if(fn) {fn.call(bsui, e)}else{eval(s);}}")
			} else {
				fn = f
			}
		}
		if (typeof fn != "function" || !type) {
			return false
		}
		type = type.toLowerCase();
		var event = bsui.events[type];
		if (!event) {
			event = bsui.events[type] = []
		}
		scope = scope || bsui;
		if (!bsui.findListener(type, fn, scope)) {
			event.push([fn, scope])
		}
		return bsui
	},

	un : function (c, b, a) {
		if (typeof b != "function") {
			return false
		}
		c = c.toLowerCase();
		var d = bsui.events[c];
		if (d) {
			a = a || bsui;
			var e = bsui.findListener(c, b, a);
			if (e) {
				d.remove(e)
			}
		}
		return bsui
	},

	fire : function (d, e) {
		d = d.toLowerCase();
		var b = bsui.events[d];
		if (b) {
			if (!e) {
				e = {}

			}
			if (e && e != bsui) {
				if (!e.type) {
					e.type = d
				}
			}
			for (var c = 0, a = b.length; c < a; c++) {
				var f = b[c];
				if (f) {
					f[0].apply(f[1], [e])
				}
			}
		}
	},

	jq_on : function (d, c, b, a) {
		if (!d || !c || !b || !a) {
			return false
		}
		var g = bsui.createDelegate(b, a);
		jQuery(d).bind(c, g)
	},

	onOne : function (f, d, c, b) {
		if (!f) {
			return
		}
		var a = "on" + d.toLowerCase();
		f[a] = function (h) {
			h = h || window.event;
			if (!h.target) {
				h.target = h.srcElement
			}
			if (!h.preventDefault) {
				h.preventDefault = bsui.preventDefault
			}
			if (!h.stopPropogation) {
				h.stopPropogation = bsui.stopPropogation
			}
			var g = c.call(b, h);
			if (g === false) {
				return false
			}
		}
	}
});
bsui.JSON = new(function () {
		var sb = [];
		var _dateFormat = null;
		var useHasOwn = !!{}

		.hasOwnProperty,
		replaceString = function (a, b) {
			var c = m[b];
			if (c) {
				return c
			}
			c = b.charCodeAt();
			return "\\u00" + Math.floor(c / 16).toString(16) + (c % 16).toString(16)
		},
		doEncode = function (o, field) {
			if (o === null) {
				sb[sb.length] = "null";
				return
			}
			var t = typeof o;
			if (t == "undefined") {
				sb[sb.length] = "null";
				return
			} else {
				if (o.push) {
					sb[sb.length] = "[";
					var b,
					i,
					l = o.length,
					v;
					for (i = 0; i < l; i += 1) {
						v = o[i];
						t = typeof v;
						if (t == "undefined" || t == "function" || t == "unknown") {}
						else {
							if (b) {
								sb[sb.length] = ","
							}
							doEncode(v);
							b = true
						}
					}
					sb[sb.length] = "]";
					return
				} else {
					if (o.getFullYear) {
						if (_dateFormat) {
							sb[sb.length] = '"';
							if (typeof _dateFormat == "function") {
								sb[sb.length] = _dateFormat(o, field)
							} else {
								sb[sb.length] = mini.formatDate(o, _dateFormat)
							}
							sb[sb.length] = '"'
						} else {
							var n;
							sb[sb.length] = '"';
							sb[sb.length] = o.getFullYear();
							sb[sb.length] = "-";
							n = o.getMonth() + 1;
							sb[sb.length] = n < 10 ? "0" + n : n;
							sb[sb.length] = "-";
							n = o.getDate();
							sb[sb.length] = n < 10 ? "0" + n : n;
							sb[sb.length] = "T";
							n = o.getHours();
							sb[sb.length] = n < 10 ? "0" + n : n;
							sb[sb.length] = ":";
							n = o.getMinutes();
							sb[sb.length] = n < 10 ? "0" + n : n;
							sb[sb.length] = ":";
							n = o.getSeconds();
							sb[sb.length] = n < 10 ? "0" + n : n;
							sb[sb.length] = '"'
						}
						return
					} else {
						if (t == "string") {
							if (strReg1.test(o)) {
								sb[sb.length] = '"';
								sb[sb.length] = o.replace(strReg2, replaceString);
								sb[sb.length] = '"';
								return
							}
							sb[sb.length] = '"' + o + '"';
							return
						} else {
							if (t == "number") {
								sb[sb.length] = o;
								return
							} else {
								if (t == "boolean") {
									sb[sb.length] = String(o);
									return
								} else {
									sb[sb.length] = "{";
									var b,
									i,
									v;
									for (i in o) {
										if (!useHasOwn || Object.prototype.hasOwnProperty.call(o, i)) {
											v = o[i];
											t = typeof v;
											if (t == "undefined" || t == "function" || t == "unknown") {}
											else {
												if (b) {
													sb[sb.length] = ","
												}
												doEncode(i);
												sb[sb.length] = ":";
												doEncode(v, i);
												b = true
											}
										}
									}
									sb[sb.length] = "}";
									return
								}
							}
						}
					}
				}
			}
		},
		m = {
			"\b" : "\\b",
			"\t" : "\\t",
			"\n" : "\\n",
			"\f" : "\\f",
			"\r" : "\\r",
			'"' : '\\"',
			"\\" : "\\\\"
		},
		strReg1 = /["\\\x00-\x1f]/,
		strReg2 = /([\x00-\x1f\\"])/g;
		this.encode = function () {
			var ec;
			return function (o, dateFormat) {
				sb = [];
				_dateFormat = dateFormat;
				doEncode(o);
				_dateFormat = null;
				return sb.join("")
			}
		}
		();
		this.decode = function () {
			var dateRe1 = /^(\d{4})-(\d{2})-(\d{2})[T ](\d{2}):(\d{2}):(\d{2}(?:\.*\d*)?)Z*$/;
			var dateRe2 = new RegExp("^/+Date\\((-?[0-9]+).*\\)/+$", "g");
			var re = /[\"\'](\d{4})-(\d{2})-(\d{2})[T ](\d{2}):(\d{2}):(\d{2})[\"\']/g;
			return function (json, parseDate) {
				if (json === "" || json === null || json === undefined) {
					return json
				}
				if (typeof json == "object") {
					json = this.encode(json)
				}
				function evalParse(json) {
					if (parseDate !== false) {
						json = json.replace(__js_dateRegEx, "$1new Date($2)");
						json = json.replace(re, "new Date($1,$2-1,$3,$4,$5,$6)");
						json = json.replace(__js_dateRegEx2, "new Date($1)")
					}
					return eval("(" + json + ")")
				}
				var data = null;
				if (window.JSON && window.JSON.parse) {
					var dateReviver = function (key, value) {
						if (typeof value === "string" && parseDate !== false) {
							dateRe1.lastIndex = 0;
							var a = dateRe1.exec(value);
							if (a) {
								value = new Date(a[1], a[2] - 1, a[3], a[4], a[5], a[6]);
								return value
							}
							dateRe2.lastIndex = 0;
							var a = dateRe2.exec(value);
							if (a) {
								value = new Date(parseInt(a[1]));
								return value
							}
						}
						return value
					};
					try {
						var json2 = json.replace(__js_dateRegEx, '$1"/Date($2)/"');
						data = window.JSON.parse(json2, dateReviver)
					} catch (ex) {
						data = evalParse(json)
					}
				} else {
					data = evalParse(json)
				}
				return data
			}
		}
		()
	})();
__js_dateRegEx = new RegExp('(^|[^\\\\])\\"\\\\/Date\\((-?[0-9]+)(?:[a-zA-Z]|(?:\\+|-)[0-9]{4})?\\)\\\\/\\"', "g");
__js_dateRegEx2 = new RegExp("[\"']/Date\\(([0-9]+)\\)/[\"']", "g");
bsui.encode = bsui.JSON.encode;
bsui.decode = bsui.JSON.decode;
bsui.ajax = function (options) {
	var data = {
		Head:{},
		Body:options.data
	};

	if (!options.dataType) {
	   options.dataType = "json";
	}
	if (!options.contentType) {
	   options.contentType = "application/json; charset=UTF-8";
	}
	if (options.data && bsui.isNull(options.data.pageIndex) == false) {
	   var page = options.data.page = {};
	   page.begin = options.data.pageIndex*options.data.pageSize;
	   page.length = options.data.pageSize;
	   page.isCount = true;
	}
	if (options.data && typeof(options.data)=='object' ) {
		options.data = bsui.encode(data);
	}
	if (options.dataType == "json") {
		if(options.data == '{}'){
			delete options.data;
		}
		options.type='POST';
	}		
	options._success = options.success;
	options.e = options.error;

	options.beforeSend = function(request){	}
	options.success = function(data, textStatus, xhr){
		if(this._success)
			this._success(data,textStatus,xhr);
	}

	options.error = function(data, textStatus, xhr){
		if(this._error)
			this._error(data,textStatus,xhr);
	}
	return window.jQuery.ajax(options);
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
		tWarnCss:"warning",
		components:{},
		selectRows:{},
		checkboxColumn:"checkcolumn",
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
	*	length  : 集合长度
	*   rowId   : 行ID
	* attrs     
	*	columns			: 表格头每列字段信息，包括字段名、字段显示名、特殊字段标识
	*	allowRowSelect	: 是否允许选择行
	*	multiSelect		: 是否允许多选
	*	onclick   		: 表格点击事件
	*	selectsFlag 	: 表格全选标识
	* 
	**/
	var TABLE = function (element, options) {
		this.id = $(element).attr('id');
		this.options = options;
		this.element = element;
		this.headEl = null;
		this.bodyEl = null;
		this.dataField = {};
		this.attrs = this.getAttr() || {selectsFlag:"0"};
		this.create();
		this.initEvents();
		this.set();
	};

	TABLE.prototype.set = function(){
		var e = this.attrs || {};
		for (var b in e) {
			if (b.toLowerCase().indexOf("on") == 0) {
				var c = e[b];
				if(window[c])
					bsui.on(b.substring(2, b.length).toLowerCase(), c, this);
				delete e[b]
			}
		}
	}

	TABLE.prototype.create = function(){
		var head = this.createHeadRow();
		var tableNode = this.createTableRow();
		var pNode = this.element.parentNode;

		bsui.removeNode(this.element);
		this.headEl = head;
		this.element = tableNode;
		tableNode.appendChild(head);
		pNode.appendChild(tableNode);
	}

	TABLE.prototype.initEvents = function(){
		//绑定点击事件至表格上
		bsui.bindEvents(function () {
			//bsui.onOne(this.element, "click", this.__OnClick, this);
		}, this)
		bsui.on("selectAll", this.doSelectAll, this);
		bsui.on("unselectAll", this.doUnSelectAll, this);
		bsui.on("rowmousedown", this.__OnRowMouseDown, this);
		bsui.on("rowclick", this.__OnRowClick, this);
		bsui.on("cellclick", this.__OnCellClick, this);
		bsui.on("HeaderCellClick", this.__OnHeaderCellClick, this)
		bsui.jq_on(this.element, "click", this.__OnClick, this);
		bsui.jq_on(this.element, "mousedown", this.__OnMouseDown, this);
		bsui.jq_on(this.element, "mousemove", this.__OnMouseMove, this);
	}

	TABLE.prototype.__OnHeaderCellClick = function(a){
		if(a.htmlEvent 
			&& a.htmlEvent.target 
			&& this.attrs["allowRowSelect"]
			&& this.attrs["multiSelect"]){

			if(a.htmlEvent.target.checked)
				bsui.fire("selectAll");
			else
				bsui.fire("unselectAll");
		}
	}

	TABLE.prototype.__OnClick = function(a){
		//自定义点击事件
		bsui.fire("click");
		this.fireEvent(a, "Click")
	}

	TABLE.prototype.__OnMouseDown = function(a){
		this.fireEvent(a, "MouseDown")
	}

	TABLE.prototype.__OnMouseMove = function(a){
		this.fireEvent(a, "MouseMove")
	}

	TABLE.prototype.__OnRowMouseDown = function(a){

	}

	TABLE.prototype.__OnRowClick = function(a){
		if(this.attrs["allowRowSelect"] 
			&& a["row"]["type"]!="head"){
			
			var t = this.getId("tr",a["row"]["_index"]);
			var rowObj = $('#'+t);
			var rowIndex = this.getIndexById("tr",t)["index"];
			var checkboxId = this.getId("checkbox",rowIndex,"0");
			var checkboxObj = document.getElementById(checkboxId);
			var sFlag = TABLE_STATIC.selectRows.hasOwnProperty(t);
			if(rowObj && rowObj[0]){
				if(sFlag){
					rowObj[0].className = "";
					delete TABLE_STATIC.selectRows[t]; 
					if(checkboxObj){
						checkboxObj.checked = "";
					}
				}else{
					rowObj[0].className = TABLE_STATIC.tWarnCss;
					TABLE_STATIC.selectRows[t] = "";
					if(checkboxObj){
						checkboxObj.checked = "true";
					}
				}
			}
		}
	}

	TABLE.prototype.__OnCellClick = function(a){

	}

	TABLE.prototype.doSelect = function(a){

	}

	TABLE.prototype.doSelectAll = function(a){
		for(var a=0,b=this.dataField.length;a<b;a++){
			var t = this.getId("tr",a);
			var c = this.getId("checkbox",a,"0");
			var checkboxObj = document.getElementById(c);
			checkboxObj.checked = "true";
			if(a > 0){
				$('#'+t)[0].className = TABLE_STATIC.tWarnCss;
				TABLE_STATIC.selectRows[t] = "";
			}
		}
		this.attrs["selectsFlag"] = "1";
	}

	TABLE.prototype.doUnSelectAll = function(a){
		for(var a=0,b=this.dataField.length;a<b;a++){
			var t = this.getId("tr",a);
			var c = this.getId("checkbox",a,"0");
			var checkboxObj = document.getElementById(c);
			checkboxObj.checked = "";
			if(a > 0){
				$('#'+t)[0].className = "";
				delete TABLE_STATIC.selectRows[t];
			}
		}
		this.attrs["selectsFlag"] = "0";
	}

	TABLE.prototype.getSelectRows = function(){
		var a = [];
		for(var i in TABLE_STATIC.selectRows){
			var row = this.dataField[i];
			a.push(row);
		}
		return a;
	}

	TABLE.prototype.fireEvent = function (h, b) {
		if(b == "Click"){
			debugger;
		}
		var j = this.getCellByEvent(h);
		var f = j[0],
		d = j[1];
		if (f) {
			var g = {
				record : f,
				row : f,
				htmlEvent : h
			};
			bsui.fire("row" + b, g)
		}
		if (d) {
			var g = {
				column : d,
				field : d.field,
				htmlEvent : h
			};
			bsui.fire("column" + b, g)
		}
		if (f && d) {
			var g = {
				record : f,
				row : f,
				column : d,
				type : d.type,
				htmlEvent : h
			};
			bsui.fire("cell" + b, g)
		}
		if(f && f["type"] == "head"){
			var g = {
				record : f,
				row : f,
				htmlEvent : h
			};
			bsui.fire("headercell" + b, g)
		}
	}

	TABLE.prototype.getCellByEvent = function (c) {
		var a = this.getRecordByEvent(c);
		var b = this.getColumnByEvent(c);
		return [a, b]
	}

	TABLE.prototype.getRecordByEvent = function (d) {
		var b;
		if(d.target)
			b = bsui.findParent(d.target,TABLE_STATIC);
		if (b) {
			return this.dataField[b.id]
		}
		return null
	}

	TABLE.prototype.getColumnByEvent = function (c) {
		//TODO 有bug，是否应该返回所有列定义信息
		if (c && c.target 
			&& c.target.id) {
			var cellIndex = this.getIndexById("td",c.target.id)["cellIndex"];
			return this.attrs.columns[cellIndex];
		}
		return null
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
				attrs.columns = bsui.ParseColumns(node) || [];
				bsui.removeNode(node)
			}
		}
		bsui.ParseString(this.element, attrs, ["onclick"]);
		bsui.ParseBool(this.element, attrs, ["allowRowSelect","multiSelect"]);
		return attrs
	}

	TABLE.prototype.setAttr = function(options){
		this['options'] = options;
	}

	TABLE.prototype.createTableRow = function(){
		var tNode = this.element;
		var pNode = tNode.parentNode;
		var tableNode = document.createElement("table");
		tableNode.className = tNode.className;
		tableNode.id = tNode.id;
		pNode.appendChild(tableNode);
		return tableNode;
	}

	TABLE.prototype.createHeadRow = function(){
		var c = this.attrs.columns;
		var head = document.createElement("thead");
		var tr = document.createElement("tr");
		var rowId = this.getId("tr","0");
		tr.id = rowId;
		this.addRow(tr.id,{type:"head"});

		TABLE_STATIC.components[tr.id] = tr; 
		for(var b=0,len=c.length;b<len;b++){
			var column = c[b];
			var th = this.createHeadNodes(column);
			tr.appendChild(th);
		}
		head.appendChild(tr);
		return head;
	}


	TABLE.prototype.createHeadNodes = function(column){
		var inn = "";
		var th = document.createElement("th");
		if(column["type"] == TABLE_STATIC.checkboxColumn){
			inn = this.createCheckHTML("0","0") + " ";
		}
		th.innerHTML = inn + column["name"];
		return th;
	}

	TABLE.prototype.createRowsHTML = function(row){
		var tr = document.createElement("tr");
		for(var i=0,len=this.attrs.columns.length;i<len;i++){
			var cell = {"_cIndex":i};
			row["column"] = this.attrs.columns[i];
		
			tr.appendChild(this.createNodesHTML(row,cell));
			delete row["column"];
		}
		return tr;
	}

	TABLE.prototype.createNodesHTML = function(row,cell){
		var f = row["data"];
		var h = row["column"];
		var td = document.createElement("td");
		var inn = "";
		if(h["type"] == TABLE_STATIC.checkboxColumn){
			inn = this.createCheckHTML(row["_index"],cell["_cIndex"]);
		}
		if(h["field"] && f[h["field"]]){
			inn = inn + f[h["field"]];
		}
		td.innerHTML = inn;
		return td;
	}

	TABLE.prototype.createCheckHTML = function(index,cellIndex){
		var i = '<INPUT id="' + this.getId("checkbox",0,0) + '" type="checkbox" />';
		if(index){
			i = '<INPUT id="' + this.getId("checkbox",index,cellIndex) + '" type="checkbox" />';
		}
		return i;
	}

	TABLE.prototype.setData = function(data){
		if(!data)return;
		var body = document.createElement("tbody");
		for(var i=0,len=data.length;i<len;i++){
			var row = {_index:i+1,data:data[i]};
			var tr = this.createRowsHTML(row);
			tr.id = this.getId("tr",i+1);
			body.appendChild(tr);

			this.addRow(tr.id,row);
			TABLE_STATIC.components[tr.id] = tr;
		}
		if(this.bodyEl){
			bsui.removeNode(this.bodyEl);
		}
		this.bodyEl = body;
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
		}else if(type == "checkbox"){
			uid = uid +"_checkbox" + "_"+ index + "_"+ cellIndex
		}
		return uid;
	}

	TABLE.prototype.getIndexById = function(type,id){
		var i = {};
		var arr = id.split("_");
		if(type == "tr"){
			i["index"] = arr[arr.length-1];
		}else if(type == "td" || type == "checkbox"){
			i["index"] = arr[arr.length-2];
			i["cellIndex"] = arr[arr.length-1];
		}
		return i;
	}

	TABLE.prototype.addRow = function(i,r){
		this.dataField[i] = r; 
		if(!this.dataField["length"])this.dataField["length"] = 1;
		else this.dataField["length"] ++;
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
