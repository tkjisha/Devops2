/**
 * 
 */
myApp.controller("BlogController",function($scope,$rootScope,$http,$location)
{
	$scope.blog={blogName:'',blogContent:'',createDate:'',status:'',likes:0,loginname:''}
	$rootScope.blog1={blogName:'',blogContent:'',createDate:'',status:'',likes:0,loginname:''}
	$scope.blogdata;
	$scope.blogcommentdata;
	$rootScope.bid;
	$rootScope.bgid;
	$scope.blogcomment={commentText:'',blogId:0,loginname:'',commentDate:''}
	
	$scope.val='false';
	$scope.insertBlog=function()
	{
		console.log("inside blog controller insert");
		$http.post("http://localhost:8090/ChatMiddleware/addblog",$scope.blog)
		.then(fetchAllBlogs(),function(response)
		{
			console.log('Status Text'+response.statusText);
		});
		
	};
	
	function fetchAllBlogs()
	{
		console.log("fetching all blogs");
		$http.get("http://localhost:8090/ChatMiddleware/getallblog",$scope.blog)
		.then(function(response)
		{
			$scope.blogdata=response.data;
			
		});
		
	};
	
	function getAllBlogComments()
	{
		console.log("fetching all blogs comments");
		$http.get("http://localhost:8090/ChatMiddleware/listblogcomment",$scope.blogcomment)
		.then(function(response)
		{
			$scope.blogcommentdata=response.data;
			
		});
	};
	
	$scope.editBlog=function(blogId)
	{
		console.log("inside blog edit"+blogId);
		$http.get('http://localhost:8090/ChatMiddleware/getblog/'+blogId)
		.then(function(response)
				{console.log('Status Text');
					$scope.blog=response.data;
					$scope.val='true';
					console.log($scope.val);
					$location.path('/blog')
				});
	};
	
	$scope.getBlog=function(blogId)
	{
		console.log("inside blog get"+blogId);
		$http.get('http://localhost:8090/ChatMiddleware/getblog/'+blogId)
		.then(function(response)
				{ 
			console.log('Status Text');
			$scope.blog=response.data;
			$rootScope.bid=$scope.blog.blogId;
			console.log($rootScope.bid+":"+$scope.blog.blogId);
			$location.path('/viewblogs')
				});
	};
	$scope.deleteBlog=function(blogId)
	{
		console.log("inside blog delete");
		$http.get('http://localhost:8090/ChatMiddleware/deleteblog/'+blogId)
		.then(fetchAllBlogs(),function(response)
				{
					console.log('Deleted');
					$location.path('/blog')
				});
	};
	
	$scope.incrementLike=function(blogId)
	{
		console.log("inside like increment");
		$http.get('http://localhost:8090/ChatMiddleware/incrementlike/'+blogId)
		.then(fetchAllBlogs(),function(response)
				{
					console.log('Incremented');
					$location.path('/blog')
				});
	};
	
	$scope.updateBlog=function(blogId)
	{
		console.log("inside blog update"+blogId);
		$http.post('http://localhost:8090/ChatMiddleware/updateblog/'+blogId,$scope.blog)
		.then(fetchAllBlogs(),function(response)
				{
					$scope.blog=response.data;
					console.log('Updated');
					$location.path('/blog');
				});
	};
	
	$scope.approveBlog=function(blogId)
	{
		console.log("inside approve blog");
		$http.get('http://localhost:8090/ChatMiddleware/approveblog/'+blogId)
		.then(function(response)
				{
					$scope.blog=response.data;
					console.log('blog approved');
					$location.path('/Blogview');
				});
	};
	
	$scope.rejectBlog=function(blogId)
	{
		console.log("inside reject blog");
		$http.get('http://localhost:8090/ChatMiddleware/rejectblog/'+blogId)
		.then(function(response)
				{
					$scope.blog=response.data;
					console.log('blog rejected');
					$location.path('/Blogview');
				});
	};
	
	$scope.addBlogComment=function()
	{
		console.log("inside comment blog");
		$http.post("http://localhost:8090/ChatMiddleware/addblogcomment",$scope.blogcomment)
		.then(getAllBlogComments(),function(response)
		{
			console.log('Comment added');
		});
		
	};
	
	$scope.deleteComment=function(commentId)
	{
		console.log("inside comment delete");
		$http.get("http://localhost:8090/ChatMiddleware/deleteblogcomment/"+commentId)
		.then(getAllBlogComments(),function(response)
		{
			console.log('comment deleted');
		});
		
	};
	 
	
	fetchAllBlogs();
	getAllBlogComments();
});