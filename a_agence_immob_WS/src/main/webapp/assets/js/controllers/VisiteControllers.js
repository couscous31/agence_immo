monApp

.controller("listeviCtrl", function($scope, viService, $location, $rootScope) {
	// fonction recuperer la liste des proprietaire
	viService.getall(function(callBack) {
		$scope.listevi = callBack;
	});

	// 2eme méthode du controller : supprimer un contrat
	$scope.supprimerBouton = function(id) {

		// appel de la fonction supOneContrat du service
		viService.supp(id, function(callBack) {

			if (callBack == 'OK') {
				clService.getall(function(callBack) {
					$scope.listevi = callBack;
				});
			}
		})
	};
	// 3eme méthode du controller : modifier un contrat
	$rootScope.viModif = {
		id : undefined
	};

	$scope.modifierBouton = function(Visite) {
		$rootScope.viModif = Visite;
		$location.path("modifvi");

	};

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
		heure : ''
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