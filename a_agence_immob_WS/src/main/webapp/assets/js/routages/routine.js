// Config de la table de routage

monApp.config(function($routeProvider){
	
					//Contrat
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
						
					//Propriétaire
					.when("/findAllProp", {
						controller:"listePropCTRL", 
						templateUrl: "vues/listeProp.html"})
						
					.when("/addProp", {
						controller:"ajoutPropCTRL", 
						templateUrl: "vues/ajoutProp.html"})
					
					.when("/updateProp", {
						controller:"modifPropCTRL", 
						templateUrl: "vues/modifProp.html"})
					
					.when("/deleteProp", {
						controller:"supprPropCTRL", 
						templateUrl: "vues/supprimProp.html"})
					
					.when("/searchProp", {
						controller:"recPropCTRL", 
						templateUrl: "vues/rechercheProp.html"})
			
					//Visite
					.when('/listevi', {
						controller : "listeviCtrl",
						templateUrl : "vues/conseilImmobilier.html"
					})
	
					.when('/addvi',{
						controller: "ajoutviCtrl",
						templateUrl: "vues/ajoutervi.html"
					})
					
					.when('/modifvi', {
						controller : "modifviCtrl",
						templateUrl : "vues/modifiervi.html"
					})
					
					.when('/suppvi', {
						controller : "supprviCtrl",
						templateUrl : "vues/supprimervi.html"
					})
					
					.when('/rechvi', {
						controller : "getbyidviCtrl",
						templateUrl : "vues/recherchevi.html"
					})
					
					//Bien immobilier
					.when("/findAllBi", {
						controller:"listeBiCTRL",
						templateUrl: "vues/listeBi.html"
					})
						
					.when("/addBi", {
						controller:"ajoutBiCTRL", 
						templateUrl: "vues/addBi.html"
					})
						
					.when("/updateBi", {
						controller:"modifBiCTRL", 
						templateUrl: "vues/modifBi.html"
					})
						
					.when("/deleteBi", {
						controller:"supprBiCTRL", 
						templateUrl: "vues/supprimBi.html"
					})
						
					.when("/searchBi", {
						controller:"recBiCTRL", 
						templateUrl: "vues/rechercheBi.html"
					})
						
					//Client
					.when("/findAllClient", {
						controller:"listeClientCtrl",
						templateUrl: "vues/listeClient.html"
					})
						
					.when("/addClient", {
						controller:"ajoutClientCtrl", 
						templateUrl: "vues/addClient.html"
					})
						
					.when("/updateClient", {
						controller:"modifClientCtrl", 
						templateUrl: "vues/modifClient.html"
					})
						
					.when("/deleteClient", {
						controller:"supClientCtrl", 
						templateUrl: "vues/supClient.html"
					})
						
					.when("/searchClient", {
						controller:"recClientCtrl", 
						templateUrl: "vues/rechClient.html"
					})
					
					.otherwise({
						redirectTo : "/findAllBi"})
	
});