/**
 * 
 */
var myApp=angular.module("myApp",['ngRoute',,'ngCookies']);
console.log("Routeprovider");
myApp.config(function($routeProvider)
		{
			console.log("route ");
			$routeProvider.when("#/",{templateUrl:"/index.html"})
			.when("/register",{templateUrl:"c_user/Register.html"})
			.when("/login",{templateUrl:"c_user/Login.html"})
			.when("/blog",{templateUrl:"c_blog/blog.html"})
			.when("/contactus",{templateUrl:"template/Contact.html"})
			.when("/forum",{templateUrl:"c_forum/Forum.html"})
			.when("/UserHome",{templateUrl:"c_user/UserHome.html"})
		});
