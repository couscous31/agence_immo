/**
 * 
 */

monApp.factory("viService", function($http){

	function liste(busvi){
		
		$http({
			method:"GET",
			url:restUrl+"/listevi"
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
	
})

