/**
 * 
 */
myApp.controller("BlogController",function($scope,$rootScope,$http,$location)
{
	$scope.blog={blogId:0,blogName:'',blogContent:'',createDate:'',status:'',likes:0,loginname:''}
	$rootScope.blog1={blogName:'',blogContent:'',createDate:'',status:'',likes:0,loginname:''}
	$scope.blogdata;
	
	$scope.insertBlog=function()
	{
		console.log("inside blog controller insert");
		$http.post("http://localhost:8091/ChatMiddleware/addblog",$scope.blog)
		.then(fetchAllBlogs(),function(response)
		{
			console.log('Status Text'+response.statusText);
		});
		
	};
	
	function fetchAllBlogs()
	{
		console.log("fetching all blogs");
		$http.get("http://localhost:8091/ChatMiddleware/listblog",$scope.blog)
		.then(function(response)
		{
			$scope.blogdata=response.data;
		});
		
	};
	
	$scope.editBlog=function(blogId)
	{
		console.log("inside blog edit"+blogId);
		$http.get('http://localhost:8091/ChatMiddleware/getblog/'+blogId)
		.then(function(response)
				{console.log('Status Text');
					$rootScope.blog1=response.data;
					console.log('Status Text'+response.statusText);console.log($rootScope.blog1.blogId);
					$scope.bid=$rootScope.blog1.blogId;
					$location.path('/UpdateBlog')
				});
	};
	
	$scope.deleteBlog=function(blogId)
	{
		console.log("inside blog delete");
		$http.get('http://localhost:8091/ChatMiddleware/deleteblog/'+blogId)
		.then(fetchAllBlogs(),function(response)
				{
					console.log('Deleted');
					$location.path('/blog')
				});
	};
	
	$scope.incrementLike=function(blogId)
	{
		console.log("inside like increment");
		$http.get('http://localhost:8091/ChatMiddleware/incrementlike/'+blogId)
		.then(fetchAllBlogs(),function(response)
				{
					console.log('Incremented');
					$location.path('/blog')
				});
	};
	
	$scope.updateBlog=function(blogId)
	{
		console.log("inside blog update");
		$http.get('http://localhost:8091/ChatMiddleware/updateblog/'+blogId,$scope.blog1)
		.then(fetchAllBlogs(),function(response)
				{
					$scope.blog=response.data;
					console.log('Status Text'+response.statusText);
					$location.path('/blog')
				});
	};
	
	fetchAllBlogs();
});