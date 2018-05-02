monApp

.controller("listeBiCtrl", function($scope, biService){
	biService.getAllBi(function(callBack){
		$scope.listeBi=callBack;
	});
});


