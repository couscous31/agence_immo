monApp
		.factory(
				"biService",
				function($http) {
					var restUrl = "http://localhost:8080/a_agence_immob_WS";
					function getAllBi(buscSC) {
						$http({
							method : "GET",
							url : restUrl + "/classeStandard"
						}).then(
								function successCallBack(response) {
									busSC(response.data)
								},
								function errorCallBack(response) {
									console.log("Erreur : ------"
											+ response.statusText);
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

					return {

						findAllBi : getAllBi,
						addBi : ajoutBi, 
						localisationBi : geoAdresse 
					}
				});