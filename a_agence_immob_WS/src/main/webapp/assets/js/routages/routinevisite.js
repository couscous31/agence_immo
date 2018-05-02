//Configuration du routage
monApp.config(function($routeProvider) {

	$routeProvider.when('/listevi', {
		controller : "listeviCtrl",
		templateUrl : "vue/listevi.html"
	})

		.when('/rechvi', {
		controller : "getbyidviCtrl",
		templateUrl : "vue/recherchevi.html"
	})
	
	.when('/addvi',{
		controller: "ajoutviCtrl",
		templateUrl: "vue/ajoutervi.html"
	})

	.when('/suppvi', {
		controller : "supprviCtrl",
		templateUrl : "vue/supprimervi.html"
	})
	.when('/modifvi', {
		controller : "modifviCtrl",
		templateUrl : "vue/modifiervi.html"
	})
	
	.otherwise({redirectTo:'/listevi'})
});
