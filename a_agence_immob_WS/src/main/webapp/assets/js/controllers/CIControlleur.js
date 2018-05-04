monApp

.controller('LoginController',
	    ['$scope', '$rootScope', '$location', 'ciService',
	    function ($scope, $rootScope, $location, ciService) {
	        // reset login status
	        ciService.ClearCredentials();
	 
	        $scope.login = function () {
	            $scope.dataLoading = true;
	            ciService.Login($scope.idUsername, $scope.mdp, function(response) {
	                if(typeof response == "object") {
	                    AuthenticationService.SetCredentials($scope.idUsername, $scope.mdp);
	                    $location.path('listevi');
	                } else {
	                    $scope.error = response.message;
	                    $scope.dataLoading = false;
	                }
	            });
	        };
	    }]);
   