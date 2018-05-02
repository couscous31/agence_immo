//les controllers de la  partir proprietaire

monApp

.controller("listePropCTRL",
		function($scope, propService, $location, $rootScope) {
			// fonction recuperer la liste des proprietaire
			propService.getAll(function(callBack) {
				$scope.listeProprietaires = callBack;
			})

		})

.controller("ajoutPropCTRL", function($scope, propService, $location) {
	$scope.proprietaire = {
		codePostal : null,
		numero : null,
		rue : null,
		ville : null,
		nom : null,
		telPerso : null,
		telPro : null
	}
	// fonction appelée via le bouton ajouter
	$scope.ajouter = function() {
		propService.ajoutOne($scope.proprietaire, function(callBack) {
			if (typeof callBack == "object") {
				$location.path("findAllProp");
			} else {
				$scope.message = "ajout impossible"
			}
		})
	}

})

.controller("modifPropCTRL",
		function($scope, propService, $location, $rootScope) {
				$scope.proprietaire = {
					id : null,
					codePostal : null,
					numero : null,
					rue : null,
					ville : null,
					nom : null,
					telPerso : null,
					telPro : null
				}
				// fonction appelée via le bouton modifier
			$scope.modifier = function() {
				propService.modifOne($scope.proprietaire, function(callBack) {
					if (typeof callBack == "object") {
						$location.path("findAllProp");
					} else {
						$scope.message = "modif impossible"
					}
				})
			}

		})

.controller("supprPropCTRL", function($scope, propService, $location) {
	$scope.idDel;
	// fonction appelée via le boutton
	$scope.supprimerParId = function() {
		propService.suppOne($scope.idDel, function(callBack) {
			if (callBack == 'OK') {
				$location.path("/findAllProp");
			} else {
				$scope.message = "suppression impossible ! "
			}
		})

	}
})

.controller("recPropCTRL", function($scope, propService) {
	$scope.id;
	$scope.indice = false;
	$scope.indice1 = false;

	// fonction appeler via le boutton
	$scope.rechercherParID = function() {
		// appel de la fonction getById du service
		propService.getOne($scope.id, function(callBack) {
			if (typeof callBack == "object") {
				$scope.indice = true;
				$scope.indice1 = false;
				$scope.propOut = callBack;
			} else {
				$scope.indice = false
				$scope.indice1 = true;
				$scope.message = "le proprietaire recherche n'existe pas ! "
			}

		});

	}

});
