/**
 * 
 */
myApp.controller("ForumController",function($scope,$rootScope,$http,$location)
{
	$scope.forum={forumId:0,forumName:'',forumContent:'',createDate:'',status:'',loginname:''}
	$rootScope.forum1={forumId:0,forumName:'',forumContent:'',createDate:'',status:'',loginname:''}
	$scope.forumdata;
	$scope.forumcomment={fcommentText:'',loginname:'',forumId:0,fmCommentDate:''}
	$rootScope.fid;
	$rootScope.frid;
	$scope.forumcommentdata;
	
	$scope.insertForum=function()
	{
		console.log("inside forum controller insert");
		$http.post('http://localhost:8090/ChatMiddleware/addforum',$scope.forum)
		.then(fetchAllForums(),function(response)
		{
			console.log('Status Text'+response.statusText);
		});
	};
	
	function fetchAllForums()
	{
		console.log("fetching all forums");
		$http.get('http://localhost:8090/ChatMiddleware/listforum',$scope.forum)
		.then(function(response)
		{
			$scope.forumdata=response.data;
		});
		
	};
	
	function getAllForumComments()
	{
		console.log("fetching all forum comments");
		$http.get("http://localhost:8090/ChatMiddleware/listforumcomment",$scope.forumcomment)
		.then(function(response)
		{
			$scope.forumcommentdata=response.data;
			
		});
	};
	
	$scope.editForum=function(forumId)
	{
		console.log("inside forum edit"+forumId);
		$http.get('http://localhost:8090/ChatMiddleware/getforum/'+forumId)
		.then(function(response)
			{ 
				console.log('Status Text');
				$rootScope.forum1=response.data;
				$rootScope.frid=$rootScope.forum1.forumId;
				console.log($rootScope.forum1.forumId);
				$location.path('/updateforum');
			});
	};
	
	$scope.getForum=function(forumId)
	{
		console.log("inside forum get"+forumId);
		$http.get('http://localhost:8090/ChatMiddleware/getforum/'+forumId)
		.then(function(response)
			{ 
				console.log('Status Text');
				$scope.forum=response.data;
				$rootScope.fid=$scope.forum.forumId;
				console.log($rootScope.fid+":"+$scope.forum.forumId);
				$location.path('/viewforums');
			});
	};
	
	$scope.deleteForum=function(forumId)
	{
		console.log("inside forum delete");
		$http.get('http://localhost:8090/ChatMiddleware/deleteforum/'+forumId)
		.then(fetchAllForum(),function(response)
				{
					console.log('Deleted');
					$location.path('/Forum')
				});
	};
	
	$scope.approveForum=function(forumId)
	{
		console.log("inside approve forum");
		$http.get('http://localhost:8090/ChatMiddleware/approveforum/'+forumId)
		.then(function(response)
				{
					$scope.forum=response.data;
					console.log('Status Text'+response.statusText);
					$location.path('/Forumview');
				});
	};
	
	$scope.rejectForum=function(forumId)
	{
		console.log("inside reject forum");
		$http.get('http://localhost:8090/ChatMiddleware/rejectforum/'+forumId)
		.then(function(response)
				{
					$scope.forum=response.data;
					console.log('Status Text'+response.statusText);
					$location.path('/Forumview');
				});
	};
	
	$scope.addForumComment=function()
	{
		console.log("inside comment forum");
		$http.post("http://localhost:8090/ChatMiddleware/addforumcomment",$scope.forumcomment)
		.then(getAllForumComments(),function(response)
		{
			console.log('Status Text'+response.statusText);
		});
		
	};
	
	$scope.deleteForumComment=function(fcommentId)
	{
		console.log("inside comment delete");
		$http.get("http://localhost:8090/ChatMiddleware/deleteforumcomment/"+fcommentId)
		.then(getAllforumComments(),function(response)
		{
			console.log('Status Text'+response.statusText);
		});
		
	};
	
	fetchAllForums();
	getAllForumComments();
});