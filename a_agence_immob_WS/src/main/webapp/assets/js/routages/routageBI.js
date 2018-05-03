//configurer le routage pour les proprietaires
monApp.config(function($routeProvider){
	$routeProvider
			.when("/findAllBi", {controller:"listeBiCTRL",templateUrl: "vues/listeBi.html"})
			.when("/addBi",{controller:"ajoutBiCTRL", templateUrl: "vues/addBi.html"})
			.when("/updateBi",{controller:"modifBiCTRL", templateUrl: "vues/modifBI.html"})
			.when("/deleteBi",{controller:"supprBiCTRL", templateUrl: "vues/supprimBI.html"})
			.otherwise({
				redirectTo:"/findAllBi"
			})
});