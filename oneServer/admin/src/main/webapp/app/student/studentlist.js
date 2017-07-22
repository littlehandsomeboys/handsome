define(['jquery','vue','utils'],
function($,Vue,utils){
	
	/**
	 * 样式加载
	 */
	loadCss("/admin/static/css/bootstrap.min.css");
	
	/**
	 * 初始化执行函数
	 */
    fun1();
    
    /**
     * 定义函数
     */
    function fun1(){
    	var v = $("#jqt").val();
    	console.log(v);
    };
    
    /**
     * 双向数据绑定
     */
    var index = new Vue({
	    el:'#studentlist',
	    data: {
	    	items : [{"name":null,"point":null}],
			condition : {
				classId : "1"
			}
	    },
/*	    template: '<div id="app">\
	        <input v-model="mes" type="text">\
	        <br/>\
	        <span>{{ mes }}</span>\
	        </div>',*/
	    methods : {
	    	showData : function() {
				var _self = this;
				$.ajax({
					type : 'GET',
					dataType : "json",
					data : _self.condition,
					url : '/admin/app/student/getStudentList.do',
					success : function(data) {
						//JSON.stringify();
						_self.items = data;
					},
					error : function(XMLHttpRequest, textStatus, errorThrown) {
						alert(errorThrown);
					}
				});
			}
	    }
    });
    
    
    /**
     * public方法
     */
    return {
  　　　　　　fun1: fun1
  　　　　};
  
}

)