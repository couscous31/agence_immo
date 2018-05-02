// Config de la table de routage

monApp.config(function($routeProvider){
	
	$routeProvider.when("/findAllContrat", {
						controller : "listeContratCtrl",
						templateUrl : "vues/listeContrat.html"})
						
					.when("/addContrat", {
						controller : "ajoutContratCtrl",
						templateUrl : "vues/addContrat.html"})
						
					.when("/updateContrat", {
						controller : "modifContratCtrl",
						templateUrl : "vues/modifContrat.html"})
						
					.when("/deleteContrat", {
						controller : "supContratCtrl",
						templateUrl : "vues/supContrat.html"})
					
					.otherwise({
						redirectTo : "/findAllContrat"})
	
});