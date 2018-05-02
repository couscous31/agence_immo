monApp.factory("biService", function($http){
	var restUrl = "http://localhost:8080/a_agence_immob_WS";
	function getAll(busSC){
		$http({
			method : "GET",
			url : restUrl + "/classeStandard"
		}).then(function successCallBack(response){
			busSC(response.data)
		}, function errorCallBack(response) {
			console.log("Erreur : ------" + response.statusText);
		})
	}
	
	function getAllSurface(busSC){
		$http({
			method : "GET",
			url : restUrl + "/classeStandardSurface"
		}).then(function successCallBack(response){
			busSC(response.data)
		}, function errorCallBack(response) {
			console.log("Erreur : ------" + response.statusText);
		})
	}
	
	function getAllPrix(busSC){
		$http({
			method : "GET",
			url : restUrl + "/classeStandardPrix"
		}).then(function successCallBack(response){
			busSC(response.data)
		}, function errorCallBack(response) {
			console.log("Erreur : ------" + response.statusText);
		})
	}
	
	return {
		getAllBi : getAll,
		getAllSMin : getAllSurface,
		getAllPMax : getAllPrix
	}
});