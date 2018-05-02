monApp.controller("listeBiCtrl", function($scope, biService){
	biService.getAllBi(function(callBack){
		$scope.listeBi=callBack;
	});
	biService.getAllSMin(function(callBack){
		$scope.listeSurface=callBack;
	});
	biService.getAllPMax(function(callBack){
		$scope.listePrix=callBack;
	});
});