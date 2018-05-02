
monApp.factory("viService", function($http){
	var restURL="http://localhost:8080/a_agence_immob_WS";

	//OK
	function listevi(busvi){
		
		$http({
			method:"GET",
			url:restURL+"/listevi"
		}).then(function sucessCallback (response){
			busvi(response.data)
		},function erreurCallback (response){
			console.log("erreur:--------"+response.statusText)
		})
	}
	
	function getbyIdvi(id, busvi){
		
		$http.get(restUrl+"getvibyid?pId="+id).then(function sucessCallback (response){	
		busvi(response.data)
		},function erreurCallback (response){
			console.log("erreur:-------"+response.statusText)
		})
	};
	
	
	
	function supprimervi(id,busvi){
		$http({
			method: "DELETE",
			url: restUrl+"/supvi/" + id
		}).then(function sucessCallback (response){
			busvi(response.statusText)
		},function erreurCallback (response){
		
		})
	}
	
	function ajoutervi(Visite, busvi){
		$http({
			method:"POST",
			url:restURL+"/addvi",
			data:angular.toJson(Visite),
			headers:{ContentType:"application/JSON"}	
		}).then(function sucessCallback (response){
			busvi(response.statusText)
		},function erreurCallback (response){
	})
}
	function modifiervi(Visite, busvi){
		$http({
			method:"PUT",
			url:restUrl+"/modvi",
			data:angular.toJson(Visite),
			headers:{ContentType:"application/JSON"}
		}).then(function sucessCallback (response){
			busvi(response.statusText)
		},function erreurCallback (response){
	})
	};
	
	return {
		getall:listevi,
		getbyId:getbyIdvi,
		supp:supprimervi,
		ajoutvi:ajoutervi,
		modifvi:modifiervi
	}
	
});

