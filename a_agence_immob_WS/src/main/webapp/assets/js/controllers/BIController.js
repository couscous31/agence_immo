monApp

.controller("listeBiCtrl", function($scope, biService) {
	
});

monApp.controller("ajoutBiCtrl", function($scope, biService) {

	$scope.ajouter = function() {

		biService.localisationBi($scope.rue, $scope.codePostal, $scope.ville,
				function(callBack)
		{
			$scope.lat = callBack.results[0].geometry.location.lat;
			$scope.lng = callBack.results[0].geometry.location.lng;

			console.log($scope.lat);
			console.log($scope.lng);
		})

	} 

})