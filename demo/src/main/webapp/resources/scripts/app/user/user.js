// 用户模块
define(["jquery", "util", "statusCode"], function($, util, sCode) {
	
	// 注册校验
	function checkRegister(model) {
		
		if (model.username == "") {
			util.bsAlert("用户名不能为空", sCode.ALERT_WARN);
			return false;
		}
		
		if (model.password == "") {
			util.bsAlert("密码不能为空", sCode.ALERT_WARN);
			return false;
		}
		
		return true;
	}
	
	// 调用注册
	function trueRegister(model) {
		$.ajax({
			type : "post",
			url : "register",
			data : JSON.stringify(model),
			dataType : "json",
			contentType : "text/plain",
			success : function(result) {
				if (result.status == sCode.AJAX_SUCCESS) {
					util.bsAlert("注册成功", sCode.ALERT_SUCCESS);
				}
				else if (result.status == sCode.AJAX_EXIST) {
					util.bsAlert("用户名已存在", sCode.ALERT_WARN);
				}
				else {
					util.bsAlert("注册失败", sCode.ALERT_FAIL);
				}
			}
		});
	}
	
	// 暴露出的API
	return {
		
		// 显示登录框（同时隐藏注册框）
		showLogin : function() {
			$("#loginTable").show();
			$("#registerTable").hide();
		},
		
		// 显示注册框（同时隐藏登录框）
		showRegister : function() {
			$("#registerTable").show();
			$("#loginTable").hide();
		},
		
		// 执行注册
		register : function() {
			var model = {
				username : $("#registerTable").contents().find("input[name=username]").val().trim(),
				password : $("#registerTable").contents().find("input[name=password]").val().trim()
			};
			
			// 校验通过则执行注册调用
			if (checkRegister(model)) {
				trueRegister(model);
			}
		},
	};
});