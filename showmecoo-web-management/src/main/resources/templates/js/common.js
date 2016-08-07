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