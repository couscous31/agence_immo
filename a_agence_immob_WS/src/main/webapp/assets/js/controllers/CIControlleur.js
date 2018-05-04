monApp
 
.controller('LoginController',function ($scope, $rootScope, $location, ciService) {

		$scope.ci={
				idUsername : '',
				mdp : ''
		};
        $scope.login = function () {
            $scope.dataLoading = true;
            ciService.Login($scope.username, $scope.password, function(response) {
                if(response.success) {
                    $location.path('/');
                } else {
                    $scope.error = response.message;
                    $scope.dataLoading = false;
                }
            });
        };
    });