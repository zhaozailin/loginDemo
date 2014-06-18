// 配置模块路径
requirejs.config({
	
	// 根目录
	baseUrl : "resources/scripts",
	
	// 指定模块id
	paths : {
		domReady : "libs/require/domReady",
		jquery : "libs/jquery/jquery-1.11.1.min",
		bootstrap : "libs/bootstrap/bootstrap.min",
		statusCode : "app/config/statusCode",
		util : "app/utils/util",
		user : "app/user/user"
	},
	
	shim : {
		bootstrap : ["jquery"]
	}
});

// 启动主方法
requirejs(["domReady", "jquery", "bootstrap", "util", "user"], function(domReady, $, bs, util, user) {
	domReady(function() {
		
		// 初始化登录页面，显示登录框，隐藏注册框
		user.showLogin();
		
		// 监听显示注册框事件
		$("#goRegisterBtn").click(function() {
			
			// 显示注册框，隐藏登录框
			user.showRegister();
		});
		
		// 监听返回登录事件
		$("#backBtn").click(function() {
			
			// 显示注册框，隐藏登录框
			user.showLogin();
		});
		
		// 监听注册事件
		$("#registerBtn").click(function() {
			user.register();
		});
	});
});

