//Configuration du routage
monApp.config(function($routeProvider) {

	$routeProvider.when('/listevi', {
		controller : "listeviCtrl",
		templateUrl : "vues/listevi.html"
	})

		.when('/rechvi', {
		controller : "getbyidviCtrl",
		templateUrl : "vues/recherchevi.html"
	})
	
	.when('/addvi',{
		controller: "ajoutviCtrl",
		templateUrl: "vues/ajoutervi.html"
	})

	.when('/suppvi', {
		controller : "supprviCtrl",
		templateUrl : "vues/supprimervi.html"
	})
	.when('/modifvi', {
		controller : "modifviCtrl",
		templateUrl : "vues/modifiervi.html"
	})
	
	.otherwise({redirectTo:'/listevi'})
});
