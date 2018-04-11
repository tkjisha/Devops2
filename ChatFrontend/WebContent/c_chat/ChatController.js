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
			ChatService.send($rootScope.currentUser.loginname+":"+$scope.message);
			$scope.message="";
		};
		
		ChatService.receive().then(null,null,function(message)
		{
			$scope.message.push(message);
		});
	
	});