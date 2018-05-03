//creer les services du proprietaire pour récupérer les données du ws
monApp.factory("biService", function($http) {
	var restURL = "http://localhost:8080/a_agence_immob_WS";

	// FONCTION LISTE
	function findAll(bus) {
		$http({
			method : "GET",
			url : restURL + "/listeBi"
		}).then(function succesCallBack(response) {
			bus(response.data);
		}, function erreurCallback(response) {

		})

	}
	
	// FONCTION AJOUTER
	function addOne(bienImmobilier, bus) {
		//transformer image récupérer en base 64
		console.log(bienImmobilier.photoBI);
		
		bienImmobilier.photoBI=bienImmobilier.photoBI.base64;
		
		$http.post(restURL + "/BienImmobilier", JSON.stringify(bienImmobilier), {
			ContentType : "application/JSON"
		}).then(function successCallback(response) {
			bus(response.data)
		}, function errorCallback(response) {
		});
	}
	
	// FONCTION MODIFIER
	function updateOne(bienImmobilier, bus) {
		$http.put(restURL + "/BienImmobilier", JSON.stringify(bienImmobilier), {
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
			url : restURL + "/BienImmobilier?pId=" + id
		}).then(function succesCallBack(response) {
			bus(response.data)
		}, function errorCallBack(response) {

		})
	}
	

	// FONCTION DELETE
	function delOne(id, bus) {
		
		$http({
			method : "DELETE",
			url : restURL + "/BienImmobilier/" + id
		}).then(function succesCallBack(response) {
			bus(response.statusText)
		
		}, function errorCallBack(response) {

		})
	}
	
	function getAllBi(buscSC) {
		$http({
			method : "GET",
			url : restUrl + "/classeStandard"
		}).then(function successCallBack(response) {
					busSC(response.data)
				},
				function errorCallBack(response) {
					console.log("Erreur : ------"+ response.statusText);
				})
	}

	function ajoutBi(bi, busSC) {
		$http({
			method : "POST",
			url : restUrl + "/BienImmobilier",
			data : JSON.stringify(bi),
			headers : {
				ContentType : "application/JSON"
			}
		}).then(
				function successCallBack(response) {
					busSC(response.data)
				},
				function errorCallBack(response) {
					console.log("Erreur : ------"
							+ response.statusText);
				})
	}

	function geoAdresse(rue, codePostal, ville, busSC) {
		$http(
				{
					method : "GET",
					url : "https://maps.googleapis.com/maps/api/geocode/json?address="
							+ rue
							+ ","
							+ codePostal
							+ ""
							+ ville
							+ "&key=AIzaSyDy1ZKI7FhtHYJx8VEB0GQyjcUoxc2nwy4"
				}).then(
				function successCallBack(response) {
					busSC(response.data)
				},
				function errorCallBack(response) {
					console.log("Erreur : ------"
							+ response.statusText);
				})

}
	function getByIdProp(id_prop, bus) {
		$http({
			method : "GET",
			url : restURL + "/BienImmobilierprop?pIdprop=" + id_prop
		}).then(function succesCallBack(response) {
			bus(response.data)
		}, function errorCallBack(response) {

		})
	}
	
	return {
		getAll: findAll,
		getOne: getById,
		suppOne: delOne,
		ajoutOne: addOne,
		modifOne : updateOne,
		findAllBi : getAllBi,
		addBi : ajoutBi, 
		localisationBi : geoAdresse, 
		getOneprop:getByIdProp
	}

});


//monApp
//		.factory(
//				"biService",
//				function($http) {
//					var restUrl = "http://localhost:8080/a_agence_immob_WS";
//					function getAllBi(buscSC) {
//						$http({
//							method : "GET",
//							url : restUrl + "/classeStandard"
//						}).then(
//								function successCallBack(response) {
//									busSC(response.data)
//								},
//								function errorCallBack(response) {
//									console.log("Erreur : ------"
//											+ response.statusText);
//								})
//					}
//
//					function ajoutBi(bi, busSC) {
//						$http({
//							method : "POST",
//							url : restUrl + "/BienImmobilier",
//							data : JSON.stringify(bi),
//							headers : {
//								ContentType : "application/JSON"
//							}
//						}).then(
//								function successCallBack(response) {
//									busSC(response.data)
//								},
//								function errorCallBack(response) {
//									console.log("Erreur : ------"
//											+ response.statusText);
//								})
//					}
//
//					function geoAdresse(rue, codePostal, ville, busSC) {
//						$http(
//								{
//									method : "GET",
//									url : "https://maps.googleapis.com/maps/api/geocode/json?address="
//											+ rue
//											+ ","
//											+ codePostal
//											+ ""
//											+ ville
//											+ "&key=AIzaSyDy1ZKI7FhtHYJx8VEB0GQyjcUoxc2nwy4"
//								}).then(
//								function successCallBack(response) {
//									busSC(response.data)
//								},
//								function errorCallBack(response) {
//									console.log("Erreur : ------"
//											+ response.statusText);
//								})
//
//					}
//
//					return {
//
//						findAllBi : getAllBi,
//						addBi : ajoutBi, 
//						localisationBi : geoAdresse 
//					}
//				});