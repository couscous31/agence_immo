//configurer le routage pour les proprietaires
monApp.config(function($routeProvider){
	$routeProvider
			.when("/", {controller:"LoginController",templateUrl: "vues/login.html"})
			.when("/listeContrat",{templateUrl: "vues/listeContrat"})
			.otherwise({
				redirectTo:"/"
			})
});