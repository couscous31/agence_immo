// Création du service pour récup les données du WS

monApp.factory("contratService", function($http){
	
	var restUrl = "http://localhost:8080/a_agence_immob_WS";
	
	//méthode afficher la liste
	function findAllContrat(busSC) {
		
		console.log("Je suis dans le provider");
		
		$http({
			method : "GET",
			url : restUrl + "/listeContrat"
				
		}).then (function successCallback(response) {
			console.log(response.data);
			busSC(response.data);
		}, function errorCallback(response) {
			console.log("Erreur : ------" + response.statusText);
		})
	}
	
	//méthode ajouter un contrat
	function addOneContrat(contrat, busSC) {
		
		$http({
			method : "POST",
			url : restUrl + "/contrat",
			//on veut un JSON en sortie de la requête
			data : angular.toJson(contrat),
			//la requête consomme un JSON
			headers : {ContentType : "application/JSON"}
				
		}).then (function successCallback(response) {
			console.log(response.data);
			busSC(response.data);
		}, function errorCallback(response) {
			
		})
	}
	
	// méthode modifier un contrat
	function updateContrat(contrat, busSC) {

		$http({
			method : "PUT",
			url : restUrl + "/contrat",
			//on veut un JSON en sortie de la requête
			data : angular.toJson(contrat),
			//la requête consomme un JSON
			headers : {ContentType : "application/JSON"}

		}).then(function successCallback(response) {
			busSC(response.statusText);

		}, function errorCallback(response) {
			console.log("Erreur : ----" + response.statusText);

		})

	}
	
	// méthode supprimer
	function delOneContrat(id, busSC) {

		$http$http({
			method : "DELETE",
			url : restUrl + "/contrat/" + id

		}).then(function successCallback(response) {
			busSC(response.statusText);

		}, function errorCallback(response) {
			console.log("Erreur : ----" + response.statusText);

		})

	}
	
	return {
		getAllContrat : findAllContrat,
		ajoutOneContrat : addOneContrat,
		modifContrat : updateContrat,
		supOneContrat : delOneContrat
	}
	
});