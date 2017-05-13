require.config({
	baseUrl: '/admin/static',
    paths : {
    	"jquery" : "js/jquery-3.1.1.min",
    	"vue" : "js/vue.min",
    	"bootstrap" : "js/bootstrap.min",
    	"utils" : "js/customized/utils"
    }
    /*waitSeconds: 15,
    map: {
        '*': {
            'css': 'css/bootstrap.min.css'
        }
    },
    shim : {
        'util': ['css/bootstrap.min.css']
    }*/
});
//require(["jquery","bootstrap","vue"]);