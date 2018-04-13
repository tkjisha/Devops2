/**
 * 
 */
myApp.controller('FriendController',function($scope,$rootScope,$http,$location)
{
	$scope.friend={friendId:0,loginname:'',friendloginname:'',status:''}
	$scope.acceptfrienddata;
	$scope.pendingfrienddata;
	$scope.suggestfrienddata;
	
	function getAllFriends()
	{
		console.log("inside getfriend");
		$http.get("http://localhost:8091/ChatMiddleware/showAllFriend")
		.then(function(response)
		{
			$scope.acceptfrienddata=response.data;
			console.log($scope.acceptfrienddata);
		});
		
	};
	
	function getPendingFriends()
	{
		console.log("inside pendingfriend");
		$http.get("http://localhost:8091/ChatMiddleware/showPendingRequestList")
		.then(function(response)
		{
			$scope.pendingfrienddata=response.data;
			console.log($scope.pendingfrienddata);
		});
		
	};
	
	function getSuggestedFriends()
	{
		console.log("inside suggestedfriend");
		$http.get("http://localhost:8091/ChatMiddleware/showSuggestedFriend")
		.then(function(response)
		{
			$scope.suggestedfrienddata=response.data;
			console.log($scope.suggestedfrienddata);
		});
		
	};
	
	$scope.deleteFriendRequest=function(friendId)
	{
		console.log("inside deletefriend");
		$http.get('http://localhost:8091/ChatMiddleware/deleteFriendRequest/'+friendId)
		.then(getAllFriends(),function(response)
		{
			console.log("Deleted");
			$location.path('/Friends')
		});
	};
	
	$scope.acceptFriendRequest=function(friendId)
	{
		console.log("inside acceptfriend");
		$http.get('http://localhost:8091/ChatMiddleware/acceptFriendRequest/'+friendId)
		.then(getAllFriends(),function(response)
		{
			console.log("Accepted");
			$location.path('/Friends')
		});
	};
	
	$scope.sendFriendRequest=function(friendId)
	{
		console.log("inside sendfriend");
		$http.get('http://localhost:8091/ChatMiddleware/sendFriendRequest/'+friendId)
		.then(getAllFriends(),function(response)
		{
			
		});
	};
	
	getAllFriends();
	getPendingFriends();
	getSuggestedFriends();
});