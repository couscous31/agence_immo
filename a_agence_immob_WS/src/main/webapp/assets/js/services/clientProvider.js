// Création du service pour récup les données du WS

monApp.factory("clService", function($http){
	
	var restUrl = "http://localhost:8080/a_agence_immob_WS";
	
	//méthode afficher la liste
	function findAllClient(busSC) {
		
		$http({
			method : "GET",
			url : restUrl + "/listeClient"
				
		}).then (function successCallback(response) {
			console.log(response.data);
			busSC(response.data);
		}, function errorCallback(response) {
			console.log("Erreur : ------" + response.statusText);
		})
	}
	
	//méthode ajouter un client
	function addOneClient(client, busSC) {
		
		$http({
			method : "POST",
			url : restUrl + "/client",
			//on veut un JSON en sortie de la requête
			data : angular.toJson(client),
			//la requête consomme un JSON
			headers : {ContentType : "application/JSON"}
				
		}).then (function successCallback(response) {
			console.log(response.data);
			busSC(response.data);
		}, function errorCallback(response) {
			console.log("Erreur : ------" + response.statusText);
		})
	}
	
	// méthode modifier un client
	function updateClient(client, busSC) {

		$http({
			method : "PUT",
			url : restUrl + "/client",
			//on veut un JSON en sortie de la requête
			data : angular.toJson(client),
			//la requête consomme un JSON
			headers : {ContentType : "application/JSON"}

		}).then(function successCallback(response) {
			busSC(response.statusText);

		}, function errorCallback(response) {
			console.log("Erreur : ----" + response.statusText);

		})

	}
	
	// méthode supprimer
	function delOneClient(id, busSC) {

		$http({
			method : "DELETE",
			url : restUrl + "/client/" + id

		}).then(function successCallback(response) {
			busSC(response.statusText);

		}, function errorCallback(response) {
			console.log("Erreur : ----" + response.statusText);

		})

	}
	
	// méthode recherche par id
	function findOneClient(id, busSC) {

		$http.get(restUrl + "/client?pId=" + id)

		.then(function successCallback(response) {
			busSC(response.data);

		}, function errorCallback(response) {
			console.log("Erreur : ----" + response.statusText);

		})

	}
	
	return {
		getAllClient : findAllClient,
		ajoutOneClient : addOneClient,
		modifClient : updateClient,
		supOneClient : delOneClient,
		getOneClient : findOneClient
		
	}
	
});