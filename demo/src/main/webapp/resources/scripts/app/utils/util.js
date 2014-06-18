define(["jquery", "statusCode"], function($, scode) {
	return {
		bsAlert : function(info, type) {
			
			// 成功
			if (type === scode.ALERT_SUCCESS) {
				$("#alertBody").html(info);
			}
			
			// 失败
			else if (type === scode.ALERT_FAIL) {
				$("#alertBody").html(info);
			}
			
			// 警告
			else if (type === scode.ALERT_WARN) {
				$("#alertBody").html(info);
			}
			
			$("#alertModal").modal("show");
		}
	};
});
