$(document).ready(function(){
	$("#toRegisterForm").click(function(e){
		$("#login-form").toggle();
		$("#registration-form").toggle();
		$(".reg-form").css("height", "auto");
		$("#module-head").text("Register");
	});
	$("#toLoginForm").click(function(e){
		$("#login-form").toggle();
		$("#registration-form").toggle();
		$(".login-form").css("height", "auto");
		$("#module-head").text("Login");
	});
	$("#addSongToggle").click(function(e){
		$("#addSongModule").slideToggle();
	});
	
	$("#deleteAccount").click(function(e){
		$(this).hide();
		$("#delete-confirmation").toggle();
	});
	
	$(".editButton").click(function(e){
        $(this).siblings(".droplist").slideToggle();
    });
});