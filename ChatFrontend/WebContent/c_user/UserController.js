/**
 * 
 */
myApp.controller("UserController",function($scope,$http,$location,$rootScope,$cookieStore)
{
	$scope.user={loginname:'',password:'',role:'',username:'',emailid:'',mobileno:'',address:'',isonline:''}
	
	$rootScope.login=function()
	{
		console.log("inside login");
		$http.post('http://localhost:8091/ChatMiddleware/login',$scope.user)
		.then(function(response)
			{
				console.log(response.status);
				$scope.user=response.data;
				$rootScope.currentUser=response.data;
				$cookieStore.put('userDetails',response.data);
				console.log($rootScope.currentUser.role);
				if($rootScope.currentUser.role=="ROLEADMIN")
					{
						console.log("Admin home");
						
					}
				else
				{
					console.log("User home");
					
				}
				$location.path('/Userhome');
			});
	};
	
});