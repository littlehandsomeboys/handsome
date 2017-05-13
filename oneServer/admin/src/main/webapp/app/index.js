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
	    el:'#app',
	    data: {
	        mes: 'hello vue'
	    },
	    template: '<div id="app">\
	        <input v-model="mes" type="text">\
	        <br/>\
	        <span>{{ mes }}</span>\
	        </div>',
	    methods : {
			showData : function() {
				
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