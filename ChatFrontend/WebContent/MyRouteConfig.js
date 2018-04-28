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
			.when("/logout",{templateUrl:"c_user/Logout.html"})
			.when("/blog",{templateUrl:"c_blog/blog.html"})
			//.when("/UpdateBlog",{templateUrl:"c_blog/UpdateBlog.html"})
			.when("/contact",{templateUrl:"c_about/Contact.html"})
			.when("/about",{templateUrl:"c_about/About.html"})
			.when("/forum",{templateUrl:"c_forum/Forum.html"})
			.when("/jobs",{templateUrl:"c_job/Jobs.html"})
			.when("/addjob",{templateUrl:"c_job/AddJob.html"})
			.when("/myjobs",{templateUrl:"c_job/MyJobs.html"})
			.when("/chat",{templateUrl:"c_chat/Chat.html"})
			.when("/friend",{templateUrl:"c_friend/Friends.html"})
			.when("/Userhome",{templateUrl:"c_user/Userhome.html"})
			.when("/admin",{templateUrl:"c_user/Admin.html"})
			.when("/viewallblogs",{templateUrl:"c_blog/Blogview.html"})
			.when("/viewblogs",{templateUrl:"c_blog/Viewblogs.html"})
			.when("/viewblogcomments",{templateUrl:"c_blog/Viewblogcomment.html"})
			.when("/viewallforums",{templateUrl:"c_forum/Forumview.html"})
			.when("/viewforums",{templateUrl:"c_forum/Viewforums.html"})
			.when("/viewforumcomments",{templateUrl:"c_forum/Viewforumcomment.html"})
			.when("/updateforum",{templateUrl:"c_forum/Updateforum.html"})
		});
myApp.run(function($rootScope,$cookieStore)
		{
			console.log('I am in run function');
			console.log($rootScope.currentUser);
			
				if($rootScope.currentUser==undefined)
				{
				$rootScope.currentUser=$cookieStore.get('userDetails');
				}
				else
				{
				console.log($rootScope.currentUser.username);
				console.log($rootScope.currentUser.role);
				}
		});