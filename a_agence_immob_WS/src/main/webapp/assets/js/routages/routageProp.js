//configurer le routage pour les proprietaires
monApp.config(function($routeProvider){
	$routeProvider
			.when("/findAllProp",{controller:"listePropCTRL", templateUrl: "vues/listeProp.html"})
			.when("/addProp",{controller:"ajoutPropCTRL", templateUrl: "vues/ajoutProp.html"})
			.when("/updateProp",{controller:"modifPropCTRL", templateUrl: "vues/modifProp.html"})
			.when("/deleteProp",{controller:"supprPropCTRL", templateUrl: "vues/supprimProp.html"})
			.when("/searchProp",{controller:"recPropCTRL", templateUrl: "vues/rechercheProp.html"})
			.otherwise({
				redirectTo:"/findAllProp"
			})
});			
