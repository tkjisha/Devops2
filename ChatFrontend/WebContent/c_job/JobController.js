/**
 * 
 */
myApp.controller("JobController",function($scope,$rootScope,$http,$location)
{
	$scope.job={jobId:0,description:'',desig:'',company:'',sal:0,ctc:0,postdate:''}
	
	$scope.jobdata;
	$scope.myjobs;
	
	function listjobs()
	{
		console.log("fetching all jobs");
		$http.get("http://localhost:8090/ChatMiddleware/listjob")
		.then(function(response)
		{
			$scope.jobdata=response.data;
					
		});
	};
	
	
	$scope.add=function()
	{
		console.log("call add");
		$location.path('/addjob');
	};
	
	$scope.view=function()
	{
		console.log("call VIEW");
		$location.path('/myjobs');
	};
	$scope.addJob=function()
	{
		console.log("inside add job");
		$http.post("http://localhost:8090/ChatMiddleware/addjob",$scope.job)
		.then(function(response)
		{
			console.log('Status Text'+response.statusText);
		});
	};
	
	$scope.deleteJob=function(jobId)
	{
		console.log("inside delete job");
		$http.get('http://localhost:8090/ChatMiddleware/deletejob/'+jobId)
		.then(listjobs(),function(response)
				{
					console.log('Deleted');
					$location.path('/Jobs');
				});
	};
	
	$scope.applyJob=function(jobId)
	{
		console.log("inside apply job");
		$http.post('http://localhost:8090/ChatMiddleware/applyJob/'+jobId)
		.then(function(response)
				{
					console.log('Applied');
					$location.path('/Jobs');
				});
	}
	
	function listmyjobs()
	{
		console.log("fetching my jobs");
		$http.get("http://localhost:8090/ChatMiddleware/showmyjobs")
		.then(function(response)
		{
			$scope.myjobs=response.data;			
		});
	};
	
	listjobs();
	listmyjobs();
});	