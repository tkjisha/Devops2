/**
 * 
 */
myApp.controller("ForumController",function($scope,$http,$location)
{
	$scope.forum={forumId:0,forumName:'',forumContent:'',createDate:'',status:'',loginname:''}
	$scope.forumdata;
	
	$scope.insertForum=function()
	{
		console.log("inside forum controller insert");
		$http.post('http://localhost:8091/ChatMiddleware/addforum',$scope.forum)
		.then(fetchAllForums(),function(response)
		{
			console.log('Status Text'+response.statusText);
		});
	};
	
	function fetchAllForums()
	{
		console.log("fetching all forums");
		$http.get('http://localhost:8091/ChatMiddleware/listforum',$scope.forum)
		.then(function(response)
		{
			$scope.forumdata=response.data;
		});
		
	};
	
	$scope.deleteForum=function(forumId)
	{
		console.log("inside forum delete");
		$http.get('http://localhost:8091/ChatMiddleware/deleteforum/'+forumId)
		.then(fetchAllForum(),function(response)
				{
					console.log('Deleted');
					$location.path('/Forum')
				});
	};
	
	fetchAllForums();
});