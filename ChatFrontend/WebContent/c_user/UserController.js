/**
 * 
 */
myApp.controller("UserController",function($scope,$http,$location,$rootScope,$cookieStore)
{
	$scope.user={loginname:'',password:'',role:'ROLEUSER',username:'',emailid:'',mobileno:'',address:'',isonline:'n'}
	$scope.userdata;
	
	$rootScope.login=function()
	{
		console.log("inside login");
		$http.post('http://localhost:8090/ChatMiddleware/login',$scope.user)
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
						$location.path('/admin');
					}
				else
				{
					console.log("User home"+$rootScope.currentUser.role);
					$location.path('/Userhome');
				}
				
			});
	};
	
	$rootScope.logout=function()
	{
		console.log('Logout Function');
		delete $rootScope.currentUser;
		$cookieStore.remove('userDetails');
		$location.path("/logout");
	};

	$rootScope.register=function()
	{
		console.log("inside register");
		
		$http.post('http://localhost:8090/ChatMiddleware/registeruser',$scope.user)
		.then(function(response)
		{
			console.log(response.status);
			$location.path('/register');
		});
	};
	
	$rootScope.updateuser=function()
	{
		console.log("inside updt user");
		
		$http.post('http://localhost:8090/ChatMiddleware/updatestatus',$scope.user)
		.then(function(response)
		{
			console.log(response.status);
			$location.path('/Userhome');
		});
	};
	
	function getUsers()
	{
		console.log("inside getuser");
		$http.get("http://localhost:8090/ChatMiddleware/listuser")
		.then(function(response)
				{
					$scope.userdata=response.data;
					console.log($scope.userdata);
				});
	};
	
	getUsers();
	
});