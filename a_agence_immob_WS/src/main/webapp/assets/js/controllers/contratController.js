// Création des controllers de contrat

monApp.controller("listeContratCtrl", function($scope, contratService, $rootScope, $location) {
	
	//1ere méthode du controller : afficher la liste des contrats
	contratService.getAllContrat(function(callBack){
		$scope.listeContrats = callBack;
		console.log("Je suis dans le controller !");
	});
	
	// 2eme méthode du controller : supprimer un contrat
	$scope.supprimerLink = function(id) {

		// appel de la fonction supOneContrat du service
		contratService.supOneContrat(id, function(callBack) {

			if (callBack == 'OK') {
				contratService.getAllContrat(function(callBack) {
					$scope.listeContrats = callBack;
				});
			}
		})
	};

	// 3eme méthode du controller : modifier un contrat
	$rootScope.contratModif = {
		id : undefined
	};

	$scope.modifierLink = function(contrat) {
		$rootScope.contratModif = contrat;
		$location.path("updateContrat");

	};

})

.controller("ajoutContratCtrl", function($scope, contratService, $location) {

	$scope.contrat = {
		ref : '',
		dateSignature : '',
		client : {
			id : ''
			},
			telephone : '',
			ci : {
				id : ''
			},
		bi : {
			id : ''
		}
	},
	
	$scope.indice = false;

	// fonction appelée par le bouton
	$scope.ajouterContrat = function() {

		// appel de la fonction ajoutOne du service
		contratService.ajoutOneContrat($scope.contrat, function(callBack) {

			if (callBack == 'OK') {
				$location.path("findAllContrat");
			} else {
				$scope.message = "Fail !!!";
				$scope.indice = true;
			}

		})
	};
})

.controller("modifContratCtrl", function($scope, contratService, $location, $rootScope) {

	if ($rootScope.contratModif.id == undefined) {
		$scope.contrat = {
			id : '',
			ref : '',
			dateSignature : ''
		};

	} else {
		$scope.contrat = $rootScope.contratModif;
	}

	$scope.indice = false;

	// fonction appelée par le bouton
	$scope.modifierContrat = function() {

		// appel de la fonction modif du service
		contratService.modifContrat($scope.contrat, function(callBack) {

			if (callBack == 'OK') {
				$location.path("findAllContrat");
			} else {
				$scope.message = "Fail !!!";
				$scope.indice = true;
			}

		})
	};
})
