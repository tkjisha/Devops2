/**
 * 
 */
var myApp=angular.module("myApp",["ngRoute"]);
console.log("Routeprovider");
myApp.config(function($routeProvider)
		{
			$routeProvider.when("/",{templateUrl:"/index.jsp"})
			.when("/home",{templateUrl:"/index.jsp"})
			.when("/register",{templateUrl:"template/Register.html"})
			.when("/login",{templateUrl:"template/Login.html"})
			.when("/aboutus",{templateUrl:"template/About.html"})
			.when("/contactus",{templateUrl:"template/Contact.html"})
		});