// Création des controllers de client

monApp.controller("listeClientCtrl", function($scope, clService, $rootScope, $location) {
	
	//1ere méthode du controller : afficher la liste des clients
	clService.getAllClient(function(callBack){
		$scope.listeClients = callBack;
	});
	
	// 2eme méthode du controller : supprimer un contrat
	$scope.supprimerLink = function(id) {

		// appel de la fonction supOneContrat du service
		clService.supOneClient(id, function(callBack) {

			if (callBack == 'OK') {
				clService.getAllClient(function(callBack) {
					$scope.listeClients = callBack;
				});
			}
		})
	};

	// 3eme méthode du controller : modifier un contrat
	$rootScope.clModif = {
		id : undefined
	};

	$scope.modifierLink = function(client) {
		$rootScope.clModif = client;
		$location.path("updateClient");

	};

})

.controller("ajoutClientCtrl", function($scope, clService, $location) {

	$scope.client = {
		nom : '',
		adresse : {
			numero : '',
			rue : '',
			codePostal : '',
			ville : ''
		},
		telephone : '',
		email : ''
	};
	
	$scope.indice = false;

	// fonction appelée par le bouton
	$scope.ajouterClient = function() {

		// appel de la fonction ajoutOneClient du service
		contratService.ajoutOneClient($scope.client, function(callBack) {

			if (callBack == 'OK') {
				$location.path("findAllClient");
			} else {
				$scope.message = "Fail !!!";
				$scope.indice = true;
			}

		})
	};
})

.controller("modifClientCtrl", function($scope, clService, $location, $rootScope) {

	if ($rootScope.clModif.id == undefined) {
		$scope.client = {
			id : '',
			nom : '',
			adresse : {
				numero : '',
				rue : '',
				codePostal : '',
				ville : ''
			},
			telephone : '',
			email : ''
		};

	} else {
		$scope.client = $rootScope.clModif;
	}

	$scope.indice = false;

	// fonction appelée par le bouton
	$scope.modifierClient = function() {

		// appel de la fonction modif du service
		clService.modifClient($scope.client, function(callBack) {

			if (callBack == 'OK') {
				$location.path("findAllClient");
			} else {
				$scope.message = "Fail !!!";
				$scope.indice = true;
			}

		})
	};
})

.controller("recClientCtrl", function($scope, clService) {

	$scope.id = undefined;
	$scope.indice = false;
	$scope.indice1 = false;

	// fonction appelée via le bouton
	$scope.rechercheClientParId = function() {

		// appel de la fonction getOne du service
		clService.getOneClient($scope.id, function(callBack) {

			if (typeof callBack == "object") {
				$scope.clOut = callBack;
				$scope.indice = true;
				$scope.indice1 = false;
			} else {
				$scope.indice = false;
				$scope.indice1 = true;
				$scope.message = "Fail !!!";
			}
		})
	};

});

