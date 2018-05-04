monApp.controller("listeBiCtrl", function($scope, biService2,$rootScope,$location){
	biService2.getAllBi(function(callBack){
		$scope.listeBi=callBack;
	});
	biService2.getAllSMin(function(callBack){
		$scope.listeSurface=callBack;
	});
	biService2.getAllPMax(function(callBack){
		$scope.listePrix=callBack;
	});
	
	// méthode pour afficher un bi du côté client
$scope.biRec = undefined;
	
	$scope.afficherBi = function(bi) {

		$rootScope.biRec = bi;
		$location.path("/afficherBiSeul");
	};
});