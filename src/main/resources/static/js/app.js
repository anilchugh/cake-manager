var app = angular.module('app',[]);

app.controller('CakeCRUDCtrl', ['$scope','CakeCRUDService', function ($scope,CakeCRUDService) {
	  
    $scope.addCake = function () {
        if ($scope.cake != null && $scope.cake.title) {
            CakeCRUDService.addCake($scope.cake.title, $scope.cake.description, $scope.cake.image)
              .then (function success(response){
                  $scope.message = 'Cake added!';
                  $scope.errorMessage = '';
              },
              function error(response){
                  $scope.errorMessage = 'Error adding cake!';
                  $scope.message = '';
            });
        }
        else {
            $scope.errorMessage = 'Please enter a title!';
            $scope.message = '';
        }
    }
    
    $scope.getAllCakes = function () {
        CakeCRUDService.getAllCakes()
          .then(function success(response){
              $scope.cakes = response.data._embedded.cakes;
              $scope.message='';
              $scope.errorMessage = '';
          },
          function error (response ){
              $scope.message='';
              $scope.errorMessage = 'Error getting cakes!';
          });
    }

}]);

app.service('CakeCRUDService',['$http', function ($http) {
	
    this.addCake = function addCake(title, description, image){
        return $http({
          method: 'POST',
          url: 'cakes',
          data: {title:title, description:description, image:image}
        });
    }
	
    this.getAllCakes = function getAllCakes(){
        return $http({
          method: 'GET',
          url: '/cakes'
        });
    }
    

}]);