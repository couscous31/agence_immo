//creer les services du proprietaire pour récupérer les données du ws
monApp.factory('ciService',
	    
	    function ($http) {
//	        var service = {};
//
//	        service.Login = function (username, password, callback) {
//
//	            /* Dummy authentication for testing, uses $timeout to simulate api call
//	             ----------------------------------------------*/
////	            $timeout(function(){
////	                var response = { success: username === 'test' && password === 'test' };
////	                if(!response.success) {
////	                    response.message = 'Username or password is incorrect';
////	                }
////	                callback(response);
////	            }, 1000);
//
//
//	            /* Use this for real authentication
//	             ----------------------------------------------*/
//	            $http.get('http://localhost:8080/a_agence_immob_WS/listeLogin?pidUsername='+idUsername, '&pMdp='+mdp)
//	                .success(function (response) {
//	                    callback(response);
//	                });
//
//	        };
	
	var restURL = "http://localhost:8080/a_agence_immob_WS";

	function loginService(idUsername, mdp, bus) {
			$http({
				method : "GET",
				url : restURL + "/listeLogin?pidUsername=" + idUsername + "&pMdp=" + mdp
			}).then(function succesCallBack(response) {
				bus(response.data)
			}, function errorCallBack(response) {

			})
		}
	function listevi(bus) {

		$http({
			method : "GET",
			url : restURL + "/listevi"
		}).then(function sucessCallback(response) {
			bus(response.data)
		}, function erreurCallback(response) {
			console.log("erreur:--------" + response.statusText)
		})
	}
	 
	        return {
	        	connService : loginService,
	        	getall : listevi
	        	};
	    });