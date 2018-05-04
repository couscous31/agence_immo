//creer les services du proprietaire pour récupérer les données du ws
monApp.factory('ciService',
	    
	    function ($http) {
	        var service = {};

	        service.Login = function (username, password, callback) {

	            /* Dummy authentication for testing, uses $timeout to simulate api call
	             ----------------------------------------------*/
//	            $timeout(function(){
//	                var response = { success: username === 'test' && password === 'test' };
//	                if(!response.success) {
//	                    response.message = 'Username or password is incorrect';
//	                }
//	                callback(response);
//	            }, 1000);


	            /* Use this for real authentication
	             ----------------------------------------------*/
	            $http.get('http://localhost:8080/a_agence_immob_WS/listeLogin?pidUsername='+idUsername, '&pMdp='+mdp)
	                .success(function (response) {
	                    callback(response);
	                });

	        };
	 
	        return service;
	    });