/**
 * 
 */
myApp.controller('FriendController',function($scope,$rootScope,$http,$location)
{
	$scope.friend={friendId:0,loginname:'',friendloginname:'',status:''}
	$scope.acceptfrienddata;
	$scope.pendingfrienddata;
	$scope.suggestedfrienddata;
	
	function getAllFriends()
	{
		console.log("inside getfriend");
		$http.get("http://localhost:8090/ChatMiddleware/showAllFriend")
		.then(function(response)
		{
			$scope.acceptfrienddata=response.data;
			console.log($scope.acceptfrienddata);
		});
		
	};
	
	function getPendingFriends()
	{
		console.log("inside pendingfriend");
		$http.get("http://localhost:8090/ChatMiddleware/showPendingRequestList")
		.then(function(response)
		{
			$scope.pendingfrienddata=response.data;
			console.log($scope.pendingfrienddata);
		});
		
	};
	
	function getSuggestedFriends()
	{
		console.log("inside suggestedfriend");
		$http.get("http://localhost:8090/ChatMiddleware/showSuggestedFriend",$scope.friend)
		.then(function(response)
		{
			$scope.suggestedfrienddata=response.data;
			console.log($scope.suggestedfrienddata);
		});
		
	};
	
	$scope.deleteFriendRequest=function(friendId)
	{
		console.log("inside deletefriend");
		$http.get('http://localhost:8090/ChatMiddleware/deleteFriendRequest/'+friendId)
		.then(getAllFriends(),function(response)
		{
			console.log("Deleted");
			$location.path('/Friends')
		});
	};
	
	$scope.acceptFriendRequest=function(friendId)
	{
		console.log("inside acceptfriend");
		$http.get('http://localhost:8090/ChatMiddleware/acceptFriendRequest/'+friendId)
		.then(getAllFriends(),function(response)
		{
			console.log("Accepted");
			$location.path('/Friends')
		});
	};
	
	$scope.sendFriendRequest=function(friendloginname)
	{
		console.log("inside sendfriend");
		$scope.friend.loginname=$rootScope.currentUser.loginname;
		$scope.friend.friendloginname=friendloginname;
		console.log($scope.friend.loginname+":"+$scope.friend.friendloginname);
		$http.post('http://localhost:8090/ChatMiddleware/sendFriendRequest/'+friendloginname)
		.then(function(response)
		{
			console.log("Requst send");
			$location.path('/Friends')
		});
	};
	
	getAllFriends();
	getPendingFriends();
	getSuggestedFriends();
});