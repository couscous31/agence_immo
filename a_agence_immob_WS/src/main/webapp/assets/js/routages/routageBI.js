//configurer le routage pour les proprietaires
monApp.config(function($routeProvider){
	$routeProvider
			.when("/findAllBi", {controller:"listeBiCtrl",templateUrl: "vues/listeBi.html"})
			.when("/addBi",{controller:"ajoutBiCTRL", templateUrl: "vues/ajoutBi.html"})
			.when("/updateBi",{controller:"modifBiCTRL", templateUrl: "vues/modifBi.html"})
			.when("/deleteBi",{controller:"supprBiCTRL", templateUrl: "vues/supprimBi.html"})
			.when("/searchBi",{controller:"recBiCTRL", templateUrl: "vues/rechercheBi.html"})
			.otherwise({
				redirectTo:"/findAllBi"
			})
});