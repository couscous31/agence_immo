monApp

.controller("listeviCtrl", function($scope, viService, $location, $rootScope) {
	// fonction recuperer la liste des proprietaire
	viService.getall(function(callBack) {
		$scope.listevi = callBack;
	})

})

.controller("getbyidviCtrl", function($scope, viService) {
	$scope.id = undefined;
	$scope.indice = false;
	$scope.indice1 = false;

	$scope.rechercheViId = function() {

		viService.getbyId($scope.id, function(callBack) {
			if (typeof callBack == "object") {
				$scope.indice = true;
				$scope.indice1 = false;
				$scope.viOut = callBack;
			} else {
				$scope.indice = false
				$scope.indice1 = true;
				$scope.message = "la visite n'existe pas ! "
			}

		})

	}

})

.controller("ajoutviCtrl", function($scope, viService, $location) {
	$scope.Visite = {
		datevisite : '',
		heure : '',
		id_bi:''
	}
	
	$scope.ajoutervisite = function() {
		viService.ajoutvi($scope.Visite, function(callBack) {
			if (typeof callBack == "object") {
				$location.path("listevi");
			} else {
				$scope.message = "ajout impossible"
			}
		})
	}

})

.controller("supprviCtrl", function($scope, viService, $location) {
	$scope.id;
	// fonction appelée via le boutton
	$scope.supprimervi = function() {
		viService.supp($scope.id, function(callBack) {
			if (callBack == 'OK') {
				$location.path("/listevi");
			} else {
				$scope.message = "suppression impossible ! "
			}
		})

	}
})

.controller("modifviCtrl",
		function($scope, viService, $location, $rootScope) {
				$scope.Visite = {
					id : '',
					datevisite : '',
					heure : '',
				}
				// fonction appelée via le bouton modifier
			$scope.modifiervi = function() {
				viService.modifvi($scope.Visite, function(callBack) {
					if (typeof callBack == "object") {
						$location.path("listevi");
					} else {
						$scope.message = "modif impossible"
					}
				})
			}

		})