monApp.controller("listeBiCtrl", function($scope, biService,$rootScope,$location){
	biService.getAllBi(function(callBack){
		$scope.listeBi=callBack;
	});
	biService.getAllSMin(function(callBack){
		$scope.listeSurface=callBack;
	});
	biService.getAllPMax(function(callBack){
		$scope.listePrix=callBack;
	});
	
	// méthode pour afficher un bi du côté client
$scope.biRec = undefined;
	
	$scope.afficherBi = function(bi) {

		$rootScope.biRec = bi;
		$location.path("/afficherBiSeul");
	};
});