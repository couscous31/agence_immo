monApp.factory("biService", function($http){
	var restUrl = "http://localhost:8080/a_agence_immob_WS";
	function getAllBi(buscSC){
		$http({
			method : "GET",
			url : restUrl + "/classeStandard"
		}).then(function successCallBack(response){
			busSC(response.data)
		}, function errorCallBack(response) {
			console.log("Erreur : ------" + response.statusText);
		})
	}
});