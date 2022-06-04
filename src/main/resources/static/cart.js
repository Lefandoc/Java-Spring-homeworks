angular.module('cart', []).controller('cartController', function ($scope, $http) {
    const contextPath = 'http://localhost:9082/app/api/v1/cart';

    $scope.loadProducts = function () {
        $http.get(contextPath + '/items')
            .then(function (response) {
                $scope.productList = response.data;
            });
    };

    // $scope.loadProducts = function (userId) {
    //     $http({
    //         url: contextPath + '/cart/items',
    //         method: 'GET',
    //         params: {
    //             userId: userId
    //         }
    //     }).then(function (response) {
    //         $scope.productList = response.data;
    //     });
    // };

    $scope.changeCount = function (productId, delta){
        $http({
            url: contextPath + '/change_count',
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
            url: contextPath + '/delete',
            method: 'GET',
            params: {
                productId: productId
            }
        }).then(function (response){
            $scope.loadProducts();
        });
    };

    $scope.loadProducts();

});