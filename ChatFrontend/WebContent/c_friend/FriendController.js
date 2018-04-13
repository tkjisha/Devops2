/**
 * 
 */
myApp.controller('FriendController',function($scope,$rootScope,$http)
{
	$scope.friend={friendId:0,Loginname:'',friendloginname:'',status:''}
	$scope.frienddata;
	
	function getAllFriends()
	{
		console.log("inside getfriend");
		$http.get("http://localhost:8091/ChatMiddleware/showAllFriend")
		.then(function(response)
		{
			$scope.frienddata=response.data;
		});
		
	};
	
	getAllFriends();
});