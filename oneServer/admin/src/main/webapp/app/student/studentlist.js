define(['jquery','vue','utils'],
function($,Vue,utils){
	
	/**
	 * 样式加载
	 */
	loadCss("/admin/static/css/bootstrap.min.css");
	
	/**
	 * 初始化执行函数
	 */
    init();
    
    /**
     * 定义函数
     */
    function init(){
    	
    };
    
    /**
     * 双向数据绑定
     */
    var index = new Vue({
	    el:'#studentlist',
	    data: {
	    	classSelect:[],
	    	items : [{"name":null, "point":null, "rowNo":null}],
			condition : {
				classId : "0"
			},
			temp: {
				show: null
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
						_self.items = data;
					},
					error : function(XMLHttpRequest, textStatus, errorThrown) {
						alert(errorThrown);
					}
				});
			},
			getClassSelect: function() {
				var _self = this;
				$.ajax({
					type : 'GET',
					dataType : "json",
					data : _self.condition,
					url : '/admin/app/class/selectClass.do',
					success : function(data) {
						_self.classSelect = data;
					},
					error : function(XMLHttpRequest, textStatus, errorThrown) {
						alert(errorThrown);
					}
				});
			},
			showTab: function(item) {
				var _self = this;
				if (_self.temp.show==item.id) {
					_self.temp.show=null;
				}
				else {
					_self.temp.show=item.id;
				}
			}
	    },
	    watch: {
	    	condition: {
	    		handler(curVal,oldVal){
	    			this.showData();
			    },
			    deep:true
	    	}
	    },
	    created: function(){
	    	var _self = this;
	    	_self.showData();
	    	_self.getClassSelect();
	    }
    });
    
    
    /**
     * public方法
     */
    return {
  　　　　　　init: init
  　　　　};
  
}
)