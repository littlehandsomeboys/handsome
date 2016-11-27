//监测session是否已经超时
function isTimeOut() {
	$.ajax({
		url : '/admin/auth/api/isTimeOut.do',
		type : "POST",
		dataType : "json",
		contentType : "application/x-www-form-urlencoded; charset=utf-8",
		//contentType : "multipart/form-data",
		data : $('#fmu').serialize(),
		success : function(result) {
			if (typeof result === 'object') {
				result = result;
			} else {
				result = eval("(" + result + ")")
			}
			if (result.code == "0") {

			} else {
				var top = getTopWinow(); //获取当前页面的顶层窗口对象
				top.location.href = "/admin/logout.do";
			}
		},
		error : function(XMLResponse) {
			var top = getTopWinow(); //获取当前页面的顶层窗口对象
			top.location.href = "/admin/logout.do";
		}
	});
}

/** 
 * 在页面中任何嵌套层次的窗口中获取顶层窗口 
 * @return 当前页面的顶层窗口对象 
 */
function getTopWinow() {
	var p = window;
	while (p != p.parent) {
		p = p.parent;
	}
	return p;
}