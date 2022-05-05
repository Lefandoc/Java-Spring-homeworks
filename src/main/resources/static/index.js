angular.module('app', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:9082/app';

    $scope.loadProducts = function () {
        $http.get(contextPath + '/products/all')
            .then(function (response) {
                $scope.productList = response.data;
            });
    };

    $scope.changeCount = function (productId, delta){
        $http({
            url: contextPath + '/products/change_count',
            method: 'GET',
            params: {
                productId: productId,
                delta: delta
            }
        }).then(function (response){
            $scope.loadProducts();
        });
    };

    $scope.delete = function (productId){
        $http({
            url: contextPath + '/products/delete',
            method: 'GET',
            params: {
                productId: productId
            }
        }).then(function (response){
            $scope.loadProducts();
        });
    };

    $scope.fill = function (){
        $http({
            url: contextPath + '/products/fill_products',
            method: 'GET'
        }).then(function (response){
            $scope.loadProducts();
        });
    };

    $scope.loadProducts();

});