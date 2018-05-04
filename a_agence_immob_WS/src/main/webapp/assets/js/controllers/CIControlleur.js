monApp


 
.controller('LoginController',function ($scope, $rootScope, $location, ciService) {

		$scope.ci={
				idUsername : '',
				mdp : ''
		};
        $scope.login = function () {
            $scope.dataLoading = true;
            ciService.connService($scope.username, $scope.password, function(response) {
                if(response.success) {
                    $location.path("listevi");
                } else {
                    $scope.error = response.message;
                    $scope.dataLoading = false;
                }
            });
        };
    })
    
    .controller("listeviCtrl", function($scope, ciService, $location, $rootScope) {
	// fonction recuperer la liste des proprietaire
	ciService.getall(function(callBack) {
		$scope.listevi = callBack;
	});
});