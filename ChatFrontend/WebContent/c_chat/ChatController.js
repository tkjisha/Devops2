/**
 * 
 */
myApp.controller("ChatController",function($scope,$rootScope,ChatService)
	{
		$scope.messages=[];
		$scope.message="";
		$scope.max=140	;
		
		$scope.addMessage=function()
		{
			console.log("send");
			ChatService.send($rootScope.currentUser.loginname+":"+$scope.message);
			$scope.message="";
		};
		
		ChatService.receive().then(null,null,function(message)
		{
			$scope.messages.push(message);
		});
	
	});