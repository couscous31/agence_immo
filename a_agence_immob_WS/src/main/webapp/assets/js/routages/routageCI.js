//configurer le routage pour les proprietaires
monApp.config(function($routeProvider) {
	$routeProvider.when("/LoginSpace", { controller : "LoginController", templateUrl : "vues/login.html"
	})
	.when('/listevi', { controller : "listeviCtrl", templateUrl : "vues/conseilImmobilier.html"})

});