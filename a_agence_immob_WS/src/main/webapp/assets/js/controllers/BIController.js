monApp

.controller("listeBiCTRL", function($scope, biService, $location, $rootScope) {
	
	// 1ere fonction du controller : recuperer la liste des biens immobiliers
	biService.getAll(function(callBack) {
		$scope.listeBienImmobiliers = callBack;
	});
	
	// 2eme fct du controller : supprimer un bi
	$scope.supprimerLink = function(id) {
		
		//appel de la fonction suppOne du service
		biService.suppOne(id, function(callBack) {
			
			if (callBack == 'OK') {
				biService.getAll(function(callBack) {
					$scope.listeBienImmobiliers = callBack;
				});
			}
		})
	};
	
	// 3eme fct du controller : modifier un bi
	$rootScope.biModif = {
			id : undefined
	};
	
	$scope.modifierLink = function(bi) {
		$rootScope.biModif = bi;
		$location.path("updateBi");
	};

})



.controller("ajoutBiCTRL", function($scope, biService, $location) {
	$scope.bienImmobilier = {
		type : null,
		codePostal : null,
		numero : null,
		rue : null,
		ville : null,
		dateDispo : null,
		dateSoumission : null,
		photoBI : null,
		prix : null,
		revenuCadastral : null,
		statut : null,
		etat : null,
		prixAchat : null,
		caution : null,
		charges : null,
		loyer : null,
		meubles : null,
		typeBail : null,
		cs_id : null,
		prop_id : null
	}
	// fonction appelée via le bouton ajouter
	$scope.ajouterBi = function() {
		
		biService.ajoutOne($scope.bienImmobilier, function(callBack) {
			if (typeof callBack == "object") {
								
				$location.path("findAllBi");
			} else {
				$scope.message = "ajout impossible"
			}
		})
	}
	 
			

})

.controller("modifBiCTRL", function($scope, biService, $location, $rootScope) {
	
	if ($rootScope.biModif.id == undefined) {
		$scope.bi = {
				id : null,
				type : null,
				codePostal : null,
				numero : null,
				rue : null,
				ville : null,
				dateDispo : null,
				dateSoumission : null,
				photoBI : null,
				prix : null,
				revenuCadastral : null,
				statut : null,
				etat : null,
				prixAchat : null,
				caution : null,
				charges : null,
				loyer : null,
				meubles : null,
				typeBail : null,
				cs_id : null,
				prop_id : null
		};
		
	} else {
		$scope.bi = $rootScope.biModif;
	}
	
	$scope.indice = false;
	
	// fonction appelée via le bouton modifier
	$scope.modifierBi = function() {
		
		biService.modifOne($scope.bi, function(callBack) {
			
			if (typeof callBack == "object") {
				$location.path("findAllBi");
			} else {
				$scope.message = "modif impossible";
				$scope.indice = true;
			}
		})
	};

})

.controller("supprBiCTRL", function($scope, biService, $location) {

	$scope.idDel;
	// fonction appelée via le boutton
	$scope.supprimerBiParId = function() {

		biService.suppOne($scope.idDel, function(callBack) {
			if (callBack == 'OK') {
				$location.path("/findAllBi");
			} else {
				$scope.message = "suppression impossible ! "
			}
		})

	}
})

.controller("recBiCTRL", function($scope, biService) {
	$scope.id;
	$scope.indice = false;
	$scope.indice1 = false;

	// fonction appeler via le boutton
	$scope.rechercherParID = function() {
		// appel de la fonction getById du service
		biService.getOne($scope.id, function(callBack) {
			if (typeof callBack == "object") {
				$scope.indice = true;
				$scope.indice1 = false;
				$scope.propOut = callBack;
				
				var adresse=$scope.propOut.adresse;
				
				

				 biService.localisationBi(adresse.numero+" "+adresse.rue,adresse.codePostal,adresse.ville,function(callBack) {
					 
							 $scope.lat = callBack.results[0].geometry.location.lat;
							 $scope.lng = callBack.results[0].geometry.location.lng;
							
							 console.log($scope.lat);
							 console.log($scope.lng);
				 
					
				});

			} else {
				$scope.indice = false
				$scope.indice1 = true;
				$scope.message = "le BI rechercher n'existe pas ! "
			}

		})

	}
})

//.controller("ajoutBiCtrl",function($scope, biService) {
//	 $scope.ajouter = function() {
//	
//	 biService.localisationBi($scope.rue,$scope.codePostal,$scope.ville,function(callBack) {
//		 
//	 $scope.lat = callBack.results[0].geometry.location.lat;
//	 $scope.lng = callBack.results[0].geometry.location.lng;
//	
//	 console.log($scope.lat);
//	 console.log($scope.lng);
//		
//		})
//	}
//
//})


.controller("BiSeulCTRL", function($scope, bienImmobilier, biService, $rootScope, $location) {

	$scope.bienImmobilier;
	// fonction appelée via le boutton
	$scope.afficheBiSeul = function() {

		biService.suppOne($scope.idDel, function(callBack) {
			if (callBack == 'OK') {
				$location.path("/findAllBi");
			} else {
				$scope.message = "suppression impossible ! "
			}
		})

	}
})

		
.controller("recBiPrCTRL", function($scope, biService) {
	$scope.id_prop;
	$scope.indice = false;
	$scope.indice1 = false;

	// fonction appeler via le boutton
	$scope.rechercherParIDprop = function() {
		// appel de la fonction getById du service
		biService.getOneprop($scope.id_prop, function(callBack) {
			if (typeof callBack == "object") {
				$scope.indice = true;
				$scope.indice1 = false;
				$scope.propOut = callBack;
			} else {
				$scope.indice = false
				$scope.indice1 = true;
				$scope.message = "le proprietaire recherche n'existe pas ! "
			}

		})

	}
})


