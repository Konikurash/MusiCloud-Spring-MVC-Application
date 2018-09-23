$(document).ready(function(){
	$("#toRegisterForm").click(function(e){
		$("#login-form").toggle();
		$("#registration-form").toggle();
		$(".login-module-container").css("height", "625px")
	});
	$("#toLoginForm").click(function(e){
		$("#login-form").toggle();
		$("#registration-form").toggle();
		$(".login-module-container").css("height", "375px")
	});
});