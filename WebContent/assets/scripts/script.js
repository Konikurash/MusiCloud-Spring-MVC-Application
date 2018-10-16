$(document).ready(function(){
	$("#toRegisterForm").click(function(e){
		$("#login-form").toggle();
		$("#registration-form").toggle();
		$(".login-module-container").css("height", "625px");
		$("#module-head").text("Register");
	});
	$("#toLoginForm").click(function(e){
		$("#login-form").toggle();
		$("#registration-form").toggle();
		$(".login-module-container").css("height", "375px");
		$("#module-head").text("Login");
	});
	$("#addSongToggle").click(function(e){
		$("#addSongModule").slideToggle();
	});
});