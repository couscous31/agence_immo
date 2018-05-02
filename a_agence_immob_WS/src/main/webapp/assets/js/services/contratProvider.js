// Création du service pour récup les données du WS

monApp.factory("contratService", function($http){
	
	//méthode afficher la liste
	function findAllContrat(busSC) {
		
		$http({
			method : "GET"
				
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
			//on veut un JSON en sortie de la requête
			data : angular.toJson(etudiant),
			//la requête consomme un JSON
			headers : {ContentType : "application/JSON"}
				
		}).then (function successCallback(response) {
			console.log(response.data);
			busSC(response.data);
		}, function errorCallback(response) {
			console.log("Erreur : ------" + response.statusText);
		})
	}
	
	// méthode modifier un contrat
	function updateContrat(contrat, busSC) {

		$http({
			method : "PUT",
			//on veut un JSON en sortie de la requête
			data : angular.toJson(etudiant),
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
			method : "DELETE"

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