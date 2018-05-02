//creer les services du proprietaire pour récupérer les données du ws
monApp.factory("propService", function($http) {
	var restURL = "http://localhost:8080/a_agence_immob_WS";

	// FONCTION LISTE
	function findAll(bus) {
		$http({
			method : "GET",
			url : restURL + "/listeProp"
		}).then(function succesCallBack(response) {
			bus(response.data);
		}, function erreurCallback(response) {

		})

	}

	// FONCTION AJOUTER
	function addOne(proprietaire, bus) {
		$http.post(restURL + "/proprietaire", JSON.stringify(proprietaire), {
			ContentType : "application/JSON"
		}).then(function successCallback(response) {
			bus(response.data)
		}, function errorCallback(response) {
		});
	}

	// FONCTION MODIFIER
	function updateOne(proprietaire, bus) {
		$http.put(restURL + "/proprietaire", JSON.stringify(proprietaire), {
			ContentType : "application/JSON"
		}).then(function successCallback(response) {
			bus(response.data)
		}, function errorCallback(response) {
		});
	}

	// FONCTION GETBYID
	function getById(id, bus) {
		$http({
			method : "GET",
			url : restURL + "/proprietaire?pId=" + id
		}).then(function succesCallBack(response) {
			bus(response.data)
		}, function errorCallBack(response) {

		})
	}

	// FONCTION DELETE
	function delOne(id, bus) {
		$http({
			method : "DELETE",
			url : restURL + "/proprietaire/" + id
		}).then(function succesCallBack(response) {
			bus(response.statusText)
		}, function errorCallBack(response) {

		})
	}
	
	return {
		getAll: findAll,
		getOne: getById,
		suppOne: delOne,
		ajoutOne: addOne,
		modifOne : updateOne
	}

});